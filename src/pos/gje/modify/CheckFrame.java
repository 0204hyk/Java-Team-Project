package pos.gje.modify;

import java.awt.Color;

import javax.swing.JFrame;

import pos.gje.modify.component.OkBtn;
import pos.gje.modify.panel.CheckPanel;

public class CheckFrame extends JFrame{
	
	public CheckFrame() {

		
		
		add(new OkBtn(this));
		add(new CheckPanel());
		
		setUndecorated(true); // 타이틀바 없애기
		getContentPane().setBackground(Color.white); // 배경색
		setBackground(new Color(0, 0, 0, 0));	// 패널 배경 투명하게 하기
		setSize(400, 200); // 프레임 사이즈
		setLayout(null); // 레이아웃
//		setVisible(true); // 나타나게하기
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		

	}
	public static void main(String[] args) {
		new CheckFrame();
	}
}
