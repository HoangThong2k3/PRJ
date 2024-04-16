package com.snack_shop.controller.products;

import com.snack_shop.dto.response.product.ProductResponseDto;
import com.snack_shop.service.ProductService;
import com.snack_shop.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetProductById", value = "/GetProductById")
public class GetProductById extends HttpServlet {
    private ProductService productService; // Initialize your ProductService

    public void init() {
        productService = new ProductServiceImpl();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        System.out.println("Get product by ID phase");
        String productIdStr = request.getParameter("id"); // Get product ID
        int productId = Integer.parseInt(productIdStr); // Convert product ID to int

        ProductResponseDto product = productService.getProductById(productId); // Fetch product by ID

        System.out.println(product.toString());
        request.setAttribute("product", product); // Set product as a request attribute

        request.getRequestDispatcher("/product-details.jsp").forward(request, response); // Forward to JSP page

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

