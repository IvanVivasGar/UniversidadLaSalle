const geoBtn = document.querySelector(".geo");
// const signInBtn = document.querySelector(".sign-in-btn");
// const logInBtn = document.querySelector(".log-in-btn");
// const logInContainer = document.querySelector(".log-in-container");
// const signInContainer = document.querySelector(".sing-in-container");
// const sportsHeaderbtn = document.querySelector(
//   ".deportes-disponibles-container"
// );
// const sportsHeaderContainer = document.querySelector(
//   ".menu-deportes-container"
// );

const topCardBtn = document.querySelectorAll(".info-top-card");
const infoCard = document.querySelectorAll(".info-bottom-card");

geoBtn.addEventListener("click", (e) => {
  e.preventDefault();
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(successFunction, errorFunction);
  } else {
    console.log("Geolocation is not supported by this browser.");
  }

  function successFunction(position) {
    console.log(position);
  }

  function errorFunction() {
    console.log("Unable to retrieve your location.");
  }
});

// sportsHeaderbtn.addEventListener("click", () => {
//   sportsHeaderContainer.classList.toggle("hidden");
// });

for (let i = 0; i < topCardBtn.length; i++) {
  topCardBtn[i].addEventListener("click", () => {
    const cardId = topCardBtn[i].dataset.card;

    for (let x = 0; x < infoCard.length; x++) {
      const infoId = infoCard[x].dataset.box;
      console.log("a");
      if (cardId == infoId) {
        infoCard[x].classList.toggle("hidden-box");
      }
    }
  });
}

// /////////////////////\
// const sportsHeaderP = document.querySelector(".deportes-disponibles-label");
// const sportsHeaderI = document.querySelector(".deportes-disponibles-icon");

// document.addEventListener("click", (e) => {
//   targetEl = e.target;
//   console.log(e.target);
//   console.log(sportsHeaderbtn);
//   console.log("p");
//   if (
//     targetEl != sportsHeaderbtn &&
//     targetEl != sportsHeaderI &&
//     targetEl != sportsHeaderP
//   ) {
//     console.log("n");
//     if (!sportsHeaderContainer.classList.contains("hidden")) {
//       sportsHeaderContainer.classList.add("hidden");
//     }
//   }
// });
// ///
const mainBtn = document.querySelector(".main-btn");
const sportsCarrousell = document.querySelector(".sports-selection-container");

mainBtn.addEventListener("click", () => {
  sportsCarrousell.scrollIntoView();
});
