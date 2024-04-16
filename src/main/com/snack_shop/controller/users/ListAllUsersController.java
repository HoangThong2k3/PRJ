package com.snack_shop.controller.users;

import com.snack_shop.dto.response.user.UserResponseDto;
import com.snack_shop.service.UserService;
import com.snack_shop.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainUserController", value = "/MainUserController")
public class ListAllUsersController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;
    public void init() {
        userService = new UserServiceImpl();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String searchValue = request.getParameter("txtSearchValue");
        try {
            List<UserResponseDto> users = userService.getAllUsers(searchValue);
            HttpSession session = request.getSession();
            session.setAttribute("userList", users);
            log("Saved Session!");
            response.sendRedirect("./AdminManagement.jsp");

        } catch (Exception e) {
            log("ERROR at ListAllUsersController: " + e.getMessage());
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

