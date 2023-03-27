--Q1. 다음 주어진 테이블에 대해서 아래와 같은 결과값이 반환되도록 아래 SQL문의 빈칸에 들어갈 것을 고르시오.
--    [SQLD_37]
--    COL1    COL2    COL3
--    null    0       30
--    0       null    0
--    10      20      null
--    11      21      31
--    12      22      32
--    
--    [결과]
--    A       B       C
--    12      0       33
--    
--    select (    ) AS A, (   ) AS B, (   ) AS C from SQLD_37;
--    
--    ① max(COL2), min(COL2), sum(COL1)
--    ② max(COL1), min(COL2), sum(COL2)
--    ③ max(COL1), min(COL2), sum(COL1)
--    ④ min(COL1), max(COL2), max(COL1)
--    
--A. ③

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

--①
select max(COL2) AS A, min(COL2) AS B, sum(COL1) AS C from SQLD_37;
--A   B   C
--22  0   33

--②
select max(COL1) AS A, min(COL2) AS B, sum(COL2) AS C from SQLD_37;
--A   B   C
--12  0   63

--③
select max(COL1) AS A, min(COL2) AS B, sum(COL1) AS C from SQLD_37;
--A   B   C
--12  0   33

--④
select min(COL1) AS A, max(COL2) AS B, max(COL1) AS C from SQLD_37;
--A   B   C
--0  22   12