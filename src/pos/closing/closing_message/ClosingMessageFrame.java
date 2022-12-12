package pos.closing.closing_message;

import java.awt.Color;

import javax.swing.JFrame;

import pos.ImageScaledTool;
import pos.closing.closing_message.container.ClosingBackgroundPanel;

public class ClosingMessageFrame extends JFrame {
	
	public ClosingMessageFrame() {
				
		add(new ClosingBackgroundPanel(this, ImageScaledTool.getScaledImage(
				"PosImages/마감 이미지/마감 확인 안내창.png", 500, 250)));
		
		setSize(500, 250);
		setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));	// 패널 배경 투명하게 하기
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
