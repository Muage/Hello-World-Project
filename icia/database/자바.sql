/* 학생 테이블 생성 */
create table tbl_student(
  sno char(3) not null primary key,
  sname varchar(200) not null,
  dept varchar(100),
  birthday date
);

/* 100, 홍길동, 컴정과 학생 입력 */
insert into tbl_student
values('100', '홍길동', '컴정', '2002-12-17');

insert into tbl_student(sno, sname, dept)
values('200', '심청이', '전자');

/* 학생 테이블 데이터 결과 */
select * from tbl_student;

/* 100번 학생의 학과를 컴정으로 수정 */
update tbl_student set dept='컴정', sname='김길동'
where sno='100';

/* 200번 학생을 삭제 */
delete from tbl_student
where sno='200';

/* 학생 테이블 삭제 */
drop table tbl_score;
drop table tbl_student;

/* 성적 테이블 생성 */
create table tbl_score(
  sno char(3) not null,
  stype varchar(10) not null,
  sdate date default sysdate,
  grade int default 0,
  primary key(sno, stype),
  foreign key(sno) references tbl_student(sno)
);

/* 100번 학생 중간 100 */
insert into tbl_score(sno, stype, grade)
values('100', '중간', 100);

insert into tbl_score(sno, stype, grade)
values('100', '기말', 90);

insert into tbl_score(sno, stype, grade)
values('200', '중간', 89);

insert into tbl_score(sno, stype, grade)
values('200', '기말', 85);

/* 성적 데이터 출력 */
select * from tbl_score;

/* 100번 학생의 기말 점수를 100점으로 수정 */
update tbl_score set grade=100
where sno='100' and stype='기말';

/* 200번 학생의 모든 성적 삭제 */
delete from tbl_score
where sno='200' and stype='기말';

/* 모든 학생의 이름, 타입, 성적 출력 */
select st.sno, sc.sno, st.sname, stype, grade
from tbl_student st, tbl_score sc
where sc.sno = st.sno
order by grade desc;

