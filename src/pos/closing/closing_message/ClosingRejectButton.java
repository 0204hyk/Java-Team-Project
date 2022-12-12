package pos.closing.closing_message;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ClosingRejectButton extends JButton implements ActionListener{
	// 마감 확인 안내 프레임의 "아니오" 버튼
	ClosingMessageFrame frame;
	
	public ClosingRejectButton(ClosingMessageFrame frame) {
		this.frame = frame;
		// 버튼에 이미지 삽입
		try {
			File f = new File("images/PosImages/마감 이미지/안내창 - 아니요.png");
			BufferedImage bufferedImage = ImageIO.read(f);
			Image scaledImage = bufferedImage.getScaledInstance(150, 75, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setOpaque(false);
			setContentAreaFilled(false);
			setBorderPainted(false);
			setSize(150, 75);
			setFocusable(false);

			// 버튼 클릭 했을 때 변하는 이미지 삽입
			File f2 = new File("images/PosImages/마감 이미지/안내창 - 아니요 클릭.png");
			BufferedImage bufferedImage2 = ImageIO.read(f2);
			Image scaledImage2 = bufferedImage2.getScaledInstance(150, 75, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage2 = new ImageIcon(scaledImage2);
			setPressedIcon(btnImage2);

			addActionListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
	}

}
