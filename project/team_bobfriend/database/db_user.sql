select concat('u', max((substr(u_code, 2)) + 1)) as new_code from tbl_user;	/* 일반 회원가입 */
select concat('k', '2507276386') as new_code;	/* 카카오 회원가입 */

delete from tbl_user;

select * from tbl_user where u_id = 'test';

select * from tbl_user;