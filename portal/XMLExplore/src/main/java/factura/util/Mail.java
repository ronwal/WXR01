package factura.util;

import ec.ste.factura.ConfigurationManager;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mail implements Runnable {

    public static SimpleDateFormat dateFormat;
    public static SimpleDateFormat timeFormat;
    private static Properties properties;
    String titulo;
    String plantilla;
    String detalle;
    String destinatario;
    List<Destinatario> destinatarios;
    String adjunto;
    private Thread thread;
    private List<Attach> attaches;
    private String emisor;
    private String fecha;
    private String documento;
    private String datosEmpresa;
    private String ruc;
    private String emailEmpr;

    public static synchronized Properties getProperties() {
        return Mail.properties;
    }

    public void setEmailEmpr(String emailEmpr) {
        this.emailEmpr = emailEmpr;
    }

    public String getEmailEmpr() {
        return this.emailEmpr;
    }

    public void enviar(final String titulo, final String plantilla, String emisor, final String destinatario, String fecha, String documento, String datosEmpresa, final String detalle, final List<Destinatario> destinatarios, final String adjunto, final List<Attach> attaches, String ruc) {
        this.titulo = titulo;
        this.plantilla = plantilla;
        this.emisor = emisor;
        this.detalle = detalle;
        this.destinatario = destinatario;
        this.fecha = fecha;
        this.documento = documento;
        this.datosEmpresa = datosEmpresa;
        this.destinatarios = destinatarios;
        this.adjunto = adjunto;
        this.attaches = attaches;
        this.ruc = ruc;
        (this.thread = new Thread(this)).start();
    }

    @Override
    public void run() {
        try {

            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            final InputStream input = Mail.class.getResourceAsStream("/" + this.plantilla);
            final byte[] buffer = new byte[2048];
            int read = 0;
            while ((read = input.read(buffer)) > 0) {
                output.write(buffer, 0, read);
            }
            output.flush();
            input.close();
            String html = output.toString("utf-8");
            final Properties props = System.getProperties();
            Session session;
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            (props).put("mail.smtp.host", Mail.properties.getProperty("ec.ste.factura.mail.server"));
            (props).put("mail.smtp.auth", Mail.properties.getProperty("ec.ste.factura.mail.smtp.auth"));
            (props).put("mail.smtp.port", Mail.properties.getProperty("ec.ste.factura.mail.smtp.port"));
//            (props).put("mail.pop3.socketFactory.class", SSL_FACTORY);
//            (props).setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//            (props).setProperty("mail.smtp.socketFactory.port",Mail.properties.getProperty("ec.ste.factura.mail.smtp.port"));
            (props).put("mail.smtp.startssl.enable", Mail.properties.getProperty("ec.ste.factura.mail.smtp.starttls.enable"));
            boolean starttls = Boolean.parseBoolean(Mail.properties.getProperty("ec.ste.factura.mail.smtp.starttls.enable"));
            if (starttls) {
                props.put("mail.smtp.socketFactory.port", Mail.properties.getProperty("ec.ste.factura.mail.smtp.port"));

                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.socketFactory.fallback", "false");
                final Authenticator auth = new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Mail.properties.getProperty("ec.ste.factura.mail.account"), Mail.properties.getProperty("ec.ste.factura.mail.password"));
                    }
                };
                session = Session.getDefaultInstance(props, auth);
            } else {
                session = Session.getDefaultInstance(props);
            }

            final MimeMessage msg = new MimeMessage(session);
            msg.setFrom((Address) new InternetAddress(Mail.properties.getProperty("ec.ste.factura.mail.account")));
            msg.setSubject(this.titulo);
            final MimeBodyPart body = new MimeBodyPart();
            while (html.contains("${logo}")) {
                html = html.replace("${logo}", "<img src='cid:" + ruc + "' />");
            }
            while (html.contains("${logoFactura}")) {
                html = html.replace("${logoFactura}", "<img src='cid:" + adjunto + "' width='128px'/>");
            }
            while (html.contains("${fechaActual}")) {
                html = html.replace("${fechaActual}", dateFormat.format(new Date()));
            }
            while (html.contains("${hora}")) {
                html = html.replace("${hora}", timeFormat.format(new Date()));
            }
            while (html.contains("${fecha}")) {
                html = html.replace("${fecha}", fecha);
            }

            while (html.contains("${emisor}")) {
                html = html.replace("${emisor}", this.emisor);
            }
            while (html.contains("${documento}")) {
                html = html.replace("${documento}", this.documento);
            }
            while (html.contains("${datosEmpresa}")) {
                html = html.replace("${datosEmpresa}", this.datosEmpresa);
            }

            while (html.contains("${detalle}")) {
                html = html.replace("${detalle}", this.detalle);
            }
            while (html.contains("${destinatario}")) {
                html = html.replace("${destinatario}", this.destinatario);
            }

            final Multipart multipart = (Multipart) new MimeMultipart();
            MimeBodyPart attachMent = new MimeBodyPart();
            attachMent.setDataHandler(new DataHandler(Mail.class.getResource("/" + this.adjunto + ".png")));
            attachMent.setHeader("Content-ID", "<" + this.adjunto + ">");
            multipart.addBodyPart((BodyPart) attachMent);

            String path = ConfigurationManager.getInstance().getLogosPath();
            if (!path.endsWith("/")) {
                path += "/";
            }

            path += ruc + ".png";

            File file = new File(path);
            if (file.exists()) {
                attachMent = new MimeBodyPart();
                attachMent.setDataHandler(new DataHandler(new FileDataSource(file)));
                attachMent.setHeader("Content-ID", "<" + ruc + ">");
                multipart.addBodyPart((BodyPart) attachMent);
            } else {
                path = ConfigurationManager.getInstance().getStorePath();
                if (!path.endsWith("/")) {
                    path += "/";
                }
                path += "no-logo.png";

                file = new File(path);
                if (file.exists()) {
                    attachMent = new MimeBodyPart();
                    attachMent.setDataHandler(new DataHandler(new FileDataSource(file)));
                    attachMent.setHeader("Content-ID", "<" + ruc + ">");
                    multipart.addBodyPart((BodyPart) attachMent);
                }
            }

            multipart.addBodyPart((BodyPart) body);

            for (final Attach attach : attaches) {
                attachMent = new MimeBodyPart();
                attachMent.setDataHandler(new DataHandler(new DataSource() {

                    @Override
                    public InputStream getInputStream() throws IOException {
                        return new ByteArrayInputStream(attach.getContent());
                    }

                    @Override
                    public OutputStream getOutputStream() throws IOException {
                        return null;
                    }

                    @Override
                    public String getContentType() {
                        return attach.getMime();
                    }

                    @Override
                    public String getName() {
                        return attach.getName();
                    }
                }));
                attachMent.setFileName(attach.getName());
                attachMent.setDisposition("attachment");
                multipart.addBodyPart((BodyPart) attachMent);
            }

            msg.setContent(multipart);
            for (final Destinatario d : this.destinatarios) {
                String prepared;
                for (prepared = html; prepared.contains("${destinatario}"); prepared = prepared.replace("${destinatario}", d.getNombre())) {
                }
                body.setText(prepared, "utf-8", "html");
                msg.setRecipient(Message.RecipientType.TO, (Address) new InternetAddress(d.getMail()));
                if (getEmailEmpr()!=null && CommonClass.emailRgexvalidate(getEmailEmpr().trim())) {
                    String delims = ";";
			String[] emails = getEmailEmpr().split(delims);
			if (emails.length == 1) {
				delims = ",";
				emails = getEmailEmpr().split(delims);
			}

			InternetAddress[] addressTo = new InternetAddress[emails.length];
			for (int i = 0; i < emails.length; i++) {
				addressTo[i] = new InternetAddress(emails[i]);
			}
                    msg.setRecipients(Message.RecipientType.CC, addressTo);
                   msg.addHeader("Disposition-Notification-To",emails[0]);
                }
                Transport.send((Message) msg);
//                Transport transport = session.getTransport("smtp");
//			transport.connect(props.getProperty("mail.smtp.host"),
//					Integer.parseInt(props.getProperty("mail.smtp.port")),
//					Mail.properties.getProperty("ec.ste.factura.mail.account"), 
//                Mail.properties.getProperty("ec.ste.factura.mail.password"));
//			transport.sendMessage(msg, msg.getAllRecipients());
//			transport.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.thread.interrupt();
        this.thread = null;
    }

    static {
        Mail.dateFormat = new SimpleDateFormat("EEEEEE, dd MMMMMM 'de' yyyy");
        Mail.timeFormat = new SimpleDateFormat("HH:mm");
        Mail.properties = new Properties();
        try {
            Mail.properties.loadFromXML(Mail.class.getResourceAsStream("/config.xml"));
        } catch (Exception ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
