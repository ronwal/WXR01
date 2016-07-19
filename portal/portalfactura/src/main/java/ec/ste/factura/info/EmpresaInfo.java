package ec.ste.factura.info;

import ec.ste.factura.EntityInfo;
import ec.ste.factura.dao.EmpresaDao;
import ec.ste.factura.entities.Empresa;


public class EmpresaInfo implements EntityInfo {

    public static final String EMP_CODIGO = "empCodigo";
    public static final String EMP_RAZON_SOCIAL = "empRazonSocial";
    public static final String EMP_MAIL = "empMail";
    public static final String EMP_TELEFONO = "empTelefono";
    public static final String EMP_DIRECCION = "empDireccion";

    public static final String PK_FINDER_METHOD="findEmpresaByPrimaryKey";

    @Override
    public String getPkAttributeName(){
        return "empCodigo";
    }


    @Override
    public String getPkFinderMethod(){
        return "findEmpresaByPrimaryKey";
    }

    @Override
    public String getFilterAttributeName(){
        return "empRazonSocial";
    }

    @Override
    public String getFilterMethod(){
        return "filterByEmpRazonSocial";
    }

    @Override
    public String getFilterLabel(){
        return "Empresa";
    }

    @Override
    public Class getDaoClass(){
        return EmpresaDao.class;
    }

    @Override
    public Class getEntityClass(){
        return Empresa.class;
    }

}