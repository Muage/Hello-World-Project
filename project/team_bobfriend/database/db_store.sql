select *
from tbl_store
where s_code = 's1';
        
update tbl_store
set s_name = '롯데리아'
where s_code = 's1';

select concat('s', max((substr(s_code, 2)) + 1)) as new_code from tbl_store;

update tbl_store
set s_photo = null
where s_code = 's1';

select *
from tbl_menu
where s_code = 's1';

insert into tbl_store(s_code,s_name,s_admin,s_location,s_tel,s_c_code) 
values('s4','롯데리아 인천학익점','담당자','인천 미추홀구 매소홀로 466','032-873-4115',3);

select s.*, c.c_type
from tbl_store s, tbl_category c
where s.s_c_code = c.c_code;