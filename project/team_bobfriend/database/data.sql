/*카테고리 테이블*/
insert into tbl_category(c_type) values('한식');
insert into tbl_category(c_type) values('일식');
insert into tbl_category(c_type) values('중식');
insert into tbl_category(c_type) values('양식');
insert into tbl_category(c_type) values('아시안');
insert into tbl_category(c_type) values('분식');
insert into tbl_category(c_type) values('패스트푸드');
insert into tbl_category(c_type) values('디저트');
insert into tbl_category(c_type) values('기타');


/*유저 타입 테이블*/
insert into tbl_user_type(u_type) values('관리자');
insert into tbl_user_type(u_type) values('점주');
insert into tbl_user_type(u_type) values('일반사용자');
insert into tbl_user_type(u_type) values('배달');


/*등급 테이블*/
insert into tbl_grade(standard,grade) values(0,'동');
insert into tbl_grade(standard,grade) values(100,'은');
insert into tbl_grade(standard,grade) values(200,'금');


/*가게 테이블*/
insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s1','롯데리아 인천학익점','인천 미추홀구 매소홀로 466','032-873-4115',7,'/upload/store/photo/s1.png','홍길동','purple',(select u_pass from tbl_user where u_id='purple'));

insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s2','육심','인천 미추홀구 소성로 251','032-873-2564',1,'/upload/store/photo/s2.png','김한식','red',(select u_pass from tbl_user where u_id='red'));

insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s3','안짱스시','인천 미추홀구 매소홀로 429','032-866-4523',2,'/upload/store/photo/s3.jpg','이일식','orange',(select u_pass from tbl_user where u_id='orange'));

insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s4','칭칭차이나 문학점','인천 미추홀구 미추홀대로 486-31','032-432-2221',3,'/upload/store/photo/s4.jpg','박중식','yellow',(select u_pass from tbl_user where u_id='yellow'));

insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s5','쿡대디','인천 미추홀구 소성로 191 1층','0507-1313-8454',4,'/upload/store/photo/s5.jpg','최양식','green',(select u_pass from tbl_user where u_id='green'));

insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s6','대나무베트남명품쌀국수 학익점','인천 미추홀구 소성로 192 1층 대나무베트남쌀국수','032-876-2627',5,'/upload/store/photo/s6.jpg','아시안','blue',(select u_pass from tbl_user where u_id='blue'));

insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s7','소끔만두','인천 미추홀구 매소홀로 474 수빈빌딩 105호','0507-1342-3992',6,'/upload/store/photo/s7.jpg','강분식','navy',(select u_pass from tbl_user where u_id='navy'));

insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s8','메가MGC커피 인천학익신동아점','인천 미추홀구 매소홀로 476','032-875-0126',8,'/upload/store/photo/s8.jpg','강감찬','black',(select u_pass from tbl_user where u_id='black'));

insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s9','두찜 학익점','인천 미추홀구 매소홀로 470','0507-1408-3047',1,'/upload/store/photo/s9.jpg','심청이','white',(select u_pass from tbl_user where u_id='white'));

insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s10','약선당감자탕 학익점','인천 미추홀구 매소홀로 446','032-863-7725',1,'/upload/store/photo/s10.jpg','나점주','bronze',(select u_pass from tbl_user where u_id='bronze'));

insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s11','숯골그집쭈꾸미','인천 미추홀구 학익소로 29 석목빌딩 106호~107호','032-862-6418',1,'/upload/store/photo/s11.jpg','김점주','silver',(select u_pass from tbl_user where u_id='silver'));

insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s12','명륜진사갈비 인천학익점','인천 미추홀구 소성로 153','032-876-1402',1,'/upload/store/photo/s12.jpg','이점주','paltinum',(select u_pass from tbl_user where u_id='paltinum'));

insert into tbl_store(s_code, s_name, s_location, s_tel,s_c_code, s_photo, s_admin,u_id,u_pass)
values('s13','진천순대','인천 미추홀구 소성로 314','032-421-0053',1,'/upload/store/photo/s13.jpg','최한식','diamond',(select u_pass from tbl_user where u_id='diamond'));


/*메뉴 테이블*/
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s1', '힙&핫치킨버거 세트', 8300,'/upload/menu/m1.jpg',1);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s1', '더블 한우불고기 세트', 13700,'/upload/menu/m2.jpg',2);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s1', '한우트러플머쉬룸', 9300,'/upload/menu/m3.jpg',3);

insert into tbl_menu(s_code,m_name,m_price,m_code) values('s2', '삼겹살', 9000,1);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s2', '항정살', 9000,2);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s2', '우삼겹', 9000,3);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s2', '목살', 9000,4);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s2', '소등심', 12000,5);

insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s3', '연어명란(12pcs)', 20000,'/upload/menu/m4.jpg',1);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s3', '특모듬초밥(14pcs)', 20000,'/upload/menu/m5.jpg',2);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s3', '추천초밥(15개)', 27000,3);

insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s4', '옛날고기짬뽕(보통)', 10000,'/upload/menu/m6.jpg',1);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s4', '칭칭쟁반짜장', 8000,'/upload/menu/m7.jpg',2);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s4', '탕수육(小)', 17000,'/upload/menu/m8.jpg',3);

insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s5', '베이컨까르보나라', 8900,'/upload/menu/m9.jpg',1);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s5', '쭈새 빠네', 15000,'/upload/menu/m10.jpg',2);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s5', '쉬림프 로제 파스타', 11900,'/upload/menu/m11.jpg',3);

insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s6', '소고기 쌀국수(기본(Pho))', 9000,'/upload/menu/m12.jpg',1);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s6', '고기구이국수(분짜)', 11000,'/upload/menu/m13.jpg',2);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s6', '짜조(6개)', 7000,'/upload/menu/m14.jpg',3);

insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s7', '고기만두', 4500,'/upload/menu/m15.jpg',1);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s7', '김치만두', 4500,'/upload/menu/m16.jpg',2);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s7', '새우만두', 4500,'/upload/menu/m17.jpg',3);

insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s8', '아메리카노', 1500,'/upload/menu/m18.jpg',1);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s8', '퐁크러쉬', 3900,'/upload/menu/m19.jpg',2);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s8', '딸기라뗴', 3500,'/upload/menu/m20.jpg',3);

insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s9', '트러플크림찜닭', 31800,'/upload/menu/m21.jpg',1);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s9', '불마왕불닭', 31800,'/upload/menu/m22.jpg',2);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s9', '까만/빨간찜닭두마리', 38800,'/upload/menu/m23.jpg',3);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s9', '한마리찜닭', 25800,4);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s9', '로제찜닭', 29800,5);

insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s10', '감자탕(大)', 42000,'/upload/menu/m24.jpg',1);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s10', '등뼈찜(순한맛)(대)', 53000,'/upload/menu/m25.jpg',2);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s10', '약선삼계탕', 14000,'/upload/menu/m26.jpg',3);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s10', '뼈해장국', 9000,4);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s10', '돈가스', 9000,5);

insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s11', '쭈꾸미볶음(1인분)', 8900,'/upload/menu/m27.jpg',1);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s11', '삼겹살볶음(1인분)', 8900,'/upload/menu/m28.jpg',2);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s11', '생등심돈까스(국내산)', 9000,'/upload/menu/m29.jpg',3);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s11', '왕새우튀김(4마리)', 9500,4);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s11', '해물파전(대 사이즈)', 16000,5);

insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s12', '무한리필 숯불돼지갈비', 16500,'/upload/menu/m30.jpg',1);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s12', '소갈비살', 7000,'/upload/menu/m31.jpg',2);
insert into tbl_menu(s_code,m_name,m_price,m_photo,m_code) values('s12', '돼지껍데기', 3000,'/upload/menu/m32.jpg',3);

insert into tbl_menu(s_code,m_name,m_price,m_code) values('s13', '순대국', 8000,1);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s13', '매운순대국', 8500,2);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s13', '모듬전골 대', 32000,3);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s13', '곱창전골 대', 31000,4);
insert into tbl_menu(s_code,m_name,m_price,m_code) values('s13', '곱창볶음 1인분', 13000,5);


/* 유저 테이블 */
insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('d0', '삭제된 사용자 입니다.', '삭제된 사용자 입니다.', 'delete', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('a1', '관리자1', '관리자1', 'admin1', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('a2', '관리자2', '관리자2', 'admin2', 'pass');

update tbl_user set u_type=1 where u_code='d0';
update tbl_user set u_type=1 where u_code='a1';
update tbl_user set u_type=1 where u_code='a2';

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u1', '김한식', '인천시 미추홀구 문학동', 'red', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)	
values('u2', '이일식', '대구시 수성구 연호동', 'orange', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u3', '박중식', '광주시 북구 임동', 'yellow', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u4', '최양식', '인천시 미추홀구 학익동', 'green', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u5', '아시안', '인천시 미추홀구 문학동', 'blue', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u6', '강분식', '대구시 수성구 연호동', 'navy', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u7', '홍길동', '광주시 북구 임동', 'purple', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u8', '강감찬', '인천시 미추홀구 학익동', 'black', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u9', '심청이', '인천시 미추홀구 문학동', 'white', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u10', '나점주', '대구시 수성구 연호동', 'bronze', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u11', '김점주', '광주시 북구 임동', 'silver', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u12', '이점주', '인천시 미추홀구 학익동', 'paltinum', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u13', '최한식', '인천시 미추홀구 문학동', 'diamond', 'pass');

update tbl_user set u_type=2 where u_code like '%u%';
/*---------------------------일반사용자------------------------------------*/
insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u14', '김유저', '인천시 미추홀구 학익동', 'user1', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u15', '이유저', '인천시 미추홀구 학익동', 'user2', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u16', '최유저', '인천시 미추홀구 주안동', 'user3', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u17', '박유저', '인천시 미추홀구 문학동', 'user4', 'pass');

insert into tbl_user(u_code,u_name,u_address,u_id,u_pass)
values('u18', '강유저', '인천시 남동구 구월동', 'user5', 'pass');
/*---------------------------------------------------------------*/


/* 즐겨찾기 테이블 */
insert into tbl_liked(u_code,s_code) values('u14', 's1');
insert into tbl_liked(u_code,s_code) values('u14', 's3');
insert into tbl_liked(u_code,s_code) values('u14', 's5');
insert into tbl_liked(u_code,s_code) values('u14', 's7');
insert into tbl_liked(u_code,s_code) values('u14', 's9');
insert into tbl_liked(u_code,s_code) values('u14', 's11');

insert into tbl_liked(u_code,s_code) values('u15', 's2');
insert into tbl_liked(u_code,s_code) values('u15', 's4');
insert into tbl_liked(u_code,s_code) values('u15', 's6');

insert into tbl_liked(u_code,s_code) values('u16', 's3');
insert into tbl_liked(u_code,s_code) values('u16', 's6');
insert into tbl_liked(u_code,s_code) values('u16', 's9');

insert into tbl_liked(u_code,s_code) values('u17', 's5');
insert into tbl_liked(u_code,s_code) values('u17', 's10');
insert into tbl_liked(u_code,s_code) values('u17', 's13');

insert into tbl_liked(u_code,s_code) values('u18', 's13');
insert into tbl_liked(u_code,s_code) values('u18', 's12');
insert into tbl_liked(u_code,s_code) values('u18', 's11');

/* 신고 테이블 */
insert into tbl_report(r_code,suer,defender,r_result, r_type) values('r1', 'u1', 'u3', '신고 사유를 적는 테스트입니다.', '신고타입');
insert into tbl_report(r_code,suer,defender,r_result, r_type) values('r2', 'u1', 'u3', '신고 사유가 잘 전달되고 있나요?', '신고타입');
insert into tbl_report(r_code,suer,defender,r_result, r_type) values('r3', 'u2', 'u3', '신고에 문제가 있으면 태희님께 자문을 구합세요!', '신고타입');


/* 리뷰 테이블 */
insert into tbl_review(s_code,u_code,r_rating) values('s1', 'u14', '4.5');
insert into tbl_review(s_code,u_code,r_rating) values('s3', 'u14', '5');
insert into tbl_review(s_code,u_code,r_rating) values('s5', 'u14', '5');
insert into tbl_review(s_code,u_code,r_rating) values('s7', 'u14', '4');
insert into tbl_review(s_code,u_code,r_rating) values('s9', 'u14', '4.5');
insert into tbl_review(s_code,u_code,r_rating) values('s11', 'u14', '5');


insert into tbl_review(s_code,u_code,r_rating) values('s2', 'u15', '4');
insert into tbl_review(s_code,u_code,r_rating) values('s4', 'u15', '4.5');
insert into tbl_review(s_code,u_code,r_rating) values('s6', 'u15', '5');


insert into tbl_review(s_code,u_code,r_rating) values('s3', 'u16', '4');
insert into tbl_review(s_code,u_code,r_rating) values('s6', 'u16', '4');
insert into tbl_review(s_code,u_code,r_rating) values('s9', 'u16', '4');


insert into tbl_review(s_code,u_code,r_rating) values('s5', 'u17', '4.5');
insert into tbl_review(s_code,u_code,r_rating) values('s10', 'u17', '5');
insert into tbl_review(s_code,u_code,r_rating) values('s13', 'u17', '5');


insert into tbl_review(s_code,u_code,r_rating) values('s1', 'u18', '3');
insert into tbl_review(s_code,u_code,r_rating) values('s2', 'u18', '2');
insert into tbl_review(s_code,u_code,r_rating) values('s3', 'u18', '1');

/* 유저 삭제 테이블 */
insert into tbl_user_delete(d_code) values('u3');

/* 게시글 테이블 */
insert into tbl_post(u_code, s_code, m_name, m_photo) values('u1', 's1', '감자탕(大)', '/upload/menu/m24.jpg');
insert into tbl_post(u_code, s_code, m_name, m_photo) values('u2', 's1', '감자탕(大)', '/upload/menu/m24.jpg');
insert into tbl_post(u_code, s_code, m_name, m_photo) values('u3', 's1', '감자탕(大)', '/upload/menu/m24.jpg');
insert into tbl_post(u_code, s_code, m_name, m_photo) values('u4', 's1', '감자탕(大)', '/upload/menu/m24.jpg');

insert into tbl_post(u_code, s_code, m_name, m_photo) values('u1', 's2', '쭈꾸미볶음(1인분)', '/upload/menu/m24.jpg');
insert into tbl_post(u_code, s_code, m_name, m_photo) values('u2', 's2', '쭈꾸미볶음(1인분)', '/upload/menu/m24.jpg');
insert into tbl_post(u_code, s_code, m_name, m_photo) values('u3', 's2', '쭈꾸미볶음(1인분)', '/upload/menu/m24.jpg');
insert into tbl_post(u_code, s_code, m_name, m_photo) values('u4', 's2', '쭈꾸미볶음(1인분)', '/upload/menu/m24.jpg');