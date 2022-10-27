package DAO;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import metier.entity.Users;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class StoreAdmin implements Dao<Users> {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("marjane");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public Users get(long id) {

        Users user = entityManager.find(Users.class, id);

        return user;
    }


    @Override
    public List<Users> getAll() {

        Query query = Connection.getEntityManager().createQuery("select u from Users u where u.role= :role ").setParameter("role", "storeAdmin");
        return query.getResultList();
    }

    @Override
    public void save(Users user) {


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
    public void update(Users users) {

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

            Users user = entityManager.find(Users.class, id);

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
