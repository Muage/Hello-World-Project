var express = require('express');
var router = express.Router();
var db = require('../db');

/* GET login page. */
router.get('/login', (req, res, next) => {
	res.render('index', { title: "로그인", pageName: 'user/login.ejs' });
});

router.post('/login', (req, res) => {
	var userid = req.body.userid;
	var userpassword = req.body.userpassword;
	var chkLogin = req.body.chkLogin;
	var sql = "select * from tbl_user where userid = ?";
	db.get().query(sql, [userid], (err, rows) => {
		var result = 0;
		if(rows[0] != null) {
			if(rows[0].userpassword == userpassword) {
				result = 1;
				req.session.userid = userid;
				if(chkLogin == 1)
				res.cookie("userid", id, { maxAge: 1000 * 60 * 60 * 24 });
			} else {
				result = 2;
			}
		}
		res.status(200).send({ result: result });
	});
});

router.get('/logout', (req, res) => {
	req.session.destroy();
	res.clearCookie("userid");
	res.redirect('/');
})

module.exports = router;
