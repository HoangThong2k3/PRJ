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

    private UserService userService;

    public void init() {
        userService = new UserServiceImpl();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String firstName = request.getParameter("txtFirstName");
        String lastName = request.getParameter("txtLastName");
        String email = request.getParameter("txtEmail");
        String phone = request.getParameter("txtPhone");
        String username = request.getParameter("username");
        String password = request.getParameter("txtPassword");

        log(password);

        try {
            boolean isRegisted = userService.register(new RegisterRequestDto(firstName, lastName, email, phone, username, password));
            if (isRegisted) {
                System.out.println("User is registered");
                response.sendRedirect("./home.jsp");
            } else {
                response.sendRedirect("./register.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }



}

