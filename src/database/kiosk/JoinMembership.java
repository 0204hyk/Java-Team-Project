package database.kiosk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.Date;

import database.OjdbcConnection;

public class JoinMembership {

	// 회원 가입
	public JoinMembership(String ph) {

		String query = "INSERT INTO membership VALUES (?, 0, ?)";

		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {

			LocalDate today = LocalDate.now();
			pstmt.setString(1, ph);
			pstmt.setString(2, today.toString());
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
