package web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;

import services.PromotionService;

@WebServlet({"/promotion", "/promotion/updatePromotion", "/promotion/createPromotion", "/promotion/displayPromotion", "/promotion/displayPromotion/filtered"})
@MultipartConfig
public class Promotion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        HttpSession session = request.getSession();
        if (session.getAttribute("auth") == null) {
            response.sendRedirect("http://localhost/marjane_war_exploded/Login/Login.jsp");

        } else if (path.equals("/promotion/displayPromotion")) {

            PromotionService.displayPromotion(request, response, false, null);
        } else if (path.equals("/promotion/displayPromotion/filtered")) {
        
            String status = request.getParameter("status");
            PromotionService.displayPromotion(request, response, true, status);
        } else if (path.equals("/promotion/updatePromotion")) {
            PromotionService.updatePromotion(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        if (session.getAttribute("auth") == null) {
            response.sendRedirect("http://localhost/marjane_war_exploded/Login/Login.jsp");
        } else if (path.equals("/promotion/createPromotion")) {
            try {
                PromotionService.AddPromotion(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
