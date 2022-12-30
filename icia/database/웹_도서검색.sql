create table books(
	id int auto_increment primary key,
    title varchar(1000),
    contents varchar(2000),
    wdate datetime default now(),
    image varchar(1000),
    publisher varchar(100),
    authors varchar(200),
    price int default 0,
    isbn varchar(100)
);

desc books;

select * from books;