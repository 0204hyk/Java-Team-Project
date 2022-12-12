package pos.gje.ReceiptCheck.refund.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CheckButton extends JButton implements ActionListener{

	public CheckButton() {
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/영수증 조회 이미지/영수증 출력 여부 체크.png"));
			Image scaledImage = bufferedImage.getScaledInstance(56, 48, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		setBounds(25, 430, 56, 48);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);
		addActionListener(this);
		
	}
	
	int num = 1;
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			++num;
			System.out.println(num);
			if (num % 2 == 0) {	
				System.out.println("영수증을 출력합니다.");
				BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/영수증 조회 이미지/영수증 출력 여부 체크 완.png"));
				Image scaledImage = bufferedImage.getScaledInstance(56, 63, Image.SCALE_SMOOTH); // 크기 조정
				setIcon(new ImageIcon(scaledImage));
			} else {
				BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/영수증 조회 이미지/영수증 출력 여부 체크.png"));
				Image scaledImage = bufferedImage.getScaledInstance(56, 48, Image.SCALE_SMOOTH); // 크기 조정
				setIcon(new ImageIcon(scaledImage));
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}  
	}

}
