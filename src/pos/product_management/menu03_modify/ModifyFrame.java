package pos.product_management.menu03_modify;

import javax.swing.JFrame;

import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu03_modify.component.ModifyEscapeBtn;
import pos.product_management.menu03_modify.component.ModifyOKButton;
import pos.product_management.menu03_modify.message_frame.ModifyMessageFrame;
import pos.product_management.menu03_modify.panel.ModifyBackgroundImagePanel;

public class ModifyFrame extends JFrame{
	
	public ModifyBackgroundImagePanel panel;
	public ModifyOKButton modifyOkBtn;
	
	public ModifyFrame(ProductManagementJFrame mainFrame) {
		
		panel = new ModifyBackgroundImagePanel();
		
		modifyOkBtn = new ModifyOKButton(mainFrame, this, new ModifyMessageFrame(mainFrame, this), panel);

		add(new ModifyEscapeBtn(mainFrame, this));
		add(modifyOkBtn);
		add(panel);
		
		setUndecorated(true);
		setSize(900, 550); // 프레임 사이즈
		setLayout(null); // 레이아웃
		setVisible(true); // 나타나게하기
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료 했을 때
	}
	
}
