package pos.kjh;

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
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pos.DigitalClock;
import pos.ImagePanel;
import pos.ImageScaledTool;
import pos.PosFrame;
import pos.gje.delet.component.CancelBtn;
import pos.gje.delet.panel.DeleteCheckPanel;
import pos.product_management.menu_add.MenuAddFrame;
import pos.product_management.menu_main.component.ModifyButton;

public class ProductManagementJFrame extends JFrame {

	public MenuListJTable mj = new MenuListJTable(allMenu());

	static JTextField serchText = new JTextField("키워드를 입력해주세요");

	PosFrame p;
	CancelBtn cBtn;
	DeleteCheckPanel dcp;
	
	public ProductManagementJFrame() throws IOException, SQLException {

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

		buttons();
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
	public static JLabel labelImage(String image, int a, int b, int c, int d) throws IOException {
		JLabel l = new JLabel();
		BufferedImage bufferedlImage = ImageIO.read(new File(image));
		Image lImage = bufferedlImage.getScaledInstance(c, d, Image.SCALE_SMOOTH);
		l.setIcon(new ImageIcon(lImage));
		l.setBounds(a, b, c, d);

		return l;

	}

	// 상품목록에 있는 버튼들
	public JButton buttons() throws IOException, SQLException {
		JButton serchBtn = btnImage("images/PosImages/상품 관리 이미지/검색 버튼.png", 
				"images/PosImages/상품 관리 이미지/검색 버튼 클릭.png",  910,100,95,50);

		JButton backBtn = btnImage("images/PosImages/상품 관리 이미지/돌아가기 버튼.png",
				"images/PosImages/상품 관리 이미지/돌아가기 버튼 클릭.png", 20, 680, 120, 65);

		JButton deleteBtn = btnImage("images/PosImages/상품 관리 이미지/삭제 버튼.png",
				"images/PosImages/상품 관리 이미지/삭제 버튼 클릭.png", 1027, 620, 130, 65);

		JButton addBtn = btnImage("images/PosImages/상품 관리 이미지/추가 시작 버튼.png",
				"images/PosImages/상품 관리 이미지/추가 시작 버튼 클릭.png", 733, 620, 130, 65);


		// 검색 버튼
		serchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					if (serch().getText() == null) {
						mj.setVisible(true);
					}
					else {
						mj.setVisible(false);
						MenuListJTable.contents.setNumRows(0);
						mj = new MenuListJTable(serchMenu(serch().getText()));
						add(mj);
					};

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		// 텍스트 창
		serchText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (serch().getText() == null) {
						mj.setVisible(true);
					}
					else {
						mj.setVisible(false);
						MenuListJTable.contents.setNumRows(0);
						mj = new MenuListJTable(serchMenu(serch().getText()));
						add(mj);
					};

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});


		// 돌아가기 버튼
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MenuListJTable table = null;
				try {
					table = new MenuListJTable(allMenu());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.contents.setNumRows(0);

			}
		});

		// 삭제 버튼
		deleteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					mj.delete();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});				

		// 추가 버튼
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					new MenuAddFrame();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		add(serchBtn);
		add(backBtn);
		add(deleteBtn);
		add(new ModifyButton(this));
		add(addBtn);

		setUndecorated(true);
		setLayout(null);
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(64, 64, 64));
		setLocationRelativeTo(null);
		setResizable(false);

		return addBtn;
	}



	// 버튼에 이미지 붙이는 메서드
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



	public static void main(String[] args) throws IOException, SQLException {
		new ProductManagementJFrame();
	}



}
