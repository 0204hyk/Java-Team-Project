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
import javax.swing.JTextField;

import pos.PosFrame;

public class LoginStart extends JFrame{

	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static String id = "hyCafe";
	private static String pw = "1234";

	String idCheck;
	String pwCheck;
	JTextField idText;
	JTextField pwText;
	
	static JLabel discordance = loginCheck("잘못된 아이디 또는 비밀번호 입니다.");
	static JLabel idNoInput = loginCheck("아이디를 입력해주세요.");
	static JLabel pwNoInput = loginCheck("비밀번호를 입력해주세요.");

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이브 연결 안됨");
		}
	}

	public JLabel labelSetting(String image, int a, int b, int c, int d) throws IOException {
		JLabel label = new JLabel();

		BufferedImage bufferedlabelImage = ImageIO.read(new File(image));
		Image labelImage = bufferedlabelImage.getScaledInstance(c, d, Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(labelImage));
		label.setBounds(a, b, c, d);

		return label;
	}


	// DB 아이디 체크
	public String checkIdDB() throws SQLException {

		String sql = "SELECT manager_id FROM manager";

		try (
				Connection conn = DriverManager.getConnection(url, id, pw);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){

			while (rs.next()) {
				idCheck = rs.getString("manager_id");
			}
		}

		return idCheck;
	}

	// DB 비번 체크
	public String checkPwDB() throws SQLException {

		String sql = "SELECT manager_password FROM manager";

		try (
				Connection conn = DriverManager.getConnection(url, id, pw);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){

			while (rs.next()) {
				pwCheck = rs.getString("manager_password");
			}
		}

		return pwCheck;
	}


	public static  JLabel loginCheck(String text) {
		JLabel l = new JLabel(text);

		l.setForeground(Color.RED);
		l.setBounds(175, 350, 220, 43);

		return l;
	}

	public LoginStart() throws IOException {

		// 닫기 버튼
		JButton xBtn = new JButton();
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

		// 아이디 입력
		
		idText = new JTextField();

		idText.setBounds(220, 265, 170, 30);
		idText.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		idText.setOpaque(false);
		idText.setBorder(javax.swing.BorderFactory.createEmptyBorder());


		// 비밀번호 입력
		pwText = new JTextField() ;

		pwText.setBounds(220, 322, 170, 30);
		pwText.setFont(new Font("맑은 고딕", Font.BOLD, 15));
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
				try {

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
				} catch (SQLException e1) {
					e1.printStackTrace();
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
