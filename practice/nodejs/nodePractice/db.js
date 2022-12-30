var mysql = require('mysql');
var conn;

// connect: db 커넥션 풀 생성하는 함수
exports.connect = function() {
    conn = mysql.createPool({
        connectionLimit: 100,
        host: 'localhost',
        user: 'root',
        password: '1234',
        database: 'nodePracticeDB'
    });
};

// 생성한 커넥션 풀 반환하는 함수
exports.get = function() {
    return conn;
};