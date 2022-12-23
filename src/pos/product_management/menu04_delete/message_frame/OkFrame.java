package pos.product_management.menu04_delete.message_frame;

import java.awt.Color;

import javax.swing.JFrame;

import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu04_delete.message_frame.component.CompletionBtn;

public class OkFrame extends JFrame{

	public OkFrame(ProductManagementJFrame mainFrame) {
		
		add (new CompletionBtn(mainFrame, this));
		add(new OkPanel());
		
		setSize(400, 200); // 프레임 사이즈
		setLayout(null); 
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
//		setVisible(true); 
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}
	
}
