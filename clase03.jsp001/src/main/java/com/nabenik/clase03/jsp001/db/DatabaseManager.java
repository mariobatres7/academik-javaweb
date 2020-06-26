package com.nabenik.clase03.jsp001.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Mario Batres
 */
public class DatabaseManager {

    private static EntityManagerFactory entityManagerFactory = null;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("TiendaPU");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static <T> T find(EntityManager entityManager, Class<T> clazz, Object id) {
        return entityManager.find(clazz, id);
    }

    public static <T> List<T> findAll(EntityManager entityManager, Class<T> clazz) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(clazz);

        query.from(clazz);

        var resultList = entityManager.createQuery(query).getResultList();

        return resultList;
    }

}
