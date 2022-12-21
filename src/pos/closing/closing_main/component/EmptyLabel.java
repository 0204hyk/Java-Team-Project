package pos.closing.closing_main.component;

import java.awt.Font;

import javax.swing.JLabel;

public class EmptyLabel extends JLabel {
	// 임시 텍스트 라벨
	public EmptyLabel() {
		setSize(100, 20);
		setText("0");
		setHorizontalAlignment(JLabel.RIGHT);
		setFont(new Font("맑은 고딕", Font.BOLD, 16));
	}
	
}
