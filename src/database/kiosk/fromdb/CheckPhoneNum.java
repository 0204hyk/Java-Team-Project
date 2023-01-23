package database.kiosk.fromdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.OjdbcConnection;

public class CheckPhoneNum {
	
	String result;

	public CheckPhoneNum(String phonenumber) {

		String query = "SELECT * FROM membership WHERE member_phonenumber = ?";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			pstmt.setString(1, phonenumber);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					result = rs.getString("member_phonenumber");

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean check() {
		if (result == null) {
			return false;
		} else {
			return true;
		}
	}

}
