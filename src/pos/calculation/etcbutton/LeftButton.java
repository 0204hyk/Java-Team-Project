package pos.calculation.etcbutton;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LeftButton extends JButton {

	public LeftButton() {

		// < 버튼 이미지 기본 아이콘
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/메뉴 창 뒤로가기 버튼.png"));
			Image scale = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// < 버튼 이미지 눌렀을 때
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/메뉴창 뒤로가기 버튼 클릭.png"));
			Image scale = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			setPressedIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}


		setBounds(1030, 540, 60, 60);
	}
}
