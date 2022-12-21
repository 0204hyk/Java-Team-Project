package pos.calculation;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MenuCategoryView extends JLabel {

	
	public MenuCategoryView() {
		
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/메뉴 카테고리 배경판.png"));
			Image scale = image.getScaledInstance(640, 500, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setBounds(550, 110, 640, 500);
		
	}
}
