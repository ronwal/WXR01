package ec.ste.factura.info;

import ec.ste.factura.EntityInfo;
import ec.ste.factura.dao.UsuarioDao;
import ec.ste.factura.entities.Usuario;


public class UsuarioInfo implements EntityInfo {

    public static final String USU_CODIGO = "usuCodigo";
    public static final String EMPRESA = "empresa";
    public static final String PERFIL = "perfil";
    public static final String USU_IDENTIFICACION = "usuIdentificacion";
    public static final String USU_NOMBRE = "usuNombre";
    public static final String USU_MAIL = "usuMail";
    public static final String USU_NICK = "usuNick";
    public static final String USU_CLAVE = "usuClave";
    public static final String USU_ACTIVO = "usuActivo";

    public static final String PK_FINDER_METHOD="findUsuarioByPrimaryKey";

    @Override
    public String getPkAttributeName(){
        return "usuCodigo";
    }


    @Override
    public String getPkFinderMethod(){
        return "findUsuarioByPrimaryKey";
    }

    @Override
    public String getFilterAttributeName(){
        return "usuNombre";
    }

    @Override
    public String getFilterMethod(){
        return "filterByUsuNombre";
    }

    @Override
    public String getFilterLabel(){
        return "Usuario";
    }

    @Override
    public Class getDaoClass(){
        return UsuarioDao.class;
    }

    @Override
    public Class getEntityClass(){
        return Usuario.class;
    }

}