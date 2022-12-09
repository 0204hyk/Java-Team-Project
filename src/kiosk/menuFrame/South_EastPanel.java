package kiosk.menuFrame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class South_EastPanel extends JPanel{
	
	JButton paymentButton = new JButton();
	JButton cancelButton = new JButton();

	public South_EastPanel() {
		
		setLayout(new GridLayout(0,1));
		setBackground(Color.white);
		
		paymentButton();
		cancelButton();
		
	}
	
	public void paymentButton() {
		
		paymentButton.setBounds(540, 833, 85, 56);
		
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("image/menu/payScaled.png"));			
			paymentButton.setIcon(new ImageIcon(logoBufferedImage));
			
			paymentButton.setBorderPainted(false);	
			paymentButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			paymentButton.setOpaque(false);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		add(paymentButton);
		
	}
	
	public void cancelButton() {
		cancelButton.setBounds(540, 896, 85, 50);

		
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("image/menu/deleteAllScaled.png"));			
			cancelButton.setIcon(new ImageIcon(logoBufferedImage));
			
			cancelButton.setBorderPainted(false);	
			cancelButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			cancelButton.setOpaque(false);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		add(cancelButton);
		
	}
}
