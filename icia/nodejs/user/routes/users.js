var express = require('express');
const { response } = require('../app');
var router = express.Router();
var db = require('../db');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.render('list');
});

// GET 사용자 목록 데이터
router.get('/list.json', function(req, res) {
  var sql = 'select * from users';
  db.get().query(sql, function(err, rows) {
    res.send(rows);
  })
});

// GET 사용자 등록 페이지
router.get('/insert', function(req, res) {
  res.render('insert');
});

// GET 사용자 정보 Read
router.get('/read.json', function(req, res) {
  var id = req.query.id;
  console.log('id = ' + id);
  var sql = 'select * from users where id = ?';
  db.get().query(sql, [id], function(err, rows) {
    res.send(rows[0]);
  })
});

// GET 사용자 수정 페이지
router.get('/update', function(req, res) {
  var id = req.query.id;
  res.render('update', { userid: id });
});

/* POST users listing. */
// POST 사용자 등록
router.post('/insert', function(req, res) {
  var id = req.body.id;
  var pass = req.body.pass;
  var name = req.body.name;
  // var image = req.body.image;
  var sql = 'insert into users(id, pass, name) values(?, ?, ?)';
  
  db.get().query(sql, [id, pass, name], function(err, rows) {
    if(err) res.sendStatus(400);
    else res.sendStatus(200);
  })
});

// POST 사용자 삭제
router.post('/delete', function(req, res) {
  var id = req.body.id;
  var sql = 'delete from users where id = ?';

  db.get().query(sql, [id], function(err, rows) {
    if(err) res.sendStatus(400);
    else res.sendStatus(200);
   })
});

// POST 사용자 수정
router.post('/update', function(req, res) {
  var id = req.body.id;
  var pass = req.body.pass;
  var name = req.body.name;
  // var image = req.body.image;
  var sql = 'update users set pass = ?, name = ? where id = ?';
  
  db.get().query(sql, [pass, name, id], function(err, rows) {
    if(err) res.sendStatus(400);
    else res.sendStatus(200);
  })
});

module.exports = router;
