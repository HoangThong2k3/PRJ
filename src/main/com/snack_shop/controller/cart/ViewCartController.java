package com.snack_shop.controller.cart;

import com.snack_shop.dto.response.product.ProductResponseDto;
import com.snack_shop.repository.CartRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ViewCartController", value = "/ViewCartController")
public class ViewCartController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HashMap<String, ProductResponseDto> sessionCart = null;
        List<ProductResponseDto> pList = null;
        HttpSession session = request.getSession();
        String accountId = (String)session.getAttribute("accountId");
        String sessionName = "productCart" + accountId;
        Cookie cookieCart = null;
        try {
            CartRepository cartRepository = new CartRepository();
            sessionCart = (HashMap<String, ProductResponseDto>) session.getAttribute(sessionName);
            if (sessionCart == null) {
                cookieCart = cartRepository.getCookieByName(request, sessionName);
                if (cookieCart != null) {
                    sessionCart = cartRepository.getCartFromCookie(cookieCart);
                    if (sessionCart != null) {
                        pList = new ArrayList<>(sessionCart.values());
                        session.setAttribute("productCart", sessionCart);
                    }
                }
            }
            else {
                pList = new ArrayList<ProductResponseDto>(sessionCart.values());
            }
            request.setAttribute(accountId + "cart", sessionCart);  //take a look
        } catch (Exception e) {
            log("ViewCartController has error: " + e.getMessage());
        } finally {
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

