var randomNumber1 = Math.floor(Math.random() * 6 + 1); //1-6

var randomImageSource = "images/dice" + randomNumber1 + ".png";

document.querySelectorAll("img")[0].setAttribute("src",randomImageSource)

var randomNumber2 = Math.floor(Math.random() * 6 + 1);

var randomImageSource1 = "images/dice" + randomNumber2 + ".png";

document.querySelectorAll("img")[1].setAttribute("src",randomImageSource1);

// Dynamic Header

if (randomNumber1 > randomNumber2){
  document.querySelector("h1").innerHTML = "🏁 Player1 Wins !!";
}
else if (randomNumber2 > randomNumber1){
  document.querySelector("h1").innerHTML = "Player2 Wins !! 🏁";
}
else {
  document.querySelector("h1").innerHTML = "🏁 It's A Draw 🏁";
}
