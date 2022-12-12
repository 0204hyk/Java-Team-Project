package pos.closing.closing_main.container;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ClosingImagePanel extends JPanel {
	// 마감 파트 이미지 들어가는 패널 생성
	private Image background;
	
	public void paintComponent(Graphics g) {
		// 생성하는 패널 사이즈에 맞춰 이미지 그리기
		Dimension d = getSize();
		g.drawImage(background, 0, 0, d.width, d.height, null);		
	}	
	
	public ClosingImagePanel(Image background) {
		this.background = background;
		setLayout(null);
		// 패널 사이즈 이미지 크기에 맞게 조정
		setSize(new Dimension(background.getWidth(null), background.getHeight(null)));
	}
}
