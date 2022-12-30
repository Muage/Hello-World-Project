CREATE TABLE professors (
    pcode CHAR(3) NOT NULL PRIMARY KEY,
    pname VARCHAR(15) NOT NULL,
    dept VARCHAR(30),
    hiredate DATEtime default now(),
    title VARCHAR(15) default '정교수',
    salary INT DEFAULT 0
);

desc professors;

CREATE TABLE students (
    scode CHAR(8) NOT NULL,
    sname VARCHAR(15) NOT NULL,
    dept VARCHAR(30),
    year CHAR(1),
    birthday DATE,
    advisor CHAR(3),
    PRIMARY KEY (scode),
    FOREIGN KEY (advisor) REFERENCES professors (pcode)
);

desc students;

CREATE TABLE courses (
    lcode CHAR(4) NOT NULL,
    lname VARCHAR(50) NOT NULL,
    hours INT,
    room CHAR(3),
    instructor CHAR(3),
    capacity INT DEFAULT 0,
    persons INT DEFAULT 0,
    PRIMARY KEY(lcode),
    FOREIGN KEY(instructor)
	REFERENCES professors(pcode)
);

desc courses;

CREATE TABLE enrollments (
    lcode CHAR(4) NOT NULL,
    scode CHAR(8) NOT NULL,
    edate DATEtime default now(),
    grade INT DEFAULT 0,
    PRIMARY KEY(lcode , scode),
    FOREIGN KEY(lcode) REFERENCES courses (lcode),
    FOREIGN KEY (scode) REFERENCES students (scode)
);

desc enrollments;

insert into professors(pcode,pname,dept,hiredate,title,salary) values('221','이병렬','전산','75/04/03','정교수',3000000);
insert into professors(pcode,pname,dept,hiredate,title,salary) values('228','이재광','전산','91/09/19','부교수',2500000);
insert into professors(pcode,pname,dept,hiredate,title,salary) values('311','강승일','전자','94/06/09','부교수',2300000);
insert into professors(pcode,pname,dept,hiredate,title,salary) values('509','오문환','건축','92/10/14','조교수',2000000);

select * from professors;

insert into students(scode,sname,dept,year,birthday,advisor) values('92414029','서연우','전산',3,'73/10/06','228');
insert into students(scode,sname,dept,year,birthday,advisor) values('92414033','김창덕','전산',4,'73/10/26','221');
insert into students(scode,sname,dept,year,birthday,advisor) values('92514009','이지행','전자',4,'73/11/16','311');
insert into students(scode,sname,dept,year,birthday,advisor) values('92514023','김형명','전자',4,'73/08/29','311');
insert into students(scode,sname,dept,year,birthday,advisor) values('92454018','이원구','건축',3,'74/09/30','509');
insert into students(scode,sname,dept,year,birthday,advisor) values('95454003','이재영','건축',4,'76/02/06','509');
insert into students(scode,sname,dept,year,birthday,advisor) values('95414058','박혜경','전산',4,'76/03/12','221');
insert into students(scode,sname,dept,year,birthday,advisor) values('96414404','김수정','전산',3,'77/12/22','228');

select * from students;

delete from students where year=2;

SET SQL_SAFE_UPDATES = 0;

insert into courses(lcode,lname,hours,room,instructor,capacity,persons) values('C301','파일처리론', 3 ,'506','221',100,80);
insert into courses(lcode,lname,hours,room,instructor,capacity,persons) values('C401','데이터베이스',3,'414','221',80,80);
insert into courses(lcode,lname,hours,room,instructor,capacity,persons) values('C421','알고리즘',3,'510','228',80,72);
insert into courses(lcode,lname,hours,room,instructor,capacity,persons) values('C312','자료구조',2,'510','228',100,60);
insert into courses(lcode,lname,hours,room,instructor,capacity,persons) values('E221','논리회로',3,'304','311',100,80);
insert into courses(lcode,lname,hours,room,instructor,capacity,persons) values('A109','한국의건축문화',2,'101','509',120,36);

select * from courses;

insert into enrollments(lcode, scode, edate, grade) values('C401','92414033','98/03/02',85);
insert into enrollments(lcode, scode, edate, grade) values('C301','92414033','98/03/02',80);
insert into enrollments(lcode, scode, edate, grade) values('C421','92414033','98/03/02', 0);
insert into enrollments(lcode, scode, edate, grade) values('C401','95414058','98/03/03',90);
insert into enrollments(lcode, scode, edate, grade) values('C301','95414058','98/03/03',80);
insert into enrollments(lcode, scode, edate, grade) values('C312','95414058','98/03/03',80);
insert into enrollments(lcode, scode, edate, grade) values('C401','92514023','98/03/03',70);
insert into enrollments(lcode, scode, edate, grade) values('C301','92514023','98/03/03',70);
insert into enrollments(lcode, scode, edate, grade) values('C421','92514023','98/03/03',70);
insert into enrollments(lcode, scode, edate, grade) values('C301','92414029','98/03/03',90);
insert into enrollments(lcode, scode, edate, grade) values('C421','92414029','98/03/03',0);
insert into enrollments(lcode, scode, edate, grade) values('C312','92414029','98/03/03',70);
insert into enrollments(lcode, scode, edate, grade) values('E221','92414029','98/03/03',75);
insert into enrollments(lcode, scode, edate, grade) values('A109','92414029','98/03/03',90);
insert into enrollments(lcode, scode, edate, grade) values('C301','92514009','98/03/03',70);
insert into enrollments(lcode, scode, edate, grade) values('C401','92514009','98/03/03',85);
insert into enrollments(lcode, scode, edate, grade) values('E221','92514009','98/03/03',85);
insert into enrollments(lcode, scode, edate, grade) values('C301','96414404','98/03/04',75);
insert into enrollments(lcode, scode, edate, grade) values('C401','96414404','98/03/04',75);
insert into enrollments(lcode, scode, edate, grade) values('C421','96414404','98/03/04',75);
insert into enrollments(lcode, scode, edate, grade) values('C312','92454018','98/03/04',90);
insert into enrollments(lcode, scode, edate, grade) values('E221','92454018','98/03/04',90);
insert into enrollments(lcode, scode, edate, grade) values('A109','95454003','98/03/05',85);
insert into enrollments(lcode, scode, edate, grade) values('E221','95454003','98/03/05',85);

select * from enrollments;
select count(*) from enrollments;

select s.*, p.pname, p.dept pdept
from students s, professors p
where advisor = pcode;

create view stu as(
select s.*, p.pname, p.dept pdept
from students s, professors p
where advisor = pcode
);

select * from stu where pname like '%병렬%';

select c.*, pname, dept
from courses c, professors p
where instructor = pcode;

create view cou as
select c.*, pname, dept
from courses c, professors p
where instructor = pcode;

select * from cou;

create view estu as
select e.*, sname, dept, year
from students s, enrollments e
where s.scode = e.scode;

select * from estu;

select e.*, lname, hours, capacity, persons, room
from courses c, enrollments e
where c.lcode = e.lcode;

create view ecou as
select e.*, lname, hours, capacity, persons, room
from courses c, enrollments e
where c.lcode = e.lcode;

select * from ecou;

select * from estu
where dept like '%전%'
order by dept
limit 0, 5;

select count(*) from estu
where dept like '%전%';

call list('stu', 'sname', '김', 'sname', '', 2, 2);

select max(pcode)+1 code from professors;

select * from courses where instructor='228';

select * from students where advisor='228';

update stu set year='3' where year='4' and scode != null;
select * from stu;

select * from ecou where scode='92414029';

drop view ecou;

create view ecou as
select e.scode, e.edate, e.grade, c.*, pname
from enrollments e, courses c, professors p
where e.lcode = c.lcode and pcode = instructor;

select count(*) from ecou;

update courses c set persons=
(select count(*) from enrollments e where e.lcode=c.lcode)
where c.lcode != '';

select * from courses;

select * from enrollments;
desc enrollments;

select * from estu where lcode = 'A109';