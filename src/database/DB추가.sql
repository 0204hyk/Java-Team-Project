
--ī�װ�  1~5�� Ŀ�� ī�װ� / 6�����ʹ� �ɼ� ī�װ�
INSERT INTO category VALUES (1, '�α�޴�');
INSERT INTO category VALUES (2, 'Ŀ��');
INSERT INTO category VALUES (3, '��Ŀ��');
INSERT INTO category VALUES (4, '���̵�');
INSERT INTO category VALUES (5, '������');

--�߰��ɼ�
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

--�޴�
INSERT INTO menu VALUES (1, '����������','Espresso',2,1, 'images/KioskImages/menu/coffee/����������.png',3000);
INSERT INTO menu VALUES (2, '�Ƹ޸�ī��','Americano',2,1, 'images/KioskImages/menu/coffee/�Ƹ޸�ī��.png',3500);
INSERT INTO menu VALUES (3, 'ī���','Cafe Latte',2,2, 'images/KioskImages/menu/coffee/ī���.png',4500);
INSERT INTO menu VALUES (4, 'ī���ī','Cafe Mocha',2,2, 'images/KioskImages/menu/coffee/ī���ī.png',4500);
INSERT INTO menu VALUES (5, '��ü��','Dole Latte',2,2, 'images/KioskImages/menu/coffee/��ü��.png',4500);
INSERT INTO menu VALUES (6, '�ٴҶ� ��','Vanilla Latte',2,2, 'images/KioskImages/menu/coffee/�ٴҶ��.png',5000);
INSERT INTO menu VALUES (7, 'ī��� �����ƶ�','Caramel Macchiato',2,2,'images/KioskImages/menu/coffee/ī��Ḷ���ƶ�.png',5000);
INSERT INTO menu VALUES (8, '������� ��','Hazelnut Latte',2,2,'images/KioskImages/menu/coffee/������Ӷ�.png',5000);
INSERT INTO menu VALUES (9, '�ݵ���','Cold Brew',2,3, 'images/KioskImages/menu/coffee/�ݵ���.png',5000);
INSERT INTO menu VALUES (10, '�ݵ��� ��','Cold Brew Latte',2,4,'images/KioskImages/menu/coffee/�ݵ����.png',5500);

INSERT INTO menu VALUES (11, '�׸�Ƽ ������','Green tea Frappe',3,5, 'images/KioskImages/menu/frappe/�׸�Ƽ������.png',6000);
INSERT INTO menu VALUES (12, '���� ����� ������','Strawberry Gelato Frappe',3,5,'images/KioskImages/menu/frappe/���������������.png',6500);
INSERT INTO menu VALUES (13, '���� ���� ������','Red Apple Frappe',3,5,'images/KioskImages/menu/frappe/�������������.png',6500);
INSERT INTO menu VALUES (14, '���� ���� ������','Apple Mango Frappe',3,5,'images/KioskImages/menu/frappe/���ø���������.png',6500);
INSERT INTO menu VALUES (15, '����Ĩ ������','Chocolate Frappe',3,5, 'images/KioskImages/menu/frappe/����Ĩ������.png',6500);
INSERT INTO menu VALUES (16, '���ݸ� ��Ű ����� ������','Chocolate Cookie Gelato Frappe',3,5, 'images/KioskImages/menu/frappe/���ݸ���Ű�����������.png',6700);
INSERT INTO menu VALUES (17, '�ݵ��� ��ī ������','Cold Brew Mocha Frappe',3,6,'images/KioskImages/menu/frappe/�ݵ����ī������.png',7000);
INSERT INTO menu VALUES (18, '�ݵ��� ī��� ������','Cold Brew Caramel Frappe',3,6,'images/KioskImages/menu/frappe/�ݵ���ī���������.png',7300);
INSERT INTO menu VALUES (19, '�ݵ��� ������','Cold Brew Frappe',3,6,'images/KioskImages/menu/frappe/�ݵ���������.png',7500);

INSERT INTO menu VALUES (20, '���� ��','Sweet Potato Latte',4,7,'images/KioskImages/menu/noncoffee/������.png',4300);
INSERT INTO menu VALUES (21, '���� ��','Green Tea Latte',4,7,'images/KioskImages/menu/noncoffee/������.png',4500);
INSERT INTO menu VALUES (22, '���� ��','Five Grain Latte',4,7,'images/KioskImages/menu/noncoffee/�����.png',4500);
INSERT INTO menu VALUES (23, '���� ��','Chocolate Latte',4,7,'images/KioskImages/menu/noncoffee/���ڶ�.png',4500);
INSERT INTO menu VALUES (24, '�ǽ�Ÿġ�� ��','Pistachio Latte',4,7,'images/KioskImages/menu/noncoffee/�ǽ�Ÿġ����.png',4500);

INSERT INTO menu VALUES (25, '���� ���̵�','Lemon Ade',5,8,'images/KioskImages/menu/ade/�����̵�.png',5000);
INSERT INTO menu VALUES (26, '�ڸ� ���̵�','Grapefruit Ade',5,8,'images/KioskImages/menu/ade/�ڸ����̵�.png',5000);
INSERT INTO menu VALUES (27, 'û���� ���̵�','Green Grape Ade',5,8,'images/KioskImages/menu/ade/û�������̵�.png',5000);
 


COMMIT;