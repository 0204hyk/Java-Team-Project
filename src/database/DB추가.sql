
--카테고리  1~5번 커피 카테고리 / 6번부터는 옵션 카테고리
INSERT INTO category VALUES (1, '인기메뉴');
INSERT INTO category VALUES (2, '커피');
INSERT INTO category VALUES (3, '논커피');
INSERT INTO category VALUES (4, '에이드');
INSERT INTO category VALUES (5, '프라페');

--추가옵션
INSERT INTO extra_option VALUES (1, 'HOT',  0);
INSERT INTO extra_option VALUES (2, 'ICE',  0);
INSERT INTO extra_option VALUES (3, 'DECAF_NO',  0);
INSERT INTO extra_option VALUES (4, 'DECAF_YES',  1000);
INSERT INTO extra_option VALUES (5, 'SIZE_S',  0);
INSERT INTO extra_option VALUES (6, 'SIZE_M',  500);
INSERT INTO extra_option VALUES (7, 'SIZE_L',  1000);
INSERT INTO extra_option VALUES (8, 'Plastic',  0);
INSERT INTO extra_option VALUES (9, 'Tumbler',  0);
INSERT INTO extra_option VALUES (10, 'ICE_NORMAL',  0);
INSERT INTO extra_option VALUES (11, 'ICE_LOW',  0);
INSERT INTO extra_option VALUES (12, 'ICE_NONE',  0);
INSERT INTO extra_option VALUES (13, 'SHOT_1',  300);
INSERT INTO extra_option VALUES (14, 'SHOT_2',  600);
INSERT INTO extra_option VALUES (15, 'Milk',  0);
INSERT INTO extra_option VALUES (16, 'Soy_Milk',  300);
INSERT INTO extra_option VALUES (17, 'Lowfat_Milk',  0);

--메뉴
<<<<<<< HEAD
--메뉴
INSERT INTO menu VALUES (1, '에스프레소', 2, 1, 'images/KioskImages/menu/coffee/에스프레소.png', 3000, 'Espresso'); 
INSERT INTO menu VALUES (2, '아메리카노', 2, 1, 'images/KioskImages/menu/coffee/아메리카노.png',3500, 'Americano'); 
INSERT INTO menu VALUES (3, '카페라떼', 2, 2, 'images/KioskImages/menu/coffee/카페라떼.png',4500, 'Cafe Latte'); 
INSERT INTO menu VALUES (4, '카페모카', 2, 2, 'images/KioskImages/menu/coffee/카페모카.png',4500, 'Cafe Mocha'); 
INSERT INTO menu VALUES (5, '돌체라떼', 2, 2, 'images/KioskImages/menu/coffee/돌체라떼.png',4500, 'Dole Latte'); 
INSERT INTO menu VALUES (6, '바닐라 라떼', 2, 2, 'images/KioskImages/menu/coffee/바닐라라떼.png',5000, 'Vanilla Latte'); 
INSERT INTO menu VALUES (7, '카라멜 마끼아또', 2, 2,'images/KioskImages/menu/coffee/카라멜마끼아또.png', 5000, 'Caramel Macchiato'); 
INSERT INTO menu VALUES (8, '헤이즐넛 라떼', 2, 2,'images/KioskImages/menu/coffee/헤이즐넛라떼.png', 5000, 'Hazelnut Latte'); 
INSERT INTO menu VALUES (9, '콜드브루', 2, 3, 'images/KioskImages/menu/coffee/콜드브루.png',5000, 'Cold Brew'); 
INSERT INTO menu VALUES (10, '콜드브루 라떼', 2, 4,'images/KioskImages/menu/coffee/콜드브루라떼.png',5500, 'Cold Brew Latte'); 
=======
INSERT INTO menu VALUES (1, '에스프레소','Espresso',2,1, 'images/KioskImages/menu/coffee/에스프레소.png',3000);
INSERT INTO menu VALUES (2, '아메리카노','Americano',2,1, 'images/KioskImages/menu/coffee/아메리카노.png',3500);
INSERT INTO menu VALUES (3, '카페라떼','Cafe Latte',2,2, 'images/KioskImages/menu/coffee/카페라떼.png',4500);
INSERT INTO menu VALUES (4, '카페모카','Cafe Mocha',2,2, 'images/KioskImages/menu/coffee/카페모카.png',4500);
INSERT INTO menu VALUES (5, '돌체라떼','Dole Latte',2,2, 'images/KioskImages/menu/coffee/돌체라떼.png',4500);
INSERT INTO menu VALUES (6, '바닐라 라떼','Vanilla Latte',2,2, 'images/KioskImages/menu/coffee/바닐라라떼.png',5000);
INSERT INTO menu VALUES (7, '카라멜 마끼아또','Caramel Macchiato',2,2,'images/KioskImages/menu/coffee/카라멜마끼아또.png',5000);
INSERT INTO menu VALUES (8, '헤이즐넛 라떼','Hazelnut Latte',2,2,'images/KioskImages/menu/coffee/헤이즐넛라떼.png',5000);
INSERT INTO menu VALUES (9, '콜드브루','Cold Brew',2,3, 'images/KioskImages/menu/coffee/콜드브루.png',5000);
INSERT INTO menu VALUES (10, '콜드브루 라떼','Cold Brew Latte',2,4,'images/KioskImages/menu/coffee/콜드브루라떼.png',5500);
>>>>>>> refs/remotes/origin/jsj

<<<<<<< HEAD
INSERT INTO menu VALUES (11, '그린티 프라페', 3, 5, 'images/KioskImages/menu/frappe/그린티프라페.png',6000,'Green tea Frappe'); 
INSERT INTO menu VALUES (12, '딸기 젤라또 프라페', 3, 5,'images/KioskImages/menu/frappe/딸기젤라또프라페.png', 6500, 'Strawberry Gelato Frappe'); 
INSERT INTO menu VALUES (13, '레드 애플 프라페', 3, 5,'images/KioskImages/menu/frappe/레드애플프라페.png', 6500, 'Red Apple Frappe'); 
INSERT INTO menu VALUES (14, '애플 망고 프라페', 3, 5,'images/KioskImages/menu/frappe/애플망고프라페.png', 6500, 'Apple Mango Frappe'); 
INSERT INTO menu VALUES (15, '초코칩 프라페', 3, 5, 'images/KioskImages/menu/frappe/초코칩프라페.png',6500,'Chocolate Frappe'); 
INSERT INTO menu VALUES (16, '초콜릿 쿠키 젤라또 프라페', 3, 5, 'images/KioskImages/menu/frappe/초콜릿쿠키젤라또프라페.png',6700, 'Chocolate Cookie Gelato Frappe'); 
INSERT INTO menu VALUES (17, '콜드브루 모카 프라페', 3, 6,'images/KioskImages/menu/frappe/콜드브루모카프라페.png', 7000, 'Cold Brew Mocha Frappe'); 
INSERT INTO menu VALUES (18, '콜드브루 카라멜 프라페', 3, 6,'images/KioskImages/menu/frappe/콜드브루카라멜프라페.png', 7300, 'Cold Brew Caramel Frappe'); 
INSERT INTO menu VALUES (19, '콜드브루 프라페', 3, 6,'images/KioskImages/menu/frappe/콜드브루프라페.png',7500, 'Cold Brew Frappe'); 
=======
INSERT INTO menu VALUES (11, '그린티 프라페','Green tea Frappe',3,5, 'images/KioskImages/menu/frappe/그린티프라페.png',6000);
INSERT INTO menu VALUES (12, '딸기 젤라또 프라페','Strawberry Gelato Frappe',3,5,'images/KioskImages/menu/frappe/딸기젤라또프라페.png',6500);
INSERT INTO menu VALUES (13, '레드 애플 프라페','Red Apple Frappe',3,5,'images/KioskImages/menu/frappe/레드애플프라페.png',6500);
INSERT INTO menu VALUES (14, '애플 망고 프라페','Apple Mango Frappe',3,5,'images/KioskImages/menu/frappe/애플망고프라페.png',6500);
INSERT INTO menu VALUES (15, '초코칩 프라페','Chocolate Frappe',3,5, 'images/KioskImages/menu/frappe/초코칩프라페.png',6500);
INSERT INTO menu VALUES (16, '초콜릿 쿠키 젤라또 프라페','Chocolate Cookie Gelato Frappe',3,5, 'images/KioskImages/menu/frappe/초콜릿쿠키젤라또프라페.png',6700);
INSERT INTO menu VALUES (17, '콜드브루 모카 프라페','Cold Brew Mocha Frappe',3,6,'images/KioskImages/menu/frappe/콜드브루모카프라페.png',7000);
INSERT INTO menu VALUES (18, '콜드브루 카라멜 프라페','Cold Brew Caramel Frappe',3,6,'images/KioskImages/menu/frappe/콜드브루카라멜프라페.png',7300);
INSERT INTO menu VALUES (19, '콜드브루 프라페','Cold Brew Frappe',3,6,'images/KioskImages/menu/frappe/콜드브루프라페.png',7500);
>>>>>>> refs/remotes/origin/jsj

<<<<<<< HEAD
INSERT INTO menu VALUES (20, '고구마 라떼', 4, 7,'images/KioskImages/menu/noncoffee/고구마라떼.png', 4300, 'Sweet Potato Latte'); 
INSERT INTO menu VALUES (21, '녹차 라떼', 4, 7,'images/KioskImages/menu/noncoffee/녹차라떼.png', 4500, 'Green Tea Latte'); 
INSERT INTO menu VALUES (22, '오곡 라떼', 4, 7,'images/KioskImages/menu/noncoffee/오곡라떼.png', 4500, 'Five Grain Latte'); 
INSERT INTO menu VALUES (23, '초코 라떼', 4, 7,'images/KioskImages/menu/noncoffee/초코라떼.png', 4500, 'Chocolate Latte'); 
INSERT INTO menu VALUES (24, '피스타치오 라떼', 4, 7,'images/KioskImages/menu/noncoffee/피스타치오라떼.png', 4500, 'Pistachio Latte'); 
=======
INSERT INTO menu VALUES (20, '고구마 라떼','Sweet Potato Latte',4,7,'images/KioskImages/menu/noncoffee/고구마라떼.png',4300);
INSERT INTO menu VALUES (21, '녹차 라떼','Green Tea Latte',4,7,'images/KioskImages/menu/noncoffee/녹차라떼.png',4500);
INSERT INTO menu VALUES (22, '오곡 라떼','Five Grain Latte',4,7,'images/KioskImages/menu/noncoffee/오곡라떼.png',4500);
INSERT INTO menu VALUES (23, '초코 라떼','Chocolate Latte',4,7,'images/KioskImages/menu/noncoffee/초코라떼.png',4500);
INSERT INTO menu VALUES (24, '피스타치오 라떼','Pistachio Latte',4,7,'images/KioskImages/menu/noncoffee/피스타치오라떼.png',4500);
>>>>>>> refs/remotes/origin/jsj

<<<<<<< HEAD
INSERT INTO menu VALUES (25, '레몬 에이드', 5, 8,'images/KioskImages/menu/ade/레몬에이드.png', 5000,' Lemon Ade'); 
INSERT INTO menu VALUES (26, '자몽 에이드', 5, 8,'images/KioskImages/menu/ade/자몽에이드.png', 5000, 'Grapefruit Ade'); 
INSERT INTO menu VALUES (27, '청포도 에이드', 5, 8,'images/KioskImages/menu/ade/청포도에이드.png', 5000, 'Green Grape Ade'); 
SELECT * FROM user_tables;
SELECT * FROM user_constraints;
=======
INSERT INTO menu VALUES (25, '레몬 에이드','Lemon Ade',5,8,'images/KioskImages/menu/ade/레몬에이드.png',5000);
INSERT INTO menu VALUES (26, '자몽 에이드','Grapefruit Ade',5,8,'images/KioskImages/menu/ade/자몽에이드.png',5000);
INSERT INTO menu VALUES (27, '청포도 에이드','Green Grape Ade',5,8,'images/KioskImages/menu/ade/청포도에이드.png',5000);
 

>>>>>>> refs/remotes/origin/jsj

