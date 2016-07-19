/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fecuador.persist.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mauriciochilan
 */
public abstract class AbstractJPADao {

    /**
     * The EntityManager
     */
    protected EntityManager em;

    /**
     * Sets the EntityManager through Spring injection.
     *
     * @param entityManager the new EntityManager
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
}
