package DAO;

import metier.entity.PromoEntity;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class PromotionTest {

    @Test
    void getAllPromotionToResponsable() throws ParseException {
        Promotion promo = new Promotion();
        List<PromoEntity> promotions = new ArrayList<>();
        String currentTime =  LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        String startTime="08:00";
        String endTime="12:00";
        LocalTime sTime= LocalTime.parse(startTime);
        LocalTime eTime= LocalTime.parse(endTime);
        LocalTime t = LocalTime.parse(currentTime);

        int condition1 = t.compareTo(sTime);
        int condition2 = t.compareTo(eTime);

       assertTrue(condition1 >= 0 && condition2 <= 0);

        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        assertNotNull(promo.getAll(date,1));
        for(PromoEntity promoA:promo.getAll(date,1)){
            System.out.println(promoA.getStartdate());
        }






    }

    @Test
    void createPromotionForAllSubCategory() throws ParseException {
        Promotion promo = new Promotion();
        PromoEntity promoEntity = new PromoEntity();

        String currentTime =  LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        String startTime="08:00";
        String endTime="12:00";
        LocalTime sTime= LocalTime.parse(startTime);
        LocalTime eTime= LocalTime.parse(endTime);
        LocalTime t = LocalTime.parse(currentTime);

        int condition1 = t.compareTo(sTime);
        int condition2 = t.compareTo(eTime);

        assertTrue(condition1 >= 0 && condition2 <= 0);


        String startDate="2022-11-01";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(startDate);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        String endDate="2022-12-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = sdf.parse(endDate);
        java.sql.Date sqlEndDate = new java.sql.Date(date1.getTime());
        int percentage = Integer.parseInt("10");
        int idCategory=1;
        if( idCategory == 1 && percentage>20){
            System.out.println("for multimedia products the promotion should not be more than 20%");
            assertNotNull(null);
        }
        else if(percentage>50){
            System.out.print("promotion should not be greater than 50%");
            assertNotNull(null);
        }
        promoEntity.setStartdate(sqlStartDate);
        promoEntity.setEnddate(sqlEndDate);
        promoEntity.setPercentage("50");
        promoEntity.setStatus("pending");
        promoEntity.setIdcategory(1);
        promoEntity.setIdStore(1);
        promoEntity.setName("eid");
        promo.save(promoEntity);

    }

    @Test
    void createPromoForSubCategory() throws ParseException {

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


        int percentage = Integer.parseInt("50");
        int idCategory=1;
        if( idCategory == 1 && percentage>20){
            System.out.println("for multimedia products the promotion should not be more than 20%");
            assertNotNull(null);
        }
        else if(percentage>50){
            System.out.print("promotion should not be greater than 50%");
            assertNotNull(null);
        }
        promoEntity.setStartdate(sqlStartDate);
        promoEntity.setEnddate(sqlEndDate);
        promoEntity.setPercentage("50");
        promoEntity.setStatus("pending");
        promoEntity.setIdSubCategory(1);
        promoEntity.setName("eid");

        promo.save(promoEntity);
    }

    @Test
    void save() {
    }

    @Test
    void updatingPromotionStatusPenddingToAccepted() {
        Promotion promo = new Promotion();


        PromoEntity promotion = promo.get(13);

        promotion.setStatus("accepted");

        promotion.setIdpromo(13);

        promo.update(promotion);

    }
    @Test
    void updatingPromotionStatusPenddingToRefused() {
        Promotion promo = new Promotion();


        PromoEntity promotion = promo.get(13);

        promotion.setStatus("refused");

        promotion.setIdpromo(13);

        promo.update(promotion);

    }

    @Test
    void delete() {
    }
}