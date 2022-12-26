package database.kiosk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

import database.OjdbcConnection;
import kiosk.tools.WithImage;

public class GetImageInfo {

	String menuImageRoot= "";
	String menuNameKor="";
	String menuNameEng="";
	Integer menuOptionCategory = null;
	Integer menuPrice = null;
	String menu = "";
	Integer menuNum = null;
	
	public GetImageInfo(String menu) {
		String query = "SELECT * FROM menu WHERE menu_name = ?";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			pstmt.setString(1, menu);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					menuNum = rs.getInt("menu_number");
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

	public Integer getMenuOptionCategory() {
		return menuOptionCategory;
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

	
	public Integer getMenuNum() {
		return menuNum;
	}

	public static void main(String[] args) {
		GetImageInfo gi = new GetImageInfo("초콜릿 쿠키 젤라또 프라페");
		System.out.println(gi.getMenuNum());
	}
	
}
