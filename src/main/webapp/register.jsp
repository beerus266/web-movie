
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Sign up</title>
    <!-- CSS -->
    <link rel="stylesheet" href="css/common.css"/>
    <link rel="stylesheet" href="css/register.css"/>
</head>
<body>
<div class="banner">
    <div class="form">
        <h1 style="margin-left: 20px;color: white;">Sign Up</h1>
    <form action="register" method="post">
        <div class="form-control">
            <input type="text" placeholder="username" name="username"/>
        </div>
        <div class="form-control">
            <input type="password" placeholder="password" name="password"/>
        </div>
        <div class="form-control">
            <input type="email" placeholder="email" name="gmail"/>
        </div>
        <div class="form-control">
            <input type="text" placeholder="phone" name="phone"/>
        </div>
        <div class="form-control">
            <button id="login-button" type="submit">Sign Up</button>
        </div>
    </form>
    </div>

</div>
</body>
</html>