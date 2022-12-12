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

public class ClosingEscapeButton extends JButton implements ActionListener {
	// 마감 파트 뒤로가기 버튼
	
	ClosingFrame frame;
	
	public ClosingEscapeButton(ClosingFrame frame) {
		this.frame = frame;
		try {
			// 버튼에 이미지 삽입
			File f = new File("images/PosImages/마감 이미지/돌아가기 버튼.png");
			BufferedImage bufferedImage = ImageIO.read(f);
			Image scaledImage = bufferedImage.getScaledInstance(180, 80, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setSize(180, 80);
			setContentAreaFilled(false);	// 버튼 배경 지우기
			setBorderPainted(false);	// 버튼 테두리 지우기
			setFocusable(false);	
			
			// 버튼 클릭 했을 때 변하는 이미지 삽입
			File f2 = new File("images/PosImages/마감 이미지/돌아가기 버튼 클릭.png");
			BufferedImage bufferedImage2 = ImageIO.read(f2);
			Image scaledImage2 = bufferedImage2.getScaledInstance(180, 80, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage2 = new ImageIcon(scaledImage2);
			setPressedIcon(btnImage2);			
			
			addActionListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 마감 창 닫기
		frame.dispose();
	}

}

