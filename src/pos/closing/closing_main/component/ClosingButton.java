package pos.closing.closing_main.component;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ClosingButton extends JButton implements ActionListener{
	public ClosingButton() {
		try {
			File f = new File("PosImages/포스기 이미지 png/마감 이미지/마감 버튼.png");
			BufferedImage bufferedImage = ImageIO.read(f);
			Image scaledImage = bufferedImage.getScaledInstance(300, 80, Image.SCALE_DEFAULT);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setBounds(800, 660, 300, 80);
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
		System.out.println("마감 버튼 기능 구현 X");
	}
}
