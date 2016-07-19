package ec.ste.factura.info;

import ec.ste.factura.EntityInfo;
import ec.ste.factura.dao.DetalleAuditoriaDao;
import ec.ste.factura.entities.DetalleAuditoria;


public class DetalleAuditoriaInfo implements EntityInfo {

    public static final String DAU_CODIGO = "dauCodigo";
    public static final String AUDITORIA = "auditoria";
    public static final String DAU_FECHA = "dauFecha";
    public static final String DAU_ACCION = "dauAccion";
    public static final String DAU_TIPO_DOCUMENTO = "dauTipoDocumento";
    public static final String DAU_CODIGO_DOCUMENTO = "dauCodigoDocumento";

    public static final String PK_FINDER_METHOD="findDetalleAuditoriaByPrimaryKey";

    @Override
    public String getPkAttributeName(){
        return "dauCodigo";
    }


    @Override
    public String getPkFinderMethod(){
        return "findDetalleAuditoriaByPrimaryKey";
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
        return DetalleAuditoriaDao.class;
    }

    @Override
    public Class getEntityClass(){
        return DetalleAuditoria.class;
    }

}