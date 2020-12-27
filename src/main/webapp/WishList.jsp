<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <!-- CSS -->
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/navtop.css">
    <link rel="stylesheet" href="css/footer.css">

    <link rel="stylesheet" href="css/userlist.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>

<jsp:include page="nav-top.jsp"></jsp:include>

<img src="assets/images/noel-left.png" class="noel-brochure-left">
<img src="assets/images/noel-left.png" class="noel-brochure-right">
<div class="main-content ag-snow-fall" style="margin: 40px 150px">
    <h1 style="text-align: center;">Your list</h1>
        <c:forEach var="movie" items="${movies}">
            <div class="film-item" id="id-${movie.id}">
                <div class="thumbnail">
                    <img src="${movie.urlImg}" alt="">
                </div>
                <div class="description">
                    <h3>${movie.title}</h3>
                    <p>${movie.summary}</p>
                    <form action="detail-movie" method="get">
                        <input type="text" value="${movie.id}" style="display: none " name="id">
                        <button class="watch-now-btn" type="submit" >Detail</button>
                        <button class="delete-from-list" type="button" onclick="removeFromList(${movie.id})"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                    </form>
                </div>
            </div>
        </c:forEach>
</div>
<jsp:include page="footer.jsp"></jsp:include>

<script src="js/list.js"></script>
<script src="js/SnowFall.js"></script>

</body>
</html>
