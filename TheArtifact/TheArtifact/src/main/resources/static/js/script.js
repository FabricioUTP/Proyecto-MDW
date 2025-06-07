let currentSlide = 0;
const track = document.querySelector('.slider-track');
const totalSlides = 2;

function slide() {
  currentSlide = (currentSlide + 1) % totalSlides;
  track.style.transform = `translateX(-${currentSlide * 100}%)`;
}

setInterval(slide, 4000); // Cambia cada 4 segundos