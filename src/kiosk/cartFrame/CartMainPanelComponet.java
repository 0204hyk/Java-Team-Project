package kiosk.cartFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.tools.javac.Main;

public class CartMainPanelComponet {

	

	//결제정보창 메뉴 번호
	public JLabel number() {

		JLabel label = new JLabel();
		try {
			BufferedImage numberBufferedImage = ImageIO.read(new File("images/KioskImages/3_메뉴선택/Scaled1.png"));
			label.setIcon(new ImageIcon(numberBufferedImage));

			label.setPreferredSize(new Dimension(30, 30));

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return label;
	}

	// 메뉴정보
	public JLabel menu() {
		JLabel label = new JLabel();
		Font menuFont = new Font("맑은 고딕", Font.BOLD, 18);
		String text = "카페라떼(ICE) / 1잔 / 3,500원";

		label.setText(String.format("%-35s", text));
		label.setFont(menuFont);

		return label;
	}

	// 메뉴아래 옵션정보
	public JLabel option() {
		JLabel label = new JLabel();
		String text = "ㄴ 아이스 / S / 텀블러사용 / 1샷추가 / 우유(기본)";

		Font font = new Font("맑은 고딕", Font.PLAIN, 15);
		label.setForeground(new Color(182, 186, 184));
		label.setFont(font);

		label.setText(String.format("%42s", text));

		return label;
	}

	//주문정보창 배경화면
	public JLabel imageLabel() {
		JLabel label = new JLabel();
		try {
			BufferedImage backgroundBufferedImage = ImageIO
					.read(new File("images/KioskImages/7_주문정보_확인/cartMainPanelScaled.png"));
			label.setIcon(new ImageIcon(backgroundBufferedImage));

		} catch (Exception e) {
			// TODO: handle exception
		}

		label.setBounds(70, 230, 490, 370);

		return label;
	}

}
