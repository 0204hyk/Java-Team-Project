package pos.closing.closing_message;

import java.awt.Color;

import javax.swing.JFrame;

import pos.ImageScaledTool;
import pos.PosFrame;
import pos.closing.closing_main.ClosingFrame;
import pos.closing.closing_main.component.DoCloseButton;
import pos.closing.closing_message.container.ClosingBackgroundPanel;

public class ClosingMessageFrame extends JFrame {
	// 마감 확인 안내창
	ClosingFrame mainFrame;
	public ClosingMessageFrame(ClosingFrame mainFrame) {
		this.mainFrame = mainFrame;
		add(new ClosingBackgroundPanel(mainFrame, this, ImageScaledTool.getScaledImage(
				"images/PosImages/마감 이미지/마감 확인 안내창.png", 500, 250)));
		
		setSize(500, 250);
		setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));	// 패널 배경 투명하게 하기
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
