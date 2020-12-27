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
<div class="main">

    <img src="assets/images/noel-left.png" class="noel-brochure-left">
    <img src="assets/images/noel-left.png" class="noel-brochure-right">
    <!-- Slideshow container -->
    <div class="slideshow-container">

        <!-- Full-width images with number and caption text -->
        <div class="mySlides fade cover1">
            <div class="right">
                <strong class="film-name-banner">Aladdin</strong>
                <p>Aladdin là phim điện ảnh nhạc kịch kỳ ảo của Mỹ do Guy Ritchie đạo diễn, người đồng viết kịch bản
                    với John August, và do hãng Walt Disney Pictures sản xuất. Đây là phiên bản làm lại người đóng
                    của tác phẩm hoạt hình cùng tên năm 1992 của Disney, cả hai đều dựa trên truyện cổ tích cùng tên
                    từ Nghìn lẻ một đêm</p>
                <a href="detail.jsp"><button class="watch-now-btn">Detail</button></a>
                <button class="add-to-list-btn">+ Add to list</button>
            </div>
        </div>

        <div class="mySlides fade cover2">
            <div class="right">
                <strong class="film-name-banner">Avengers - End Game</strong>
                <p>Avengers: Hồi kết là phim điện ảnh siêu anh hùng Mỹ ra mắt năm 2019, do Marvel Studios sản xuất
                    và Walt Disney Studios Motion Pictures phân phối. Phim là phần thứ tư của loạt phim Avengers,
                    sau Biệt đội siêu anh hùng, Avengers: Đế chế Ultron và Avengers: Cuộc chiến vô cực</p>
                <a href="detail.jsp"><button class="watch-now-btn">Detail</button></a>
                <button class="add-to-list-btn">+ Add to list</button>
            </div>
        </div>

        <div class="mySlides fade cover3">
            <div class="right">
                <strong class="film-name-banner">Avatar</strong>
                <p>Avatar là một bộ phim khoa học viễn tưởng của Mỹ năm 2009 do James Cameron viết kịch bản và đạo
                    diễn, với sự tham gia của các diễn viên Sam Worthington, Zoe Saldana, Stephen Lang, Michelle
                    Rodriguez, Joel David Moore, Giovanni Ribisi và Sigourney Weaver.</p>
                <a href="detail.jsp"><button class="watch-now-btn">Detail</button></a>
                <button class="add-to-list-btn">+ Add to list</button>
            </div>
        </div>

    </div>
    <br>

    <div id="new-films" class="main-content">
        <div class="main-content-header">
            <h1><span>New films</span></h1>
        </div>
        <div class="line-cards">
            <c:forEach begin="0" end="3" var="movie" items="${newMovies}">
                    <div class="card"  >
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
        <div class="line-cards">
            <c:forEach begin="4" end="7" var="movie" items="${newMovies}">
                <div class="card"  >
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

    <div id="hot-films" class="main-content">
        <div class="main-content-header">
            <h1><span>Hot films</span></h1>
        </div>
        <div class="line-cards">
            <c:forEach begin="0" end="3" var="movie" items="${rankMovies}">
                <div class="card"  >
                    <img src="${movie.urlImg}">
                    <div class="hover" hidden>
                        <h2>${movie.title}</h2>
                        <p>${movie.titleSub}</p>
<%--                        <p>${movie.summary}</p>--%>
                        <form action="detail-movie" method="get">
                            <input type="text" value="${movie.id}" style="display: none " name="id">
                            <button class="watch-now-btn" type="submit" >Detail</button>
                            <button class="add-to-list-btn" type="button" onclick="addToList(${movie.id})">+ Add to list</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="line-cards">
            <c:forEach begin="4" end="7" var="movie" items="${rankMovies}">
                <div class="card"  >
                    <img src="${movie.urlImg}">
                    <div class="hover" hidden>
                        <h2>${movie.title}</h2>
                        <p>${movie.titleSub}</p>
                            <%--                        <p>${movie.summary}</p>--%>
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
<script type="text/javascript" src="js/home.js" ></script>
<script src="js/SnowFall.js"></script>

</body>



</html>