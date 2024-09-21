const signInBtn = document.querySelector(".sign-in-btn");
const logInBtn = document.querySelector(".log-in-btn");
const logInContainer = document.querySelector(".log-in-container");
const signInContainer = document.querySelector(".sing-in-container");
const sportsHeaderbtn = document.querySelector(
  ".deportes-disponibles-container"
);
const sportsHeaderP = document.querySelector(".deportes-disponibles-label");
const sportsHeaderI = document.querySelector(".deportes-disponibles-icon");

const sportsHeaderContainer = document.querySelector(
  ".menu-deportes-container"
);
document.addEventListener("click", (e) => {
  targetEl = e.target;
  if (
    targetEl != sportsHeaderbtn &&
    targetEl != sportsHeaderI &&
    targetEl != sportsHeaderP
  ) {
    console.log("n");
    if (!sportsHeaderContainer.classList.contains("hidden")) {
      sportsHeaderContainer.classList.add("hidden");
    }
  }
});
sportsHeaderbtn.addEventListener("click", () => {
  sportsHeaderContainer.classList.toggle("hidden");
});
