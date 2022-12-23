--카테고리  1~5번 커피 카테고리
INSERT INTO category VALUES (1, '신메뉴');
INSERT INTO category VALUES (2, '커피');  
INSERT INTO category VALUES (3, '프라페');
INSERT INTO category VALUES (4, '논커피');
INSERT INTO category VALUES (5, '에이드');
--메뉴
INSERT INTO menu VALUES (1, '에스프레소','Espresso',2,2, 'images/KioskImages/menu/coffee/에스프레소.png',3000);
INSERT INTO menu VALUES (2, '아메리카노','Americano',2,2, 'images/KioskImages/menu/coffee/아메리카노.png',3500);
INSERT INTO menu VALUES (3, '카페라떼','Cafe Latte',2,1, 'images/KioskImages/menu/coffee/카페라떼.png',4500);
INSERT INTO menu VALUES (4, '카페모카','Cafe Mocha',2,1, 'images/KioskImages/menu/coffee/카페모카.png',4500);
INSERT INTO menu VALUES (5, '돌체라떼','Dole Latte',2,1, 'images/KioskImages/menu/coffee/돌체라떼.png',4500);
INSERT INTO menu VALUES (6, '바닐라 라떼','Vanilla Latte',2,1, 'images/KioskImages/menu/coffee/바닐라라떼.png',5000);
INSERT INTO menu VALUES (7, '카라멜 마끼아또','Caramel Macchiato',2,1,'images/KioskImages/menu/coffee/카라멜마끼아또.png',5000);
INSERT INTO menu VALUES (8, '헤이즐넛 라떼','Hazelnut Latte',2,1,'images/KioskImages/menu/coffee/헤이즐넛라떼.png',5000);
INSERT INTO menu VALUES (9, '콜드브루','Cold Brew',2,3, 'images/KioskImages/menu/coffee/콜드브루.png',5000);
INSERT INTO menu VALUES (10, '콜드브루 라떼','Cold Brew Latte',2,4,'images/KioskImages/menu/coffee/콜드브루라떼.png',5500);

INSERT INTO menu VALUES (11, '그린티 프라페','Green tea Frappe',3,5, 'images/KioskImages/menu/frappe/그린티프라페.png',6000);
INSERT INTO menu VALUES (12, '딸기 젤라또 프라페','Strawberry Gelato Frappe',3,5,'images/KioskImages/menu/frappe/딸기젤라또프라페.png',6500);
INSERT INTO menu VALUES (13, '레드 애플 프라페','Red Apple Frappe',3,5,'images/KioskImages/menu/frappe/레드애플프라페.png',6500);
INSERT INTO menu VALUES (14, '애플 망고 프라페','Apple Mango Frappe',3,5,'images/KioskImages/menu/frappe/애플망고프라페.png',6500);
INSERT INTO menu VALUES (15, '초코칩 프라페','Chocolate Frappe',3,5, 'images/KioskImages/menu/frappe/초코칩프라페.png',6500);
INSERT INTO menu VALUES (16, '초콜릿 쿠키 젤라또 프라페','Chocolate Cookie Gelato Frappe',3,5, 'images/KioskImages/menu/frappe/초콜릿쿠키젤라또프라페.png',6700);
INSERT INTO menu VALUES (17, '콜드브루 모카 프라페','Cold Brew Mocha Frappe',3,6,'images/KioskImages/menu/frappe/콜드브루모카프라페.png',7000);
INSERT INTO menu VALUES (18, '콜드브루 카라멜 프라페','Cold Brew Caramel Frappe',3,6,'images/KioskImages/menu/frappe/콜드브루카라멜프라페.png',7300);
INSERT INTO menu VALUES (19, '콜드브루 프라페','Cold Brew Frappe',3,6,'images/KioskImages/menu/frappe/콜드브루프라페.png',7500);

INSERT INTO menu VALUES (20, '고구마 라떼','Sweet Potato Latte',4,7,'images/KioskImages/menu/noncoffee/고구마라떼.png',4300);
INSERT INTO menu VALUES (21, '녹차 라떼','Green Tea Latte',4,7,'images/KioskImages/menu/noncoffee/녹차라떼.png',4500);
INSERT INTO menu VALUES (22, '오곡 라떼','Five Grain Latte',4,7,'images/KioskImages/menu/noncoffee/오곡라떼.png',4500);
INSERT INTO menu VALUES (23, '초코 라떼','Chocolate Latte',4,7,'images/KioskImages/menu/noncoffee/초코라떼.png',4500);
INSERT INTO menu VALUES (24, '피스타치오 라떼','Pistachio Latte',4,7,'images/KioskImages/menu/noncoffee/피스타치오라떼.png',4500);

INSERT INTO menu VALUES (25, '레몬 에이드','Lemon Ade',5,8,'images/KioskImages/menu/ade/레몬에이드.png',5000);
INSERT INTO menu VALUES (26, '자몽 에이드','Grapefruit Ade',5,8,'images/KioskImages/menu/ade/자몽에이드.png',5000);
INSERT INTO menu VALUES (27, '청포도 에이드','Green Grape Ade',5,8,'images/KioskImages/menu/ade/청포도에이드.png',5000);

-- 임시 매니저 데이터
INSERT INTO manager VALUES ('hyCafe', 1234);

-- 임시 회원 데이터
INSERT INTO membership VALUES ('01067447970', 50000, '2022-12-22');

-- 임시 회원 판매 데이터
INSERT INTO sales_management VALUES ('20221222-01-165330',
'01067447970',
to_date('2022-12-22 16:53:30', 'YYYY-MM-DD HH24:MI:SS'),
3, 5000, '1234-1234-1234');
                                         -- 상품코드, 옵션, 갯수 , 가격
INSERT INTO sales VALUES ('20221222-01-165330', 2, 0000000, 1, 3500);
INSERT INTO sales VALUES ('20221222-01-165330', 3, 0000000, 2, 9000);

-- 임시 비회원 판매 데이터
INSERT INTO sales_management VALUES ('20221222-01-170015', null,
to_date('2022-12-22 17:00:15', 'YYYY-MM-DD HH24:MI:SS'),
1, 0, '2345-2345-2345');
                                        -- 상품코드, 옵션, 갯수 , 가격
INSERT INTO sales VALUES ('20221222-01-170015', 9, 0000000, 1, 5000);
INSERT INTO sales VALUES ('20221222-01-170015', 9, 0120000, 1, 5300);
INSERT INTO sales VALUES ('20221222-01-170015', 21, 0000000, 1, 4500);

select * from sales where sales_number = '20221222-01-165330';
select * from sales_management;

commit;

SELECT * FROM user_tables;
SELECT * FROM user_constraints;

SELECT
    to_char(saledate, 'HH24'),
    TRIM(to_char(SUM(price) - used_point,
                 '999,999,999'))
FROM
         sales_management
    INNER JOIN sales USING ( sales_number )
WHERE
        to_char(saledate, 'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD')
    AND to_char(saledate, 'HH24') = 16
GROUP BY
    to_char(saledate, 'HH24'), used_point
ORDER BY
    to_char(saledate, 'HH24');


SELECT
    TRIM(to_char(SUM(price) - used_point,
                 '999,999,999'))
FROM
         sales_management
    INNER JOIN sales USING ( sales_number )
WHERE
        to_char(saledate, 'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD')
    AND to_char(saledate, 'HH24') BETWEEN 10 AND 21
GROUP BY
    used_point;
	