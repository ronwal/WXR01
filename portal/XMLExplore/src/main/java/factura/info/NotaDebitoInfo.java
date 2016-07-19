package factura.info;

import ec.ste.factura.EntityInfo;
import ec.ste.factura.dao.NotaDebitoDao;
import ec.ste.factura.entities.NotaDebito;


public class NotaDebitoInfo implements EntityInfo {

    public static final String NDE_CODIGO = "ndeCodigo";
    public static final String EMPRESA = "empresa";
    public static final String TIPO = "tipo";
    public static final String NDE_NUM_AUTORIZACION = "ndeNumAutorizacion";
    public static final String NDE_FECHA_AUTORIZACION = "ndeFechaAutorizacion";
    public static final String NDE_ESTABLECIMIENTO = "ndeEstablecimiento";
    public static final String NDE_PUNTO_EMISION = "ndePuntoEmision";
    public static final String NDE_SECUENCIAL = "ndeSecuencial";
    public static final String NDE_FECHA_EMISION = "ndeFechaEmision";
    public static final String NDE_IDENTIFICACION_COMPRADOR = "ndeIdentificacionComprador";
    public static final String NDE_RAZON_SOCIAL_COMPRADOR = "ndeRazonSocialComprador";
    public static final String NDE_NUM_DOC_MODIFICADO = "ndeNumDocModificado";
    public static final String NDE_TOTAL_SIN_IMPUESTOS = "ndeTotalSinImpuestos";

    public static final String PK_FINDER_METHOD="findNotaDebitoByPrimaryKey";

    @Override
    public String getPkAttributeName(){
        return "ndeCodigo";
    }


    @Override
    public String getPkFinderMethod(){
        return "findNotaDebitoByPrimaryKey";
    }

    @Override
    public String getFilterAttributeName(){
        return "ndeRazonSocialComprador";
    }

    @Override
    public String getFilterMethod(){
        return "filterByNdeRazonSocialComprador";
    }

    @Override
    public String getFilterLabel(){
        return "Nota Debito";
    }

    @Override
    public Class getDaoClass(){
        return NotaDebitoDao.class;
    }

    @Override
    public Class getEntityClass(){
        return NotaDebito.class;
    }

}