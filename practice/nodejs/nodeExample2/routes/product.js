var express = require('express');
var router = express.Router();
var db = require('../db');
var multer = require('multer')
var fs = require('fs');
var path = require('path');
var uploadPath = './public/upload';

if(!fs.existsSync(uploadPath)) fs.mkdirSync(dir);

var upload = multer({
    storage: multer.diskStorage({
        destination: (req, file, done) => {
            done(null, uploadPath);
        },
        filename: (req, file, done) => {
            var ext = path.extname(file.originalname);
            done(null, path.basename(file.originalname, ext) + Date.now() + ext);
        },
    }),
    limits: { fileSize: 5 * 1024 * 1024 }
})

router.post('/update', upload.single('image'), (req, res) => {
    var code = req.body.code;
    var pname = req.body.pname;
    var price = req.body.price;
    var image = req.body.oldImage;

    // 이미지 변경된 경우
    if(req.file != null) {
        fs.unlink(uploadPath + '/' + image, (err) => {  // 기존 이미지 삭제
            if(err) throw err;
        });
        image = req.file.filename;
    }

    var sql = 'update productinfo set pname = ?, price = ?, image = ? where code = ?';
    
    db.get().query(sql, [pname, price, image, code], (err, result) => {
        if(err) return res.sendStatus(400);
        res.status(200).redirect('/product');
    });
})

router.get('/delete', (req, res) => {
    var code = req.query.code;
    var image = req.query.image;
    var sql = 'delete from productinfo where code = ?';

    db.get().query(sql, [code], (err, result) => {
        if(image != '') {
            fs.unlink(uploadPath + '/' + image, (err) => {
                if(err) throw err;
            });
        }
        res.status(200).redirect('/product');
    });
})

router.get('/read', (req, res, next) => {
    var code = req.query.code;
    var sql = 'select * from productinfo where code = ?';

    db.get().query(sql, [code], (err, rows) => {
        res.render('product/read', { product: rows[0] });
    });
})

router.get('/insert', (req, res, next) => {
    res.render('product/insert', { title: '상품입력' });
})

router.post('/insert', upload.single('image'), (req, res) => {
    var code = req.body.code;
    var pname = req.body.pname;
    var price = req.body.price;
    var image = '';

    if(req.file != null) var image = req.file.filename;

    var sql = 'insert into productinfo(code, pname, price, image) values(?, ?, ?, ?)';

    db.get().query(sql, [code, pname, price, image], (err, result) => {
        if(err) return res.sendStatus(400);
        res.status(200).redirect('/product');
    });
})

router.get('/', function(req, res, next) {
  res.render('product/list', { title: '상품관리' });
})

router.get('/list.json', (req, res) => {
    var sql = 'select * from productinfo';

    db.get().query(sql, (err, rows) => {
        if(err) return res.sendStatus(400);
        // res.status(200).json(rows);
        res.send(rows);
    });
})

module.exports = router;
