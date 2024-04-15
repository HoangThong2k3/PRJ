package com.snack_shop.controller.users;


import com.snack_shop.dto.request.user.RegisterRequestDto;
import com.snack_shop.service.UserService;
import com.snack_shop.service.impl.UserServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {

    private UserService authService;

    public void init() {
        authService = new UserServiceImpl();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String firstName = request.getParameter("txtFirstName");
        String lastName = request.getParameter("txtLastName");
        String email = request.getParameter("txtEmail");
        String phone = request.getParameter("txtPhone");
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");

        try {
            boolean isRegisted = authService.register(new RegisterRequestDto(firstName, lastName, email, phone, username, password));
            if (isRegisted) {
                System.out.println("User is registered");
                response.sendRedirect("./home.jsp");
            } else {
                System.out.println("User is not registered");
                response.sendRedirect("./register.jsp");
            }
        } catch (Exception e) {
            log("ERROR at RegisterController: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }


}

