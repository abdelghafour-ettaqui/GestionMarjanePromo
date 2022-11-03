package services;

import DAO.Promotion;
import DAO.StoreAdmin;
import Email.SendingEmail;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entity.PromoEntity;
import metier.entity.UsersEntity;

import java.io.IOException;
import java.sql.SQLException;
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

    public static void AddPromotion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersEntity storeAdmin = new UsersEntity();

        storeAdmin.setEmail(request.getParameter("email"));
        storeAdmin.setFullname(request.getParameter("fullname"));
        storeAdmin.setPassword(request.getParameter("password"));
        storeAdmin.setRole("StoreAdmin");
        storeAdmin.setIdstore(Integer.parseInt(request.getParameter("idStore")));
        StoreAdmin admin = new StoreAdmin();
        admin.save(storeAdmin);
        String message = "hello, this your new account for managing your store \n the email is " + storeAdmin.getEmail() + " the password is " + storeAdmin.getPassword();
        SendingEmail.send(storeAdmin.getEmail(), "new account", message);
        displayPromotion(request, response);


    }

    public static void updatePromotion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersEntity storeAdmin = new UsersEntity();
        storeAdmin.setEmail(request.getParameter("email"));
        storeAdmin.setFullname(request.getParameter("fullname"));
        storeAdmin.setPassword(request.getParameter("password"));
        storeAdmin.setRole("StoreAdmin");
        storeAdmin.setIdstore(Integer.parseInt(request.getParameter("idStore")));
        storeAdmin.setIduser(Integer.parseInt(request.getParameter("idStoreAdmin")));
        StoreAdmin admin = new StoreAdmin();
        admin.update(storeAdmin);
        displayPromotion(request, response);
    }

    public static void displayPromotion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StoreAdmin storeAdmin = new StoreAdmin();
        long idStore = 1;
        List<UsersEntity> StoreAdmins = storeAdmin.getAll();
        Promotion promo = new Promotion();
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        String startTime = "08:00";
        String endTime = "17:00";
        LocalTime sTime = LocalTime.parse(startTime);
        LocalTime eTime = LocalTime.parse(endTime);
        LocalTime t = LocalTime.parse(currentTime);

        int condition1 = t.compareTo(sTime);
        int condition2 = t.compareTo(eTime);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        if (condition1 >= 0 && condition2 <= 0) {

            System.out.println("test 2");
            System.out.println(date);
            List<PromoEntity> promotions = promo.getAll(date,idStore);


            request.setAttribute("Promotions", promotions);
        }
        request.getRequestDispatcher(".././Responsible/Dashboard.jsp").forward(request, response);


    }
}
