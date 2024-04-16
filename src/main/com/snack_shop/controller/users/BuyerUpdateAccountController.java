package com.snack_shop.controller.users;

import com.snack_shop.dto.request.user.UpdateRequestDto;
import com.snack_shop.dto.response.user.UserResponseDto;
import com.snack_shop.enums.UserRole;
import com.snack_shop.service.UserService;
import com.snack_shop.service.impl.UserServiceImpl;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BuyerUpdateAccountController", value = "/BuyerUpdateAccountController")
public class BuyerUpdateAccountController extends HttpServlet {
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
        String password = request.getParameter("txtPassword");
        String firstName = request.getParameter("txtFirstName");
        String lastName = request.getParameter("txtLastName");
        String address = request.getParameter("txtAddress");
        String email = request.getParameter("txtEmail");
        String phone = request.getParameter("txtPhone");
        String avatar = request.getParameter("txtAvatar");

        String searchValue = request.getParameter("lastSearchValue");
        String url = ERROR_PAGE;
        try {
            UpdateRequestDto buyer = new UpdateRequestDto(username, password, firstName, lastName, email, address, phone, avatar, UserRole.BUYER);
            boolean result = userService.updateUser(buyer);
        } catch (SQLException ex) {
            log("ERROR at BuyerUpdateAccountController: " + ex.getMessage());
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

