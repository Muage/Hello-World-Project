var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

// 라우트 코드 로딩
var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

// express 객체를 app 변수로 선언
var app = express();

// view engine setup
// app.set(): 익스프레스 환경 설정
// path.join(): 경로 연결
// __dirname: 현재 디렉터리
app.set('views', path.join(__dirname, 'views'));  // 경로 설정: 현재 디렉터리에 있는 views
app.set('view engine', 'ejs');  // 템플릿 엔진 종류 설정

// app.use(): 지정된 인자 실행
app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

// 라우트 설정
app.use('/', indexRouter);
app.use('/users', usersRouter);

// catch 404 and forward to error handler
app.use(function (req, res, next) {
	next(createError(404));
});

// error handler
app.use(function (err, req, res, next) {
	// set locals, only providing error in development
	res.locals.message = err.message;
	res.locals.error = req.app.get('env') === 'development' ? err : {};

	// render the error page
	res.status(err.status || 500);
	res.render('error');
});

// connect 함수 호출
var db = require('./db');

db.connect(function (err) {
	if (err) {
		console.log('Unable to connect to MySQL.');
		process.exit(1);
	}
});

module.exports = app;
