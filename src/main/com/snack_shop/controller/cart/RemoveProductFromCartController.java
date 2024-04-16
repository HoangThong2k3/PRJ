package com.snack_shop.controller.cart;

import com.snack_shop.dto.response.product.ProductResponseDto;
import com.snack_shop.repository.CartRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "RemoveProductFromCartController", value = "/RemoveProductFromCartController")
public class RemoveProductFromCartController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String productId = request.getParameter("productId");
        HttpSession session = request.getSession();
        String accountId = (String) session.getAttribute("accountId");
        String sessionName = accountId + "cart";
        HashMap<String, ProductResponseDto> pCart = (HashMap<String, ProductResponseDto>) session.getAttribute("cart");
        CartRepository cartRepository = new CartRepository();
        Cookie c = cartRepository.getCookieByName(request, sessionName);
        //------------------------------------//
        if (pCart != null) {
            if (pCart.containsKey(productId)) {
                pCart.remove(productId);
                session.setAttribute("productCart" + accountId, pCart);
            }
        }
        if (c != null) {
            HashMap<String, ProductResponseDto> cookieCart = cartRepository.getCartFromCookie(c);
            if (cookieCart != null) {
                if (cookieCart.containsKey(productId)) {
                    cookieCart.remove(productId);
                    String itemsInCart = cartRepository.convertCartToString(new ArrayList<ProductResponseDto>(cookieCart.values()));
                    cartRepository.saveCartToCookie(request, response, itemsInCart, accountId);
                }
            }
        }
        //------------------------------------//
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

