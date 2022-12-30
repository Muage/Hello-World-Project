var express = require('express');
var router = express.Router();
var db = require('../db');

/* GET users listing. */
router.get('/', function(req, res, next) {
  var sql = 'select * from users order by id';
  db.get().query(sql, function(err, rows) {
    res.send(rows);
  })
});

// 사용자등록
router.post('/insert', function(req, res) {
  var id = req.body.id;
  var pass= req.body.pass;
  var name = req.body.name;
  var sql = 'insert into users(id, pass, name) values(?, ?, ?)';

  db.get().query(sql, [id, pass, name], function(err, row) {
    if(err) {
      return res.sendStatus(400);
    } else {
      return res.sendStatus(200);
    }
  })
});

// 사용자정보 Read
router.get('/read', function(req, res) {
  var id = req.query.id;
  var sql = 'select * from users where id = ?';

  db.get().query(sql, [id], function(err, rows) {
    res.send(rows[0]);
  })
});

module.exports = router;