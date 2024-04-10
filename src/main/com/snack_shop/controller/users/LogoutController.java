package com.snack_shop.controller.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutController", urlPatterns = "/logout")
public class LogoutController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("userInfo");
        session.invalidate();
        response.sendRedirect("./home.jsp");
    }
}