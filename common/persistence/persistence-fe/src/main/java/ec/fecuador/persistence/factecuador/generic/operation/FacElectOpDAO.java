package ec.fecuador.persistence.factecuador.generic.operation;

import ec.fecuador.persistence.factecuador.data.entities.*;

import javax.swing.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Walter on 20/2/17.
 */
public interface FacElectOpDAO {

    public static final String BEAN_NAME = "facElectOpDAO";

    public List<AuditoriaEntity> getAllAuditEnt();

    public void insertAuditEnt(AuditoriaEntity objEntidad);

    public void eliminarAuditEnt(AuditoriaEntity objEntidad);

    public List<DetalleAuditoriaEntity> getAllDetAut();

    public void insertDetAut(DetalleAuditoriaEntity objEntidad);

    public void eliminarDetAut(DetalleAuditoriaEntity objEntidad);

    public List<DetalleRetencionEntity> getAllDetRet();

    public void insertDetRet(DetalleRetencionEntity objEntidad);

    public void eliminarDetRet(DetalleRetencionEntity objEntidad);

    public List<EmpresaEntity> getAllEmp();

    public void insertEmp(EmpresaEntity objEntidad);

    public void eliminarEmp(EmpresaEntity objEntidad);

    public List<EmpresaEntity> getEmpbyNomb(String nombEmp);

    public EmpresaEntity getEmpbyId(String codEmpresa);

    public List<FacturaEntity> getAllFact();

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

    public List<GuiaRemisionEntity> getAllGuiaRem();

    public void insertGuiaRem(GuiaRemisionEntity objEntidad);

    public void eliminarGuiaRem(GuiaRemisionEntity objEntidad);

    public List<NotaCreditoEntity> getAllNotaCred();

    public void insertNotaCred(NotaCreditoEntity objEntidad);

    public void eliminarNotaCred(NotaCreditoEntity objEntidad);

    public List<NotaDebitoEntity> getAllNotaDeb();

    public void insertNotaDeb(NotaDebitoEntity objEntidad);

    public void eliminarNotaDeb(NotaDebitoEntity objEntidad);

    public List<PerfilEntity> getAllPerfil();

    public void insertPerfil(PerfilEntity objEntidad);

    public void eliminarPerfil(PerfilEntity objEntidad);

    public PerfilEntity getPerfilByCodPrf(String codPerfil);

    public List<RetencionEntity> getAllRetenc();

    public void insertRetenc(RetencionEntity objEntidad);

    public void eliminarRetenc(RetencionEntity objEntidad);

    public List<TipoEntity> getAllTipo();

    public void insertTipo(TipoEntity objEntidad);

    public void eliminarTipo(TipoEntity objEntidad);

    public List<UsuarioEntity> getAllUser();

    public UsuarioEntity getUserById(Integer idUser);

    public List<UsuarioEntity> getAllUserLazyPag(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters);

    public Long getCountUserLazyPag(Map<String, Object> filters);

    public void insertUser(UsuarioEntity objEntidad);

    public void eliminarUser(UsuarioEntity objEntidad);

    public void actualizarUser(UsuarioEntity objEntidad);

    public UsuarioEntity getAUser(String userName, String userPass, String empCod);

    public UsuarioEntity getAUser(String userName, String empCod);

    public Object lazyLoad(Class<?> clazz, Object entity);
}
