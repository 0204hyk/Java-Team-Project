package pos.salescheck.component.button;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import pos.ImageScaledTool;
import pos.salescheck.component.main.SalesDayCheckMain;
import pos.salescheck.component.main.SalesMonthCheckMain;
import pos.salescheck.component.main.SalesYearCheckMain;
import pos.salescheck.component.saleslist.TitlePanel;
import pos.salescheck.component.saleslist.TotalPanel;
import pos.salescheck.component.table.SalesDayTable;
import pos.salescheck.component.table.SalesMonthTable;
import pos.salescheck.component.table.SalesYearTable;

public class SalesEscapeButton extends JButton {

	SalesDayCheckMain dayFrame;
	SalesMonthCheckMain monthFrame;
	SalesYearCheckMain yearFrame;

	ImageScaledTool tool = new ImageScaledTool();

	public SalesEscapeButton(SalesYearCheckMain yearFrame) {
		this.yearFrame = yearFrame;
		// 매출요약 < 버튼 이미지 설정
		setIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/돌아가기 버튼.png", 180, 80)));

		// 매출요약 < 버튼 눌렀을 때
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/돌아가기 버튼 클릭.png", 180, 80)));

		// < 버튼 위치 지정
		setBounds(940, 670, 180, 80);
		setBorder(null);
		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);
		
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 버튼 클릭 시 기존 TitlePanel 값 초기화.
				TitlePanel panel = new TitlePanel();
				panel.text.setText("");
				SalesYearTable table = new SalesYearTable();
				table.model.setNumRows(0);
				TotalPanel total = new TotalPanel();
				total.text.setText("");
				yearFrame.dispose();
			}
		});
	}

	public SalesEscapeButton(SalesMonthCheckMain monthFrame) {
		this.monthFrame = monthFrame;
		// 매출요약 < 버튼 이미지 설정
		setIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/돌아가기 버튼.png", 180, 80)));

		// 매출요약 < 버튼 눌렀을 때
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/돌아가기 버튼 클릭.png", 180, 80)));

		// < 버튼 위치 지정
		setBounds(940, 670, 180, 80);
		setBorder(null);
		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 버튼 클릭 시 기존 TitlePanel 값 초기화.
				TitlePanel panel = new TitlePanel();
				panel.text.setText("");
				SalesMonthTable table = new SalesMonthTable();
				table.model.setNumRows(0);
				TotalPanel total = new TotalPanel();
				total.text.setText("");
				monthFrame.dispose();
			}
		});
	}

	public SalesEscapeButton(SalesDayCheckMain dayFrame) {
		this.dayFrame = dayFrame;
		// 매출요약 < 버튼 이미지 설정
		setIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/돌아가기 버튼.png", 180, 80)));

		// 매출요약 < 버튼 눌렀을 때
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/돌아가기 버튼 클릭.png", 180, 80)));

		// < 버튼 위치 지정
		setBounds(940, 670, 180, 80);
		setBorder(null);
		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼 클릭 시 기존 TitlePanel 값 초기화.
				TitlePanel panel = new TitlePanel();
				panel.text.setText("");
				SalesDayTable table = new SalesDayTable();
				table.model.setNumRows(0);
				TotalPanel total = new TotalPanel();
				total.text.setText("");
				dayFrame.dispose();
			}
		});
	}
}
