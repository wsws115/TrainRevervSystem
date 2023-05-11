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

}