var express = require('express');
var router = express.Router();
var db = require('../db');

// list best product
router.get('/', (req, res) => {
    var sql = 'select *, concat("$", format(price, 3)) fprice from best where isShow = true';

    db.get().query(sql, (err, rows) => {
        res.send(rows);
    })
});

// all list
router.get('/list', (req, res) => {
    var sql = 'select *, concat("$", format(price, 3)) fprice from best order by id desc';

    db.get().query(sql, (err, rows) => {
        res.send(rows);
    })
});

// update show or hide
router.post('/toggle', (req, res) => {
    var isShow = req.body.isShow;
    var id = req.body.id;
    var sql = 'update best set isShow = ? where id = ?';

    db.get().query(sql, [isShow, id], (err, rows) => {
        res.sendStatus(200);
    });
})

// insert best product
// file upload
var multer = require('multer');
var upload = multer({
    storage: multer.diskStorage({
        destination: (req, file, done) => {
            done(null, './public/products')
        },
        filename: (req, file, done) => {
            done(null, Date.now() + '_' + file.originalname)
        }
    })
})

router.post('/insert', upload.single('image'), (req, res) => {
    var title = req.body.title;
    var price = req.body.price;
    var category = req.body.category;
    var linkImg = '/products/' + req.file.filename;
    var sql = 'insert into best(title, price, category, linkImg) values(?, ?, ?, ?)';

    db.get().query(sql, [title, price, category, linkImg], (err, rows) => {
        res.sendStatus(200);
    })
})

// read best product
router.get('/read/:id', (req, res) => {
    var id = req.params.id;
    var sql = 'select *, date_format(wdate, "%Y-%m-%d %T") fdate, concat("$", format(price, 3)) fprice from best where id = ?'

    db.get().query(sql, [id], (err, rows) => {
        res.send(rows[0]);
    })
})

// delete best product
var fs = require('fs');

router.post('/delete', (req, res) => {
    var id = req.body.id;
    var url = req.body.url;
    var sql = 'delete from best where id = ?';

    db.get().query(sql, [id], (err, rows) => {
        res.sendStatus(200);

        fs.unlink("./public" + url, (err) => {
            if(err) console.log('err...' + err);
        });
    });

    
})

module.exports = router;