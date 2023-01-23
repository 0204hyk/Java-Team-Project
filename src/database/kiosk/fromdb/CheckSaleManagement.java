package database.kiosk.fromdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.OjdbcConnection;

public class CheckSaleManagement {
	public static void main(String[] args) {

		String query = "SELECT * FROM sales_management ORDER BY sales_number DESC";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			ResultSet rs = pstmt.executeQuery();
			int num = 1; // 목록에 있는 번호

			while (rs.next()) {
				// 영수증에 관한 값을 List에 저장 (현재 영수증 테이블에 값이 없엉서 멤버십 테이블로 대신함)
				System.out.printf("%s\t%d\t%s\t%s\t%s\n", rs.getString("sales_number"), rs.getInt("used_point"),
						rs.getString("card_number"), rs.getString("saledate"), rs.getString("member_phonenumber"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
