package pos.salescheck.component.saleslist;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 매출요약 테이블 타이틀

public class TitlePanel extends JPanel {

	String year;
	String month;
	String day;

	public static JLabel text = new JLabel();

	public TitlePanel() {

		setBounds(710, 180, 315, 45);
		setBackground(new Color(16, 41, 64));
		add(text);
	}

	// 매출 테이블 타이틀 년 생성
	public TitlePanel(String year) {
		this.year = year;

		text.setText(year + "년");
		text.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		text.setForeground(Color.WHITE);
	}

	// 매출 테이블 타이틀 년, 월 생성
	public TitlePanel(String year, String month) {
		this.year = year;
		this.month = month;

		text.setText(year + "년 " + month + "월 ");
		text.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		text.setForeground(Color.WHITE);
	}

	// 매출 테이블 타이틀 년, 월, 일 생성
	public TitlePanel(String year, String month, String day) {
		this.year = year;
		this.month = month;
		this.day = day;

		text.setText(year + "년 " + month + "월 " + day + "일");
		text.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		text.setForeground(Color.WHITE);
	}
}
