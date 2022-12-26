package database.kiosk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.OjdbcConnection;

public class CheckSales {

	public static void main(String[] args) {

		String query = "SELECT * FROM sales";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\n",rs.getString("sales_number"), 
					rs.getInt("menu_number"), rs.getInt("menu_options"), rs.getInt("menu_qty"), rs.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
