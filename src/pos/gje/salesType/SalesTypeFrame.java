package pos.gje.salesType;

import javax.swing.JFrame;

import pos.gje.delet.DeletBtn;
import pos.gje.delet.panel.OkPanel;

public class SalesTypeFrame {
	
	
	public static JFrame mainFrame() {
		
		JFrame f = new JFrame("POS");
		
		f.add(new SalesTypeBtn().day());
		f.add(new SalesTypeBtn().month());
		f.add(new SalesTypeBtn().year());
		
		f.setUndecorated(true); // 타이틀바 없애기
		f.setSize(1200, 800); // 프레임 사이즈
		f.setLayout(null); 
		f.setVisible(true); 
		f.setResizable(false); // 크기 조절 안되게
		f.setLocationRelativeTo(null); // 가운데에 뜨게
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE); 
		
		return f;
	}
	
	public static void main(String[] args) {
		new SalesTypeFrame().mainFrame();
	}

}
