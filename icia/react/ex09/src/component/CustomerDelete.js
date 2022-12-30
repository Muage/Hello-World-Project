import { Button, Dialog, DialogActions, DialogContent, DialogTitle, Typography } from '@material-ui/core'
import axios from 'axios';
import React, { useState } from 'react'

const CustomerDelete = ({ state, id, callAPI }) => {
    const [open, setOpen] = useState(false);

    const onClickOpen = () => {
        setOpen(true);
    }

    const onClickClose = () => {
        setOpen(false);
    }

    const onChange = async() => {
        const change = state === '1' ? '0' : '1';
        await axios.post('/customers/change', {id: id, state: change});
        setOpen(false);
        callAPI('');
        alert('변경되었습니다.');
    }

    return (
        <>
        {state === '0' ? 
            <Button variant='contained' color='secondary'
                onClick={onClickOpen}>
                복원
            </Button>:
            <Button variant='outlined' color='secondary'
                onClick={onClickOpen}>
                삭제
            </Button>
        }
        
        <Dialog open={open}>
            <DialogTitle>삭제경고</DialogTitle>
            <DialogContent gutterBottom>
                <Typography>
                    {state === '1' ?
                        '선택한 고객 정보를 삭제하시겠습니까?':
                        '선택한 고객 정보를 복원하시겠습니까?'
                    }
                </Typography>
            </DialogContent>
            <DialogActions>
                <Button variant='contained' color='secondary'
                    onClick={onChange}>예</Button>
                <Button variant='outlined' onClick={onClickClose}>아니요</Button>
            </DialogActions>
        </Dialog>
        </>
    )
}

export default CustomerDelete
