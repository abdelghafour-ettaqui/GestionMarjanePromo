package web;

import DAO.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "crudStoreAdmin", value = "/crudStoreAdmin")
public class crudStoreAdmin extends HttpServlet {

    private User user;

    @Override
    public void init() throws ServletException {
        user = new User();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
