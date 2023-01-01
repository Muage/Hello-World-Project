import React, { useEffect, useState } from 'react';
import { Alert, Button, Card, Col, Form, ListGroup, Row, Table } from 'react-bootstrap';
import { getSkiResorts } from '../Data';
import SkiResortLiftItem from './SkiResortLiftItem';

const ExpectedCost = () => {

    const skiResorts = getSkiResorts();
    
    const [skiResortSelected, setSkiResortSelected] = useState("9");
    const [lift, setLift] = useState(skiResorts[8].lift);
    const [distance, setDistance] = useState(skiResorts[8].distance);
    const [estimatedTime, setEstimatedTime] = useState(skiResorts[8].estimatedTime);
    
    const [liftSale, setLiftSale] = useState(skiResorts[8].liftSale);
    const [equipmentSale, setEquipmentSale] = useState(skiResorts[8].equipmentSale);
    const [suitSale, setSuitSale] = useState(skiResorts[8].suitSale);

    const [priceLiftItem, setPriceLiftItem] = useState([]);
    const [priceLiftWeekendItem, setPriceLiftWeekendItem] = useState([]);
    const [priceGondolaItem, setPriceGondolaItem] = useState([]);

    const [priceEquipment, setPriceEquipment] = useState(0);
    const [priceSuit, setPriceSuit] = useState(0);

    const [liftSalePercent, setLiftSalePercent] = useState(1);
    const [equipmentSalePercent, setEquipmentSalePercent] = useState(1);
    const [suitSalePercent, setSuitSalePercent] = useState(1);
    const [quantity, setQuantity] = useState(1);

    const [transport, setTransport] = useState("");
    const [socarDrivingCost1, setSocarDrivingCost1] = useState("");
    const [socarDrivingCost2, setSocarDrivingCost2] = useState("");
    const [greencarDrivingCost, setGreencarDrivingCost] = useState("");
    const [messageQuantity, setMessageQuantity] = useState("");

    // 도착지 변경될 때마다
    const skiResortSelect = (e) => {
        const index = e.target.value - 1;
        setSkiResortSelected(e.target.value);

        // 도착지 정보
        setLift(skiResorts[index].lift);
        setDistance(skiResorts[index].distance);
        setEstimatedTime(skiResorts[index].estimatedTime);
        setLiftSale(skiResorts[index].liftSale);
        setEquipmentSale(skiResorts[index].equipmentSale);
        setSuitSale(skiResorts[index].suitSale);

        // 선택된 요금 초기화
        setPriceLiftItem([]);
        setPriceLiftWeekendItem([]);
        setPriceGondolaItem([]);
        setPriceEquipment(0);
        setPriceSuit(0);
        setQuantity(1);

        // 선택된 할인 초기화
        setLiftSalePercent(1);
        setEquipmentSalePercent(1);
        setSuitSalePercent(1);

        setMessageQuantity("");
    };

    let type_title = "";
    let type_time = "";
    let equipment = 0;
    let suit = 0;

    // 리프트, 리프트(주중) 요금
    let sumPriceLift = 0;
    let liftTime = 0;
    for(let i = 0; i < priceLiftItem.length; i++) {
        const index = priceLiftItem[i] - 1;
        if(lift[index].type_title) type_title = " : " + lift[index].type_title;
        if(lift[index].type_time) type_time = " : " + lift[index].type_time;

        if(lift[index].time) liftTime += lift[index].time;

        if(lift[index].price.lift) sumPriceLift += lift[index].price.lift;
        if(lift[index].price.liftWeekday) sumPriceLift += lift[index].price.liftWeekday;

        if(lift[index].price.equipment) equipment = lift[index].price.equipment;
        if(lift[index].price.equipmentWeekday) equipment = lift[index].price.equipmentWeekday;
        
        if(lift[index].price.suit) suit = lift[index].price.suit;
    }

    // 리프트(주말) 요금
    let sumPriceLiftWeekend = 0;
    for(let i = 0; i < priceLiftWeekendItem.length; i++) {
        const index = priceLiftWeekendItem[i] - 1;
        if(lift[index].type_title) type_title = lift[index].type_title;
        if(lift[index].type_time) type_time = lift[index].type_time;

        if(lift[index].price.liftWeekend) sumPriceLiftWeekend += lift[index].price.liftWeekend;

        if(lift[index].price.equipment) equipment = lift[index].price.equipment;
        if(lift[index].price.equipmentWeekend) equipment = lift[index].price.equipmentWeekend;

        if(lift[index].price.suit) suit = lift[index].price.suit;
    };

    // 곤돌라 요금
    let sumPriceGondola = 0;
    for(let i = 0; i < priceGondolaItem.length; i++) {
        const index = priceGondolaItem[i] - 1;
        if(lift[index].price.gondola === "-") {
            alert("리프트만 이용 가능합니다.");
            setPriceGondolaItem([]);
        }

        if(lift[index].type_title) type_title = lift[index].type_title;
        if(lift[index].type_time) type_time = lift[index].type_time;

        if(lift[index].price.gondola && lift[index].price.gondola !== "-") sumPriceGondola += lift[index].price.gondola;        

        if(lift[index].price.equipment) equipment += lift[index].price.equipment;

        if(lift[index].price.suit) suit = lift[index].price.suit;
    };

    // 리프트 할인
    const liftSaleSelect = (e) => {
        const index = e.target.value - 1;
        if(index === -1 || liftSale[index].percent === "x") setLiftSalePercent(1);
        else setLiftSalePercent(1 - liftSale[index].percent);
    };

    // 총 리프트 요금
    let sumLiftCost = (sumPriceLift + sumPriceLiftWeekend + sumPriceGondola) * liftSalePercent
    let stringLiftCost = sumLiftCost ?
            sumLiftCost.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원" :
            "";

    // 장비 추가 체크
    const onEquipmentChecked = (checked) => {
        if(checked) {
            setPriceEquipment(equipment);
        } else {
            setPriceEquipment(0);
        }
    };

    // 장비 할인
    const equipmentSaleSelect = (e) => {
        const index = e.target.value - 1;
        if(index === -1) setEquipmentSalePercent(1);
        else setEquipmentSalePercent(1 - equipmentSale[index].percent);
    };

    // 총 장비 요금
    let equipmentCost = priceEquipment * equipmentSalePercent;
    let stringEquipmentCost = equipmentCost ?
            " : " + equipmentCost.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원" :
            "";

    // 의류 추가 체크
    const onSuitChecked = (checked) => {
        if(checked) {
            setPriceSuit(suit);
        } else {
            setPriceSuit(0);
        }
    };

    // 의류 할인
    const suitSaleSelect = (e) => {
        const index = e.target.value - 1;
        if(index === -1) setSuitSalePercent(1);
        else setSuitSalePercent(1 - suitSale[index].percent);
    };

    // 총 의류 요금
    let suitCost = priceSuit * suitSalePercent;
    let stringSuitCost = suitCost ?
            " : " + suitCost.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원" :
            "";

    // 리프트 수량
    const onClickQuantityMinus = () => {
        if(quantity > 1) setQuantity(quantity - 1);
        else setQuantity(1);
        if(quantity < 4) setMessageQuantity("");
    }

    const onClickQuantityPlus = () => {
        setQuantity(quantity + 1);
        if(liftSalePercent && quantity === 4) {
            setQuantity(4);
            setMessageQuantity("리프트 할인은 본인 포함 4인까지 가능합니다")
        }
        if(quantity < 4) setMessageQuantity("");
    }

    // 이동수단 변경 시
    useEffect(() => {
        setSocarDrivingCost1("");
        setSocarDrivingCost2("");
        setGreencarDrivingCost("");
    }, [transport]);

    // 주행 요금 계산 ( 편도 )
    let drivingCostOneway = 0;
    if(socarDrivingCost1) { // 쏘카 요금
        let drivingCost30 = 0;
        let drivingCost100 = 0;
        let drivingCost101 = 0;

        if(distance > 30)
                drivingCost30 = 30 * socarDrivingCost2;
        if(distance > 30 && distance <= 100)
                drivingCost100 = (distance - 30) * (socarDrivingCost2 - 10);
        if(distance > 100)
                drivingCost100 = 70 * (socarDrivingCost2 - 10);
        if(distance > 100)
                drivingCost101 = (distance - 100) * socarDrivingCost1;

        drivingCostOneway = drivingCost30 + drivingCost100 + drivingCost101;
    } else if(greencarDrivingCost) {    // 그린카 요금
        drivingCostOneway = distance * greencarDrivingCost;
    }

    // 편도 요금
    let stringDrivingCostOneway = drivingCostOneway ?
            " : " + drivingCostOneway.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원" :
            "";
    // 왕복 요금
    let drivingCostRoundTrip = drivingCostOneway * 2;
    let stringDrivingCostRoundTrip = drivingCostRoundTrip ?
            " : " + drivingCostRoundTrip.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원" :
            "";

    // 총 예상 비용
    let expectedCost = ((sumLiftCost + equipmentCost + suitCost) * quantity) + drivingCostRoundTrip;
    let stringExpectedCost = expectedCost ?
            " : " + expectedCost.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원" :
            "";

    // 리프트 이용 시간
    // parseInt(time / 60);
    let liftTimeHour = liftTime / 60;
    let liftTimeMinute = liftTime % 60;
    let stringLiftTime = liftTimeMinute !== 0 ?
            " : " + liftTimeHour + "시간 " + liftTimeMinute + "분" :
            liftTimeMinute === 0 ? " : " + liftTimeHour + "시간" : ""

    // 스키장 이동 시간 ( 편도 )
    let estimatedTimeHourOneway = parseInt(estimatedTime / 60);
    let estimatedTimeMinuteOneway = estimatedTime % 60;
    let stringExpectedTimeOneway = estimatedTimeMinuteOneway !== 0 ?
            " : " + estimatedTimeHourOneway + "시간 " + estimatedTimeMinuteOneway + "분" :
            estimatedTimeMinuteOneway === 0 ? " : " + estimatedTimeHourOneway + "시간" : ""

    // 왕복 시간
    let estimatedTimeHourRoundTrip = parseInt((estimatedTime * 2) / 60);
    let estimatedTimeMinuteRoundTrip = (estimatedTime * 2) % 60;
    let stringExpectedTimeRoundTrip = estimatedTimeMinuteRoundTrip !== 0 ?
            " : " + estimatedTimeHourRoundTrip + "시간 " + estimatedTimeMinuteRoundTrip + "분" :
            estimatedTimeMinuteRoundTrip === 0 ? " : " + estimatedTimeHourRoundTrip + "시간" : ""

    // 총 예상 시간
    let expectedTimeHour = parseInt(((estimatedTime * 2) + liftTime) / 60);
    let expectedTimeMinute = ((estimatedTime * 2) + liftTime) % 60;
    let stringExpectedTime = expectedTimeMinute !== 0 ?
            " : " + expectedTimeHour + "시간 " + expectedTimeMinute + "분" :
            expectedTimeMinute === 0 ? " : " + expectedTimeHour + "시간" : ""

    // onChange={skiResortSelect}           // value 값 확인 ( OK )
    // console.log(skiResortSelected);
    // console.log(lift);                   // lift 값 확인 ( OK )
    // console.log(transport);              // transport 값 확인 ( OK )
    // console.log(priceItem);              // priceItem 값 확인 ( OK )
    // console.log(sumPriceLift);           // sumPriceLift 값 확인 ( OK )
    // console.log(sumPriceLiftWeekend);    // sumPriceLiftWeekend 값 확인 ( OK )
    // console.log(expectedCost);           // expectedCost 값 확인 ( OK )
    // console.log(drivingCost);            // drivingCost 값 확인 ( OK )
    // console.log(liftSale);               // liftSale 값 확인 ( OK )
    // console.log(percent);                // percent 값 확인 ( OK )

    return (
        <Row className="my-4 col-md-10 mx-auto">
            <Row>
                <Col sm={4}>
                    <Form.Label
                            className="text-primary"
                            style={{ fontWeight: "bold" }}>
                        출발지
                    </Form.Label>
                    <Form.Control
                            type="text"
                            placeholder="서울역"
                            disabled
                            readOnly />
                </Col>
                <Col>
                    <Form.Label
                            className="text-primary"
                            style={{ fontWeight: "bold" }}>
                        도착지
                    </Form.Label>
                    <Form.Select
                            aria-label="skiResorts"
                            onChange={skiResortSelect}>
                        <optgroup label="경기">
                            {skiResorts
                                .filter(skiResort => skiResort.province.includes("경기"))
                                .sort((a, b) => (a.distance > b.distance) ? 1 : -1)
                                .map(skiResort => {
                                    return (
                                        <option key={skiResort.id} value={skiResort.id}>
                                            {skiResort.name}
                                        </option>
                                    );
                                })
                            }
                        </optgroup>
                        <optgroup label="강원">
                            {skiResorts
                                .filter(skiResort => skiResort.province.includes("강원"))
                                .sort((a, b) => (a.distance > b.distance) ? 1 : -1)
                                .map(skiResort => {
                                    return (
                                        <option key={skiResort.id} value={skiResort.id}>
                                            {skiResort.name}
                                        </option>
                                    );
                                })
                            }
                        </optgroup>
                        <optgroup label="전북">
                            {skiResorts
                                .filter(skiResort => skiResort.province.includes("전북"))
                                .sort((a, b) => (a.distance > b.distance) ? 1 : -1)
                                .map(skiResort => {
                                    return (
                                        <option key={skiResort.id} value={skiResort.id}>
                                            {skiResort.name}
                                        </option>
                                    );
                                })
                            }
                        </optgroup>
                    </Form.Select>
                </Col>
            </Row>
            {skiResortSelected && (
                <Row className="mt-3 justify-content-md-center">
                    <Col>
                        <Table hover>
                            <thead className="text-primary">
                                <tr>
                                    <th>리프트권</th>
                                    {lift[0].type_time && <th>시간</th>}
                                    {lift[0].time && <th>(이용시간)</th>}
                                    {lift[0].price.lift &&<th>리프트가격</th>}
                                    {lift[0].price.liftWeekday &&<th>리프트가격(주중)</th>}
                                    {lift[0].price.liftWeekend &&<th>리프트가격(주말)</th>}
                                    {lift[0].price.gondola && <th>곤돌라가격</th>}
                                </tr>
                            </thead>
                            <tbody>
                                {lift.map(lift => {
                                    return (
                                        <SkiResortLiftItem
                                                key={lift.id}
                                                lift={lift}
                                                priceLiftItem={priceLiftItem}
                                                setPriceLiftItem={setPriceLiftItem}
                                                priceLiftWeekendItem={priceLiftWeekendItem}
                                                setPriceLiftWeekendItem={setPriceLiftWeekendItem}
                                                priceGondolaItem={priceGondolaItem}
                                                setPriceGondolaItem={setPriceGondolaItem} />
                                    );
                                })}
                            </tbody>
                        </Table>
                    </Col>
                </Row>
            )}
            <Form.Label
                    className="text-primary"
                    style={{ fontWeight: "bold" }}>
                이동수단
            </Form.Label>
            <Row className="mb-3" xs="auto">
                <Col>
                    <Form.Check
                            type="radio"
                            name="groupTransport"
                            id="socar"
                            value="쏘카"
                            label="쏘카"
                            onChange={(e) => setTransport(e.target.value)} />
                </Col>
                <Col>
                    <Form.Check
                            type="radio"
                            name="groupTransport"
                            id="greencar"
                            value="그린카"
                            label="그린카"
                            onChange={(e) => setTransport(e.target.value)} />
                </Col>
                <Col>
                    <Form.Check
                            type="radio"
                            name="groupTransport"
                            id="notSelected"
                            value="선택안함"
                            label="선택안함"
                            onChange={(e) => setTransport(e.target.value)} />
                </Col>
            </Row>
            {transport === "쏘카" ?
                <Row className="mb-3">
                    <Col sm={2}>
                        <Form.Label>주행요금(원/km)</Form.Label>
                        <Form.Control
                                type="number"
                                min={0}
                                step={10}
                                value={socarDrivingCost1}
                                placeholder="200"
                                onChange={(e) => setSocarDrivingCost1(e.target.value)} />
                    </Col>
                    <Col xs={1} style={{ textAlign: "center", padding: "30px 0 0" }}>~</Col>
                    <Col sm={2}>
                        <Form.Label>주행요금(원/km)</Form.Label>
                        <Form.Control
                                type="number"
                                min={0}
                                step={10}
                                value={socarDrivingCost2}
                                placeholder="220"
                                onChange={(e) => setSocarDrivingCost2(e.target.value)} />
                    </Col>
                </Row>
                : transport === "그린카" ?
                <Row className="mb-3">
                    <Col sm={2}>
                        <Form.Label>주행요금(원/km)</Form.Label>
                        <Form.Control
                                type="number"
                                min={0}
                                step={10}
                                value={greencarDrivingCost}
                                placeholder="200"
                                onChange={(e) => setGreencarDrivingCost(e.target.value)}  />
                    </Col>
                </Row>
                : ""
            }
            <hr />
            <Card className="mt-3" style={{ padding: 0 }}>
                <Card.Header as="b">
                    <Col className="my-2">서울역 → {skiResorts[skiResortSelected - 1].name}</Col>
                </Card.Header>
                <ListGroup variant="flush">
                    <ListGroup.Item>
                        <Col className="mt-2">리프트권 {type_title}</Col>
                        {type_time && <Col className="mt-2">운영시간 {type_time}</Col>}
                        {liftTime !== 0 && <Col className="mt-2">이용시간 {stringLiftTime}</Col>}
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <Row className="mt-2">
                            <Col sm={2}>리프트 요금 : {stringLiftCost}</Col>
                            {(stringLiftCost && liftSale.length !== 0) &&
                                <Col sm={4}>
                                    <Form.Select
                                            size="sm"
                                            onChange={liftSaleSelect}>
                                        <option value={0}>리프트 요금 할인 선택</option>
                                        {liftSale
                                            .map(liftSale => {
                                                return (
                                                    <option key={liftSale.id} value={liftSale.id}>
                                                        {liftSale.sale_title}
                                                    </option>
                                                );
                                            })
                                        }
                                    </Form.Select>
                                </Col>
                            }
                        </Row>
                        <Row>
                        {(stringLiftCost && equipment !== "-") &&
                            <Col sm={2} className="mt-2">
                                <Form.Check>
                                    <Form.Check.Input
                                            type="checkbox"
                                            onChange={(e) => onEquipmentChecked(e.target.checked)} />
                                    <Form.Check.Label>장비 추가{stringEquipmentCost}</Form.Check.Label>
                                </Form.Check>
                            </Col>
                        }
                        {(stringLiftCost && equipmentSale.length !== 0) &&
                            <Col sm={4} className="mt-2">
                                <Form.Select
                                        size="sm"
                                        onChange={equipmentSaleSelect}>
                                    <option value={0}>장비 요금 할인 선택</option>
                                    {equipmentSale
                                        .map(equipmentSale => {
                                            return (
                                                <option key={equipmentSale.id} value={equipmentSale.id}>
                                                    {equipmentSale.sale_title}
                                                </option>
                                            );
                                        })
                                    }
                                </Form.Select>
                            </Col>
                        }
                        </Row>
                        <Row>
                        {(stringLiftCost && suit !== "-") &&
                            <Col sm={2} className="mt-2">
                                <Form.Check>
                                    <Form.Check.Input
                                            type="checkbox"
                                            onChange={(e) => onSuitChecked(e.target.checked)} />
                                    <Form.Check.Label>의류 추가{stringSuitCost}</Form.Check.Label>
                                </Form.Check>
                            </Col>
                        }
                        {(stringLiftCost && suitSale.length !== 0) &&
                            <Col sm={4} className="mt-2">
                                <Form.Select
                                        size="sm"
                                        onChange={suitSaleSelect}>
                                    <option value={0}>의류 요금 할인 선택</option>
                                    {suitSale
                                        .map(suitSale => {
                                            return (
                                                <option key={suitSale.id} value={suitSale.id}>
                                                    {suitSale.sale_title}
                                                </option>
                                            );
                                        })
                                    }
                                </Form.Select>
                            </Col>
                        }
                        </Row>
                        <Row className="mt-3">
                        {stringLiftCost &&
                            <Col>
                                <span className="mx-3">수량</span>
                                <Button variant="outline-secondary" onClick={onClickQuantityMinus}>-</Button>
                                <span className="mx-3">{quantity}</span>
                                <Button variant="outline-secondary" onClick={onClickQuantityPlus}>+</Button>
                            </Col>
                        }
                        {messageQuantity &&
                            <Col sm={3} className="mt-2">
                                <Alert variant="warning" style={{ padding: "8px 16px" }}>
                                    {messageQuantity}
                                </Alert>
                            </Col>
                        }
                        </Row>
                    </ListGroup.Item>
                    <ListGroup.Item>
                        <Col className="mt-2">
                            {transport}{socarDrivingCost1 && socarDrivingCost2 ?
                                    " (" + socarDrivingCost1 + " ~ " + socarDrivingCost2 + "원/km)" :
                                    greencarDrivingCost ? " (" + greencarDrivingCost + "원/km)" : ""}
                        </Col>
                        <Row>
                            <Col sm={6}>
                                <Row>
                                    <Col className="mt-2">주행 거리 (편도) : {distance}km</Col>
                                </Row>
                                <Row>
                                    <Col className="mt-2">주행 시간 (편도) {stringExpectedTimeOneway}</Col>
                                </Row>
                                <Row>
                                    <Col className="my-2">주행 요금 (편도) {stringDrivingCostOneway}</Col>
                                </Row>
                            </Col>
                            <Col sm={6}>
                                <Row>
                                    <Col className="mt-2">주행 거리 (왕복) : {distance * 2}km</Col>
                                </Row>
                                <Row>
                                    <Col className="mt-2">주행 시간 (왕복) {stringExpectedTimeRoundTrip}</Col>
                                </Row>
                                <Row>
                                    <Col className="my-2">주행 요금 (왕복) {stringDrivingCostRoundTrip}</Col>
                                </Row>
                            </Col>
                        </Row>
                    </ListGroup.Item>
                    <Card.Footer as="b">
                        <Col className="mt-2">총 예상 소요 시간 {stringExpectedTime}</Col>
                        <Col className="my-2">총 예상 비용 {stringExpectedCost}</Col>
                    </Card.Footer>
                </ListGroup>
            </Card>
        </Row>
    );

}

export default ExpectedCost;