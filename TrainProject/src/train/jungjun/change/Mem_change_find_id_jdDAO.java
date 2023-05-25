package train.jungjun.change;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import train.db.OjdbcConnection;
import train.jungjun.login_join_page.Login_and_join;

public class Mem_change_find_id_jdDAO {
	public String find_id() {
		String query = "SELECT id FROM user_info WHERE name =? AND phone_number =?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
		){
				pstmt.setString(1,Mem_change.name);
				pstmt.setString(2,Mem_change.pn);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						return rs.getString(1);
					}else {
						return "존재하지않는 아이디";
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
			return "오류_1";
		}
	}
}
