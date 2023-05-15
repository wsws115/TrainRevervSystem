package train.jungjun.login_join_page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Find_pwDAO {
	OjdbcConnectionPool cp = StaticResources.cp;
	
	public boolean find_pw() {
		String query ="SELECT * FROM user_info WHERE id =? AND name=? AND phone_number=?";
		try (
				OjdbcSession session = cp.getSession();	
			) {
			Connection conn = session.getConnection();
		
			try( PreparedStatement pstmt = conn.prepareStatement(query);
					){
				pstmt.setString(1, Login_and_join.id3);
				pstmt.setString(2, Login_and_join.name3);
				pstmt.setString(3, Login_and_join.phone_number3);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						return true;
					}else {
						return false;
					}
				}
			}
		}catch(Exception e) {
		e.printStackTrace();
		return false;
		}
	}
}

