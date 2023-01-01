select * from tbl_account;

create view view_tradeInfo as(
  select ta.*, tp.password
  from tbl_account ta, tbl_password tp
  where ta.accountno = tp.accountno
);

select * from view_tradeInfo;

create view view_trade as(
  select trd.accountno, trdt.tradeType, trd.tradebalance, trd.tradedate
  from tbl_trade trd, tbl_tradeType trdt
  where trd.tradeTypeNo = trdt.tradeTypeNo
);

drop view view_trade;
select * from view_trade;

update tbl_account set balance = balance + 500 where accountNo = '620-00004';

insert into tbl_trade(accountNo, tradeTypeNo, tradeBalance) values('620-00004', 'T01', 500);

select * from view_tradeInfo where accountno = '620-00004';
select * from tbl_account where accountno = '620-00004';
select * from tbl_trade where accountno = '620-00004';
delete from tbl_trade where tradebalance = 2000 and accountno = '620-00004';

commit;