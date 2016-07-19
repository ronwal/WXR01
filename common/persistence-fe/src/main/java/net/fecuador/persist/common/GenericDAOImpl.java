/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fecuador.persist.common;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 *
 * @author mauriciochilan
 */
public class GenericDAOImpl <T, PK extends Serializable> extends AbstractJPADao implements GenericDAO<T, PK> {

    /**
     * The generic class type.
     */
    private Class<T> type;

    /**
     * Instantiates a new generic JPA DAO implementation.
     *
     * @param type the type
     */
    public GenericDAOImpl(Class<T> type) {
        this.type = type;
    }

    /**
     * Creates a new instance of a persistent object.
     *
     * @param newInstance the new instance
     */
    @Transactional(readOnly = true)
    public void create(T newInstance) {
        em.persist(newInstance);
        em.flush();
    }

    /**
     * Reads a persistent object.
     *
     * @param id the id
     * @return the t
     */
    public T read(PK id) {
        return em.find(type, id);
    }

    /**
     * Updates a persistent object.
     *
     * @param persistentObject the persistent object
     */
    @Transactional
    public void update(T persistentObject) {
        em.merge(persistentObject);
        em.flush();
    }

    /**
     * Deletes a persistent object.
     *
     * @param persistentObject the persistent object
     */
    @Transactional
    public void delete(T persistentObject) {
        em.remove(em.merge(persistentObject));
        em.flush();
    }

    public EntityManager getEm(){
        return em;
    }
}
