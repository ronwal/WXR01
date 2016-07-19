package factura.info;

import ec.ste.factura.EntityInfo;
import ec.ste.factura.dao.NotaCreditoDao;
import ec.ste.factura.entities.NotaCredito;


public class NotaCreditoInfo implements EntityInfo {

    public static final String NCR_CODIGO = "ncrCodigo";
    public static final String EMPRESA = "empresa";
    public static final String TIPO = "tipo";
    public static final String NCR_NUM_AUTORIZACION = "ncrNumAutorizacion";
    public static final String NCR_FECHA_AUTORIZACION = "ncrFechaAutorizacion";
    public static final String NCR_ESTABLECIMIENTO = "ncrEstablecimiento";
    public static final String NCR_PUNTO_EMISION = "ncrPuntoEmision";
    public static final String NCR_SECUENCIAL = "ncrSecuencial";
    public static final String NCR_FECHA_EMISION = "ncrFechaEmision";
    public static final String NCR_IDENTIFICACION_COMPRADOR = "ncrIdentificacionComprador";
    public static final String NCR_RAZON_SOCIAL_COMPRADOR = "ncrRazonSocialComprador";
    public static final String NCR_NUM_DOC_MODIFICADO = "ncrNumDocModificado";
    public static final String NCR_TOTAL_SIN_IMPUESTOS = "ncrTotalSinImpuestos";
    public static final String NCR_VALOR_MODIFICACION = "ncrValorModificacion";

    public static final String PK_FINDER_METHOD="findNotaCreditoByPrimaryKey";

    @Override
    public String getPkAttributeName(){
        return "ncrCodigo";
    }


    @Override
    public String getPkFinderMethod(){
        return "findNotaCreditoByPrimaryKey";
    }

    @Override
    public String getFilterAttributeName(){
        return "ncrRazonSocialComprador";
    }

    @Override
    public String getFilterMethod(){
        return "filterByNcrRazonSocialComprador";
    }

    @Override
    public String getFilterLabel(){
        return "Nota Credito";
    }

    @Override
    public Class getDaoClass(){
        return NotaCreditoDao.class;
    }

    @Override
    public Class getEntityClass(){
        return NotaCredito.class;
    }

}