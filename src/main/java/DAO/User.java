package DAO;

import jakarta.persistence.Query;
import metier.entity.Users;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class User implements Dao<Users> {


    @Override
    public Users get(long id) {
        return null;
    }

    @Override
    public List<Users> getAll() {
        return null;
    }

    @Override
    public void save(Users users) {


    }

    @Override
    public void update(Users users) {

    }

    @Override
    public void delete(long id) throws SQLException {

    }

    public static boolean validate(String email, String password) {

        Transaction transaction = null;

        try {

            Query query = Connection.getEntityManager().createQuery("select u from Users u where u.email = :email ").setParameter("email", email);

            metier.entity.Users user = (metier.entity.Users) query.getSingleResult();


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