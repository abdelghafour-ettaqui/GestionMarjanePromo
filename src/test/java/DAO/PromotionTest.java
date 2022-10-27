package DAO;

import metier.entity.PromoEntity;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class PromotionTest {

    @Test
    void get() {
    }

    @Test
    void createPromotionbyStoreAdmin() throws ParseException {
        Promotion promo = new Promotion();
        PromoEntity promoEntity = new PromoEntity();

        String startDate="2022-11-01";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(startDate);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        String endDate="2022-12-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = sdf.parse(endDate);
        java.sql.Date sqlEndDate = new java.sql.Date(date1.getTime());

        promoEntity.setStartdate(sqlStartDate);
        promoEntity.setEnddate(sqlEndDate);
        promoEntity.setPercentage("50");
        promoEntity.setStatus("pending");
        promoEntity.setIdcategory(1);
        promoEntity.setName("eid");



        promo.save(promoEntity);

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
}