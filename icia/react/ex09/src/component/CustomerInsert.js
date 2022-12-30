import { Button, Dialog, DialogActions, DialogContent, DialogTitle, FormControl, InputLabel, makeStyles, MenuItem, Select, TextField } from '@material-ui/core';
import axios from 'axios';
import React, { useState } from 'react'

const useStyles = makeStyles((theme) => ({
    formControl: {
      margin: theme.spacing(1),
      minWidth: 160,
    },
    selectEmpty: {
      marginTop: theme.spacing(2),
    }
}));

const CustomerInsert = ({ callAPI }) => {
    // selectbox
    const classes = useStyles();

    const handleChange = (event) => {
        console.log(event.target.value);
        job = event.target.value;
    };

    // dialog box open & close
    const [open, setOpen] = React.useState(false);
    
    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const [form, setForm] = useState({
        name: '무기명',
        birthday: '2000-10-04',
        gender: '남',
        job: '전업주부',
        file: null,
        fileName: ''
    })
    const {name, birthday, gender, job, file, fileName} = form;

    const onChange = (e) => {
        const newForm = {
            ...form,
            [e.target.name]: e.target.value
        }
        setForm(newForm);
    }

    const onChangeFile = (e) => {
        const newForm = {
            ...form,
            file: e.target.files[0],
            fileName: e.target.value
        }
        setForm(newForm);
    }

    const onSubmit = async(e) => {
        e.preventDefault();
        // alert(JSON.stringify(form, null, 4));
        if(!window.confirm('새로운 고객을 등록하시겠습니까?')) return;

        const formData = new FormData();
        formData.append('name', name);
        formData.append('birthday', birthday);
        formData.append('gender', gender);
        formData.append('job', job);
        formData.append('image', file);

        const config = {
            Headers: { 'content-type': 'multipart/form-data'}
        };

        await axios.post('/customers/insert', formData, config);
        alert('새로운 고객이 등록되었습니다.');
        callAPI('');
        setForm({
            name: '아무개',
            birthday: '2000-10-04',
            gender: '여',
            job: '유치원 교사',
            file: null,
            fileName: ''
        })
    }

    return (
        <>
        <Button variant="contained" color="primary" onClick={handleClickOpen}>
            고객 등록
        </Button>
        <Dialog
            open={open}
            onClose={handleClose}
            aria-labelledby="alert-dialog-title"
            aria-describedby="alert-dialog-description">
            <DialogTitle id="alert-dialog-title">
                고객 추가
            </DialogTitle>
            <DialogContent>
                <form onSubmit={onSubmit}>
                    <input
                        style={{display: 'none'}}
                        type='file'
                        name='file'
                        value={fileName}
                        id='file-button'
                        onChange={onChangeFile}/>
                    <label htmlFor='file-button'>
                        <Button variant='contained' name='file' component='span'>
                            {fileName === '' ? '프로필 이미지 선택' : fileName}
                        </Button>
                    </label>
                    <br/><br/>
                    <TextField label='이름'
                        variant='standard'
                        type='text'
                        name='name'
                        value={name}
                        onChange={onChange}/>
                    <br/><br/>
                    <TextField label='생년월일'
                        variant='standard'
                        type='date'
                        name='birthday'
                        value={birthday}
                        onChange={onChange}/>
                    <br/><br/>
                    <TextField label='성별'
                        type='text'
                        name='gender'
                        value={gender}
                        onChange={onChange}/>
                    <br/><br/>
                    <Select label='직업'
                        name="job"
                        value={job}
                        onChange={onChange}>
                        <MenuItem value="">
                            <em>None</em>
                        </MenuItem>
                        <MenuItem value={'전업주부'}>전업주부</MenuItem>
                        <MenuItem value={'회사원'}>회사원</MenuItem>
                        <MenuItem value={'유치원 원장'}>유치원 원장</MenuItem>
                        <MenuItem value={'유치원 원장'}>유치원 교사</MenuItem>
                    </Select>
                </form>
            </DialogContent>
            <DialogActions>
                <Button variant="contained" onClick={onSubmit} color="primary">
                    고객 등록
                </Button>
                <Button variant="outlined" onClick={handleClose} color="primary" autoFocus>
                    닫기
                </Button>
            </DialogActions>
        </Dialog>
        </>
    )
}

export default CustomerInsert