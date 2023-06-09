var express = require('express');
var router = express.Router();
var db = require('../db');

/* 특정 게시글의 댓글 목록 데이터 */
router.get('/list.json', function(req, res, next) {
    var postid = req.query.postid;
    var sql = 'select * from view_comments where postid = ? order by id desc';
    db.get().query(sql, [postid], function(err, rows) {
        res.send(rows);
    })
});

// 댓글 DB 등록
router.post('/insert', function(req, res) {
    var postid = req.body.postid;
    var body = req.body.body;
    var userid = 'blue';
    var sql = 'insert into comments(postid, body, userid) values(?, ?, ?)';
    db.get().query(sql, [postid, body, userid], function(err, rows) {
        res.sendStatus(200);
    })
});

// 댓글 DB 삭제
router.post('/delete', function(req, res) {
    var id = req.body.id;
    var sql = 'delete from comments where id = ?';
    db.get().query(sql, [id], function(err, rows) {
        res.sendStatus(200);
    })
});

// 댓글 DB 수정
router.post('/update', function(req, res) {
    var id = req.body.id;
    var body = req.body.body;
    var sql = 'update comments set body = ? where id = ?';
    db.get().query(sql, [body, id], function(err, rows) {
        res.sendStatus(200);
    })
});

module.exports = router;