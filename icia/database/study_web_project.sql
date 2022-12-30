use projectdb;

create table users (
	userid varchar(20) not null,
    usercode char(8) not null primary key,
    username varchar(20) not null,
    userpassword varchar(50) not null
);

drop table users;

insert into users(userid, usercode, username, userpassword)
values('green', '10000001', '홍길동', 'pass');

insert into users(userid, usercode, username, userpassword)
values('red', '10000002', '심청이', 'pass');

insert into users(userid, usercode, username, userpassword)
values('blue', '10000003', '강감찬', 'pass');

select * from users;

create table professors(
    professorscode char(3) not null primary key, 
    professorsname varchar(100) not null
);

drop table professors;

select * from professors;

create table lecture (
	lecturecode char(4) not null primary key,
    lecturename varchar(100) not null,
    lectureimage varchar(100),
    lecturecontent varchar(1000),
    lectureprofessors char(3),
    foreign key(lectureprofessors) references professors(professorscode)
);

drop table lecture;

select * from lecture;

create table enrollments(
	lecturecode char(4) not null,
    usercode char(8) not null, 
    primary key(lecturecode, usercode), 
    foreign key(lecturecode) references lecture(lecturecode), 
    foreign key(usercode) references users(usercode)
);

drop table enrollments;

select * from enrollments;