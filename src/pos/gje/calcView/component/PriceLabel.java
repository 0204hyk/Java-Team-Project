package pos.gje.calcView.component;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PriceLabel extends JLabel{

	public PriceLabel() {
		setText("3,500");
		setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		
		 
		setBounds(400, 40, 100, 56); // 위치 및 사이즈 조절
		
	}
}
