package pos.closing.closing_main;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.DigitalClock;
import pos.ImageScaledTool;
import pos.closing.closing_main.component.ClosingEscapeButton;
import pos.closing.closing_main.component.DoCloseButton;
import pos.closing.closing_main.container.ClosingImagePanel;
import pos.closing.closing_main.container.EmptyLabel;
import pos.closing.closing_message.ClosingMessageFrame;

public class ClosingFrame extends JFrame {
	// 마감 파트 프레임
	
	public ClosingFrame() {
		
		// 상단 메뉴바 설정
		JPanel titlePanel = new ClosingImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상단 메뉴바.png", 1200, 60));
		titlePanel.setBounds(0 ,0, 1200, 60);
		// 현재 시간 출력
		JLabel clock = new DigitalClock();
		clock.setBounds(375, 10, 400, 30);
		titlePanel.add(clock);
		
		// 결제 수단 이미지 패널
		JPanel panelA = new ClosingImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/마감 이미지/현금 & 카드 결제 금액 확인 틀.png", 400, 100));
		panelA.setBounds(120, 90, 400, 100);
		
		JLabel label1 = new EmptyLabel();
		label1.setLocation(265, 14);
		panelA.add(label1);
		
		JLabel label2 = new EmptyLabel();
		label2.setLocation(265, 58);
		panelA.add(label2);


		// 현금 시제 이미지 패널
		JPanel panelB = new ClosingImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/마감 이미지/현금 시제 기본 틀.png", 400, 430));
		panelB.setBounds(120, 220, 400, 430);
		
		EmptyLabel[] labels = new EmptyLabel[9];
		int locationY = 54;
		for (int i = 0; i < 9; ++i) {
			labels[i] = new EmptyLabel();
			labels[i].setLocation(265, locationY);
			panelB.add(labels[i]);
			locationY += 42;
		}
		
//		JLabel count50000 = new EmptyLabel();
//		count50000.setLocation(265, 54);
//		panelB.add(count50000);
//		
//		JLabel count10000 = new EmptyLabel();
//		count10000.setLocation(265, 96);
//		panelB.add(count10000);
//		
//		JLabel count5000 = new EmptyLabel();
//		count5000.setLocation(265, 138);
//		panelB.add(count5000);
//		
//		JLabel count1000 = new EmptyLabel();
//		count1000.setLocation(265, 154);
//		panelB.add(count1000);
//		
//		JLabel count500 = new EmptyLabel();
//		count500.setLocation(265, 200);
//		panelB.add(count500);
//
//		JLabel count100 = new EmptyLabel();
//		count100.setLocation(265, 247);
//		panelB.add(count100);
//		
//		JLabel count50 = new EmptyLabel();
//		count50.setLocation(265, 293);
//		panelB.add(count50);
//		
//		JLabel count10 = new EmptyLabel();
//		count10.setLocation(265, 340);
//		panelB.add(count10);
//
//		JLabel countAll = new EmptyLabel();
//		countAll.setLocation(265, 386);
//		panelB.add(countAll);

		
		// 마감 내역 이미지 패널
		JPanel panelC = new ClosingImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/마감 이미지/마감 내역 기본 틀.png", 500, 550));
		panelC.setBounds(600, 100, 500, 550);

		// 오늘 일자 출력
		Calendar now = Calendar.getInstance();
		String date = "  " + now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) 
				+ "-" + now.get(Calendar.DAY_OF_MONTH); 
		JLabel dateLabel = new JLabel(date);
		dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		dateLabel.setBounds(10, 5, 200, 50);
		panelC.add(dateLabel);

		// 마감하기 버튼 누르면 나오는 마감 확인 안내 프레임
		ClosingMessageFrame messageFrame = new ClosingMessageFrame(this);
		
		// 마감하기 버튼
		DoCloseButton doCloseBtn = new DoCloseButton(this ,messageFrame);
		doCloseBtn.setLocation(800, 670);
		
		// 뒤로가기 버튼
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
		setResizable(false);	// 사이즈 조절 불가능하게 만들기
		setLocationRelativeTo(null);	// 프레임 화면 가운데에 나오게 하기
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
