--ī�װ� (�α�޴�, Ŀ��, ��Ŀ��, ���̵�, ������)
CREATE TABLE category (
   category_number   NUMBER(2)
    CONSTRAINT category_number_pk PRIMARY KEY,
   category_name   VARCHAR(40)
);

-- �޴� 
CREATE TABLE menu(
    menu_number	NUMBER(4)
    CONSTRAINT menu_number_pk PRIMARY KEY,
    menu_name VARCHAR2(40),
    category_number NUMBER(2) 
    CONSTRAINT menu_category_fk REFERENCES category(category_number),
    option_category_number NUMBER(1),--���̺� �ɼ� ī�װ� (1~8) / Ű����ũ���� 8�� �ɼ� �г� �� 1�� �����ϱ� ���� ��
    menu_image VARCHAR2(255),
    price NUMBER(5),
    menu_eng_name VARCHAR2(40)
);

--���������� (id 1�������)
CREATE TABLE manager(
    manager_id VARCHAR2(16),
    manager_password VARCHAR2(255)
);

--ȸ������
CREATE TABLE membership(
    member_phonenumber VARCHAR2(20) 
    CONSTRAINT member_phonenumber_pk PRIMARY KEY,
    member_point NUMBER(5),
    member_join DATE
);

-- ������ ��ȸ 
CREATE TABLE sales (
   sales_number   NUMBER(20) 
   CONSTRAINT sales_number_fk REFERENCES sales_management (sales_number),
   member_phonenumber VARCHAR2(20) 
   CONSTRAINT member_phonenumber_fk REFERENCES membership (member_phonenumber),
   saledate   DATE
);

--�Ǹ� ����
CREATE TABLE sales_management (
    sales_number   NUMBER(20)
    CONSTRAINT sales_number_pk PRIMARY KEY,
    menu_number	NUMBER(4)
    CONSTRAINT menu_number_fk REFERENCES menu (menu_number),
    option_number NUMBER(7), -- 7�ڸ� ���ڷ� �ɼ� ���� ���� ���� ex > 0122001 (���� �ɼǿ����� ���� ��ȭ�� �ڹٿ��� ó��)
    product_qty   NUMBER(3),
    total_price NUMBER(10)
);

-- ������� ��ȸ -- �굵 sales�� ���ĵ� �ɵ�?
CREATE TABLE payment(
    sales_number   NUMBER(20)
    CONSTRAINT payment_number_fk REFERENCES sales (sales_number),
    payment_type NUMBER(1),
    price NUMBER(10)
);

-- date Ÿ�� �ð����� �����Բ� ���� ����
ALTER SESSION SET nls_date_format = 'YYYY-MM-DD HH24:MI:SS';
