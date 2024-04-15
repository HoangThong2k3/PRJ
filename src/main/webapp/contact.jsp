<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Snack Shop">
    <meta name="keywords" content="SnackShop, snack">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Contact Us</title>
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
</head>

<body>
    <!-- Page Preloader -->
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
                                <label>
                                    <input type="text" placeholder="What do yo u need?">
                                </label>
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+84 12.345.6789</h5>
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
                        <h2>Contact Us</h2>
                        <div class="breadcrumb__option">
                            <a href="./home.jsp">Home</a>
                            <span>Contact Us</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Contact Section Begin -->
    <section class="contact ">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                    <div class="contact__widget">
                        <span class="icon_phone"></span>
                        <h4>Phone</h4>
                        <p>+84 12.345.6789</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                    <div class="contact__widget">
                        <span class="icon_pin_alt"></span>
                        <h4>Address</h4>
                        <p>FPT University, Qui Nhơn city, Binh Dinh</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                    <div class="contact__widget">
                        <span class="icon_clock_alt"></span>
                        <h4>Open time</h4>
                        <p>8:00 am to 18:00 pm</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                    <div class="contact__widget">
                        <span class="icon_mail_alt"></span>
                        <h4>Email</h4>
                        <p>snackshop@fpt.com</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Contact Section End -->

    <!-- Map Begin -->
    <div class="map">
        <iframe
                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3874.5848114218884!2d109.21657047632104!3d13.803884386593445!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x316f6bf778c80973%3A0x8a7d0b5aa0af29c7!2zxJDhuqFpIGjhu41jIEZQVCBRdXkgTmjGoW4!5e0!3m2!1svi!2s!4v1712741333484!5m2!1svi!2s"
                height="500" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
        <div class="map-inside">
            <i class="icon_pin"></i>
            <div class="inside-widget">
                <h4>FPT University</h4>
                <ul>
                    <li>Phone: +84 12.345.6789</li>
                    <li>Add: FPT University, Qui Nhơn city, Binh Dinh</li>
                </ul>
            </div>
        </div>
    </div>
    <!-- Map End -->

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