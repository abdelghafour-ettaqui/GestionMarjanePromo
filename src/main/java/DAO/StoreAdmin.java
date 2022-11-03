package DAO;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import metier.entity.UsersEntity;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class StoreAdmin implements Dao<UsersEntity> {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public UsersEntity get(long id) {

        UsersEntity user = entityManager.find(UsersEntity.class, id);

        return user;
    }


    @Override
    public List<UsersEntity> getAll() {

        Query query = Connection.getEntityManager().createQuery("select u from UsersEntity u where u.role= :role ").setParameter("role", "StoreAdmin");
        return query.getResultList();
    }

    @Override
    public void save(UsersEntity user) {

        System.out.println(user.toString());
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(UsersEntity users) {

        try {
            transaction.begin();

            entityManager.merge(users);

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

            UsersEntity user = entityManager.find(UsersEntity.class, id);

            entityManager.remove(user);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }
}
