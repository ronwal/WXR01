package ec.fecuador.persistence.factecuador.data.dao.impl;

import ec.fecuador.persistence.factecuador.data.dao.EmpresaDAO;
import ec.fecuador.persistence.factecuador.data.entities.EmpresaEntity;
import ec.fecuador.persistence.factecuador.generic.common.impl.GenericDAOImpl;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by @rw_r on 25/2/16.
 */
public class EmpresaDAOImpl extends GenericDAOImpl<EmpresaEntity, Integer> implements EmpresaDAO {
    public EmpresaDAOImpl() {
        super(EmpresaEntity.class);
    }

    @Override
    public List<EmpresaEntity> getAllEmp() {
        return getAll();
    }

    @Override
    public void insertEmp(EmpresaEntity objEntidad) {
        create(objEntidad);
    }

    @Override
    public void eliminarEmp(EmpresaEntity objEntidad) {
        eliminarEmp(objEntidad);
    }

    @Override
    public List<EmpresaEntity> getEmpbyNomb(String nombEmp) {
        List<EmpresaEntity> entityList = null;
        try {
            String sql = "SELECT td " +
                    "FROM EmpresaEntity td " +
                    "WHERE td.empRazonSocial like :nombEmp " +
                    "ORDER BY td.empRazonSocial ASC ";

            TypedQuery<EmpresaEntity> query = em.createQuery(sql, EmpresaEntity.class);
            query.setParameter("nombEmp", "%" + nombEmp + "%");
            entityList = query.getResultList();
        } finally {
            return entityList;
        }
    }

    @Override
    public EmpresaEntity getEmpbyId(String codEmpresa) {
        EmpresaEntity entity = null;
        try {
            String sql = "SELECT td " +
                    "FROM EmpresaEntity td " +
                    "WHERE td.empCodigo=:codEmpresa " +
                    "ORDER BY td.empRazonSocial ASC ";

            TypedQuery<EmpresaEntity> query = em.createQuery(sql, EmpresaEntity.class);
            query.setParameter("codEmpresa", codEmpresa);
            entity = query.getSingleResult();
        } finally {
            return entity;
        }
    }
}
