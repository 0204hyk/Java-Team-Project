package pos.product_management.menu04_delete;

import java.awt.Color;

import javax.swing.JFrame;

import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu04_delete.component.CancelBtn;
import pos.product_management.menu04_delete.component.OkBtn;
import pos.product_management.menu04_delete.message_frame.OkFrame;

public class DeleteFrame extends JFrame{
	
	public DeleteFrame(ProductManagementJFrame mainFrame) {
		
		add(new OkBtn(mainFrame, this, new OkFrame(mainFrame)));
		add(new CancelBtn(mainFrame, this));
		add(new DeleteCheckPanel());
		
		setSize(500, 250);
		setLayout(null); 
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		setVisible(true); 
		setResizable(false); 
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
