create database htmldb;
create user 'html' @'localhost' identified by 'pass';
grant all privileges on htmldb.* to 'html'@'localhost';

create database nodedb;
create user 'node'@'localhost' identified by 'pass';
grant all privileges on nodedb.* to 'node'@'localhost';

create database haksadb;
create user 'haksa'@'localhost' identified by 'pass';
grant all privileges on haksadb.* to 'haksa'@'localhost';

create database webdb;
create user 'web'@'localhost' identified by 'pass';
grant all privileges on webdb.* to 'web'@'localhost';