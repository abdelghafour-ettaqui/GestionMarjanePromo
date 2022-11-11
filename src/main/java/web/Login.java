package web;

import DAO.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import metier.entity.UsersEntity;
import services.*;

import java.io.IOException;

@WebServlet({"/Login","/updatePassword"})
@MultipartConfig
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("idStore");
        session.invalidate();
        response.sendRedirect("Login/Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        System.out.println(path);
        if (path.equals("/Login")) {

            try {
                authenticate(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }


        } else if (path.equals("/updatePassword")) {
            try{
                updatePassword(request,response);
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }

    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User users = new User();

        String role = request.getParameter("role");

        UsersEntity user = users.validate(email,password);

        HttpSession session = request.getSession();

        System.out.println("test test");

        if (user != null && role.equals(user.getRole())) {
            if( user.getStatus().equals("inactive") ){

                request.setAttribute("idUser",user.getIduser());
                request.getRequestDispatcher(".././Login/setPassword.jsp").forward(request, response);
            }
            else if (user.getRole().equals("Responsible")) {
                session.setAttribute("idCategory", user.getIdcategory());
                session.setAttribute("idStore", user.getIdstore());
                response.sendRedirect("http://localhost/marjane_war_exploded/promotion/displayPromotion");

            } else if (user.getRole().equals("superAdmin")) {
                session.setAttribute("idStore", user.getIdstore());
                response.sendRedirect("http://localhost/marjane_war_exploded/crudStoreAdmin/displayStoreAdmin");

            } else if (user.getRole().equals("StoreAdmin")) {

                session.setAttribute("idStore", user.getIdstore());

                response.sendRedirect("http://localhost/marjane_war_exploded/CrudResponsible/displayResponsible");
            }

        } else {
            throw new Exception("Login not successfull...");
        }
    }

    public static void updatePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String password = request.getParameter("password");

        String confirmPassword = request.getParameter("confirmPassword");

        String idUser = request.getParameter("idUser");
        if(!password.equals(confirmPassword)){
            System.out.println("invalid password");
        }
        else{
            UsersEntity user = new UsersEntity();
            User users= new User();
            user.setStatus("valid");
            user.setPassword(password);
            user.setIduser(Integer.parseInt(idUser));
            users.update(user);
            response.sendRedirect("Login/Login.jsp");
        }


    }


}
