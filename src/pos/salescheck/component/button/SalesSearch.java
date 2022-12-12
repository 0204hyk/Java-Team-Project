package pos.salescheck.component.button;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SalesSearch extends JButton {
	
	public SalesSearch() {
		// 매출요약 검색 버튼 이미지 설정.
		try {
			BufferedImage image = ImageIO.read(new File("PosImages/매출 요약 이미지/날짜 검색 버튼.png"));
			Image scale = image.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 매출요약 검색 버튼 눌렀을 때 설정.
		try {
			BufferedImage image = ImageIO.read(new File("PosImages/매출 요약 이미지/날짜 검색 버튼 클릭.png"));
			Image click = image.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
			setPressedIcon(new ImageIcon(click));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// 검색버튼 위치 설정.
		
		setBounds(750, 100, 100, 50);
		setBorder(null);
		
	}
}
