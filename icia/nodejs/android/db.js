var mysql=require('mysql');
var con;

exports.connect=function(){
    con=mysql.createPool({
        connectionLimit: 100,
        host: 'localhost',
        user: 'android',
        password: 'pass',
        database: 'androiddb'
    })
}

exports.get=function(){
    return con;
}