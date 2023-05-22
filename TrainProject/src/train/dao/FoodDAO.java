package train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import train.db.OjdbcConnection;
import train.dto.FoodDTO;

public class FoodDAO {
	
	/** 음식 DB에서 값을 가져오는 메소드 */
	public List<FoodDTO> getFoodAll() {
		
		List<FoodDTO> list = new ArrayList<>();
		
		String query = "SELECT * FROM trainfood";
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
							rs.getInt("food_price")							
					));
				}
				
				return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	/** userchoicefood DB로 값을 보내는 메소드 */
//	public void setuserchoicefood() {
//		
//		try (
//				Connection conn = OjdbcConnection.getConnection();
//			) {
//			
//			String qurey = "INSERT INTO coffee VALUES(coffee_id_seq.nextval,?,?)";				
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

}