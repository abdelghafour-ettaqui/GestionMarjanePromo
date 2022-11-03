package DAO;

import jakarta.persistence.*;
import metier.entity.UsersEntity;
import metier.entity.PromoEntity;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class Promotion implements Dao<PromoEntity> {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public PromoEntity get(long id) {

        PromoEntity promotion = entityManager.find(PromoEntity.class, id);

        return promotion;

    }

    @Override
    public List<PromoEntity> getAll() {

        Query query = entityManager.createQuery("select p from PromoEntity p");
        return query.getResultList();

    }

    public List<PromoEntity> getAll(java.sql.Date currentDate,long idStore) {
//        Query query = entityManager.createQuery("SELECT p FROM PromoEntity p WHERE p.idstore= '"+idStore+"' AND p.status='pending' AND p.startdate <= '"+currentDate+"' AND p.enddate >= '"+currentDate+"'");
        Query query = entityManager.createQuery("SELECT p FROM PromoEntity p WHERE p.idstore= '"+idStore+"'  AND p.startdate <= '"+currentDate+"' AND p.enddate >= '"+currentDate+"'");
        return query.getResultList();
    }

    @Override
    public void save(PromoEntity promotion) {

        EntityTransaction transaction = entityManager.getTransaction();
        try {
            System.out.println(promotion.getIdcategory());

            transaction.begin();

            entityManager.persist(promotion);

            transaction.commit();

        } catch (Exception e) {

            transaction.rollback();

            e.printStackTrace();

        }

    }

    @Override
    public void update(PromoEntity promotion) {
        try {
            transaction.begin();
//            PromoEntity promotion = entityManager.find(PromoEntity.class, id);

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

            PromoEntity promotion = entityManager.find(PromoEntity.class, id);

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
