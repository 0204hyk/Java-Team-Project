package kiosk.printReceipt;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrintReciptPanel extends JPanel {
	
	public PrintReciptPanel() {
		setLayout(null);
		setImage();
		noPrintButton();
		printButton();
		
		
	}
	
	public void setImage() {
		JLabel label = new JLabel();
		label.setBounds(20, 20,365, 190);
		
		try {
			BufferedImage bufferedImage =
			ImageIO.read(new File("KioskImages/7_1_영수증_출력_여부,카드,결제완료/printReceiptScaled.png"));			
			label.setIcon(new ImageIcon(bufferedImage));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
	}
	
	public void noPrintButton() {
		JButton button = new JButton();
		
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("KioskImages/7_1_영수증_출력_여부,카드,결제완료/noPrintButtonScaled.png"));			
			button.setIcon(new ImageIcon(logoBufferedImage));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		button.setBorderPainted(false);	
		button.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
		button.setOpaque(false);
		
		button.setBounds(285, 220, 98, 46);
		
		add(button);
	}
	
	public void printButton() {
		JButton button = new JButton();
		
		try {
			BufferedImage logoBufferedImage =
			ImageIO.read(new File("KioskImages/7_1_영수증_출력_여부,카드,결제완료/printButtonScaled.png"));			
			button.setIcon(new ImageIcon(logoBufferedImage));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		button.setBorderPainted(false);	
		button.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
		button.setOpaque(false);
		
		button.setBounds(170, 220, 98, 46);
		
		add(button);
	}
	

}
