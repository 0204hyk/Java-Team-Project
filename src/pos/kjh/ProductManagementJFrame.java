package pos.kjh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProductManagementJFrame extends JFrame {

	TopPanel tp = new TopPanel();
	JButton btn = new JButton();

	public ProductManagementJFrame() throws IOException {
		
		add(labelImage("PosImages/상품 관리 이미지/검색바.png", 200, 100, 700, 51));
		add(labelImage("PosImages/상품 관리 이미지/메뉴 리스트 기본 틀.png", 48, 190, 1100, 400));
		serch();
		buttons();
	}
	
	public JTextField serch() {
		JTextField serch = new JTextField();

		serch.setBounds(215, 100, 700, 49);
		serch.setOpaque(false);
		serch.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		add(serch);
		
		add(labelImage("images/PosImages/상품 관리 이미지/검색바.png", 200, 100, 700, 51));
		add(labelImage("images/PosImages/상품 관리 이미지/메뉴 리스트 기본 틀.png", 48, 190, 1100, 400));
		
		add(btnImage("images/PosImages/상품 관리 이미지/검색 버튼.png", "images/PosImages/상품 관리 이미지/검색 버튼 클릭.png",  910,100,95,50));
		add(btnImage("images/PosImages/상품 관리 이미지/돌아가기 버튼.png","images/PosImages/상품 관리 이미지/돌아가기 버튼 클릭.png", 20, 690, 110, 55));
		add(btnImage("images/PosImages/상품 관리 이미지/삭제 버튼.png","images/PosImages/상품 관리 이미지/삭제 버튼 클릭.png", 1030, 620, 120, 55));
		add(btnImage("images/PosImages/상품 관리 이미지/수정 시작 버튼.png","images/PosImages/상품 관리 이미지/수정 시작 버튼 클릭.png", 900, 620, 120, 55));
		add(btnImage("images/PosImages/상품 관리 이미지/추가 시작 버튼.png","images/PosImages/상품 관리 이미지/추가 시작 버튼 클릭.png", 770, 620, 120, 55));
		add(tp);
		
		JButton addBtn = btnImage("images/PosImages/상품 관리 이미지/추가 시작 버튼.png",
				"images/PosImages/상품 관리 이미지/추가 시작 버튼 클릭.png", 
				770, 620, 120, 55);
		
		addBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame menu = new JFrame();
						
						menu.setLayout(null);
						menu.setSize(1000, 600);
						menu.setVisible(true);
						menu.getContentPane().setBackground(new Color(255, 255, 255));
						menu.setLocationRelativeTo(null);
						menu.setResizable(false);
					}
		});
		
		setLayout(null);
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(64, 64, 64));
		setLocationRelativeTo(null);
		setResizable(false);
		return serch;
	}
	
	public static JLabel labelImage(String image, int a, int b, int c, int d) throws IOException {
		JLabel l = new JLabel();
		BufferedImage bufferedlImage = ImageIO.read(new File(image));
		Image lImage = bufferedlImage.getScaledInstance(c, d, Image.SCALE_SMOOTH);
		l.setIcon(new ImageIcon(lImage));
		l.setBounds(a, b, c, d);

		return l;

	}

	public JButton buttons() throws IOException {
		JButton serchBtn = btnImage("PosImages/상품 관리 이미지/검색 버튼.png", 
				"PosImages/상품 관리 이미지/검색 버튼 클릭.png",  910,100,95,50);

		JButton backBtn = btnImage("PosImages/상품 관리 이미지/돌아가기 버튼.png",
				"PosImages/상품 관리 이미지/돌아가기 버튼 클릭.png", 20, 690, 110, 55);

		JButton deleteBtn = btnImage("PosImages/상품 관리 이미지/삭제 버튼.png",
				"PosImages/상품 관리 이미지/삭제 버튼 클릭.png", 1030, 620, 120, 55);

		JButton modifyBtn = btnImage("PosImages/상품 관리 이미지/수정 시작 버튼.png",
				"PosImages/상품 관리 이미지/수정 시작 버튼 클릭.png", 900, 620, 120, 55);

		JButton addBtn = btnImage("PosImages/상품 관리 이미지/추가 시작 버튼.png",
				"PosImages/상품 관리 이미지/추가 시작 버튼 클릭.png", 770, 620, 120, 55);

		add(serchBtn);
		add(backBtn);
		add(deleteBtn);
		add(modifyBtn);
		add(addBtn);
		add(tp);


		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new MenuAddFrame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		add(addBtn);
		setLayout(null);
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(64, 64, 64));
		setLocationRelativeTo(null);
		setResizable(false);

		return addBtn;
	}


		
	public static JButton btnImage(String image, String clickImage, int a, int b, int c, int d) throws IOException {

		JButton btn = new JButton();
		BufferedImage bufferedBtnImage = ImageIO.read(new File(image));
		Image btnImage = bufferedBtnImage.getScaledInstance(c, d, Image.SCALE_SMOOTH);
		btn.setIcon(new ImageIcon(btnImage));
		btn.setBounds(a, b, c, d);

		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);

		BufferedImage bufferedBtnClickImage = ImageIO.read(new File(clickImage));
		Image btnClickImage = bufferedBtnClickImage.getScaledInstance(c, d, Image.SCALE_SMOOTH);
		Icon btnClickIcon = new ImageIcon(btnClickImage);

		btn.setPressedIcon(btnClickIcon);


		return btn;
	}


		public static void main(String[] args) throws IOException {
			new ProductManagementJFrame();
		}






	}
