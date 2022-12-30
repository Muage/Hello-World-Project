var mysql=require('mysql');
var con;

exports.connect=function(){
    con=mysql.createPool({
        connectionLimit: 100,
        host: 'localhost',
        user: 'nodeExample2',
        password: 'pass',
        database: 'nodeExample2DB',
        port: '3306'
    })
}

exports.get=function(){
    return con;
}