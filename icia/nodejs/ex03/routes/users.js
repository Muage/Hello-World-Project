var express = require('express');
var router = express.Router();
var db = require('../db');

/* 사용자관리 */
router.get('/', function(req, res, next) {
  res.render('index', { title: '사용자목록', pageName: 'users.ejs' })
});

// 사용자 목록 데이터 (JSON)
router.get('/list.json', function(req, res) {
  var sql = 'select * from users';
  db.get().query(sql, function(err, rows){
    console.log('err......' + err);
    res.send(rows)
  });
})

// 사용자 등록 화면
router.get('/insert', function(req, res) {
  res.render('index', { title: '사용자등록', pageName: 'users/insert.ejs' })
});

// 사용자 데이터를 데이터베이스에 저장
router.post('/insert', function(req, res) {
  var userid = req.body.userid;
  var username = req.body.username;
  var email = req.body.email;
  var address = req.body.address;
  var sql = 'insert into users (userid, username, email, address) values (?, ?, ?, ?)';
  db.get().query(sql, [userid, username, email, address], function(err, row){
    console.log('err......' + err);
    res.redirect('/users')
  })
});

// 중복확인
router.get('/check', function(req, res) {
  var userid = req.query.userid;
  var sql = 'select * from users where userid = ?';
  db.get().query(sql, [userid], function(err, rows){
    res.send({ count: rows.length });
  })
});

// 사용자 Read 페이지 이동
router.get('/read', function(req, res) {
  var userid = req.query.userid;
  var sql = 'select * from users where userid = ?';
  db.get().query(sql, [userid], function(err, rows){
    res.render('index', { title: '사용자정보', pageName: 'users/read.ejs', row: rows[0] })
  })
});

// 사용자정보 DB에 저장
router.post('/update', function(req, res){
  var userid = req.body.userid;
  var username = req.body.username;
  var email = req.body.email;
  var address = req.body.address;
  var sql = 'update users set username = ?, email = ?, address = ? where userid = ?';
  db.get().query(sql, [username, email, address, userid], function(err, row){
    console.log('err......' + err);
    res.redirect('/users');
  })
});

// 사용자 DB에서 삭제
router.post('/delete', function(req, res){
  var userid = req.body.userid;
  var sql = 'delete from users where userid = ?';
  db.get().query(sql, [userid], function(err, rows){
    console.log('err......' + err);
    res.redirect('/users'); //사용자목록으로 이동
  })
});

// 특정 사용자가 작성한 게시글 갯수
router.get('/count', function(req, res) {
  var userid = req.query.userid;
  var sql = 'select * from posts where userid = ?';
  db.get().query(sql, [userid], function(err, rows) {
    res.send({ count: rows.length })
  })
})

module.exports = router;
