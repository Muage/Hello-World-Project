import { CircularProgress, makeStyles, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@material-ui/core';
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import CustomerInsert from './CustomerInsert';
import CustomerItem from './CustomerItem';
import Pagination from 'react-js-pagination'
import "./Pagination.css"
import SearchAppBar from './SearchAppBar';
import Banner from './Banner';
import qs from 'qs';

const useStyles = makeStyles({
    table: {
        minWidth: "80%"
    }
})

const CustomerList = ({ location }) => {
    const object = "customers";
    const search = qs.parse(location.search, {ignoreQueryPrefix: true});
    const classes = useStyles();

    const [customers, setCustomers] = useState();
    const [page, setPage] = useState(1);
    const [total, setTotal] = useState(0);
    const [word, setWord] = useState('');

    const callAPI = async() => {
        const response = await axios.get(`/customers/list?page=${page}&word=${word}`);
        setCustomers(response.data.list);
        setTotal(response.data.total);
    }

    useEffect(() => {
        // console.log(`page: ${page}`, `word: ${word}`);
        // console.log(object);
        callAPI();
    }, [page, word]);

    if(!customers) return <CircularProgress/>

    return (
        <div>
            <SearchAppBar callAPI={callAPI} setWord={setWord} setPage={setPage} object={object}/>
            <Banner/>
            <div style={{margin: '10px 0'}}>
                <CustomerInsert callAPI={callAPI}/>
                <span>전체 {total}</span>
            </div>
            <TableContainer component={Paper}>
                <Table className={classes.table} aria-label="simple table">
                    <TableHead style={{background: '#DDD'}}>
                        <TableRow>
                            <TableCell>번호</TableCell>
                            <TableCell align="left">이미지</TableCell>
                            <TableCell align="left">이름</TableCell>
                            <TableCell align="left">생년월일</TableCell>
                            <TableCell align="left">성별</TableCell>
                            <TableCell align="left">직업</TableCell>
                            <TableCell align="left">삭제</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {customers.map(c => 
                            <CustomerItem key={c.id} customer={c} callAPI={callAPI}/>
                        )}
                    </TableBody>
                </Table>
            </TableContainer>
            {total > 0 ?
                <Pagination
                activePage={page}
                itemsCountPerPage={5}
                totalItemsCount={total}
                pageRangeDisplayed={10}
                prevPageText={"‹"}
                nextPageText={"›"}
                onChange={(e) => setPage(e)}/> :
                <h1 style={{textAlign: 'center'}}>일치하는 검색 결과가 없습니다.</h1>
            }
            
        </div>
    )
}

export default CustomerList