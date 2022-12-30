create table bbs(
 no int(8) auto_increment primary key, 
 title varchar(50) not null, 
 content varchar(500) not null, 
 writer varchar(20) not null, 
 wdate datetime not null default now(), 
 foreign key(writer) references userinfo(id)   
);

desc bbs;

select * from bbs;

insert into bbs(title, content, writer)
select title, content, writer from bbs;

select count(*) from bbs;

delete from bbs where no>400;