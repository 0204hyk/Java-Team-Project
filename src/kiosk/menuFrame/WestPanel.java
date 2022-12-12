package kiosk.menuFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WestPanel extends JPanel {
	
	public WestPanel() {
		
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		prevButton();
		setBackground(Color.white);
		
	}
	
	public void prevButton() {
		JButton button = new JButton();
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("KioskImages/3_메뉴선택/prevButtonScaled.png"));			
			button.setIcon(new ImageIcon(logoBufferedImage));
			
			button.setPreferredSize(new Dimension(40,40));
			button.setBorderPainted(false);	
			button.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			button.setOpaque(false);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		// Borderlayout 사용하여 옆쪽 여백주기위해서 공백버튼
		JButton button2 = new JButton();
		try {
			BufferedImage BufferedImage =
			ImageIO.read(new File("KioskImages/3_메뉴선택/menuImages/buttonBlank.png"));			
			button2.setIcon(new ImageIcon(BufferedImage));
			
			button2.setPreferredSize(new Dimension(10,10)); // (서쪽 버튼옆 여백 지정)
			button2.setBorderPainted(false);	
			button2.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			button2.setOpaque(false);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		add(button, BorderLayout.EAST);
		add(button2, BorderLayout.WEST);
		
	}

}
