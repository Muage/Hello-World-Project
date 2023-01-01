export function getSkiResorts() {

    // distance:        [ km ]
    // estimatedTime:   [ min ]
    // time:            [ min ]
    // price:           [ 원 ]  / 대인 기준

    return [
        {
            id: 1,
            name: "무주 덕유산 리조트 스키장",
            tel: "063-322-9000",
            link: "https://www.mdysresort.com/",
            address: "전북 무주군 설천면 만선로 185",
            direction: "https://map.naver.com/v5/directions/-/14220597.484902982,4285399.811835928,%EB%AC%B4%EC%A3%BC%20%EB%8D%95%EC%9C%A0%EC%82%B0%20%EB%A6%AC%EC%A1%B0%ED%8A%B8%EC%8A%A4%ED%82%A4%EC%9E%A5,20284202,PLACE_POI/-/car?c=14054726.8915233,4405644.5080696,7,0,0,0,dh",
            x: 35.890327,
            y: 127.737510,
            province: "전북",
            distance: 255,
            estimatedTime: 220,
            image: [
                {
                    id: 1,
                    src: "./image/muju1.jpg"
                },
                {
                    id: 2,
                    src: "./image/muju2.jpg"
                },
                {
                    id: 3,
                    src: "./image/muju3.jpg"
                },
            ],
            lift: [
                {
                    id: 1,
                    type_title: "후야권",
                    type_time: "12:30 ~ 22:00",         // 정설 시간: 16:30 ~ 18:30
                    time: 450,                          // 정설 시간 제외함
                    price: {
                        lift: 94000,                    // 리프트티켓 보증금(1,000)
                        gondola: 109000,
                        equipment: 33000,
                        suit: 19000                     // 헬멧 +5,000원
                    }
                },
                {
                    id: 2,
                    type_title: "주간권",
                    type_time: "09:00 ~ 16:30",
                    time: 450,
                    price: {
                        lift: 86000,
                        gondola: 101000,
                        equipment: 33000,
                        suit: 19000
                    }
                },
                {
                    id: 3,
                    type_title: "오전권",
                    type_time: "09:00 ~ 13:00",
                    time: 240,
                    price: {
                        lift: 61000,
                        gondola: 69000,
                        equipment: 28000,
                        suit: 16000
                    }
                },
                {
                    id: 4,
                    type_title: "오후권",
                    type_time: "12:30 ~ 16:30",
                    time: 240,
                    price: {
                        lift: 61000,
                        gondola: 69000,
                        equipment: 28000,
                        suit: 16000
                    }
                },
                {
                    id: 5,
                    type_title: "야간권",
                    type_time: "18:30 ~ 22:00",
                    time: 240,
                    price: {
                        lift: 61000,
                        gondola: 69000,
                        equipment: 28000,
                        suit: 16000
                    }
                },
                {
                    id: 6,
                    type_title: "야자8권",
                    type_time: "20:00 ~ 24:00",
                    time: 240,
                    price: {
                        lift: 61000,
                        gondola: 69000,
                        equipment: 28000,
                        suit: 16000
                    }
                },
                {
                    id: 7,
                    type_title: "새오권",
                    type_time: "07:00 ~ 12:30",
                    time: 330,
                    price: {
                        lift: 73000,
                        gondola: "-",
                        equipment: 33000,
                        suit: 19000
                    }
                },
                {
                    id: 8,
                    type_title: "야자권",
                    type_time: "18:30 ~ 24:00",
                    time: 330,
                    price: {
                        lift: 73000,
                        gondola: "-",
                        equipment: 33000,
                        suit: 19000
                    }
                },
                {
                    id: 9,
                    type_title: "자정권",
                    type_time: "21:00 ~ 24:00",
                    time: 180,
                    price: {
                        lift: 46000,
                        gondola: "-",
                        equipment: 25000,
                        suit: 16000
                    }
                },
                {
                    id: 10,
                    type_title: "새벽권",
                    type_time: "07:00 ~ 10:00",
                    time: 180,
                    price: {
                        lift: 46000,
                        gondola: "-",
                        equipment: 25000,
                        suit: 19000
                    }
                },
                {
                    id: 11,
                    type_title: "일회권",
                    type_time: "-",
                    price: {
                        lift: 18000,
                        gondola: 23000,
                        equipment: "-",
                        suit: "-"
                    }
                },
            ],
            liftSale: [
                {
                    id: 1,
                    sale_title: "제휴 신용카드: 신한, BC, NH, KB, 하나 (주중: 25%)",
                    percent: 0.25
                },
                {
                    id: 2,
                    sale_title: "제휴 신용카드: 신한, BC, NH, KB, 하나 (주말: 20%)",
                    percent: 0.2
                }
            ],
            equipmentSale: [
                {
                    id: 1,
                    sale_title: "제휴 신용카드: 신한, BC, NH, KB, 하나 (50%)",
                    percent: 0.5
                }
            ],
            suitSale: [
                {
                    id: 1,
                    sale_title: "제휴 신용카드: 신한, BC, NH, KB, 하나 (10%)",
                    percent: 0.1
                }
            ]
        },
        {
            id: 2,
            name: "알펜시아리조트스키장",
            tel: "033-339-0318",
            link: "https://www.alpensia.com/ski/use-cost-lift.do",
            address: "강원 평창군 대관령면 솔봉로 325",
            direction: "https://map.naver.com/v5/directions/-/14323639.792694423,4531243.362653643,%EC%95%8C%ED%8E%9C%EC%8B%9C%EC%95%84%EB%A6%AC%EC%A1%B0%ED%8A%B8%EC%8A%A4%ED%82%A4%EC%9E%A5,32359154,PLACE_POI/-/car?c=14117178.5284838,4532883.9551005,7,0,0,0,dh",
            x: 37.658130,
            y: 128.672852,
            province: "강원",
            distance: 211,
            estimatedTime: 167,
            image: [
                {
                    id: 1,
                    src: "./image/alpensia1.jpg"
                },
                {
                    id: 2,
                    src: "./image/alpensia2.jpg"
                },
                {
                    id: 3,
                    src: "./image/alpensia3.jpg"
                },
            ],
            lift: [
                {
                    id: 1,
                    type_title: "오전권",
                    type_time: "09:00 ~ 13:00",         // 정설 시간: 17:00 ~ 18:30
                    time: 240,                          // 정설 시간 제외함
                    price: {
                        lift: 54000,
                        equipment: 27000,
                        suit: 15000
                    }
                },
                {
                    id: 2,
                    type_title: "오후권",
                    type_time: "13:00 ~ 17:00",
                    time: 240,
                    price: {
                        lift: 54000,
                        equipment: 27000,
                        suit: 15000
                    }
                },
                {
                    id: 3,
                    type_title: "야간권",
                    type_time: "18:30 ~ 22:00",
                    time: 210,
                    price: {
                        lift: 54000,
                        equipment: 27000,
                        suit: 15000
                    }
                },
                {
                    id: 4,
                    type_title: "주간권",
                    type_time: "09:00 ~ 17:00",
                    time: 480,
                    price: {
                        lift: 69000,
                        equipment: 35000,
                        suit: 25000
                    }
                },
                {
                    id: 5,
                    type_title: "후야권",
                    type_time: "13:00 ~ 22:00",
                    time: 450,
                    price: {
                        lift: 69000,
                        equipment: 35000,
                        suit: 25000
                    }
                },
                {
                    id: 6,
                    type_title: "당일권",
                    type_time: "09:00 ~ 22:00",
                    time: 690,
                    price: {
                        lift: 80000,
                        equipment: 44000,
                        suit: 30000
                    }
                },
            ],
            liftSale: [
                {
                    id: 1,  // 본인 포함 4인 적용
                    sale_title: "제휴카드: 신한, BC (30%)",
                    percent: 0.3
                },
                {
                    id: 2,  // 월요일, 화요일
                    sale_title: "신한카드: 야간권 1 + 1",
                    percent: "x"
                },
                {
                    id: 3,  // 금요일, 토요일
                    sale_title: "BC카드: 야간권 1 + 1",
                    percent: "x"
                }
            ],
            equipmentSale: [
                {
                    id: 1,  // 본인 포함 4인 적용
                    sale_title: "제휴카드: 신한, BC (30%)",
                    percent: 0.3
                },
            ],
            suitSale: []
        },
        {
            id: 3,
            name: "휘닉스평창스노우파크",
            tel: "1588-2828",
            link: "https://phoenixhnr.co.kr/static/pyeongchang/guide/price/snowpark",
            address: "강원 평창군 봉평면 태기로 174",
            direction: "https://map.naver.com/v5/directions/-/14284474.712658536,4520270.421957048,%ED%9C%98%EB%8B%89%EC%8A%A4%ED%8F%89%EC%B0%BD%EC%8A%A4%EB%85%B8%EC%9A%B0%ED%8C%8C%ED%81%AC,15783182,PLACE_POI/-/car?c=14148034.8827053,4498549.4235387,8,0,0,0,dh",
            x: 37.581932,
            y: 128.320850,
            province: "강원",
            distance: 169,
            estimatedTime: 138,
            image: [
                {
                    id: 1,
                    src: "./image/pyeongchang1.jpg"
                },
                {
                    id: 2,
                    src: "./image/pyeongchang2.jpg"
                },
                {
                    id: 3,
                    src: "./image/pyeongchang3.jpg"
                },
                {
                    id: 4,
                    src: "./image/pyeongchang4.jpg"
                },
                {
                    id: 5,
                    src: "./image/pyeongchang5.jpg"
                }
            ],
            lift: [
                {
                    id: 1,
                    type_title: "All day pass",
                    type_time: "09:00 ~ 22:00",         // 정설 시간: 16:00 ~ 18:00
                    time: 660,                          // 정설 시간 제외함
                    price: {
                        lift: 110000,
                        equipment: 30000,
                        suit: 18000                     // 고글, 보호대(엉덩이/ 무릎) +8000원, 보호대 추가 +5000원
                    }
                },
                {
                    id: 2,
                    type_title: "Half day pass",
                    type_time: "13:00 ~ 22:00",
                    time: 420,
                    price: {
                        lift: 90000,
                        equipment: 30000,
                        suit: 18000
                    }
                },
                {
                    id: 3,
                    type_title: "Night pass",
                    type_time: "18:00 ~ 22:00",
                    time: 240,
                    price: {
                        lift: 60000,
                        equipment: 30000,
                        suit: 18000
                    }
                }
            ],
            liftSale: [
                {
                    id: 1,
                    sale_title: "제휴카드: 삼성 (30%)",
                    percent: 0.3
                },
                {
                    id: 2,
                    sale_title: "제휴카드: BC, NH농협, 하나 (주중: 30%)",
                    percent: 0.3
                },
                {
                    id: 2,
                    sale_title: "제휴카드: BC, NH농협, 하나 (주말: 20%)",
                    percent: 0.2
                },
            ],
            equipmentSale: [
                {
                    id: 1,
                    sale_title: "제휴카드: 삼성 (30%)",
                    percent: 0.3
                },
                {
                    id: 2,
                    sale_title: "제휴카드: BC, NH농협 (주중: 30%)",
                    percent: 0.3
                },
                {
                    id: 2,
                    sale_title: "제휴카드: BC, NH농협 (주중: 30%, 주말: 20%)",
                    percent: 0.2
                },
            ],
            suitSale: []
        },
        {
            id: 4,
            name: "엘리시안강촌스키장",
            tel: "033-260-2000",
            link: "https://www.elysian.co.kr/gangchon/ski/ski_cost.asp",
            address: "강원 춘천시 남산면 북한강변길 688",
            direction: "https://map.naver.com/v5/directions/-/14203022.263508994,4553568.330113441,%EC%97%98%EB%A6%AC%EC%8B%9C%EC%95%88%EA%B0%95%EC%B4%8C%EC%8A%A4%ED%82%A4%EC%9E%A5,15648643,PLACE_POI/-/car?c=14199878.7437440,4555020.7671657,12,0,0,0,dh",
            x: 37.817844,
            y: 127.587168,
            province: "강원",
            distance: 88,
            estimatedTime: 89,
            image: [
                {
                    id: 1,
                    src: "./image/elysian1.jpg"
                },
                {
                    id: 2,
                    src: "./image/elysian2.jpg"
                },
                {
                    id: 3,
                    src: "./image/elysian3.jpg"
                },
            ],
            lift: [
                {
                    id: 1,
                    type_title: "2시간권",
                    time: 120,                          // 정설 시간 제외함
                    price: {
                        liftWeekday: 48000,
                        liftWeekend: 58000,
                        equipment: 27000,
                        suit: 20000
                    }
                },
                {
                    id: 2,
                    type_title: "4시간권",
                    time: 240,
                    price: {
                        liftWeekday: 58000,
                        liftWeekend: 68000,
                        equipment: 30000,
                        suit: 22000
                    }
                },
                {
                    id: 3,
                    type_title: "6시간권",
                    time: 360,
                    price: {
                        liftWeekday: 68000,
                        liftWeekend: 78000,
                        equipment: 33000,
                        suit: 24000
                    }
                },
                {
                    id: 4,
                    type_title: "8시간권",
                    time: 480,
                    price: {
                        liftWeekday: 78000,
                        liftWeekend: 88000,
                        equipment: 36000,
                        suit: 26000
                    }
                },
                {
                    id: 5,
                    type_title: "1회권",
                    price: {
                        liftWeekday: 16000,
                        liftWeekend: 19000,
                        equipment: "-",
                        suit: "-"
                    }
                }
            ],
            liftSale: [
                {
                    id: 1,  // 본인 포함 4인 적용
                    sale_title: "제휴카드: 신한, BC, KB, NH (30%)",
                    percent: 0.3
                },
                {
                    id: 2,  // 금요일, 토요일 야간
                    sale_title: "BC카드: 야간 6시간권 1 + 1",
                    percent: "x"
                },
                {
                    id: 3,  // 일요일 ~ 목요일
                    sale_title: "KB카드: 야간 4시간권 1 + 1",
                    percent: "x"
                },
                {
                    id: 4,  // 일요일 ~ 목요일
                    sale_title: "NH카드: 야간 4시간권 (50%)",
                    percent: 0.5
                }
            ],
            equipmentSale: [
                {
                    id: 1,  // 본인 포함 4인 적용
                    sale_title: "제휴카드: 신한, BC, KB, NH (30%)",
                    percent: 0.3
                },
            ],
            suitSale: []
        },
        {
            id: 5,
            name: "오크밸리 스키장",                    /** 렌탈 할인 의류 장비 둘 다 포함인지 확인 **/
            tel: "0507-1332-7072",
            link: "https://oakvalley.co.kr/ski/ski_charge_info",
            address: "강원 원주시 지정면 오크밸리2길 58",
            direction: "https://map.naver.com/v5/directions/-/14228390.472647656,4495777.901185365,%EC%98%A4%ED%81%AC%EB%B0%B8%EB%A6%AC%20%EC%8A%A4%ED%82%A4%EC%9E%A5,66928111,PLACE_POI/-/car?c=14227924.6845065,4495777.9011855,15,0,0,0,dh",
            x: 37.403354,
            y: 127.812152,
            province: "강원",
            distance: 105,
            estimatedTime: 99,
            image: [
                {
                    id: 1,
                    src: "./image/oakvalley1.jpg"
                },
                {
                    id: 2,
                    src: "./image/oakvalley2.jpg"
                },
                {
                    id: 3,
                    src: "./image/oakvalley3.jpg"
                },
            ],
            lift: [
                {
                    id: 1,
                    type_title: "오전권",
                    type_time: "09:00 ~ 13:00",         // 정설 시간: 16:30 ~ 17:30
                    time: 240,                          // 정설 시간 제외함
                    price: {
                        lift: 53000,
                        equipment: 24000,
                        suit: 18000                     // 헬멧 +5000원
                    }
                },
                {
                    id: 2,
                    type_title: "오후권",
                    type_time: "12:30 ~ 16:30",
                    time: 240,
                    price: {
                        lift: 53000,
                        equipment: 24000,
                        suit: 18000
                    }
                },
                {
                    id: 3,
                    type_title: "야간권",
                    type_time: "17:30 ~ 22:30",
                    time: 300,
                    price: {
                        lift: 53000,
                        equipment: 24000,
                        suit: 18000
                    }
                },
                {
                    id: 4,
                    type_title: "주간권",
                    type_time: "09:00 ~ 16:30",
                    time: 450,
                    price: {
                        lift: 66000,
                        equipment: 28000,
                        suit: 24000
                    }
                },
                {
                    id: 5,
                    type_title: "오야권",
                    type_time: "12:30 ~ 22:30",
                    time: 540,
                    price: {
                        lift: 66000,
                        equipment: 28000,
                        suit: 24000
                    }
                },
            ],
            liftSale: [
                {
                    id: 1,  // 본인 포함 4인 적용
                    sale_title: "제휴카드: 신한, BC, KB, NH (주중: 30%)",
                    percent: 0.3
                },
                {
                    id: 2,  // 본인 포함 4인 적용
                    sale_title: "제휴카드: 신한, BC, KB, NH (주말: 25%)",
                    percent: 0.25
                },
                {
                    id: 3,  // 월요일, 본인 포함 4인 적용
                    sale_title: "신한카드: 월요일 (45%)",
                    percent: 0.45
                },
                {
                    id: 4,  // 주중 야간, 본인
                    sale_title: "KB카드: 주중 야간권 (50%)",
                    percent: 0.5
                },
                {
                    id: 5,  // 금요일, 토요일 야간, 본인 포함 4인 적용
                    sale_title: "BC카드: 금/토 야간권 1 + 1",
                    percent: "x"
                }
            ],
            equipmentSale: [
                {
                    id: 1,  // 본인 포함 4인 적용
                    sale_title: "제휴카드: 신한, BC, KB, NH (35%)",
                    percent: 0.35
                },
                {
                    id: 2,  // 본인 포함 4인 적용
                    sale_title: "BC카드 QR결제/PAYBOOK: 야간 렌탈 1 + 1",
                    percent: "x"
                },
            ],
            suitSale: []
        },
        {
            id: 6,
            name: "지산포레스트리조트 스키장",
            tel: "031-644-1200",
            link: "https://www.jisanresort.co.kr/w/ski/use/rental.asp",
            address: "경기 이천시 마장면 지산로 267",
            direction: "https://map.naver.com/v5/directions/-/14176019.194064643,4469367.0237550195,%EC%A7%80%EC%82%B0%ED%8F%AC%EB%A0%88%EC%8A%A4%ED%8A%B8%EB%A6%AC%EC%A1%B0%ED%8A%B8%20%EC%8A%A4%ED%82%A4%EC%9E%A5,51978638,PLACE_POI/-/car?c=14175087.6177825,4469367.0237550,14,0,0,0,dh",
            x: 37.217457,
            y: 127.344854,
            province: "경기",
            distance: 79,
            estimatedTime: 79,
            image: [
                {
                    id: 1,
                    src: "./image/jisan1.jpg"
                },
                {
                    id: 2,
                    src: "./image/jisan2.jpg"
                },
                {
                    id: 3,
                    src: "./image/jisan3.jpg"
                },
                {
                    id: 4,
                    src: "./image/jisan4.jpg"
                },
                {
                    id: 5,
                    src: "./image/jisan5.jpg"
                }
            ],
            lift: [
                {
                    id: 1,
                    type_title: "2시간",                // 정설 시간: (일 ~ 목) 17:00 ~ 18:30, (금, 토) 17:00 ~ 18:30 / 23:00 ~ 24:00
                    time: 120,                          // 정설 시간 제외함
                    price: {
                        liftWeekday: 55000,
                        liftWeekend: 65000,
                        equipment: 23000,
                        suit: 20000                     // 헬멧, 보호대, 고글 +5000원
                    }
                },
                {
                    id: 2,
                    type_title: "3시간",
                    time: 180,
                    price: {
                        liftWeekday: 60000,
                        liftWeekend: 72000,
                        equipment: 25000,
                        suit: 25000
                    }
                },
                {
                    id: 3,
                    type_title: "4시간",
                    time: 240,
                    price: {
                        liftWeekday: 65000,
                        liftWeekend: 77000,
                        equipment: 27000,
                        suit: 25000
                    }
                },
                {
                    id: 4,
                    type_title: "6시간",
                    time: 360,
                    price: {
                        liftWeekday: 72000,
                        liftWeekend: 82000,
                        equipment: 30000,
                        suit: 28000
                    }
                },
            ],
            liftSale: [
                {
                    id: 1,  // 본인, 해당기관 증명서류 + 신분증 지참 / 장애인 복지카드 + 신분증 지참 / 신분증 지참
                    sale_title: "군인 / 경찰 / 소방 / 국가유공자 / 장애인 / 생일자 (50%)",
                    percent: 0.5
                },
                {
                    id: 2,  // 본인, 학생증 또는 청소년증 또는 주민등록등본 또는 의료보험증 또는 수험표 지참
                    sale_title: "청소년 / 수험생 (40%)",
                    percent: 0.4
                },
                {
                    id: 3,
                    sale_title: "온라인예매 (30%)",
                    percent: 0.3
                }
            ],
            equipmentSale: [
                {
                    id: 1,  // 본인, 해당기관 증명서류 + 신분증 지참 / 장애인 복지카드 + 신분증 지참 / 신분증 지참
                    sale_title: "군인 / 경찰 / 소방 / 국가유공자 / 장애인 / 생일자 (50%)",
                    percent: 0.5
                },
                {
                    id: 2,  // 본인, 학생증 또는 청소년증 또는 주민등록등본 또는 의료보험증 또는 수험표 지참
                    sale_title: "청소년 / 수험생 (40%)",
                    percent: 0.4
                },
                {
                    id: 3,
                    sale_title: "온라인예매 (30%)",
                    percent: 0.3
                }
            ],
            suitSale: []
        },
        {
            id: 7,
            name: "하이원리조트 스키장",
            tel: "1588-7789",
            link: "https://www.high1.com/ski/contents.do?key=750",
            address: "강원 정선군 고한읍 하이원길 500 밸리스키하우스",
            direction: "https://map.naver.com/v5/directions/-/14342277.057690319,4467588.346611118,%ED%95%98%EC%9D%B4%EC%9B%90%EB%A6%AC%EC%A1%B0%ED%8A%B8%20%EC%8A%A4%ED%82%A4%EC%9E%A5,92136142,PLACE_POI/-/car?c=14342281.5126122,4467643.1270365,18,0,0,0,dh",
            x: 37.207735,
            y: 128.825287,
            province: "강원",
            distance: 241,
            estimatedTime: 192,
            image: [
                {
                    id: 1,
                    src: "./image/high1.jpg"
                },
                {
                    id: 2,
                    src: "./image/high2.jpg"
                },
                {
                    id: 3,
                    src: "./image/high3.jpg"
                },
            ],
            lift: [
                {
                    id: 1,
                    type_title: "3시간",                // 정설 시간: (일 ~ 목) 17:00 ~ 18:30, (금, 토) 17:00 ~ 18:30 / 23:00 ~ 24:00
                    time: 180,                          // 정설 시간 제외함
                    price: {
                        lift: 56000,
                        equipment: 27000,
                    }
                },
                {
                    id: 2,
                    type_title: "4시간",
                    time: 240,
                    price: {
                        lift: 62000,
                        equipment: 25000,
                    }
                },
                {
                    id: 3,
                    type_title: "5시간",
                    time: 300,
                    price: {
                        lift: 68000,
                        equipment: 37000,
                    }
                },
                {
                    id: 4,
                    type_title: "7시간",
                    time: 420,
                    price: {
                        lift: 76000,
                        equipment: 37000,
                    }
                },
                {
                    id: 5,
                    type_title: "종일권",
                    time: 0,
                    price: {
                        lift: 97000,
                        equipment: 54000,
                    }
                },
            ],
            liftSale: [
                {
                    id: 1,  // 본인 포함 2인, 국가유공자증, 복지카드, 신분증 및 경로증
                    sale_title: "국가유공자 / 장애인 / 경로우대 (50%)",
                    percent: 0.5
                },
                {
                    id: 2,  // 본인 포함 4인
                    sale_title: "군인 / 경찰 / 소방 / 문화누리카드 (30%)",
                    percent: 0.3
                },
                {
                    id: 3,  // 본인
                    sale_title: "외국인 (30%)",
                    percent: 0.3
                }
            ],
            equipmentSale: [
                {
                    id: 1,  // 본인 포함 2인, 국가유공자증, 복지카드, 신분증 및 경로증
                    sale_title: "국가유공자 / 장애인 / 경로우대 (50%)",
                    percent: 0.5
                },
                {
                    id: 2,  // 본인 포함 4인
                    sale_title: "군인 / 경찰 / 소방 / 문화누리카드 (30%)",
                    percent: 0.3
                },
                {
                    id: 3,  // 본인
                    sale_title: "외국인 (40%)",
                    percent: 0.4
                }
            ],
            suitSale: []
        },
        {
            id: 8,
            name: "오투리조트 스키장",
            tel: "033-580-7000",
            link: "https://www.o2resort.com/GDE/totalPrice_skiLift.jsp",
            address: "강원 태백시 서학로 861",
            direction: "https://map.naver.com/v5/directions/-/14353690.422442373,4463648.853357786,%EC%98%A4%ED%88%AC%EB%A6%AC%EC%A1%B0%ED%8A%B8%20%EC%8A%A4%ED%82%A4%EC%9E%A5,701834655,PLACE_POI/-/car?c=14352758.8461601,4463648.8533578,14,0,0,0,dh",
            x: 37.177562,
            y: 128.947815,
            province: "강원",
            distance: 265,
            estimatedTime: 217,
            image: [
                {
                    id: 1,
                    src: "./image/o2resort1.jpg"
                },
                {
                    id: 2,
                    src: "./image/o2resort2.jpg"
                },
                {
                    id: 3,
                    src: "./image/o2resort3.jpg"
                },
            ],
            lift: [
                {
                    id: 1,
                    type_title: "주간권",               // 정설 시간: 16:30 ~ 18:00
                    time: 420,
                    price: {
                        lift: 56000,
                        equipment: 23000,
                        suit: 18000
                    }
                },
                {
                    id: 2,
                    type_title: "반일권",
                    time: 210,
                    price: {
                        lift: 42000,
                        equipment: 18000,
                        suit: 14000
                    }
                },
            ],
            liftSale: [],
            equipmentSale: [],
            suitSale: []
        },
        {
            id: 9,
            name: "곤지암리조트 스키장",
            tel: "02-1661-8787",
            link: "https://www.konjiamresort.co.kr/funny/useChargeSkiMeTimePass.dev",
            address: "경기 광주시 도척면 도척윗로 278",
            direction: "https://map.naver.com/v5/directions/-/14170266.959752988,4486154.510509135,%EA%B3%A4%EC%A7%80%EC%95%94%EB%A6%AC%EC%A1%B0%ED%8A%B8%20%EC%8A%A4%ED%82%A4%EC%9E%A5,32350358,PLACE_POI/-/car?c=14169335.3834713,4486154.5105090,14,0,0,0,dh",
            x: 37.337310,
            y: 127.295337,
            province: "경기",
            distance: 65,
            estimatedTime: 70,
            image: [
                {
                    id: 1,
                    src: "./image/konjiam1.jpg"
                },
                {
                    id: 2,
                    src: "./image/konjiam2.jpg"
                },
                {
                    id: 3,
                    src: "./image/konjiam3.jpg"
                },
            ],
            lift: [
                {
                    id: 1,
                    type_title: "1시간권",             // 정설 시간: 18시 ~ 19시 또는 17시 ~ 19시
                    time: 60,                         // 정설 시간 제외함
                    price: {
                        liftWeekday: 32000,
                        liftWeekend: 38000,
                        equipment: 32000,              // 헬멧 +7000원(4시간 이하) / +10000원(4시간 초과), 보호대 +10000원
                        suit: 25000                    // 4시간 이하 25000원, 4시간 초과 32000원
                    }
                },
                {
                    id: 2,
                    type_title: "2시간권",
                    time: 120,
                    price: {
                        liftWeekday: 58000,
                        liftWeekend: 69000,
                        equipment: 32000,
                        suit: 25000
                    }
                },
                {
                    id: 3,
                    type_title: "3시간권",
                    time: 180,
                    price: {
                        liftWeekday: 63000,
                        liftWeekend: 75000,
                        equipment: 32000,
                        suit: 25000
                    }
                },
                {
                    id: 4,
                    type_title: "4시간권",
                    time: 240,
                    price: {
                        liftWeekday: 66000,
                        liftWeekend: 78000,
                        equipment: 32000,
                        suit: 25000
                    }
                },
                {
                    id: 5,
                    type_title: "6시간권",
                    time: 360,
                    price: {
                        liftWeekday: 71000,
                        liftWeekend: 85000,
                        equipment: 32000,
                        suit: 32000
                    }
                },
                {
                    id: 6,  // 2 ~ 6시간권 사용 후 구매 가능
                    type_title: "모바일 전용 1시간 추가",
                    time: 60,
                    price: {
                        liftWeekday: 8000,
                        liftWeekend: 9000,
                        equipment: "-",
                        suit: "-"
                    }
                },
                {
                    id: 7,
                    type_title: "모바일 전용 2시간 추가",
                    time: 120,
                    price: {
                        liftWeekday: 13000,
                        liftWeekend: 15000,
                        equipment: "-",
                        suit: "-"
                    }
                },
            ],
            liftSale: [
                {
                    id: 1,
                    sale_title: "온라인 주중 심야(일 ~ 목, 18시 ~ 02시) (35%)",
                    percent: 0.35
                },
                {
                    id: 2,
                    sale_title: "제휴카드: 신한, BC, 하나 (25%)",
                    percent: 0.25
                }
            ],
            equipmentSale: [
                {
                    id: 1,
                    sale_title: "제휴카드: 신한, BC, 하나 (25%)",
                    percent: 0.25
                }
            ],
            suitSale: []
        },
        {
            id: 10,
            name: "웰리힐리파크스노우파크",
            tel: "1544-8833",
            link: "https://www.wellihillipark.com/home/guide/pay/snowpark",
            address: "강원 횡성군 둔내면 고원로 451-1",
            direction: "https://map.naver.com/v5/directions/-/14276642.94120327,4507232.987859625,%EC%9B%B0%EB%A6%AC%ED%9E%90%EB%A6%AC%ED%8C%8C%ED%81%AC%EC%8A%A4%EB%85%B8%EC%9A%B0%ED%8C%8C%ED%81%AC,31169393,PLACE_POI/-/car?c=14275365.6566771,4507364.4822532,14,0,0,0,dh",
            x: 37.485749,
            y: 128.247400,
            province: "강원",
            distance: 159,
            estimatedTime: 123,
            image: [
                {
                    id: 1,
                    src: "./image/wellihilli1.jpg"
                },
                {
                    id: 2,
                    src: "./image/wellihilli2.jpg"
                },
                {
                    id: 3,
                    src: "./image/wellihilli3.jpg"
                },
            ],
            lift: [ // 리프트권 보증금 1,000원 별도
                {
                    id: 1,
                    type_title: "2시간권",
                    time: 120,                          // 정설 시간 제외함
                    price: {
                        lift: 50000,
                        equipment: 30000,
                        suit: 19000
                    }
                },
                {
                    id: 2,
                    type_title: "3시간권",
                    time: 180,
                    price: {
                        lift: 55000,
                        equipment: 30000,
                        suit: 19000
                    }
                },
                {
                    id: 3,
                    type_title: "4시간권",
                    time: 240,
                    price: {
                        lift: 67000,
                        equipment: 30000,
                        suit: 19000
                    }
                },
                {
                    id: 4,
                    type_title: "6시간권",
                    time: 360,
                    price: {
                        lift: 74000,
                        equipment: 36000,
                        suit: 24000
                    }
                },
                {
                    id: 5,
                    type_title: "8시간권",
                    time: 480,
                    price: {
                        lift: 83000,
                        equipment: 36000,
                        suit: 24000
                    }
                },
                {
                    id: 6,
                    type_title: "1회권",
                    price: {
                        lift: 15000,
                        equipment: "-",
                        suit: "-"
                    }
                }
            ],
            liftSale: [
                {
                    id: 1,
                    sale_title: "제휴카드: KB, BC, 하나, 신한, NH농협 (30%)",
                    percent: 0.3
                },
                {
                    id: 2,
                    sale_title: "온라인 회원 (25%)",
                    percent: 0.25
                }
            ],
            equipmentSale: [
                {
                    id: 1,
                    sale_title: "제휴카드: KB, BC, 하나, 신한, NH농협 (30%)",
                    percent: 0.3
                },
                {
                    id: 2,
                    sale_title: "온라인 회원 (25%)",
                    percent: 0.25
                }
            ],
            suitSale: []
        },
        {
            id: 11,
            name: "용평리조트 스키장",
            tel: "033-335-5757",
            link: "https://www.yongpyong.co.kr/kor/skiNboard/utilizationFee/rentCharge.do",
            address: "강원 평창군 대관령면 올림픽로 715",
            direction: "https://map.naver.com/v5/directions/-/14324089.57909697,4527325.622134058,%EC%9A%A9%ED%8F%89%EB%A6%AC%EC%A1%B0%ED%8A%B8%20%EC%8A%A4%ED%82%A4%EC%9E%A5,60427179,PLACE_POI/-/car?c=14323637.7898198,4528320.9009750,14,0,0,0,dh",
            x: 37.645791,
            y: 128.682426,
            province: "강원",
            distance: 194,
            estimatedTime: 158,
            image: [
                {
                    id: 1,
                    src: "./image/yongpyong1.jpg"
                },
                {
                    id: 2,
                    src: "./image/yongpyong2.jpg"
                },
                {
                    id: 3,
                    src: "./image/yongpyong3.jpg"
                },
            ],
            lift: [ // 보증금 1,000원은 별도
                {
                    id: 1,
                    type_title: "주간권",
                    type_time: "09:00 ~ 17:00",         // 정설 시간: 17:00 ~ 19:00
                    time: 480,                          // 정설 시간 제외함
                    price: {
                        lift: 84000,
                        equipment: 39000,
                        suit: 27000                     // 헬멧 +5000원
                    }
                },
                {
                    id: 2,
                    type_title: "오전권",
                    type_time: "09:00 ~ 13:00",
                    time: 240,
                    price: {
                        lift: 65000,
                        equipment: 34000,
                        suit: 17000
                    }
                },
                {
                    id: 3,
                    type_title: "오후권",
                    type_time: "13:00 ~ 17:00",
                    time: 240,
                    price: {
                        lift: 67000,
                        equipment: 34000,
                        suit: 17000
                    }
                },
                {
                    id: 4,
                    type_title: "야간권",
                    type_time: "19:00 ~ 22:00",
                    time: 180,
                    price: {
                        lift: 59000,
                        equipment: 34000,
                        suit: 17000
                    }
                },
                {
                    id: 5,
                    type_title: "오후야간권",
                    type_time: "13:00 ~ 22:00",
                    time: 420,
                    price: {
                        lift: 95000,
                        equipment: 41000,
                        suit: 27000
                    }
                },
                {
                    id: 6,
                    type_title: "심야권",
                    type_time: "21:00 ~ 23:30",
                    time: 150,
                    price: {
                        lift: 53000,
                        equipment: 30000,
                        suit: 17000
                    }
                },
                {
                    id: 7,
                    type_title: "야간심야권",
                    type_time: "19:00 ~ 23:30",
                    time: 270,
                    price: {
                        lift: 74000,
                        equipment: 37000,
                        suit: 20000
                    }
                },
                {
                    id: 8,
                    type_title: "1회권",
                    type_time: "-",
                    price: {
                        lift: 16000,
                        equipment: "-",
                        suit: "-"
                    }
                },
            ],
            liftSale: [
                {
                    id: 1,  // 본인 포함 4인
                    sale_title: "제휴카드: BC, KB, 신한, NH농협, 하나 (25%)",
                    percent: 0.25
                },
            ],
            equipmentSale: [
                {
                    id: 1,
                    sale_title: "제휴카드: BC, KB, 신한, NH농협, 하나 (30%)",
                    percent: 0.3
                },
            ],
            suitSale: []
        },
        {
            id: 12,
            name: "비발디파크",
            tel: "1588-4888",
            link: "https://www.sonohotelsresorts.com/daemyung.vp.skiworld.04_04_01.ds/dmparse.dm",
            address: "강원 홍천군 서면 한치골길 262 비발디파크",
            direction: "https://map.naver.com/v5/directions/-/14214112.579098765,4528795.147351177,%EB%B9%84%EB%B0%9C%EB%94%94%ED%8C%8C%ED%81%AC,56317478,PLACE_POI/-/car?c=14213541.0314369,4529776.6703290,15,0,0,0,dh",
            x: 37.646654,
            y: 127.681356,
            province: "강원",
            distance: 93,
            estimatedTime: 87,
            image: [
                {
                    id: 1,
                    src: "./image/vivaldi1.jpg"
                },
                {
                    id: 2,
                    src: "./image/vivaldi2.jpg"
                },
                {
                    id: 3,
                    src: "./image/vivaldi3.jpg"
                },
                {
                    id: 4,
                    src: "./image/vivaldi4.jpg"
                },
                {
                    id: 5,
                    src: "./image/vivaldi5.jpg"
                }
            ],
            lift: [
                {
                    id: 1,
                    type_title: "3시간권",             // 정설 시간: 16:30 ~ 18:30
                    type_time: "-",
                    time: 180,                         // 정설 시간 제외함
                    price: {
                        liftWeekday: 60000,
                        liftWeekend: 65000,
                        equipmentWeekday: 30000,       // 헬멧 +7000원(4시간 이하) / +10000원(4시간 초과), 보호대 +10000원
                        equipmentWeekend: 35000,
                        suit: 22000
                    }
                },
                {
                    id: 2,
                    type_title: "5시간권",
                    type_time: "-",
                    time: 300,
                    price: {
                        liftWeekday: 72000,
                        liftWeekend: 77000,
                        equipmentWeekday: 34000,
                        equipmentWeekend: 39000,
                        suit: 28000
                    }
                },
                {
                    id: 3,
                    type_title: "7시간권",
                    type_time: "-",
                    time: 420,
                    price: {
                        liftWeekday: 80000,
                        liftWeekend: 85000,
                        equipmentWeekday: 38000,
                        equipmentWeekend: 43000,
                        suit: 33000
                    }
                },
                {
                    id: 4,
                    type_title: "밤샘권",
                    type_time: "20:00 ~ 03:00",
                    time: 420,
                    price: {
                        liftWeekday: 74000,
                        liftWeekend: 79000,
                        equipmentWeekday: 36000,
                        equipmentWeekend: 41000,
                        suit: 25000
                    }
                },
                {
                    id: 5,
                    type_title: "새벽권",
                    type_time: "23:00 ~ 03:00",
                    time: 240,
                    price: {
                        liftWeekday: 61000,
                        liftWeekend: 66000,
                        equipmentWeekday: 31000,
                        equipmentWeekend: 36000,
                        suit: 14000
                    }
                },
            ],
            liftSale: [
                {
                    id: 1,  // 본인 포함 4명
                    sale_title: "제휴카드: BC, 신한, KB, NH농협, 하나 (30%)",
                    percent: 0.3
                },
                {
                    id: 2,
                    sale_title: "KB 국민카드: 08:30 ~ 16:30 발권 (50%)",
                    percent: 0.5
                },
                {
                    id: 3,
                    sale_title: "카카오페이: 주간 타임패스 리프트 + 렌탈 1 + 1",
                    percent: "x"
                },
                {
                    id: 4,  // 16:30분 이후 발권
                    sale_title: "BC카드: 야간 타임패스 리프트 + 렌탈 1 + 1",
                    percent: "x"
                }
            ],
            equipmentSale: [],
            suitSale: []
        }
    ]
}