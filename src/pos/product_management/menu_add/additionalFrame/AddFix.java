package pos.product_management.menu_add.additionalFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import pos.ImagePanel;
import pos.ImageScaledTool;
import pos.kjh.ProductManagementJFrame;
import pos.product_management.menu_add.MenuAddFrame;

public class AddFix extends JFrame {

	JScrollPane scrollPane;
	ImageIcon icon;
	
	ProductManagementJFrame prjf;
	MenuAddFrame menuAddFrame;
	
	public JButton AddFixButton() throws IOException {
		JButton addFixBtn = prjf.btnImage("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png", 
				"images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png", 140,110,120,60);
		addFixBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				menuAddFrame.nameField.setText(null);
				menuAddFrame.priceField.setText(null);
			}
		});
		
		return addFixBtn;
	}
	
	public AddFix(MenuAddFrame menuAddFrame) throws IOException {
		this.menuAddFrame = menuAddFrame;
		
		JPanel background = new ImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상품 관리 이미지/메뉴 추가 완료 안내 창.png", 400, 200));
		
		background.add(AddFixButton());	
		
		add(background);
		
		setSize(400, 200);
		setResizable(false);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));	// 패널 배경 투명하게 하기
		setLocationRelativeTo(null);

	}
}
