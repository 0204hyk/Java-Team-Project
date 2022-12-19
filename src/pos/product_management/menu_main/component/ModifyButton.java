package pos.product_management.menu_main.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import pos.gje.modify.ModifyFrame;
import pos.kjh.ProductManagementJFrame;

public class ModifyButton extends JButton implements ActionListener{
	ProductManagementJFrame mainFrame;
	public ModifyButton(ProductManagementJFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		try {
			BufferedImage bufferedfixBtnImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/수정 시작 버튼.png"));
			Image fixBtnImage = bufferedfixBtnImage.getScaledInstance(120,55, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(fixBtnImage));
			setBounds(900, 620, 120, 55);
			
			setBorderPainted(false);
			setContentAreaFilled(false);
			setFocusPainted(false);
			
			BufferedImage bufferedBtnClickImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/수정 시작 버튼 클릭.png"));
			Image btnClickImage = bufferedBtnClickImage.getScaledInstance(120,55, Image.SCALE_SMOOTH);
			Icon btnClickIcon = new ImageIcon(btnClickImage);
			setPressedIcon(btnClickIcon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		addActionListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrame.setEnabled(false);
		ModifyFrame modifyFrame = new ModifyFrame(mainFrame);
//		modifyFrame.panel.nameField.setText();
		
		
		mainFrame.mj.contents.fireTableDataChanged();	// 데이터 테이블 변경사항 JTable에 적용
		
	}
	
}
