package train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import train.db.OjdbcConnection;

public class TicketDAO {

	/** DB에서 날짜에 맞는 기차 번호를 가져오는 메소드 */
	public Integer[] getTrainNum(int date) {

		Integer[] trains = null;
		String query ="SELECT train_num FROM train_api WHERE train_date = ?";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			pstmt.setInt(1, date);
			try (
					ResultSet rs = pstmt.executeQuery();
			){				
				int i = 0;				
				while (rs.next()) {
					trains = new Integer[rs.getRow()];
					trains[i++] = rs.getInt(1);
				}				
				return trains;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// ★ 수정 중 - 추후에 선택 차내식 추가해야 함 !!
	/** 조건에 맞는 티켓을 가져오는 메소드 */
	// 가져와야할 것, "좌석번호", "티켓번호", "출발지", "도착지", "차내식"
	public void getTicketList(int date, int trainNum, int trainCode, DefaultTableModel model) {
		String query = 				
				"SELECT seat.seat_name, ticket_num_pk, starting_subway, ending_subway FROM train_ticket tt"
				+ " JOIN seat_table seat ON tt.seat_code = seat.seat_code"
				+ " JOIN train_table train ON seat.train_code = train.train_code"
				+ " JOIN train_API api ON train.train_num = api.train_num"
				+ " WHERE api.train_date = " + date
				+ " AND api.train_num = " + trainNum
				+ " AND train_ho_num = " + trainCode;

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
		) {
				while(rs.next()) {
					Vector<Object> list = new Vector<>();
					list.add(rs.getString(1));
					list.add(rs.getString(2));
					list.add(rs.getString(3));
					list.add(rs.getString(4));
					model.addRow(list);
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refundTicket(String ticketNum) {
		String query1 = "DELETE FROM train_ticket WHERE ticket_num_pk = '" + ticketNum + "'";
		String query2 = "UPDATE train_table SET train_seat_qty = train_seat_qty + 1 WHERE train_table.train_num "
				+ "= (SELECT train_num FROM seat_table WHERE seat_table.seat_code"
				+ " = (SELECT seat_code FROM train_ticket WHERE ticket_num_pk = '" + ticketNum +"'))";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);				
				PreparedStatement pstmt2 = conn.prepareStatement(query2);				
		) {
			if (pstmt2.executeUpdate() == 1 && pstmt1.executeUpdate() == 1) {
				JOptionPane.showMessageDialog(null, "티켓을 반환하였습니다.");
			} else {
				conn.rollback(); // 실패하면 롤백?
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
