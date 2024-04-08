package com.snack_shop.controller.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get Session from server
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            response.sendRedirect("./");
            return;
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // get UserSerivce instance
        UserService userService = ServiceSingleton.getUserServiceInstance();

        if (userService.login(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            Cookie cookieUserName = new Cookie("username", username);
            Cookie cookiePassword = new Cookie("password", password);
            cookieUserName.setMaxAge(60 * 3);
            cookiePassword.setMaxAge(60 * 3);
            response.addCookie(cookieUserName);
            response.addCookie(cookiePassword);
            response.sendRedirect("./");
        } else {
            response.sendRedirect("./login");
        }

    }
}