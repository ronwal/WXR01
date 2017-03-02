/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fecuador.persistence.factecuador.generic.common;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author @rw_r
 */
@Transactional
public interface GenericDAO<T, PK extends Serializable> {

    /**
     * Creates a new instance of a persistent object.
     *
     * @param newInstance the new instance
     */
    void create(T newInstance);

    /**
     * Reads a persistent object.
     *
     * @param id the id
     * @return the t
     */
    T read(PK id);

    /**
     * Updates a persistent object.
     *
     * @param persistentObject the persistent object
     */
    void update(T persistentObject);

    /**
     * Deletes a persistent object.
     *
     * @param persistentObject the persistent object
     */
    void delete(T persistentObject);

    <T> T readEager(PK id);

    //public Class<T> refreshEager(Class<? extends Object> clazz, Class<?> entity);
    Object refreshEager(Class<?> clazz, Object entity);

    T lazyLoad(T entity);
}
