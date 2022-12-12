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
		setLayout(layout);//임시
		
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
		
		
		add(button);
		

	}
}
