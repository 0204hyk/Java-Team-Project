package database.kiosk.infotodb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.OjdbcConnection;

public class Select {

	public static void main(String[] args) {
	
		
		String query = "SELECT * FROM membership";

//		String query = "INSERT INTO membership VALUES (?,?,?)";
				
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {
				
//			pstmt.setString(1, "null");
//			pstmt.setInt(2, 0);
//			pstmt.setString(3, "2022-12-23");
//			
//			pstmt.executeUpdate();

			
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					System.out.printf("%s\t%d\t%s\n" ,rs.getString("member_phonenumber"), rs.getInt("member_point"),rs.getString("member_join"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
