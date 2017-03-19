package ec.fecuador.persistence.factecuador.generic.operation.impl;

import ec.fecuador.persistence.factecuador.data.dao.*;
import ec.fecuador.persistence.factecuador.data.entities.*;
import ec.fecuador.persistence.factecuador.generic.common.AbstractJPADao;
import ec.fecuador.persistence.factecuador.generic.operation.FacElectOpDAO;

import javax.swing.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Walter on 20/2/17.
 */
public class FacElectOpDAOImpl extends AbstractJPADao implements FacElectOpDAO {

    AuditoriaDAO auditoriaDAO;
    DetalleAuditoriaDAO detalleAuditoriaDAO;
    DetalleRetencionDAO detalleRetencionDAO;
    EmpresaDAO empresaDAO;
    FacturaDAO facturaDAO;
    GuiaRemisionDAO guiaRemisionDAO;
    NotaCreditoDAO notaCreditoDAO;
    NotaDebitoDAO notaDebitoDAO;
    RetencionDAO retencionDAO;
    PerfilDAO perfilDAO;
    TipoDAO tipoDAO;
    UsuarioDAO usuarioDAO;

    @Override
    public List<AuditoriaEntity> getAllAuditEnt() {
        return this.auditoriaDAO.getAllAuditEnt();
    }

    @Override
    public void insertAuditEnt(AuditoriaEntity objEntidad) {
        this.auditoriaDAO.insertAuditEnt(objEntidad);
    }

    @Override
    public void eliminarAuditEnt(AuditoriaEntity objEntidad) {
        this.auditoriaDAO.eliminarAuditEnt(objEntidad);
    }

    @Override
    public List<DetalleAuditoriaEntity> getAllDetAut() {
        return this.detalleAuditoriaDAO.getAllDetAut();
    }

    @Override
    public void insertDetAut(DetalleAuditoriaEntity objEntidad) {
        this.detalleAuditoriaDAO.insertDetAut(objEntidad);
    }

    @Override
    public void eliminarDetAut(DetalleAuditoriaEntity objEntidad) {
        this.detalleAuditoriaDAO.eliminarDetAut(objEntidad);
    }

    @Override
    public List<DetalleRetencionEntity> getAllDetRet() {
        return this.detalleRetencionDAO.getAllDetRet();
    }

    @Override
    public void insertDetRet(DetalleRetencionEntity objEntidad) {
        this.detalleRetencionDAO.insertDetRet(objEntidad);
    }

    @Override
    public void eliminarDetRet(DetalleRetencionEntity objEntidad) {
        this.detalleRetencionDAO.eliminarDetRet(objEntidad);
    }

    @Override
    public List<EmpresaEntity> getAllEmp() {
        return this.empresaDAO.getAllEmp();
    }

    @Override
    public void insertEmp(EmpresaEntity objEntidad) {
        this.empresaDAO.insertEmp(objEntidad);
    }

    @Override
    public void eliminarEmp(EmpresaEntity objEntidad) {
        this.empresaDAO.eliminarEmp(objEntidad);
    }

    @Override
    public List<EmpresaEntity> getEmpbyNomb(String nombEmp) {
        return this.empresaDAO.getEmpbyNomb(nombEmp);
    }

    @Override
    public EmpresaEntity getEmpbyId(String codEmpresa) {
        return this.empresaDAO.getEmpbyId(codEmpresa);
    }

    @Override
    public List<FacturaEntity> getAllFact() {
        return this.facturaDAO.getAllFact();
    }

    @Override
    public void insertFact(FacturaEntity objEntidad) {
        this.facturaDAO.insertFact(objEntidad);
    }

    @Override
    public void eliminarFact(FacturaEntity objEntidad) {
        this.facturaDAO.eliminarFact(objEntidad);
    }

    @Override
    public FacturaEntity findFacturaByPrimaryKey(Integer facCodigo) throws Exception {
        return this.facturaDAO.findFacturaByPrimaryKey(facCodigo);
    }

    @Override
    public FacturaEntity findFacturaByInfo(String emisor, String receptor, String establecimiento, String ptoEmision, int secuencial) throws Exception {
        return this.facturaDAO.findFacturaByInfo(emisor, receptor, establecimiento, ptoEmision, secuencial);
    }

    @Override
    public List<FacturaEntity> filterByFacRazonSocialComprador(String filter, int maxResults) throws Exception {
        return this.facturaDAO.filterByFacRazonSocialComprador(filter, maxResults);
    }

    @Override
    public List<FacturaEntity> filterByFacRazonSocialComprador(String filter) throws Exception {
        return this.facturaDAO.filterByFacRazonSocialComprador(filter);
    }

    @Override
    public List<FacturaEntity> filterByEmpresa(EmpresaEntity empresa) throws Exception {
        return this.facturaDAO.filterByEmpresa(empresa);
    }

    @Override
    public List<FacturaEntity> filterByEmpresa(String empCodigo) throws Exception {
        return this.facturaDAO.filterByEmpresa(empCodigo);
    }

    @Override
    public List<FacturaEntity> filterByTipo(TipoEntity tipo) throws Exception {
        return this.facturaDAO.filterByTipo(tipo);
    }

    @Override
    public List<FacturaEntity> filterByTipo(String tipCodigo) throws Exception {
        return this.facturaDAO.filterByTipo(tipCodigo);
    }

    @Override
    public List<FacturaEntity> personalizedFilter(EmpresaEntity empresa, TipoEntity tipo) throws Exception {
        return this.facturaDAO.personalizedFilter(empresa, tipo);
    }

    @Override
    public boolean checkIsRegistered(FacturaEntity factEnt) throws Exception {
        return this.facturaDAO.checkIsRegistered(factEnt);
    }

    @Override
    public Date getFirstDate(EmpresaEntity empEnt) {
        return this.facturaDAO.getFirstDate(empEnt);
    }

    @Override
    public double getResumeData(EmpresaEntity empresa, TipoEntity tipo, Date inicio, Date fin) throws Exception {
        return this.facturaDAO.getResumeData(empresa, tipo, inicio, fin);
    }

    @Override
    public List<GuiaRemisionEntity> getAllGuiaRem() {
        return this.guiaRemisionDAO.getAllGuiaRem();
    }

    @Override
    public void insertGuiaRem(GuiaRemisionEntity objEntidad) {
        this.guiaRemisionDAO.insertGuiaRem(objEntidad);
    }

    @Override
    public void eliminarGuiaRem(GuiaRemisionEntity objEntidad) {
        this.guiaRemisionDAO.eliminarGuiaRem(objEntidad);
    }

    @Override
    public List<NotaCreditoEntity> getAllNotaCred() {
        return this.notaCreditoDAO.getAllNotaCred();
    }

    @Override
    public void insertNotaCred(NotaCreditoEntity objEntidad) {
        this.notaCreditoDAO.insertNotaCred(objEntidad);
    }

    @Override
    public void eliminarNotaCred(NotaCreditoEntity objEntidad) {
        this.notaCreditoDAO.eliminarNotaCred(objEntidad);
    }

    @Override
    public List<NotaDebitoEntity> getAllNotaDeb() {
        return this.notaDebitoDAO.getAllNotaDeb();
    }

    @Override
    public void insertNotaDeb(NotaDebitoEntity objEntidad) {
        this.notaDebitoDAO.insertNotaDeb(objEntidad);
    }

    @Override
    public void eliminarNotaDeb(NotaDebitoEntity objEntidad) {
        this.notaDebitoDAO.eliminarNotaDeb(objEntidad);
    }

    @Override
    public List<PerfilEntity> getAllPerfil() {
        return this.perfilDAO.getAllPerfil();
    }

    @Override
    public void insertPerfil(PerfilEntity objEntidad) {
        this.perfilDAO.insertPerfil(objEntidad);
    }

    @Override
    public void eliminarPerfil(PerfilEntity objEntidad) {
        this.perfilDAO.eliminarPerfil(objEntidad);
    }

    @Override
    public PerfilEntity getPerfilByCodPrf(String codPerfil) {
        return this.perfilDAO.getPerfilByCodPrf(codPerfil);
    }

    @Override
    public List<RetencionEntity> getAllRetenc() {
        return this.retencionDAO.getAllRetenc();
    }

    @Override
    public void insertRetenc(RetencionEntity objEntidad) {
        this.retencionDAO.insertRetenc(objEntidad);
    }

    @Override
    public void eliminarRetenc(RetencionEntity objEntidad) {
        this.retencionDAO.eliminarRetenc(objEntidad);
    }

    @Override
    public List<TipoEntity> getAllTipo() {
        return this.tipoDAO.getAllTipo();
    }

    @Override
    public void insertTipo(TipoEntity objEntidad) {
        this.tipoDAO.insertTipo(objEntidad);
    }

    @Override
    public void eliminarTipo(TipoEntity objEntidad) {
        this.tipoDAO.eliminarTipo(objEntidad);
    }

    @Override
    public List<UsuarioEntity> getAllUser() {
        return this.usuarioDAO.getAllUser();
    }

    @Override
    public UsuarioEntity getUserById(Integer idUser) {
        return this.usuarioDAO.getUserById(idUser);
    }

    @Override
    public List<UsuarioEntity> getAllUserLazyPag(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        return this.usuarioDAO.getAllUserLazyPag(first, pageSize, sortField, sortOrder, filters);
    }

    @Override
    public Long getCountUserLazyPag(Map<String, Object> filters) {
        return this.usuarioDAO.getUserCount(filters);
    }

    @Override
    public UsuarioEntity getAUser(String userName, String userPass, String empCod) {
        return this.usuarioDAO.getAUser(userName, userPass, empCod);
    }

    @Override
    public UsuarioEntity getAUser(String userName, String empCod) {
        return this.usuarioDAO.getAUser(userName, empCod);
    }

    @Override
    public void insertUser(UsuarioEntity objEntidad) {
        this.usuarioDAO.insertUser(objEntidad);
    }

    @Override
    public void eliminarUser(UsuarioEntity objEntidad) {
        this.usuarioDAO.eliminarUser(objEntidad);
    }

    @Override
    public void actualizarUser(UsuarioEntity objEntidad) {
        this.usuarioDAO.actualizarUser(objEntidad);
    }

    @Override
    public Object lazyLoad(Class<?> clazz, Object entity) {
        return this.perfilDAO.lazyLoad(clazz, entity);
    }

    /**
     * ManagedBeans
     **/
    public void setAuditoriaDAO(AuditoriaDAO auditoriaDAO) {
        this.auditoriaDAO = auditoriaDAO;
    }

    public void setDetalleAuditoriaDAO(DetalleAuditoriaDAO detalleAuditoriaDAO) {
        this.detalleAuditoriaDAO = detalleAuditoriaDAO;
    }

    public void setDetalleRetencionDAO(DetalleRetencionDAO detalleRetencionDAO) {
        this.detalleRetencionDAO = detalleRetencionDAO;
    }

    public void setEmpresaDAO(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO;
    }

    public void setFacturaDAO(FacturaDAO facturaDAO) {
        this.facturaDAO = facturaDAO;
    }

    public void setGuiaRemisionDAO(GuiaRemisionDAO guiaRemisionDAO) {
        this.guiaRemisionDAO = guiaRemisionDAO;
    }

    public void setNotaCreditoDAO(NotaCreditoDAO notaCreditoDAO) {
        this.notaCreditoDAO = notaCreditoDAO;
    }

    public void setNotaDebitoDAO(NotaDebitoDAO notaDebitoDAO) {
        this.notaDebitoDAO = notaDebitoDAO;
    }

    public void setRetencionDAO(RetencionDAO retencionDAO) {
        this.retencionDAO = retencionDAO;
    }

    public void setPerfilDAO(PerfilDAO perfilDAO) {
        this.perfilDAO = perfilDAO;
    }

    public void setTipoDAO(TipoDAO tipoDAO) {
        this.tipoDAO = tipoDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
