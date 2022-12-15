package database.kiosk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import database.OjdbcConnection;

public class SavePoint {
	
	public SavePoint(int point, String phonenumber) {
		String query = "UPDATE membership SET member_point = member_point + ? WHERE member_phonenumber = ? ";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {
			
			pstmt.setInt(1, point);
			pstmt.setString(2, phonenumber);
			
			pstmt.executeQuery();
			System.out.println("포인트 업뎃 완");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("뭔가 오류");
		}
	}
}
