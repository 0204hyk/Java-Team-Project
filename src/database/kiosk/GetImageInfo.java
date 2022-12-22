package database.kiosk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.OjdbcConnection;

public class GetImageInfo {

	String menuImageRoot= "";
	String menuNameKor="";
	String menuNameEng="";
	Integer menuOptionCategory = null;
	Integer menuPrice = null;
	String menu = "";
	
	public GetImageInfo(String menu) {
		String query = "SELECT * FROM menu WHERE menu_name = ?";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			pstmt.setString(1, menu);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					menuImageRoot = rs.getString("menu_image");
					menuOptionCategory = rs.getInt("option_category_number");
					menuNameKor = rs.getString("menu_name");
					menuNameEng = rs.getString("menu_eng_name");
					menuPrice = rs.getInt("price");

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	public String getMenuImageRoot() {
		return menuImageRoot;
	}


	public String getMenuNameKor() {
		return menuNameKor;
	}


	public String getMenuNameEng() {
		return menuNameEng;
	}


	public Integer getMenuPrice() {
		return menuPrice;
	}
	
	public static void main(String[] args) {
		GetImageInfo gi = new GetImageInfo("에스프레소");
		System.out.println(gi.getMenuPrice());
	}
	
}
