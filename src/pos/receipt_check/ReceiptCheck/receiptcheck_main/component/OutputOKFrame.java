package pos.receipt_check.ReceiptCheck.receiptcheck_main.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import pos.WithImage;
import pos.receipt_check.ReceiptCheck.receiptcheck_main.ReceiptCheckFrame;


public class OutputOKFrame extends JFrame{

	String root = "images/PosImages/영수증 조회 이미지/";
	WithImage wi = new WithImage(root);

	Timer timer;
	public OutputOKFrame() {
		
		JLabel lb = wi.makeLabel("영수증 출력 확인", 0, 0, 500, 250);
		add(lb);
		
		setUndecorated(true);
		
		timer = new Timer(700, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		timer.start();
		
		
		setSize(490, 240);
		setLayout(null); 
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setVisible(true);

		
	
	
	}

}
