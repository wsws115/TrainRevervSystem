package train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import train.db.OjdbcConnectionPool;
import train.db.OjdbcSession;
import train.db.StaticResources;
import train.dto.FoodDto;

public class FoodDao {

	OjdbcConnectionPool cp = StaticResources.cp;
	
	/** 음식 DB에서 값을 가져오는 메소드 */
	public List<FoodDto> getFoodAll() {
		
		List<FoodDto> list = new ArrayList<>();
		
		try (
				OjdbcSession session = cp.getSession();	
			) {
			Connection conn = session.getConnection();
			
			String query = "SELECT * FROM trainfood";
			
			try (
					PreparedStatement pstmt = conn.prepareStatement(query);
					ResultSet rs = pstmt.executeQuery();
			) {
				while (rs.next()) {
					list.add(new FoodDto(
							rs.getString("food_number"),
							rs.getString("food_type"),
							rs.getString("food_name"),
							rs.getInt("food_price")							
							));
				}
				return list;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	/** userchoicefood DB로 값을 보내는 메소드 */
	public void setuserchoicefood() {
		
		try (
				OjdbcSession session = cp.getSession();	
			) {
				Connection conn = session.getConnection();
			
				String qurey = "INSERT INTO coffee VALUES(coffee_id_seq.nextval,?,?)";				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}