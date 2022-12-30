var express = require('express');
var router = express.Router();
var moment = require('moment');
var loginCheck = require('./loginCheck');
var firebase = require('./firebase');
require('firebase/firestore');
var db = firebase.firestore();
require('firebase/database');
var realdb = firebase.database();

/* GET products listing. */
router.get('/insert', (req, res) => {
	res.render("index", {
		title: "당근마켓",
		pageName: 'products/insert.ejs',
		email: loginCheck.getEmail()
	});
});

// 파일업로드 설정
var multer = require("multer");
var upload = multer({ storage: multer.memoryStorage() });
require('firebase/storage');
var storage = firebase.storage();

// 상품 데이터 저장 및 파일 업로드
router.post('/insert', upload.single("file"), (req, res) => {
	// 파일 업로드
	var file = req.file;
	global.XMLHttpRequest = require("xhr2");
	var fileName = Date.now() + "_" + file.originalname;
	var storageRef = storage.ref().child("image/" + fileName);
	storageRef.put(file.buffer).then((snapshot) => {
		snapshot.ref.getDownloadURL().then(url => {
			// 데이터 저장
			db.collection("product").doc().set({
				name: req.body.name,
				price: parseInt(req.body.price),
				data: moment(new Date()).format("YYYY-MM-DD HH:mm:ss"),
				content: req.body.content,
				cnt_chat: 0,
				url: url,
				image: fileName,
				email: loginCheck.getEmail()
			});
			res.send("success");
		});
	});
});

// 상품 상세 페이지
router.get('/read', (req, res) => {
	var id = req.query.id;
	db.collection("product").doc(id).get().then((doc) => {
		res.render("index", {
			title: "당근마켓",
			pageName: 'products/read.ejs',
			email: loginCheck.getEmail(),
			product: { id: id, data: doc.data() }
		});
	});
});

// 상품 수정 페이지
router.get('/update', (req, res) => {
	var id = req.query.id;
	db.collection("product").doc(id).get().then((doc) => {
		res.render("index", {
			title: "당근마켓",
			pageName: 'products/update.ejs',
			email: loginCheck.getEmail(),
			product: { id: id, data: doc.data() }
		});
	});
});

// 상품 데이터 수정 및 파일업로드
router.post('/update', upload.single("file"), (req, res) => {
	var id = req.body.id;
	var file = req.file;
	var docRef = db.collection("product").doc(id);

	// 수정할 이미지 존재할 경우
	if(file != null) {
		global.XMLHttpRequest = require("xhr2");
		var fileName = Date.now() + "_" + file.originalname;
		var storageRef = storage.ref().child("image/" + fileName);
		storageRef.put(file.buffer).then((snapshot) => {
			snapshot.ref.getDownloadURL().then(url => {
				var url = url;
				docRef.get().then(doc => {
					// 예전 이미지 삭제
					storage.ref().chile("image/" + doc.data().image).delete().then(() => {
						// 상품 정보 수정
						docRef.update({
							name: req.body.name,
							price: req.body.price,
							content: req.body.content,
							image: fileName,
							url: url
						});
						res.send("success");
					});
				});
			});
		});
	} else {	// 수정할 이미지 없을 경우
		docRef.get().then(doc => {
			// 상품 정보 수정
			docRef.update({
				name: req.body.name,
				price: req.body.price,
				content: req.body.content
			});
		});
	}
	res.send("success");
})

// 상품 목록 데이터 생성
router.get('/list.json', (req, res) => {
	var rows = [];
	var loginEmail = loginCheck.getEmail().replace(".", "");
	db.collection("product").orderBy("date", "desc").get().then(snapshot => {
		snapshot.forEach((doc) => {
			var id = doc.id;
			var row = {
				"id": id,
				"email": doc.data().email,
				"name": doc.data().name,
				"price": doc.data().price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ","),
				"date": doc.data().date,
				"url": doc.data().url,
				"cnt_chat": doc.data().cnt_chat,
				"like": 0
			}

			if(loginEmail == null || loginEmail == "") {
				rows.push(row);
			} else {
				realdb.ref("likes/" + id + "/" + loginEmail).on("value", snap => {
					if(snap.exists()) row.like = 1;
					rows.push(row);
				});
			}
		});
		res.send(rows);
	});
});

// 상품 좋아요 추가
router.post('/like/insert', (req, res) => {
	var id = req.body.id;
	var loginEmail = loginCheck.getEmail().replace(".", "");
	var strDate = moment(new Date()).format("YYYY-MM-DD HH:mm:ss")
	realdb.ref("likes/" + id + "/" + loginEmail).set({ date: strDate });
	res.send("success");
});

// 상품 좋아요 삭제
router.post('/like/delete', (req, res) => {
	var id = req.body.id;
	var loginEmail = loginCheck.getEmail().replace(".", "");
	realdb.ref("likes/" + id + "/" + loginEmail).remove();
	res.send("success");
});

// 채팅 페이지
router.get('/chat', (req, res,) => {
	var id = req.query.id;
	db.collection("product").doc(id).get().then((doc) => {
		res.render('index', {
			title: "당근마켓",
			pageName: 'products/chat.ejs',
			email: loginCheck.getEmail(),
			id: id,
			data: doc.data()
		});
	});
});

// 채팅 카운트 증가
router.post('/chat/add_count', (req, res) => {
	var id = req.body.id;
	var ref = db.collection("product").doc(id);
	ref.get().then(doc => {
		var count = doc.data().cnt_chat + 1;
		ref.update({ cnt_chat: count });
	});
});

// 채팅 카운트 감소
router.post('/chat/del_count', (req, res) => {
	var id = req.body.id;
	var ref = db.collection("product").doc(id);
	ref.get().then(doc => {
		var count = doc.data().cnt_chat - 1;
		ref.update({ cnt_chat: count });
	});
});

module.exports = router;
