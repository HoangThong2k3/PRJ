package com.snack_shop.controller.cart;

import com.snack_shop.dto.response.product.ProductResponseDto;
import com.snack_shop.service.ProductService;
import com.snack_shop.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddProductToCart", value = "/AddProductToCart")
public class AddProductToCartController extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        HashMap<String, ProductResponseDto> cart = (HashMap<String, ProductResponseDto>) request.getSession().getAttribute("cart");
        String productId = request.getParameter("product_id");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductResponseDto product = productService.getProductById(Integer.parseInt(productId));
        product.setQuantity(quantity);

        if (cart == null) {
            cart = new HashMap<>();
            cart.put(productId, product);
        } else {
            if (cart.containsKey(productId)) {
                ProductResponseDto existingProduct = cart.get(productId);
                existingProduct.setQuantity(existingProduct.getQuantity() + quantity);
                cart.put(productId, existingProduct);
            } else {
                cart.put(productId, product);
            }
        }
        session.setAttribute("cart", cart);
        response.sendRedirect(request.getContextPath() + "/cart-details.jsp");

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

