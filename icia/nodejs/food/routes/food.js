var express = require('express');
var router = express.Router();
var db = require('../db');

/* 음식점 목록 */
router.get('/list.json', function(req, res, next) {
    var sort = '';
    switch(req.query.order) {
        case "recently":
            sort = 'id desc';
            break;

        case "name":
            sort = 'name';
            break;

        case "tel":
            sort = 'tel';
            break;

        case "address":
            sort = 'address';
            break;
    }
    var word = '%' + req.query.word + '%';
    var sql = 'select * from food where name like ? or tel like ? or address like ? order by ' + sort;
    db.get().query(sql, [word, word, word], function(err, rows) {
        res.send(rows);
    })
});

/* 음식점 정보 */
router.get('/read.json', function(req, res) {
    var id = req.query.id;
    var sql = 'select * from food where id = ?';
    db.get().query(sql, [id], function(err, rows) {
        res.send(rows[0])
    })
});

/* 음식점 저장 DB */
router.post('/insert', function(req, res) {
    var name = req.body.name;
    var tel = req.body.tel;
    var address = req.body.address;
    var x = req.body.x;
    var y = req.body.y;
    var sql = 'insert into food(name, tel, address, x, y) values(?, ?, ?, ?, ?)';
    db.get().query(sql, [name, tel, address, x, y], function(err, rows) {
        if(err) res.sendStatus(400);
        else res.sendStatus(200);
    })
});

/* 음식점 삭제 DB */
router.get('/delete', function(req, res) {
   var id = req.query.id;
   var sql = 'delete from food where id = ?';
   db.get().query(sql, [id], function(err, rows) {
    if(err) res.sendStatus(400);
    else res.sendStatus(200);
   }) 
});

module.exports = router;
