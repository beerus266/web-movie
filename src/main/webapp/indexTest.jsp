<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-11-09
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/navtop.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">

    <link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
    <p >Hello world fucking care</p>

    <form action="index" method="get" class="form-submit">
        <div class="form-input">
            <label> UserName:</label>
            <input type="text" name="username" >
        </div>
        <div>
            <label> Password: thiếu nữa</label>
            <input type="password" name="password">
        </div>
        <button type="submit">Submit</button>
    </form>
    <p style="color: white">Aladdin là phim điện ảnh nhạc kịch kỳ ảo của Mỹ do Guy Ritchie đạo diễn, người đồng viết kịch bản
        với John August, và do hãng Walt Disney Pictures sản xuất. Đây là phiên bản làm lại người đóng
        của tác phẩm hoạt hình cùng tên năm 1992 của Disney, cả hai đều dựa trên truyện cổ tích cùng tên
        từ Nghìn lẻ một đêm</p>
    <button id="btn">click</button>
    <div id="id1"></div>
    <script type="text/javascript">
        $("#btn").on("click", function(){
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("id1").innerHTML = this.responseText;
                    console.log(this.responseText);
                    // this.responseXML
                }
            };
            const json = {
                "email": "eve.holt@reqres.in",
                "email1": "eve.holt@reqres.in1",

                "email2": "eve.holt@reqres.in",
                "email3": "eve.holt@reqres.in",
                "password": "cityslicka"
            };


            xhttp.open("post", "Login", true);
// set `Content-Type` header
            xhttp.setRequestHeader('Content-Type', 'application/json');

// send rquest with JSON payload
            xhttp.send(JSON.stringify(json));
            // xhttp.send(json);

        });

    </script>

</body>

</html>
