package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Connection {


    private final static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }


}
