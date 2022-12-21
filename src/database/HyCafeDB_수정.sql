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
    member_phonenumber NUMBER(20) 
    CONSTRAINT member_phonenumber_pk PRIMARY KEY,
    member_point NUMBER(6),
    member_join DATE
);

-- 판매 테이블
CREATE TABLE sales (
    sales_number   VARCHAR2(20) 
    CONSTRAINT sales_number_fk REFERENCES sales_management (sales_number),
    menu_number	NUMBER(4)
    CONSTRAINT menu_number_fk REFERENCES menu (menu_number),
    /*
        메뉴 옵션 : 핫/아이스 / 디카페인 / 컵종류 / 컵사이즈 / 샷 추가 / 얼음 양 / 우유  
        해당사항 없을 경우 0 그 외에는 1,2,3 등으로 표현
    */
    menu_options NUMBER(7), -- 7자리 숫자로 옵션 선택 여부 설정 ex > 0122001 (선택 옵션에따른 가격 변화는 자바에서 처리)
    menu_qty NUMBER(2),
    price NUMBER(6)
);

--판매 관리
CREATE TABLE sales_management (
    sales_number   VARCHAR2(20) -- 20221221-01-163515
    CONSTRAINT sales_number_pk PRIMARY KEY,
    member_phonenumber NUMBER(20)
    CONSTRAINT member_number_fk REFERENCES membership (member_phonenumber),
    saledate   DATE,
    payment_type NUMBER(1), -- 1 - 카드 / 2 - 포인트 / 3 - 혼합
    used_point NUMBER(6),  -- 포인트 사용 액수
    card_number VARCHAR2(14) -- 0000-0000-0000
);

-- date 타입 시간까지 나오게끔 포맷 변경
ALTER SESSION SET nls_date_format = 'YYYY-MM-DD HH24:MI:SS';
