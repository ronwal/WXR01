package factura;

import java.util.HashMap;
import java.util.Map;

public abstract class InfoManager {

    public static final AuditoriaInfo AUDITORIA_INFO = new AuditoriaInfo();
    public static final DetalleAuditoriaInfo DETALLE_AUDITORIA_INFO = new DetalleAuditoriaInfo();
    public static final EmpresaInfo EMPRESA_INFO = new EmpresaInfo();
    public static final FacturaInfo FACTURA_INFO = new FacturaInfo();
    public static final GuiaRemisionInfo GUIA_REMISION_INFO = new GuiaRemisionInfo();
    public static final NotaCreditoInfo NOTA_CREDITO_INFO = new NotaCreditoInfo();
    public static final NotaDebitoInfo NOTA_DEBITO_INFO = new NotaDebitoInfo();
    public static final PerfilInfo PERFIL_INFO = new PerfilInfo();
    public static final RetencionInfo RETENCION_INFO = new RetencionInfo();
    public static final TipoInfo TIPO_INFO = new TipoInfo();
    public static final UsuarioInfo USUARIO_INFO = new UsuarioInfo();
    public static Map<String, EntityInfo> infoMap = new HashMap<String, EntityInfo>() {
        {
            put("Auditoria", AUDITORIA_INFO);
            put("DetalleAuditoria", DETALLE_AUDITORIA_INFO);
            put("Empresa", EMPRESA_INFO);
            put("Factura", FACTURA_INFO);
            put("GuiaRemision", GUIA_REMISION_INFO);
            put("NotaCredito", NOTA_CREDITO_INFO);
            put("NotaDebito", NOTA_DEBITO_INFO);
            put("Perfil", PERFIL_INFO);
            put("Retencion", RETENCION_INFO);
            put("Tipo", TIPO_INFO);
            put("Usuario", USUARIO_INFO);
        }
    };

    public static EntityInfo findInfo(Object entity) {
        if (entity instanceof DatabaseEntity) {
            return infoMap.get(entity.getClass().getSimpleName());
        }
        return null;
    }
}
