package kiosk.printReceipt;

import javax.swing.JFrame;

public class PrintReceiptFrame extends JFrame{

	
	public PrintReceiptFrame() {
		add(new PrintReciptPanel());
		setDisplay();

	}
	
	
	public void setDisplay() {
		

		//setUndecorated(true); 

		setVisible(true);
		setSize(420, 315);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	
	public static void main(String[] args) {
		new PrintReceiptFrame();
	}

}
