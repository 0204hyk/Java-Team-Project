
--ī�װ�  1~5�� Ŀ�� ī�װ� / 6�����ʹ� �ɼ� ī�װ�
INSERT INTO category VALUES (1, '�Ÿ޴�');
INSERT INTO category VALUES (2, 'Ŀ��');
INSERT INTO category VALUES (3, '��Ŀ��');
INSERT INTO category VALUES (4, '���̵�');
INSERT INTO category VALUES (5, '������');

--�޴�
INSERT INTO menu VALUES (1, '����������', 2, 1, 'images/KioskImages/menu/coffee/����������.png', 3000, 'Espresso'); 
INSERT INTO menu VALUES (2, '�Ƹ޸�ī��', 2, 1, 'images/KioskImages/menu/coffee/�Ƹ޸�ī��.png',3500, 'Americano'); 
INSERT INTO menu VALUES (3, 'ī���', 2, 2, 'images/KioskImages/menu/coffee/ī���.png',4500, 'Cafe Latte'); 
INSERT INTO menu VALUES (4, 'ī���ī', 2, 2, 'images/KioskImages/menu/coffee/ī���ī.png',4500, 'Cafe Mocha'); 
INSERT INTO menu VALUES (5, '��ü��', 2, 2, 'images/KioskImages/menu/coffee/��ü��.png',4500, 'Dole Latte'); 
INSERT INTO menu VALUES (6, '�ٴҶ� ��', 2, 2, 'images/KioskImages/menu/coffee/�ٴҶ��.png',5000, 'Vanilla Latte'); 
INSERT INTO menu VALUES (7, 'ī��� �����ƶ�', 2, 2,'images/KioskImages/menu/coffee/ī��Ḷ���ƶ�.png', 5000, 'Caramel Macchiato'); 
INSERT INTO menu VALUES (8, '������� ��', 2, 2,'images/KioskImages/menu/coffee/������Ӷ�.png', 5000, 'Hazelnut Latte'); 
INSERT INTO menu VALUES (9, '�ݵ���', 2, 3, 'images/KioskImages/menu/coffee/�ݵ���.png',5000, 'Cold Brew'); 
INSERT INTO menu VALUES (10, '�ݵ��� ��', 2, 4,'images/KioskImages/menu/coffee/�ݵ����.png',5500, 'Cold Brew Latte'); 

INSERT INTO menu VALUES (11, '�׸�Ƽ ������', 3, 5, 'images/KioskImages/menu/frappe/�׸�Ƽ������.png',6000,'Green tea Frappe'); 
INSERT INTO menu VALUES (12, '���� ����� ������', 3, 5,'images/KioskImages/menu/frappe/���������������.png', 6500, 'Strawberry Gelato Frappe'); 
INSERT INTO menu VALUES (13, '���� ���� ������', 3, 5,'images/KioskImages/menu/frappe/�������������.png', 6500, 'Red Apple Frappe'); 
INSERT INTO menu VALUES (14, '���� ���� ������', 3, 5,'images/KioskImages/menu/frappe/���ø���������.png', 6500, 'Apple Mango Frappe'); 
INSERT INTO menu VALUES (15, '����Ĩ ������', 3, 5, 'images/KioskImages/menu/frappe/����Ĩ������.png',6500,'Chocolate Frappe'); 
INSERT INTO menu VALUES (16, '���ݸ� ��Ű ����� ������', 3, 5, 'images/KioskImages/menu/frappe/���ݸ���Ű�����������.png',6700, 'Chocolate Cookie Gelato Frappe'); 
INSERT INTO menu VALUES (17, '�ݵ��� ��ī ������', 3, 6,'images/KioskImages/menu/frappe/�ݵ����ī������.png', 7000, 'Cold Brew Mocha Frappe'); 
INSERT INTO menu VALUES (18, '�ݵ��� ī��� ������', 3, 6,'images/KioskImages/menu/frappe/�ݵ���ī���������.png', 7300, 'Cold Brew Caramel Frappe'); 
INSERT INTO menu VALUES (19, '�ݵ��� ������', 3, 6,'images/KioskImages/menu/frappe/�ݵ���������.png',7500, 'Cold Brew Frappe'); 

INSERT INTO menu VALUES (20, '���� ��', 4, 7,'images/KioskImages/menu/noncoffee/������.png', 4300, 'Sweet Potato Latte'); 
INSERT INTO menu VALUES (21, '���� ��', 4, 7,'images/KioskImages/menu/noncoffee/������.png', 4500, 'Green Tea Latte'); 
INSERT INTO menu VALUES (22, '���� ��', 4, 7,'images/KioskImages/menu/noncoffee/�����.png', 4500, 'Five Grain Latte'); 
INSERT INTO menu VALUES (23, '���� ��', 4, 7,'images/KioskImages/menu/noncoffee/���ڶ�.png', 4500, 'Chocolate Latte'); 
INSERT INTO menu VALUES (24, '�ǽ�Ÿġ�� ��', 4, 7,'images/KioskImages/menu/noncoffee/�ǽ�Ÿġ����.png', 4500, 'Pistachio Latte'); 

INSERT INTO menu VALUES (25, '���� ���̵�', 5, 8,'images/KioskImages/menu/ade/�����̵�.png', 5000,' Lemon Ade'); 
INSERT INTO menu VALUES (26, '�ڸ� ���̵�', 5, 8,'images/KioskImages/menu/ade/�ڸ����̵�.png', 5000, 'Grapefruit Ade'); 
INSERT INTO menu VALUES (27, 'û���� ���̵�', 5, 8,'images/KioskImages/menu/ade/û�������̵�.png', 5000, 'Green Grape Ade'); 

-- �ӽ� �Ŵ��� ������
INSERT INTO manager VALUES ('hyCafe', 1234);

-- �ӽ� ȸ�� ������
INSERT INTO membership VALUES ('01067447970', 50000, '2022-12-21');

-- �ӽ� ȸ�� �Ǹ� ������
INSERT INTO sales_management VALUES ('20221221-01-165330',
'01067447970',
to_date('2022-12-21 16:53:30', 'YYYY-MM-DD HH24:MI:SS'),
3, 5000, '1234-1234-1234');
                                         -- ��ǰ�ڵ�, �ɼ�, ���� , ����
INSERT INTO sales VALUES ('20221221-01-165330', 2, 0000000, 1, 3500);
INSERT INTO sales VALUES ('20221221-01-165330', 3, 0000000, 2, 9000);

-- �ӽ� ��ȸ�� �Ǹ� ������
INSERT INTO sales_management VALUES ('20221221-01-170015', null,
to_date('2022-12-21 17:00:15', 'YYYY-MM-DD HH24:MI:SS'),
1, 0, '2345-2345-2345');
                                        -- ��ǰ�ڵ�, �ɼ�, ���� , ����
INSERT INTO sales VALUES ('20221221-01-170015', 9, 0000000, 1, 5000);
INSERT INTO sales VALUES ('20221221-01-170015', 9, 0120000, 1, 5300);
INSERT INTO sales VALUES ('20221221-01-170015', 21, 0000000, 1, 4500);


select * from sales where sales_number = '20221221-01-165330';
select * from sales_management;

SELECT * FROM user_tables;
SELECT * FROM user_constraints;

