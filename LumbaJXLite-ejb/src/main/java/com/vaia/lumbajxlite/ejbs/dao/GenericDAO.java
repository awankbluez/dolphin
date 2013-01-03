package com.vaia.lumbajxlite.ejbs.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAO<T>
        implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LumbaJXLite-ejb.v1.PU");
    private EntityManager em;
    private Class<T> entityClass;

    public void beginTransaction() {
        this.em = emf.createEntityManager();

        this.em.getTransaction().begin();
    }

    public void commit() {
        this.em.getTransaction().commit();
    }

    public void rollback() {
        this.em.getTransaction().rollback();
    }

    public void closeTransaction() {
        this.em.close();
    }

    public void commitAndCloseTransaction() {
        commit();
        closeTransaction();
    }

    public void flush() {
        this.em.flush();
    }

    public void joinTransaction() {
        this.em = emf.createEntityManager();
        this.em.joinTransaction();
    }

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        this.em.persist(entity);
    }

    public void delete(T entity) {
        Object entityToBeRemoved = this.em.merge(entity);

        this.em.remove(entityToBeRemoved);
    }

    public T update(T entity) {
        return this.em.merge(entity);
    }

    public T find(int entityID) {
        return this.em.find(this.entityClass, Integer.valueOf(entityID));
    }

    public T findReferenceOnly(int entityID) {
        return this.em.getReference(this.entityClass, Integer.valueOf(entityID));
    }

    public List<T> findAll() {
        CriteriaQuery cq = this.em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(this.entityClass));
        return this.em.createQuery(cq).getResultList();
    }

    protected Object findOneResult(String namedQuery, Map<String, Object> parameters) {
        Object result = null;
        try {
            Query query = this.em.createNamedQuery(namedQuery);

            if ((parameters != null) && (!parameters.isEmpty())) {
                populateQueryParameters(query, parameters);
            }

            result = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No result found for named query: " + namedQuery);
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
        for (Map.Entry entry : parameters.entrySet()) {
            query.setParameter((String) entry.getKey(), entry.getValue());
        }
    }
}