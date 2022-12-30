var express = require('express');
const { checkout } = require('.');
var router = express.Router();
var db = require('../db');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

// GET login page.
router.get('/login', function(req, res) {
  res.render('index', { title: '로그인', pageName: 'users/login.ejs', userid: req.session.userid })
})

// login check
router.post('/login', function(req, res) {
  var userid = req.body.userid;
  var password = req.body.password;
  var check = req.body.check;
  var sql = 'select * from users where userid = ?';
  var result = 0; // 아이디 없는 경우
  
  db.get().query(sql, [userid], function(err, rows) {
    if(rows.length  > 0) {
      if(rows[0].password == password) {
        result = 1; // login 성공
        req.session.userid = userid;
        // login 상태유지
        if(check == 1) {
          res.cookie('userid', userid, { maxAge: 60 * 60 })
        }
      } else {
        result = 2; //password 틀린 경우
      }
    }
    res.send({ result: result });
  })
})

// logout
router.get('/logout', function(req, res) {
  req.session.destroy();  //session값 삭제
  res.clearCookie('userid');
  res.redirect('/');
})

module.exports = router;
