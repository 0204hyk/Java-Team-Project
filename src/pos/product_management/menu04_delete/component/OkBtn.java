package pos.product_management.menu04_delete.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu01_main.component.MenuListJTable;
import pos.product_management.menu04_delete.DeleteFrame;
import pos.product_management.menu04_delete.message_frame.OkFrame;

public class OkBtn extends JButton implements ActionListener{
	// 삭제하시겠습니까 확인 버튼
	ProductManagementJFrame mainFrame;
	DeleteFrame f;
	OkFrame f2;
	
	public OkBtn(ProductManagementJFrame mainFrame, DeleteFrame f, OkFrame f2) {
		this.mainFrame = mainFrame;
		this.f = f;
		this.f2 = f2;
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(scaledImage2);
			setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		addActionListener(this);
			
		
		setBounds(110, 160, 120, 60);
		setContentAreaFilled(false);
		setBorderPainted(false); 
		setOpaque(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrame.setEnabled(true);
		mainFrame.deleteBtn.setEnabled(true);
		MenuListJTable.deleteDB(MenuListJTable.menuName);
		
		// JTable에서 선택행 삭제하기
		int index = MenuListJTable.table.getSelectedRow();
		MenuListJTable.contents.removeRow(index);
		f2.setVisible(true);
		f.dispose();
		mainFrame.setEnabled(false);
		mainFrame.deleteBtn.setEnabled(false);
	}
	
}
