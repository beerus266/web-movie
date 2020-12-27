// === carousel ===


console.log("js search");


// === card ===
var cards = document.getElementsByClassName("card");
for (i = 0; i < cards.length; i++) {
    cards[i].setAttribute('onmouseover', 'CardHover(this)');
    cards[i].setAttribute('onmouseout', 'CardMouseOut(this)');
}

function CardHover(card){
    var hover = card.childNodes[3];
    hover.style.display='block';
}

function CardMouseOut(card){
    var hover = card.childNodes[3];
    hover.style.display='none';
}

function addToList (movieId) {
    data = {
        "movieId": movieId
    }
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            // document.getElementById("id1").innerHTML = this.responseText;
            console.log(this.responseText);
            // this.responseXML
        }
    };

    console.log("outtt");
    xhttp.open("post", "add-to-list", true);
// set `Content-Type` header
    xhttp.setRequestHeader('Content-Type', 'application/json');

// send request with JSON payload
    xhttp.send(JSON.stringify(data));
}
