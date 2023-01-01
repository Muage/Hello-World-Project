select * from tbl_menu where s_code = 's1';

select ifnull(max(m_code) + 1, 1) as new_code from tbl_menu where s_code = 's1';

delete from tbl_menu where s_code = 's1' and m_code = 5;

update tbl_menu
set m_name = '불고기버거', m_price = '6600', m_photo = null
where s_code = 's1' and m_code = 1;

update tbl_menu
set m_name = '티랙스버거', m_price = '5000', m_photo = null
where s_code = 's1' and m_code = 2;

update tbl_menu
set m_name = '한우불고기콤보버거세트', m_price = '12000', m_photo = null
where s_code = 's1' and m_code = 3;

insert into tbl_menu(m_code, s_code, m_name, m_price) values(4, 's1', '불고기', 6600);
insert into tbl_menu(m_code, s_code, m_name, m_price) values(5, 's1', '티랙스', 5000);
insert into tbl_menu(m_code, s_code, m_name, m_price) values(6, 's1', '한우불고기콤보버거', 12000);