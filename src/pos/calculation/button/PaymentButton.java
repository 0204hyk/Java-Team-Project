package pos.calculation.button;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PaymentButton extends JButton {

	public PaymentButton() {
		
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/결제 버튼.png"));
			Image scale = image.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/결제 버튼 클릭.png"));
			Image scale = image.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
			setPressedIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		setBounds(1050, 700, 100, 50);
		setBorder(null);
		
	}
}
