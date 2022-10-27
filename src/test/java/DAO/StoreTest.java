package DAO;

import metier.entity.StoreEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }

    @Test
    void save() {
        StoreEntity store = new StoreEntity();

        store.setCity("Safi");
        store.setIdstoreadmin(1);
        Store str = new Store();
        str.save(store);

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}