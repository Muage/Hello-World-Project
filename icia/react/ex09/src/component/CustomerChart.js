import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react'
import { Chart } from "react-google-charts";
import { Link } from 'react-router-dom';
import qs from 'qs';

export const data = [
    ["Year", "Sales", "Expenses", "Profit"],
    ["2014", 1000, 400, 200],
    ["2015", 1170, 460, 250],
    ["2016", 660, 1120, 300],
    ["2017", 1030, 540, 350],
];

const CustomerChart = ({ location }) => {
    const search = qs.parse(location.search, {ignoreQueryPrefix: true});
    const type = search.type;

    const [data, setData] = useState([]);
    
    const title = useRef('직업별 인원수');
    const chartType = useRef('Bar');

    const options = {
        chart: {
            title: title.current
        },
        title: title.current,
        curveType: "function",
        legend: {
            position: "bottom"
        }
    };

    const callAPI = async() => {
        let array = [];
        const result = null;
        switch(type) {
            case '1':
                let result = await axios.get(`/customers/chart/${type}`);
                array = changeData(result.data);
                setData(array);

                break;

            case '2':
                result = await axios.get(`/customers/chart/${type}`);
                array = changeData2(result.data);
                setData(array);

                break;

            case '3':
                result = await axios.get(`/customers/chart/${type}`);
                array = changeData3(result.data);
                setData(array);

                break;

            case '4':
                result = await axios.get('/customers/chart/job_gender');
                setData(result.data);
                setData(array);

                break;
        }
    }

    const changeData = (result) => {
        title.current = '직업별 인원수';
        chartType.current = 'Bar';

        let array = [];
        array.push(['직업명', '인원수']);
        result.forEach(item => {
            array.push([item.job, item.count]);
        });
        return array;
    }

    const changeData2 = (result) => {
        title.current = '성별별 인원수';
        chartType.current = 'PieChart';

        let array = [];
        array.push(['성별', '인원수']);
        result.forEach(item => {
            array.push([item.gender, item.count]);
        });
        return array;
    }

    const changeData3 = (result) => {
        title.current = '2022년 월별 회원가입 인원수';
        chartType.current = 'LineChart';

        let array = [];
        array.push(['월', '인원수']);
        result.forEach(item => {
            array.push([item.month, item.count]);
        });
        return array;
    }

    const changeData4 = (result) => {
        title.current = '직업별/성별 인원수';
        chartType.current = 'Bar';

        let array = [];
        array.push(['직업', '인원수']);
        result.forEach(item => {
            array.push([item.gender, item.count]);
        });
        return array;
    }

    useEffect(() => {
        callAPI();
    }, [type])

    return (
        <div>
            <div className='subMenu'>
                <Link to='/chart?type=1'>직업별 인원수</Link>
                <Link to='/chart?type=2'>성별별 인원수</Link>
                <Link to='/chart?type=3'>월별 회원가입 인원수</Link>
                <Link to='/chart?type=4'>직업별/성별 인원수</Link>
            </div>
            <hr/>
            <Chart
                chartType={chartType.current}
                width="100%"
                height="400px"
                data={data}
                options={options}/>
        </div>
    )
}

export default CustomerChart