package services;

import DAO.Promotion;
import DAO.Responsible;
import DAO.StoreAdmin;
import Email.SendingEmail;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.entity.PromoEntity;
import metier.entity.UsersEntity;
import services.CrudResponsibleService;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PromotionService {
    public static void deletePromotion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        StoreAdmin storeAdmin = new StoreAdmin();
        storeAdmin.delete(id);
        displayPromotion(request, response);

    }

    public static void AddPromotion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        Promotion promo = new Promotion();
        PromoEntity promoEntity = new PromoEntity();

        String startDate=request.getParameter("startDate");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(startDate);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

        String endDate=request.getParameter("endDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = sdf.parse(endDate);
        java.sql.Date sqlEndDate = new java.sql.Date(date1.getTime());


        int percentage =Integer.parseInt(request.getParameter("percentage"));

        int idCategory=Integer.parseInt(request.getParameter("category"));
        int idSubCategory=Integer.parseInt(request.getParameter("subcategory"));

        System.out.println("1 "+startDate+" 2 "+endDate+" 3 "+request.getParameter("percentage")+" 4 "+idSubCategory+" 5 "+request.getParameter("name")+" 6 "+idCategory+" 7");
        if( idCategory == 1 && percentage>20){

            System.out.println("for multimedia products the promotion should not be more than 20%");

        }
        else if(percentage>50){
            System.out.print("promotion should not be greater than 50%");

        }

        promoEntity.setStartdate(sqlStartDate);
        promoEntity.setEnddate(sqlEndDate);
        promoEntity.setPercentage(request.getParameter("percentage"));
        promoEntity.setStatus("pending");
        promoEntity.setIdsubcategory(idSubCategory);
        promoEntity.setName(request.getParameter("name"));
        promoEntity.setIdstore(1);
        promoEntity.setIdcategory(idCategory);
        promo.save(promoEntity);

        CrudResponsibleService.displayResponsible(request, response);


    }

    public static void updatePromotion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PromoEntity promo = new PromoEntity();
        Promotion promotion = new Promotion();
        System.out.println("test teste testetsettet"+request.getParameter("idPromo"));
        promo = promotion.get(Integer.parseInt(request.getParameter("idPromo")));
        promo.setStatus(request.getParameter("status"));
        promotion.update(promo);

    }

    public static void displayPromotion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StoreAdmin storeAdmin = new StoreAdmin();
        HttpSession session = request.getSession();

        long idStore = Long.parseLong(session.getAttribute("idStore").toString()) ;
//        long idStore = 1;
        List<UsersEntity> StoreAdmins = storeAdmin.getAll();
        
        Promotion promo = new Promotion();
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        String startTime = "08:00";
        String endTime = "19:00";
        LocalTime sTime = LocalTime.parse(startTime);
        LocalTime eTime = LocalTime.parse(endTime);
        LocalTime t = LocalTime.parse(currentTime);

        int condition1 = t.compareTo(sTime);
        int condition2 = t.compareTo(eTime);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        if (condition1 >= 0 && condition2 <= 0) {

            List<PromoEntity> promotions = promo.getAll(date,idStore);

            request.setAttribute("Promotions", promotions);
        }
        request.getRequestDispatcher(".././Responsible/Dashboard.jsp").forward(request, response);


    }
}
