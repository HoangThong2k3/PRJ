package com.snack_shop.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeController", urlPatterns = {"/", "/home"})
public class HomeController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get Session from server
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userInfo") != null) {
            request.setAttribute("userInfo", session.getAttribute("userInfo"));
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(request, response);
    }
}