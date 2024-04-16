package com.snack_shop.controller.products;

import com.snack_shop.dto.response.product.ProductResponseDto;
import com.snack_shop.service.ProductService;
import com.snack_shop.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetAllProductsController", urlPatterns = {"/GetAllProductsController"})
public class GetAllProductsController extends HttpServlet {
    private ProductService productService; // Initialize your ProductService

    public void init() {
        productService = new ProductServiceImpl();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<ProductResponseDto> products = productService.getAllProducts(); // Fetch all products

        request.setAttribute("products", products); // Set products as a request attribute

        request.getRequestDispatcher("/home.jsp").forward(request, response); // Forward to JSP page

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

