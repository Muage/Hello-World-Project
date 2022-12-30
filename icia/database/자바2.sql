/* �а� ���̺� ���� */
create table tbl_dept(
  code char(2) not null primary key,
  dname varchar(100) not null
);
desc tbl_dept;

/* �л� ���̺� ���� */
create table tbl_student(
  sno char(3) not null primary key,
  sname varchar(20) not null,
  code char(2) not null,
  foreign key(code) references tbl_dept(code)
);

/* ���� ���̺� ���� */
create table tbl_type(
  code char(2) not null primary key,
  tname varchar(20) not null
);
desc tbl_type;

/* ���� ���̺� ���� */
create table tbl_score(
  sno char(3) not null,
  grade int default 0,
  sdate date default sysdate,
  code char(2) not null,
  primary key(sno, code),
  foreign key(sno) references tbl_student(sno),
  foreign key(code) references tbl_type(code)
);

/* ���̺� ���� */
drop tabel tbl_score;
drop tabel tbl_type;
drop tabel tbl_student;
drop tabel tbl_dept;

insert into tbl_dept
values('10', '��ǻ����������');
insert into tbl_dept
values('20', '���ڰ���');
select * from tbl_dept;

insert into tbl_student
values('100', 'ȫ�浿', '10');
insert into tbl_student
values('200', '��û��', '20');
insert into tbl_student
values('300', '������', '10');
select * from tbl_student;

insert into tbl_type
values('10', '�߰�');
insert into tbl_type
values('20', '�⸻');
insert into tbl_type
values('30', '����');
select * from tbl_type;

insert into tbl_score(sno, grade, code)
values('100', 99, '10');
insert into tbl_score(sno, grade, code)
values('100', 100, '20');
insert into tbl_score(sno, grade, code)
values('200', 88, '10');
insert into tbl_score(sno, grade, code)
values('200', 87, '20');
insert into tbl_score(sno, grade, code)
values('300', 78, '10');
select * from tbl_score;

select * from tbl_dept;

insert into tbl_dept(code, dname)
values('30', '�������');

update tbl_dept set dname='�������ڰ���'
where code='20';

delete from tbl_dept
where code='10';

commit;

select max(code) mcode from tbl_dept;