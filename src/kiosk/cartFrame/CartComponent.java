package kiosk.cartFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CartComponent {
	
	private JLabel logo = new JLabel();
	private JButton homeButton = new JButton();
	Font font = new Font("맑은 고딕", Font.BOLD, 27);
	
	//로고
	public JLabel logo() {
			
		logo.setBounds(52, 25, 60, 83);
		
		
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("image/menu/logoScaled.png"));			
			logo.setIcon(new ImageIcon(logoBufferedImage));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return logo;
	}
		
	public JButton homeButton() {
		homeButton.setBorderPainted(false);	
		homeButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
		homeButton.setOpaque(false);

		homeButton.setBounds(542, 44, 52, 52);
		
		try {
			BufferedImage homeBufferedImage =
			ImageIO.read(new File("image/menu/homeScaled.png"));
			
			homeButton.setIcon(new ImageIcon(homeBufferedImage));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return homeButton;
	}	
		
	public JLabel mainLabel() {
		JLabel label = new JLabel();
		
		label.setFont(font);
		label.setText("주문 정보를 확인해주세요.");
		label.setBounds(80, 130, 350, 150);
		
		return label;
	}
	
}
