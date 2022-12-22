package kiosk;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import kiosk.tools.WithImage;

public class Test {

	public static void main(String[] args) {
		String root = "images/KioskImages/3. 메뉴선택/";
		WithImage wi = new WithImage(root);

		JFrame frame = new JFrame();

		JPanel panel = new JPanel();

		panel.add(new JLabel("모임?"));
		panel.add(new JLabel("모임?"));
		panel.add(new JLabel("모임?"));
		panel.add(new JLabel("모임?"));
		
		JScrollPane scrollable = new JScrollPane();


		scrollable.setViewportView(panel); // 판

		frame.add(scrollable); // 스크롤
		frame.setSize(600, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
