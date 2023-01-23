package database.kiosk.fromdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.OjdbcConnection;

public class CheckPoint {
	
	int point;
	
	public CheckPoint(String phonenumber) {

		String query = "SELECT member_point FROM membership WHERE member_phonenumber = ?";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			pstmt.setString(1, phonenumber);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					point = rs.getInt("member_point");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int currentPoint() {
		
		int point = this.point;
		
		return point;
	}
	
	public static void main(String[] args) {
	}
}
