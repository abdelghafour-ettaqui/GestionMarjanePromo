package DAO;

import metier.entity.Users;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StoreAdminTest {

    @Test
    void get() {
        StoreAdmin storeAdmin = new StoreAdmin();

        assertNotNull(storeAdmin.get(3));
    }

    @Test
    void getAllMethodNotNull() {
        StoreAdmin storeAdmin = new StoreAdmin();

        assertNotNull(storeAdmin.getAll());
    }

    @Test
    void CheckIfSaveMethodGoesWell() {

        Users user = new Users("abdelghafour","email@gamil.com","password","StoreAdmin",1);


        StoreAdmin storeAdmin= new StoreAdmin();

        storeAdmin.save(user);

    }

    @Test
    void update() {
        StoreAdmin storeAdmin= new StoreAdmin();
        Users user = new Users("abdela","email@gamil.com","password","StoreAdmin",1);
        user.setIduser(5);

        storeAdmin.update(user);
    }

    @Test
    void delete() throws SQLException {
        StoreAdmin storeAdmin= new StoreAdmin();
        storeAdmin.delete(3);
    }
}