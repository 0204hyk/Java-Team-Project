package pos.product_management.menu03_modify.message_frame;

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
import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu02_add.MenuAddFrame;
import pos.product_management.menu03_modify.ModifyFrame;
import pos.product_management.menu03_modify.message_frame.component.OkBtn;

public class ModifyMessageFrame extends JFrame{
		
	public ModifyMessageFrame(ProductManagementJFrame f1, ModifyFrame f2) {
		
		add(new OkBtn(f1, f2, this));
		add(new ModifyMessagePanel());
		
		setUndecorated(true); // 타이틀바 없애기
		getContentPane().setBackground(Color.white); // 배경색
		setBackground(new Color(0, 0, 0, 0));	// 패널 배경 투명하게 하기
		setSize(400, 200); // 프레임 사이즈
		setLayout(null); // 레이아웃
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게

	}

}
