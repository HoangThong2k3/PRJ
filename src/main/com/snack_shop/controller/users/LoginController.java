package com.snack_shop.controller.users;

import com.snack_shop.dto.request.user.LoginRequestDto;
import com.snack_shop.dto.response.user.UserResponseDto;
import com.snack_shop.service.UserService;
import com.snack_shop.service.impl.UserServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private UserService authService;

    public void init() {
        authService = new UserServiceImpl();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        System.out.println(username + " " + password);
        try {

            UserResponseDto userInfo = authService.login(new LoginRequestDto(username, password));
            System.out.println(userInfo);

            if (userInfo != null) {
                // TODO: save login info into session.
                HttpSession session = request.getSession();
                session.setAttribute("USER_INFO", userInfo);
                System.out.println("Login success");
                response.sendRedirect("./home.jsp");
            } else {
                log("Wrong username or password");
                response.sendRedirect("./login.jsp?err=");
            }
        } catch (Exception e) {
            log("ERROR at LoginController: " + e.getMessage());
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