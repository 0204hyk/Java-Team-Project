package database.kiosk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

import database.OjdbcConnection;
import kiosk.tools.WithImage;

public class GetImage {

	String result= "";
	public GetImage(String menu) {

		String query = "SELECT * FROM menu WHERE menu_name = ?";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			pstmt.setString(1, menu);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					result = rs.getString("menu_image");

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	
	public String getImageName() {
		
		return result;
	}
	
}
