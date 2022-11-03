package services;

import DAO.Responsible;
import DAO.StoreAdmin;
import Email.SendingEmail;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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

        UsersEntity responsible = new UsersEntity();
        responsible.setEmail(request.getParameter("email"));
        responsible.setFullname(request.getParameter("fullname"));
        responsible.setPassword(request.getParameter("password"));
        responsible.setRole("Responsible");
        responsible.setIdstore(Integer.parseInt(request.getParameter("idStore")));
        responsible.setIdcategory(Integer.parseInt(request.getParameter("IdCategory")));
        Responsible Responsible = new Responsible();
        Responsible.save(responsible);
        String message = "hello, this your new account for managing you category \n the email is " + responsible.getEmail() + " the password is " + responsible.getPassword();
        SendingEmail.send(responsible.getEmail(), "new account", message);
        displayResponsible(request, response);


    }

    public static void updateResponsible(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersEntity responsible = new UsersEntity();

        responsible.setEmail(request.getParameter("email"));
        responsible.setFullname(request.getParameter("fullname"));
        responsible.setPassword(request.getParameter("password"));
        responsible.setRole("Responsible");
        responsible.setIdstore(Integer.parseInt(request.getParameter("idStore")));
        responsible.setIdcategory(Integer.parseInt(request.getParameter("IdCategory")));
        responsible.setIduser(Integer.parseInt(request.getParameter("idResponsible")));
        Responsible Responsible = new Responsible();
        Responsible.update(responsible);
        displayResponsible(request, response);
    }

    public static void displayResponsible(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        HttpSession session = request.getSession();
//        session.setAttribute("storeAdmin",);
        long idStore = 1;

        Responsible Responsible = new Responsible();
        List<UsersEntity> Responsibles = Responsible.getAll(idStore);

        request.setAttribute("Responsibles", Responsibles);

        request.getRequestDispatcher(".././Responsible/crudResponsible.jsp").forward(request, response);

    }


}
