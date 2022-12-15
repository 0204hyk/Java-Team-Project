package pos.gje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import database.OjdbcConnection;

public class DBTest {

	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@192.168.0.135:1521:XE";
	private static String id = "hyCafe";
	private static String password = "1234";
	
	public static void main(String[] args) {
		
		
		String sql1 = "CREATE TABLE test(\n"
				+ "    test VARCHAR2(16),\n"
				+ "   test2 VARCHAR2(255))";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		){
			// Connection 인스턴스는 처음에 기본적으로 자동 커밋이 활성화 되어있다
			conn.setAutoCommit(false); //이거 왜하는?

			
			// Insert, Update, Delete는 executeUpdate() 메서드를 사용한다 결과는 int가 나옴
			int row = pstmt1.executeUpdate();
			
			System.out.println(row + "행이 성공적으로 추가되었습니다");
			
			System.out.println(row + "행이 성공적으로 100원 올랐습니다");
			
			//Connection 객체에 커밋과 롤백이 있다
			
			System.out.println("savepoint1로 돌아가 update만 취소되었습니다.");
			
			conn.commit();
			
			System.out.println("commit을 통해 변경 사항을 확정 지었습니다");
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
