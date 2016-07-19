package ec.ste.factura.info;

import ec.ste.factura.EntityInfo;
import ec.ste.factura.dao.GuiaRemisionDao;
import ec.ste.factura.entities.GuiaRemision;


public class GuiaRemisionInfo implements EntityInfo {

    public static final String GRE_CODIGO = "greCodigo";
    public static final String EMPRESA = "empresa";
    public static final String TIPO = "tipo";
    public static final String GRE_NUM_AUTORIZACION = "greNumAutorizacion";
    public static final String GRE_FECHA_AUTORIZACION = "greFechaAutorizacion";
    public static final String GRE_ESTABLECIMIENTO = "greEstablecimiento";
    public static final String GRE_PUNTO_EMISION = "grePuntoEmision";
    public static final String GRE_SECUENCIAL = "greSecuencial";
    public static final String GRE_FECHA_EMISION = "greFechaEmision";
    public static final String GRE_INDETIFICACION_COMPRADOR = "greIndetificacionComprador";
    public static final String GRE_RAZON_SOCIAL_COMPRADOR = "greRazonSocialComprador";
    public static final String GRE_NUM_DOC_MODIFICADO = "greNumDocModificado";
    public static final String GRE_TOTAL_SIN_IMPUESTOS = "greTotalSinImpuestos";
    public static final String GRE_VALOR_MODIFICACION = "greValorModificacion";

    public static final String PK_FINDER_METHOD="findGuiaRemisionByPrimaryKey";

    @Override
    public String getPkAttributeName(){
        return "greCodigo";
    }


    @Override
    public String getPkFinderMethod(){
        return "findGuiaRemisionByPrimaryKey";
    }

    @Override
    public String getFilterAttributeName(){
        return "greRazonSocialComprador";
    }

    @Override
    public String getFilterMethod(){
        return "filterByGreRazonSocialComprador";
    }

    @Override
    public String getFilterLabel(){
        return "Guia Remision";
    }

    @Override
    public Class getDaoClass(){
        return GuiaRemisionDao.class;
    }

    @Override
    public Class getEntityClass(){
        return GuiaRemision.class;
    }

}