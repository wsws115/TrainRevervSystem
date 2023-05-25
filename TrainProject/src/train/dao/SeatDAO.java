package train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import train.TrainReserv_Main;
import train.db.OjdbcConnection;
import train.search.component.ReservBtn;

public class SeatDAO {

	
//	public static List<ArrayList <String>> bookedSeatlists = new ArrayList<>();
	public static ArrayList <String> bookedSeatList1 = new ArrayList<>(); // 1호차에서 예약된 좌석의 목록
	public static ArrayList <String> bookedSeatList2 = new ArrayList<>(); 
	public static ArrayList <String> bookedSeatList3 = new ArrayList<>(); 
	public static ArrayList <String> bookedSeatList4 = new ArrayList<>(); 
	public static ArrayList <String> bookedSeatList5 = new ArrayList<>(); 
	public static ArrayList <String> bookedSeatList6 = new ArrayList<>(); 
	public static ArrayList <String> bookedSeatList7 = new ArrayList<>(); 
	public static ArrayList <String> bookedSeatList8 = new ArrayList<>(); 
	public static ArrayList <String> bookedSeatList9 = new ArrayList<>();
	public static ArrayList <String> bookedSeatList10 = new ArrayList<>(); 
	

	
	/** 예매 버튼을 눌렀을 때 해당 기차에 예약된 좌석의 리스트를 가져오는 메서드*/
	
	public void getBookedSpecialSeats() {		
		//train_ho_num : 호차번호
		//seat_name : 좌석번호
	
		
		
		String query = "SELECT train_ho_num, seat_name FROM seat_table seat "
	              +"RIGHT JOIN train_table train ON seat.train_code = train.train_code "
	              +"RIGHT JOIN train_api api ON train.train_num = api.train_num "
	              +"WHERE api.train_type = ? AND api.train_date = ? AND "
	                  +"api.starting_subway = ? AND api.ending_subway = ? AND "
	                  +"api.start_time = ? AND api.end_time = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
		) {

		    pstmt.setString(1, ReservBtn.name);
            pstmt.setString(2, TrainReserv_Main.date_text.getText());
            pstmt.setString(3, TrainReserv_Main.st_sub_btn.getText());
            pstmt.setString(4, TrainReserv_Main.en_sub_btn.getText());
            pstmt.setString(5, ReservBtn.st_time);
            pstmt.setString(6, ReservBtn.en_time);


//			pstmt.setString(1, ReservBtn.name);// 기차타입
//			pstmt.setString(2, TrainReserv_Main.t_date); // 날짜
//			pstmt.setString(3, TrainReserv_Main.t_arrival); // 출발지
//			pstmt.setString(4, ReservBtn.st_time); // 출발시간
//			pstmt.setString(5, TrainReserv_Main.t_departure); // 도착지
//			pstmt.setString(6, ReservBtn.en_time); // 도착시간

	
			try (ResultSet rs = pstmt.executeQuery();) {
				 while(rs.next()) {
//	                  System.out.println(rs.getString("train_ho_num")+ "호차");
	                  
//	                 for(List list : bookedSeatlists) {
//	                	list.add(rs.getString("seat_name"));
//	                	System.out.println(list.toString());
//	                 }

	                  if(rs.getString("train_ho_num").equals("1")) {
	                	  bookedSeatList1.add(rs.getString("seat_name"));
	                  }
	                  if(rs.getString("train_ho_num").equals("2")) {
	                	  bookedSeatList2.add(rs.getString("seat_name"));
	                  }
	                  if(rs.getString("train_ho_num").equals("3")) {
	                	  bookedSeatList3.add(rs.getString("seat_name"));
	                  }
	                  if(rs.getString("train_ho_num").equals("4")) {
	                	  bookedSeatList4.add(rs.getString("seat_name"));
	                  }
	                  if(rs.getString("train_ho_num").equals("5")) {
	                	  bookedSeatList5.add(rs.getString("seat_name"));
	                  }
	                  if(rs.getString("train_ho_num").equals("6")) {
	                	  bookedSeatList6.add(rs.getString("seat_name"));
	                  }
	                  if(rs.getString("train_ho_num").equals("7")) {
	                	  bookedSeatList7.add(rs.getString("seat_name"));
	                  }
	                  if(rs.getString("train_ho_num").equals("8")) {
	                	  bookedSeatList8.add(rs.getString("seat_name"));
	                  }
	                  if(rs.getString("train_ho_num").equals("9")) {
	                	  bookedSeatList9.add(rs.getString("seat_name"));
	                  }
	                  if(rs.getString("train_ho_num").equals("10")) {
	                	  bookedSeatList10.add(rs.getString("seat_name"));
	                  }
//	                  
	               }
//				 System.out.println("1호차 : " + bookedSeatList1.toString());
//				 System.out.println("2호차 : " + bookedSeatList2.toString());
//				 System.out.println("3호차 : " + bookedSeatList3.toString());
//				 System.out.println(bookedSeatList4.toString());
//				 System.out.println(bookedSeatList5.toString());
//				 System.out.println(bookedSeatList6.toString());
//				 System.out.println(bookedSeatList7.toString());
//				 System.out.println(bookedSeatList8.toString());
//				 System.out.println(bookedSeatList9.toString());
//				 System.out.println(bookedSeatList10.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
