create table userinfo (
 name varchar(10) not null, 
 id varchar(8) not null, 
 password varchar(8) not null, 
 primary key(id)
);

insert into userinfo(name, id, password) values('김재영', 'spider', 'pass');
insert into userinfo(name, id, password) values('박철규', 'iceman', 'pass');
insert into userinfo(name, id, password) values('변재희', 'sparrow', 'pass');
insert into userinfo(name, id, password) values('진석영', 'batman', 'pass');

select * from userinfo;

alter table userinfo add column del char(1) default '0';