--카테고리
CREATE TABLE category (
   category_number   NUMBER(2)
    CONSTRAINT category_number_pk PRIMARY KEY,
   category_name   VARCHAR(40)
);

--테이블명 option은 사용불가 / 옵션 추가정보
CREATE TABLE extra_option (
   option_number NUMBER(2)
   CONSTRAINT option_number_pk PRIMARY KEY,
   hotandice VARCHAR2(20),
   decaffein VARCHAR2(20),
   cup VARCHAR2(2),
   cup_sizes VARCHAR2(20),
   shot VARCHAR2(20),
   ice VARCHAR2(20),
   milk VARCHAR2(20),  
   option_price NUMBER(4)
);

-- 메뉴 
CREATE TABLE menu(
    menu_number	NUMBER(4)
    CONSTRAINT menu_number_pk PRIMARY KEY,
    menu_name VARCHAR2(40),
    category_number NUMBER(2) 
    CONSTRAINT menu_category_fk REFERENCES category(category_number),
    option_category_number NUMBER(1),--테이블별 옵션 카테고리 / 8개
    menu_image VARCHAR2(255),
    price NUMBER(5),
    menu_eng_name VARCHAR2(40)
);

--관리자정보 (id 1개만사용)
CREATE TABLE manager(
    manager_id VARCHAR2(16),
    manager_password VARCHAR2(255)
);

--회원정보
CREATE TABLE membership(
    member_phonenumber VARCHAR2(20) 
    CONSTRAINT member_phonenumber_pk PRIMARY KEY,
    member_point NUMBER(5),
    member_join DATE
);

--판매정보
CREATE TABLE sales (
   sales_number   NUMBER(20) 
   CONSTRAINT sales_number_pk PRIMARY KEY,
   member_phonenumber VARCHAR2(20) 
   CONSTRAINT member_phonenumber_fk REFERENCES membership (member_phonenumber),
   saledate   DATE
);

--영수증조회 (sales jointable)
CREATE TABLE sales_management (
    sales_number   NUMBER(20)
    CONSTRAINT sales_number_fk REFERENCES sales (sales_number),
    menu_number	NUMBER(4)
    CONSTRAINT menu_number_fk REFERENCES menu (menu_number),
    option_number NUMBER(4)
    CONSTRAINT option_number_fk REFERENCES extra_option (option_number),
   product_qty   NUMBER(3),
    total_price NUMBER(10)
);

-- 결제방식 조회
CREATE TABLE payment(
    sales_number   NUMBER(20)
    CONSTRAINT payment_number_fk REFERENCES sales (sales_number),
    payment_type NUMBER(1),
    price NUMBER(10)
);

-- date 타입 시간까지 나오게끔 포맷 변경
ALTER SESSION SET nls_date_format = 'YYYY-MM-DD HH24:MI:SS';
