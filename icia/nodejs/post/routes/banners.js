var express = require('express');
var router = express.Router();
var db = require('../db');

router.get('/list', (req, res) => {
    var sql = 'select * from banner order by id desc';

    db.get().query(sql, (err, rows) => {
        res.send(rows);
    })
})

router.get('/show', (req, res) => {
    var sql = 'select * from banner where bshow = 1 order by id desc';

    db.get().query(sql, (err, rows) => {
        res.send(rows);
    })
})

// 상태변경
router.post('/change', (req, res) => {
    var id = req.body.id;
    var bshow = req.body.bshow;
    // console.log(id, bshow);
    var sql = 'update banner set bshow = ? where id = ?';

    db.get().query(sql, [bshow, id], (err, rows) => {
        res.sendStatus(200);
    })
})

// 파일업로드
var multer = require('multer');
var upload = multer({
    storage: multer.diskStorage({
        destination: (req, file, done) => {
            done(null, './public/images')
        },
        filename: (req, file, done) => {
            done(null, Date.now() + '_' + file.originalname)
        }
    })
})

// insert
router.post('/insert', upload.single('image'), (req, res) => {
    var title = req.body.title;
    var url = '/images/' + req.file.filename;
    var sql = 'insert into banner(title, url) values(?, ?)';

    db.get().query(sql, [title, url], (err, rows) => {
        res.sendStatus(200);
    })
})

// insert -> ejs로 테스트
router.get('/insert', (req, res) => {
    res.render('insert');
})

// delete
var fs = require('fs'); // 파일 삭제 내장 라이브러리 file system

router.post('/delete', (req, res) => {
    var id = req.body.id;
    var url = req.body.url;
    var sql = 'delete from banner where id = ?';

    db.get().query(sql, [id], (err, rows) => {
        res.sendStatus(200);
        fs.unlink("/data/node/post/public" + url, (err) => {
            if(err) console.log('err...' + err);
        });
    });
})

// 베너 정보 read
router.get('/read/:id', (req, res) => {
    var id = req.params.id;
    var sql = 'select * from banner where id = ?';

    db.get().query(sql, [id], (err, rows) => {
        res.send(rows[0]);
    })
})

module.exports = router;