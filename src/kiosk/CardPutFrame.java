package kiosk;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import kiosk.tools.WithImage;

public class CardPutFrame extends JFrame {

	String root = "images/KioskImages/7_1. 영수증 출력 여부, 카드, 결제완료";
	WithImage wi = new WithImage(root);

	public CardPutFrame() {
		add(wi.makeLabel("inputCard.png", 120, 379, 414, 301));
		setDisplay();

	}

	public void setDisplay() {

		 setUndecorated(true);
		setVisible(true);
		setSize(434, 320);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {

		new CardPutFrame();
	}
}
