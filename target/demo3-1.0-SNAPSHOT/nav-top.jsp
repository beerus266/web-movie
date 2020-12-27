<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


<div class="form-search">
    <form action="search-movie" method="get">
        <input type="text"  placeholder="Tìm phim ..." name="searchField">
    </form>
</div>
<div class="navtop">

    <ul class="left">

        <li>
            <a href="index">
                <strong style="font-size: 25px;">Home</strong>
            </a>
        </li>
        <li>
            <a href="#">Films</a>
        </li>
        <li>
            <a href="wishlist">Yêu thích</a>
        </li>

    </ul>
    <ul class="right">
        <li>
            <i style="color: white" class="fa fa-user" aria-hidden="true"></i>
            <a href="">Hi <span id="usernameUnique"><c:out value='${sessionScope.name}'/></span></a>
        </li>
        <li>
            <form action="logout" method="post">
                <a type="submit"><button id="logout-button" type="submit"><i class="fa fa-sign-out" aria-hidden="true"></i></button></a>
            </form>
        </li>
    </ul>

</div>


