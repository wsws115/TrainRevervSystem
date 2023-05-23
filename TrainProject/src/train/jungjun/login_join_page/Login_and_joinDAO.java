package train.jungjun.login_join_page;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import train.db.OjdbcConnection;

// 사용

public class Login_and_joinDAO {
	public static String alrim = "";
	public static String user_code;
	public static String preferential;
	public boolean login_chk() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
		String query ="SELECT * FROM user_info WHERE id =? AND password=?";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {
				pstmt.setString(1, Login_and_join.id);
				pstmt.setString(2, Login_and_join.pw);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						alrim = "로그인에 성공하셨습니다";
						user_code = rs.getString("usernum_pk");
						preferential = rs.getString("preferential_treatment");
						Login_alrim alrim = new Login_alrim();
						alrim.main(null);
						return true;
					}else {
						alrim = "로그인에 실패했습니다_1";
						Login_alrim alrim = new Login_alrim();
						alrim.main(null);
						return false;
					}
				}catch(Exception e) {
					alrim = "로그인에 실패했습니다_2";
					Login_alrim alrim = new Login_alrim();
					alrim.main(null);
					e.printStackTrace();
					return false;
				}
		}catch(Exception e) {
			alrim = "로그인에 실패했습니다_3";
			Login_alrim alrim = new Login_alrim();
			alrim.main(null);
			e.printStackTrace();
			return false;
		}
	}
	
	
}