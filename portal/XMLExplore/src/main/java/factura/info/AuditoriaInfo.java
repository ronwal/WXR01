package factura.info;

import ec.ste.factura.EntityInfo;
import ec.ste.factura.dao.AuditoriaDao;
import ec.ste.factura.entities.Auditoria;


public class AuditoriaInfo implements EntityInfo {

    public static final String AUD_CODIGO = "audCodigo";
    public static final String USUARIO = "usuario";
    public static final String AUD_FECHA = "audFecha";

    public static final String PK_FINDER_METHOD="findAuditoriaByPrimaryKey";

    @Override
    public String getPkAttributeName(){
        return "audCodigo";
    }


    @Override
    public String getPkFinderMethod(){
        return "findAuditoriaByPrimaryKey";
    }

    @Override
    public String getFilterAttributeName(){
        return getPkAttributeName();
    }

    @Override
    public String getFilterMethod(){
        return getPkFinderMethod();
    }

    @Override
    public String getFilterLabel(){
        return null;
    }

    @Override
    public Class getDaoClass(){
        return AuditoriaDao.class;
    }

    @Override
    public Class getEntityClass(){
        return Auditoria.class;
    }

}