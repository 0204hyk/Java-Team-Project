package pos.product_management.menu04_delete.notselected_frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pos.ImagePanel;
import pos.ImageScaledTool;
import pos.product_management.menu01_main.ProductManagementJFrame;

public class NotSelectedFrame extends JFrame{

	ProductManagementJFrame mainFrame;
	JButton ok;

	public NotSelectedFrame(ProductManagementJFrame mainFrame) {
		this.mainFrame = mainFrame;
		ok = mainFrame.btnImage("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png",
				"images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png", 140, 110, 120, 60);
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setEnabled(true);
				mainFrame.deleteBtn.setEnabled(true);
				dispose();
			}
		});
		add(ok);
		
		JPanel notSelectedPanel = new ImagePanel(
				ImageScaledTool.getScaledImage("images/PosImages/상품 관리 이미지/삭제 메뉴 선택하지 않을 때 창.png", 400, 200));
		notSelectedPanel.setSize(400,200);
		
		add(notSelectedPanel);
		
		setSize(400, 200);
		setLayout(null); 
		setUndecorated(true); 
		setBackground(new Color(0, 0, 0, 0));	// 패널 배경 투명하게 하기
		setVisible(true); 
		setResizable(false); 
		setLocationRelativeTo(null);
	}

}
