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

     List<AuditoriaEntity> getAllAuditEnt();

     void insertAuditEnt(AuditoriaEntity objEntidad);

     void eliminarAuditEnt(AuditoriaEntity objEntidad);

     List<DetalleAuditoriaEntity> getAllDetAut();

     void insertDetAut(DetalleAuditoriaEntity objEntidad);

     void eliminarDetAut(DetalleAuditoriaEntity objEntidad);

     List<DetalleRetencionEntity> getAllDetRet();

     void insertDetRet(DetalleRetencionEntity objEntidad);

     void eliminarDetRet(DetalleRetencionEntity objEntidad);

     List<EmpresaEntity> getAllEmp();

     void insertEmp(EmpresaEntity objEntidad);

     void eliminarEmp(EmpresaEntity objEntidad);

     List<EmpresaEntity> getEmpbyNomb(String nombEmp);

     EmpresaEntity getEmpbyId(String codEmpresa);

     List<FacturaEntity> getAllFact();

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

     List<GuiaRemisionEntity> getAllGuiaRem();

     void insertGuiaRem(GuiaRemisionEntity objEntidad);

     void eliminarGuiaRem(GuiaRemisionEntity objEntidad);

     List<NotaCreditoEntity> getAllNotaCred();

     void insertNotaCred(NotaCreditoEntity objEntidad);

     void eliminarNotaCred(NotaCreditoEntity objEntidad);

     List<NotaDebitoEntity> getAllNotaDeb();

     void insertNotaDeb(NotaDebitoEntity objEntidad);

     void eliminarNotaDeb(NotaDebitoEntity objEntidad);

     List<PerfilEntity> getAllPerfil();

     void insertPerfil(PerfilEntity objEntidad);

     void eliminarPerfil(PerfilEntity objEntidad);

     PerfilEntity getPerfilByCodPrf(String codPerfil);

     List<RetencionEntity> getAllRetenc();

     void insertRetenc(RetencionEntity objEntidad);

     void eliminarRetenc(RetencionEntity objEntidad);

     List<TipoEntity> getAllTipo();

     void insertTipo(TipoEntity objEntidad);

     void eliminarTipo(TipoEntity objEntidad);

     List<UsuarioEntity> getAllUser();

     UsuarioEntity getUserById(Integer idUser);

     List<UsuarioEntity> getAllUserLazyPag(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters);

     Long getCountUserLazyPag(Map<String, Object> filters);

     void insertUser(UsuarioEntity objEntidad);

     void eliminarUser(UsuarioEntity objEntidad);

     void actualizarUser(UsuarioEntity objEntidad);

     UsuarioEntity getAUser(String userName, String userPass, String empCod);

     UsuarioEntity getAUser(String userName, String empCod);

     Object lazyLoad(Class<?> clazz, Object entity);
}
