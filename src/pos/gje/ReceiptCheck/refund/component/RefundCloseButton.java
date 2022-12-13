package pos.gje.ReceiptCheck.refund.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.gje.ReceiptCheck.receiptcheck_main.ReceiptCheckFrame;
import pos.gje.ReceiptCheck.refund.RefundFrame;

public class RefundCloseButton extends JButton implements ActionListener{
	ReceiptCheckFrame f1;
	RefundFrame f2;
	
	public RefundCloseButton(ReceiptCheckFrame f1, RefundFrame f2) {
		this.f1 = f1;
		this.f2 = f2;
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/영수증 조회 이미지/환불 창 닫기 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		setBounds(700, 10, 78, 48);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);

		addActionListener(this);

	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		f1.setEnabled(true);
		f2.setVisible(false);
	}

}
