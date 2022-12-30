create table tbl_account(
  ano char(3) not null primary key,
  aname varchar(20) not null,
  balance int default 0,
  odate date default sysdate
);

create table tbl_statement(
  ano char(3) not null,
  sdate date default sysdate,
  type varchar(20) not null,
  amount int default 0 not null,
  primary key (ano, type, amount),
  foreign key (ano) references tbl_account(ano)
);

insert into tbl_account
values ('100', '홍길동', 1000, '2022-05-10');
insert into tbl_account
values ('200', '심청이', 3000, '2022-07-01');
insert into tbl_account
values ('300', '강감찬', 4000, '2022-07-10');

select * from tbl_account;

delete from tbl_account;

insert into tbl_statement
values ('100', '2022-05-10', '입금', 500);
insert into tbl_statement
values ('100', '2022-05-15', '출금', 500);
insert into tbl_statement
values ('100', '2022-05-20', '입금', 1000);
insert into tbl_statement
values ('200', '2022-07-01', '입금', 3000);
insert into tbl_statement
values ('300', '2022-07-10', '입금', 4000);

select * from tbl_statement;

delete from tbl_statement;

select max(ano) from tbl_account;

select * from tbl_statement where ano = '100';

select aname, balance, odate from tbl_account where ano = '100';

select sum(amount) from tbl_statement where ano = '100';

insert into tbl_statement(amount) select balance from tbl_account ac where st.ano = ac.ano;


update tbl_account set balance = '2000' where ano = '400';

commit;

create view view_balance as(
select ac.ano, amount, balance
from tbl_account ac, tbl_statement st
where ac.ano = st.ano);

