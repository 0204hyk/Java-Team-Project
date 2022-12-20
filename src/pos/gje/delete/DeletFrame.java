package pos.gje.delete;

import javax.swing.JFrame;

import pos.gje.delete.component.CancelBtn;
import pos.gje.delete.component.OkBtn;
import pos.gje.delete.panel.DeleteCheckPanel;

public class DeletFrame extends JFrame{
	
	public DeletFrame() {
		add(new OkBtn(this));
		add(new CancelBtn(this));
		add(new DeleteCheckPanel());
		
		setUndecorated(true); 
		setSize(500, 251); // 프레임 사이즈
		setLayout(null); 
		setVisible(true); 
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new DeletFrame();
		
	}


}
