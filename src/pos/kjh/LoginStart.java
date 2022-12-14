package pos.kjh;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginStart extends JFrame{
	
	public LoginStart() throws IOException {
		
		// 카페 로고
		JLabel logo = new JLabel();
		
		BufferedImage bufferedLogoImage = ImageIO.read(new File("images/KioskImages/2. 로그인/Asset 9@4x-8.png"));
		Image logoImage = bufferedLogoImage.getScaledInstance(118, 163, Image.SCALE_SMOOTH);
		logo.setIcon(new ImageIcon(logoImage));
		
		logo.setBounds(224, 55, 118, 163);
		
		// 아이디 입력
		JLabel id = new JLabel();
		
		BufferedImage bufferedIdImage = ImageIO.read(new File("images/KioskImages/2. 로그인/Asset 13@4x-8.png"));
		Image idImage = bufferedIdImage.getScaledInstance(227, 43, Image.SCALE_SMOOTH);
		id.setIcon(new ImageIcon(idImage));
		
		id.setBounds(170, 260, 227, 43);

		// 비밀번호 입력
		JLabel pw = new JLabel();

		BufferedImage bufferedPwImage = ImageIO.read(new File("images/KioskImages/2. 로그인/Asset 8@4x-8.png"));
		Image pwImage = bufferedPwImage.getScaledInstance(227, 43, Image.SCALE_SMOOTH);
		pw.setIcon(new ImageIcon(pwImage));

		pw.setBounds(170, 318, 227, 43);

		
		// 로그인 진행 확인 버튼
		JButton checkBtn = new JButton();
		BufferedImage bufferedCheckImage = ImageIO.read(new File("images/KioskImages/2. 로그인/Asset 12@4x-8.png"));
		Image chImage = bufferedCheckImage.getScaledInstance(38,38, Image.SCALE_SMOOTH);
		checkBtn.setIcon(new ImageIcon(chImage));
		checkBtn.setBounds(428,291,38,38);
		
		
		
		checkBtn.setBorderPainted(false);
		checkBtn.setContentAreaFilled(false);
		checkBtn.setFocusPainted(false);
		
		add(checkBtn);
		add(pw);
		add(id);
		add(logo);
		
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
