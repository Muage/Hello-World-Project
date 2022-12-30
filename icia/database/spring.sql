CREATE TABLE tbl_board (
    bno INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    content TEXT,
    writer VARCHAR(50) NOT NULL,
    regdate DATETIME DEFAULT NOW(),
    updatedate DATETIME DEFAULT NOW(),
    PRIMARY KEY (bno)
);

desc tbl_board;

insert into tbl_board(writer, title, content)
values('red','왜 리액트인가?','한때 자바스크립트는 웹 브라우저에서 간단한 연산을 했지만 현재는 웹 애플리케이션에서 가장 핵심적인 역할을 한다.');
insert into tbl_board(writer, title, content)
values('blue','컴포넌트','컴포넌트를 선언하는 방식은 두 가지이다. 하나는 함수형 컴포넌트이고, 또 다른 하나는 클래스형 컴포넌트이다');
insert into tbl_board(writer, title, content)
values('yellow','배열 비구조화 할당','배열 안에 들어 있는 값을 쉽게 추출할 수 있도록 해 주는 문법이다.');
insert into tbl_board(writer, title, content)
values('yellow','최신 부트스트랩 템플릿 사이트','Bootstrap은 다양한 웹 요소들의 디자인과 기능을 포함하고 있어 손쉽게 사이트를 제작할 수 있다.');

select * from tbl_board order by bno desc;

insert into tbl_board(writer, title, content)
select writer, title, content from tbl_board;

select count(*) from tbl_board;


/* 2022.10.05 */
select count(*), writer from tbl_board
group by writer;

create table tbl_user(
	uid varchar(20) not null primary key,
    upass varchar(200) not null,
    uname varchar(20) not null,
    photo varchar(200)
);

insert into tbl_user(uid, upass, uname) values('black', 'pass', '홍길동');
insert into tbl_user(uid, upass, uname) values('blue', 'pass', '심청이');
insert into tbl_user(uid, upass, uname) values('yellow', 'pass', '강감찬');

insert into tbl_user(uid, upass, uname) values('red', 'pass', '성춘향');
insert into tbl_user(uid, upass, uname) values('orange', 'pass', '이몽룡');
insert into tbl_user(uid, upass, uname) values('green', 'pass', '이순신');
insert into tbl_user(uid, upass, uname) values('navy', 'pass', '정약용');
insert into tbl_user(uid, upass, uname) values('purple', 'pass', '이성계');
insert into tbl_user(uid, upass, uname) values('white', 'pass', '이방원');
insert into tbl_user(uid, upass, uname) values('brown', 'pass', '정몽주');
insert into tbl_user(uid, upass, uname) values('olive', 'pass', '윤동주');
insert into tbl_user(uid, upass, uname) values('sky', 'pass', '송몽규');

alter table tbl_board add foreign key (writer) references tbl_user(uid);

select b.*, uname
from tbl_board b, tbl_user
where writer = uid;


/* 2022.10.06 */
select * from tbl_user;

delete from tbl_user where uid = 'alpha';
delete from tbl_user where uid = 'beta';
delete from tbl_user where uid = 'gamma';

create table tbl_reply(
	rno int auto_increment primary key,
    bno int not null,
    content varchar(1000) not null,
    replyer varchar(20) not null,
    replyDate datetime default now(),
    updateDate datetime default now(),
    foreign key(bno) references tbl_board(bno),
    foreign key(replyer) references tbl_user(uid)
);

insert into tbl_reply(bno, content, replyer) values(511, '테스트 댓글입니다.', 'register');
insert into tbl_reply(bno, content, replyer) values(511, '리액트까지 해주셔서 감사합니다. 선생님 ㅎㅎ', 'red');
insert into tbl_reply(bno, content, replyer) values(511, '좋은 강의 감사합니다 열심히 따라가볼게요', 'orange');
insert into tbl_reply(bno, content, replyer) values(511, '현재 리액트로 포폴 중인데 복습 한다는마음으로 보겠습니다 ㅎㅎ', 'yellow');
insert into tbl_reply(bno, content, replyer) values(511, '선생님~ 리엑트공부 영상보면서 공부하고 있습니다. 책도 한권 있으면 좋겠다는 생각인데 혹시 추천해 주실 책 있을까요?', 'green');
insert into tbl_reply(bno, content, replyer) values(511, '와~ 그저 빛! 감사합니다. 앙마님 ㅋㅋ. 제가 이번주는 힘들고 다음주부터 또 정주행 가겠습니다. 너무 너무 감사합니다.~', 'blue');

insert into tbl_reply(bno, content, replyer) values(510, '테스트 댓글입니다.', 'register');
insert into tbl_reply(bno, content, replyer) values(510, '리액트까지 해주셔서 감사합니다. 선생님 ㅎㅎ', 'red');
insert into tbl_reply(bno, content, replyer) values(510, '좋은 강의 감사합니다 열심히 따라가볼게요', 'orange');
insert into tbl_reply(bno, content, replyer) values(510, '현재 리액트로 포폴 중인데 복습 한다는마음으로 보겠습니다 ㅎㅎ', 'yellow');
insert into tbl_reply(bno, content, replyer) values(510, '선생님~ 리엑트공부 영상보면서 공부하고 있습니다. 책도 한권 있으면 좋겠다는 생각인데 혹시 추천해 주실 책 있을까요?', 'green');
insert into tbl_reply(bno, content, replyer) values(510, '와~ 그저 빛! 감사합니다. 앙마님 ㅋㅋ. 제가 이번주는 힘들고 다음주부터 또 정주행 가겠습니다. 너무 너무 감사합니다.~', 'blue');

create view reply_user as
select r.*, uname, photo
from tbl_reply r, tbl_user u
where replyer = uid;

select * from reply_user;

insert into tbl_reply(bno, content, replyer)
select bno, content, replyer from tbl_reply;


/* 2022.10.07 */
create table tbl_product(
	pcode char(15) primary key,
    pname varchar(200) not null,
    price int default 0,
    image varchar(200),
    pdate datetime default now()
);

drop table tbl_product;

insert into tbl_product(pcode, pname, image)
values(date_format(now(), 'P%Y%m%d%H%i%S'), 'GV80', '/upload/product/gv80.png');
insert into tbl_product(pcode, pname, image)
values(date_format(now(), 'P%Y%m%d%H%i%S'), 'GV70', '/upload/product/gv70.png');
insert into tbl_product(pcode, pname, image)
values(date_format(now(), 'P%Y%m%d%H%i%S'), '5008', '/upload/product/5008.png');
insert into tbl_product(pcode, pname, image)
values(date_format(now(), 'P%Y%m%d%H%i%S'), '3008', '/upload/product/3008.png');
insert into tbl_product(pcode, pname, image)
values(date_format(now(), 'P%Y%m%d%H%i%S'), 'X3', '/upload/product/x3.png');
insert into tbl_product(pcode, pname, image)
values(date_format(now(), 'P%Y%m%d%H%i%S'), 'X5', '/upload/product/x5.png');

select * from tbl_product;


/* 2022.10.11 */
desc tbl_board;

alter table tbl_board add column replycnt int default 0;
alter table tbl_board add column viewcnt int default 0;

select count(rno) from tbl_reply;
select * from tbl_reply;

update tbl_board
set replycnt = (select count(rno) from tbl_reply where tbl_reply.bno = tbl_board.bno)
where bno > 0;

select * from tbl_board order by replycnt desc;

/* 2022.10.12 */
select * from tbl_user;

alter table tbl_user add column point int default 0;

create table tbl_message (
	mid int auto_increment primary key,
    receiver varchar(20) not null,
    sender varchar(20) not null,
    message text,
    sendDate datetime default now(),
    readDate datetime,
    foreign key(receiver) references tbl_user(uid),
    foreign key(sender) references tbl_user(uid)
);

insert into tbl_message(receiver, sender, message) values('red','blue', '토요일에 우리 만날까?');
insert into tbl_message(receiver, sender, message) values('blue','red','오랜만이네. 그날은 선약이 있어서 불가능해.');
insert into tbl_message(receiver, sender, message) values('green', 'orange', '잘 지내지?');
insert into tbl_message(receiver, sender, message) values('orange', 'green', '오랜만이네. 반갑다.');

select * from tbl_message;

select m.*, uname
from tbl_message m, tbl_user u
where sender = 'red' and receiver = uid;

