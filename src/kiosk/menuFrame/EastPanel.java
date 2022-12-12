package kiosk.menuFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EastPanel extends JPanel {
	
	public EastPanel() {
		
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		nextButton();
		setBackground(Color.white);
	}
	
	public void nextButton() {
		JButton button = new JButton();
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("KioskImages/3_메뉴선택/nextButtonScaled.png"));			
			button.setIcon(new ImageIcon(logoBufferedImage));
			
			button.setBorderPainted(false);	
			button.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			button.setOpaque(false);
			button.setPreferredSize(new Dimension(40,40));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		// Borderlayout 사용하여 옆쪽 여백주기위해서 공백버튼
		JButton blankButton = new JButton();
		try {
			BufferedImage BufferedImage =
			ImageIO.read(new File("KioskImages/3_메뉴선택/menuImages/buttonBlank.png"));			
			blankButton.setIcon(new ImageIcon(BufferedImage));
			
			blankButton.setPreferredSize(new Dimension(10,10)); // (동쪽 버튼옆 여백 지정)
			blankButton.setBorderPainted(false);	
			blankButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			blankButton.setOpaque(false);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		add(button, BorderLayout.WEST);
		add(blankButton, BorderLayout.EAST);

	}
}
