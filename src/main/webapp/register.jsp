<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <script src="./resources/js/register.js" ></script>
</head>
<body>
<div class="container mt-5">
    <section class="vh-100" style="background-color: #eee;">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-lg-12 col-xl-11">
                    <div class="card text-black" style="border-radius: 25px;">
                        <div class="card-body p-md-5">
                            <div class="row justify-content-center">
                                <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4"><h2>Sign Up</h2></p>

                                    <form id="registerForm" class="mx-1 mx-md-4" method="POST" action="UserDispatchController">
                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="text" id="first_name" class="form-control" name="txtFirstName" required/>
                                                <label class="form-label" for="first_name">First Name</label>
                                            </div>
                                        </div>

                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="text" id="last_name" class="form-control" name="txtLastName" required/>
                                                <label class="form-label" for="last_name">Last Name</label>
                                            </div>
                                        </div>

                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="email" id="email" class="form-control" name="txtEmail" required/>
                                                <label class="form-label" for="email">Your Email</label>
                                            </div>
                                        </div>
                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="text" id="phone" class="form-control" name="txtPhone" required/>
                                                <label class="form-label" for="phone">Your Phone Number</label>
                                            </div>
                                        </div>

                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="text" id="username" class="form-control" name="txtUsername" required/>
                                                <label class="form-label" for="username">Username</label>
                                            </div>
                                        </div>

                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="password" id="password" class="form-control"
                                                   name="txtPassword" required
                                                   pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$"
                                                   title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                                                />
                                                <label class="form-label" for="password">Password</label>
                                            </div>
                                        </div>


                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="password" id="retype_password" class="form-control" onkeyup="checkPasswordMatch()" required/>
                                                <label class="form-label" for="retype_password">Repeat your password</label>
                                            </div>
                                        </div>

                                        <span id="passwordMatchMessage" style="color: red"></span><br />

                                        <div class="form-check d-flex justify-content-center mb-5">
                                            <input class="form-check-input me-2" type="checkbox" value="" id="agree" />
                                            <label class="form-check-label" for="agree">
                                                I agree all statements in <a href="#!">Terms of service</a>
                                            </label>
                                        </div><br/>

                                        <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                            <button id="submitButton" type="submit" value="Register"
                                                    class="btn btn-primary btn-lg" name="btAction">Register</button>
                                        </div>
                                    </form><br/>

                                </div>
                                <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                         class="img-fluid" alt="Sample image">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<script>
    window.onload = function() {
        checkAgreement();
    };
</script>
</body>
</html>
