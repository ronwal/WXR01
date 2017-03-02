package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.EmpresaEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface EmpresaDAO {
    public static String BEAN_NAME = "empresaDAO";

    public List<EmpresaEntity> getAllEmp();

    public void insertEmp(EmpresaEntity objEntidad);

    public void eliminarEmp(EmpresaEntity objEntidad);

    public List<EmpresaEntity> getEmpbyNomb(String nombEmp);

    public EmpresaEntity getEmpbyId(String codEmpresa);

}