package train.jungjun.login_join_page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChangePW {
	OjdbcConnectionPool cp = StaticResources.cp;
	
	public boolean change_pw() {
		String query ="UPDATE user_info SET password =? WHERE id =?";
		try (
				OjdbcSession session = cp.getSession();	
			) {
			Connection conn = session.getConnection();
			try( PreparedStatement pstmt = conn.prepareStatement(query);
					){
				pstmt.setString(1, Find_pw_Jd.pw1);
				pstmt.setString(2, Login_and_join.id3);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						return true;
					}else {
						return false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}