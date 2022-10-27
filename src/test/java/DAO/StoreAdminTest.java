package DAO;

import metier.entity.UsersEntity;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import Email.SendingEmail;

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

        UsersEntity user = new UsersEntity("abdelghafour","ettaqui88@gmail.com","password","StoreAdmin",1);


        StoreAdmin storeAdmin= new StoreAdmin();

        storeAdmin.save(user);
        String message="hello, this your new account for managing your store \n the email is "+user.getEmail()+" the password is "+user.getPassword();
        SendingEmail.send(user.getEmail(),"new account",message);


    }

    @Test
    void update() {
        StoreAdmin storeAdmin= new StoreAdmin();
        UsersEntity user = new UsersEntity("abdela","email@gamil.com","password","StoreAdmin",1);
        user.setIduser(5);

        storeAdmin.update(user);
    }

    @Test
    void delete() throws SQLException {
        StoreAdmin storeAdmin= new StoreAdmin();
        storeAdmin.delete(3);
    }
}