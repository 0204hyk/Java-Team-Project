package pos.gje.ReceiptCheck.receiptcheck_main.component;

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

public class RefundButton extends JButton implements ActionListener {
	ReceiptCheckFrame f1;
	RefundFrame f2;
	public RefundButton(ReceiptCheckFrame f1, RefundFrame f2) {
		this.f1 = f1;
		this.f2 = f2;
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/영수증 조회 이미지/환불 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(250, 80, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/영수증 조회 이미지/환불 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(250, 80, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		addActionListener(this);
		
		setEnabled(false);
		setBounds(900, 670, 250, 80); // 위치 및 사이즈 조절
		setContentAreaFilled(false);
		setBorderPainted(false); 
		setOpaque(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		f1.setEnabled(false);
		f2.setVisible(true);
	}

}
