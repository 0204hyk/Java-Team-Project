package kiosk.menuFrame.southPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class South_EastPanel extends JPanel{

	
	public South_EastPanel() {
		//add(blank());
		setBackground(Color.white);
	}
	
public JButton blank() {
	JButton blank = new JButton();
	
	
		blank.setPreferredSize(new Dimension(20, 0));
		
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/buttonBlank.png"));			
			blank.setIcon(new ImageIcon(logoBufferedImage));
			
			blank.setBorderPainted(false);	
			blank.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			blank.setOpaque(false);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return blank;
		
	}
}
