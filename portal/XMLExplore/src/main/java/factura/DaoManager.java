package factura;

import ec.ste.factura.dao.*;


public abstract class DaoManager extends InfoManager{

    public static final AuditoriaDao AUDITORIA_DAO = new AuditoriaDao();
    public static final DetalleAuditoriaDao DETALLE_AUDITORIA_DAO = new DetalleAuditoriaDao();
    public static final EmpresaDao EMPRESA_DAO = new EmpresaDao();
    public static final FacturaDao FACTURA_DAO = new FacturaDao();
    public static final GuiaRemisionDao GUIA_REMISION_DAO = new GuiaRemisionDao();
    public static final NotaCreditoDao NOTA_CREDITO_DAO = new NotaCreditoDao();
    public static final NotaDebitoDao NOTA_DEBITO_DAO = new NotaDebitoDao();
    public static final PerfilDao PERFIL_DAO = new PerfilDao();
    public static final RetencionDao RETENCION_DAO = new RetencionDao();
    public static final TipoDao TIPO_DAO = new TipoDao();
    public static final UsuarioDao USUARIO_DAO = new UsuarioDao();
}