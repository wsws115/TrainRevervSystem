package train.jungjun.change;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import train.db.OjdbcConnection;
import train.jungjun.No_login_join;

public class No_mem_changeDAO {
	public boolean NCDAO() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
		String query = "SELECT * FROM non_mem_info WHERE phone_number =? AND password =?";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {					
				pstmt.setString(1, No_mem_change.pn);
				pstmt.setString(2, No_mem_change.pw);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"로그인에 성공했습니다");
						return true;
					}else {
						JOptionPane.showMessageDialog(null,"로그인에 실패했습니다_1");
						return false;
					}
				}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"로그인에 실패했습니다_2");
			e.printStackTrace();
			return false;
		}
	}
}
