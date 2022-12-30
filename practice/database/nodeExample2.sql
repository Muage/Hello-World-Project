create table productinfo(
	code char(4) primary key,
    pname varchar(100) not null,
    price int,
    image varchar(50)
);

insert into productinfo(code, pname, price, image) values('P001', '5단서랍장', 50000, 'img01.jpg');
insert into productinfo(code, pname, price, image) values('P002', '원목싱글침대', 800000, 'img02.jpg');
insert into productinfo(code, pname, price, image) values('P003', '싱글침대', 800000, 'img03.jpg');
insert into productinfo(code, pname, price, image) values('P004', '4인용 가죽 쇼파', 1800000, 'img04.jpg');

select * from productinfo;