package train.jungjun.admin_page;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import train.jungjun.login_join_page.OjdbcConnectionPool;
import train.jungjun.login_join_page.OjdbcSession;
import train.jungjun.login_join_page.StaticResources;

public class Admin_pageDAO {
	
	OjdbcConnectionPool cp = StaticResources.cp;
//	static {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	private Connection conn = getConnection();
//	public static Connection getConnection() {
//		try {
//			return DriverManager.getConnection
//					("jdbc:oracle:thin:@localhost:1521:XE", "hr","1234");
//		}catch(SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	public boolean login_chk() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
		UIManager.put("OptionPane.messageFont",
				new Font("굴림", Font.BOLD, 50));
		String query ="SELECT * FROM admin_info WHERE admin_num_pk =? AND admin_pw=?";
		
		try (
				OjdbcSession session = cp.getSession();	
			){
			Connection conn = session.getConnection();
			try( PreparedStatement pstmt = conn.prepareStatement(query);
			){
				pstmt.setString(1, Admin_page.id);
				pstmt.setString(2, Admin_page.pw);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"로그인에 성공했습니다");
						Choice c = new Choice();
						c.setVisible(true);
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
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null,"로그인에 실패했습니다3");
				e.printStackTrace();
				return false;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"로그인에 실패했습니다4");
			e.printStackTrace();
			return false;
		}
	}
}