package kiosk.menuFrame;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class North_SouthPanel extends JPanel {

	private JLabel logo = new JLabel();
	private JButton homeButton = new JButton();
	
	public North_SouthPanel() {
		logo();
		homeButton();
	}
	//로고
		public void logo() {
			
			logo.setBounds(500, 50, 50, 50);
			logo.setSize(100, 100);
			
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

			homeButton.setBounds(300, 300, 100, 100);
			
			try {
				BufferedImage homeBufferedImage =
				ImageIO.read(new File("image/menu/homeScaled.png"));
				
				Image scaledImage =  homeBufferedImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				
				homeButton.setIcon(new ImageIcon(scaledImage));
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
			add(homeButton);
		}
	
	
}
