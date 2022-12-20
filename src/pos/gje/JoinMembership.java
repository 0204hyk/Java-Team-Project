package pos.gje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.Date;

import database.OjdbcConnection;


public class JoinMembership {
   
   // 회원 가입
   public JoinMembership(String ph) {
      
      LocalDate today = LocalDate.now();
      
      String query = "SELECT * FROM membership";

      try (Connection conn = OjdbcConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
      ) {

    	  ResultSet rs = pstmt.executeQuery();
			
			// 4. 받아온 결과를 사용한다 (SELECT의 경우 ResultSet 타입 인스턴스에 들어있다)
			while (rs.next()) {
				System.out.printf("%s\t%d\t%s\n",
						rs.getString("member_phonenumber"), 
						rs.getInt("member_point"),
						rs.getString("member_join"));
			}
			
      } catch (SQLException e) {
         System.out.println(" 오류");
         e.printStackTrace();
      }
   }
   public static void main(String[] args) {
      new JoinMembership("01046854832");
      
   }
}
