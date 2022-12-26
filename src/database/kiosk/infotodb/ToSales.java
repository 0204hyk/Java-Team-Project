package database.kiosk.infotodb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import database.OjdbcConnection;

public class ToSales {
	public ToSales(ArrayList<String> orderInfo) {

		// 판매번호, 메뉴번호, 메뉴옵션, 메뉴 수량, 가격
		String query = "INSERT INTO sales VALUES(?,?,?,?,?)";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {

			pstmt.setString(1, orderInfo.get(0));
			pstmt.setInt(2, Integer.parseInt(orderInfo.get(5)));
			pstmt.setInt(3, Integer.parseInt(orderInfo.get(6)));
			pstmt.setInt(4, Integer.parseInt(orderInfo.get(2)));
			pstmt.setInt(5, Integer.parseInt(orderInfo.get(3)));

			pstmt.executeUpdate();
<<<<<<< HEAD
=======
			
>>>>>>> refs/remotes/origin/jsj
			System.out.println("판매 테이블 DB입력 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
