package services;

import DAO.*;
import Email.SendingEmail;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.entity.CategoryEntity;
import metier.entity.StoreEntity;
import metier.entity.SubcategoryEntity;
import metier.entity.UsersEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CrudResponsibleService {

    public static void deleteResponsible(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        Responsible responsible = new Responsible();
        responsible.delete(id);
        displayResponsible(request, response);

    }

    public static void AddResponsible(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int generatedPassword = (int) ((Math.random() * (999999999 - 111111111)) + 111111111);
        HttpSession session = request.getSession();

        int idStore = Integer.parseInt(session.getAttribute("idStore").toString()) ;
        UsersEntity responsible = new UsersEntity();

        responsible.setEmail(request.getParameter("email"));
        responsible.setFullname(request.getParameter("fullname"));
        responsible.setPassword(Integer.toString(generatedPassword));
        responsible.setRole("Responsible");
        responsible.setIdstore(idStore);
        responsible.setIdcategory(Integer.parseInt(request.getParameter("IdCategory")));
        responsible.setStatus("inactive");
        Responsible Responsible = new Responsible();
        Responsible.save(responsible);
        String message = "hello, this your new account for managing you category \n the email is " + responsible.getEmail() + " the password is " + responsible.getPassword();
        SendingEmail.send(responsible.getEmail(), "new account", message);
        displayResponsible(request, response);


    }

    public static void updateResponsible(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Responsible Responsible = new Responsible();
        UsersEntity responsible= Responsible.get(Integer.parseInt(request.getParameter("idResponsible")));
        responsible.setEmail(request.getParameter("email"));
        responsible.setFullname(request.getParameter("fullname"));
        responsible.setRole("Responsible");
//        responsible.setIdstore(Integer.parseInt(request.getParameter("idStore")));
        responsible.setIdcategory(Integer.parseInt(request.getParameter("IdCategory")));
        Responsible.update(responsible);
        displayResponsible(request, response);
    }

    public static void displayResponsible(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        long idStore = Long.parseLong(session.getAttribute("idStore").toString()) ;

        Responsible Responsible = new Responsible();
        Category category = new Category();
        SubCategory subCategory = new SubCategory();
        Store store = new Store();

        List<UsersEntity> Responsibles = Responsible.getAll(idStore);
        List<CategoryEntity> categories = category.getAll();
        List<SubcategoryEntity> subCategories = subCategory.getAll();
        List<StoreEntity> stores = store.getAll();



        request.setAttribute("Responsibles", Responsibles);
        request.setAttribute("categories", categories);
        request.setAttribute("subCategories", subCategories);
        request.setAttribute("stores", stores);

        request.getRequestDispatcher(".././Responsible/crudResponsible.jsp").forward(request,response);

    }
    public static void displayOneResponsible(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        long idUser = Long.parseLong(session.getAttribute("idUser").toString()) ;

        Responsible Responsible = new Responsible();

        System.out.println(idUser);
        UsersEntity responsible = Responsible.get(idUser);

        request.setAttribute("responsible", responsible);

        request.getRequestDispatcher("./Responsible/Profile.jsp").forward(request,response);



}



}
