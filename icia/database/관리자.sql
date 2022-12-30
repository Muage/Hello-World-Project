/* 유저생성 */
create user java identified by pass;

/* 권한부여 */
grant connect, resource, dba to java;

/* 유저확인 */
select username from dba_users;

/* 유저삭제 */
drop user java;
