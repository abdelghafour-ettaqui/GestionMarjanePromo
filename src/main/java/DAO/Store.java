package DAO;

import jakarta.persistence.*;

import java.sql.SQLException;
import java.util.List;

public class Store implements Dao<metier.entity.Store> {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();


    @Override
    public metier.entity.Store get(long id) {

        metier.entity.Store store = entityManager.find(metier.entity.Store.class, id);

        return store;
    }

    @Override
    public List<metier.entity.Store> getAll() {
        Query query = entityManager.createQuery("select s from Store s");
        return query.getResultList();
    }

    @Override
    public void save(metier.entity.Store store) {
        try {
            transaction.begin();
            entityManager.persist(store);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();

        }

    }

    @Override
    public void update(metier.entity.Store store) {
        try {
            transaction.begin();

            entityManager.merge(store);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }

    @Override
    public void delete(long id) throws SQLException {
        try {
            transaction.begin();

            metier.entity.Store store = entityManager.find(metier.entity.Store.class, id);

            entityManager.remove(store);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}
