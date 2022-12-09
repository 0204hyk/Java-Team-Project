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
	

	
	
	
	
	//로고
	public JLabel logo() {
		JLabel logo = new JLabel();
			
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
		JButton homeButton = new JButton();
		
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
		
		Font font = new Font("맑은 고딕", Font.BOLD, 27);
		label.setFont(font);
		label.setText("주문 정보를 확인해주세요.");
		label.setBounds(80, 130, 350, 150);
		
		return label;
	}
	
	public JLabel priceLabel() {
		JLabel label = new JLabel();
		Font font = new Font("맑은 고딕", Font.BOLD, 15);
		label.setFont(font);
		
		label.setText("주문 금액");
		label.setBounds(350, 645, 91, 23);
		
		return label;
	}
	
	public JLabel price() {
		JLabel label = new JLabel();
		Font font = new Font("맑은 고딕", Font.BOLD, 15);
		label.setFont(font);
		
		label.setText("11,200원");
		label.setBounds(510, 645, 91, 23);
		
		return label;
	}
	
	public JLabel pointLabel() {
		JLabel label = new JLabel();
		Font font = new Font("맑은 고딕", Font.BOLD, 16);
		label.setFont(font);
		
		label.setText("포인트 사용");
		label.setBounds(332, 680, 112, 23);
		return label;
	}
	
	public JLabel point() {
		JLabel label = new JLabel();
		Font font = new Font("맑은 고딕", Font.BOLD, 16);
		label.setFont(font);
		
		label.setText("200원");
		label.setBounds(520, 680, 112, 23);
		return label;
	}
	
	public JLabel totalPriceLabel() {
		JLabel label = new JLabel();
		Font font = new Font("맑은 고딕", Font.BOLD, 27);
		label.setFont(font);
		
		label.setText("결제 금액");
		label.setBounds(300, 715, 126, 32);
		return label;
	}
	
	public JLabel totalPrice() {
		JLabel label = new JLabel();
		Font font = new Font("맑은 고딕", Font.BOLD, 27);
		label.setForeground(Color.getHSBColor(63, 187, 145));
		label.setFont(font);
		label.setText("11,000원");
		label.setBounds(450, 715, 126, 32);
		return label;
	}
	
	public JButton payButton() {
		JButton payButton = new JButton();
		
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("KioskImages/7_주문정보_확인/payScaled.png"));			
			payButton.setIcon(new ImageIcon(logoBufferedImage));
			
			payButton.setBorderPainted(false);	
			payButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			payButton.setOpaque(false);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		//cancelButton.setBounds(125, 790, 192, 68);
		payButton.setBounds(335, 790, 192, 68);
		return payButton;
	}
	
	public JButton cancelButton() {
		JButton cancelButton = new JButton();
		
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("KioskImages/7_주문정보_확인/cancelScaled.png"));			
			cancelButton.setIcon(new ImageIcon(logoBufferedImage));
			
			cancelButton.setBorderPainted(false);	
			cancelButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			cancelButton.setOpaque(false);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		cancelButton.setBounds(125, 790, 192, 68);

		return cancelButton;
	}
}
