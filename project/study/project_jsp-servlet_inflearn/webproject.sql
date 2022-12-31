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

insert into professors values('P01','조현영');
insert into professors values('P02','김영한');
insert into professors values('P03','나도코딩');
insert into professors values('P04','HEROPY');
insert into professors values('P05','제주코딩베이스캠프');
insert into professors values('P06','Rookiss');
insert into professors values('P07','목마하임');
insert into professors values('P08','얄팍한 코딩사전');
insert into professors values('P09','워니');
insert into professors values('P10','DevStory');

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

insert into lecture(lecturecode,lecturename,lectureprofessors) values('L001','웹 게임을 만들며 배우는 React','P01');
insert into lecture(lecturecode,lecturename,lectureprofessors) values('L002','스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술','P02');
insert into lecture(lecturecode,lecturename,lectureprofessors) values('L003','파이썬 무료 강의 (활용편6) - 이미지 처리 (OpenCV)','P03');
insert into lecture(lecturecode,lecturename,lectureprofessors) values('L004','Svelte.js 입문 가이드','P04');
insert into lecture(lecturecode,lecturename,lectureprofessors) values('L005','생애 첫 SQL With 제코베','P05');
insert into lecture(lecturecode,lecturename,lectureprofessors) values('L006','[C#과 유니티로 만드는 MMORPG 게임 개발 시리즈] Part1: C# 기초 프로그래밍 입문','P06');
insert into lecture(lecturecode,lecturename,lectureprofessors) values('L007','일주일 완성! 3dsmax 입문 (자동차 및 캐릭터 만들기)','P07');
insert into lecture(lecturecode,lecturename,lectureprofessors) values('L008','제대로 파는 Git & GitHub - by 얄코','P08');
insert into lecture(lecturecode,lecturename,lectureprofessors) values('L009','실제 이력서 사례로 알아보는 [합격하는 이력서] 작성 가이드','P09');
insert into lecture(lecturecode,lecturename,lectureprofessors) values('L010','Flutter 앱 개발 완성','P10');

select * from lecture;

create table enrollments(
	lecturecode char(4) not null,
    usercode char(8) not null, 
    primary key(lecturecode, usercode), 
    foreign key(lecturecode) references lecture(lecturecode), 
    foreign key(usercode) references users(usercode)
);

drop table enrollments;

insert into enrollments values('L001', '10000001');
insert into enrollments values('L002', '10000001');
insert into enrollments values('L003', '10000001');
insert into enrollments values('L004', '10000002');
insert into enrollments values('L005', '10000002');
insert into enrollments values('L006', '10000002');
insert into enrollments values('L007', '10000003');
insert into enrollments values('L008', '10000003');
insert into enrollments values('L009', '10000003');
insert into enrollments values('L010', '10000003');

select * from enrollments;

create view user_enrollments as(
	select u.*, lecturename, lectureimage
    from users u, lecture l, enrollments e
    where u.usercode = e.usercode and l.lecturecode = e.lecturecode
);

drop view user_enrollments;

select * from user_enrollments;

update lecture set lectureimage='01.jpg' where lecturecode='L001';
update lecture set lectureimage='02.png' where lecturecode='L002';
update lecture set lectureimage='03.jpg' where lecturecode='L003';
update lecture set lectureimage='04.jpg' where lecturecode='L004';
update lecture set lectureimage='05.jpg' where lecturecode='L005';