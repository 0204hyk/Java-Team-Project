package pos.product_management.menu_modify;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import pos.gje.modify.CheckFrame;
import pos.kjh.ProductManagementJFrame;
import pos.product_management.menu_modify.component.ModifyEscapeBtn;
import pos.product_management.menu_modify.component.ModifyOKButton;
import pos.product_management.menu_modify.panel.ModifyBackgroundImagePanel;

public class ModifyFrame extends JFrame{
	
	ProductManagementJFrame mainFrame;
	public ModifyBackgroundImagePanel panel;
	
	public JTextField nameField;
	public JFormattedTextField priceField;
	
	public ModifyFrame(ProductManagementJFrame mainFrame) {
		this.mainFrame = mainFrame;
		setTitle("메뉴 수정");
		
		panel = new ModifyBackgroundImagePanel();
		
		nameField = new JTextField();
		nameField.setBounds(190, 105, 700, 49);
		nameField.setOpaque(false);
		nameField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		priceField = new JFormattedTextField(new NumberFormatter());
		priceField.setBounds(190, 213, 700, 49);
		priceField.setOpaque(false);
		priceField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		priceField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		add(new ModifyEscapeBtn(mainFrame, this));
		add(new ModifyOKButton(new CheckFrame()));
		add(nameField);
		add(priceField);
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
