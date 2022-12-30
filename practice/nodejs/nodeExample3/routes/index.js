var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', (req, res, next) => {
	if(req.cookies.userid) req.session.userid = req.cookies.userid;
	
	res.render('index', {
		title: "학교소개",
		pageName: 'info.ejs',
		userid: req.session.userid
	});
});

module.exports = router;
