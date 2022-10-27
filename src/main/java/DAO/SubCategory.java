package DAO;

import jakarta.persistence.*;
import metier.entity.Subcategory;
import metier.entity.Users;

import java.sql.SQLException;
import java.util.List;

public class SubCategory implements Dao<metier.entity.Subcategory> {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public Subcategory get(long id) {

        Subcategory subCategory = entityManager.find(Subcategory.class, id);

        return subCategory;
    }

    @Override
    public List<Subcategory> getAll() {
        Query query = entityManager.createQuery("select s from Subcategory s");
        return query.getResultList();
    }

    @Override
    public void save(Subcategory subcategory) {
        try {
            transaction.begin();
            entityManager.persist(subcategory);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();

        }
    }

    @Override
    public void update(Subcategory subcategory) {
        try {
            transaction.begin();

            entityManager.merge(subcategory);

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

            metier.entity.Subcategory subcategory = entityManager.find(metier.entity.Subcategory.class, id);

            entityManager.remove(subcategory);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}
