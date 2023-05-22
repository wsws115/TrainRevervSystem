package train.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import train.db.OjdbcConnection;
import train.dto.FoodDTO;
import train.dto.Search_TableDTO;

public class Train_Api_DAO {
	
	public int chk_train(List<String> apilist) {
		int chk_pk_num = 0;
		String query = "SELECT train_num FROM train_api WHERE train_type = ? "
				+ "AND train_date = ? AND starting_subway = ?  AND start_time = ? "
				+ "AND ending_subway = ? AND end_time = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
			) {
				
				pstmt.setString(1, apilist.get(0));
				pstmt.setString(2, apilist.get(1));
				pstmt.setString(3, apilist.get(2));
				pstmt.setString(4, apilist.get(3));
				pstmt.setString(5, apilist.get(4));
				pstmt.setString(6, apilist.get(5));
				try(ResultSet rs = pstmt.executeQuery();){
					if(!rs.next()) {
						chk_pk_num = 0;
					}else {
						chk_pk_num = rs.getInt("train_num");
					}
					return chk_pk_num;
				} 
		} catch (Exception e) {
			e.printStackTrace();
			return chk_pk_num;
		}
		
		
	}
	
	public int chkTrain_Table(List<String> holist, int train_num) {
		int chk_tpk_num = 0;
		String query = "SELECT * FROM train_table WHERE train_num = ? AND train_code = ? AND train_ho_num = ? AND train_ho_type = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
			) {
				
				pstmt.setInt(1, train_num);
				pstmt.setString(2, train_num+holist.get(0));
				pstmt.setString(3, holist.get(0));
				pstmt.setString(4, holist.get(1));
				try(ResultSet rs = pstmt.executeQuery();){
					if(!rs.next()) {
						chk_tpk_num = 0;
					}else {
						chk_tpk_num = rs.getInt("train_code");
					}
					return chk_tpk_num;
				} 
		} catch (Exception e) {
			e.printStackTrace();
			return chk_tpk_num;
		}
		
		
	}
//	public int chkSeat(List<String> seatlist, int train_ho_num) {
//		int chk_tpk_num = 0;
//		String query = "SELECT * FROM seat_table WHERE train_num = ? AND train_code = ? AND train_ho_num = ? AND train_ho_type = ?";
//		try (
//				Connection conn = OjdbcConnection.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(query);
//				
//			) {
//				
//				pstmt.setInt(1, train_num);
//				pstmt.setString(2, train_num+holist.get(0));
//				pstmt.setString(3, holist.get(0));
//				pstmt.setString(4, holist.get(1));
//				try(ResultSet rs = pstmt.executeQuery();){
//					if(!rs.next()) {
//						chk_tpk_num = 0;
//					}else {
//						chk_tpk_num = rs.getInt("train_code");
//					}
//					return chk_tpk_num;
//				} 
//		} catch (Exception e) {
//			e.printStackTrace();
//			return chk_tpk_num;
//		}
//		
//		
//	}
	public void setAllSearch(List<String> apilist){
		
		String query1 = "INSERT INTO train_api VALUES(train_id_seq.nextval,?,?,?,?,?,?,?)";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query1);
				
			) {
				
				pstmt.setString(1, apilist.get(0));
				pstmt.setString(2, apilist.get(1));
				pstmt.setString(3, apilist.get(2));
				pstmt.setString(4, apilist.get(3));
				pstmt.setString(5, apilist.get(4));
				pstmt.setString(6, apilist.get(5));
				pstmt.setString(7, apilist.get(6));
				pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void setTrain_ho(List<String> holist, int train_num){
		String query = "INSERT INTO train_table VALUES(?,?,?,?,?)";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
			) {
				
				pstmt.setInt(1, train_num);
				pstmt.setString(2, train_num+holist.get(0));
				pstmt.setString(3, holist.get(0));
				pstmt.setString(4, holist.get(1));
				pstmt.setString(5, holist.get(2));
				pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void setSeat(List<String> seat, int train_ho_num){
		String query = "INSERT INTO seat_table VALUES(?,?,?,?,?)";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
			) {
				pstmt.setInt(1, train_ho_num);
				pstmt.setString(2, train_ho_num+seat.get(0));
				pstmt.setString(3, seat.get(0));
				pstmt.setString(4, seat.get(1));
				pstmt.setString(5, seat.get(2));
				pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public void setSeatUp(int train_ho_num){
		String query = "UPDATE train_table SET train_seat_qty = train_seat_qty +1 WHERE train_code = ?";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
			) {
				pstmt.setInt(1, train_ho_num);
				pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void setSeatDown(int train_ho_num){
		String query = "UPDATE train_table SET train_seat_qty = train_seat_qty -1 WHERE train_code = ?";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
			) {
				pstmt.setInt(1, train_ho_num);
				pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void settikect(List<String> ticketlist, int train_seat) {
		String query = "INSERT INTO train_ticket VALUES(?,?,?,?,?,?)";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
			) {
				String user_code =  train.jungjun.login_join_page.Login_and_joinDAO.user_code;
				pstmt.setString(1, train_seat+ticketlist.get(0) + user_code);
				pstmt.setString(2, user_code);
				pstmt.setString(3, train_seat+"");
				pstmt.setString(4, ticketlist.get(1));
				pstmt.setString(6, ticketlist.get(2));
				pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
