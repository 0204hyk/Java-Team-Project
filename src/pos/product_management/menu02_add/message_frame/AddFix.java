package pos.product_management.menu02_add.message_frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import pos.ImagePanel;
import pos.ImageScaledTool;
import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu01_main.component.MenuListJTable;
import pos.product_management.menu02_add.MenuAddFrame;
import pos.product_management.menu02_add.panel.AddBackgroundImagePanel;

public class AddFix extends JFrame {
	ImageIcon icon;
		
	public AddFix(ProductManagementJFrame prjf, MenuAddFrame frame) {
		
		JPanel background = new ImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상품 관리 이미지/메뉴 추가 완료 안내 창.png", 400, 200));
		
		JButton addFixBtn = prjf.btnImage("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png", 
				"images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png", 140,110,120,60);
		addFixBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				prjf.mj.contents.setRowCount(0);
				prjf.mj.selectTable(prjf.allMenu());
				prjf.setEnabled(true);
				prjf.addBtn.setEnabled(true);
				dispose();
				frame.dispose();
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
