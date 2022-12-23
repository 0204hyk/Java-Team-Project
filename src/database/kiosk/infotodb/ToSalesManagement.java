package database.kiosk.infotodb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import database.OjdbcConnection;

public class ToSalesManagement {
		
	//판매관리 테이블: [주문별] 판매번호(날짜-01-랜덤번호 6자리), 회원번호(비회원은 null), 날짜, 결제 방식, 포인트 사용액, 카드 번호(-두개포함)

	public ToSalesManagement(ArrayList<String> orderInfo) {

		String query = "INSERT INTO sales_management VALUES(?,?,?,?,?,?)";
		
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			pstmt.setString(1, orderInfo.get(0));
			pstmt.setString(2, orderInfo.get(1));
			pstmt.setString(3, "2022-12-23");
			pstmt.setInt(4, Integer.parseInt(orderInfo.get(3)));
			pstmt.setInt(5, Integer.parseInt(orderInfo.get(4)));
			pstmt.setString(6, orderInfo.get(5));

			pstmt.executeUpdate();
			System.out.println("판매관리 테이블 DB입력 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
