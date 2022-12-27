package pos.gje.ReceiptCheck.receiptcheck_main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import database.OjdbcConnection;
import pos.gje.ReceiptCheck.receiptcheck_main.component.OutputButton;
import pos.gje.ReceiptCheck.receiptcheck_main.component.PrintScroll;
import pos.gje.ReceiptCheck.receiptcheck_main.component.RefundButton;
import pos.gje.ReceiptCheck.refund.RefundFrame;

// 리스트
public class List {
   
   static private String[] top = {" ", "영수증번호"};
   public static DefaultTableModel contents = new DefaultTableModel(top, 0){ // 테이블 안에 들어가는 데이터 값을 채워넣음
      public boolean isCellEditable(int row, int column){
         return false;
      }
   };  //셀 수정 못하게 하는 부분
   public static JTable table = new JTable(contents); 
   public static JScrollPane scroll;
   public static RefundFrame refundFrame;
   
   static ArrayList<String> date = new ArrayList<>(); // 판매 날짜 및 시간
   static ArrayList<String> cardNum = new ArrayList<>(); // 카드 번호 
   static ArrayList<Integer> point_payment = new ArrayList<>(); // 포인트 결제  
   static ArrayList<String> mem_number = new ArrayList<>(); //멤버십 정보
   static ArrayList<String> options = new ArrayList<>(); // 옵션 번호 
   
   DecimalFormat formatter = new DecimalFormat("###,###");
   
   
   String sales_date, sales_number, menu_name;
   int menu_qty, total_price, menu_price, point;
   
   String tem, caf, tum, size, shot, ice, milk;
   
   
   public List() {   }
   
   public List(OutputButton out, RefundButton refund) {
      
      String query = "SELECT * FROM sales_management ORDER BY sales_number DESC"; 
      
      try (Connection conn = OjdbcConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            ) {
         ResultSet rs = pstmt.executeQuery();
         int num = 1; // 목록에 있는 번호 
         
         while (rs.next()) {
            // 영수증에 관한 값을 List에 저장 (현재 영수증 테이블에 값이 없엉서 멤버십 테이블로 대신함)
            point_payment.add(rs.getInt("used_point")); // 포인트 결제
            cardNum.add(rs.getString("card_number")); // 카드 번호
            date.add(rs.getString("saledate")); // 결제 날짜 
            mem_number.add(rs.getString("member_phonenumber"));
            
            // Table 목록 생성
            contents.addRow(new Object[] {
                  num++, 
                  rs.getString("sales_number") 
            });
         }
         
      } catch (SQLException e) {
         System.out.println(" 오류");
         e.printStackTrace();
      }
      
      
      // 만든 테이블 스크롤에 붙이기
      scroll = new JScrollPane(table);
      scroll.setBounds(75, 95, 500, 550);
      
      // 크기 조정 
      table.getColumn(" ").setPreferredWidth(40);
      table.getColumn("영수증번호").setPreferredWidth(450);

      // 수정 안되게 만들기
      table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

      table.getTableHeader().setPreferredSize(new Dimension(0, 50));   // 컬럼 헤드 높이 설정
      table.getTableHeader().setBackground(new Color(217, 217, 217));   // 컬럼 헤드 배경색
        
        // 높이
        table.setRowHeight(35);
        
        // 글꼴 설정 
      table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 25)); 
      table.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      
      // 하나만 선택되게 설정 
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
      DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); 
      dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

      TableColumnModel tcm = table.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴

      //전체 열에 지정
      for(int i = 0 ; i < tcm.getColumnCount() ; i++){
         tcm.getColumn(i).setCellRenderer(dtcr);
      }
      
      ListSelectionModel rowSelect = table.getSelectionModel();
      rowSelect.addListSelectionListener(new ListSelectionListener() {
         
         @Override
         public void valueChanged(ListSelectionEvent e) {            
            if(e.getValueIsAdjusting()) {
               ListSelectionModel lsm = (ListSelectionModel)e.getSource();
               int rowIndex = lsm.getMinSelectionIndex();
               
               total_price = 0;
               options.clear();
               tem = "";
               
               int num = (int)(table.getValueAt(rowIndex, 0)) - 1;
               
               String sales_number = (table.getValueAt(rowIndex, 1)).toString();
               String card_number = cardNum.get(num);
               String sales_date = date.get(num);
               
               // 영수증 번호 전달
               menu(sales_number, num);
               
               out.setEnabled(true);
               refund.setEnabled(true);
                  
            }

         }
      });
   }
   
   // 메뉴를 담는 클래스 
   public void menu (String sales_number, int num) {
      
      String query = "select menu_name, menu_qty, s.price, menu_options "
            + "from sales s, menu m "
            + "where sales_number = '" + sales_number + "'"
            + "AND s.menu_number = m.menu_number"; 
      
      
      StringBuilder sb1 = new StringBuilder();
      
      try (Connection conn = OjdbcConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            ) {
         ResultSet rs = pstmt.executeQuery();
         
            // 영수증에 관한 값을 List에 저장 (현재 영수증 테이블에 값이 없엉서 멤버십 테이블로 대신함)
//            ResultSetMetaData metadata = rs.getMetaData();
         while (rs.next()) {   
            
            menu_name = rs.getString("menu_name");
            menu_qty = rs.getInt("menu_qty");
            menu_price = rs.getInt("price");
         
            // 처음에 메뉴 개수나 옵션 개수가 몇 개인지 몰라서 list로 받음 
            options.add(rs.getInt("menu_options") + "");
            
            String[] options1 = new String[options.size()];
            String[] option = new String[7];
            
            // list를 배열로 저장 
            for (int i = 0; i < options.size(); i++) {
               options1[i] = options.get(i).substring(0, 1);
            }

            for (int i = 0; i < options1.length; ++i) {
//                  System.out.println("optins1[i] = " + options1[i]);
            
               
               if (options1[i].equals("1")) {
                  tem = "(HOT)";
               } else if (options1[i].equals("2")) {
                  tem = "(ICE)";
               } else {
                  tem = "";
               }
            }
            
//               String menu = String.format("  %-20s\t%-10d%-10d\n", menu_name, menu_qty, menu_price);
//            
//               sb1.append(menu);
            
            if (menu_name.length() < 6) {
                  sb1.append("  " + menu_name + tem + "\t\t\t " 
                           + menu_qty + "\t\t" + formatter.format(menu_price) + "\n"); // 메뉴 프린트
                  
               } else if (menu_name.length() > 10) {
                  sb1.append("  " + menu_name + tem + "\t " 
                           + menu_qty + "\t\t" + formatter.format(menu_price) + "\n");
               }else {
                  sb1.append("  " + menu_name + tem + "\t\t" 
                           + menu_qty + "\t\t" + formatter.format(menu_price) + "\n"); // 메뉴 프린트
               } 
            
            total_price += menu_price;
         }
            
         int point = point_payment.get(num); 
         int card = total_price - point;
         String card_num = cardNum.get(num);
         String sale_date = date.get(num);
         String member_phonenumber = mem_number.get(num);
         
         // 환불창에 뜨게 하기
                                 // 총 가격, 포인트 결제, 카드 결제, 받은 금액
         refundFrame = new RefundFrame(total_price, point, card , card_num, sales_number, member_phonenumber, sb1.toString());
      
      
         // 영수증 출력하는 곳에 값 넣기 
                  // 날짜, 영수증번호, 메뉴, 총 가격, 포인트결제, 카드결제
         changeTextA(sale_date, sales_number, sb1.toString(), total_price , point, card);
         
         rs.close();
      } catch (SQLException e) {
         System.out.println(" 오류");
         e.printStackTrace();
      }

   }

   
   public void changeTextA(String date, String sales_number, String menu, int price, int point, int card) {
      JTextArea a = PrintScroll.p;
      
      
      a.setText(" [영수증]\n"
            + " \n"
            + " [매장명] 구리점\n"
            + " [사업자] 123-12-12345\n"
            + " [주소] 경기도 구리시 건원대로 44 태영빌딩\n"
            + " 4층 409호\n"
            + " [대표자] 김XX\t\t\t[TEL] 031-555-4449\n"
            + " [매출일] " + date + "\n"
            + " [영수증] " + sales_number + "\n"
            + " =========================================================\n"
            + "  상 품 명\t\t\t수 량\t\t단 가\n"
            + " ---------------------------------------------------------\n"
            + menu
            + " ---------------------------------------------------------\n"
            + " \t\t\t\t합 계 금 액   "  + formatter.format(price) + "\n"
            + " ---------------------------------------------------------\n"
            + " \t\t\t\t받 을 금 액   "  + formatter.format(price) + "\n"
            + " \t\t\t\t포인트 결제   "  + formatter.format(point) + "\n"
            + " \t\t\t\t카 드 결 제   "  +  formatter.format(card) + "\n"
            + " \t\t\t\t받 은 금 액   "  + formatter.format(price) + "\n"
            + " =========================================================\n"
            );
      
      
   }
   
   
   

}