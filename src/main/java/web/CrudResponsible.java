package web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.CrudResponsibleService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet({"/crudResponsible","/Profile", "/CrudResponsible/displayResponsible", "/CrudResponsible/deleteResponsible", "/CrudResponsible/addResponsible", "/CrudResponsible/updateResponsible"})
@MultipartConfig
public class CrudResponsible extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        if (session.getAttribute("auth") == null) {
            response.sendRedirect("http://localhost/marjane_war_exploded/Login/Login.jsp");

        }
        else if (path.equals("/CrudResponsible/displayResponsible")) {

            CrudResponsibleService.displayResponsible(request, response);

        }
        else if (path.equals("/Profile")) {

            CrudResponsibleService.displayOneResponsible(request, response);

        }else if (path.equals("/CrudResponsible/deleteResponsible")) {
            try {
                CrudResponsibleService.deleteResponsible(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        if (session.getAttribute("auth")==null) {
            response.sendRedirect("http://localhost/marjane_war_exploded/Login/Login.jsp");
        }
       else if (path.equals("/CrudResponsible/addResponsible")) {
            CrudResponsibleService.AddResponsible(request, response);
        } else if (path.equals("/CrudResponsible/updateResponsible")) {
            CrudResponsibleService.updateResponsible(request, response);
        }
    }
}
