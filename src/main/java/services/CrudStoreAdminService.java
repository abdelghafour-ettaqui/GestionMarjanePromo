package services;

import DAO.StoreAdmin;
import Email.SendingEmail;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entity.UsersEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CrudStoreAdminService {

    public static void deleteStoreAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        StoreAdmin storeAdmin = new StoreAdmin();
        storeAdmin.delete(id);
        displayStoreAdmin(request,response);

    }
    public static void AddStoreAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersEntity storeAdmin = new UsersEntity();

        storeAdmin.setEmail(request.getParameter("email"));
        storeAdmin.setFullname(request.getParameter("fullname"));
        storeAdmin.setPassword(request.getParameter("password"));
        storeAdmin.setRole("StoreAdmin");
        storeAdmin.setIdstore(Integer.parseInt(request.getParameter("idStore")));
        StoreAdmin admin = new StoreAdmin();
        admin.save(storeAdmin);
        String message="hello, this your new account for managing your store \n the email is "+storeAdmin.getEmail()+" the password is "+storeAdmin.getPassword();
        SendingEmail.send(storeAdmin.getEmail(),"new account",message);
        displayStoreAdmin(request,response);


    }
    public static void updateStoreAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersEntity storeAdmin = new UsersEntity();
        storeAdmin.setEmail(request.getParameter("email"));
        storeAdmin.setFullname(request.getParameter("fullname"));
        storeAdmin.setPassword(request.getParameter("password"));
        storeAdmin.setRole("StoreAdmin");
        storeAdmin.setIdstore(Integer.parseInt(request.getParameter("idStore")));
        storeAdmin.setIduser(Integer.parseInt(request.getParameter("idStoreAdmin")));
        StoreAdmin admin = new StoreAdmin();
        admin.update(storeAdmin);
        displayStoreAdmin(request,response);
    }
    public static void displayStoreAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StoreAdmin storeAdmin = new StoreAdmin();
        List<UsersEntity> StoreAdmins = storeAdmin.getAll();

        request.setAttribute("storeAdmins",StoreAdmins);
        request.getRequestDispatcher(".././SuperAdmin/crudStoreAdmin.jsp").forward(request,response);

    }


}
