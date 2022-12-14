package DAO;

import jakarta.persistence.*;

import java.sql.SQLException;
import metier.entity.StoreEntity;
import java.util.List;

public class Store implements Dao<StoreEntity> {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();


    @Override
    public StoreEntity get(long id) {

        StoreEntity store = entityManager.find(StoreEntity.class, id);

        return store;
    }

    @Override
    public List<StoreEntity> getAll() {
        Query query = entityManager.createQuery("select s from StoreEntity s");
        return query.getResultList();
    }

    @Override
    public void save(StoreEntity store) {
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
    public void update(StoreEntity store) {
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

            StoreEntity store = entityManager.find(StoreEntity.class, id);

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
