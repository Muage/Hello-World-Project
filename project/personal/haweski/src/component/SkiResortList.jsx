import React, { useState } from 'react';
import { Col, Form, Table } from 'react-bootstrap';
import { getSkiResorts } from '../Data';
import SkiResortItem from './SkiResortItem';

const SkiResortList = () => {

    const skiResorts = getSkiResorts();

    const [sorting, setSorting] = useState(0);

    const sortSelect = (e) => {
        setSorting(e.target.value);
    };

    return (
        <div className="my-4 mx-5">
            <Col md={{ span: 4, offset: 8 }}>
                <Form.Select
                        aria-label="sort"
                        className="my-3"
                        onChange={sortSelect}>
                    <option value={0}>스키장순</option>
                    <option value={1}>주소순</option>
                    <option value={2}>거리순</option>
                    <option value={3}>예상소요시간순</option>
                </Form.Select>
            </Col>
            <Table striped hover>
                <thead className="text-primary">
                    <tr>
                        <th>스키장</th>
                        <th>주소</th>
                        <th className="text-center">거리(편도)</th>
                        <th className="text-center">예상소요시간(편도)</th>
                        <th className="text-center">정보</th>
                    </tr>
                </thead>
                <tbody>
                    {!sorting &&
                            skiResorts
                                    .sort((a, b) => (a.name > b.name) ? 1 : -1)
                                    .map(skiResort => {
                                            return (
                                                <SkiResortItem
                                                        key={skiResort.id}
                                                        skiResort={skiResort}/>
                                            );
                                    })}
                    {sorting === "0" &&
                            skiResorts
                                    .sort((a, b) => (a.name > b.name) ? 1 : -1)
                                    .map(skiResort => {
                                            return (
                                                <SkiResortItem
                                                        key={skiResort.id}
                                                        skiResort={skiResort}/>
                                            );
                                    })}
                    {sorting === "1" &&
                            skiResorts
                                    .sort((a, b) => (a.address > b.address) ? 1 : -1)
                                    .map(skiResort => {
                                            return (
                                                <SkiResortItem
                                                        key={skiResort.id}
                                                        skiResort={skiResort}/>
                                            );
                                    })}
                    {sorting === "2" &&
                            skiResorts
                                    .sort((a, b) => (a.distance > b.distance) ? 1 : -1)
                                    .map(skiResort => {
                                            return (
                                                <SkiResortItem
                                                        key={skiResort.id}
                                                        skiResort={skiResort}/>
                                            );
                                    })}
                    {sorting === "3" &&
                            skiResorts
                                    .sort((a, b) => (a.estimatedTime > b.estimatedTime) ? 1 : -1)
                                    .map(skiResort => {
                                            return (
                                                <SkiResortItem
                                                        key={skiResort.id}
                                                        skiResort={skiResort}/>
                                            );
                                    })}
                </tbody>
            </Table>
        </div>
    );
    
};

export default SkiResortList;