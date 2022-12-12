package pos.gje.ReceiptCheck.refund_message.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pos.ImageScaledTool;
import pos.gje.ReceiptCheck.receiptcheck_main.ReceiptCheckFrame;
import pos.gje.ReceiptCheck.refund_message.RefundFrame;
import pos.gje.ReceiptCheck.refund_message.component.RefundCloseButton;

public class TitlePanel extends JPanel {
	Image image = ImageScaledTool.getScaledImage(
			"images/PosImages/영수증 조회 이미지/타이틀바.png", 800, 63);
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(image, 0, 0, d.width, d.height, null);
	}	
	
	public TitlePanel() {
		setBounds(0, 0, 800, 63); // Panel 틀
	}	     

}
