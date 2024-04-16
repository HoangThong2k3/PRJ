package com.snack_shop.controller.users;

import com.snack_shop.dto.request.user.UpdateRequestDto;
import com.snack_shop.service.UserService;
import com.snack_shop.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateAccountInfoController", value = "/UpdateAccountInfoController")
public class UpdateAccountInfoController extends HttpServlet {
    UserService userService;

    public void init() {
        userService = new UserServiceImpl();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String avatar = request.getParameter("avatar");
        String password = request.getParameter("password");
        String username = request.getParameter("username");

        try {
            userService.updateUser(new UpdateRequestDto(username, password, firstName, lastName, email, address, phone, avatar, null));
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

