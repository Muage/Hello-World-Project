create table users(
	id varchar(20) not null primary key,
    pass varchar(20) not null,
    name varchar(20) not null
);

insert into users
values('red', 'pass', '김레드');
insert into users
values('blue', 'pass', '박블루');
insert into users
values('green', 'pass', '최그린');

select * from users;

alter table users add column image varchar(200);

update users set image = '/images/짱구.png' where id = 'red';
update users set image = '/images/맹구.jpg' where id = 'blue';
update users set image = '/images/철수.jpg' where id = 'green';

select * from users;

update users set image = '/images/짱구.png' where id = 'blue';
update users set image = '/images/맹구.jpg' where id = 'green';
update users set image = '/images/수지.jpg' where id = 'red';

create table product(
	code int auto_increment primary key,
    name varchar(200) not null,
    image varchar(200),
    price int default 0
);

select * from product;

/* 맛집 관리 */
create table food (
	id int auto_increment primary key,
    name varchar(200) not null,
    tel varchar(200) not null,
    address varchar(200) not null,
    y double not null,
    x double not null
);

insert into food(name, tel, address, y, x) 
values('쿠바', '032-565-6969', '인천광역시 서구 경서동 950-14', 37.54089, 126.6799233);
insert into food(name, tel, address, y, x) 
values('테르미니', '02-972-0036', '서울특별시 노원구 공릉동 27-20', 37.6263383, 127.0919478);
insert into food(name, tel, address, y, x) 
values('애플민트', '02-975-3710', '서울특별시 노원구 공릉동 113', 37.6263176, 127.0240964);

