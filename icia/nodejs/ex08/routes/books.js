var express = require('express');
var router = express.Router();
var db = require('../db');

router.get('/', function(req, res) {
    res.render('index', { title: '도서목록', pageName: 'books/list.ejs', userid: req.session.userid })
});

router.get('/list.json', function(req, res) {
    var sql = 'select * from books order by code desc limit 0, 10';
    db.get().query(sql, function(err, rows) {
        res.send(rows);
    })
})

// GET 도서정보 페이지
router.get('/read', function(req, res) {
    var code = req.query.code;
    var sql = 'select * from books where code = ?';
    db.get().query(sql, [code], function(err, rows) {
        res.render('index', {
            title: '도서정보',
            pageName: 'books/read.ejs',
            userid: req.session.userid,
            row: rows[0]
        })
    })
})

// REVIEW DATA
router.get('/review.json', function(req, res) {
    var code = req.query.code;
    var sql = 'select *, date_format(wdate, "%Y-%m-%d %T") fdate from review where code = ? order by id desc';
    db.get().query(sql, [code], function(err, rows) {
        res.send(rows);
    })
})

// 리뷰등록
router.post('/review/insert', function(req, res) {
    var code = req.body.code;
    var userid = req.session.userid;
    var text = req.body.text;
    var sql = 'insert into review(code, userid, text) values(?, ?, ?)';
    db.get().query(sql, [code, userid, text], function(err, rows) {
        res.sendStatus(200);
    })
})

// 리뷰삭제
router.post('/review/delete', function(req, res) {
    var id = req.body.id;
    var sql = 'delete from review where id = ?';
    db.get().query(sql, [id], function(err, rows) {
        res.sendStatus(200);
    })
})

module.exports = router;