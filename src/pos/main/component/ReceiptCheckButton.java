package pos.main.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ReceiptCheckButton extends JButton implements ActionListener{
	
	public ReceiptCheckButton() {
		try {
			File f = new File("PosImages/시작 페이지 버튼 이미지/영수증 조회 버튼.png");
			BufferedImage bufferedImage = ImageIO.read(f);
			Image scaledImage = bufferedImage.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setSize(300, 300);
			setContentAreaFilled(false);	// 버튼 배경 지우기
			setBorderPainted(false);	// 버튼 테두리 지우기
			setFocusable(false);	
			addActionListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
