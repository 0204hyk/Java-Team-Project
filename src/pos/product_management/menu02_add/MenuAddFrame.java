package pos.product_management.menu02_add;

import javax.swing.JFrame;

import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu02_add.panel.AddBackgroundImagePanel;

public class MenuAddFrame extends JFrame{
	
	public AddBackgroundImagePanel panel;
	
	public MenuAddFrame(ProductManagementJFrame mainFrame) {
		panel = new AddBackgroundImagePanel(mainFrame, this);
		add(panel);
		
		setUndecorated(true);
		setSize(900, 550); // 프레임 사이즈
		setLayout(null); // 레이아웃
		setVisible(true); // 나타나게하기
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		
	}
}
