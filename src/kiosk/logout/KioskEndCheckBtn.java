package kiosk.logout;

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
import kiosk.TouchToPlaceAnOrder;
import pos.login.LoginSelectFrame;

public class KioskEndCheckBtn extends JButton implements ActionListener {

	TouchToPlaceAnOrder frame;
	KioskEndFrame middleFrame;
	KioskAccessPanel panel;

	static String pwCheck;
	static String idCheck;

	// DB 아이디 체크
	public String checkIdDB() throws SQLException {

		String sql = "SELECT manager_id FROM manager";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				idCheck = rs.getString("manager_id");
			}
		}

		return idCheck;
	}

	// DB 비번 체크
	public static String checkPwDB() throws SQLException {

		String sql = "SELECT manager_password FROM manager";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				pwCheck = rs.getString("manager_password");
			}
		}

		return pwCheck;
	}

	public KioskEndCheckBtn(TouchToPlaceAnOrder frame, KioskAccessPanel panel, KioskEndFrame middleFrame) {
		this.frame = frame;
		this.panel = panel;
		this.middleFrame = middleFrame;
		try {
			BufferedImage bufferedfixBtnImage = ImageIO
					.read(new File("images/KioskImages/2_1. touchScreen Selected/키오스크 관리자 모드 접속창 버튼.png"));
			Image fixBtnImage = bufferedfixBtnImage.getScaledInstance(80, 48, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(fixBtnImage));
			setBounds(345, 66, 80, 48);

			setBorderPainted(false);
			setContentAreaFilled(false);
			setFocusPainted(false);

			BufferedImage bufferedBtnClickImage = ImageIO
					.read(new File("images/KioskImages/2_1. touchScreen Selected/키오스크 관리자 모드 접속창 버튼 클릭.png"));
			Image btnClickImage = bufferedBtnClickImage.getScaledInstance(80, 48, Image.SCALE_SMOOTH);
			Icon btnClickIcon = new ImageIcon(btnClickImage);
			setPressedIcon(btnClickIcon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 디비에 있는 아이디로 유효성 체크하는 설정값 만들기
		try {
			if (checkPwDB().equals(panel.accessPassword.getText())) {
				middleFrame.dispose();
				frame.dispose();
				new LoginSelectFrame();

			} else if (!(checkPwDB().equals(panel.accessPassword.getText()))) {
				KioskAccessPanel.discordance.setVisible(true);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
