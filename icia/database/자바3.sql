drop table tbl_score;
drop table tbl_type;
drop table tbl_student;
drop table tbl_dept;

/* 학과 테이블 생성 */
create table tbl_dept(
  dcode char(3) not null primary key,
  dname varchar(100) not null
);

desc tbl_dept;

/* 구분 테이블 생성 */
create table tbl_type(
  tcode char(3) not null primary key,
  tname varchar(100) not null
);

/* 학생 테이블 생성 */
create table tbl_student(
  sno char(3) not null primary key,
  sname varchar(20) not null,
  dcode char(3),
  foreign key (dcode) references tbl_dept(dcode)
);

/* 성적 테이블 생성 */
create table tbl_score(
  sno char(3) not null,
  tcode char(3) not null,
  sdate date default sysdate,
  grade int default 0,
  primary key(sno, tcode),
  foreign key (sno) references tbl_student(sno),
  foreign key (tcode) references tbl_type(tcode)
);

/* 학과 데이터 입력 */
insert into tbl_dept
values('D10', '컴퓨터정보공학');
insert into tbl_dept
values('D20', '전기전자공학');
insert into tbl_dept
values('D30', '경영학');

select * from tbl_dept;

/* 구분 데이터 입력 */
insert into tbl_type
values('T10', '중간');
insert into tbl_type
values('T20', '기말');
insert into tbl_type
values('T30', '9월모의');

select * from tbl_type;

/* 학생 데이터 입력 */
insert into tbl_student
values('100', '홍길동', 'D10');
insert into tbl_student
values('200', '심청이', 'D20');
insert into tbl_student
values('300', '강감찬', 'D10');

select * from tbl_student;

/* 성적 데이터 입력 */
insert into tbl_score
values('100', 'T10', '2020-03-23', '99');
insert into tbl_score
values('200', 'T10', '2020-03-23', '88');
insert into tbl_score
values('300', 'T10', '2020-03-23', '100');
insert into tbl_score
values('100', 'T20', '2020-06-30', '85');
insert into tbl_score
values('200', 'T20', '2020-06-30', '76');
insert into tbl_score
values('300', 'T30', '2020-09-25', '69');

delete from tbl_score;

select * from tbl_score;

select s.*, dname
from tbl_student s, tbl_dept d
where s.dcode = d.dcode;

/* 학번, 학생명, 구분코드, 구분코드명, 시험일, 점수 출력 */
create view view_score as
(select g.*, sname, tname, dname
from tbl_student s, tbl_type t, tbl_score g, tbl_dept d
where g.sno = s.sno and g.tcode = t.tcode and s.dcode = d.dcode);

select * from view_score order by sdate desc;

commit;
select * from tbl_dept;
select max(dcode) mcode from tbl_dept;
select * from tbl_dept where dcode='D20';
update tbl_dept set dname = '컴퓨터정보공학과'
where dcode = 'D10';
update tbl_dept set dname = '전기전자공학과' where dcode = 'D20';

select max(tcode) from tbl_type;