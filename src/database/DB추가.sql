
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
INSERT INTO menu VALUES (1, '에스프레소', 2, 1, 3000); 
INSERT INTO menu VALUES (2, '아메리카노', 2, 1, 3500); 
INSERT INTO menu VALUES (3, '카페라떼', 2, 2, 4500); 
INSERT INTO menu VALUES (4, '카페모카', 2, 2, 4500); 
INSERT INTO menu VALUES (5, '돌체라떼', 2, 2, 4500); 
INSERT INTO menu VALUES (6, '바닐라라떼', 2, 2, 5000); 
INSERT INTO menu VALUES (7, '카라멜마끼아또', 2, 2, 5000); 
INSERT INTO menu VALUES (8, '헤이즐넛라떼', 2, 2, 5000); 
INSERT INTO menu VALUES (9, '콜드브루', 2, 3, 5000); 
INSERT INTO menu VALUES (10, '콜드브루라떼', 2, 4, 5500); 

INSERT INTO menu VALUES (11, '그린티프라페', 3, 5, 6000); 
INSERT INTO menu VALUES (12, '딸기젤라또프라페', 3, 5, 6500); 
INSERT INTO menu VALUES (13, '레드애플프라페', 3, 5, 6500); 
INSERT INTO menu VALUES (14, '애플망고프라페', 3, 5, 6500); 
INSERT INTO menu VALUES (15, '초코칩프라페', 3, 5, 6500); 
INSERT INTO menu VALUES (16, '초콜릿쿠키젤라또프라페', 3, 5, 6700); 
INSERT INTO menu VALUES (17, '콜드브루모카프라페', 3, 6, 7000); 
INSERT INTO menu VALUES (18, '콜드브루카라멜프라페', 3, 6, 7300); 
INSERT INTO menu VALUES (19, '콜드브루프라페', 3, 6, 7500); 

INSERT INTO menu VALUES (20, '고구마라떼', 4, 7, 4300); 
INSERT INTO menu VALUES (21, '녹차라떼', 4, 7, 4500); 
INSERT INTO menu VALUES (22, '오곡라떼', 4, 7, 4500); 
INSERT INTO menu VALUES (23, '초코라떼', 4, 7, 4500); 
INSERT INTO menu VALUES (24, '피스타치오라떼', 4, 7, 4500); 

INSERT INTO menu VALUES (25, '레몬에이드', 5, 8, 5000); 
INSERT INTO menu VALUES (26, '자몽에이드', 5, 8, 5000); 
INSERT INTO menu VALUES (27, '청포도에이드', 5, 8, 5000); 


