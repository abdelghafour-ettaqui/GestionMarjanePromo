package DAO;

import metier.entity.UsersEntity;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import Email.SendingEmail;

class ResponsibleTest {

    @Test
    void get() {
        Responsible responsible = new Responsible();

        assertNotNull(responsible.get(3));
    }

    @Test
    void getAllMethodNotNull() {
        Responsible responsible = new Responsible();

        assertNotNull(responsible.getAll());
    }

    @Test
    void CheckIfSaveMethodGoesWell() {

        UsersEntity user = new UsersEntity("abdelghafour","ettaqui88@gmail.com","password","responsible",1,1);


        Responsible responsible = new Responsible();

        responsible.save(user);
        String message="hello, this your new account for managing you category \n the email is "+user.getEmail()+" the password is "+user.getPassword();
        SendingEmail.send(user.getEmail(),"new account",message);


    }

    @Test
    void update() {
        Responsible responsible = new Responsible();
        UsersEntity user = new UsersEntity("abdela","email@gamil.com","password","StoreAdmin",1,1);
        user.setIduser(5);

        responsible.update(user);
    }

    @Test
    void delete() throws SQLException {
        Responsible responsible = new Responsible();
        responsible.delete(7);
    }


}