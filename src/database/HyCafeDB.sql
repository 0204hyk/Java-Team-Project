<<<<<<< HEAD
--ī�װ�
CREATE TABLE category (
   category_number   number(2)
    CONSTRAINT category_number_pk PRIMARY KEY,
   category_name   VARCHAR(40)
);

--���̺�� option�� ���Ұ� / �ɼ� �߰�����
CREATE TABLE extra_option (
   option_number number(2)
   CONSTRAINT option_number_pk PRIMARY KEY,
   option_name VARCHAR2(20),
   option_price number(4)
);

-- �޴� 
CREATE TABLE menu(
    menu_number	number(4)
    CONSTRAINT menu_number_pk PRIMARY KEY,
    menu_name VARCHAR(40),
    category_number number(2) 
    CONSTRAINT menu_category_fk REFERENCES category(category_number),
    option_category_number number(1),--���̺� �ɼ� ī�װ� / 8��
    price number(5)
);

--���������� (id 1�������)
CREATE TABLE manager(
    manager_id VARCHAR2(16),
    manager_password VARCHAR2(255)
);

--ȸ������
CREATE TABLE membership(
    member_phonenumber varchar2(20) 
    CONSTRAINT member_phonenumber_pk PRIMARY KEY,
    member_point number(5),
    member_join date
);

--�Ǹ�����
CREATE TABLE sales (
   sales_number   number(20) 
   CONSTRAINT sales_number_pk PRIMARY KEY,
   member_phonenumber varchar2(20) 
   CONSTRAINT member_phonenumber_fk references membership (member_phonenumber),
   saleDate   DATE
);

--��������ȸ (sales jointable)
CREATE TABLE sales_management (
    sales_number   number(20)
    CONSTRAINT sales_number_fk references sales (sales_number),
    menu_number	number(4)
    CONSTRAINT menu_number_fk references menu (menu_number),
    option_number number(4)
    CONSTRAINT option_number_fk references extra_option (option_number),
   product_qty   number(3),
    total_price number(10)
);

-- ������� ��ȸ
CREATE TABLE payment(
    sales_number   number(20)
    CONSTRAINT payment_number_fk references sales (sales_number),
    payment_type number(1),
    price number(10)
);
=======
ALTER SESSION SET nls_date_format = 'YYYY-MM-DD HH24:MI:SS';

--ī�װ�
CREATE TABLE category (
   category_number   number(2)
    CONSTRAINT category_number_pk PRIMARY KEY,
   category_name   VARCHAR(40)
);

--���̺�� option�� ���Ұ� / �ɼ� �߰�����
CREATE TABLE extra_option (
   option_number number(2)
   CONSTRAINT option_number_pk PRIMARY KEY,
   option_name VARCHAR2(20),
   option_price number(4)
);

-- �޴� 
CREATE TABLE menu(
    menu_number	number(4)
    CONSTRAINT menu_number_pk PRIMARY KEY,
    menu_name VARCHAR(40),
    category_number number(2) 
    CONSTRAINT menu_category_fk REFERENCES category(category_number),
    option_category_number number(1),--���̺� �ɼ� ī�װ� / 8��
    price number(5)
);

ALTER TABLE menu MODIFY (
    menu_name VARCHAR(40)
    CONSTRAINT menu_name_uk UNIQUE
    CONSTRAINT menu_name_nn NOT NULL
);

--���������� (id 1�������)
CREATE TABLE manager(
    manager_id VARCHAR2(16),
    manager_password VARCHAR2(255)
);

--ȸ������
CREATE TABLE membership(
    member_phonenumber varchar2(20) 
    CONSTRAINT member_phonenumber_pk PRIMARY KEY,
    member_point number(5),
    member_join date
);

--�Ǹ�����
CREATE TABLE sales (
   sales_number   number(20) 
   CONSTRAINT sales_number_pk PRIMARY KEY,
   member_phonenumber varchar2(20) 
   CONSTRAINT member_phonenumber_fk references membership (member_phonenumber),
   saleDate   DATE
);

--��������ȸ (sales jointable)
CREATE TABLE sales_management (
    sales_number   number(20)
    CONSTRAINT sales_number_fk references sales (sales_number),
    menu_number	number(4)
    CONSTRAINT menu_number_fk references menu (menu_number),
    option_number number(4)
    CONSTRAINT option_number_fk references extra_option (option_number),
   product_qty   number(3),
    total_price number(10)
);

-- ������� ��ȸ
CREATE TABLE payment(
    sales_number   number(20)
    CONSTRAINT payment_number_fk references sales (sales_number),
    payment_type number(1),
    price number(10)
);

select * from tabs;
>>>>>>> refs/remotes/origin/main
