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


--Q2. 다음의 SQL문을 사용할 때, 날짜형 변수를 문자형으로 바꿀 수 있는 것은?
--    SELECT SYSDATE FROM DUAL;
--    
--    ① TO_NUMBER
--    ② TO_DATE
--    ③ TO_CHAR
--    ④ CONVERT

--A. ③

--①
--TO_NUMBER : 주어진 문자열 또는 컬럼의 데이터를 숫자로 변환
SELECT TO_NUMBER(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
--오류

--②
--TO_DATE : 문자를 날짜 데이터 타입으로 변환
SELECT TO_DATE(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
--23/03/31

--③
--TO_CHAR : 날짜 및 숫자 등의 값을 문자열로 변환
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
--2023-03-31

--④
--CONVERT : 문자세트를 다른 문자세트로 문자열을 변환
SELECT CONVERT(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
--오류


--Q3. 아래와 같은 테이블이 있을 때 모든 SQL이 수행된 이후의 결과는?
--    [테이블]
--    SQLD_D5
--    COL1 VARCHAR2(30)
--    COL2 NUMBER

--    [SQL]
--    INSERT INTO SQLD_D5(COL1, COL2) VALUES('ABCD', NULL);
--    INSERT INTO SQLD_D5(COL1, COL2) VALUES('BC', NULL);
--    ALTER TABLE SQLD_D5 MODIFY COL2 DEFAULT 10;
--    INSERT INTO SQLD_D5(COL1, COL2) VALUES('XY', NULL);
--    INSERT INTO SQLD_D5(COL1) VALUES('EXD');
--    SELECT SUM(COL2) FROM SQLD_D5;
    
--    ① 10
--    ② 40
--    ③ 20
--    ④ 0

--A. 

create table SQLD_D5 (
    COL1 varchar2(30),
    COL2 int
);