package services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Login {

    public static void Update(HttpServletRequest request, HttpServletResponse response,int idUser) throws ServletException, IOException {

        request.setAttribute("idUser",idUser);
        request.getRequestDispatcher(".././Login/set-password.jsp").forward(request,response);

    }
}
