/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import ec.ste.factura.beans.Login;
import ec.ste.factura.entities.*;
import ec.ste.factura.util.DataFormatUtil;
import ec.ste.factura.util.FacesUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author German17
 */
public class HibernateUtil {

    private final static Logger log = Logger.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    /**
     * Extrae un Map<String, Object>, como key los atributos de la clase, y como
     * value el valor que contiene dicho atributo
     *
     * @param o
     * @return
     * @throws Exception
     */
    public static Map reflectToMap(Object o) throws Exception {
        Class clazz = o.getClass();
        Field fields[] = clazz.getDeclaredFields();
        Map<String, Object> map = new HashMap<String, Object>();
        String name;
        Object value;
        Method getter;
        for (Field f : fields) {
            name = f.getName();
            if (f.getType().getSimpleName().equalsIgnoreCase("boolean")) {
                getter = clazz.getDeclaredMethod("is" + Character.toUpperCase(name.charAt(0)) + name.substring(1, name.length()), new Class[]{});
            } else {
                getter = clazz.getDeclaredMethod("get" + Character.toUpperCase(name.charAt(0)) + name.substring(1, name.length()), new Class[]{});
            }
            value = getter.invoke(o);
            map.put(name, value);
        }

        return map;
    }

    /**
     * Transforma un Map<String, Object>, que representa a una clase, a un texto
     * patron: [atr1][atr2][atr3] con un texto de contenido [val1][val2][val3]
     * para el caso de que un atributo sea una clase entidad, se establece el
     * texto y el valor de la siguiente forma:
     * [perfil][usuExterno][usuCodigo][usuActivado][usuClave][usuNombre]
     * [{[prfCodigo][prfNombre]}{[SPR][SUPER
     * ADMINISTRADOR]}][false][1719853432][true][bGAuoAZVTqUQWaBNGrhswFRtZiFyQyix][Germán
     * Morocho]
     *
     * @param map
     * @param limit
     * @return
     */
    public static AuditText mapToAuditText(Map map, int limit) {
        AuditText audit = new AuditText();
        Set<String> keys = map.keySet();

        String pattern = "";
        String text = "";
        String current;
        String currentPattern;
        for (String key : keys) {
            currentPattern = "[" + key + "]";
            if ((pattern.length() + currentPattern.length()) > limit) {
                audit.addPattern(pattern);
                pattern = currentPattern;
            } else {
                pattern += currentPattern;
            }

            Object attributeValue = map.get(key);

            if (attributeValue == null) {
                current = "[null]";
            } else {
                if (attributeValue instanceof String) {
                    current = "[" + attributeValue + "]";
                } else if (attributeValue instanceof Integer) {
                    current = "[" + attributeValue + "]";
                } else if (attributeValue instanceof Number) {
                    current = "[" + DataFormatUtil.getDecimalFormat(((Number) attributeValue).doubleValue()) + "]";
                } else if (attributeValue instanceof Date) {
                    current = "[" + DataFormatUtil.getDateFormat((Date) attributeValue) + "]";
                } else if (attributeValue instanceof DatabaseEntity) {
                    EntityInfo info = InfoManager.findInfo(attributeValue);
                    if (info != null) {
                        String attributeName = info.getFilterAttributeName();
                        if (attributeName != null) {
                            try {
                                Field field = attributeValue.getClass().getDeclaredField(attributeName);
                                field.setAccessible(true);
                                Object descr = field.get(attributeValue);
                                current = "[" + descr + "]";
                            } catch (IllegalAccessException ex) {
                                log.info("Error al intentar obtener texto para auditoria: " + attributeValue.getClass().getSimpleName(), ex);
                                current = "[nr-err]";
                            } catch (IllegalArgumentException ex) {
                                log.info("Error al intentar obtener texto para auditoria: " + attributeValue.getClass().getSimpleName(), ex);
                                current = "[nr-err]";
                            } catch (NoSuchFieldException ex) {
                                log.info("Error al intentar obtener texto para auditoria: " + attributeValue.getClass().getSimpleName(), ex);
                                current = "[nr-err]";
                            } catch (SecurityException ex) {
                                log.info("Error al intentar obtener texto para auditoria: " + attributeValue.getClass().getSimpleName(), ex);
                                current = "[nr-err]";
                            }
                        } else {
                            current = "[nr-atr]";
                        }
                    } else {
                        current = "[nr-inf]";
                    }
                } else {
                    current = "[" + attributeValue.toString() + "]";
                }
            }

            while (current.length() > limit) {
                String buffer = current.substring(0, limit);
                audit.addText(buffer);
                current = current.substring(limit + 1, current.length());
            }
            if ((text.length() + current.length()) > limit) {
                audit.addText(text);
                text = "";
            }
            text += current;
        }
        if (pattern.length() > 0) {
            audit.addPattern(pattern);
        }
        if (text.length() > 0) {
            audit.addText(text);
        }

        return audit;
    }

    public static void auditInsert(Session s, Object o) throws Exception {
        checkUpperCaseEntity(o);
        if (o instanceof Auditoria) {
            return;
        }
        if (o instanceof DetalleAuditoria) {
            return;
        }

        Login login = null;
        Auditoria aud = null;
        try {
            login = FacesUtil.findBean("login");
            if (login == null) {
                System.out.println("Login no recuperado para auditoria");
                return;
            }
            aud = login.getController().getAuditoria();
            if (aud == null) {
                System.out.println("Auditoria no recuperado para detalle auditoria");
                return;
            }
        } catch (Exception e) {
        }

        DetalleAuditoria da = new DetalleAuditoria();
        da.setAuditoria(aud);
        da.setDauAccion("INS");
        da.setDauFecha(new Date());
        da.setDauTipoDocumento(o.getClass().getSimpleName());
        da.setDauCodigoDocumento(0);
        da.setDauDetalle("");
        if (o instanceof Empresa) {
            Empresa e = (Empresa) o;
            String str = e.getEmpCodigo() + "/" + e.getEmpRazonSocial() + "/" + e.getEmpTelefono() + "/" + e.getEmpMail();
            if (str.length() > 250) {
                str = str.substring(0, 250);
            }
            da.setDauDetalle(str);
        } else if (o instanceof Factura) {
            Factura e = (Factura) o;
            String str = e.getFacIdentificacionVendedor() + "/" + e.getFacRazonSocialVendedor() + "/" + e.getFacIdentificacionComprador() + "/" + e.getFacRazonSocialComprador() + "/" + e.getFacEstablecimiento() + "-" + e.getFacPuntoEmision() + "-" + e.getFacSecuencial() + "/" + e.getFacTotalSinImpuestos();
            if (str.length() > 250) {
                str = str.substring(0, 250);
            }
            da.setDauDetalle(str);
        } else if (o instanceof Usuario) {
            Usuario e = (Usuario) o;
            String str = e.getUsuIdentificacion() + "/" + e.getUsuNombre() + "/" + e.getUsuNick() + "/" + e.getUsuMail();
            if (str.length() > 250) {
                str = str.substring(0, 250);
            }
            da.setDauDetalle(str);
        }
        s.save(da);
    }

    public static void auditUpdate(Session s, Object o) throws Exception {
        checkUpperCaseEntity(o);
        if (o instanceof Auditoria) {
            return;
        }
        if (o instanceof DetalleAuditoria) {
            return;
        }

        Login login = null;
        Auditoria aud = null;
        try {
            login = FacesUtil.findBean("login");
            if (login == null) {
                System.out.println("Login no recuperado para auditoria");
                return;
            }
            aud = login.getController().getAuditoria();
            if (aud == null) {
                System.out.println("Auditoria no recuperado para detalle auditoria");
                return;
            }
        } catch (Exception e) {
        }
        DetalleAuditoria da = new DetalleAuditoria();
        da.setAuditoria(aud);
        da.setDauAccion("UPD");
        da.setDauFecha(new Date());
        da.setDauTipoDocumento(o.getClass().getSimpleName());
        da.setDauCodigoDocumento(0);
        da.setDauDetalle("");
        if (o instanceof Empresa) {
            Empresa e = (Empresa) o;
            String str = e.getEmpCodigo() + "/" + e.getEmpRazonSocial() + "/" + e.getEmpTelefono() + "/" + e.getEmpMail();
            if (str.length() > 250) {
                str = str.substring(0, 250);
            }

            da.setDauDetalle(str);
        } else if (o instanceof Factura) {
            Factura e = (Factura) o;
            String str = e.getFacIdentificacionVendedor() + "/" + e.getFacRazonSocialVendedor() + "/" + e.getFacIdentificacionComprador() + "/" + e.getFacRazonSocialComprador() + "/" + e.getFacEstablecimiento() + "-" + e.getFacPuntoEmision() + "-" + e.getFacSecuencial() + "/" + e.getFacTotalSinImpuestos();
            if (str.length() > 250) {
                str = str.substring(0, 250);
            }
            da.setDauCodigoDocumento(e.getFacCodigo());
            da.setDauDetalle(str);
        } else if (o instanceof Usuario) {
            Usuario e = (Usuario) o;
            String str = e.getUsuIdentificacion() + "/" + e.getUsuNombre() + "/" + e.getUsuNick() + "/" + e.getUsuMail();
            if (str.length() > 250) {
                str = str.substring(0, 250);
            }
            da.setDauCodigoDocumento(e.getUsuCodigo());
            da.setDauDetalle(str);
        }
        s.save(da);
    }

    public static void auditDelete(Session s, Object o) throws Exception {
        if (o instanceof Auditoria) {
            return;
        }
        if (o instanceof DetalleAuditoria) {
            return;
        }

        Login login = null;
        Auditoria aud = null;
        try {
            login = FacesUtil.findBean("login");
            if (login == null) {
                System.out.println("Login no recuperado para auditoria");
                return;
            }
            aud = login.getController().getAuditoria();
            if (aud == null) {
                System.out.println("Auditoria no recuperado para detalle auditoria");
                return;
            }
        } catch (Exception e) {
        }
        DetalleAuditoria da = new DetalleAuditoria();
        da.setAuditoria(aud);
        da.setDauAccion("DEL");
        da.setDauFecha(new Date());
        da.setDauTipoDocumento(o.getClass().getSimpleName());
        da.setDauCodigoDocumento(0);
        da.setDauDetalle("");
        if (o instanceof Empresa) {
            Empresa e = (Empresa) o;
            String str = e.getEmpCodigo() + "/" + e.getEmpRazonSocial() + "/" + e.getEmpTelefono() + "/" + e.getEmpMail();
            if (str.length() > 250) {
                str = str.substring(0, 250);
            }
            da.setDauDetalle(str);
        } else if (o instanceof Factura) {
            Factura e = (Factura) o;
            String str = e.getFacIdentificacionVendedor() + "/" + e.getFacRazonSocialVendedor() + "/" + e.getFacIdentificacionComprador() + "/" + e.getFacRazonSocialComprador() + "/" + e.getFacEstablecimiento() + "-" + e.getFacPuntoEmision() + "-" + e.getFacSecuencial() + "/" + e.getFacTotalSinImpuestos();
            if (str.length() > 250) {
                str = str.substring(0, 250);
            }
            da.setDauCodigoDocumento(e.getFacCodigo());
            da.setDauDetalle(str);
        } else if (o instanceof Usuario) {
            Usuario e = (Usuario) o;
            String str = e.getUsuIdentificacion() + "/" + e.getUsuNombre() + "/" + e.getUsuNick() + "/" + e.getUsuMail();
            if (str.length() > 250) {
                str = str.substring(0, 250);
            }
            da.setDauCodigoDocumento(e.getUsuCodigo());
            da.setDauDetalle(str);
        }
        s.save(da);
    }

    public static void checkUpperCaseEntity(Object e) {

        if (e.getClass().equals(Usuario.class)) {
            return;
        }

        Class clazz = e.getClass();
        Field fields[] = clazz.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.getType().equals(String.class) & !f.getName().toLowerCase().contains("mail") & !f.getName().toLowerCase().contains("url")) {
                try {
                    String value = (String) f.get(e);
                    if (value != null) {
                        f.set(e, checkFormat(value));
                    }
                } catch (IllegalAccessException ex) {
                } catch (IllegalArgumentException ex) {
                }
            }
        }
    }

    public static String checkFormat(String value) {
        value = value.toUpperCase().trim();
        value = value.replace("Á", "A");
        value = value.replace("É", "E");
        value = value.replace("Í", "I");
        value = value.replace("Ó", "O");
        value = value.replace("Ú", "U");
        return value;
    }
}
