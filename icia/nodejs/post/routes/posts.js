var express = require('express');
var router = express.Router();
var db = require('../db');

/* GET users listing. */
router.get('/', function(req, res, next) {
  var page = parseInt(req.query.page);
  var query = `'%${req.query.word}%'`;
  var start = (page - 1) * 10;
  var condition = `where title like ${query} or body like ${query} or userid like ${query}`;
  var sql = 'select *, date_format(wdate, "%Y-%m-%d %T") fdate from posts '
    + condition + ' order by id desc limit ?, 10';

  db.get().query(sql, [start], (err, rows) => {
    var list = rows;
    sql = 'select count(*) cnt from posts ' + condition;
    db.get().query(sql, function(err, rows) {
      res.send({total: rows[0].cnt , list: list});
    });
  });
});

// post insert
router.post('/insert', function(req, res) {
  var title = req.body.title;
  var body = req.body.body;
  var userid = req.body.userid;
  var sql = 'insert into posts(title, body, userid) values(?, ?, ?)';

  db.get().query(sql, [title, body, userid], (err, rows) => {
    if(err) res.sendStatus(400);
    else res.sendStatus(200);
  })
})

// post read
router.get('/:id', (req, res) => {
  var id = req.params.id;
  var sql = 'select *, date_format(wdate, "%Y-%m-%d %T") fdate from posts where id = ?';
  db.get().query(sql, [id], (err, rows) => {
    res.send(rows[0]);
  })
})

// post delete
router.post('/delete/:id', (req, res) => {
  var id = req.params.id;
  var sql = 'delete from posts where id = ?';
  db.get().query(sql, [id], (err, rows) => {
    if(err) res.sendStatus(400);
    else res.sendStatus(200);
  })
})

// change post state
router.post('/change', (req, res) => {
  var id = req.body.id;
  var state = req.body.state;
  var sql = 'update posts set state = ? where id = ?';

  db.get().query(sql, [state, id], (err, rows) => {
      res.sendStatus(200);
  });
})

// post update
router.post('/update', (req, res) => {
  var id = req.body.id;
  var title = req.body.title;
  var body = req.body.body;
  var sql = 'update posts set title = ?, body = ?, wdate = now() where id = ?';

  db.get().query(sql, [title, body, id], (err, rows) => {
    if(err) res.sendStatus(400);
    else res.sendStatus(200);
  })
})

module.exports = router;
