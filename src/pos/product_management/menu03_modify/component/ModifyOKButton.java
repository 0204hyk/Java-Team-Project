package pos.product_management.menu03_modify.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import database.OjdbcConnection;
import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu03_modify.message_frame.ModifyMessageFrame;
import pos.product_management.menu03_modify.panel.ModifyBackgroundImagePanel;

public class ModifyOKButton extends JButton implements ActionListener{
	// 수정 버튼 
		ProductManagementJFrame mainFrame;
		ModifyMessageFrame messageFrame;
		ModifyBackgroundImagePanel panel;
		
	public ModifyOKButton (ProductManagementJFrame mainFrame, ModifyMessageFrame messageFrame, ModifyBackgroundImagePanel panel) {
		this.mainFrame = mainFrame;
		this.messageFrame = messageFrame;
		this.panel = panel;
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/메뉴 수정 확인 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(150, 75, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/상품 관리 이미지/메뉴 수정 확인 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(150, 75, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		

		setBounds(720, 450, 150, 75); // 위치 및 사이즈 조절
		setContentAreaFilled(false);
		setBorderPainted(false); 
		setOpaque(false);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sql = "UPDATE menu "
				+ "SET price = ?, category_number = ?, option_category_number = ?" 
				+ "WHERE menu_number = ?";
		try(
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);				
		) {
			
			if (!panel.priceField.getText().equals("")) {
				String[] prices = panel.priceField.getText().split(","); 
				String result = "";
				for (String price : prices) {
					result += price;
				}
				pstmt.setInt(1, Integer.parseInt(result));								
			} else {
				JOptionPane.showMessageDialog(null, "가격을 입력하세요", "Message", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if (panel.coffee.isSelected()) {
				pstmt.setInt(2, 2);
			} else if (panel.nonCoffee.isSelected()) {
				pstmt.setInt(2, 3);
			} else if (panel.ade.isSelected()) {
				pstmt.setInt(2, 4);
			} else {
				pstmt.setInt(2, 5);
			}
			
			if (panel.option1.isSelected()) {
				pstmt.setInt(3, 1);
			} else if (panel.option2.isSelected()) {
				pstmt.setInt(3, 2);
			} else if (panel.option3.isSelected()) {
				pstmt.setInt(3, 3);
			} else if (panel.option4.isSelected()) {
				pstmt.setInt(3, 4);
			} else if (panel.option5.isSelected()) {
				pstmt.setInt(3, 5);
			} else if (panel.option6.isSelected()) {
				pstmt.setInt(3, 6);
			} else if (panel.option7.isSelected()) {
				pstmt.setInt(3, 7);
			} else {
				pstmt.setInt(3, 8);
			}
			
			pstmt.setInt(4, mainFrame.mj.getMenuNumber());
			
			pstmt.executeUpdate();
			messageFrame.setVisible(true);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	} 
	


}
