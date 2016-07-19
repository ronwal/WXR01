package factura.info;

import ec.ste.factura.EntityInfo;
import ec.ste.factura.dao.TipoDao;
import ec.ste.factura.entities.Tipo;


public class TipoInfo implements EntityInfo {

    public static final String TIP_CODIGO = "tipCodigo";
    public static final String TIP_NOMBRE = "tipNombre";

    public static final String PK_FINDER_METHOD="findTipoByPrimaryKey";

    @Override
    public String getPkAttributeName(){
        return "tipCodigo";
    }


    @Override
    public String getPkFinderMethod(){
        return "findTipoByPrimaryKey";
    }

    @Override
    public String getFilterAttributeName(){
        return "tipNombre";
    }

    @Override
    public String getFilterMethod(){
        return "filterByTipNombre";
    }

    @Override
    public String getFilterLabel(){
        return "Tipo";
    }

    @Override
    public Class getDaoClass(){
        return TipoDao.class;
    }

    @Override
    public Class getEntityClass(){
        return Tipo.class;
    }

}