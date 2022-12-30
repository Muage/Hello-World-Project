import { CircularProgress, makeStyles, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@material-ui/core';
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Pagination from 'react-js-pagination';
import PostItem from './PostItem';
import SearchAppBar from './SearchAppBar';
import qs from 'qs';
import PostInsert from './PostInsert';

const useStyles = makeStyles({
    table: {
        minWidth: "80%"
    }
})

const PostList = ({ location }) => {
    const object = "posts";
    const search = qs.parse(location.search, {ignoreQueryPrefix: true});
    const classes = useStyles();

    const [posts, setPosts] = useState();
    const [page, setPage] = useState(1);
    const [word, setWord] = useState('');
    const [total, setTotal] = useState(0);

    const callAPI = async() => {
        const result = await axios.get(`/posts?page=${page}&word=${word}`);
        setPosts(result.data.list);
        setTotal(result.data.total);
    }

    useEffect(() => {
        callAPI();
    }, [page, word])

    if(!posts) return <CircularProgress/>

    return (
        <div>
            <SearchAppBar callAPI={callAPI} setWord={setWord} setPage={setPage} object={object}/>

            <div style={{margin: '10px 0'}}>
                <span>전체 {total}</span>
                <PostInsert callAPI={callAPI}/>
            </div>
            <TableContainer component={Paper}>
                <Table className={classes.table} aria-label="simple table">
                    <TableHead style={{background: '#DDD'}}>
                        <TableRow>
                            <TableCell>번호</TableCell>
                            <TableCell align="left">ID</TableCell>
                            <TableCell align="left">제목</TableCell>
                            <TableCell align="left">내용</TableCell>
                            <TableCell align="left">작성일</TableCell>
                            <TableCell align="left">삭제</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {posts.map(p =>
                            <PostItem key={p.id} post={p} callAPI={callAPI}/>
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

export default PostList