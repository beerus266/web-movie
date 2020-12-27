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

function removeFromList (movieId) {
  data = {
    "movieId": movieId
  }
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
    }
  };

  xhttp.open("post", "remove-from-list", true);
  xhttp.setRequestHeader('Content-Type', 'application/json');

  xhttp.send(JSON.stringify(data));
  document.getElementById("id-"+movieId).remove();
  alert("Xóa khỏi danh sách thành công !")

}