--Q1. ���� �־��� ���̺� ���ؼ� �Ʒ��� ���� ������� ��ȯ�ǵ��� �Ʒ� SQL���� ��ĭ�� �� ���� ���ÿ�.
--    [SQLD_37]
--    COL1    COL2    COL3
--    null    0       30
--    0       null    0
--    10      20      null
--    11      21      31
--    12      22      32
--    
--    [���]
--    A       B       C
--    12      0       33
--    
--    select (    ) AS A, (   ) AS B, (   ) AS C from SQLD_37;
--    
--    �� max(COL2), min(COL2), sum(COL1)
--    �� max(COL1), min(COL2), sum(COL2)
--    �� max(COL1), min(COL2), sum(COL1)
--    �� min(COL1), max(COL2), max(COL1)
--    
--A. ��

create table SQLD_37 (
    COL1 int,
    COL2 int,
    COL3 int
);

select * from SQLD_37;

--insert into SQLD_37 (COL1, COL2, COL3) values (null, 0, 30);
insert into SQLD_37 values (null, 0, 30);
insert into SQLD_37 values (0, null, 0);
insert into SQLD_37 values (10, 20, null);
insert into SQLD_37 values (11, 21, 31);
insert into SQLD_37 values (12, 22, 32);