package pos.calculation.categorybutton;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CalcEscapeButton extends JButton {

	
	public CalcEscapeButton() {
		
		// < 버튼 이미지
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/돌아가기 버튼.png"));
			Image scale = image.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// < 버튼 이미지 눌렀을 때
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/돌아가기 버튼 클릭.png"));
			Image scale = image.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
			setPressedIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		setBorder(null);
		setBounds(80, 700, 100, 50);
		
		
		
		
	}
}
