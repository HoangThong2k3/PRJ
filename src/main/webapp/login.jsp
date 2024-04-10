
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet" />

    <!-- Css Styles -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css" />
    <link rel="stylesheet" href="resources/css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="resources/css/elegant-icons.css" type="text/css" />
    <link rel="stylesheet" href="resources/css/nice-select.css" type="text/css" />
    <link rel="stylesheet" href="resources/css/jquery-ui.min.css" type="text/css" />
    <link rel="stylesheet" href="resources/css/owl.carousel.min.css" type="text/css" />
    <link rel="stylesheet" href="resources/css/slicknav.min.css" type="text/css" />
    <link rel="stylesheet" href="resources/css/style.css" type="text/css" />
</head>
<body>

    <%-- Header Section Begin --%>
    <%@include file="layout/header_account.jsp"%>
    <%-- Header Section End--%>

    <div class="login_form_image">
        <img src="./resources/images/account-background.jpg" class="image_background"  alt=""/>
    </div>

    <div class="login_form">
        <form>
            <div class="form-group">
                <h4 class="form-group-title">Login</h4>
            </div>
            <div class="form-group">
                <label>User name</label>
                <input type="text" class="form-control" placeholder="Enter username" name="txtUsername" required/>
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" class="form-control" placeholder="Password" name="txtPassword" required/>
            </div>
            <button type="submit" class="btn btn-primary form-control">Login</button>
        </form>
    </div>

    <!-- Footer Section Begin -->
    <%@include file="layout/footer.jsp"%>
    <!-- Footer Section End -->
</body>
</html>

