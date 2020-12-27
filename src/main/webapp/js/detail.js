// === watch ===
function Watch() {
    // alert("watch");
    console.log("ASdfasd");
    document.getElementById("pre-watch").hidden = "true";
    document.getElementById("post-watch").style.display = "block";
    document.getElementById("movie").autoplay = true;
    document.getElementById("movie").load();
    document.getElementsByClassName("detail")[1].style.width="100%";
    document.getElementsByClassName("detail")[1].style.display="block";
    document.getElementsByClassName("detail")[1].style.marginLeft="0px";

    window.scrollTo(0, 0);
    removesnow();
}

//====== key Enter change ============
console.log("Fasd");
document.getElementById('form-comment-input').addEventListener('keypress', function (e) {
    if (e.keyCode == 13) {
        addComment();
    }
});
// === COmment ===
function addComment () {
    var content = document.getElementById("form-comment-input").value;
    var url = new URL(window.location.href);
    var movieid = url.searchParams.get("id");
    var date = new Date(Date.now()).toLocaleString().split(',');


    data = {
        "content": content,
        "movieid": movieid
    }
    console.log(data);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("form-comment-input").value ="";
            var comments = document.getElementById("group-comment");
            var containerDiv = document.createElement("div");
            containerDiv.className = "comment-container";
            comments.appendChild(containerDiv);

            var h3 = document.createElement("h3");
            h3.style.cssText = "margin-bottom: 0px";
            var i = document.createElement("i");
            i.className = "fa fa-user";
            h3.appendChild(i);
            h3.innerText = document.getElementById("usernameUnique").innerText;
            containerDiv.appendChild(h3);

            var small = document.createElement("small");
            small.style.cssText = "font-weight: normal";
            small.innerText = date[0] + " " + date[1];
            containerDiv.appendChild(small);

            var p = document.createElement("p");
            p.innerText = content;
            containerDiv.appendChild(p);
        }
    };

    xhttp.open("post", "comment", true);
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(data));
}

function addToList (movieId) {
    data = {
        "movieId": movieId
    }
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
        }
    };

    console.log("outtt");
    xhttp.open("post", "add-to-list", true);
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(data));
    alert("Thêm vào danh sách thành công !");
}