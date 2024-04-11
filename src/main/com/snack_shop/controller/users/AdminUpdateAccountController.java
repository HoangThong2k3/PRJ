package com.snack_shop.controller.users;

import com.snack_shop.service.UserService;
import com.snack_shop.service.impl.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminUpdateAccountController", value = "/AdminUpdateAccountController")
public class AdminUpdateAccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String ERROR_PAGE = "error.html";
    UserService userService;

    public void init() {
        userService = new UserServiceImpl();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("txtUsername");

        String firstName = request.getParameter("txtFirstName");
        String lastName = request.getParameter("txtLastName");
        String role = request.getParameter("txtRole");

        String searchValue = request.getParameter("lastSearchValue");
        String url = ERROR_PAGE;
        try {
            boolean result = userService.deleteUser(username);

            if (result) {
                url = "UserDispatchController"
                    + "?btAction=Search"
                    + "&lastSearchValue=" + searchValue;
            }

        } catch (SQLException ex) {
            log("ERROR at DeleteUserController: " + ex.getMessage());
        }
        finally {
            response.sendRedirect(url);
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

