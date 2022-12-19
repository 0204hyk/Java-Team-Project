package pos.gje.modify;

import javax.swing.JFrame;

import pos.gje.modify.component.ModifyEscapeBtn;
import pos.gje.modify.component.ModifyOKButton;
import pos.gje.modify.panel.ModifyBackgroundImagePanel;
import pos.kjh.ProductManagementJFrame;

public class ModifyFrame extends JFrame{
	ProductManagementJFrame mainFrame;
	public ModifyBackgroundImagePanel panel;
	
	public ModifyFrame(ProductManagementJFrame mainFrame) {
		this.mainFrame = mainFrame;
		setTitle("ModifyFrame");
		
		panel = new ModifyBackgroundImagePanel();
		
		add(new ModifyEscapeBtn(mainFrame, this));
		add(new ModifyOKButton(new CheckFrame()));
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
