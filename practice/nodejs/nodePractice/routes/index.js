var express = require('express');
var router = express.Router();  // 호출
var db = require('../db');

/* GET home page. */
// URL 경로가 '/'일 때 호출되는 함수
// req: HTTP 요청 객체에 대한 정보
// res: HTTP 응답 객체에 대한 정보
router.get('/', function (req, res, next) {
	res.render('index', { title: 'Express' });
});

router.get('/list.json', function (req, res) {
	var query = '%' + req.query.keyword + '%';
	var sql = 'select * from userinfo where id like ?';

	db.get().query(sql, [query], function (err, rows) {
		if (err) return res.sendStatus(400);
		res.status(200).json(rows);
		// res.status(200).send(rows);
		// res.send(rows);
	});
});

router.post('/insert', function (req, res) {
	var id = req.body.id;
	var password = req.body.password;
	var name = req.body.name;
	var sql = 'insert into userinfo(id, password, name) values(?, ?, ?)';

	db.get().query(sql, [id, password, name], function (err, result) {
		if (err) return res.sendStatus(400);
		res.sendStatus(200);
	});
});

// 별도 파일에서 함수 사용할 수 있도록 추가
module.exports = router;
