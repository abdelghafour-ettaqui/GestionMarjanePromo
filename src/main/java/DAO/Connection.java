package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Connection {


    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    }

    public static EntityManager getEntityManager() {
        entityManager = entityManagerFactory.createEntityManager();

        return entityManager;
    }


}
