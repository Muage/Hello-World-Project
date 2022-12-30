/* 게시글 테이블 */
create table posts(
	id int auto_increment primary key,
    userid varchar(20) not null,
    title varchar(1000) not null,
    body varchar(2000)
);

insert into posts(userid, title, body) values('red', '선언형', 'React는 상호작용이 많은 UI를 만들 때 생기는 어려움을 줄여줍니다. 애플리케이션의 각 상태에 대한 간단한 뷰만 설계하세요. 그럼 React는 데이터가 변경됨에 따라 적절한 컴포넌트만 효율적으로 갱신하고 렌더링합니다. 선언형 뷰는 코드를 예측 가능하고 디버그하기 쉽게 만들어 줍니다.');
insert into posts(userid, title, body) values('blue', '컴포넌트 기반', '스스로 상태를 관리하는 캡슐화된 컴포넌트를 만드세요. 그리고 이를 조합해 복잡한 UI를 만들어보세요. 컴포넌트 로직은 템플릿이 아닌 JavaScript로 작성됩니다. 따라서 다양한 형식의 데이터를 앱 안에서 손쉽게 전달할 수 있고, DOM과는 별개로 상태를 관리할 수 있습니다.');
insert into posts(userid, title, body) values('green', '한 번 배워서 어디서나 사용하기', '기술 스택의 나머지 부분에는 관여하지 않기 때문에, 기존 코드를 다시 작성하지 않고도 React의 새로운 기능을 이용해 개발할 수 있습니다. React는 Node 서버에서 렌더링을 할 수도 있고, React Native를 이용하면 모바일 앱도 만들 수 있습니다.');
insert into posts(userid, title, body) values('sky', '간단한 컴포넌트', 'React 컴포넌트는 render()라는 메서드를 구현하는데, 이것은 데이터를 입력받아 화면에 표시할 내용을 반환하는 역할을 합니다. 이 예제에서는 XML과 유사한 문법인 JSX를 사용합니다. 컴포넌트로 전달된 데이터는 render() 안에서 this.props를 통해 접근할 수 있습니다.');
insert into posts(userid, title, body) values('pink', '상태를 가지는 컴포넌트', '컴포넌트는 this.props를 이용해 입력 데이터를 다루는 것 외에도 내부적인 상태 데이터를 가질 수 있습니다. 이는 this.state로 접근할 수 있습니다. 컴포넌트의 상태 데이터가 바뀌면 render()가 다시 호출되어 마크업이 갱신됩니다.');
insert into posts(userid, title, body) values('black', '애플리케이션', 'props와 state를 사용해서 간단한 Todo 애플리케이션을 만들 수 있습니다. 이 예제에서는 state를 사용해 사용자가 입력한 텍스트와 할 일 목록을 관리합니다. 이벤트 핸들러들이 인라인으로 각각 존재하는 것처럼 보이지만, 실제로는 이벤트 위임을 통해 하나로 구현됩니다.');
insert into posts(userid, title, body) values('red', '외부 플러그인을 사용하는 컴포넌트', 'React는 유연하며 다른 라이브러리나 프레임워크를 함께 활용할 수 있습니다. 이 예제에서는 외부 마크다운 라이브러리인 remarkable을 사용해 <textarea>의 값을 실시간으로 변환합니다.');

insert into posts(userid, title, body)
select userid, title, body from posts;

select count(*) from posts;

alter table posts add column wdate datetime default now();

select * from posts order by id desc;

alter table posts add column state char(1) default '1';


/* 사용자(회원관리) 테이블 */
create table users(
	uid varchar(20) not null primary key,
    uname varchar(20) not null,
    upass varchar(20) not null,
    address varchar(500),
    tel varchar(20)
);

insert into users(uid, uname, upass) values('red', '레드', 'pass');
insert into users(uid, uname, upass) values('blue', '블루', 'pass');
insert into users(uid, uname, upass) values('green', '그린', 'pass');
insert into users(uid, uname, upass) values('sky', '스카이', 'pass');
insert into users(uid, uname, upass) values('pink', '핑크', 'pass');
insert into users(uid, uname, upass) values('black', '블랙', 'pass');
insert into users(uid, uname, upass) values('orange', '오렌지', 'pass');
insert into users(uid, uname, upass) values('white', '화이트', 'pass');
insert into users(uid, uname, upass) values('yellow', '옐로우', 'pass');
insert into users(uid, uname, upass) values('navy', '네이비', 'pass');
insert into users(uid, uname, upass) values('brown', '브라운', 'pass');

select distinct(userid) from posts;	/* foreign key 지정 시 users 테이블의 uid 중 없는 userid가 있으면 안되기 때문에 확인해야함 */
select * from users;

alter table posts add foreign key(userid) references users(uid);

select * from users where uid like '%%';

select * from users where uid like '%%' or uname like '%%' limit 0, 5;

alter table users add status varchar(20) default 'green';


create table banner(
	id int auto_increment primary key,
    title varchar(200) not null,
    url varchar(500) not null,
    bshow int default 1,
    wdate datetime default now()
);

insert into banner(title, url) values('전 품목 5%세일', '/images/img01.jpg');
insert into banner(title, url) values('추석 특별 세일 5%', '/images/img02.jpg');
insert into banner(title, url) values('풍성한 보름달이 밝았습니다.', '/images/img03.jpg');
insert into banner(title, url) values('메가박스 예매권 누구나 30% 할인권', 'https://picsum.photos/seed/7/900/150');
insert into banner(title, url) values('놀라운 혜댁으로 장보기', 'https://picsum.photos/seed/6/900/150');

select * from banner;

update banner set bshow = 0 where id = 4;

drop table banner;

select * from banner where id = 7;

create table best(
	id int auto_increment primary key,
    title varchar(500) not null,
    price double default 0,
    category varchar(100) not null,
    linkImg varchar(500) not null,
    isShow boolean default true,
    wdate datetime default now()
);

drop table best;

insert into best(title, price, category, linkImg) values('Mario Kart™ 8 Deluxe', 59.99, 'Nintendo Switch', 'https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_auto/c_scale,w_300/v1/ncom/en_US/games/switch/m/mario-kart-8-deluxe-switch/hero?_a=AJADJWI0');
insert into best(title, price, category, linkImg) values('TRIANGLE STRATEGY™', 59.99, 'Nintendo Switch', 'https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_auto/c_scale,w_300/v1/ncom/en_US/games/switch/t/triangle-strategy-switch/hero?_a=AJADJWI0');
insert into best(title, price, category, linkImg) values('Pokémon™ Legends: Arceus', 59.99, 'Nintendo Switch', 'https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_auto/c_scale,w_300/v1/ncom/en_US/games/switch/p/pokemon-legends-arceus-switch/hero?_a=AJADJWI0');
insert into best(title, price, category, linkImg) values('Super Mario™ 3D World + Bowser’s Fury', 59.99, 'Nintendo Switch', 'https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_auto/c_scale,w_300/v1/ncom/en_US/games/switch/s/super-mario-3d-world-plus-bowsers-fury-switch/hero?_a=AJADJWI0');
insert into best(title, price, category, linkImg) values('Cuphead', 19.99, 'Nintendo Switch', 'https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_auto/c_scale,w_300/v1/ncom/en_US/games/switch/c/cuphead-switch/hero?_a=AJADJWI0');
insert into best(title, price, category, linkImg) values('Minecraft', 29.99, 'Nintendo Switch', 'https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_auto/c_scale,w_300/v1/ncom/en_US/games/switch/m/minecraft-switch/hero?_a=AJADJWI0');
insert into best(title, price, category, linkImg) values('Mario + Rabbids® Kingdom Battle', 59.99, 'Nintendo Switch', 'https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_auto/c_scale,w_300/v1/ncom/en_US/games/switch/m/mario-kart-8-deluxe-switch/hero?_a=AJADJWI0');
insert into best(title, price, category, linkImg) values('Unravel Two', 59.99, 'Nintendo Switch', 'https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_auto/c_scale,w_300/v1/ncom/en_US/games/switch/u/unravel-two-switch/hero?_a=AJADJWI0');

select * from best;
select * from best where isShow = true;
select * from best where isShow = 1;

update best set isShow = false where id = 2 or id = 4;

select *, concat('$', format(price, 2)) fprice from best where isShow = true;


create table customers(
	id int auto_increment primary key,
    name varchar(50) not null,
    image varchar(200) not null,
    job varchar(100),
    birthday date,
    gender char(1)
);

drop table customers;

insert into customers(name, image, job, birthday, gender) values('짱구', '/photos/짱구.png', '유치원생', '1994-05-05', '남');
insert into customers(name, image, job, birthday, gender) values('훈이', '/photos/훈이.png', '유치원생', '1995-02-04', '남');
insert into customers(name, image, job, birthday, gender) values('맹구', '/photos/맹구.png', '유치원생', '1994-09-10', '남');
insert into customers(name, image, job, birthday, gender) values('철수', '/photos/철수.png', '유치원생', '1994-07-19', '남');
insert into customers(name, image, job, birthday, gender) values('유리', '/photos/유리.png', '유치원생', '1994-06-05', '여');

select * from customers;

update customers set job = '떡잎마을방범대 대장' where id = 1;
update customers set job = '떡잎마을방범대 멤버' where id = 2;
update customers set job = '떡잎마을방범대 멤버' where id = 3;
update customers set job = '떡잎마을방범대 멤버' where id = 4;
update customers set job = '떡잎마을방범대 멤버' where id = 5;


insert into customers(name, image, job, birthday, gender)
select name, image, job, birthday, gender from customers;

alter table customers add column state char(1) default '1';

select count(*), gender from customers group by gender;
select count(*), gender from customers where job like '%떡잎%' group by gender;
select count(*), gender from customers where id < 100 group by gender;

/* 직업별 인원수 */
select count(*), job from customers group by job;

select job, count(*) count from customers group by job order by count desc;

select ifnull(count(*), 0) count, gender, job from customers group by ifnull(gender, 0), ifnull(job, 0);

select job,
	sum(case gender when '남' then 1 else 0 end) male,
    sum(case gender when '여' then 1 else 0 end) female
from customers
group by job;

/* teacher */
select tbl2.job, tbl2.dis_gender,
	(select count(*) from customers where job = tbl2.job and gender=tbl2.dis_gender) result
from (select job, dis_gender from customers,
	(select distinct(gender) dis_gender from customers) tbl1 group by job, dis_gender) tbl2;


select month(jdate) month, count(*) from customers where year(jdate) = '2022' group by month order by month;

call count_month(2022);


alter table customers add column jdate date;
update customers set jdate = '2020-01-01' where id between 1 and 10;
update customers set jdate = '2021-01-01' where id between 11 and 30;
update customers set jdate = '2021-03-01' where id between 31 and 100;
update customers set jdate = '2021-02-01' where id between 101 and 150;
update customers set jdate = '2021-04-01' where id between 151 and 300;

update customers set jdate = '2022-01-01' where id between 301 and 500;
update customers set jdate = '2022-02-01' where id between 501 and 700;
update customers set jdate = '2022-03-01' where id between 701 and 850;
update customers set jdate = '2022-04-01' where id between 1 and 10;
update customers set jdate = '2022-05-01' where id between 11 and 20;
update customers set jdate = '2022-06-01' where id between 1001 and 1110;
update customers set jdate = '2022-07-01' where id between 1111 and 1200;
update customers set jdate = '2022-08-01' where id between 1201 and 1260;
update customers set jdate = '2022-09-01' where id between 1261 and 1365;
update customers set jdate = '2022-10-01' where id between 1366 and 1400;
update customers set jdate = '2022-11-01' where id between 1401 and 1405;
update customers set jdate = '2022-12-01' where id between 1406 and 1500;


select dis_job as job, dis_gender as gender,
	(select count(*) from customers where job = dis_job and gender = dis_gender) as count
from
	(select distinct(job) as dis_job from customers) tbl1,
	(select distinct(gender) as dis_gender from customers) tbl2
order by dis_job, dis_gender;

call count_gender_job;


/* 2022년 월별 가입 남녀수 */
select gender, date_format(dis_date, '%Y-%m') date,
	(select count(*) from customers where month(jdate) = month(dis_date) and gender = gender) as count
from
	(select distinct(jdate) as dis_date from customers where year(jdate) = '2022' group by month(jdate)) tbl_month,
	(select distinct(gender) as gender from customers) tbl_gender
order by dis_date, gender;