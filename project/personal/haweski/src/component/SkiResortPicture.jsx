import React, { useState } from 'react'
import { Carousel } from 'react-bootstrap';

const SkiResortPicture = ({ image }) => {

    const [index, setIndex] = useState(0);
  
    const handleSelect = (selectedIndex, e) => {
        setIndex(selectedIndex);
    }

    const rendering = () => {
        const result = [];
        for(let i = 0; i < image.length; i++) {
            result.push(
                    <Carousel.Item key={image[i].id}>
                        <img
                                className="d-block w-100"
                                src={image[i].src}
                                alt={image[i].src}
                                style={{ height: "500px" }} />
                    </Carousel.Item>
            );
        }
        return result;
    };

    return (
        <Carousel activeIndex={index} onSelect={handleSelect}>
        {rendering()}
    </Carousel>
    )

}

export default SkiResortPicture