package com.snack_shop.controller.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserDispatchController")
public class UserDispatchController extends HttpServlet {
    private final String LOGIN_PAGE = "home.jsp";
    private final String REGISTER_CONTROLLER = "RegisterController";
    private final String LOGIN_CONTROLLER = "LoginController"; // url-pattern
    private final String SEARCH_LASTNAME_CONTROLLER = "SearchLastnameController";
    private final String DELETE_ACCOUNT_CONTROLLER = "DeleteAccountController";
    private final String UPDATE_ACCOUNT_CONTROLLER = "UpdateAccountController";
    private final String PROCESS_ACCOUNT_CONTROLLER = "ProcessRequestController";
    private final String ADD_ITEM_TO_CART_CONTROLLER = "AddItemToCartController";
    private final String REMOVE_ITEM_FROM_CART_CONTROLLER = "RemoveItemsFromCartController";
    private final String VIEW_CART_PAGE = "viewCart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String button = request.getParameter("btAction");
        System.out.println(button);
        String url = LOGIN_PAGE;

        try {
            if (button == null) {
                url = PROCESS_ACCOUNT_CONTROLLER;
            } else if (button.equals("Register")) {
                url = REGISTER_CONTROLLER;
            } else if (button.equals("Login")) {
                url = LOGIN_CONTROLLER;
            } else if (button.equals("Search")) {
                url = SEARCH_LASTNAME_CONTROLLER;
            } else if (button.equals("Delete")) {
                url = DELETE_ACCOUNT_CONTROLLER;
            } else if (button.equals("Update")) {
                url = UPDATE_ACCOUNT_CONTROLLER;
            } else if (button.equals("Add Item To Your Cart")) {
                url = ADD_ITEM_TO_CART_CONTROLLER;
            } else if (button.equals("View Your Cart")) {
                url = VIEW_CART_PAGE;
            } else if (button.equals("Remove Selected Items")) {
                url = REMOVE_ITEM_FROM_CART_CONTROLLER;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

}

