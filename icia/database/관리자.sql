/* �������� */
create user java identified by pass;

/* ���Ѻο� */
grant connect, resource, dba to java;

/* ����Ȯ�� */
select username from dba_users;

/* �������� */
drop user java;
