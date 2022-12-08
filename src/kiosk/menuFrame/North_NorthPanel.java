package kiosk.menuFrame;

import java.awt.Color;
import java.awt.Image;
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
		
	}
	
	//로고
	public void logo() {
		
		logo.setBounds(5, 5, 83, 66);
		logo.setSize(83, 66);
		
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("image/menu/logoScaled.png"));			
			logo.setIcon(new ImageIcon(logoBufferedImage));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		add(logo);
		
	}
	
	//
	public void homeButton() {
		homeButton.setSize(52, 52);
		homeButton.setBorderPainted(false);	
		homeButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
		homeButton.setOpaque(false);

		homeButton.setBounds(580, 5, 52, 52);
		
		try {
			BufferedImage homeBufferedImage =
			ImageIO.read(new File("image/menu/homeScaled.png"));
			
			homeButton.setIcon(new ImageIcon(homeBufferedImage));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		add(homeButton);
	}
	
}
