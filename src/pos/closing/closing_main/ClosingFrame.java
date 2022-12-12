package pos.closing.closing_main;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

import pos.ImageScaledTool;
import pos.closing.closing_main.component.ClosingEscapeButton;
import pos.closing.closing_main.component.DoCloseButton;
import pos.closing.closing_main.container.ClosingImagePanel;
import pos.closing.closing_main.container.EmptyLabel;
import pos.closing.closing_message.ClosingMessageFrame;

public class ClosingFrame extends JFrame {
	
	public ClosingFrame() {
		
		ClosingImagePanel titlePanel = new ClosingImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상단 메뉴바.png", 1200, 60));
		titlePanel.setBounds(0 ,0, 1200, 60);
//		titlePanel.add();
		
		ClosingImagePanel panelA = new ClosingImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/마감 이미지/현금 & 카드 결제 금액 확인 틀.png", 400, 100));
		panelA.setBounds(120, 80, 400, 100);
		
		EmptyLabel label1 = new EmptyLabel();
		label1.setLocation(265, 14);
		panelA.add(label1);
		
		EmptyLabel label2 = new EmptyLabel();
		label2.setLocation(265, 58);
		panelA.add(label2);


		ClosingImagePanel panelB = new ClosingImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/마감 이미지/현금 시제 기본 틀.png", 400, 430));
		panelB.setBounds(120, 230, 400, 430);
		
//		EmptyLabel[] labels = new EmptyLabel[8];
//		int locationY = 60;
//		for (int i = 0; i < 8; ++i) {
//			labels[i] = new EmptyLabel();
//			labels[i].setLocation(265, locationY);
//			panelB.add(labels[i]);
//			locationY += 46;
//		}
		
		EmptyLabel count50000 = new EmptyLabel();
		count50000.setLocation(265, 61);
		panelB.add(count50000);
		
		EmptyLabel count10000 = new EmptyLabel();
		count10000.setLocation(265, 107);
		panelB.add(count10000);
		
		EmptyLabel count1000 = new EmptyLabel();
		count1000.setLocation(265, 154);
		panelB.add(count1000);
		
		EmptyLabel count500 = new EmptyLabel();
		count500.setLocation(265, 200);
		panelB.add(count500);

		EmptyLabel count100 = new EmptyLabel();
		count100.setLocation(265, 247);
		panelB.add(count100);
		
		EmptyLabel count50 = new EmptyLabel();
		count50.setLocation(265, 293);
		panelB.add(count50);
		
		EmptyLabel count10 = new EmptyLabel();
		count10.setLocation(265, 340);
		panelB.add(count10);

		EmptyLabel countAll = new EmptyLabel();
		countAll.setLocation(265, 386);
		panelB.add(countAll);

		
		ClosingImagePanel panelC = new ClosingImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/마감 이미지/마감 내역 기본 틀.png", 500, 550));
		panelC.setBounds(600, 100, 500, 550);

		Calendar now = Calendar.getInstance();
		String date = "  " + now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) 
				+ "-" + now.get(Calendar.DAY_OF_MONTH); 
		JLabel dateLabel = new JLabel(date);
		dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		dateLabel.setBounds(10, 5, 200, 50);
		panelC.add(dateLabel);

		ClosingMessageFrame messageFrame = new ClosingMessageFrame();
		
		DoCloseButton doCloseBtn = new DoCloseButton(messageFrame);
		doCloseBtn.setLocation(800, 670);
		
		ClosingEscapeButton escapeBtn = new ClosingEscapeButton(this);
		escapeBtn.setLocation(80, 670);

		add(titlePanel);
		add(panelA);
		add(panelB);
		add(panelC);
		add(doCloseBtn);
		add(escapeBtn);
		
		
		setTitle("마감");
		setSize(1200, 800);
		getContentPane().setBackground(new Color(64, 64, 64));	// 프레임 백그라운드 컬러 설정
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
