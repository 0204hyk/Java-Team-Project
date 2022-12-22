package database.kiosk.infotodb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.OjdbcConnection;

public class ToMembership {
	/*
	 * 결제 완료 후 디비로 전송할 데이터
	 * 1. 멤버십 테이블: [주문별] 폰번호, 포인트 금액, 날짜(가입일)
	 * 2. 판매관리 테이블: [주문별] 판매번호(날짜-01-랜덤번호 6자리), 회원번호(비회원은 null), 날짜, 결제 방식, 포인트 사용액, 카드 번호(-두개포함)
	 * 3. 판매 테이블: [메뉴 하나씩 들어감] 판매번호(날짜-01-랜덤번호 6자리) - 중복 적용, 메뉴번호, 옵션들, 잔수, 가격
	 */

	public ToMembership() {

		String query = "INSERT INTO membership VALUES(?,?,?)";
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			pstmt.setString(1, query);
			pstmt.setInt(2, 1);
			pstmt.setString(3, "날짜");

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
