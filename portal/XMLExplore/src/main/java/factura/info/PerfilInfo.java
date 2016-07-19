package factura.info;

import ec.ste.factura.EntityInfo;
import ec.ste.factura.dao.PerfilDao;
import ec.ste.factura.entities.Perfil;


public class PerfilInfo implements EntityInfo {

    public static final String PRF_CODIGO = "prfCodigo";
    public static final String PRF_NOMBRE = "prfNombre";

    public static final String PK_FINDER_METHOD="findPerfilByPrimaryKey";

    @Override
    public String getPkAttributeName(){
        return "prfCodigo";
    }


    @Override
    public String getPkFinderMethod(){
        return "findPerfilByPrimaryKey";
    }

    @Override
    public String getFilterAttributeName(){
        return "prfNombre";
    }

    @Override
    public String getFilterMethod(){
        return "filterByPrfNombre";
    }

    @Override
    public String getFilterLabel(){
        return "Perfil";
    }

    @Override
    public Class getDaoClass(){
        return PerfilDao.class;
    }

    @Override
    public Class getEntityClass(){
        return Perfil.class;
    }

}