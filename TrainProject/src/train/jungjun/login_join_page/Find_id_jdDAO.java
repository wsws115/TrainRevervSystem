package train.jungjun.login_join_page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import train.db.OjdbcConnection;

public class Find_id_jdDAO {
	
	public String find_id() {
		String query = "SELECT id FROM user_info WHERE name =? AND phone_number =?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
		){
				pstmt.setString(1,Login_and_join.name2);
				pstmt.setString(2,Login_and_join.phone_number2);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						return rs.getString(1);
					}else {
						return "존재하지않는 아이디";
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
			return "오류1";
		}
	}
}