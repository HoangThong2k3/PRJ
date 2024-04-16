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

@WebServlet(name = "PagingProductController", urlPatterns = {"/PagingProductController"})
public class PagingProductController extends HttpServlet {
    private ProductService productService; // Initialize your ProductService

    public void init() {
        productService = new ProductServiceImpl();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int pageNumber = request.getParameter("page") != null?
            Integer.parseInt(request.getParameter("page")) : 1;

        List<ProductResponseDto> products = productService.getProductsByPage(pageNumber); // Fetch all products
        System.out.println(products);
        List<ProductResponseDto> topLatestProducts = productService.getTopLatestProducts(); // Fetch all products
        int totalProducts = productService.getAllProducts().size();
        request.setAttribute("total-products", totalProducts); // Set products as a request attribute
        request.setAttribute("paging-products", products); // Set products as a request attribute
        request.setAttribute("top-latest-products", topLatestProducts); // Set products as a request attribute

        request.getRequestDispatcher("/shop-grid.jsp").forward(request, response); // Forward to JSP page
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

