drop table tbl_account;
drop table tbl_statement;

/*accountInfo table*/
create table tbl_accountInfo (
  accountTypeNo char(3) not null primary key,
  accountTypeName varchar(100) not null,
  accountType varchar(100) not null
);

/*passwordType talbe*/
create table tbl_passwordType (
  passwordTypeNo char(3) not null primary key,
  passwordQuestion varchar(500) not null
);

/*account table*/
create table tbl_account (
  accountNo char(9) not null primary key,
  accountName varchar(100) not null,
  balance int default 1000,
  accountTypeNo char(3) not null,
  accountDate date default sysdate,
  foreign key (accountTypeNo) references tbl_accountInfo(accountTypeNo)
);

/*password talbe*/
create table tbl_password (
  accountNo char(9) not null,
  password char(4) not null primary key,
  passwordTypeNo char(3) not null,
  passwordAnswer varchar(500) not null,
  foreign key (accountNo) references tbl_account(accountNo),
  foreign key (passwordTypeNo) references tbl_passwordType(passwordTypeNo)
);


/*데이터 생성 tbl_accountInfo*/
insert into tbl_accountInfo values ('A01','개미 적금','적금');
insert into tbl_accountInfo values ('A02','자율 입출금','입출금');

/*데이터 생성 tbl_passwordType*/
insert into tbl_passwordType values ('Q01','좋아하는 위인은?');
insert into tbl_passwordType values ('Q02','현재 사는 지역은?');
insert into tbl_passwordType values ('Q03','초등학교 이름은?');

/*데이터 생성 tbl_account*/
insert into tbl_account values ('620-00000','김가나',1000,'A02','2022-05-16');
insert into tbl_account values ('620-00001','김가나',20000,'A01','2022-06-17');
insert into tbl_account values ('620-00002','김다라',1000,'A02','2022-07-10');
insert into tbl_account values ('620-00003','김마바',1000,'A02','2022-03-01');

/*데이터 생성 tbl_passwordType*/
insert into tbl_password values ('620-00000','1111','Q01','이순신');
insert into tbl_password values ('620-00001','1113','Q02','인천');
insert into tbl_password values ('620-00002','1110','Q03','학익초등학교');
insert into tbl_password values ('620-00003','1112','Q02','서울');

/*각 테이블 보기*/
select * from tbl_accountInfo;
select * from tbl_passwordType;
select * from tbl_account;
select * from tbl_password;

/*개인 계좌 조회*/
select * from tbl_account where accountNo='?';

/*계좌번호 생성*/
select max(accountNo) from tbl_account;

/*입출금*/
update tbl_account set balance=5000 where accountNo='?';

commit;