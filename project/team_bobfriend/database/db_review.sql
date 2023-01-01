select r.*, u.u_name
from tbl_review r, tbl_user u
where s_code = 's2' and r.u_code = u.u_code;

delete from tbl_review where s_code = 's3';


select *
from tbl_review v
inner join tbl_reply p
on v.u_code = p.u_code
where v.u_code = 'u1';

select p.* from tbl_reply p where u_code = 'u1';

create table tbl_reply(
	s_code varchar(10) not null,
	u_code varchar(100) not null,
    re_content varchar(200),
    re_date datetime default now(),
    foreign key (s_code) references tbl_store(s_code),
    foreign key (u_code) references tbl_user(u_code),
    primary key(u_code, re_date)
);

insert into tbl_reply(s_code,u_code) values('s1', 'u1');


/* s1r1 */
select ifnull(
   concat('s1', concat('r', max((substr(r_code, 4)) + 1))),
   concat('s1', concat('r', 1))
) as new_code
from tbl_review
where s_code = 's1';