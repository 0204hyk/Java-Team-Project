package pos.main.exit_message;

import java.awt.Color;

import javax.swing.JFrame;

import pos.ImageScaledTool;
import pos.PosFrame;

public class ExitMessageFrame extends JFrame {
	public ExitMessageFrame(PosFrame pos) {
		
		add(new ExitMessageBackgroundPanel(pos, this, ImageScaledTool.getScaledImage(
				"images/PosImages/시작 페이지 버튼 이미지/로그아웃 창.png", 500, 250)));
				
		setSize(500, 250);
		setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));	// 패널 배경 투명하게 하기
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
