/* �л� ���̺� ���� */
create table tbl_student(
  sno char(3) not null primary key,
  sname varchar(200) not null,
  dept varchar(100),
  birthday date
);

/* 100, ȫ�浿, ������ �л� �Է� */
insert into tbl_student
values('100', 'ȫ�浿', '����', '2002-12-17');

insert into tbl_student(sno, sname, dept)
values('200', '��û��', '����');

/* �л� ���̺� ������ ��� */
select * from tbl_student;

/* 100�� �л��� �а��� �������� ���� */
update tbl_student set dept='����', sname='��浿'
where sno='100';

/* 200�� �л��� ���� */
delete from tbl_student
where sno='200';

/* �л� ���̺� ���� */
drop table tbl_score;
drop table tbl_student;

/* ���� ���̺� ���� */
create table tbl_score(
  sno char(3) not null,
  stype varchar(10) not null,
  sdate date default sysdate,
  grade int default 0,
  primary key(sno, stype),
  foreign key(sno) references tbl_student(sno)
);

/* 100�� �л� �߰� 100 */
insert into tbl_score(sno, stype, grade)
values('100', '�߰�', 100);

insert into tbl_score(sno, stype, grade)
values('100', '�⸻', 90);

insert into tbl_score(sno, stype, grade)
values('200', '�߰�', 89);

insert into tbl_score(sno, stype, grade)
values('200', '�⸻', 85);

/* ���� ������ ��� */
select * from tbl_score;

/* 100�� �л��� �⸻ ������ 100������ ���� */
update tbl_score set grade=100
where sno='100' and stype='�⸻';

/* 200�� �л��� ��� ���� ���� */
delete from tbl_score
where sno='200' and stype='�⸻';

/* ��� �л��� �̸�, Ÿ��, ���� ��� */
select st.sno, sc.sno, st.sname, stype, grade
from tbl_student st, tbl_score sc
where sc.sno = st.sno
order by grade desc;

