package pos.gje.ReceiptCheck;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ReceiptCheckButton {
	
	public ReceiptCheckButton() {

	}
	
	public static JButton refundBtn () {
		JButton refundBtn = new JButton();
	
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("PosImages/영수증 조회 이미지/환불 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(230, 60, Image.SCALE_SMOOTH); // 크기 조정
			refundBtn.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		refundBtn.setBounds(900, 650, 230, 60); // 위치 및 사이즈 조절
	
		refundBtn.setBackground(Color.white);
		refundBtn.getFocusTraversalKeysEnabled();
		refundBtn.setBorderPainted(false);
		refundBtn.setOpaque(false);
		refundBtn.setContentAreaFilled(false);
		
		return refundBtn;
	}

	
	public static JButton outfutBtn() {
		JButton outfutBtn = new JButton();
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("src/receiptImages/영수증 출력 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(230, 60, Image.SCALE_SMOOTH); // 크기 조정
			outfutBtn.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		
		outfutBtn.setBounds(650, 650, 230, 60);
		outfutBtn.setContentAreaFilled(false);
		outfutBtn.setBackground(Color.white);
		outfutBtn.setBorderPainted(false);
		outfutBtn.setOpaque(false);
		
		return outfutBtn;
		
	}
	
	

	

}
