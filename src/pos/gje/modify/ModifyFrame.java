package pos.gje.modify;

import javax.swing.JFrame;

import pos.gje.modify.component.ModifyButton;
import pos.gje.modify.component.ModifyEscapeBtn;
import pos.gje.modify.panel.ModifyBackgroundImagePanel;

public class ModifyFrame extends JFrame{

	public ModifyFrame() {
		setTitle("ModifyFrame");
			
		add(new ModifyEscapeBtn(this));
		add(new ModifyButton(new CheckFrame()));
		add(new ModifyBackgroundImagePanel());
		
		setUndecorated(true);
		setSize(900, 550); // 프레임 사이즈
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
