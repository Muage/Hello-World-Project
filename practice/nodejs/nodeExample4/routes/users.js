var express = require('express');
var router = express.Router();
var loginCheck = require('./loginCheck');
var firebase = require('./firebase');
require('firebase/auth');

router.get('/join', (req, res, next) => {
	res.render("index", {
		title: "당근마켓",
		pageName: 'users/join.ejs',
		email: loginCheck.getEmail()
	});
});

router.post('/join', (req, res) => {
	var email = req.body.email;
	var password = req.body.password;
	firebase.auth().createUserWithEmailAndPassword(email, password)
		.then((result) => {
			var user = result.user;
			res.send("success");
		})
		.catch((error) => {
			var errorMessage = error.message;
			res.send("fail");
		});
});

router.get('/login', (req, res, next) => {
	res.render("index", {
		title: "당근마켓",
		pageName: 'users/login.ejs',
		email: loginCheck.getEmail()
	});
});

router.post('/login', (req, res) => {
	var email = req.body.email;
	var password = req.body.password;
	firebase.auth().signInWithEmailAndPassword(email, password)
		.then((userCredential) => {
			var user = userCredential.user;
			res.send("success");
		})
		.catch((error) => {
			var errorMessage = error.message;
			res.send("fail");
		});
});

router.get('/logout', (req, res) => {
	firebase.auth().signOut().then(() => {
		res.redirect('/');
	});
});

module.exports = router;
