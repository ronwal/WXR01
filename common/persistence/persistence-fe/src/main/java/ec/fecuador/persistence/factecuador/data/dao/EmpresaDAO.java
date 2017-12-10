package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.EmpresaEntity;

import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface EmpresaDAO {
     static String BEAN_NAME = "empresaDAO";

     List<EmpresaEntity> getAllEmp();

     void insertEmp(EmpresaEntity objEntidad);

     void eliminarEmp(EmpresaEntity objEntidad);

     List<EmpresaEntity> getEmpbyNomb(String nombEmp);

     EmpresaEntity getEmpbyId(String codEmpresa);

}