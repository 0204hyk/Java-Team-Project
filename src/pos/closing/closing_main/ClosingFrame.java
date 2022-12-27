package pos.closing.closing_main;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import pos.closing.closing_main.component.ClosingEscapeButton;
import pos.closing.closing_main.component.ClosingTable;
import pos.closing.closing_main.component.DailySalesLabel;
import pos.closing.closing_main.component.DoCloseButton;
import pos.closing.closing_message.ClosingMessageFrame;
import pos.util.DigitalClock;
import pos.util.ImagePanel;
import pos.util.ImageScaledTool;

public class ClosingFrame extends JFrame {
	// 마감 파트 프레임
	
	// 마감하기 버튼
	public DoCloseButton doCloseBtn;
	
	public ClosingFrame() {
		
		// 상단 메뉴바 설정
		JPanel titlePanel = new ImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상단 메뉴바.png", 1200, 60));
		titlePanel.setBounds(0 ,0, 1200, 60);
		// 현재 시간 출력
		JLabel clock = new DigitalClock();
		clock.setBounds(375, 10, 400, 30);
		titlePanel.add(clock);

		JPanel panelC = new ImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/마감 이미지/마감 내역 기본 틀2.png", 1000, 550));
		panelC.setBounds(100, 100, 1000, 550);
		
		// 시간대별 매출 테이블
		ClosingTable closingTable = new ClosingTable();
		JScrollPane tablePanel = new JScrollPane(closingTable);
		tablePanel.setBounds(3, 55, 988, 435);
		
		// 총 금액 라벨
		DailySalesLabel totalLabel = new DailySalesLabel();
		totalLabel.setLocation(620, 498);
		
		panelC.add(tablePanel);
		panelC.add(totalLabel);
		
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
		doCloseBtn = new DoCloseButton(this ,messageFrame);
		doCloseBtn.setLocation(800, 670);
		
		// 뒤로가기 버튼
		ClosingEscapeButton escapeBtn = new ClosingEscapeButton(this);
		escapeBtn.setLocation(80, 670);

		
		add(titlePanel);
//		add(panelA);
//		add(panelB);
		add(panelC);
		add(doCloseBtn);
		add(escapeBtn);
		
		setUndecorated(true);
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
