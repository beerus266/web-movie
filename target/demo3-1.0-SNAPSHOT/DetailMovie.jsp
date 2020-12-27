<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-12-13
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
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

    <link rel="stylesheet" href="css/detail.css">

</head>
<body>
<jsp:include page="nav-top.jsp"></jsp:include>

<div class="main-content ag-snow-fall">
    <img src="assets/images/noel-left.png" class="noel-brochure-left">
    <img src="assets/images/noel-left.png" class="noel-brochure-right">
    <h3 style="text-align: center;">Phim : ${movie.title}</h3>
    <div id="pre-watch" style="margin-left: 30px">
        <iframe width="42%" height="378apx" src="${movie.producer}" frameborder="0"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                allowfullscreen></iframe>
        <div class="detail">
            <h1>${movie.title}</h1>
            <h3>${movie.titleSub}</h3>
            <h2>IMDb Rank: <span style="color: #e8e832;">${movie.IMDBRank}</span> </h2>
            <h2>Chất lượng: <span >${movie.quality}</span> </h2>
            <h2>Thời gian: <span style="color: #e8e832;">${movie.time}</span> </h2>
            <h3><u>Summary</u></h3>
            <p>${movie.summary}</p>
            <form action="detail-movie" method="get">
                <input type="text" value="${movie.id}" style="display: none " name="id">
                <button class="watch-now-btn"  id="watch" type="button" onclick="Watch()">Watch now</button>
                <button class="add-to-list-btn" type="button" onclick="addToList(${movie.id})">+ Add to list</button>
            </form>
        </div>
    </div>
    <div id="post-watch" style="display: none;">
        <video id="movie" width="100%" height="500px" controls>
            <source src="${movie.urlMovie}" type="video/mp4">
            Your browser does not support the video tag.
        </video>
        <div class="detail">
            <h1>${movie.title}</h1>
            <h2>IMDb Rank: <span style="color: red;">${movie.IMDBRank}</span> </h2>
            <h3><u>Summary</u></h3>
            <p>${movie.summary}</p>
        </div>
    </div>

    <div class="comment">
        <div class="comment-wrapper">
            <div id="form-comment">
                <input type="text" id="form-comment-input" placeholder="Viết bình luận ..." >
            </div>
            <div id="group-comment">
                <c:forEach var="comment" items="${comments}">
                    <div class="comment-container">
                        <h3 style="margin-bottom: 0px;"><i class="fa fa-user" aria-hidden="true"></i> ${comment.username} &nbsp;&nbsp;&nbsp;</h3>
                        <small style="font-weight: normal;">${comment.time}</small>
                        <p>${comment.content}</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<script  type="application/javascript" src="js/SnowFall.js"></script>
<script  type="application/javascript" src="js/detail.js"></script>


</body>

<jsp:include page="footer.jsp"></jsp:include>


</html>
