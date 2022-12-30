create table movie(
	id int auto_increment primary key,
    title varchar(200) not null,
    image varchar(200),
    actor varchar(200),
    director varchar(200),
    link varchar(200),
    pubDate varchar(100),
    wdate datetime default now()
);

select * from movie;