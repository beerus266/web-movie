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

    <link rel="stylesheet" href="css/home.css">

</head>

<body>
<jsp:include page="nav-top.jsp"></jsp:include>
<div class="main ag-snow-fall">
    <br>

    <div id="new-films" class="main-content">
        <div class="main-content-header">
            <h1><span>Phim có liên quan</span></h1>
        </div>
        <div class="line-cards" style="justify-content: flex-start !important;">
            <c:forEach  begin="0" end="3" var="movie" items="${movies}">
                <div class="card"  style="margin-left: 15px">
                    <img src="${movie.urlImg}">
                    <div class="hover" hidden>
                        <h2>${movie.title}</h2>
                        <p>${movie.titleSub}</p>
                            <%--                            <p>${movie.summary}</p>--%>
                        <form action="detail-movie" method="get">
                            <input type="text" value="${movie.id}" style="display: none " name="id">
                            <button class="watch-now-btn" type="submit" >Detail</button>
                            <button class="add-to-list-btn" type="button" onclick="addToList(${movie.id})">+ Add to list</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="js/search.js" ></script>
<script src="js/SnowFall.js"></script>
</body>



</html>