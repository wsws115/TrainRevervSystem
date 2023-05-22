package train.dao;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import train.db.OjdbcConnection;
import train.dto.FoodDTO;

public class FoodDAO {
	
	/** 음식 DB에서 값을 가져오는 메소드 */
	public List<FoodDTO> getFoodAll() {
		
		List<FoodDTO> list = new ArrayList<>();
		
		String query = "SELECT * FROM trainfood ORDER BY food_number";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
			) {
				while (rs.next()) {
					list.add(new FoodDTO(
							rs.getString("food_number"),
							rs.getString("food_type"),
							rs.getString("food_name"),
							rs.getInt("food_price"),
							rs.getString("food_image_location")
					));
				}				
				return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public void setLoginFood(List<String> foodlist, List<String> seatlist, int train_ho) {
		
		String query2 = "SELECT food_number FROM trainfood WHERE food_name = '"+foodlist.get(0)+"'";
		String query3 = "INSERT INTO ticket_mem_food VALUES(?,?,?,?)";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt2 = conn.prepareStatement(query2);
				PreparedStatement pstmt3 = conn.prepareStatement(query3);
				ResultSet rs2 = pstmt2.executeQuery();
			) {
				String user_code = train.jungjun.login_join_page.Login_and_joinDAO.user_code;
				
				
				if(rs2.next()) {
					pstmt3.setString(1, train_ho+seatlist.get(0)+user_code);
					pstmt3.setString(2, rs2.getString("food_number"));
					pstmt3.setInt(3, Integer.parseInt(foodlist.get(1)));
					pstmt3.setInt(4, Integer.parseInt(foodlist.get(2)));
					pstmt3.executeUpdate();
				}
				
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void setUnLoginFood(List<String> foodlist, List<String> seatlist, int train_ho) {
		String query2 = "SELECT food_number FROM trainfood WHERE food_name = ?";
		String query3 = "INSERT INTO ticket_unmem_food VALUES(?,?,?,?)";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt2 = conn.prepareStatement(query2);
				PreparedStatement pstmt3 = conn.prepareStatement(query3);
			) {
				String user_code = train.jungjun.No_login_joinDAO.pk;
				
				pstmt2.setString(1, foodlist.get(0));
				pstmt2.executeUpdate();
				try(ResultSet rs2 = pstmt2.executeQuery()){
					if(rs2.next()) {
						pstmt3.setString(1, train_ho+seatlist.get(0)+user_code);
						pstmt3.setString(2, rs2.getString("food_number"));
						pstmt3.setInt(3, Integer.parseInt(foodlist.get(1)));
						pstmt3.setInt(4, Integer.parseInt(foodlist.get(2)));
						pstmt3.executeUpdate();
						
					}
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	/** userchoicefood DB로 값을 보내는 메소드 */
	public void addFood(String type, String name, int price, String location) {
		
		UIManager.put("OptionPane.minimumSize",new Dimension(400, 400));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));

		String query = "INSERT INTO trainfood VALUES('F' || lpad(food_number_seq.nextval, 4, '0'),?,?,?,?)";				
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {

				pstmt.setString(1, type);
				pstmt.setString(2, name);
				pstmt.setInt(3, price);
				pstmt.setString(4, location); // 이미지 파일명만...

				if (pstmt.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "메뉴가 추가되었습니다.");
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** DB에서 메뉴를 삭제하는 메소드 */
	public void delectFood(String foodNum) {
		
		UIManager.put("OptionPane.minimumSize",new Dimension(400, 400));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
			
		String query = "DELETE FROM trainfood WHERE food_number = ?";		
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {

				pstmt.setString(1, foodNum);	
				
				if (pstmt.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "선택한 메뉴를 삭제하였습니다");
				}

		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

}