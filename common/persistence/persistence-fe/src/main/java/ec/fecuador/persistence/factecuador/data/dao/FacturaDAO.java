package ec.fecuador.persistence.factecuador.data.dao;

import ec.fecuador.persistence.factecuador.data.entities.EmpresaEntity;
import ec.fecuador.persistence.factecuador.data.entities.FacturaEntity;
import ec.fecuador.persistence.factecuador.data.entities.TipoEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public interface FacturaDAO {
     static String BEAN_NAME = "facturaDAO";

     List<FacturaEntity> getAllFact();

     List<FacturaEntity> getFactPaging(Integer firstResult, Integer maxResult);

     void insertFact(FacturaEntity objEntidad);

     void eliminarFact(FacturaEntity objEntidad);

     FacturaEntity findFacturaByPrimaryKey(Integer facCodigo) throws Exception;

     FacturaEntity findFacturaByInfo(String emisor, String receptor, String establecimiento, String ptoEmision, int secuencial) throws Exception;

     List<FacturaEntity> filterByFacRazonSocialComprador(String filter, int maxResults) throws Exception;

     List<FacturaEntity> filterByFacRazonSocialComprador(String filter) throws Exception;

     List<FacturaEntity> filterByEmpresa(EmpresaEntity empresa) throws Exception;

     List<FacturaEntity> filterByEmpresa(String empCodigo) throws Exception;

     List<FacturaEntity> filterByTipo(TipoEntity tipo) throws Exception;

     List<FacturaEntity> filterByTipo(String tipCodigo) throws Exception;

     List<FacturaEntity> personalizedFilter(EmpresaEntity empresa, TipoEntity tipo) throws Exception;

     boolean checkIsRegistered(FacturaEntity f) throws Exception;

     Date getFirstDate(EmpresaEntity e);

    // List<FacturaEntity> personalizedFilter(LoginController login, EmpresaEntity empresa, int tipo, Date desde, Date hasta, String filtro, String secuencial, int limit);

     double getResumeData(EmpresaEntity empresa, TipoEntity tipo, Date inicio, Date fin) throws Exception;

}
