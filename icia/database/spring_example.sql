desc tbl_user;

select * from tbl_user;

alter table tbl_user
add column joinDate datetime default now();

