package pos.product_management.menu01_main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import pos.PosFrame;
import pos.product_management.menu01_main.component.AddButton;
import pos.product_management.menu01_main.component.DeleteButton;
import pos.product_management.menu01_main.component.MenuListJTable;
import pos.product_management.menu01_main.component.ModifyButton;
import pos.product_management.menu04_delete.DeleteCheckPanel;
import pos.product_management.menu04_delete.component.CancelBtn;
import pos.util.DigitalClock;
import pos.util.ImagePanel;
import pos.util.ImageScaledTool;

public class ProductManagementJFrame extends JFrame {

	public MenuListJTable mj = new MenuListJTable(allMenu());

	static JTextField serchText = new JTextField("키워드를 입력해주세요");

	PosFrame p;
	CancelBtn cBtn;
	DeleteCheckPanel dcp;
	public AddButton addBtn = new AddButton(this);
	public ModifyButton modifyBtn = new ModifyButton(this);
	public JButton deleteBtn = new DeleteButton(this);
	
	public ProductManagementJFrame() {

		JPanel titlePanel = new ImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상단 메뉴바.png", 1200, 60));
		titlePanel.setBounds(0 ,0, 1200, 60);
		// 현재 시간 출력
		JLabel clock = new DigitalClock();

		clock.setBounds(375, 10, 400, 30);

		titlePanel.add(clock);

		
		add(titlePanel);
		
		add(serch());

		add(labelImage("images/PosImages/상품 관리 이미지/검색바.png", 200, 100, 700, 51));
		
		add(mj);
		
		add(addBtn);
		add(modifyBtn);
		add(deleteBtn);
		
		buttons();
		
		setUndecorated(true);
		setLayout(null);
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(64, 64, 64));
		setLocationRelativeTo(null);
		setResizable(false);
	}


	// 원하는 디비 불러오는 메서드
	public String serchMenu(String keyword) {

		String text = "SELECT DISTINCT  menu_number, menu_name, price FROM menu WHERE menu_name LIKE '%" + keyword + "%'"
				+ "ORDER BY menu_number";
		
		return text;
	}
	
	// 모든 디비 불러오는 메서드
	public String allMenu() {
		
		String text = "SELECT DISTINCT  menu_number, menu_name, price FROM menu ORDER BY menu_number";
		
		return text;
	}


	// 검색창에 텍스트 입력하는 메서드
	public static JTextField serch() {
		serchText.setBounds(215, 100, 700, 49);
		serchText.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		serchText.setOpaque(false);
		serchText.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		serchText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				serchText.setText(null);
			}
		});


		return serchText;
	}


	// 라벨로 이미지 붙이는 메서드
	public static JLabel labelImage(String image, int a, int b, int c, int d) {
		JLabel l = new JLabel();
		try {
			BufferedImage bufferedlImage = ImageIO.read(new File(image));
			Image lImage = bufferedlImage.getScaledInstance(c, d, Image.SCALE_SMOOTH);
			l.setIcon(new ImageIcon(lImage));
			l.setBounds(a, b, c, d);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return l;
	}

	// 상품목록에 있는 버튼들
	public JButton buttons() {
		JButton serchBtn = btnImage("images/PosImages/상품 관리 이미지/검색 버튼.png", 
				"images/PosImages/상품 관리 이미지/검색 버튼 클릭.png",  910,100,120,50);

		JButton backBtn = btnImage("images/PosImages/상품 관리 이미지/돌아가기 버튼.png",
				"images/PosImages/상품 관리 이미지/돌아가기 버튼 클릭.png", 45, 675, 180, 80);

		// 검색 버튼
		serchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (serch().getText() == null) {
					mj.setVisible(true);
				}
				else {
					mj.setVisible(false);
					MenuListJTable.contents.setNumRows(0);
					mj = new MenuListJTable(serchMenu(serch().getText()));
					add(mj);
				};

			}
		});

		// 텍스트 창
		serchText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (serch().getText() == null) {
					mj.setVisible(true);
				}
				else {
					mj.setVisible(false);
					MenuListJTable.contents.setNumRows(0);
					mj = new MenuListJTable(serchMenu(serch().getText()));
					add(mj);
				};

			}
		});


		// 돌아가기 버튼
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				serchText = new JTextField("키워드를 입력해주세요");

				dispose();
				MenuListJTable table = null;
				table = new MenuListJTable(allMenu());
				table.contents.setNumRows(0);

			}
		});	
		
		add(serchBtn);
		add(backBtn);

		return serchBtn;
	}



	// 버튼에 이미지 붙이는 메서드
	public static JButton btnImage(String image, String clickImage, int a, int b, int c, int d) {
		JButton btn = new JButton();
		try {
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
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return btn;
	}



	public static void main(String[] args) {
		new ProductManagementJFrame();
	}



}
