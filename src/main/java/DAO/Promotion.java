package DAO;

import jakarta.persistence.*;
import metier.entity.Users;


import java.sql.SQLException;
import java.util.List;

public class Promotion implements Dao<Object> {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public Object get(long id) {

        metier.entity.Promotion promotion = entityManager.find(metier.entity.Promotion.class, id);

        return promotion;

    }

    @Override
    public List<Object> getAll() {

        Query query = entityManager.createQuery("select p from Promotion p");
        return query.getResultList();

    }

    @Override
    public void save(Object promotion) {

        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(promotion);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();

        }

    }

    @Override
    public void update(Object promotion) {
        try {
            transaction.begin();

            entityManager.merge(promotion);

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

            metier.entity.Promotion promotion = entityManager.find(metier.entity.Promotion.class, id);

            entityManager.remove(promotion);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }
}
