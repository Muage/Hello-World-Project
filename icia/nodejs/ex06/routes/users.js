var express = require('express');
var router = express.Router();
var db = require('../db');
var fs = require('fs');
var multer = require('multer');

// 사진 파일 업로드
var upload = multer({
  storage: multer.diskStorage({
    destination: (req, file, done) => {
      done(null, './public/photo')
    },
    filename: (req, file, done) => {
      done(null, Date.now() + '_' + file.originalname)
    }
  })
})

// Get 회원정보 페이지
router.get('/read', function(req, res) {
  var userid = req.query.userid;
  var sql = 'select * from users where userid = ?';
  db.get().query(sql, [userid], function(err, rows) {
    res.render('index', {
      title: '정보수정',
      pageName: 'users/read.ejs',
      row: rows[0],
      userid: req.session.userid
    })
  })
})

// 회원정보 DB 저장
router.post('/insert', upload.single('photo'), function(req, res) {
  var userid = req.body.userid;
  var username = req.body.username;
  var password = req.body.password;
  var email = req.body.email;
  var address = req.body.address;
  var photo = req.file.filename;

  console.log(`${userid}\n${username}\n${password}\n${email}\n${address}`);
  var sql = 'insert into users(userid, username, password, email, address, photo) values(?, ?, ?, ?, ?, ?)';
  db.get().query(sql, [userid, username, password, email, address, photo], function(err, rows) {
    res.redirect('/users');
  })
});

// 회원정보 DB 수정
router.post('/update', upload.single('photo'), function(req, res) {
  var userid = req.body.userid;
  var username = req.body.username;
  var password = req.body.password;
  var email = req.body.email;
  var address = req.body.address;
  var photo = req.body.old;
  if(req.file != null) {  //새로 수정한 사진이 있으면 
    photo = req.file.filename;
    // 예전 이미지 삭제
    fs.unlink('./public/photo/' + req.body.old, function(err){});
  }
  var sql = 'update users set username = ?, password = ?, email = ?, address = ?, photo = ? where userid = ?';
  db.get().query(sql, [username, password, email, address, photo, userid], function(err, rows) {
    res.redirect('/users');
  })
})

// 회원가입 페이지
router.get('/insert', function(req, res) {
  res.render('index', {
    title: '회원가입',
    pageName: 'users/insert.ejs',
    userid: req.session.userid
  })
})

// 아이디중복확인
router.get('/check', function(req, res) {
  var userid = req.query.userid;
  var sql = 'select * from users where userid = ?';
  db.get().query(sql, [userid], function(err, rows) {
    res.send({ count: rows.length });

  })
});

/* GET 사용자 목록 페이지 */
router.get('/', function(req, res, next) {
  res.render('index', {
    title: '사용자목록',
    pageName: 'users/list.ejs',
    userid: req.session.userid
  });
});

/* 사용자 목록 데이터 */
router.get('/list.json', function(req, res) {
  var sql = 'select * from users';
  db.get().query(sql, function(err, rows) {
    res.send({ rows:rows });
  })
});

// GET 로그인 페이지
router.get('/login', function(req, res) {
  res.render('index', {
    title: '로그인',
    pageName: 'users/login.ejs',
    userid: req.session.userid
  })
})

// 로그인 확인
router.post('/login', function(req, res) {
  var userid = req.body.userid;
  var password = req.body.password;
  var result = 0; //아이디가 없는 경우
  var sql = 'select * from users where userid = ?';
  db.get().query(sql, [userid], function(err, rows) {
    if(rows.length > 0) {
      if(rows[0].password == password) {
        result = 1; //로그인 성공
        req.session.userid = userid;
      } else {
        result = 2; //비밀번호가 틀린 경우
      }
    }
    res.send({ result: result });
  })
});

// 로그아웃
router.get('/logout', function(req, res) {
  req.session.destroy();
  res.redirect('/');
})

module.exports = router;