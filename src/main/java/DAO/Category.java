package DAO;

import jakarta.persistence.*;

import java.sql.SQLException;
import java.util.List;
import metier.entity.CategoryEntity;

public class Category implements Dao<CategoryEntity> {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public CategoryEntity get(long id) {

        CategoryEntity category = entityManager.find(CategoryEntity.class, id);

        return category;
    }

    @Override
    public List<CategoryEntity> getAll() {

        Query query = entityManager.createQuery("select c from CategoryEntity c");

        return query.getResultList();
    }

    @Override
    public void save( CategoryEntity category) {
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
    public void update(CategoryEntity category) {
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

            CategoryEntity category = entityManager.find(CategoryEntity.class, id);

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
