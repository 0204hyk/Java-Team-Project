package pos.receipt_check.ReceiptCheck.receiptcheck_main.component;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.w3c.dom.events.MouseEvent;

public class ReceiptListJTable {
	public static void main(String[] args) {
	//실제 뿌려줄 크기
    Dimension dim = new Dimension(300, 500);
    JFrame frame = new JFrame("조직도");
    //뿌려줄 위치
    frame.setLocation(200, 300);
    frame.setPreferredSize(dim);
    
    String header[] = {"번호", "부서"};
    String contents[][] = 
    {
        {"1", "루트"},
        {"2", "대표이사"},
        {"3", "이철수"},
        {"4", "경영지원"},
        {"5", "솔루션"},
        {"6", "이영희"},
        {"5", "솔루션"},
        {"5", "솔루션"},
        {"5", "솔루션"},
        {"5", "솔루션"},
        {"5", "솔루션"},
        {"5", "솔루션"},
        {"5", "솔루션"},
        {"5", "솔루션"},
        {"5", "솔루션"}
        
    };

    JTable table = new JTable(contents, header);
    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane);
    
    
    //특정컬럼 값 수정
    //table.setValueAt("200", 1, 1);
    //특정컬럼 가져오기
    System.out.println(table.getValueAt(0, 0));

    //row 갯수
    System.out.println(table.getRowCount());
    //column 갯수
    System.out.println(table.getColumnCount());
    //컬럼이름
    System.out.println(table.getColumnName(0));
    
    frame.pack();
    frame.setVisible(true);
    
	}

}
