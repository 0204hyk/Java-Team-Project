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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.OjdbcConnection;
import pos.PosFrame;
import pos.product_management.menu01_main.ProductManagementJFrame;

public class LoginStart extends JFrame{

	String idCheck;
	String pwCheck;
	JTextField idText;
	JTextField pwText;
	
	static JLabel discordance = loginCheck("잘못된 아이디 또는 비밀번호 입니다.");
	static JLabel idNoInput = loginCheck("아이디를 입력해주세요.");
	static JLabel pwNoInput = loginCheck("비밀번호를 입력해주세요.");

	public JLabel labelSetting(String image, int a, int b, int c, int d) {
		JLabel label = new JLabel();

		try {
			BufferedImage bufferedlabelImage = ImageIO.read(new File(image));
			Image labelImage = bufferedlabelImage.getScaledInstance(c, d, Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(labelImage));
			label.setBounds(a, b, c, d);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return label;
	}


	// DB 아이디 체크
	public String checkIdDB() {

		String sql = "SELECT manager_id FROM manager";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){

			while (rs.next()) {
				idCheck = rs.getString("manager_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return idCheck;
	}

	// DB 비번 체크
	public String checkPwDB() {

		String sql = "SELECT manager_password FROM manager";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){

			while (rs.next()) {
				pwCheck = rs.getString("manager_password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pwCheck;
	}


	public static  JLabel loginCheck(String text) {
		JLabel l = new JLabel(text);

		l.setForeground(Color.RED);
		l.setBounds(175, 350, 220, 43);

		return l;
	}

	public LoginStart() {

		// 닫기 버튼
		JButton xBtn = new JButton();
		try {
			BufferedImage bufferedxImage = ImageIO.read(new File("images/KioskImages/1. 관리자, 키오스크 모드/닫기 버튼.png"));
			Image xBtnImage = bufferedxImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			xBtn.setIcon(new ImageIcon(xBtnImage));
			xBtn.setBounds(520, 10, 40, 40);
			
			xBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		// 아이디 입력
		
		idText = new JTextField();

		idText.setBounds(220, 266, 170, 30);
		idText.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		idText.setFocusable(true);
		idText.setOpaque(false);
		idText.setBorder(javax.swing.BorderFactory.createEmptyBorder());


		// 비밀번호 입력
		pwText = new JPasswordField() ;

		pwText.setBounds(220, 325, 170, 30);
		pwText.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		pwText.setFocusable(true);
		pwText.setOpaque(false);
		pwText.setBorder(javax.swing.BorderFactory.createEmptyBorder());


		// 카페 로고 이미지
		JLabel logoLabel = labelSetting("images/KioskImages/2. 로그인/Asset 9@4x-8.png", 224, 55, 118, 163);

		// 아이디 입력 이미지
		JLabel idLabel = labelSetting("images/KioskImages/2. 로그인/Asset 13@4x-8.png", 170, 260, 227, 43);

		// 비밀번호 입력 이미지
		JLabel pwLabel = labelSetting("images/KioskImages/2. 로그인/Asset 8@4x-8.png", 170, 318, 227, 43);


		// 로그인 진행 확인 버튼
		JButton checkBtn = ProductManagementJFrame.btnImage(
				"images/KioskImages/2. 로그인/Asset 12@4x-8.png"
				, "images/KioskImages/2. 로그인/Asset 12@4x-8 클릭.png"
				, 428,291,38,38);

		LoginSelectFrame.buttonSetting(checkBtn);
		LoginSelectFrame.buttonSetting(xBtn);

		checkBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 값이 입력되지 않았다면
				if (idText.getText().length() == 0 && pwText.getText().length() == 0) {
					discordance.setVisible(false);
						idNoInput.setVisible(true);
					
				} else if (idText.getText().length() > 0 && pwText.getText().length() == 0){
					discordance.setVisible(false);
					idNoInput.setVisible(false);
					pwNoInput.setVisible(true);
					
					
				} else if (idText.getText().length() == 0 && pwText.getText().length() > 0) {
					discordance.setVisible(false);
					pwNoInput.setVisible(false);
					idNoInput.setVisible(true);
					
				} else {
					
					if (checkIdDB().equals(idText.getText()) && checkPwDB().equals(pwText.getText())) {

						dispose();
						new PosFrame();

					} else if (!(checkIdDB().equals(idText.getText())) || !(checkPwDB().equals(pwText.getText()))){
						idNoInput.setVisible(false);
						pwNoInput.setVisible(false);
						discordance.setVisible(true);
					}
				
				}
			}
		});

		add(discordance);
		discordance.setVisible(false);

		add(idNoInput);
		idNoInput.setVisible(false);

		add(pwNoInput);
		pwNoInput.setVisible(false);

		add(idText);
		add(pwText);
		add(xBtn);
		add(checkBtn);
		add(pwLabel);
		add(idLabel);
		add(logoLabel);

		setUndecorated(true);
		setLayout(null);
		setSize(570, 450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		setLocationRelativeTo(null);
		setResizable(false); 
	}

	public static void main(String[] args) throws IOException {
		new LoginStart();
	}
}
