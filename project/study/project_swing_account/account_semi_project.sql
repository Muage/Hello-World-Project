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


/*������ ���� tbl_accountInfo*/
insert into tbl_accountInfo values ('A01','���� ����','����');
insert into tbl_accountInfo values ('A02','���� �����','�����');

/*������ ���� tbl_passwordType*/
insert into tbl_passwordType values ('Q01','�����ϴ� ������?');
insert into tbl_passwordType values ('Q02','���� ��� ������?');
insert into tbl_passwordType values ('Q03','�ʵ��б� �̸���?');

/*������ ���� tbl_account*/
insert into tbl_account values ('620-00000','�谡��',1000,'A02','2022-05-16');
insert into tbl_account values ('620-00001','�谡��',20000,'A01','2022-06-17');
insert into tbl_account values ('620-00002','��ٶ�',1000,'A02','2022-07-10');
insert into tbl_account values ('620-00003','�踶��',1000,'A02','2022-03-01');

/*������ ���� tbl_passwordType*/
insert into tbl_password values ('620-00000','1111','Q01','�̼���');
insert into tbl_password values ('620-00001','1113','Q02','��õ');
insert into tbl_password values ('620-00002','1110','Q03','�����ʵ��б�');
insert into tbl_password values ('620-00003','1112','Q02','����');

/*�� ���̺� ����*/
select * from tbl_accountInfo;
select * from tbl_passwordType;
select * from tbl_account;
select * from tbl_password;

/*���� ���� ��ȸ*/
select * from tbl_account where accountNo='?';

/*���¹�ȣ ����*/
select max(accountNo) from tbl_account;

/*�����*/
update tbl_account set balance=5000 where accountNo='?';

commit;