package pos.salescheck.component;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SearchButton extends JButton {
	
	public SearchButton() {
		try {
			BufferedImage image = ImageIO.read(new File("PosImage/매출 요약 이미지/search.png"));
			Image scale = image.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setBounds(700, 100, 120, 60);
		setBorder(null);
		
	}
}
