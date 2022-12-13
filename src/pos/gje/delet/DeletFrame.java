package pos.gje.delet;

import javax.swing.JFrame;

import pos.gje.delet.panel.DeletCheckPanel;
import pos.gje.delet.panel.OkPanel;

public class DeletFrame {
	
	public DeletFrame() {
		// TODO Auto-generated constructor stub
	}
	
	public static JFrame firstFrame () {
		JFrame f = new JFrame("POS");
		
		f.add(new DeletBtn().ok());
		f.add(new DeletBtn().cancel(f));
		f.add(new DeletCheckPanel());
		
		f.setUndecorated(true); 
		f.setSize(500, 251); // 프레임 사이즈
		f.setLayout(null); 
		f.setVisible(true); 
		//f.setResizable(false); // 크기 조절 안되게
		f.setLocationRelativeTo(null); // 가운데에 뜨게
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE); 
		
		return f;
		
	} 
	
	public static JFrame okFrame () {
		JFrame f = new JFrame("POS");
		
		f.add (new DeletBtn().Completion(f));
		f.add(new OkPanel());
		
		f.setUndecorated(true); 
		f.setSize(400, 200); // 프레임 사이즈
		f.setLayout(null); 
		f.setVisible(true); 
		f.setResizable(false); // 크기 조절 안되게
		f.setLocationRelativeTo(null); // 가운데에 뜨게
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE); 
		
		return f;
	}
	
	public static void main(String[] args) {
		new DeletFrame().firstFrame();
		
	}

}
