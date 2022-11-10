package web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;

import services.PromotionService;
@WebServlet({"/promotion","/promotion/updatePromotion","/promotion/createPromotion","/promotion/displayPromotion"})
@MultipartConfig
public class Promotion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(path.equals("/promotion/displayPromotion")){
            System.out.println("test 1");
            PromotionService.displayPromotion(request,response);
        }else if (path.equals("/promotion/updatePromotion")) {
            PromotionService.updatePromotion(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/promotion/createPromotion")){
            try {
                PromotionService.AddPromotion(request,response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
