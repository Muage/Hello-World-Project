create table posts(
	id int auto_increment not null primary key,
    title varchar(500) not null,
    userid varchar(20) not null,
    body varchar(2000) not null,
    wdate datetime default now()
);

desc posts;

insert into posts(title, userid, body)
values('제네시스 전기차 배터리 표기 관련 고객 안내','red','제네시스는 전기차의 고전압 배터리 제원을 표기할 때 ‘리튬이온 배터리’와 ’리튬이온 폴리머 배터리’라는 표현을 혼용해서 사용해왔으나, 이로 인해 고객 여러분들께 혼선을 드린 점 진심으로 사과드립니다.');
insert into posts(title, userid, body)
values('G90 디지털 키 2, 빌트인 캠 무선 소프트웨어 업데이트','blue','무선 업데이트를 통해 순차적으로 업데이트를 진행하며 차량 별 업데이트 시작 및 완료 시점은 차이가 날 수 있습니다.');
insert into posts(title, userid, body)
values('My Genesis 위치기반서비스 이용약관 개정 공지','green','My Genesis 위치기반서비스 이용약관이 아래와 같이 변경됨을 알려드립니다.');
insert into posts(title, userid, body)
values('제네시스 어카운트 개인정보 처리방침 개정 공지','yellow','제네시스 어카운트 개인정보 처리방침이 아래와 같이 변경됨을 알려드립니다.');
insert into posts(title, userid, body)
values('Genesis Connected Services 이용약관 개정 공지','red','Genesis Connected Services 이용약관이 아래와 같이 변경됨을 알려드립니다.');

select * from posts;

create table users(
	userid varchar(20) not null primary key,
    username varchar(20) not null,
    email varchar(50) not null,
    address varchar(200)
);

insert into users(userid, username, email, address)
values('red', '홍길동', 'red@icia.com', '인천시 미추홀구 문학동');
insert into users(userid, username, email, address)
values('blue', '심청이', 'blue@icia.com', '서울시 구로구 고척동');
insert into users(userid, username, email, address)
values('green', '강감찬', 'green@icia.com', '서울시 송파구 잠실동');
insert into users(userid, username, email, address)
values('yellow', '성춘향', 'yellow@icia.com', '수원시 장안구 조원동');

select * from users;

alter table posts
add foreign key(userid)
references users(userid);

drop view view_posts;

create view view_posts as
select posts.*, username, address, email
from posts, users
where posts.userid = users.userid;

select * from view_posts;

select * from view_posts
where username like '%%'
order by username;

create view view_posts as
select posts.*, username, email, address
from posts, users
where posts.userid = users.userid;

select * from posts where userid = red;

select *, date_format(wdate, "%Y-%m-%d %T") fdate
from view_posts order by id desc
limit 0, 8;

insert into posts(title, userid, body)
select title, userid, body from posts;

select count(*) from posts;

create table comments(
	id int auto_increment primary key,
    postid int not null,
    body varchar(2000) not null,
    userid varchar(20) not null,
    foreign key(postid) references posts(id),
    foreign key(userid) references users(userid)
);

insert into comments(postid, userid, body)
values(200, 'green', 'laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium');
insert into comments(postid, userid, body)
values(200, 'red', 'est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et');
insert into comments(postid, userid, body)
values(200, 'blue', 'quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione');

insert into comments(postid, userid, body)
values(201, 'green', 'laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium');
insert into comments(postid, userid, body)
values(201, 'red', 'est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et');
insert into comments(postid, userid, body)
values(201, 'blue', 'quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione');

create view view_comments as
select c.*, username, email, address
from comments c, users u
where c.userid = u.userid;

select * from view_comments where postid = 200;

/* ex05 */
create table books(
	code int auto_increment primary key,
    title varchar(200) not null,
    image varchar(200) not null,
    price int default 0,
    rdate datetime default now(),
    contents varchar(2000),
    userid varchar(20) not null,	/* 등록자 */
    qnt int default 0,
    foreign key(userid) references users(userid)
);

drop table books;

desc books;

insert into books(title, image, price, userid)
values('받침 없는 한글 동화 : 무시무시 마녀가 이사 와!', 'new1.jpg', 12420, 'red');
insert into books(title, image, price, userid)
values('받침 없는 한글 동화 : 도, 도, 도꺠비다!', 'new2.jpg', 12420, 'red');
insert into books(title, image, price, userid)
values('받침 없는 한글 동화 : 바쁘다 바빠 너구리 바빠', 'new3.jpg', 12420, 'red');
insert into books(title, image, price, userid)
values('받침 없는 한글 동화 : 도깨비 파자마 파티', 'new4.jpg', 12420, 'red');
insert into books(title, image, price, userid)
values('받침 없는 한글 동화 : 4권 세트', 'new5.jpg', 49680, 'red');

insert into books(title, image, price, userid)
values('구글 엔지니어는 이렇게 일한다', 'best1.jpg', 40500, 'red');
insert into books(title, image, price, userid)
values('혼자 공부하는 머신러닝+딥러닝', 'best2.jpg', 23400, 'red');
insert into books(title, image, price, userid)
values('혼자 공부하는 C 언어', 'best3.jpg', 21600, 'red');
insert into books(title, image, price, userid)
values('변화하는 세계 질서', 'best4.jpg', 34200, 'red');
insert into books(title, image, price, userid)
values('이것이 취업을 위한 코딩 테스트다 with 파이썬', 'best5.jpg', 30600, 'red');

select * from books;

SET SQL_SAFE_UPDATES=1;
delete from books;

insert into books(title, image, price, userid)
select title, image, price, userid from books;

select count(*) from books;

update books set contents = 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.' where code > 0;

desc users;
select * from users;

alter table users
add column password varchar(20) default 'pass' not null;

alter table users
add column photo varchar(100);

update users set photo = '짱구.png' where userid = 'red';
update users set photo = '유리.jpg' where userid = 'blue';
update users set photo = '맹구.jpg' where userid = 'green';
update users set photo = '수지.jpg' where userid = 'yellow';

desc users;

select * from users;

select * from users where userid = 'blue';

select * from books;

delete from books where code > 10;

update books set qnt = 120 where code = 1;
update books set qnt = 110 where code = 2;
update books set qnt = 500 where code = 3;
update books set qnt = 200 where code = 4;
update books set qnt = 150 where code = 5;
update books set qnt = 300 where code = 6;

insert into books(title, image, price, contents, userid)
select title, image, price, contents, userid
from books;

select count(*) from books;

create table review(
	id int auto_increment primary key,
    userid varchar(20) not null,
    wdate datetime default now(),
    text varchar(1000) not null,
    code int not null,
    foreign key (userid) references users(userid),
    foreign key (code) references books(code)
);

insert into review(userid, text, code)
values('red', '너무나 깔끔하고 친절하고 군더더기 없는 설명 감사합니다 !!! 정말 너무 도움이 많이 되고 있어요ㅠㅠ 정말 멋지십니다 :>', 436);
insert into review(userid, text, code)
values('blue', '코딩테스트 준비하는데 큰 도움이 됩니다 감사합니다.', 436);

select * from review;