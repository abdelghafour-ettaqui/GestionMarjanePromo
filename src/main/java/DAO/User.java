package DAO;

import jakarta.persistence.*;
import metier.entity.StoreEntity;
import metier.entity.UsersEntity;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class User implements Dao<UsersEntity> {
    private  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    private  EntityManager entityManager = entityManagerFactory.createEntityManager();
    private  EntityTransaction transaction = entityManager.getTransaction();


    @Override
    public UsersEntity get(long id) {

        UsersEntity user = entityManager.find(UsersEntity.class, id);

        return user;
    }

    @Override
    public List<UsersEntity> getAll() {
        return null;
    }

    @Override
    public void save(UsersEntity users) {


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

    }

    public  UsersEntity validate(String email, String password) {


        try {
            transaction.begin();

            Query query = entityManager.createQuery("select u from UsersEntity u where u.email = :email ").setParameter("email", email);

            UsersEntity user = (UsersEntity) query.getSingleResult();


            System.out.println("------------------------------------------------------------ " + user.getFullname());

            if ( user.getPassword().equals(password)) {
                return user;
            }
            transaction.commit();



        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
            e.printStackTrace();

        }
        finally {
            entityManager.close();
        }
        return null;
    }
}