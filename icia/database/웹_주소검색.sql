create table local(
	id varchar(20) primary key,
    name varchar(200) not null,
    address varchar(500),
    phone varchar(100),
    keyword varchar(100),
    x double,
    y double
);

desc local;

select * from local order by name;

alter table local add column wdate datetime default now();