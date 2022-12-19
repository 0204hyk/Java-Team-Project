package pos.salescheck.component.button;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.ImageScaledTool;
import pos.salescheck.component.main.SalesDayCheckMain;
import pos.salescheck.component.main.SalesMonthCheckMain;
import pos.salescheck.component.main.SalesYearCheckMain;

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
				dayFrame.dispose();

			}
		});
	}


}
