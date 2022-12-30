var express = require('express');
var router = express.Router();
var db = require('../db');

/* 게시판 목록 page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: '게시판목록', pageName: 'posts.ejs' });
});

// 게시글 데이터 목록
router.get('/list.json', function(req, res) {
    var page = req.query.page;
    var number = parseInt(req.query.number);
    var start = (page-1) * number;
    var list = [];
    var sql = 'select *, date_format(wdate, "%Y-%m-%d %T") fdate from view_posts order by id desc limit ?, ?';
    db.get().query(sql, [start, number], function(err, rows) {
        list = rows;
        sql = 'select count(*) cnt from posts';
        db.get().query(sql, function(err, rows) {
            res.send({ list: list, count: rows[0].cnt })
        });
    })
})

// 게시글 등록 화면 이동
router.get('/insert', function(req, res) {
    res.render('index', { title: '게시판등록', pageName: 'posts/insert.ejs' });
});

// 게시글 DB 등록
router.post('/insert', function(req, res) {
    var title = req.body.title;
    var body = req.body.body;
    var userid = 'blue';
    var sql = 'insert into posts(title, body, userid) values(?, ?, ?)';
    db.get().query(sql, [title, body, userid], function(err, rows) {
        res.redirect('/posts');
    })
});

// 게시글 Read 페이지 이동
router.get('/read', function(req, res) {
    var id = req.query.id;
    var sql = 'select *, date_format(wdate, "%Y-%m-%d %T") fdate from posts where id = ?';
    db.get().query(sql, [id], function(err, rows) {
        res.render('index', { title: '게시글정보', pageName: 'posts/read.ejs', row: rows[0] });
    })
});

// 게시글 DB 수정
router.post('/update', function(req, res) {
    var id = req.body.id;
    var title = req.body.title;
    var body = req.body.body;
    var sql = 'update posts set title = ?, body = ?, wdate = now() where id = ?';
    db.get().query(sql, [title, body, id], function(err, rows) {
        res.redirect('/posts');
    })
});

// 게시글 삭제
router.post('/delete', function(req, res) {
    var id = req.body.id;
    var sql = 'delete from posts where id = ?';
    db.get().query(sql, [id], function(err, rows) {
        res.redirect('/posts');
    })
});

module.exports = router;