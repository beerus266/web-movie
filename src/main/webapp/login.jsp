<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-12-19
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Sign in</title>
    <!-- CSS -->
    <link rel="stylesheet" href="css/common.css"/>
    <link rel="stylesheet" href="css/login.css"/>
</head>
<body>
<div class="banner">
    <div class="form">
        <h1 style="margin-left: 20px; color: white">Sign In</h1>

        <form action="login" method="post">
            <div class="form-control">
                <input type="text" placeholder="username" name="username"/>
            </div>
            <div class="form-control">
                <input type="password" placeholder="password" name="password"/>
            </div>
            <div class="form-control">
                <button id="login-button">Sign In</button>
            </div>
        </form>

        <div class="form-control">
            <span style="color: gray">Don't have any account?</span>
            <a href="register.jsp">
                Sign up now</a>
        </div>
    </div>
</div>
</body>
</html>

