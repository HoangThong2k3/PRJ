<%@page import="com.snack_shop.dto.response.user.UserResponseDto"%>
<%@page import="java.util.List"%>
<%@ page import="com.mysql.cj.Session" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Search</title>
</head>
<body>
<%
    UserResponseDto userInfo = (UserResponseDto) session.getAttribute("USER_INFO");
    if (userInfo == null) {
        response.sendRedirect("./login");
    }
%>
    <h1>User Info Page</h1>
    <div class="card">
        <div class="card-header">
            <div class="row">
                <div class="col">Account Information: Welcome ${userInfo.firstName} ${userInfo.lastName}</div>
                <div class="col text-end">
                    <a href="./logout" class="btn btn-primary">Logout</a>
                </div>
            </div>
        </div>
        <div class="card-body">
            <table class="table align-middle mb-0 bg-white">
                <thead class="bg-light">
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Avatar</th>
                    <th>Role</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            ${userInfo.getUsername()}
                            <input type="hidden" name="txtUsername" value="<%= userInfo.getUsername()%>" />
                        </td>
                        <td>
                            <input type="text" name="txtPassword" placeholder="Input New Password"/>
                        </td>
                        <td>
                            <input type="text" name="txtFirstname" value="<%= userInfo.getFirstName()%>"/>
                        </td>
                        <td>
                            <input type="text" name="txtLastname" value="<%= userInfo.getLastName()%>"/>
                        </td>
                        <td>
                            <input type="text" name="txtAddress" value="<%= userInfo.getAddress()%>"/>
                        </td>
                        <td>
                            <input type="text" name="txtEmail" value="<%= userInfo.getEmail()%>"/>
                        </td>
                        <td>
                            <input type="text" name="txtPhone" value="<%= userInfo.getPhone()%>"/>
                        </td>
                        <td>
                            <input type="text" name="txtAvatar" value="<%= userInfo.getAvatar()%>"/>
                        </td>
                        <td>
                            <%= userInfo.getRole().toString()%>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>

