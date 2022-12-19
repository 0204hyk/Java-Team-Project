package pos.product_management.menu_modify.additional_frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pos.ImagePanel;
import pos.ImageScaledTool;
import pos.kjh.ProductManagementJFrame;
import pos.product_management.menu_add.MenuAddFrame;

public class ModifyAdditionalFrame extends JFrame{
	
	ImageIcon icon;
	
	ProductManagementJFrame prjf;
	
	public JButton fixButton() throws IOException {
		JButton fixBtn = prjf.btnImage("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png", 
				"images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png", 140,110,120,60);
		fixBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		return fixBtn;
	}
	
	public ModifyAdditionalFrame() throws IOException {
		
		JPanel background = new ImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상품 관리 이미지/수정 완료 안내 멘트 창.png", 400, 200));
		
		background.add(fixButton());	
		
		add(background);
		
		setSize(400, 200);
		setResizable(false);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));	// 패널 배경 투명하게 하기
		setLocationRelativeTo(null);

	}

}
