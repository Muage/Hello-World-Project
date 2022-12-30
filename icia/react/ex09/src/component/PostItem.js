import { makeStyles, TableCell, TableRow, Typography } from '@material-ui/core';
import React from 'react'
import PostDelete from './PostDelete';

const useStyles = makeStyles({
    title: {
        width: "150px",
        overflow: "hidden",
        textOverflow: "ellipsis",
        display: "-webkit-box",
        "-webkit-line-clamp": "1",
        "-webkit-box-orient": "vertical"
    },
    ellipsis: {
        width: "250px",
        overflow: "hidden",
        textOverflow: "ellipsis",
        display: "-webkit-box",
        "-webkit-line-clamp": "1",
        "-webkit-box-orient": "vertical"
    }
})

const PostItem = ({ post, callAPI }) => {
    const classes = useStyles();

    const {id, userid, title, body, fdate, state} = post;

    return (
        <TableRow>
            <TableCell>{id}</TableCell>
            <TableCell>{userid}</TableCell>
            <TableCell>
                <Typography className={classes.title}>{title}</Typography>
            </TableCell>
            <TableCell>
                <Typography className={classes.ellipsis}>{body}</Typography>
            </TableCell>
            <TableCell>{fdate}</TableCell>
            <TableCell>
                <PostDelete id={id} state={state} callAPI={callAPI}/>
            </TableCell>
        </TableRow>
    )
}

export default PostItem