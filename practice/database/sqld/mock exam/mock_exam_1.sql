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
--
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
--
--    [SQL]
--    INSERT INTO SQLD_D5(COL1, COL2) VALUES('ABCD', NULL);
--    INSERT INTO SQLD_D5(COL1, COL2) VALUES('BC', NULL);
--    ALTER TABLE SQLD_D5 MODIFY COL2 DEFAULT 10;
--    INSERT INTO SQLD_D5(COL1, COL2) VALUES('XY', NULL);
--    INSERT INTO SQLD_D5(COL1) VALUES('EXD');
--    SELECT SUM(COL2) FROM SQLD_D5;
--    
--    ① 10
--    ② 40
--    ③ 20
--    ④ 0
--
--A. ①

create table SQLD_D5 (
    COL1 varchar2(30),
    COL2 int
);

select * from SQLD_D5;

INSERT INTO SQLD_D5(COL1, COL2) VALUES('ABCD', NULL);
INSERT INTO SQLD_D5(COL1, COL2) VALUES('BC', NULL);
ALTER TABLE SQLD_D5 MODIFY COL2 DEFAULT 10;
INSERT INTO SQLD_D5(COL1, COL2) VALUES('XY', NULL);
INSERT INTO SQLD_D5(COL1) VALUES('EXD');
SELECT SUM(COL2) FROM SQLD_D5;

--Q4. 아래와 같이 문자와 문자를 연결하는 함수에 대해서 작성하시오.
--    SELECT (    ) (COL1, COL2)
--    FROM EMP
--    WHERE EMPID = 10;
--    
--    ① LENGTH
--    ② CONCAT
--    ③ TRIM
--    ④ SUBSTR
--
--A. ②

create table EMP(
    COL1 varchar(10),
    COL2 varchar(10),
    EMPID int
);

select * from EMP;

insert into EMP values('test', 'check', 10);

--①
--LENGTH : 입력된 문자열의 글자 수 반환
SELECT LENGTH (COL1, COL2) FROM EMP WHERE EMPID = 10;
--오류

--②
--CONCAT : 문자열 연결 함수
SELECT CONCAT (COL1, COL2) FROM EMP WHERE EMPID = 10;
--CONCAT(COL1,COL2)
--testcheck

--③
--TRIM : 문자열 양쪽 공백 제거 함수
SELECT TRIM (COL1, COL2) FROM EMP WHERE EMPID = 10;
--오류

--④
--SUBSTR : 문자열 자르기 함수
SELECT SUBSTR (COL1, COL2) FROM EMP WHERE EMPID = 10;
--오류


--Q5. 아래의 SQL에서 FUNCTION 자리에 쓰인 함수에 의한 결과값이 다른 하나는?
--    
--    SELECT FUNCTION(3.46) FROM DUAL;
--
--    ① FLOOR
--    ② TRUNC
--    ③ ROUND
--    ④ CEIL
--
--A. ④

--①
--FLOOR : 내림 함수
SELECT FLOOR(3.46) FROM DUAL;
--3

--②
--TRUNC : 소수점, 날짜, 시간 절사 함수
SELECT TRUNC(3.46) FROM DUAL;
--3

--③
--ROUND : 반올림 함수
SELECT ROUND(3.46) FROM DUAL;
--3

--④
--CEIL : 올림 함수
SELECT CEIL(3.46) FROM DUAL;
--4

--Q6. 아래의 SQL에 대해서 결과값이 다른 것은?
--
--    ① SELECT 'RDBMS' & 'SQL' FROM DUAL;
--    ② SELECT CONCAT ('RDBMS', 'SQL') FROM DUAL;
--    ③ SELECT 'RDBMS' + 'SQL' FROM DUAL;
--    ④ SELECT 'RDBMS' || 'SQL' FROM DUAL;
--A. ④

--①
SELECT 'RDBMS' & 'SQL' FROM DUAL;
--오류

--②
SELECT CONCAT ('RDBMS', 'SQL') FROM DUAL;
--RDBMSSQL

--③
SELECT 'RDBMS' + 'SQL' FROM DUAL;
--오류

--④
SELECT 'RDBMS' || 'SQL' FROM DUAL;
--RDBMSSQL