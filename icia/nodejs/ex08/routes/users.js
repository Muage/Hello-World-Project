var express = require('express');
var router = express.Router();
var db = require('../db');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

// GET LOGIN PAGE
router.get('/login', function(req, res) {
  res.render('index', { title: '로그인', pageName: 'login.ejs', userid:req.session.userid })
})

// LOGIN CHECK
router.post('/login', function(req, res) {
  var userid = req.body.userid;
  var password = req.body.password;
  var sql = 'select * from users where userid = ?';
  var result = 0; //아이디가 없는 경우
  db.get().query(sql, [userid], function(err, rows) {
    if(rows.length > 0) {
      if(rows[0].password == password) {
        result = 1; //로그인 성공
        req.session.userid = userid;
      } else {
        result = 2; //비밀번호 틀림
      }
    }
    res.send({ result: result });
  })
})

// LOGOUT
router.get('/logout', function(req, res) {
  req.session.destroy();
  res.redirect('/');
})

module.exports = router;
