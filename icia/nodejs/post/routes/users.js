var express = require('express');
var router = express.Router();
var db = require('../db');

/* GET users listing. */
router.get('/list', function(req, res, next) {
  var word = `%${req.query.word}%`;
  var page = req.query.page;
  var start = (page - 1) * 5;
  // console.log('.....', word, page);
  var sql = 'select * from users where uid like ? or uname like ? limit ?, 5';

  db.get().query(sql, [word, word, start], (err, rows) => {
    var list = rows;
    sql = 'select count(*) cnt from users where uid like ? or uname like ?';
    db.get().query(sql, [word, word], (err, rows) => {
      res.send({
        total: rows[0].cnt,
        list: list
      })
    })
  })
});

router.post('/change', (req, res) => {
  var uid = req.body.uid;
  var status = req.body.status;
  var sql = 'update users set status = ? where uid = ?';
  db.get().query(sql, [status, uid], (err, rows) => {
    if(err) res.sendStatus(400)
    else res.sendStatus(200);
  })
})

// user read
router.get('/read/:uid', (req, res) => {
  var uid = req.params.uid;
  var sql = 'select * from users where uid = ?';

  db.get().query(sql, [uid], (err, rows) => {
    res.send(rows[0]);
  })
})

// login check
router.post('/login', (req, res) => {
  var uid = req.body.uid;
  var sql = 'select * from users where uid = ?';

  db.get().query(sql, [uid], (err, rows) => {
    res.send(rows[0]);
  });
})

module.exports = router;
