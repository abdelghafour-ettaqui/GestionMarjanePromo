package web;

import DAO.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Login/Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            authenticate(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void authenticate (HttpServletRequest request,HttpServletResponse response) throws Exception{
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(User.validate(email,password)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login/login-success.jsp");
            dispatcher.forward(request,response);
        }else{
            throw new Exception("Login not successfull...");
        }
    }




}
