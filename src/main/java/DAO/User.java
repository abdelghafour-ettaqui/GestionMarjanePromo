package DAO;

import jakarta.persistence.*;
import metier.entity.UsersEntity;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class User implements Dao<UsersEntity> {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static EntityTransaction transaction = entityManager.getTransaction();


    @Override
    public UsersEntity get(long id) {
        return null;
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

    }

    @Override
    public void delete(long id) throws SQLException {

    }

    public static UsersEntity validate(String email, String password) {



        try {
            transaction.begin();

            Query query = entityManager.createQuery("select u from UsersEntity u where u.email = :email ").setParameter("email", email);

            UsersEntity user = (UsersEntity) query.getSingleResult();


            System.out.println("------------------------------------------------------------ " + user.getFullname());

            if ( user.getPassword().equals(password)) {
                return user;
            }
            transaction.commit();
            entityManager.close();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();

            }
            e.printStackTrace();

        }
        return null;
    }
}