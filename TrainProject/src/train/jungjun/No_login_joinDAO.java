package train.jungjun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import train.db.OjdbcConnection;

public class No_login_joinDAO {
	public static String pk;
	public boolean no_loginDAO() {
		No_login_join_Num_chk nchk = new No_login_join_Num_chk();
		No_login_join_pw_chk pchk = new No_login_join_pw_chk();
		String query = 
				"INSERT INTO non_mem_info (phone_number,password,no_mem_pk) VALUES (?,?,?)";
		String query2 = "select ZBF_GET_SEQ_NO_MEM('now') from DUAL";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				PreparedStatement pstmt2 = conn.prepareStatement(query2);
			) {	
				if(nchk.num_chk() && pchk.pw_chk()) {
					pstmt.setString(1, No_login_join.phone_num);
					pstmt.setString(2, No_login_join.pw);
				
				try(ResultSet rs = pstmt2.executeQuery();){
					if(rs.next()) {
						pk = rs.getString("ZBF_GET_SEQ_NO_MEM('now')");
						//System.out.println(pk);
					}
				}
				pstmt.setString(3, pk);
				pstmt.executeUpdate();
				return true;
				}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
