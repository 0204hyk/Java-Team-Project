package database.kiosk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.OjdbcConnection;

public class CheckMenuByCategories {

	ArrayList<String> menuArr = new ArrayList<>();
	ArrayList<Integer> menuOptionArr = new ArrayList<>();

	public CheckMenuByCategories(int categoryNum) {
		String query = "SELECT * FROM menu WHERE category_number = ?";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			pstmt.setInt(1, categoryNum);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					menuArr.add(rs.getString("menu_name"));
					menuOptionArr.add(rs.getInt("option_category_number"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getMenu() {

		return menuArr;
	}

	public int getListSize() {
		
		return menuArr.size();
	}

	public ArrayList<Integer> getOptionNumber() {

		return menuOptionArr;
	}

	public static void main(String[] args) {
		CheckMenuByCategories cc = new CheckMenuByCategories(4);
	}
}
