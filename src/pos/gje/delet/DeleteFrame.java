package pos.gje.delet;

import javax.swing.JFrame;

import pos.gje.delet.component.CancelBtn;
import pos.gje.delet.component.OkBtn;
import pos.gje.delet.panel.DeleteCheckPanel;

public class DeleteFrame extends JFrame{
	
	public DeleteFrame() {
		add(new OkBtn(this));
		add(new CancelBtn(this));
		add(new DeleteCheckPanel());
		
		setUndecorated(true); 
		setSize(500, 251);
		setLayout(null); 
		setVisible(true); 
		setResizable(false); 
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new DeleteFrame();
		
	}


}
