package pos.main.main_component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.closing.closing_main.ClosingFrame;

public class ClosingButton extends JButton implements ActionListener{
	
	public ClosingButton() {
		try {
			File f = new File("images/PosImages/시작 페이지 버튼 이미지/마감 버튼.png");
			BufferedImage bufferedImage = ImageIO.read(f);
			Image scaledImage = bufferedImage.getScaledInstance(300, 300, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setSize(300, 300);
			setContentAreaFilled(false);	// 버튼 배경 지우기
			setBorderPainted(false);	// 버튼 테두리 지우기
			setFocusable(false);	
			
			File f2 = new File("images/PosImages/시작 페이지 버튼 이미지/마감 버튼 클릭.png");
			BufferedImage bufferedImage2 = ImageIO.read(f2);
			Image scaledImage2 = bufferedImage2.getScaledInstance(300, 300, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage2 = new ImageIcon(scaledImage2);

			setPressedIcon(btnImage2);
			
			addActionListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new ClosingFrame();
	}
	
}
