
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';

const ImageCarousel = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
  };

  return (
    <div className="carousel-container">
      <Slider {...settings}>
        <div>
          <img src="/images/img5.webp" alt="Slide 1" />
        </div>
        <div>
          <img src="/images/img1.jpg" alt="Slide 2" />
        </div>
        <div>
          <img src="/images/img3.jpg" alt="Slide 3" />
        </div>
        {/* Add more slides as needed */}
      </Slider>
    </div>
  );
};

export default ImageCarousel;
