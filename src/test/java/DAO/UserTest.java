package DAO;

import metier.entity.UsersEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void testValidateMethodWithValidEmailAndPassword() {
        String email = "superAdmin@gmail.com", password = "password";
//        UsersEntity res = User.validate(email, password);

//        assertNotNull(res);
    }

    @Test
    void testValidateMethodWithInvalidEmailAndPassword() {
        String email = "eaqui@gmail.com", password = "test";
//        UsersEntity res = User.validate(email, password);
//        assertNull(res);
    }
}