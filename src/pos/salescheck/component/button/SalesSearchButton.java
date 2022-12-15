package pos.salescheck.component.button;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import pos.ImageScaledTool;
import pos.salescheck.component.datecombo1.DayComboBox;
import pos.salescheck.component.datecombo1.MonthComboBox;
import pos.salescheck.component.datecombo1.YearComboBox;
import pos.salescheck.component.table.SalesTable;

public class SalesSearchButton extends JButton {

	ImageScaledTool tool = new ImageScaledTool();

	
	JComboBox yearBox;
	JComboBox monthBox;
	JComboBox dayBox;

	String year;
	
	public SalesSearchButton() {
	}

	public SalesSearchButton(JComboBox yearBox, JComboBox monthBox, JComboBox dayBox) {
		this.yearBox = yearBox;
		this.monthBox = monthBox;
		this.dayBox = dayBox;
		
		// 매출요약 검색 버튼 이미지 설정.
		setIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/날짜 검색 버튼.png", 100, 50)));

		// 매출요약 검색 버튼 눌렀을 때 설정.
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/매출 요약 이미지/날짜 검색 버튼 클릭.png", 100, 50)));


		// 검색버튼 위치 설정.

		setBounds(450, 90, 100, 50);
		setBorder(null);
		
		addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				
				year = yearBox.getSelectedItem().toString();
				
				monthBox.getSelectedItem().toString();
				dayBox.getSelectedItem().toString();
				
			}
		});
		
		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);	

	}
}
