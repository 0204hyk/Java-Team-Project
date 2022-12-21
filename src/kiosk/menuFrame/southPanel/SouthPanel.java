package kiosk.menuFrame.southPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SouthPanel extends JPanel {

	public SouthPanel() {

		setLayout(new BorderLayout(10, 0));
		setBackground(Color.white);

		// 장바구니 부분
		add(new SouthScrollPane(), BorderLayout.WEST);

		// 버튼 부분
		add(new South_CenterPanel(), BorderLayout.EAST);
		add(new South_EastPanel());
	}

}
