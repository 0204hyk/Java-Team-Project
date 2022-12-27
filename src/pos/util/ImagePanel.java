package pos.util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	// 마감 파트 이미지 들어가는 패널 생성
	private Image background;
	
	public void paintComponent(Graphics g) {
		// 생성하는 패널 사이즈에 맞춰 이미지 그리기
		Dimension d = getSize();
		g.drawImage(background, 0, 0, d.width, d.height, null);		
	}	
	
	public ImagePanel(Image background) {
		this.background = background;
		setLayout(null);
		// 패널 사이즈 이미지 크기에 맞게 조정
		setSize(new Dimension(background.getWidth(null), background.getHeight(null)));
	}
}
