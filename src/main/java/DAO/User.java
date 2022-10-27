package DAO;

import jakarta.persistence.Query;
import metier.entity.UsersEntity;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class User implements Dao<UsersEntity> {


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

    public static boolean validate(String email, String password) {

        Transaction transaction = null;

        try {

            Query query = Connection.getEntityManager().createQuery("select u from UsersEntity u where u.email = :email ").setParameter("email", email);

            UsersEntity user = (UsersEntity) query.getSingleResult();


            System.out.println("------------------------------------------------------------ " + user.getFullname());

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
        return false;
    }
}