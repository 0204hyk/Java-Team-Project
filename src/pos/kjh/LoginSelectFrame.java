package pos.kjh;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginSelectFrame extends JFrame{
	
	public LoginSelectFrame() throws IOException {
		
		// 키오스크 로그인 버튼
		JButton kioskBtn = new JButton();
		BufferedImage bufferedKioskImage = ImageIO.read(new File("KioskImages/1. 관리자, 키오스크 모드/Asset 11@4x-8.png"));
		Image kImage = bufferedKioskImage.getScaledInstance(163, 141, Image.SCALE_SMOOTH);
		kioskBtn.setIcon(new ImageIcon(kImage));
		kioskBtn.setBounds(87, 154, 163, 141);
		
		// 포스 로그인 버튼
		JButton posBtn = new JButton();
		BufferedImage bufferedPoskImage = ImageIO.read(new File("KioskImages/1. 관리자, 키오스크 모드/Asset 10@4x-8.png"));
		Image pImage = bufferedPoskImage.getScaledInstance(163, 141, Image.SCALE_SMOOTH);
		posBtn.setIcon(new ImageIcon(pImage));
		posBtn.setBounds(319, 154, 163, 141);

		
		add(kioskBtn);
		add(posBtn);
		
		kioskBtn.setBorderPainted(false);
		kioskBtn.setContentAreaFilled(false);
		kioskBtn.setFocusPainted(false);
		
		posBtn.setBorderPainted(false);
		posBtn.setContentAreaFilled(false);
		posBtn.setFocusPainted(false);
		
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
		new LoginSelectFrame();
	}
		
	

}
