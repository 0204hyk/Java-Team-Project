package pos.calculation;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CalcTitleImage extends JPanel {

	
	public CalcTitleImage() {
		
		setBounds(0, 0, 1200, 50);
	}
	
	public void calcBar(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon("images/PosImages/매출 요약 이미지/매출 리스트 판 제목 란.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
		
		
	}
	
}
