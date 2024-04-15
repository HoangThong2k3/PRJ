<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Snack Shop">
    <meta name="keywords" content="SnackShop, snack">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Snack Shop Home</title>
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




    <!-- Footer Section Begin -->
    <%@include file="layout/footer.jsp"%>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="resources/js/jquery-3.3.1.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.nice-select.min.js"></script>
    <script src="resources/js/jquery-ui.min.js"></script>
    <script src="resources/js/jquery.slicknav.js"></script>
    <script src="resources/js/mixitup.min.js"></script>
    <script src="resources/js/owl.carousel.min.js"></script>
    <script src="resources/js/main.js"></script>
</body>
</html>
