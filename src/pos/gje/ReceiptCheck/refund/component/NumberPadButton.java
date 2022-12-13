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

public class NumberPadButton extends JButton implements ActionListener{

	public NumberPadButton(int num) {
		int x = 300, y = 80;
		
		String root = "images/PosImages/영수증 조회 이미지/새 폴더/";
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File(root + num + ".png"));
			Image scaledImage = bufferedImage.getScaledInstance(90, 95, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File(root + num + " 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(90, 95, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			setPressedIcon(img);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if (num >= 5 && num <= 8) {
			x = 300;
			y += 100;
			num -= 4;
		} else if (num > 8 && num < 13) {
			x = 300;
			y += 100 * 2;
			num -= 8;
		} else if (num > 12) {
			x = 300;
			y += 100 * 3;
			num -= 12;
		}
		
		x += num * 95;
		
		setBounds(x, y, 90, 95);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("기능 구현 X");
	}

}
