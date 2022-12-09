package kiosk.cardPut;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CardPutFrame extends JFrame {
	
		
	public CardPutFrame() {
		setImage();
		setDisplay();
	}
	
	public void setDisplay() {

		//setUndecorated(true); 
		setVisible(true);
		setSize(420, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public void setImage() {
		JLabel label = new JLabel();
		label.setSize(385, 270);
		
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("KioskImages/7_1_영수증_출력_여부,카드,결제완료/cardPutScaled.png"));			
			label.setIcon(new ImageIcon(logoBufferedImage));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
	}
	
	public static void main(String[] args) {

		new CardPutFrame();
	}
}
