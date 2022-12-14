package pos.salescheck.component.button;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.ImageScaledTool;

public class SalesSearchButton extends JButton {

	ImageScaledTool tool = new ImageScaledTool();
	
	public SalesSearchButton() {
		
		// 매출요약 검색 버튼 이미지 설정.
		setIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/날짜 검색 버튼.png", 100, 50)));

		// 매출요약 검색 버튼 눌렀을 때 설정.
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/매출 요약 이미지/날짜 검색 버튼 클릭.png", 100, 50)));


		// 검색버튼 위치 설정.

		setBounds(450, 90, 100, 50);
		setBorder(null);
		
		
		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);	

	}
}
