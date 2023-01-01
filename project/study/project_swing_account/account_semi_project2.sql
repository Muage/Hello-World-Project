/*거래타입 테이블(tbl_tradeType) 생성*/
create table tbl_tradeType(
  tradeTypeNo char(3) not null primary key,
  tradeType varchar(100) not null
);

/*거래내역 테이블 (tbl_trade) 생성*/
create table tbl_trade(
  accountNo char(9) not null,
  tradeTypeNo char(3) not null,
  tradeBalance int not null,
  tradeDate date default sysdate,
  primary key(accountNo, tradeBalance,tradeDate),
  foreign key (accountNo) references tbl_account(accountNo),
  foreign key (tradeTypeNo) references tbl_tradeType(tradeTypeNo)
);
drop table tbl_trade;

/*테이블 확인*/
desc TBL_TRADETYPE;
desc TBL_TRADE;

/*기존 계좌들의 잔액 수정*/
update tbl_account 
set balance=40000
where accountNo='620-00000';

update tbl_account 
set balance=1500000
where accountNo='620-00001';

update tbl_account 
set balance=46700
where accountNo='620-00002';

update tbl_account 
set balance=29200
where accountNo='620-00003';

/*잔액 확인*/
select * from tbl_account;

/*거래타입 테이블(tbl_tradeType) 데이터*/
insert into tbl_tradeType(tradeTypeNo,tradeType) values('T01','입금');
insert into tbl_tradeType(tradeTypeNo,tradeType) values('T02','출금');

/*확인*/
select * from tbl_tradeType;

/*거래내역 테이블 (tbl_trade) 데이터*/
/*620-00000*/
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00000','T01',10000,'2022-05-16');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00000','T01',25000,'2022-05-22');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00000','T02',13000,'2022-05-23');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00000','T01',18000,'2022-05-30');

/*620-00001*/
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00001','T01',300000,'2022-06-17');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00001','T01',300000,'2022-07-17');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00001','T01',300000,'2022-08-17');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00001','T01',300000,'2022-09-17');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00001','T01',300000,'2022-10-17');

/*620-00002*/
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00002','T01',50000,'2022-07-10');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00002','T02',8000,'2022-07-13');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00002','T02',7300,'2022-07-20');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00002','T01',12000,'2022-07-22');

/*620-00003*/
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00002','T01',80000,'2022-03-01');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00002','T02',19800,'2022-04-03');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00002','T02',22100,'2022-04-11');
insert into tbl_trade(accountNo,tradeTypeNo,tradeBalance,tradeDate)
values('620-00002','T02',8900,'2022-04-13');

/*확인*/
select * from tbl_trade;

commit;

