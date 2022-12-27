package pos.receipt_check.ReceiptCheck.receiptcheck_main.component;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.OjdbcConnection;
import pos.receipt_check.ReceiptCheck.receiptcheck_main.ReceiptCheckFrame;

public class ListJTable extends JTable{
	String[] top = {"순번", "번호"};
	private DefaultTableModel contents = new DefaultTableModel(top, 0);
	int num;
	String text;
	List<String> numList = new ArrayList<>();
	List<String> numList2 = new ArrayList<>();
	List<String> numList3 = new ArrayList<>();
	{
	String query = "SELECT * FROM membership ";
	
    try (Connection conn = OjdbcConnection.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(query);
    ) {

  	  ResultSet rs = pstmt.executeQuery();
			
			// 4. 받아온 결과를 사용한다 (SELECT의 경우 ResultSet 타입 인스턴스에 들어있다)
			while (rs.next()) {
//				System.out.printf("%s\t%d\t%s<br>",
//						rs.getString("member_phonenumber"), 
//						rs.getInt("member_point"),
//						rs.getString("member_join"));
				

				numList.add(rs.getString("member_phonenumber"));
				numList2.add(rs.getString("member_point"));
				numList3.add(rs.getString("member_join"));
			}
    } catch (SQLException e) {
       System.out.println(" 오류");
       e.printStackTrace();
    }
	}
	public ListJTable() {
		JTable table = new JTable(contents);
        JScrollPane scroll = new JScrollPane(table);
        
        table.setFont(getFont().deriveFont(20f));
        table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 23));
        table.setRowHeight(35);
        scroll.setBounds(75, 95, 500, 550);
        
        table.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
              int row = table.getSelectedRow();
              
           }
        });
        
        setBounds(48, 190, 1100, 400);
        add(scroll);
        setLayout(null);
        setVisible(true);
	}
}
