var express = require('express');
var router = express.Router();
var db = require('../db');

router.get('/list', (req, res) => {
    var word = `%${req.query.word}%`;
    var page = req.query.page;
    var start = (parseInt(page) - 1) * 5;
    var sql = 'select *, date_format(birthday, "%Y-%m-%d") fbirthday from customers where name like ? or job like ? order by id desc limit ?, 5';

    db.get().query(sql, [word, word, start], (err, rows) => {
        var list = rows;
        sql = 'select count(*) total from customers where name like ? or job like ?';
        db.get().query(sql, [word, word], (err, rows) => {
            res.send({ list: list, total: rows[0].total });
        });
    });
})

// file upload
var multer = require('multer');
var upload = multer({
    storage: multer.diskStorage({
        destination: (req, file, done) => {
            done(null, './public/photos')
        },
        filename: (req, file, done) => {
            done(null, Date.now() + '_' + file.originalname)
        }
    })
});

// insert customer
router.post('/insert', upload.single('image'), (req, res) => {
    var name = req.body.name;
    var job = req.body.job;
    var birthday = req.body.birthday;
    var gender = req.body.gender;
    var image = '/photos/' + req.file.filename;
    var sql = 'insert into customers(name, job, birthday, gender, image) values(?, ?, ?, ?, ?)';

    db.get().query(sql, [name, job, birthday, gender, image], (err, rows) => {
        res.sendStatus(200);
    });
})

// change customer state
router.post('/change', (req, res) => {
    var id = req.body.id;
    var state = req.body.state;
    var sql = 'update customers set state = ? where id = ?';

    db.get().query(sql, [state, id], (err, rows) => {
        res.sendStatus(200);
    });
})

router.get('/chart/job_gender', (req, res) => {
    var sql = 'call count_job_gender';
    db.get().query(sql, (err, rows) => {
        var genders = rows[0];  // 성별목록
        var jobs = rows[1]; // 직업목록
        var list = rows[2]; // 직업별, 성별 인원수

        var row = [];
        
        // 첫번째 행
        var col = [];
        col.push('직업명');
        for(var i = 0; i < genders.length; i++) {
            var item = genders[i];
            col.push(item.gender);
        }
        row.push(col);

        // 데이터 행
        var index = 0;
        for(var i = 0; i < jobs.length; i++) {  // 직업이 바뀔때마다
            var col = [];
            for(var j = 0; j < genders.length; j++) {   // 성별이 바뀔때마다
                var item = list[index];
                if(col.length == 0) col.push(item.job);
                col.push(item.count);
                index = index + 1;
            }
            row.push(col);
        }
        res.send(row);
    });
})

// chart
router.get('/chart/:type', (req, res) => {
    var type = req.params.type;
    var sql = ''

    switch(type) {
        case '1':   // 직업별 인원수
        sql = 'select job, count(*) count from customers group by job order by count';

        break;

        case '2':   // 성별별 인원수
        sql = 'select gender, count(*) count from customers group by gender';

        break;

        case '3':   // 성별별 인원수
        sql = 'select month(jdate) month, count(*) from customers where year(jdate) = "2022" group by month order by month';

        break;
    }
    db.get().query(sql, (err, rows) => {
        res.send(rows);
    });
})

module.exports = router;
