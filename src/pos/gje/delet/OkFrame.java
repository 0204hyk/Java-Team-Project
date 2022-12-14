package pos.gje.delet;

import java.awt.Color;

import javax.swing.JFrame;

import pos.gje.delet.component.CompletionBtn;
import pos.gje.delet.panel.OkPanel;

public class OkFrame extends JFrame{

	
	public OkFrame() {
	
		
		add (new CompletionBtn(this));
		add(new OkPanel());
		
		setUndecorated(true); 
		setSize(400, 200); // 프레임 사이즈
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null); 
		setVisible(true); 
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}


}
