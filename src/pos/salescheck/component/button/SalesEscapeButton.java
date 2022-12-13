package pos.salescheck.component.button;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.salescheck.SalesCheckMainFrame;

public class SalesEscapeButton extends JButton implements ActionListener{
	SalesCheckMainFrame frame;
	
	public SalesEscapeButton(SalesCheckMainFrame frame) {
		this.frame = frame;
		// 매출요약 < 버튼 이미지 설정
		try {
			BufferedImage image = ImageIO.read(new File("Images/PosImages/매출 요약 이미지/돌아가기 버튼.png"));
			Image scale = image.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 매출요약 < 버튼 눌렀을 때
		try {
			BufferedImage image = ImageIO.read(new File("Images/PosImages/매출 요약 이미지/돌아가기 버튼 클릭.png"));
			Image click = image.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
			setPressedIcon(new ImageIcon(click));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// < 버튼 위치 지정
		setBounds(1050, 700, 100, 50);
		setBorder(null);
		
		
		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}
}
