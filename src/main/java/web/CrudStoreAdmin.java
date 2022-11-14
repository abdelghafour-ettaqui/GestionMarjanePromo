package web;

import DAO.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

import services.CrudStoreAdminService;

@WebServlet({"/crudStoreAdmin", "/crudStoreAdmin/displayStoreAdmin", "/crudStoreAdmin/delete", "/crudStoreAdmin/addStoreAdmin", "/crudStoreAdmin/updateStoreAdmin"})
@MultipartConfig
public class CrudStoreAdmin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        if (session.getAttribute("auth") == null) {
            response.sendRedirect("http://localhost/marjane_war_exploded/Login/Login.jsp");
        } else if (path.equals("/crudStoreAdmin/displayStoreAdmin")) {

            CrudStoreAdminService.displayStoreAdmin(request, response);


        } else if (path.equals("/crudStoreAdmin/delete")) {

            try {
                CrudStoreAdminService.deleteStoreAdmin(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        if (session.getAttribute("auth") == null) {
            response.sendRedirect("http://localhost/marjane_war_exploded/Login/Login.jsp");
        } else if (path.equals("/crudStoreAdmin/addStoreAdmin")) {
            System.out.println("hello add");
            CrudStoreAdminService.AddStoreAdmin(request, response);
        } else if (path.equals("/crudStoreAdmin/updateStoreAdmin")) {
            CrudStoreAdminService.updateStoreAdmin(request, response);
        }
    }
}
