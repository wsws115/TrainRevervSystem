package train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import train.db.OjdbcConnection;
import train.dto.TicketDTO;

public class TicketDAO {

	// 회원 티켓 조회
	public List<TicketDTO> searchMemTicket(String phoneNum) {
		List<TicketDTO> tickets = new ArrayList<>();

		String query = "SELECT tt.ticket_num_pk, api.train_type, api.train_num, api.starting_subway, api.ending_subway, seat.seat_name, tt.totalprice"
				+ " FROM train_ticket tt"
				+ " JOIN seat_table seat ON tt.seat_code = seat.seat_code"
				+ " JOIN train_table train ON seat.train_code = train.train_code"
				+ " JOIN train_API api ON train.train_num = api.train_num"
				+ " JOIN user_info mem ON mem.usernum_pk = tt.usernum_pk"
				+ " WHERE mem.phone_number = '" + phoneNum + "'";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
		){
			// "티켓번호", "열차이름", "열차번호", "출발지", "도착지", "좌석번호", "가격", "반환"
			while(rs.next()) {
				tickets.add(new TicketDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
			}				
			return tickets;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}

	// 회원 티켓 반환 메소드 (삭제 시, 차내식, 티켓, seat 테이블 3개에서 삭제됨)
	public boolean refundMemTicket(String ticketNum, int trainNum) {		

		String query1 = "UPDATE train_table SET train_seat_qty = train_seat_qty + 1 WHERE train_num = " + trainNum;
		String query2 = "DELETE FROM seat_table WHERE seat_code = (SELECT seat_code FROM train_ticket WHERE ticket_num_pk = '" + ticketNum + "')";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt2 = conn.prepareStatement(query1);	
				PreparedStatement pstmt3 = conn.prepareStatement(query2);						
		) {

			if (pstmt2.executeUpdate() == 1 && pstmt3.executeUpdate() == 1) {
				JOptionPane.showMessageDialog(null, "티켓 반환이 완료되었습니다.");	
				return true;
			}
			
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 비회원
	public List<TicketDTO> searchNoMemTicket(String phoneNum) {
		List<TicketDTO> tickets = new ArrayList<>();

		String query = "SELECT tt.ticket_num, api.train_type, api.train_num, api.starting_subway, api.ending_subway, seat.seat_name, tt.total_price"
				+ " FROM train_unmember_ticket tt"
				+ " JOIN seat_table seat ON tt.seat_code = seat.seat_code"
				+ " JOIN train_table train ON seat.train_code = train.train_code"
				+ " JOIN train_API api ON train.train_num = api.train_num"
				+ " JOIN non_mem_info mem ON mem.no_mem_pk = tt.no_mem_pk"
				+ " WHERE mem.phone_number = '" + phoneNum + "'";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
		){
			// "티켓번호", "열차이름", "열차번호", "출발지", "도착지", "좌석번호", "가격", "반환"
			while(rs.next()) {
				tickets.add(new TicketDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			return tickets;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	// 비회원 티켓 반환 메소드 (삭제 시, 차내식, 티켓, seat 테이블 3개에서 삭제됨)
	public int refundNoMemTicket(String nomomNum, String ticketNum, int trainNum) {	
		
		// 비회원 티켓 조회해서 남은 티켓이 1이면, 비회원 정보도 삭제
		String query1 = "SELECT COUNT(*) FROM train_unmember_ticket WHERE no_mem_fk = (SELECT no_mem_fk FROM non_mem_info WHERE no_mem_pk = ?)";
		String query2 = "UPDATE train_table SET train_seat_qty = train_seat_qty + 1 WHERE train_num = ?";
		String query3 = "DELETE FROM seat_table WHERE seat_code = (SELECT seat_code FROM train_unmember_ticket WHERE ticket_num = ?)";
		String query4 = "DELETE FROM non_mem_info WHERE no_mem_pk = ?";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
		) {
			
			pstmt1.setString(1, nomomNum);
			try (
					ResultSet rs = pstmt1.executeQuery();	
					PreparedStatement pstmt2 = conn.prepareStatement(query2);	
					PreparedStatement pstmt3 = conn.prepareStatement(query3);						
					PreparedStatement pstmt4 = conn.prepareStatement(query4);						
			){				
				pstmt2.setInt(1, trainNum);
				pstmt3.setString(1, ticketNum);
				pstmt4.setString(1, nomomNum);
				
				if (rs.next()) {
					if (rs.getInt(1) >= 2) {
						if (pstmt2.executeUpdate() == 1 && pstmt3.executeUpdate() == 1) {
							JOptionPane.showMessageDialog(null, "티켓 반환이 완료되었습니다.");	
							return 1;
						}
					} else if (rs.getInt(1) == 1) {
						if (pstmt2.executeUpdate() == 1 && pstmt3.executeUpdate() == 1 && pstmt4.executeUpdate() == 1) {
							JOptionPane.showMessageDialog(null, "티켓 반환이 완료되었습니다.");	
							return 2;
						}
					}
				}
			}			

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	
//	// 비회원 티켓 반환 메소드 (삭제 시, 차내식, 티켓, seat 테이블 3개에서 삭제됨)
//		public int refundNoMemTicket(String nomomNum, String ticketNum, int trainNum) {	
//			
//			// 비회원 티켓 조회해서 남은 티켓이 1이면, 비회원 정보도 삭제
//			String query4 = "DELETE FROM non_mem_info WHERE no_mem_pk = ?";
//
//			try (
//					Connection conn = OjdbcConnection.getConnection();
//					PreparedStatement pstmt1 = conn.prepareStatement(query1);
//			) {
//				
//				pstmt1.setString(1, nomomNum);
//				try (
//						ResultSet rs = pstmt1.executeQuery();	
//						PreparedStatement pstmt2 = conn.prepareStatement(query2);	
//						PreparedStatement pstmt3 = conn.prepareStatement(query3);						
//						PreparedStatement pstmt4 = conn.prepareStatement(query4);						
//				){				
//					pstmt2.setInt(1, trainNum);
//					pstmt3.setString(1, ticketNum);
//					pstmt4.setString(1, nomomNum);
//					
//					if (rs.next()) {
//						if (rs.getInt(1) >= 2) {
//							if (pstmt2.executeUpdate() == 1 && pstmt3.executeUpdate() == 1) {
//								JOptionPane.showMessageDialog(null, "티켓 반환이 완료되었습니다.");	
//								return 1;
//							}
//						} else if (rs.getInt(1) == 1) {
//							if (pstmt2.executeUpdate() == 1 && pstmt3.executeUpdate() == 1 && pstmt4.executeUpdate() == 1) {
//								JOptionPane.showMessageDialog(null, "티켓 반환이 완료되었습니다.");	
//								return 2;
//							}
//						}
//					}
//				}			
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				return 0;
//			}
//			return 0;
//		}
}
