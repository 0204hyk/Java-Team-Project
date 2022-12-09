package pos.salescheck.component;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EscapeButton extends JButton {

	public EscapeButton() {
		
		try {
			BufferedImage image = ImageIO.read(new File("sales_summary/escape.png"));
			Image scale = image.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setBounds(1050, 700, 120, 80);
		setBorder(null);
	}
}
