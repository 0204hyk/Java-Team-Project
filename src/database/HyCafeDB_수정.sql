--카테고리 (인기메뉴, 커피, 논커피, 에이드, 프라페)
CREATE TABLE category (
   category_number   NUMBER(2)
    CONSTRAINT category_number_pk PRIMARY KEY,
   category_name   VARCHAR(40)
);

-- 메뉴 
CREATE TABLE menu(
    menu_number	NUMBER(4)
    CONSTRAINT menu_number_pk PRIMARY KEY,
    menu_name VARCHAR2(40),
    category_number NUMBER(2) 
    CONSTRAINT menu_category_fk REFERENCES category(category_number),
    option_category_number NUMBER(1),--테이블별 옵션 카테고리 (1~8) / 키오스크에서 8개 옵션 패널 중 1개 선택하기 위한 값
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

-- 영수증 조회 
CREATE TABLE sales (
   sales_number   NUMBER(20) 
   CONSTRAINT sales_number_fk REFERENCES sales_management (sales_number),
   member_phonenumber VARCHAR2(20) 
   CONSTRAINT member_phonenumber_fk REFERENCES membership (member_phonenumber),
   saledate   DATE
);

--판매 관리
CREATE TABLE sales_management (
    sales_number   NUMBER(20)
    CONSTRAINT sales_number_pk PRIMARY KEY,
    menu_number	NUMBER(4)
    CONSTRAINT menu_number_fk REFERENCES menu (menu_number),
    option_number NUMBER(7), -- 7자리 숫자로 옵션 선택 여부 설정 ex > 0122001 (선택 옵션에따른 가격 변화는 자바에서 처리)
    product_qty   NUMBER(3),
    total_price NUMBER(10)
);

-- 결제방식 조회 -- 얘도 sales에 합쳐도 될듯?
CREATE TABLE payment(
    sales_number   NUMBER(20)
    CONSTRAINT payment_number_fk REFERENCES sales (sales_number),
    payment_type NUMBER(1),
    price NUMBER(10)
);

-- date 타입 시간까지 나오게끔 포맷 변경
ALTER SESSION SET nls_date_format = 'YYYY-MM-DD HH24:MI:SS';
