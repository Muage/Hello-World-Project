var express = require('express');
var router = express.Router();

/* 사용자관리 */
router.get('/', function(req, res, next) {
  res.render('index', {title: '사용자목록', pageName: 'users.ejs'});
});

// 데이터베이스 가져오기
var db=require('../db');

// 사용자목록 데이터
router.get('/list.json', function(req, res) {
  // res.send([
  //   {userid: 'red', username: '홍길동', email: 'red@icia.com', address: '인천시 미추홀구 문학동'},
  //   {userid: 'blue', username: '심청이', email: 'blue@icia.com', address: '서울시 구로구 고척동'},
  //   {userid: 'green', username: '강감찬', email: 'green@icia.com', address: '서울시 송파구 잠실동'},
  //   {userid: 'yellow', username: '성춘향', email: 'yellow@icia.com', address: '수원시 장안구 조원동'},
  // ])

  var sql = 'select * from users order by username';
  db.get().query(sql, function(err, rows){
    res.send(rows);
  });
})

// 사용자등록 화면
router.get('/insert', function(req, res){
  res.render('index', {title: '사용자등록', pageName: 'insert.ejs'})
})

// 사용자정보를 DB에 저장
router.post('/insert', function(req, res){
  var userid = req.body.userid;
  var username = req.body.username;
  var email = req.body.email;
  var address = req.body.address;
  console.log(userid + "\n" + username + "\n" + email + "\n" + address);
  var sql = "insert into users(userid, username, email, address) values(?, ?, ?, ?)";
  db.get().query(sql, [userid, username, email, address], function(err, rows){
    res.redirect("/users");
  })
});

// 중복확인
router.get('/check', function(req, res){
  var userid = req.query.userid;
  var sql = "select * from users where userid = ?";
  db.get().query(sql, [userid], function(err, rows){
    res.send({count:rows.length});
  })
});

module.exports = router;
