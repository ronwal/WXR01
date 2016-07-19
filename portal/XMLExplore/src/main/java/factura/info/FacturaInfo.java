package factura.info;

import ec.ste.factura.EntityInfo;
import ec.ste.factura.dao.FacturaDao;
import ec.ste.factura.entities.Factura;


public class FacturaInfo implements EntityInfo {

    public static final String FAC_CODIGO = "facCodigo";
    public static final String EMPRESA = "empresa";
    public static final String TIPO = "tipo";
    public static final String FAC_NUM_AUTORIZACION = "facNumAutorizacion";
    public static final String FAC_FECHA_AUTORIZACION = "facFechaAutorizacion";
    public static final String FAC_ESTABLECIMIENTO = "facEstablecimiento";
    public static final String FAC_PUNTO_EMISION = "facPuntoEmision";
    public static final String FAC_SECUENCIAL = "facSecuencial";
    public static final String FAC_FECHA_EMISION = "facFechaEmision";
    public static final String FAC_IDENTIFICACION_COMPRADOR = "facIdentificacionComprador";
    public static final String FAC_RAZON_SOCIAL_COMPRADOR = "facRazonSocialComprador";
    public static final String FAC_TOTAL_SIN_IMPUESTOS = "facTotalSinImpuestos";
    public static final String FAC_TOTAL_DESCUENTO = "facTotalDescuento";
    public static final String FAC_IMPORTE_TOTAL = "facImporteTotal";

    public static final String PK_FINDER_METHOD="findFacturaByPrimaryKey";

    @Override
    public String getPkAttributeName(){
        return "facCodigo";
    }


    @Override
    public String getPkFinderMethod(){
        return "findFacturaByPrimaryKey";
    }

    @Override
    public String getFilterAttributeName(){
        return "facRazonSocialComprador";
    }

    @Override
    public String getFilterMethod(){
        return "filterByFacRazonSocialComprador";
    }

    @Override
    public String getFilterLabel(){
        return "Factura";
    }

    @Override
    public Class getDaoClass(){
        return FacturaDao.class;
    }

    @Override
    public Class getEntityClass(){
        return Factura.class;
    }

}