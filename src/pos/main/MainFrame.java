package pos.main;

import java.awt.Color;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("POS 메인화면");
		setSize(1200, 800);
		getContentPane().setBackground(new Color(64, 64, 64));	// 프레임 백그라운드 컬러 설정
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
