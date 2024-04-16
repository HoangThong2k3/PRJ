package com.snack_shop.controller.cart;

import com.snack_shop.dto.response.product.ProductResponseDto;
import com.snack_shop.repository.CartRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SaveCartController", value = "/SaveCartController")
public class SaveCartController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accountId = (String)session.getAttribute("accountId");
        String sessionName = accountId + "cart";
        String msg = "Your cart is empty.";
        HashMap<String, ProductResponseDto> cart;
        try {
            cart = (HashMap<String, ProductResponseDto>) session.getAttribute("cart");
            CartRepository cartRepository = new CartRepository();
            if (cart != null) {
                String strItemsInCart = cartRepository.convertCartToString(new ArrayList<ProductResponseDto>(cart.values()));
                cartRepository.saveCartToCookie(request, response, strItemsInCart, accountId);
                msg = "Your Cart has been saved successfully.";
            }
        } catch (Exception e) {
            log("SaveCartController has error: " + e.getMessage());
        } finally {
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("cart-details.jsp").forward(request, response);
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

