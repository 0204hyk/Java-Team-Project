package pos.receipt_check.calcView.component;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class QuantityLabel extends JLabel{

	public QuantityLabel() {
		setText("1");
		setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		
	
	
		setBounds(355, 40, 10, 56); // 위치 및 사이즈 조절

	}
}
