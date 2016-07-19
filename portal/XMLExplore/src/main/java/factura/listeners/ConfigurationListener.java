/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.listeners;

import ec.ste.factura.ConfigurationManager;
import ec.ste.factura.ConfigurationReader;
import ec.ste.factura.Constantes;
import ec.ste.factura.dao.PerfilDao;
import ec.ste.factura.dao.TipoDao;
import ec.ste.factura.dao.UsuarioDao;
import ec.ste.factura.entities.Perfil;
import ec.ste.factura.entities.Tipo;
import ec.ste.factura.entities.Usuario;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.net.URL;

/**
 * Web application lifecycle listener.
 *
 * @author German17
 */
@WebListener()
public class ConfigurationListener implements ServletContextListener {

    private final static Logger log = Logger.getLogger(ConfigurationListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        URL url = ConfigurationListener.class.getResource("/log4j.xml");
        String defaultPath = url.getFile();
        DOMConfigurator.configure(url);
        log.debug("Archivo de configuracion para log4j utilizado: " + url.getFile());
        url = ConfigurationListener.class.getResource("/" + ConfigurationReader.CONFIGURATION_FILE);
        ConfigurationManager cfg = ConfigurationManager.getInstance();
        try {
            log.info("Verificando archivo de configuracion");

            String path;
            if (url == null) {
                path = defaultPath.substring(0, defaultPath.indexOf("log4j.xml")) + ConfigurationReader.CONFIGURATION_FILE;
            } else {
                path = url.getFile();
            }
            File file = new File(path);
            if (!file.exists() | file.length() == 0) {
                log.info("Archivo de configuracion no encontrado, se procede a crear uno nuevo");
                file.createNewFile();
                cfg.setDefaultValues();
                cfg.saveValues();
            }
            cfg.loadValuesFromConfigurationFile();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }


        PerfilDao perfilDao = new PerfilDao();

        if (cfg.isPreloadData()) {
            log.info("La precarga de datos se encuentra activada, se procede a precargar los datos");

            try {
                Perfil p = new Perfil(Constantes.PRF_ADMINISTRADOR_EMPRESA, "Administrador de Empresa");
                if (perfilDao.findPerfilByPrimaryKey(p.getPrfCodigo()) == null) {
                    perfilDao.insert(p);
                } else {
                    perfilDao.update(p);
                }
                p = new Perfil(Constantes.PRF_CONSULTOR_INTERNO, "CONSULTOR INTERNO");
                if (perfilDao.findPerfilByPrimaryKey(p.getPrfCodigo()) == null) {
                    perfilDao.insert(p);
                } else {
                    perfilDao.update(p);
                }
                
                p = new Perfil(Constantes.PRF_CARGA_DATOS_EMPRESA, "CARGADOR DE DATOS");
                if (perfilDao.findPerfilByPrimaryKey(p.getPrfCodigo()) == null) {
                    perfilDao.insert(p);
                } else {
                    perfilDao.update(p);
                }
                p = new Perfil(Constantes.PRF_CLIENTE_PROVEEDOR, "CLIENTE/PROVEEDOR");
                if (perfilDao.findPerfilByPrimaryKey(p.getPrfCodigo()) == null) {
                    perfilDao.insert(p);
                } else {
                    perfilDao.update(p);
                }
                
                p = new Perfil(Constantes.PRF_ADMINISTRADOR, "ADMINISTRADOR");
                if (perfilDao.findPerfilByPrimaryKey(p.getPrfCodigo()) == null) {
                    perfilDao.insert(p);
                } else {
                    perfilDao.update(p);
                }
                
                p = new Perfil(Constantes.PRF_GERENCIA_EMPRESA, "GERENTE");
                if (perfilDao.findPerfilByPrimaryKey(p.getPrfCodigo()) == null) {
                    perfilDao.insert(p);
                } else {
                    perfilDao.update(p);
                }

                TipoDao tipoDao = new TipoDao();

                Tipo tipo = new Tipo("ENV", "ENVIADO");
                if (tipoDao.findTipoByPrimaryKey(tipo.getTipCodigo()) == null) {
                    tipoDao.insert(tipo);
                } else {
                    tipoDao.update(tipo);
                }
                tipo = new Tipo("REC", "RECIBIDO");
                if (tipoDao.findTipoByPrimaryKey(tipo.getTipCodigo()) == null) {
                    tipoDao.insert(tipo);
                } else {
                    tipoDao.update(tipo);
                }


            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
            }
        }


        if (cfg.isRootVerify()) {


            UsuarioDao usuarioDao = new UsuarioDao();

            try {
                log.info("Verificando perfil de SUPER ADMINISTRADOR");
                Perfil perfil = perfilDao.findPerfilByPrimaryKey("SPR");
                if (perfil == null) {
                    perfil = new Perfil("SPR", "SUPER ADMINISTRADOR");
                    perfilDao.insert(perfil);
                } else if (!perfil.getPrfNombre().equals("SUPER ADMINISTRADOR")) {
                    perfil.setPrfNombre("SUPER ADMINISTRADOR");
                    perfilDao.update(perfil);
                }



                log.info("Verificando usuario " + cfg.getRootUserName() + " como SUPER ADMINISTRADOR");
                Usuario usuario = usuarioDao.findUsuarioByNick(cfg.getRootNick(),null);
                if (usuario == null) {
                    usuario = new Usuario();
                    usuario.setPerfil(perfil);
                    usuario.setUsuActivo(true);
                    usuario.setUsuClave(cfg.getRootUserPassword());
                    usuario.setUsuIdentificacion(cfg.getRootUserIdentification());
                    usuario.setUsuMail(cfg.getRootMail());
                    usuario.setUsuNick(cfg.getRootNick());
                    usuario.setUsuNombre(cfg.getRootUserName());
                    usuarioDao.insert(usuario);
                } else {
                    usuario.setPerfil(perfil);
                    usuario.setUsuActivo(true);
                    usuario.setUsuClave(cfg.getRootUserPassword());
                    usuario.setUsuIdentificacion(cfg.getRootUserIdentification());
                    usuario.setUsuMail(cfg.getRootMail());
                    usuario.setUsuNick(cfg.getRootNick());
                    usuario.setUsuNombre(cfg.getRootUserName());
                    usuarioDao.update(usuario);
                }
                log.info("Verificacon de super usuario completada");
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
            }
        }

        log.info("Configuracion de arranque completada");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.gc();
    }
}
