--ī�װ�  1~5�� Ŀ�� ī�װ�
INSERT INTO category VALUES (1, '�Ÿ޴�');
INSERT INTO category VALUES (2, 'Ŀ��');  
INSERT INTO category VALUES (3, '������');
INSERT INTO category VALUES (4, '��Ŀ��');
INSERT INTO category VALUES (5, '���̵�');
--�޴�
INSERT INTO menu VALUES (1, '����������','Espresso',2,2, 'images/KioskImages/menu/coffee/����������.png',3000);
INSERT INTO menu VALUES (2, '�Ƹ޸�ī��','Americano',2,2, 'images/KioskImages/menu/coffee/�Ƹ޸�ī��.png',3500);
INSERT INTO menu VALUES (3, 'ī���','Cafe Latte',2,1, 'images/KioskImages/menu/coffee/ī���.png',4500);
INSERT INTO menu VALUES (4, 'ī���ī','Cafe Mocha',2,1, 'images/KioskImages/menu/coffee/ī���ī.png',4500);
INSERT INTO menu VALUES (5, '��ü��','Dole Latte',2,1, 'images/KioskImages/menu/coffee/��ü��.png',4500);
INSERT INTO menu VALUES (6, '�ٴҶ� ��','Vanilla Latte',2,1, 'images/KioskImages/menu/coffee/�ٴҶ��.png',5000);
INSERT INTO menu VALUES (7, 'ī��� �����ƶ�','Caramel Macchiato',2,1,'images/KioskImages/menu/coffee/ī��Ḷ���ƶ�.png',5000);
INSERT INTO menu VALUES (8, '������� ��','Hazelnut Latte',2,1,'images/KioskImages/menu/coffee/������Ӷ�.png',5000);
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

-- �ӽ� �Ŵ��� ������
INSERT INTO manager VALUES ('hyCafe', 1234);

-- �ӽ� ȸ�� ������
INSERT INTO membership VALUES ('01067447970', 50000, '2022-12-22');

-- �ӽ� ȸ�� �Ǹ� ������
INSERT INTO sales_management VALUES ('20221222-01-165330',
'01067447970',
to_date('2022-12-22 16:53:30', 'YYYY-MM-DD HH24:MI:SS'),
3, 5000, '1234-1234-1234');
                                         -- ��ǰ�ڵ�, �ɼ�, ���� , ����
INSERT INTO sales VALUES ('20221222-01-165330', 2, 0000000, 1, 3500);
INSERT INTO sales VALUES ('20221222-01-165330', 3, 0000000, 2, 9000);

-- �ӽ� ��ȸ�� �Ǹ� ������
INSERT INTO sales_management VALUES ('20221222-01-170015', null,
to_date('2022-12-22 17:00:15', 'YYYY-MM-DD HH24:MI:SS'),
1, 0, '2345-2345-2345');
                                        -- ��ǰ�ڵ�, �ɼ�, ���� , ����
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
	