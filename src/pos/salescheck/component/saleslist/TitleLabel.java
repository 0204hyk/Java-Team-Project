package pos.salescheck.component.saleslist;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TitleLabel extends JLabel {

	
	public TitleLabel() {
		
		setText("2022년 12월 매출");
		setForeground(Color.WHITE);
		setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		setBounds(730, 0, 500, 500);
		
	}
}
