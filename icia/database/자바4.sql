desc tbl_type;
alter table tbl_type add tdate date default sysdate;

select * from tbl_type;

update tbl_type set tdate = '2020-03-23'
where tcode = 'T10';
update tbl_type set tdate = '2020-06-30'
where tcode = 'T20';
update tbl_type set tdate = '2020-09-25'
where tcode = 'T30';

desc tbl_score;
alter table tbl_score drop column sdate;

select * from tbl_score;

select * from tbl_student;

alter table tbl_score drop column sdate;
select * from tbl_score;

select s.*, d.*
from tbl_student s, tbl_dept d
where s.dcode = d.dcode;

create view view_student as(
select s.*, dname
from tbl_student s, tbl_dept d
where s.dcode = d.dcode);

drop view view_score;

select * from view_student order by sname;

commit;