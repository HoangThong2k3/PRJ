<%@page import="com.snack_shop.dto.response.product.ProductResponseDto"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Snack Shop">
    <meta name="keywords" content="SnackShop, snack">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Snack Shop Products</title>
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
    <link rel="stylesheet" href="./resources/css/style.css" >
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

    <!-- Hero Section Begin -->
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>All departments</span>
                        </div>
                        <ul>
                            <li><a href="#">Bánh tráng</a></li>
                            <li><a href="#">Snack</a></li>
                            <li><a href="#">Milk tea</a></li>
                            <li><a href="#">Juice</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section" style="background-image: url(./resources/images/contact-us.png);">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Organi Shop</h2>
                        <div class="breadcrumb__option">
                            <a href="./">Home</a>
                            <span>Shop</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <%
        List<ProductResponseDto> products = (List<ProductResponseDto>) request.getAttribute("paging-products");
        Integer totalProducts = request.getAttribute("total-products") != null ? (Integer) request.getAttribute("total-products") : 0;
    %>
    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>Department</h4>
                            <ul>
                                <li><a href="#">Bánh tráng</a></li>
                                <li><a href="#">Snack</a></li>
                                <li><a href="#">Milk tea</a></li>
                                <li><a href="#">Juice</a></li>
                            </ul>
                        </div>
                        <!-- Query top 6 latest products -->
                        <div class="sidebar__item">
                            <div class="latest-product__text">
                                <h4>Latest Products</h4>
                                <div class="latest-product__slider owl-carousel">
                                    <div class="latest-product__slider__item">
                                        <%
                                            List<ProductResponseDto> topLatestProducts = (List<ProductResponseDto>) request.getAttribute("top-latest-products");
                                            for (int i=0; i <= 2; i++) {
                                        %>
                                        <a href="./GetProductById?id=<%=topLatestProducts.get(i).getProductID()%>" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="./resources/images/product/<%=topLatestProducts.get(i).getImage()%>" alt="" style="height: 110px; width: 110px">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6><%=topLatestProducts.get(i).getProductName()%></h6>
                                                <span>$<%=topLatestProducts.get(i).getPrice()%></span>
                                            </div>
                                        </a>
                                        <%
                                            }
                                        %>
                                    </div>

                                    <div class="latest-product__slider__item">
                                        <%
                                            for (int i=3; i <= 5; i++) {
                                        %>
                                        <a href="./GetProductById?id=<%=topLatestProducts.get(i).getProductID()%>" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="./resources/images/product/<%=topLatestProducts.get(i).getImage()%>" alt="" style="height: 110px; width: 110px">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6><%=topLatestProducts.get(i).getProductName()%></h6>
                                                <span>$<%=topLatestProducts.get(i).getPrice()%></span>
                                            </div>
                                        </a>
                                        <%
                                            }
                                        %>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
                    <div class="filter__item">
                        <div class="row">
                            <div class="col-lg-4 col-md-5">
                                <div class="filter__sort">
                                    <span>Sort By</span>
                                    <select>
                                        <option value="0">Default</option>
                                        <option value="1">Lowest to Highest </option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="filter__found">
                                    <h6><span><%=totalProducts%></span> Products found</h6>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-3">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <%
                            for (ProductResponseDto product : products) {
                        %>
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <a class="product__item">
                                <div class="product__item__pic" style="background-image: url(./resources/images/product/<%=product.getImage()%>);">

                                </div>
                                <div class="product__item__text">
                                    <h6><a href="./GetProductById?id=<%=product.getProductID()%>"><%=product.getProductName()%></a></h6>
                                    <h5>$<%=product.getPrice()%></h5>
                                </div>
                            </a>
                        </div>
                        <%
                            }
                        %>


                    </div>
                    <div class="product__pagination">
                        <%
                            double totalPages = Math.ceil((double)totalProducts/6);
                            for (int i = 1; i <= totalPages; i++) {
                        %>
                        <a href="/SnackShop/PagingProductController?page=<%=i%>"><%=i%></a>
                        <%
                            }
                        %>
                        <a href="#"><i class="fa fa-long-arrow-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->

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
