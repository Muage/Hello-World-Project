var express = require('express');
var router = express.Router();
var db = require('../db');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'HOME', pageName: 'home.ejs', userid: req.session.userid });
});

// 최근도서
router.get('/new.json', function(req, res) {
  var sql = 'select *, date_format(rdate, "%Y-%m-%d") fdate, format(price, 0) fprice from books order by code desc limit 0, 4';
  db.get().query(sql, function(err, rows) {
    res.send(rows);
  })
});

// 베스트도서
router.get('/best.json', function(req, res) {
  var sql = 'select *, date_format(rdate, "%Y-%m-%d") fdate, format(price, 0) fprice from books order by qnt desc limit 0, 4';
  db.get().query(sql, function(err, rows) {
    res.send(rows);
  })
});

module.exports = router;
