package pos.salescheck.component.button;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SalesEscape extends JButton {

	public SalesEscape() {
		// 매출요약 < 버튼 이미지 설정
		try {
			BufferedImage image = ImageIO.read(new File("PosImages/매출 요약 이미지/돌아가기 버튼.png"));
			Image scale = image.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 매출요약 < 버튼 눌렀을 때
		try {
			BufferedImage image = ImageIO.read(new File("PosImages/매출 요약 이미지/돌아가기 버튼 클릭.png"));
			Image click = image.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
			setPressedIcon(new ImageIcon(click));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// < 버튼 위치 지정
		setBounds(1050, 700, 100, 50);
		setBorder(null);
	}
}
