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
						JOptionPane.showMessageDialog(null,"로그인에 성공했습니다");
						Choice c = new Choice();
						c.setVisible(true);
						return true;
					}else {
						JOptionPane.showMessageDialog(null,"로그인에 실패했습니다1");
						return false;
					}
				}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"로그인에 실패했습니다2");
			e.printStackTrace();
			return false;
		}
	}
}
