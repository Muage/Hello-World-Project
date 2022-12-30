create table tbl_camp(
  code char(4) not null primary key,
  cname varchar(200) not null,
  address varchar(500) not null
);

drop table tbl_camp;

create table tbl_facility(
  fcode char(3) not null primary key,
  fname varchar(20) not null
);

create table tbl_type(
  tcode char(3) not null primary key,
  tname varchar(20) not null
);

create table tbl_camp_facility(
  code char(4) not null,
  fcode char(3) not null,
  primary key(code, fcode),
  foreign key (code) references tbl_camp(code),
  foreign key (fcode) references tbl_facility(fcode)
);

create table tbl_camp_type(
  code char(4) not null,
  tcode char(3) not null,
  qnt int default 0,
  primary key(code, tcode),
  foreign key (code) references tbl_camp(code),
  foreign key (tcode) references tbl_type(tcode)
);

commit;

insert into tbl_camp
values ('c100', '도토리', '강원도');
insert into tbl_camp
values ('c200', '솔밭', '인천');
insert into tbl_camp
values ('c300', '자연', '경기도');

select * from tbl_camp;

insert into tbl_facility
values ('f10', '전기');
insert into tbl_facility
values ('f20', '수도');
insert into tbl_facility
values ('f30', '화장실');
insert into tbl_facility
values ('f40', '와이파이');

select * from tbl_facility;

insert into tbl_type
values ('t10', '오토캠핑');
insert into tbl_type
values ('t20', '글램핑');
insert into tbl_type
values ('t30', '카라반');

select * from tbl_type;

insert into tbl_camp_facility
values ('c100', 'f10');
insert into tbl_camp_facility
values ('c100', 'f20');
insert into tbl_camp_facility
values ('c100', 'f30');
insert into tbl_camp_facility
values ('c200', 'f10');
insert into tbl_camp_facility
values ('c200', 'f20');
insert into tbl_camp_facility
values ('c300', 'f30');
insert into tbl_camp_facility
values ('c300', 'f40');

select * from tbl_camp_facility;

insert into tbl_camp_type
values ('c100', 't10', 5);
insert into tbl_camp_type
values ('c100', 't20', 10);
insert into tbl_camp_type
values ('c200', 't10', 12);
insert into tbl_camp_type
values ('c200', 't20', 5);
insert into tbl_camp_type
values ('c200', 't30', 20);
insert into tbl_camp_type
values ('c300', 't10', 22);
insert into tbl_camp_type
values ('c300', 't30', 10);

select * from tbl_camp_type;

commit;

create view view_facility as
(select cf.*, fname
from tbl_facility f, tbl_camp_facility cf
where cf.fcode = f.fcode);

select * from view_facility;

create view view_type as
(select ct.*, tname
from tbl_camp_type ct, tbl_type t
where ct.tcode = t.tcode);

select * from view_type order by code;

select * from view_facility where code = 'c100';
select * from view_type where code = 'c100';

select max(fcode) mcode from tbl_facility;