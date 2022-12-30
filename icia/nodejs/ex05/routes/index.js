var express = require('express');
var router = express.Router();
var db = require('../db');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: '교보문고', pageName:'home.ejs' });
});


// 도서목록 Data (JSON)
router.get('/list.json', function(req, res) {
  var page = req.query.page;
  var start = (page - 1) * 8;
  var query = '%' + req.query.query + '%';
  var count = 0;
    var sql = 'select count(*) cnt from books where title like ?';
    db.get().query(sql, [query], function(err, rows) {
      count = rows[0].cnt;
      var sql = 'select *, date_format(rdate, "%Y-%m-%d %T") fdate, format(price, 0) fprice from books where title like ? order by code desc limit ?, 8';
      db.get().query(sql, [query, start], function(err, rows) {
        res.send({ count: count, list: rows });
      })
    })
});

module.exports = router;