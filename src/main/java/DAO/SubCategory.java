package DAO;

import jakarta.persistence.*;
import metier.entity.SubcategoryEntity;
import metier.entity.UsersEntity;

import java.sql.SQLException;
import java.util.List;

public class SubCategory implements Dao<metier.entity.SubcategoryEntity> {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public SubcategoryEntity get(long id) {

        SubcategoryEntity subCategory = entityManager.find(SubcategoryEntity.class, id);

        return subCategory;
    }

    @Override
    public List<SubcategoryEntity> getAll() {
        Query query = entityManager.createQuery("select s from SubcategoryEntity s");
        return query.getResultList();
    }

    @Override
    public void save(SubcategoryEntity subcategory) {
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
    public void update(SubcategoryEntity subcategory) {
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

            metier.entity.SubcategoryEntity subcategory = entityManager.find(metier.entity.SubcategoryEntity.class, id);

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
