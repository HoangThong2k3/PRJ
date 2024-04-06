package com.thong.pokemon.controllers;

import com.thong.pokemon.services.ServiceSingleton;
import com.thong.pokemon.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeController", urlPatterns = {"/", "/home"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookies [] = request.getCookies();
        if (cookies != null) {
            String username = null;
            String password = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    request.setAttribute("username", cookie.getValue());
                }
                if (cookie.getName().equals("password")) {
                    request.setAttribute("password", cookie.getValue());
                }
                UserService userService = ServiceSingleton.getUserServiceInstance();

                if (userService.login(username, password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                }
            }
        }

        //get Session from server
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            request.setAttribute("username", session.getAttribute("username"));
        }
        System.out.println("HomeController");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}