package com.snack_shop.controller.cart;


import com.snack_shop.dto.response.product.ProductResponseDto;
import com.snack_shop.repository.CartRepository;

import java.io.IOException;

import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "UpdateCartController", value = "/UpdateCartController")
public class UpdateCartController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String productId = request.getParameter("productId");
        HttpSession session = request.getSession();
        String accountId = (String) session.getAttribute("accountId");
        String sessionName = "productCart" + accountId;
        HashMap<String, ProductResponseDto> sessionCart = (HashMap<String, ProductResponseDto>) session.getAttribute("cart");
        CartRepository cartRepository = new CartRepository();
        Cookie c = cartRepository.getCookieByName(request, sessionName);
        if (sessionCart != null) {
            if (sessionCart.containsKey(productId)) {
                ProductResponseDto p = sessionCart.get(productId);
                p.setQuantity(quantity);
                sessionCart.remove(productId); // remove old product
                sessionCart.put(productId, p);
                session.setAttribute(accountId + "cart", sessionCart);
            }
        }

        request.getRequestDispatcher("cart-details.jsp").forward(request, response);
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

