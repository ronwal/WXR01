/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.fecuador.persistence.factecuador.generic.common.impl;

import ec.fecuador.persistence.factecuador.generic.common.AbstractJPADao;
import ec.fecuador.persistence.factecuador.generic.common.GenericDAO;
import org.apache.commons.lang.reflect.FieldUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author @rw_r
 */
@Transactional
@SuppressWarnings("Duplicates")
public class GenericDAOImpl<T, PK extends Serializable> extends AbstractJPADao implements GenericDAO<T, PK> {

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
     * Creates a new instance of a persistent object.
     *
     * @param newInstanceList the new instance
     */
    @Transactional(readOnly = true)
    public void create(List<T> newInstanceList) {
        if (newInstanceList.size() > 0) {
            int i = 0;
            for (T objInstance : newInstanceList) {
                em.persist(objInstance);

                if (++i % 50 == 0)
                    flushClear();
            }
            flushClear();
        }
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
     * Reads a persistent object.
     *
     * @param id the id
     * @return the t
     */
    public T read(String id) {
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
     * Updates a persistent object.
     *
     * @param persistentObjectList the persistent object
     */
    @Transactional
    public void update(List<T> persistentObjectList) {
        if (persistentObjectList.size() > 0) {
            int i = 0;
            for (T objInstance : persistentObjectList) {
                em.merge(objInstance);

                if (++i % 50 == 0)
                    flushClear();
            }
            flushClear();
        }
    }

    /**
     * Deletes a persistent object.
     *
     * @param persistentObject the persistent object
     */
    public void delete(T persistentObject) {
        em.remove(persistentObject);
        em.flush();
    }

    /**
     * Get all object of table
     *
     * @return list of result
     **/
    public List<T> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(type);
        Root<T> c = q.from(type);
        q.select(c);
        TypedQuery<T> query = em.createQuery(q);
        return query.getResultList();
    }

    /**
     * Get all object of table
     *
     * @return list of result
     **/
    public List<T> getPaging(Integer firstResult, Integer maxResult) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(type);
        Root<T> c = q.from(type);
        q.select(c);
        TypedQuery<T> query = em.createQuery(q);
        query.setFirstResult(firstResult).setMaxResults(maxResult);
        return query.getResultList();
    }

    /**
     * Leaves execution process and clean cache
     **/
    private void flushClear() {
        em.flush();
        em.clear();
    }

    public <T> T readEager(PK id) {
        return (T) lazyLoad(em.find(type, id));
    }

    public Object refreshEager(Class<?> clazz, Object entity) {
        entity = lazyLogic(clazz, em.find((Class<T>) clazz, getId(entity)));
        return entity;
    }

    public T lazyLoad(T entity) {
        return (T) lazyLogic(type, entity);
    }

    public Object lazyLogic(Class<?> clazz, T entity) {
        for (Method field : clazz.getDeclaredMethods()) {
            for (Annotation s : field.getAnnotations()) {
                if (s.annotationType().equals(OneToMany.class) ||
                        s.annotationType().equals(ManyToOne.class)) {
                    try {
                        new PropertyDescriptor(getFielName(field.getName()), clazz).getReadMethod().invoke(entity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return entity;
    }

    public Object getId(Object ent) {
        try {
            Metamodel metamodel = em.getMetamodel();

            // Get an entity type:
            EntityType<T> entity = metamodel.entity(type);

            Method idMember = (Method) entity.getDeclaredId(entity.getIdType().getJavaType()).getJavaMember();
            String fieldName = getFielName(idMember.getName());

            return FieldUtils.readField(ent, fieldName, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getFielName(String fieldMethod) {
        String fieldName = "";
        fieldName = fieldMethod.replace("get", "");
        String ax_ = fieldName.substring(0, 1).toLowerCase();
        String ax = fieldName.substring(1, fieldName.length());
        fieldName = ax_ + ax;
        return fieldName;
    }
}
