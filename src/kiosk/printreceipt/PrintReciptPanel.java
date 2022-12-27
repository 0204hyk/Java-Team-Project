package kiosk.printreceipt;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class PrintReciptPanel extends JPanel {

	String root = "images/KioskImages/7_1. 영수증 출력 여부, 카드, 결제완료";
	WithImage wi = new WithImage(root);

	public PrintReciptPanel() {
		setImage();
		noPrintButton();
		printButton();

	}

	public void setImage() {
		JLabel lb = wi.makeLabel("receipt.png", 120, 53, 414, 301);

//		lb.setHorizontalAlignment(JLabel.CENTER);
		add(lb);
	}

	public void noPrintButton() {
		JButton bt = wi.makeButton("noPrint.png", 408, 288, 97, 46);
		add(bt);
	}

	public void printButton() {
		JButton bt = wi.makeButton("print.png", 295, 288, 97, 46);
		add(bt);
	}

}
