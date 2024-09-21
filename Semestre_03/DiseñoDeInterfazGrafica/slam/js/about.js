const btnMoreAbout = document.querySelector(".more-about-us-btn");
const whoWeAre = document.querySelector(".who-we-are-info-container");

btnMoreAbout.addEventListener("click", () => {
  whoWeAre.scrollIntoView();
});
