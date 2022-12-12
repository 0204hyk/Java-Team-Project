package pos.salescheck.component.saleslist;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ListImgLabel extends JLabel {

	
	public ListImgLabel() {

		try {
			BufferedImage image = ImageIO.read(new File("PosImage/매출 요약 이미지/saleslist.png"));
			Image scale = image.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setBounds(600, 200, 500, 500);
		
	}
}
