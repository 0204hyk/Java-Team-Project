package pos.closing.closing_main.component;

import java.awt.Font;

import javax.swing.JLabel;

public class TotalAmountLabel extends JLabel {
	// 총 금액 라벨
	public TotalAmountLabel() {
		setSize(300, 30);
		setText("10,000,000");
		setHorizontalAlignment(JLabel.RIGHT);
		setFont(new Font("맑은 고딕", Font.BOLD, 25));
	}
}
