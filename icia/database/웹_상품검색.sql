create table shop(
	id varchar(30) not null primary key,
    title varchar(300) not null,
    price int default 0,
    image varchar(100),
    brand varchar(100),
    wdate datetime default now()
);

drop table shop;

desc shop;

select * from shop;

select max(id) from shop;