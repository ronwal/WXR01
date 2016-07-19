package ec.ste.factura.info;

import ec.ste.factura.EntityInfo;
import ec.ste.factura.dao.RetencionDao;
import ec.ste.factura.entities.Retencion;


public class RetencionInfo implements EntityInfo {

    public static final String RET_CODIGO = "retCodigo";
    public static final String EMPRESA = "empresa";
    public static final String TIPO = "tipo";
    public static final String RET_NUM_AUTORIZACION = "retNumAutorizacion";
    public static final String RET_FECHA_AUTORIZACION = "retFechaAutorizacion";
    public static final String RET_ESTABLECIMIENTO = "retEstablecimiento";
    public static final String RET_PUNTO_EMISION = "retPuntoEmision";
    public static final String RET_SECUENCIAL = "retSecuencial";
    public static final String RET_FECHA_EMISION = "retFechaEmision";
    public static final String RET_IDENTIFICACION_RETENIDO = "retIdentificacionRetenido";
    public static final String RET_RAZON_SOCIAL_RETENIDO = "retRazonSocialRetenido";
    public static final String RET_BASE_IMPONIBLE = "retBaseImponible";
    public static final String RET_PORCENTAJE_RETENER = "retPorcentajeRetener";
    public static final String RET_VALOR_RETENIDO = "retValorRetenido";
    public static final String RET_DOCUMENTO_SUSTENTO = "retDocumentoSustento";

    public static final String PK_FINDER_METHOD="findRetencionByPrimaryKey";

    @Override
    public String getPkAttributeName(){
        return "retCodigo";
    }


    @Override
    public String getPkFinderMethod(){
        return "findRetencionByPrimaryKey";
    }

    @Override
    public String getFilterAttributeName(){
        return "retRazonSocialRetenido";
    }

    @Override
    public String getFilterMethod(){
        return "filterByRetRazonSocialRetenido";
    }

    @Override
    public String getFilterLabel(){
        return "Retencion";
    }

    @Override
    public Class getDaoClass(){
        return RetencionDao.class;
    }

    @Override
    public Class getEntityClass(){
        return Retencion.class;
    }

}