select s_code from tbl_cart where u_code='u19' group by s_code;

insert into tbl_cart(u_code, s_code, m_name, amount, m_photo, m_price)
value('u19', 's3', '아무거나', 3, '', 2000);

