package DAO;

import jakarta.persistence.*;

import java.sql.SQLException;
import java.util.List;

public class Category implements Dao<metier.entity.Category> {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public metier.entity.Category get(long id) {

        metier.entity.Category category = entityManager.find(metier.entity.Category.class, id);

        return category;
    }

    @Override
    public List<metier.entity.Category> getAll() {
        Query query = entityManager.createQuery("select c from Category c");
        return query.getResultList();
    }

    @Override
    public void save(metier.entity.Category category) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(category);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();

        }

    }

    @Override
    public void update(metier.entity.Category category) {
        try {
            transaction.begin();

            entityManager.merge(category);

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

            metier.entity.Category category = entityManager.find(metier.entity.Category.class, id);

            entityManager.remove(category);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }


}
