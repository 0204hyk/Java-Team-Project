package kiosk;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import kiosk.tools.WithImage;

public class Test {

	public static void main(String[] args) {
		String root = "images/KioskImages/3. 메뉴선택/";
		WithImage wi = new WithImage(root);

		// 프레임 + 패널 +스크롤임
		JFrame frame = new JFrame();
		JPanel oiginal = new JPanel();
		JPanel panel = new JPanel();
		JScrollPane scrollable = new JScrollPane();

//		패널을 만들어서 들어갈수밖에없다 (레이아웃을 적ㅊ용해야됨)
//		panel.setLayout(null);
		int y = 0;
		
		for (int i = 0; i < 100; ++i) {
			JLabel b = new JLabel("???");
			b.setLocation(0, y);
			b.setPreferredSize(new Dimension(100,50));
			y += 10;

		}


//		scrollable.setBounds(0, 0, 300, 200);
		
		oiginal.add(panel);
		frame.add(scrollable); // 스크롤
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
