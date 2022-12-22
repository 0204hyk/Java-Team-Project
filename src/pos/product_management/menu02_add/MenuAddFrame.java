package pos.product_management.menu02_add;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import pos.ImagePanel;
import pos.ImageScaledTool;
import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu01_main.component.MenuListJTable;
import pos.product_management.menu02_add.component.MenuAddButton;
import pos.product_management.menu02_add.message_frame.AddFix;
import pos.product_management.menu02_add.panel.AddBackgroundImagePanel;

public class MenuAddFrame extends JFrame{
	ProductManagementJFrame mainFrame;
	
	public MenuAddFrame(ProductManagementJFrame mainFrame) throws IOException {
		add(new AddBackgroundImagePanel(mainFrame, this));
		
		setUndecorated(true);
		setSize(900, 550); // 프레임 사이즈
		setLayout(null); // 레이아웃
		setVisible(true); // 나타나게하기
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		
	}
}
