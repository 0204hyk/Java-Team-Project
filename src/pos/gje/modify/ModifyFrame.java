package pos.gje.modify;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.DigitalClock;
import pos.ImageScaledTool;
import pos.closing.closing_main.container.ClosingImagePanel;
import pos.gje.modify.panel.TitlePanel;
import pos.gje.modify.panel.listPanel;

public class ModifyFrame extends JFrame{

	
	public ModifyFrame() {
		setTitle("ModifyFrame");
			
		add(new ModifyButton().modifyBtn());
		add(new TitlePanel());
		add(new listPanel());
		
		setUndecorated(true);
		getContentPane().setBackground(new Color(233, 236, 242)); // 배경색
		setSize(800, 480); // 프레임 사이즈
		setLayout(null); // 레이아웃
		setVisible(true); // 나타나게하기
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료 했을 때
	}
	
	public static void main(String[] args) {
		new ModifyFrame();
	

	}
}