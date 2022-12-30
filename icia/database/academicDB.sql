create table professor(
	pcode char(3) not null primary key,
    pname varchar(50) not null,
    dept varchar(50),
    title varchar(10) default '정교수',
    hiredate datetime default now(),
    salary int default 0
);

desc professor;

insert into professor values('100', '김교수', '건축학부', '정교수', '1990-02-02', 4000000);
insert into professor values('101', '이교수', '융합전자공학부', '부교수', '1991-02-02', 3000000);
insert into professor values('102', '박교수', '신소재공학부', '조교수', '1992-02-02', 2000000);
insert into professor values('103', '최교수', '기계공학부', '정교수', '1993-02-02', 5000000);
insert into professor values('104', '윤교수', '화학공학과', '부교수', '1994-02-02', 3500000);

select * from professor;

