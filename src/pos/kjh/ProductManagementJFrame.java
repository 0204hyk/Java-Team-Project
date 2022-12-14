package pos.kjh;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pos.DigitalClock;
import pos.ImageScaledTool;
import pos.closing.closing_main.container.ClosingImagePanel;
import pos.gje.delete.DeletFrame;
import pos.gje.modify.ModifyFrame;

public class ProductManagementJFrame extends JFrame {

	

	public ProductManagementJFrame() throws IOException {
		// 상단 메뉴바 설정
		JPanel titlePanel = new ClosingImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상단 메뉴바.png", 1200, 60));
		titlePanel.setBounds(0 ,0, 1200, 60);
		// 현재 시간 출력
		JLabel clock = new DigitalClock();
		clock.setBounds(375, 10, 400, 30);
		titlePanel.add(clock);
		
		add(titlePanel);
		
		add(labelImage("images/PosImages/상품 관리 이미지/검색바.png", 200, 100, 700, 51));
		add(labelImage("images/PosImages/상품 관리 이미지/메뉴 리스트 기본 틀.png", 48, 190, 1100, 400));
		serch();
		buttons();
	}
	
	public JTextField serch() {
		JTextField serch = new JTextField();

		serch.setBounds(215, 100, 700, 49);
		serch.setOpaque(false);
		serch.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				
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
		JButton serchBtn = btnImage("images/PosImages/상품 관리 이미지/검색 버튼.png", 
				"images/PosImages/상품 관리 이미지/검색 버튼 클릭.png",  910,100,95,50);

		JButton backBtn = btnImage("images/PosImages/상품 관리 이미지/돌아가기 버튼.png",
				"images/PosImages/상품 관리 이미지/돌아가기 버튼 클릭.png", 20, 690, 110, 55);

		JButton deleteBtn = btnImage("images/PosImages/상품 관리 이미지/삭제 버튼.png",
				"images/PosImages/상품 관리 이미지/삭제 버튼 클릭.png", 1030, 620, 120, 55);

		JButton modifyBtn = btnImage("images/PosImages/상품 관리 이미지/수정 시작 버튼.png",
				"images/PosImages/상품 관리 이미지/수정 시작 버튼 클릭.png", 900, 620, 120, 55);

		JButton addBtn = btnImage("images/PosImages/상품 관리 이미지/추가 시작 버튼.png",
				"images/PosImages/상품 관리 이미지/추가 시작 버튼 클릭.png", 770, 620, 120, 55);
		
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
//				new PosFrame();
			}
		});
		
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeletFrame();
				
			}
		});
		
		modifyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ModifyFrame();
				
			}
		});

		add(serchBtn);
		add(backBtn);
		add(deleteBtn);
		add(modifyBtn);
		add(addBtn);

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
		
		setLayout(null);
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(64, 64, 64));
		//setUndecorated(true);
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
