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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.swing.*;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        //pagination

        if (maxResult >= 0) {
            query.setMaxResults(maxResult);
        }
        if (firstResult >= 0) {
            query.setFirstResult(firstResult);
        }
        return query.getResultList();
    }

    /**
     * Get all object of table
     *
     * @return list of result
     **/
    public Long getCount(Map<String, Object> filters) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> q = cb.createQuery(Long.class);

        Root<T> c = q.from(type);

        List<Predicate> predicates = new ArrayList<>();
        if (filters.size() > 0) {
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                Predicate condition = cb.like(c.get(entry.getKey()), "%" + (String) entry.getValue() + "%");
                predicates.add(condition);
            }
        }

        if (predicates.size() > 0) {
            q.where(cb.and(predicates.toArray(new Predicate[]{})));
        }

        q.select(cb.count(c));
        TypedQuery<Long> query = em.createQuery(q);

        return query.getSingleResult();
    }

    public List<T> getPaging(int firstResult, int maxResult, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(type);
        Root<T> c = q.from(type);

        List<Predicate> predicates = new ArrayList<>();
        if (filters.size() > 0) {
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                Predicate condition = cb.like(cb.upper(c.get(entry.getKey())), "%" + ((String) entry.getValue()).toUpperCase() + "%");
                predicates.add(condition);
            }
        }

        if (predicates.size() > 0) {
            q.where(cb.and(predicates.toArray(new Predicate[]{})));
        }
        if (sortField != null)
            if (sortOrder.equals(SortOrder.ASCENDING)) {
                q.orderBy(cb.asc(c.get(sortField)));
            } else if (sortOrder.equals(SortOrder.DESCENDING)) {
                q.orderBy(cb.desc(c.get(sortField)));
            }


        q.select(c);
        TypedQuery<T> query = em.createQuery(q);

        //pagination
        if (maxResult >= 0) {
            query.setMaxResults(maxResult);
        }
        if (firstResult >= 0) {
            query.setFirstResult(firstResult);
        }
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
