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
						JOptionPane.showMessageDialog(null,"로그인에 성공했습니다");
						Choice c = new Choice();
						c.setVisible(true);
						user_code = rs.getString("usernum_pk");
						preferential = rs.getString("preferential_treatment");
						return true;
					}else {
						JOptionPane.showMessageDialog(null,"로그인에 실패했습니다1");
						return false;
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,"로그인에 실패했습니다2");
					e.printStackTrace();
					return false;
				}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"로그인에 실패했습니다3");
			e.printStackTrace();
			return false;
		}
	}
	
	
}