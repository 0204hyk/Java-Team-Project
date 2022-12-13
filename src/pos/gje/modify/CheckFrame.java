package pos.gje.modify;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.DigitalClock;
import pos.ImageScaledTool;
import pos.closing.closing_main.container.ClosingImagePanel;
import pos.gje.modify.panel.CheckPanel;

public class CheckFrame extends JFrame{
	
	public CheckFrame() {

		
		
		add(new ModifyButton().okBtn(this));
		add(new CheckPanel());
		
		setUndecorated(true); 
		getContentPane().setBackground(Color.WHITE); // 배경색
		setSize(400, 200); // 프레임 사이즈
		setLayout(null); // 레이아웃
		setVisible(true); // 나타나게하기
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		

	}
	public static void main(String[] args) {
	
	}
}
