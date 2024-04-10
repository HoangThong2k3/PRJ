package com.snack_shop.controller.users;

import com.snack_shop.dto.request.user.LoginRequestDto;
import com.snack_shop.dto.response.user.UserResponseDto;
import com.snack_shop.service.UserService;
import com.snack_shop.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 2860215007883522580L;

    private UserService authService;

    public void init() {
        authService = new UserServiceImpl();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {

            UserResponseDto userInfo = authService.login(new LoginRequestDto(username, password));
            System.out.println(userInfo);
            if (userInfo != null) {
                // TODO: save login info into session.
                HttpSession session = request.getSession();
                session.setAttribute("userInfo", userInfo);
                log("Saved Session!");
                response.sendRedirect("./home.jsp");
            } else {
                log("Wrong username or password");
                response.sendRedirect("./llogin.jsp?err=");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}