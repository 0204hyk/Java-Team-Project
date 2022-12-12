package pos.salescheck.component.button;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EscapeButton extends JButton {

	public EscapeButton() {
		// 매출요약 < 버튼 이미지 설정
		try {
			BufferedImage image = ImageIO.read(new File("PosImage/매출 요약 이미지/escape.png"));
			Image scale = image.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// < 버튼 위치 지정
		setBounds(1050, 700, 100, 50);
		setBorder(null);
	}
}
