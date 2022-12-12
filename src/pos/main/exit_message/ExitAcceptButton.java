package pos.main.exit_message;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ExitAcceptButton extends JButton implements ActionListener{
	
	public ExitAcceptButton() {
		try {
			File f = new File("images/PosImages/시작 페이지 버튼 이미지/로그아웃 확인 버튼.png");
			BufferedImage bufferedImage = ImageIO.read(f);
			Image scaledImage = bufferedImage.getScaledInstance(150, 75, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setOpaque(false);
			setContentAreaFilled(false);
			setBorderPainted(false);
			setSize(150, 75);
			setFocusable(false);
			
			File f2 = new File("images/PosImages/시작 페이지 버튼 이미지/로그아웃 확인 버튼 클릭.png");
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
		System.exit(0);
	}
	
}
