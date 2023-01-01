/* global kakao */

import React, { useEffect } from 'react'
import { Button, Row, Table } from 'react-bootstrap';

const SkiResortLocation = ({ tel, link, address, direction, x, y }) => {

    useEffect(() => {
        const container = document.getElementById("map");
		const options = {
			center: new window.kakao.maps.LatLng(x, y),
			level: 7
		};

        const map = new window.kakao.maps.Map(container, options);

        const markerPosition = new window.kakao.maps.LatLng(x, y);
        const marker = new kakao.maps.Marker({
            position: markerPosition
        })
        marker.setMap(map);
    }, [x ,y])

    return (
        <Row className="my-1">
            <Row
                    id="map"
                    style={{
                        margin: "10px auto",
                        width: "70%",
                        height: "350px"
                    }} />
            <Table
                    style={{
                        width: "70%",
                        margin: "0 auto 10px"
                    }}>
                <tbody>
                    <tr>
                        <td>주소</td>
                        <td>
                            {address} 
                        </td>
                        <td>
                            <Button size="sm" variant="outline-primary">
                                <a
                                        href={direction}
                                        target="_blank"
                                        rel="noopener noreferrer"
                                        style={{ textDecoration: "none" }}>
                                    길찾기
                                </a>
                            </Button>
                        </td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td colSpan={2}>{tel}</td>
                    </tr>
                    <tr>
                        <td>홈페이지</td>
                        <td colSpan={2}>
                            <a
                                    href={link}
                                    target="_blank"
                                    rel="noopener noreferrer">
                                {link.length < 50 ? link : link.slice(0, 45) + "..."}
                            </a>
                        </td>
                    </tr>
                </tbody>
            </Table>
        </Row>

    )

}

export default SkiResortLocation