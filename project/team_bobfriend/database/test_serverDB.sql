use team3db;

create table tbl_test1(
	test1_1 int auto_increment primary key,
    test1_2 varchar(255),
    test1_3	char(10),
    test1_4 boolean
);

select * from tbl_test1;

create table tbl_test2(
	test2_1 int auto_increment primary key,
    test2_2 varchar(255),
    test2_3	char(10),
    test2_4 boolean
);

select * from tbl_test2;

insert into tbl_test1(test1_2, test1_3, test1_4) values('test', '0123456789', true);
insert into tbl_test1(test1_2, test1_3, test1_4) values('test', '0123456789', true);
insert into tbl_test1(test1_2, test1_3, test1_4) values('test', '0123456789', true);

insert into tbl_test2(test2_2, test2_3, test2_4) values('test', '0123456789', true);
insert into tbl_test2(test2_2, test2_3, test2_4) values('test', '0123456789', true);
insert into tbl_test2(test2_2, test2_3, test2_4) values('test', '0123456789', true);