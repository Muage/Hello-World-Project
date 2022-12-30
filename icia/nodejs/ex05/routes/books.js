var express = require('express');
var router = express.Router();
var db = require('../db');

// 파일 업로드
var multer = require('multer');
var path = "./public/books";
var upload = multer({
    storage: multer.diskStorage({
        destination: (req, file, done) => {
            done(null, path);
        },
        filename: (req, file, done) => {
            done(null, Date.now() + '_' + file.originalname);
        }
    })
})

// 도서 수정 DB
router.post('/update', upload.single('image'), function(req, res) {
    var code = req.body.code;
    var title = req.body.title;
    var contents = req.body.contents;
    var price = req.body.price;
    var image = req.body.old;
    if(req.file != null) {
        image = file.filename;
    }

    var sql = 'update books set title = ?, contents = ?, price = ?, image = ? where code = ?';
    db.get().query(sql, [title, contents, price, image, code], function(err, rows) {
        res.redirect('/books');
    })
});

// 도서 수정 페이지
router.get('/update', function(req, res) {
    var code = req.query.code;
    var sql = 'select * from books where code = ?';
    db.get().query(sql, [code], function(err, rows) {
        res.render('index', {
            title: '도서정보수정',
            pageName: 'books/update.ejs',
            book: rows[0]
        })
    })
});

// 도서 등록 DB
router.post('/insert', upload.single('image'), function(req, res) {
    var title = req.body.title;
    var userid = req.body.userid;
    var contents = req.body.contents;
    var price = req.body.price;
    var image = req.file.filename;
    var sql = 'insert into books(title, userid, contents, price, image) values(?, ?, ?, ?, ?)';
    db.get().query(sql, [title, userid, contents, price, image], function(err, rows) {
        res.redirect('/books');
    })
});

// 도서 등록 페이지
router.get('/insert', function(req, res) {
    res.render('index', { title: '도서등록', pageName: 'books/insert.ejs' })
});

// 도서 목록 출력
router.get('/', function(req, res) {
    res.render('index', { title: '도서목록', pageName: 'books/list.ejs' })
});

/* 특정 도서 정보 */
router.get('/read', function(req, res, next) {
    var code = req.query.code;
    var sql = 'select *, date_format(rdate, "%Y-%m-%d") fdate, format(price, 0) fprice from books where code= ?';
    db.get().query(sql, [code], function(err, rows) {
        res.render('index', {
            title: '도서정보',
            pageName:'books/read.ejs',
            book: rows[0]
        });
    })
});

module.exports = router;