import React, { useEffect, useState } from 'react'
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import { ArrowBackIos, ArrowForwardIos } from '@material-ui/icons';
import "./Carousel.css"

const data = [
    { id: 1, url: 'https://picsum.photos/seed/400/900/250' },
    { id: 2, url: 'https://picsum.photos/seed/402/900/250' },
    { id: 3, url: 'https://picsum.photos/seed/403/900/250' },
    { id: 4, url: 'https://picsum.photos/seed/404/900/250' },
    { id: 5, url: 'https://picsum.photos/seed/405/900/250' }
];

function SampleNextArrow(props) {
    const { className, style, onClick } = props;
    // console.log('.....next', className)

    return (
        <div className={className} onClick={onClick}>
            <ArrowForwardIos style={{color: 'black', fontSize: '30'}}/>
        </div>
    );
}

function SamplePrevArrow(props) {
    const { className, style, onClick } = props;
    return (
        <div className={className} onClick={onClick}>
            <ArrowBackIos style={{color: 'black', fontSize: '30'}}/>
        </div>
    );
}

const Banner = () => {
    const settings = {
        dots: true,
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        nextArrow: <SampleNextArrow />,
        prevArrow: <SamplePrevArrow />
    };

    const [banners, setBanners] = useState();

    useEffect(() => {
        setBanners(data);
    }, []);

    if (!banners) return <h1>데이터를 불러오는 중입니다.</h1>

    return (
        <Slider {...settings}>
            {banners.map(b =>
                <img src={b.url} alt={b.url} key={b.id}/>
            )}
        </Slider>
    )
}

export default Banner