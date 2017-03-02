/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fecuador.persistence.factecuador.generic.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author @rw_r
 */
public abstract class AbstractJPADao {

    protected EntityManager em;

    /**
     * Sets the EntityManager through Spring injection.
     *
     * @param entityManager the new EntityManager
     */
    @PersistenceContext(unitName = "fecuadorPersistence")
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
}
