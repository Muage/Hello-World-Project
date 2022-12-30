create table tbl_shop(
	code char(12) primary key not null,
    title varchar(200) not null,
    image varchar(200),
    price double default 0
);

desc tbl_shop;

select * from tbl_shop;

create table tbl_shop_attach(
	id int auto_increment primary key,
    code char(12) not null,
    image varchar(200) not null,
    regdate datetime default now(),
    foreign key (code) references tbl_shop(code)
);

delete from tbl_shop_attach where id > 0;

desc tbl_shop_attach;

select * from tbl_shop_attach;

alter table tbl_shop_attach add column content text;

select * from tbl_shop_attach
		where code = '221017101747';
        

/* 2022.10.17 */
create table tbl_shop_sale(
	id int auto_increment primary key,
	code char(12),
    startDate datetime,
    endDate datetime,
    foreign key (code) references tbl_shop(code)
);

desc tbl_shop_sale;

select * from tbl_shop_sale;

select tbl_shop.*
		from tbl_shop, tbl_shop_sale
		where tbl_shop.code = tbl_shop_sale.code;