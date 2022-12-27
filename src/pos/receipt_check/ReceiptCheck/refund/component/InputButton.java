package pos.receipt_check.ReceiptCheck.refund.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InputButton extends JButton implements ActionListener{
	public InputButton() {
		
		try {

			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/영수증 조회 이미지/카드번호 & 현금 영수증 란 입력 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(78, 48, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/영수증 조회 이미지/카드번호 및 현금 영수증용 입력 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(78, 48, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			
			setPressedIcon(img);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		
		setBounds(296, 370, 78, 48);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("기능 구현 X");
	}
}
