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
    public static String BEAN_NAME = "facturaDAO";

    public List<FacturaEntity> getAllFact();

    public List<FacturaEntity> getFactPaging(Integer firstResult, Integer maxResult);

    public void insertFact(FacturaEntity objEntidad);

    public void eliminarFact(FacturaEntity objEntidad);

    public FacturaEntity findFacturaByPrimaryKey(Integer facCodigo) throws Exception;

    public FacturaEntity findFacturaByInfo(String emisor, String receptor, String establecimiento, String ptoEmision, int secuencial) throws Exception;

    public List<FacturaEntity> filterByFacRazonSocialComprador(String filter, int maxResults) throws Exception;

    public List<FacturaEntity> filterByFacRazonSocialComprador(String filter) throws Exception;

    public List<FacturaEntity> filterByEmpresa(EmpresaEntity empresa) throws Exception;

    public List<FacturaEntity> filterByEmpresa(String empCodigo) throws Exception;

    public List<FacturaEntity> filterByTipo(TipoEntity tipo) throws Exception;

    public List<FacturaEntity> filterByTipo(String tipCodigo) throws Exception;

    public List<FacturaEntity> personalizedFilter(EmpresaEntity empresa, TipoEntity tipo) throws Exception;

    public boolean checkIsRegistered(FacturaEntity f) throws Exception;

    public Date getFirstDate(EmpresaEntity e);

    //public List<FacturaEntity> personalizedFilter(LoginController login, EmpresaEntity empresa, int tipo, Date desde, Date hasta, String filtro, String secuencial, int limit);

    public double getResumeData(EmpresaEntity empresa, TipoEntity tipo, Date inicio, Date fin) throws Exception;

}
