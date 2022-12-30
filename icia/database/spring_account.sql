create table tbl_account(
	ano char(4) primary key,
    aname varchar(20),
    openDate datetime default now(),
    balance double
);

select * from tbl_account;

insert into tbl_account(ano, aname, balance) values('1001', '홍길동', 1000);
insert into tbl_account(ano, aname, balance) values('1002', '심청이', 2000);
insert into tbl_account(ano, aname, balance) values('1003', '강감찬', 3000);

create table tbl_trade(
	id int auto_increment primary key,
    ano char(4),
    type char(4),
    tno char(4),
    amount double,
    tradeDate dateTime default now(),
    foreign key(ano) references tbl_account(ano),
    foreign key(tno) references tbl_account(ano)
);

select * from tbl_trade;

insert into tbl_trade(ano, tno, type, amount) values('1001', '1002', '출금', 500);
update tbl_account set balance = balance - 500 where ano = '1001';

insert into tbl_trade(ano, tno, type, amount) values('1002', '1001', '입금', 500);
update tbl_account set balance = balance + 500 where ano ='1002';