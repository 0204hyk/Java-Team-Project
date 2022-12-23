package kiosk.menuFrame.northPanel;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class North_NorthPanel extends JPanel{
	
	private JLabel logo = new JLabel();
	private JButton homeButton = new JButton();
	
	// 북북패널 ( 로고, 홈버튼)
	public North_NorthPanel() {
		
		setLayout(null);
		logo();
		homeButton();
		
		setBackground(Color.white);
		
	}
	
	//로고
	public void logo() {
		
		logo.setBounds(52, 25, 60, 83);
		
		
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("images/KioskImages/3_메뉴선택/logoScaled.png"));			
			logo.setIcon(new ImageIcon(logoBufferedImage));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		add(logo);
		
	}
	
	//홈버튼
	public void homeButton() {
		homeButton.setBorderPainted(false);	
		homeButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
		homeButton.setOpaque(false);
		
		homeButton.setFocusable(false);
		homeButton.setContentAreaFilled(false);
		homeButton.setFocusPainted(false);
		homeButton.setBounds(542, 44, 52, 52);
		setBackground(Color.white);
		try {
			BufferedImage homeBufferedImage =
			ImageIO.read(new File("images/KioskImages/3_메뉴선택/homeScaled.png"));
			
			homeButton.setIcon(new ImageIcon(homeBufferedImage));
			
			BufferedImage pressedHomeBufferedImage =
					ImageIO.read(new File("images/KioskImages/3_메뉴선택/homePressedScaled.png"));
					
					homeButton.setPressedIcon(new ImageIcon(pressedHomeBufferedImage));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		add(homeButton);
	}
	
}
