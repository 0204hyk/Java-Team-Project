package pos.gje.modify;

import java.awt.Color;

import javax.swing.JFrame;

import pos.gje.modify.panel.CheckPanel;
import pos.gje.modify.panel.TitlePanel;
import pos.gje.modify.panel.listPanel;
import pos.gje.refund.RefundButton;

public class ModifyFrame {

	
	public ModifyFrame() {
		
	}
	
	public static JFrame mainFrame() {
		JFrame f = new JFrame("ModifyFrame"); // 수정창 메인 프레임 
		
		f.add(new RefundButton().closeBtn(f));
		f.add(new ModifyButton().modifyBtn());
		f.add(new TitlePanel());
		f.add(new listPanel());
		
		f.setUndecorated(true);
		f.getContentPane().setBackground(new Color(233, 236, 242)); // 배경색
		f.setSize(800, 480); // 프레임 사이즈
		f.setLayout(null); // 레이아웃
		f.setVisible(true); // 나타나게하기
		f.setResizable(false); // 크기 조절 안되게
		f.setLocationRelativeTo(null); // 가운데에 뜨게
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE); // 종료 했을 때
		
		return f;
	}
	
	
	public static JFrame checkFrame() {
		JFrame f = new JFrame("ModifyFrame");
		
		
		f.add(new ModifyButton().okBtn(f));
		f.add(new CheckPanel(f));
		
		f.setUndecorated(true); 
		f.getContentPane().setBackground(Color.WHITE); // 배경색
		f.setSize(400, 200); // 프레임 사이즈
		f.setLayout(null); // 레이아웃
		f.setVisible(true); // 나타나게하기
		f.setResizable(false); // 크기 조절 안되게
		f.setLocationRelativeTo(null); // 가운데에 뜨게
		
		return f;
	}
	public static void main(String[] args) {
		new ModifyFrame().mainFrame();
	

	}
}
