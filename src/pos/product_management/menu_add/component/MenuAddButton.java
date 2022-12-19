package pos.product_management.menu_add.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import database.OjdbcConnection;
import pos.product_management.menu_add.MenuAddFrame;
import pos.product_management.menu_add.additional_frame.AddFix;

public class MenuAddButton extends JButton implements ActionListener{
	
	MenuAddFrame mainFrame;
	AddFix additionalFrame;
	
	public MenuAddButton(MenuAddFrame mainFrame, AddFix additionalFrame) {
		this.mainFrame = mainFrame;
		this.additionalFrame = additionalFrame;
		
		try {
			BufferedImage bufferedfixBtnImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/메뉴 추가 창 확인 버튼.png"));
			Image fixBtnImage = bufferedfixBtnImage.getScaledInstance(150,75, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(fixBtnImage));
			setBounds(720, 450, 150, 75);
			
			setBorderPainted(false);
			setContentAreaFilled(false);
			setFocusPainted(false);
			
			BufferedImage bufferedBtnClickImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/메뉴 추가 창 확인 버튼 클릭.png"));
			Image btnClickImage = bufferedBtnClickImage.getScaledInstance(150,75, Image.SCALE_SMOOTH);
			Icon btnClickIcon = new ImageIcon(btnClickImage);
			setPressedIcon(btnClickIcon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
				// 메뉴 넘버, 메뉴 이름, 카테고리 넘버, 옵션 카테고리 넘버, 가격 순
		String query = "INSERT INTO menu VALUES ((SELECT MAX(menu_number)+1 FROM menu m),?,?,?,?)";
		
		try (
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			if (!mainFrame.nameField.getText().equals("")) {
				pstmt.setString(1, mainFrame.nameField.getText());				
			} else {
				JOptionPane.showMessageDialog(null, "메뉴 이름을 입력하세요", "Message", JOptionPane.INFORMATION_MESSAGE);
				return;
			};
			
			if (mainFrame.coffee.isSelected()) {
				pstmt.setInt(2, 2);
			} else if (mainFrame.nonCoffee.isSelected()) {
				pstmt.setInt(2, 3);
			} else if (mainFrame.ade.isSelected()) {
				pstmt.setInt(2, 4);
			} else {
				pstmt.setInt(2, 5);
			};
			
			if (mainFrame.option1.isSelected()) {
				pstmt.setInt(3, 1);
			} else if (mainFrame.option2.isSelected()) {
				pstmt.setInt(3, 2);
			} else if (mainFrame.option3.isSelected()) {
				pstmt.setInt(3, 3);
			} else if (mainFrame.option4.isSelected()) {
				pstmt.setInt(3, 4);
			} else if (mainFrame.option5.isSelected()) {
				pstmt.setInt(3, 5);
			} else if (mainFrame.option6.isSelected()) {
				pstmt.setInt(3, 6);
			} else if (mainFrame.option7.isSelected()) {
				pstmt.setInt(3, 7);
			} else {
				pstmt.setInt(3, 8);
			};			
			
			if (!mainFrame.priceField.getText().equals("")) {
				String[] prices = mainFrame.priceField.getText().split(","); 
				String result = "";
				for (String price : prices) {
					result += price;
				}
				pstmt.setInt(4, Integer.parseInt(result));								
			} else {
				JOptionPane.showMessageDialog(null, "가격을 입력하세요", "Message", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			pstmt.executeUpdate();
			additionalFrame.setVisible(true);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "중복된 이름의 메뉴가 존재합니다", "Message", JOptionPane.INFORMATION_MESSAGE);
//			e1.printStackTrace();
		}
		
	}

}
