// const signInBtn = document.querySelector(".sign-in-btn");
// const logInBtn = document.querySelector(".log-in-btn");
// const logInContainer = document.querySelector(".log-in-container");
// const signInContainer = document.querySelector(".sing-in-container");
// const sportsHeaderbtn = document.querySelector(
//   ".deportes-disponibles-container"
// );
// const sportsHeaderP = document.querySelector(".deportes-disponibles-label");
// const sportsHeaderI = document.querySelector(".deportes-disponibles-icon");

// const sportsHeaderContainer = document.querySelector(
//   ".menu-deportes-container"
// );

const orderByBtn = document.querySelector(".order-by-btn");
const orderByItems = document.querySelector(".order-by-items");
const doneOrderBtn = document.querySelector(".done-order");
const filterByBtn = document.querySelector(".filter-by-btn");
const filterByItems = document.querySelector(".filter-by-items");
const doneFilterBtn = document.querySelector(".done-filter");

// document.addEventListener("click", (e) => {
//   targetEl = e.target;
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

// sportsHeaderbtn.addEventListener("click", () => {
//   sportsHeaderContainer.classList.toggle("hidden");
// });

orderByBtn.addEventListener("click", (e) => {
  orderByItems.classList.toggle("hidden");
});
filterByBtn.addEventListener("click", (e) => {
  filterByItems.classList.toggle("hidden");
});

doneOrderBtn.addEventListener("click", (e) => {
  orderByItems.classList.toggle("hidden");
});

doneFilterBtn.addEventListener("click", (e) => {
  filterByItems.classList.toggle("hidden");
});
