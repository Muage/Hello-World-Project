create table mall(
	mall_id char(4) not null,
    mall_name varchar(50) not null,
    manager varchar(15),
    address varchar(100),
    tel varchar(15),
    email varchar(20),
    detail varchar(100),
    primary key(mall_id)
);

create table product(
	prod_id char(4) not null,
    prod_name varchar(50) not null,
    mall_id char(4),
    company varchar(50),
    price1 int,
    price2 int,
    detail varchar(3000),
    image varchar(100),
    prod_del char(1) default '0',
    primary key(prod_id),
    foreign key(mall_id) references mall(mall_id)
);

create table purchase(
	order_id char(4) not null,
    name varchar(15) not null,
    address varchar(100),
    email varchar(20),
    tel varchar(15),
    pdate date,
    payType char(1), /* 0:무통장, 1:카드 */
    status char(1) default '0', /* 0:처리중, 1:처리완료 */
    primary key(order_id)
);

create table orders(
	order_id char(4) not null,
    prod_id char(4) not null,
    price int,
    quantity int,
    primary key(order_id, prod_id),
    foreign key (order_id) references purchase(order_id),
    foreign key (prod_id) references product(prod_id)
);

insert into mall(mall_id,mall_name,manager,address,tel,email)
values('M101','에몬스 가구','이병렬','서울 강서구 대치동 561번지','02-522-6898','Bllee@hanmail.net');
insert into mall(mall_id,mall_name,manager,address,tel,email)
values('M102','벨라지오 퍼니처','이재광','서울 강북구 수유동 134번지', '02-897-6690','Jglee@netian.com');
insert into mall(mall_id,mall_name,manager,address,tel,email)
values('M103','까사미아','서연우','인천 부평구 계산동 104번지','032-502-9599','Ywshu@netian.com');
insert into mall(mall_id,mall_name,manager,address,tel,email)
values('M104','레이디 가구','김성철','서울 강남구 압구정동 456번지','02-602-9876','Sigang@netian.com');
insert into mall(mall_id,mall_name,manager,address,tel,email)
values('M105','가구 나라','이원구','인천 남동구 만수동 567번지','032-503-9021','Wglee@hanmail.net');
select * from mall;

insert into product(prod_id,prod_name,mall_id,company,price1,price2)
values('P101','아모라 아쿠아텍스 이지클린 침대','M101','가구나라',2200000,2300000);
insert into product(prod_id,prod_name,mall_id,company,price1,price2)
values('P102','모던 라운지 낮은 퀸 침대','M101','삼익 가구나라',2100000,2200000);
insert into product(prod_id,prod_name,mall_id,company,price1,price2)
values('P103','도로시 아쿠아텍스 기능성 퀸 침대','M102','한샘가구',3000000,3200000);
insert into product(prod_id,prod_name,mall_id,company,price1,price2)
values('P104','모리엘 호텔형 침대','M102','한샘가구',1500000,1600000);
insert into product(prod_id,prod_name,mall_id,company,price1,price2)
values('P105','글로리 모던 서랍장 와이드','M101','한샘가구',600000,650000);
insert into product(prod_id,prod_name,mall_id,company,price1,price2)
values('P106','카밀라 4인용 극세사가죽 소파','M102','까사미아',2500000,2600000);
insert into product(prod_id,prod_name,mall_id,company,price1,price2)
values('P107','루진 6인 원목 식탁세트 (벤치형)','M101','까사미아',300000,320000);
insert into product(prod_id,prod_name,mall_id,company,price1,price2)
values('P108','베스트 10.5자 장롱 시리즈','M103','동서가구',400000,420000);
insert into product(prod_id,prod_name,mall_id,company,price1,price2)
values('P109','줄리아 화이트 10자/12자 장농 ','M104','동서가구',520000,550000);
insert into product(prod_id,prod_name,mall_id,company,price1,price2)
values('P110','글로리 모던 서랍장 830','M105','가구나라',100000,120000);
insert into product(prod_id,prod_name,mall_id,company,price1,price2)
values('P111','리트머스 1500 거실장','M102','한샘가구',120000,130000);
insert into product(prod_id,prod_name,mall_id,company,price1,price2)
values('P112','엘린 4인용 카우치 가죽쇼파','M102','가구나라',1500000,1670000);
select * from product;

insert into purchase(order_id, name, address, email, tel, pdate, payType, status)
values('R101', '김수정', '서울 강남구 대치1동', 'Sjkim@netian.com', '02-503-9090','2014/08/10', '1', '1');
insert into purchase(order_id, name, address, email, tel, pdate, payType, status)
values('R102', '박혜경', '인천 부평구 부평5동', 'Hkpark@hanmail.net', '032-609-9987','2014/08/10', '1', '1');
insert into purchase(order_id, name, address, email, tel, pdate, payType, status)
values('R103', '임미숙', '인천 서구 청라2동', 'mslim@hanmail.net', '02-688-7703','2014/08/13', '1', '1');
insert into purchase(order_id, name, address, email, tel, pdate, payType, status)
values('R104', '김연호', '서울 종로구 관훈동 관훈빌딩', 'Yhkim@yahoo.com', '02-688-7703','2014/08/13', '1', '0');
insert into purchase(order_id, name, address, email, tel, pdate, payType, status)
values('R105', '한보연', '서울 종로구 인사동', 'byhan@yahoo.com', '02-230-2044','2014/08/13', '1', '1');
insert into purchase(order_id, name, address, email, tel, pdate, payType, status)
values('R106', '김수정', '서울 강남구 대치1동', 'Sjkim@netian.com', '02-503-9090','2014/08/13', '0', '0');
insert into purchase(order_id, name, address, email, tel, pdate, payType, status)
values('R107', '이준호', '인천 계양구 효성동', 'Jhlee@hanmil.net', '032-522-5678','2014/08/14', '0', '1');
insert into purchase(order_id, name, address, email, tel, pdate, payType, status)
values('R108', '김연호', '서울 종로구 관훈동 관훈빌딩', 'Yhkim@yahoo.com', '02-688-7703','2014/08/15', '1', '1');
insert into purchase(order_id, name, address, email, tel, pdate, payType, status)
values('R109', '김수정', '서울 강남구 대치1동', 'Sjkim@netian.com', '02-503-9090','2014/08/15', '1', '1');
insert into purchase(order_id, name, address, email, tel, pdate, payType, status)
values('R110', '이준호', '인천 계양구 효성동', 'Jhlee@hanmil.net', '032-522-5678','2014/08/15', '0', '0');
select * from purchase;

insert into orders(order_id, prod_id, price, quantity) values('R101', 'P109', 520000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R101', 'P112', 150000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R101', 'P107', 300000, 2);
insert into orders(order_id, prod_id, price, quantity) values('R102', 'P106', 2500000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R102', 'P112', 150000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R103', 'P107', 300000, 2);
insert into orders(order_id, prod_id, price, quantity) values('R103', 'P103', 3000000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R104', 'P109', 520000, 2);
insert into orders(order_id, prod_id, price, quantity) values('R104', 'P107', 300000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R104', 'P111', 120000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R105', 'P110', 100000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R105', 'P103', 3000000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R106', 'P112', 150000, 2);
insert into orders(order_id, prod_id, price, quantity) values('R107', 'P112', 150000, 4);
insert into orders(order_id, prod_id, price, quantity) values('R107', 'P103', 3000000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R108', 'P104', 1500000, 2);
insert into orders(order_id, prod_id, price, quantity) values('R109', 'P103', 3000000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R110', 'P109', 520000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R110', 'P111', 120000, 1);
insert into orders(order_id, prod_id, price, quantity) values('R110', 'P112', 150000, 1);
select count(*) from orders;

update product set image = concat(prod_id, '.jpg') where prod_id != 'null';
select * from product;

select concat('P', max(substring(prod_id, 2, 3)) + 1) code from product;

select * from product;
update product set prod_del = '1' where prod_id = 'P101';

delete from product where prod_id = 'P115';
SET SQL_SAFE_UPDATES = 1;

create view pro_mall as
select p.*, mall_name
from product p, mall m
where p.mall_id = m.mall_id;

select * from purchase;

select * from purchase where order_id = 'R101';

select * from orders where order_id = 'R101';

create view order_prod as
select o.*, prod_name, company, image, o.price * o.quantity total
from orders o, product p
where o.prod_id = p.prod_id;

select * from order_prod where order_id = 'R101';

call order_info('R102');

select concat('R', max(substr(order_id, 2, 3) + 1)) code from purchase;

alter table purchase modify column pdate datetime default now();

select * from orders;

delete from purchase where order_id = 'R111';

create table users(
	uid varchar(20) not null primary key,
    pass varchar(100) not null,
    uname varchar(20) not null
);

insert into users values('red', 'pass', '홍길동');
insert into users values('blue', 'pass', '심청이');

select * from users;