package pos.gje.delet.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.gje.delet.DeleteFrame;
import pos.gje.delet.OkFrame;
import pos.gje.delet.panel.OkPanel;
import pos.kjh.MenuListJTable;
import pos.kjh.ProductManagementJFrame;

public class OkBtn extends JButton implements ActionListener{
	// 삭제하시겠습니까 확인 버튼
	DeleteFrame f;
	
	public OkBtn(DeleteFrame f) {
		this.f = f;
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(scaledImage2);
			setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				f.setVisible(false);
				MenuListJTable.table.setEnabled(true);
				// 디비에서 데이터 없애기
				MenuListJTable.deleteDB(MenuListJTable.menuName.toString());
				
				// JTable에서 선택행 삭제하기
				int index = MenuListJTable.table.getSelectedRow();
				MenuListJTable.contents.removeRow(index);
				new OkFrame();
				
				
			}
		});
			
		
		setBounds(120, 155, 100, 50);
		setContentAreaFilled(false);
		setBorderPainted(false); 
		setOpaque(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MenuListJTable.table.setEnabled(true);
		f.dispose();
		new OkFrame();
	}
	
}
