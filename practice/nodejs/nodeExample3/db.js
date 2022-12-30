var mysql=require('mysql');
var con;

exports.connect = () => {
    con = mysql.createPool({
        connectionLimit: 100,
        host: 'localhost',
        user: 'nodeExample3',
        password: 'pass',
        database: 'nodeExample3DB',
        port: '3306'
    })
}

exports.get = () => {
    return con;
}