package com.snack_shop.controller.users;

import com.snack_shop.dto.response.user.UserResponseDto;
import com.snack_shop.service.UserService;
import com.snack_shop.service.impl.UserServiceImpl;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchUserByNameController", value = "/SearchUserByNameController")
public class SearchUserByNameController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService userService;

    public void init() {
        userService = new UserServiceImpl();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            List<UserResponseDto> users = userService.getUserByName(request.getParameter("txtName"));
            request.setAttribute("SEARCH_USER_LIST", users);
        } catch (Exception e) {
            log("ERROR at SearchUserByNameController: " + e.getMessage());
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

