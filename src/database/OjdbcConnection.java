package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OjdbcConnection {
	//하영씨 192.168.0.116 //121.132.80.134
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@121.132.80.147:1521:XE";
	private static String id = "hyCafe";
	private static String password = "1234";
	
	// 학원 컴퓨터 : 127.0.0.1
	// static 클래스.
	static { 
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public OjdbcConnection() {
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
			return null;
		}
	}
	
}
