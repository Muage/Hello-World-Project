var express = require('express');
var router = express.Router();
var db = require('../db');
var multer = require('multer');
var upload = multer({
    storage: multer.diskStorage({
        destination: (req, file, done) => {
            done(null, './public/upload')
        },
        filename: (req, file, done) => {
            done(null, Date.now() + '_' + file.originalname)
        }
    })
})

/* GET 상품등록 page. */
router.get('/insert', function(req, res, next) {
  res.render('insert');
});

// 상품등록 DB
router.post('/insert', upload.single('image'), function(req, res) {
    var image = '';
    if(req.file != null) image = req.file.filename;
    var name = req.body.name;
    var price = req.body.price;
    var sql = 'insert into product(name, price, image) values(?, ?, ?)';
    db.get().query(sql, [name, price, image], function(err, rows) {
        if(err) res.sendStatus(400);
        else res.sendStatus(200);
    });
});

// 상품목록 Data
router.get('/list.json', function(req, res) {
    var order = req.query.order;
    var sort = '';
    switch(order) {
        case "recently":
            sort = 'code desc';
            break;
        case "low":
            sort = 'price';
            break;

        case "high":
            sort = 'price desc';
            break;
    }
    var word = '%' + req.query.word + '%';
    var sql = 'select * from product where name like ? order by ' + sort;
    db.get().query(sql, [word], function(err, rows) {
        res.send(rows);
    })
});

// 상품정보 Read
router.get('/read.json', function(req, res) {
    var code = req.query.code;
    var sql = 'select * from product where code = ?';
    db.get().query(sql, [code], function(err, rows) {
        res.send(rows[0]);
    })
});

// 상품삭제 DB
router.get('/delete', function(req, res) {
    var code = req.query.code;
    var sql = 'delete from product where code = ?';
    db.get().query(sql, [code], function(err, rows) {
        if(err) res.sendStatus(400);
        else res.sendStatus(200);
    })
});

// 상품수정 DB
router.post('/update', function(req, res) {
    var code = req.body.code;
    var name = req.body.name;
    var price = req.body.price;
    var sql = 'update product set name = ?, price = ? where code = ?';
    db.get().query(sql, [name, price, code], function(err, rows) {
        if(err) res.sendStatus(400);
        else res.sendStatus(200);
    })
});

module.exports = router;
