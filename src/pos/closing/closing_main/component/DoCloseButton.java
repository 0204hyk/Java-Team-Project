package pos.closing.closing_main.component;

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
import pos.closing.closing_message.ClosingMessageFrame;

public class DoCloseButton extends JButton implements ActionListener{
	// 마감하기 버튼
	ClosingFrame mainFrame;
	ClosingMessageFrame frame;
	
	public DoCloseButton(ClosingFrame mainFrame, ClosingMessageFrame frame) {
		this.mainFrame = mainFrame;
		this.frame = frame;
		try {
			// 버튼에 이미지 삽입
			File f = new File("images/PosImages/마감 이미지/마감 버튼.png");
			BufferedImage bufferedImage = ImageIO.read(f);
			Image scaledImage = bufferedImage.getScaledInstance(300, 80, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setSize(300, 80);
			setContentAreaFilled(false);	// 버튼 배경 지우기
			setBorderPainted(false);	// 버튼 테두리 지우기
			setFocusable(false);	
			
			// 버튼 클릭 했을 때 변하는 이미지 삽입
			File f2 = new File("images/PosImages/마감 이미지/마감 버튼 클릭.png");
			BufferedImage bufferedImage2 = ImageIO.read(f2);
			Image scaledImage2 = bufferedImage2.getScaledInstance(300, 80, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage2 = new ImageIcon(scaledImage2);

			setPressedIcon(btnImage2);
			
			addActionListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(true);
		mainFrame.setEnabled(false);
	}
}
