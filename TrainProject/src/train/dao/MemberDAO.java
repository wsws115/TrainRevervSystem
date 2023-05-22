package train.dao;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import train.db.OjdbcConnection;
import train.dto.MemberDTO;

public class MemberDAO {
	
	public List<MemberDTO> getAllMember() {
		List<MemberDTO> list = new ArrayList<>();
		String query ="SELECT * FROM user_info";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
			) {
					
				while(rs.next()) {						
					list.add(new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)
							, rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
				}
				
				return list;
					
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}	
	}
	
	public void withdraw(String usernum_pk) {
		
		UIManager.put("OptionPane.minimumSize",new Dimension(400, 400));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
		
		String query = "DELETE user_info WHERE usernum_pk = ?";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
		) {				
				pstmt.setString(1, usernum_pk);
					
				if(pstmt.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null,"회원을 삭제하였습니다");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
