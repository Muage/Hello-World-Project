import React from 'react'
import { Form } from 'react-bootstrap'

function SkiResortLiftItem({ lift, priceLiftItem, setPriceLiftItem, priceLiftWeekendItem, setPriceLiftWeekendItem, priceGondolaItem, setPriceGondolaItem }) {

    const {type_title, type_time, time, price} = lift;

    // 리프트, 리프트(주중) 요금
    const onLiftChecked = (checked, id) => {
        if(checked) {
            setPriceLiftItem(priceLiftItem.concat(id));                                 // id 추가
        } else {
            setPriceLiftItem(priceLiftItem.filter(item => id !== item));                // id 삭제
        }
    };

    // 리프트(주말) 요금
    const onLiftWeekendChecked = (checked, id) => {
        if(checked) {
            setPriceLiftWeekendItem(priceLiftWeekendItem.concat(id));
        } else {
            setPriceLiftWeekendItem(priceLiftWeekendItem.filter(item => id !== item));
        }
    };

    // 곤돌라 요금
    const onGondolaChecked = (checked, id) => {
        if(checked) {
            setPriceGondolaItem(priceGondolaItem.concat(id));
        } else {
            setPriceGondolaItem(priceGondolaItem.filter(item => id !== item));
        }
    };

    // console.log(lift);              // lift 값 확인 ( OK )
    // console.log(priceItem.length)   // priceItem.length 값 확인 ( OK )

    // 리프트 총 이용시간
    let timeHour = parseInt(time / 60);
    let timeMinute = time % 60;
    
    // 리프트 요금
    let liftPrice = price.lift ? price.lift.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원" : "";
    let liftWeekdayPrice = price.liftWeekday ? price.liftWeekday.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원" : "";
    let liftWeekendPrice = price.liftWeekend ? price.liftWeekend.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원" : "";
    let gondolaPrice = price.gondola && price.gondola !== "-" ?
                        price.gondola.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원" :
                        price.gondola === "-" ? "-" : "";

    return (
        <tr>
            <td style={{ border: "none" }}>{type_title}</td>
            {lift.type_time && <td style={{ border: "none" }}>{type_time}</td>}
            <td style={{ border: "none" }}>
                {(time && timeMinute !== 0) ?
                        " ( " + timeHour + "시간 " + timeMinute + "분 )" :
                        (time && timeMinute === 0) ? " ( " + timeHour + "시간 )" : ""}
            </td>
            {liftPrice &&
                <td style={{ border: "none" }}>
                    <Form.Check>
                        <Form.Check.Input
                                type="checkbox"
                                value={lift.id}
                                onChange={(e) => onLiftChecked(e.target.checked, lift.id)}
                                checked={priceLiftItem.includes(lift.id)} />
                        <Form.Check.Label>{liftPrice}</Form.Check.Label>
                    </Form.Check>
                </td>
            }
            {liftWeekdayPrice &&
                <td style={{ border: "none" }}>
                    <Form.Check>
                        <Form.Check.Input
                                type="checkbox"
                                value={lift.id}
                                onChange={(e) => onLiftChecked(e.target.checked, lift.id)}
                                checked={priceLiftItem.includes(lift.id)} />
                        <Form.Check.Label>{liftWeekdayPrice}</Form.Check.Label>
                    </Form.Check>
                </td>
            }
            {liftWeekendPrice &&
                <td style={{ border: "none" }}>
                    <Form.Check>
                        <Form.Check.Input
                                type="checkbox"
                                value={lift.id}
                                onChange={(e) => onLiftWeekendChecked(e.target.checked, lift.id)}
                                checked={priceLiftWeekendItem.includes(lift.id)} />
                        <Form.Check.Label>{liftWeekendPrice}</Form.Check.Label>
                    </Form.Check>
                </td>
            }
            {gondolaPrice && gondolaPrice !== "-" ?
                <td style={{ border: "none" }}>
                    <Form.Check>
                        <Form.Check.Input
                                type="checkbox"
                                value={lift.id}
                                onChange={(e) => onGondolaChecked(e.target.checked, lift.id)}
                                checked={priceGondolaItem.includes(lift.id)} />
                        <Form.Check.Label>{gondolaPrice}</Form.Check.Label>
                    </Form.Check>
                </td>
                : gondolaPrice === "-" ?
                <td style={{ border: "none" }}>
                    <Form.Check>
                        <Form.Check.Label>{gondolaPrice}</Form.Check.Label>
                    </Form.Check>
                </td> : ""
            }
        </tr>
    )
}

export default SkiResortLiftItem