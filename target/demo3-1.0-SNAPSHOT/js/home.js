// === carousel ===
var slideIndex = 0;
showSlides();

console.log("js home");
function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}
  slides[slideIndex-1].style.display = "block";
  setTimeout(showSlides, 5000); // Change image every 5 seconds
}

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
      console.log(this.responseText);
    }
  };

  console.log("outtt");
  xhttp.open("post", "add-to-list", true);
  xhttp.setRequestHeader('Content-Type', 'application/json');

  xhttp.send(JSON.stringify(data));

  alert("Thêm vào danh sách thành công !")
}