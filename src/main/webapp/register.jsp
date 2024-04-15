
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

    <%-- JavaScript --%>
    <script src="./resources/js/register.js" ></script>

</head>
<body>
    <%-- Header Section Begin --%>
    <%@include file="layout/header_account.jsp"%>
    <%-- Header Section End--%>

    <div class="login_form_image">
        <img src="./resources/images/account-background.jpg" class="image_background"  alt=""/>
    </div>

    <div class="login_form">
        <form id="registerForm" method="POST" action="UserDispatchController">
            <div class="form-group">
                <h4 class="form-group-title">Register</h4>
            </div>
            <div class="row">
                <div class="col-md-6 mb-4">
                    <label>First Name</label>
                    <input type="text" class="form-control" placeholder="Your First Name" name="txtFirstName" required/>
                </div>
                <div class="col-md-6 mb-4">
                    <label>Last Name</label>
                    <input type="text" class="form-control" placeholder="Your Last Name" name="txtLastName" required/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-4">
                    <label> Email</label>
                    <input type="text" class="form-control" placeholder="Email" name="txtEmail" required/>
                </div>
                <div class="col-md-6 mb-4">
                    <label> Phone</label>
                    <input type="text" class="form-control" placeholder="Phone Number" name="txtPhone" required/>
                </div>
            </div>

            <div class="form-group">
                <label>Username</label>
                <input type="text" class="form-control" placeholder="Username" name="txtUsername" required/>
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" class="form-control" placeholder="Password" name="txtPassword" required
                       pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$"
                       title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                />
            </div>
            <div class="form-group">
                <label>Retype Password</label> <span id="passwordMatchMessage" style="color: red"></span><br />
                <input type="password" class="form-control" placeholder="Retype Password" name="txtRetypePassword" required
                       pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$"/>
            </div>

            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="agree">
                <label class="form-check-label" for="agree">I agree all statements in <a href="#!">Terms of service</a></label>
            </div>

            <button id="submitButton" type="submit" class="btn btn-primary form-control" name="btAction" value="Register">Register</button>
        </form>
    </div>
    <script>
        window.onload = function() {
            checkAgreement();
        };
    </script>

    <!-- Footer Section Begin -->
    <%@include file="layout/footer.jsp"%>
    <!-- Footer Section End -->
</body>
</html>

