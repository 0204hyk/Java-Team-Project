package pos.product_management.menu03_modify.message_frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pos.ImagePanel;
import pos.ImageScaledTool;
import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu02_add.MenuAddFrame;

public class ModifyWarningFrame extends JFrame{
	ProductManagementJFrame prjf;

	public ModifyWarningFrame(ProductManagementJFrame prjf) {
		this.prjf = prjf;

		JPanel background = new ImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상품 관리 이미지/메뉴 선택 경고창.png", 400, 200));

		JButton addFixBtn = prjf.btnImage("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png", 
				"images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png", 140,110,120,60);
		addFixBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prjf.modifyBtn.setEnabled(true);
				prjf.setEnabled(true);
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
