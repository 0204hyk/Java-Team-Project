package pos.product_management.menu01_main.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import database.OjdbcConnection;
import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu03_modify.ModifyFrame;
import pos.product_management.menu03_modify.message_frame.ModifyWarningFrame;

public class ModifyButton extends JButton implements ActionListener{
	ProductManagementJFrame mainFrame;
	public ModifyButton(ProductManagementJFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		try {
			BufferedImage bufferedfixBtnImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/수정 시작 버튼.png"));
			Image fixBtnImage = bufferedfixBtnImage.getScaledInstance(180,80, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(fixBtnImage));
			setBounds(760, 675, 180, 80);
			
			setBorderPainted(false);
			setContentAreaFilled(false);
			setFocusPainted(false);
			
			BufferedImage bufferedBtnClickImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/수정 시작 버튼 클릭.png"));
			Image btnClickImage = bufferedBtnClickImage.getScaledInstance(180,80, Image.SCALE_SMOOTH);
			Icon btnClickIcon = new ImageIcon(btnClickImage);
			setPressedIcon(btnClickIcon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String sql1 = "SELECT menu_name, TRIM(TO_CHAR(price, '999,999,999')),"
				+ "category_number, option_category_number "
				+ "FROM menu "
				+ "WHERE menu_number = ?";
		MenuListJTable table = mainFrame.mj;

		try (
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);			
		){
			mainFrame.modifyBtn.setEnabled(false);
			mainFrame.setEnabled(false);
			
			if (!table.getSelected()) {
				new ModifyWarningFrame(mainFrame).setVisible(true);
			} else {
				ModifyFrame frame = new ModifyFrame(mainFrame);
				
				pstmt.setInt(1, table.getMenuNumber());
				
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					frame.panel.nameField.setText(rs.getString(1));
					frame.panel.priceField.setText(rs.getString(2));
					
					int categoryNum = rs.getInt(3);
					int optionNum = rs.getInt(4);
					if (categoryNum == 2) {
						frame.panel.coffee.setSelected(true);
					} else if (categoryNum == 3) {
						frame.panel.frappe.setSelected(true);
					} else if (categoryNum == 4) {
						frame.panel.nonCoffee.setSelected(true);
					} else if (categoryNum == 5) {
						frame.panel.ade.setSelected(true);
					} ;
					
					if (optionNum == 1) {
						frame.panel.option1.setSelected(true);
					} else if (optionNum == 2) {
						frame.panel.option2.setSelected(true);
					} else if (optionNum == 3) {
						frame.panel.option3.setSelected(true);
					} else if (optionNum == 4) {
						frame.panel.option4.setSelected(true);
					} else if (optionNum == 5) {
						frame.panel.option5.setSelected(true);
					} else if (optionNum == 6) {
						frame.panel.option6.setSelected(true);
					} else if (optionNum == 7) {
						frame.panel.option7.setSelected(true);
					} else {
						frame.panel.option8.setSelected(true);
					}
					
					rs.close();
				}
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
}
