package train.jungjun.change;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import train.db.OjdbcConnection;

public class Mem_chageDAO {
	public static String alrim = "";
	public static String user_code;
	public boolean DAO() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
		String query ="SELECT * FROM user_info WHERE id =? AND password=?";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {
				pstmt.setString(1, Mem_change.id);
				pstmt.setString(2, Mem_change.pw);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						alrim = "로그인에 성공했습니다";
						Mem_changeDAO_alrim mca = new Mem_changeDAO_alrim();
						user_code = rs.getString("usernum_pk");
						mca.main(null);
						return true;
					}else {
						alrim = "로그인에 실패했습니다_1";
						Mem_changeDAO_alrim mca = new Mem_changeDAO_alrim();
						mca.main(null);
						return false;
					}
				}
		}catch(Exception e) {
			alrim = "로그인에 실패했습니다_2";
			Mem_changeDAO_alrim mca = new Mem_changeDAO_alrim();
			mca.main(null);
			e.printStackTrace();
			return false;
		}
	}
}
