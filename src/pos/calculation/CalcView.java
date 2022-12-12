package pos.calculation;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CalcView extends JLabel {

	public CalcView() {
		
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/주문 메뉴 리스트 기본 틀.png"));
			Image scale = image.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setBounds(100, 150, 500, 500);
	}
}
