<%@ page import="com.snack_shop.dto.response.product.ProductResponseDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: quangtrung
  Date: 4/8/2024
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Edit Product</title>
    </head>
    <body>
        <%
            String search = (String) request.getAttribute("search");
            if (search == null)     search = "";

        %>

        <h2>Edit Product</h2>

        <form action="ProductController" method="post">
            Search: <input type="text" name="search" placeholder="Search" value="<%= search %>">
            <input type="submit" name="action" value="Search">
        </form>
        <%
            List<ProductResponseDto> products = (List<ProductResponseDto>) request.getAttribute("products");
            if (products != null) {
                if (!products.isEmpty()) {
        %>
        <table>

            <thead>
                <tr>
                    <th>Product Category</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Product Description</th>
                    <th>Product Price</th>
                    <th>Product Quantity</th>
                    <th>Product Image</th>
                    <th>Product Status</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (ProductResponseDto product : products) {
                %>
                <form action="ProductController" method="GET">
                    <tr>
                        <td><%= count++ %></td>
                        <td>
                           <input type="text" name="category" value="<%= product.getCategory() %>">
                        </td>
                        <td>
                            <input type="text" name="productID" value="<%= product.getProductID() %>">
                        </td>
                        <td>
                            <input type="text" name="productName" value="<%= product.getProductName() %>" >
                        </td>
                        <td>
                            <input type="text" name="description" value="<%= product.getDescription() %>" >
                        </td>
                        <td>
                            <input type="text" name="price" value="<%= product.getPrice() %>" >
                        <td>
                            <input type="text" name="quantity" value="<%= product.getQuantity() %>" >
                        </td>
                        <td>
                            <input type="text" name="image" value="<%= product.getImage() %>" >
                        </td>
                        <td>
                            <%= product.getStatus() %>
                        </td>
                        <td>
                            <input type="submit" name="action" value="Update">
                            <input type="hidden" name="search" value="<%= search %>">
                        </td>
                    </tr>
                </form>
                <%
                    }
                %>

            </tbody>
        </table>
        <%
                }
            }
        %>
    </body>
</html>