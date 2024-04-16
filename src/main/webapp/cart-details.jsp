<%@ page import="com.snack_shop.dto.response.user.UserResponseDto" %>
<%@ page import="com.snack_shop.entities.Product" %>
<%@ page import="com.snack_shop.dto.response.product.ProductResponseDto" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.snack_shop.repository.CartRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Snack Shop">
    <meta name="keywords" content="SnackShop, snack">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Shopping Cart</title>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
    <!-- Css Styles -->

    <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="./resources/css/elegant-icons.css" >
    <link rel="stylesheet" href="./resources/css/nice-select.css" >
    <link rel="stylesheet" href="./resources/css/jquery-ui.min.css" >
    <link rel="stylesheet" href="./resources/css/owl.carousel.min.css" >
    <link rel="stylesheet" href="./resources/css/slicknav.min.css" >
    <link rel="stylesheet" href="./resources/css/style.css">

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <%-- Header Section Begin --%>
    <c:choose>
        <c:when test="${sessionScope.USER_INFO == null}">
            <%@include file="layout/header.jsp"%>
        </c:when>
        <c:otherwise>
            <%@include file="layout/header-with-account.jsp"%>
        </c:otherwise>
    </c:choose>
    <%-- Header Section End--%>

    <div style="height: 70%; width: 80%; margin: 70px auto">
        <h1 style="text-align: center">SNACKSHOP CART</h1>
        <br/>
        <%
            UserResponseDto userInfo = (UserResponseDto) session.getAttribute("USER_INFO");
            String accountId = userInfo==null? "customer":String.valueOf(userInfo.getId());

            String sessionName = accountId + "cart";

            HashMap<String, ProductResponseDto> sessionCart = (HashMap<String, ProductResponseDto>) session.getAttribute("cart");

            HashMap<String, ProductResponseDto> cookieCart = null;

            CartRepository cartRepository = new CartRepository();

            Cookie c = cartRepository.getCookieByName(request, sessionName);
            float total = 0;
            if (c != null) {
                cookieCart = cartRepository.getCartFromCookie(c);
            }
            HashMap<String, ProductResponseDto> pCart = new HashMap<String, ProductResponseDto>();
            if (sessionCart != null && sessionCart.size() > 0) {
                pCart = sessionCart;
            } else if (cookieCart != null && cookieCart.size() > 0) {
                pCart = cookieCart;
            }
            if (pCart == null || pCart.size() == 0) {
        %>
        <h2 style="text-align: center">Your cart is empty</h2>
        <%
        } else {
        %>
        <table style="border: 1px solid black; border-collapse: collapse; width: 100%; margin-left: auto; margin-right: auto; font-size: 24px; background-color: #F0FFFF; text-align: center">
            <thead>
            <tr style="background-color: #EED2EE">
                <th style="border: 1px solid black">NO</th>
                <th style="border: 1px solid black">Name</th>
                <th style="border: 1px solid black">Quantity</th>
                <th style="border: 1px solid black">Price</th>
                <th style="border: 1px solid black">Action</th>
            </tr>
            </thead>
            <tbody>
            <%
                int count = 0;
                for (ProductResponseDto p : pCart.values()) {
                    String key = String.valueOf(p.getProductID());
                    count += 1;
                    double tmp = p.getQuantity() * p.getPrice() + 5;
                    total += tmp;
            %>
            <tr>
                <td style="border: 1px solid black"><%=count%></td>
                <form action="UpdateCartController" method="post">
                    <input type="hidden" value="<%=p.getProductID()%>" name="productId"/>
                    <td style="border: 1px solid black"> <%= p.getProductName()%></td>
                    <td style="border: 1px solid black"><input type="number" name="quantity" value="<%= p.getQuantity()%>" min="1" style="height: 40px; width: 97%; font-size: 22px"/></td>
                    <td style="border: 1px solid black"> $<%= p.getPrice() * p.getQuantity()%></td>
                    <td style="border: 1px solid black">
                        <a href="RemoveProductFromCartController?productId=<%=key%>">Remove</a><br/>
                        <input type="submit" value="Update" style="height: 69%; width: 99%; font-size: 22px; color: salmon; background-color: #FEEBD0;"/>
                    </td>
                </form>
            </tr>
            <%
                    }
                }
            %>
            <tr>
                <td rowspan="2"colspan="1"style="font-size: 30px">TOTAL</td>
                <td colspan="2" rowspan="2" style="font-size: 30px"><%=String.format("%.2f", total)%>$</td>
                <td rowspan="1" colspan="2" style="border: 1px solid black"><a href="PaymentController" style="border: 1px solid black; border-style: none;">Settle up my bill</a></td>
            </tr>
            <tr>
                <td rowspan="1" colspan="2" style="border: 1px solid black"><form action="SaveCartController" method="post"><input type="submit" value="Save my cart" style="height: 69%; width: 99%; font-size: 22px; color: salmon; background-color: #FEEBD0;"/></form> </td>
            </tr>
            </tbody>
        </table>
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
        %>
        <h4 style="color: green"><%=msg%></h4>
        <% }%>
    </div>



    <!-- Footer Section Begin -->
    <%@include file="layout/footer.jsp"%>
    <!-- Footer Section End -->
    <!-- Js Plugins -->
    <script src="./resources/js/jquery-3.3.1.min.js"></script>
    <script src="./resources/js/bootstrap.min.js"></script>
    <script src="./resources/js/jquery.nice-select.min.js"></script>
    <script src="./resources/js/jquery-ui.min.js"></script>
    <script src="./resources/js/jquery.slicknav.js"></script>
    <script src="./resources/js/mixitup.min.js"></script>
    <script src="./resources/js/owl.carousel.min.js"></script>
    <script src="./resources/js/main.js"></script>
</body>
</html>
