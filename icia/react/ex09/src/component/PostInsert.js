import { Button, Dialog, DialogActions, DialogContent, DialogTitle, makeStyles, TextField } from '@material-ui/core'
import axios from 'axios';
import React, { useState } from 'react'

const useStyles = makeStyles((theme) => ({
    formControl: {
      margin: theme.spacing(1),
      minWidth: 160,
    },
    selectEmpty: {
      marginTop: theme.spacing(2),
    },
    txtTitle: {
        width: 500
    },
    txtBody: {
        width: 500
    }
}));

const PostInsert = ({ callAPI }) => {
    const classes = useStyles();

    // dialog box open & close
    const [open, setOpen] = useState(false);
    
    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const [form, setForm] = useState({
        userid: '',
        title: ''
    })
    const {userid, title, body} = form;

    const onChange = (e) => {
        const newForm = {
            ...form,
            [e.target.name]: e.target.value
        }
        setForm(newForm);
    }

    const [value, setValue] = useState('');

    const handleChange = (event) => {
        setValue(event.target.value);
    };

    const onSubmit = async(e) => {
        e.preventDefault();
        if(!window.confirm('새로운 게시글을 등록하시겠습니까?')) return;

        const formData = new FormData();
        formData.append('userid', userid);
        formData.append('title', title);
        formData.append('body', value);

        await axios.post('/posts/insert', formData);
        alert('새로운 게시글이 등록되었습니다.');
        callAPI('');
        setForm({
            userid: '',
            title: '',
            body: ''
        })
    }

    return (
        <>
        <Button variant="contained" color="primary" onClick={handleClickOpen}>
            글쓰기
        </Button>
        <Dialog
            open={open}
            onClose={handleClose}
            aria-labelledby="alert-dialog-title"
            aria-describedby="alert-dialog-description">
            <DialogTitle id="alert-dialog-title">
                게시글 글쓰기
            </DialogTitle>
            <DialogContent>
                <form onSubmit={onSubmit}>
                    <TextField label='ID'
                        variant='standard'
                        type='text'
                        name='userid'
                        value={userid}
                        onChange={onChange}/>
                    <br/><br/>
                    <TextField label='제목'
                        className={classes.txtTitle}
                        variant='standard'
                        type='text'
                        name='title'
                        value={title}
                        onChange={onChange}/>
                    <br/><br/>
                    <TextField label='내용'
                        className={classes.txtBody}
                        multiline
                        rows={10}
                        variant="outlined"
                        value={value}
                        onChange={handleChange}/>
                    <br/><br/>
                </form>
            </DialogContent>
            <DialogActions>
                <Button variant="contained" onClick={onSubmit} color="primary">
                    등록
                </Button>
                <Button variant="outlined" onClick={handleClose} color="primary" autoFocus>
                    닫기
                </Button>
            </DialogActions>
        </Dialog>
        </>
    )
}

export default PostInsert