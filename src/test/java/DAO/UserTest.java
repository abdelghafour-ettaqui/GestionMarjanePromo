package DAO;

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
        String email = "ettaqui@gmail.com", password = "test";
        boolean res = User.validate(email, password);
        assertTrue(res);
    }

    @Test
    void testValidateMethodWithInvalidEmailAndPassword() {
        String email = "eaqui@gmail.com", password = "test";
        boolean res = User.validate(email, password);
        assertFalse(res);
    }
}