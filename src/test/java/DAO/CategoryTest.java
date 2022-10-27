package DAO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void get() {

    }

    @Test
    void getAll() {
        Category category = new Category();
        long idStoreAdmin=1;
        assertNotNull(category.getAll(idStoreAdmin));
    }
    @Test
    void getAllPromoWithSpecificCategory() {
        Category category = new Category();
        long idStoreAdmin=1;
        String name = "test";
        assertNotNull(category.getAll(idStoreAdmin,name));
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
}