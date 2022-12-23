package kiosk.printReceipt;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class PrintReceiptFrame extends JFrame {
	String root = "images/KioskImages/7_1. 영수증 출력 여부, 카드, 결제완료";
	WithImage wi = new WithImage(root);

	public PrintReceiptFrame() {
		noPrintButton();
		printButton();
		setImage();
		setDisplay();
		setLayout(null);

	}

	public void setDisplay() {

//		 setUndecorated(true);

		setSize(420, 315);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void setImage() {
		JLabel lb = wi.makeLabel("receipt.png", 0, 0, 414, 301);

		add(lb);
	}

	public void noPrintButton() {
		JButton bt = wi.makeButton("noPrint.png", 287, 234, 97, 46);
		add(bt);
	}

	public void printButton() {
		JButton bt = wi.makeButton("print.png", 174, 234, 97, 46);
		add(bt);
	}

	public static void main(String[] args) {
		new PrintReceiptFrame();
	}

}
