package pos.product_management.menu02_add.message_frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu02_add.MenuAddFrame;
import pos.util.ImagePanel;
import pos.util.ImageScaledTool;

public class MenuNameInput extends JFrame{
	
	ProductManagementJFrame prjf;
	
	public MenuNameInput(MenuAddFrame frame) {
		
		JPanel background = new ImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상품 관리 이미지/메뉴 입력 경고창.png", 400, 200));

		JButton addFixBtn = prjf.btnImage("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png", 
				"images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png", 140,110,120,60);
		addFixBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.panel.menuAddBtn.setEnabled(true);
				frame.setEnabled(true);
				dispose();
			}
		});
		background.add(addFixBtn);	

		add(background);

		setSize(400, 200);
		setResizable(false);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));	// 패널 배경 투명하게 하기
		setLocationRelativeTo(null);

	}
	
}
