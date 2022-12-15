package pos.gje.ReceiptCheck.receiptcheck_main.panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pos.gje.ReceiptCheck.receiptcheck_main.ReceiptCheckFrame;
import pos.gje.ReceiptCheck.receiptcheck_main.component.ReceiptBtn;

public class ReceiptListPanel extends JPanel {

	// 패널 배경 넣기
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon("images/PosImages/영수증 조회 이미지/날짜별 영수증 리스트 기본 틀.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public ReceiptListPanel(ReceiptCheckFrame f) {
		
		// i = DB에 저장된 개수 	
		for (int i = 0; i < 4; ++i){
			add(new ReceiptBtn(i + 1, f));
		}
		
		setBounds(75, 95, 500, 550); // Panel 틀
		setLayout(null);
		setVisible(true);
		
	}	       
}
