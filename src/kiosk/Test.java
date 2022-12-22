package kiosk;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import kiosk.byoption.Cups;
import kiosk.menupan.AMenu;
import kiosk.tools.WithImage;

public class Test {

	public static void main(String[] args) {
		String root = "images/KioskImages/3. 메뉴선택/";
		WithImage wi = new WithImage(root);

		JFrame frame = new JFrame();
		
		
		JPanel original = new JPanel();

//		JLabel bg = wi.makeLabel("wholeMenu.png", 0,0,500,500);
		
		JPanel panel = new JPanel();
		JScrollPane scrollablePane = new JScrollPane();
		// 프레임 + 패널 + 패널 (카트) + 패널(메뉴) + 스크롤

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

//		for (int i = 0; i < 9; i++) {
//			JPanel a = new JPanel(); //메뉴
//			a.setBackground(Color.BLACK);
//			a.setPreferredSize(new Dimension(300, 100)); // 상관없다
//			panel.add(a); //카트
//			panel.add(Box.createVerticalStrut(10));
//		}
		
		
		JPanel a = new AMenu("아메리카노", new Cups(),"ICE", 2000);
		a.setSize(505, 41);
		a.setBackground(Color.white);
		a.setOpaque(false);
		panel.add(a);
//		JPanel b = new AMenu("아메리카노", new Cups(),"ICE");
//		panel.add(b);
//		JPanel c = new AMenu("아메리카노", new Cups(),"ICE");
//		panel.add(c);
		
		scrollablePane.setViewportView(original); // 판
		
		original.add(panel); // 메뉴판
		frame.add(scrollablePane); // 스크롤
		frame.setSize(600, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

