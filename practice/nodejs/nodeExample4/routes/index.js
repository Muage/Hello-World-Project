var express = require('express');
var router = express.Router();
var loginCheck = require('./loginCheck');

/* GET home page. */
router.get('/', function (req, res, next) {
	res.render('index', {
		title: "당근마켓",
		pageName: 'products/list.ejs',
		'email': loginCheck.getEmail()
	});
});

module.exports = router;
