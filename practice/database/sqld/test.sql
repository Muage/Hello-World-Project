--SQL Developer 행 단위 주석 : ctrl + /

/*SQL Developer 범위 단위 주석 : alt + shift + c
test
check*/

--실행 단축키 : ctrl + enter

--tab 이라는 테이블로부터 모든 행과 모든 컬럼 출력
select * from tab;

create table 고객(
    id varchar2(20 byte) not null,
    name varchar2(30 byte) not null
);

alter table 고객 add constraint 고객_pk primary key (id);