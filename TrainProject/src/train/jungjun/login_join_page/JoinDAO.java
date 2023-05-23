package train.jungjun.login_join_page;

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

import train.db.OjdbcConnection;

// 사용
public class JoinDAO {
	public static String alrim = "";
	
	public boolean join_chk() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
		String query =
				"INSERT INTO user_info "
				+ "(id,password,name,phone_number,birthday,email,preferential_treatment,usernum_pk)"
				+ " VALUES(?,?,?,?,?,?,?,'USER'||trim(TO_CHAR(USERNUM_PK.nextval,'000000')))";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {
					if(Login_and_join.pw_chk_B && Login_and_join.email_chk_B &&
								Login_and_join.num_chk_B && Login_and_join.birthday_chk_B && Login_and_join.id_chk_B
								&& Login_and_join.preferential_treatment_chk_B) {
						pstmt.setString(1, Login_and_join.id2);
						pstmt.setString(2, Login_and_join.pw2);
						pstmt.setString(3, Login_and_join.name);
						pstmt.setString(4, Login_and_join.phone_number);
						pstmt.setString(5, Login_and_join.birthday);
						pstmt.setString(6, Login_and_join.email);
						pstmt.setString(7, Login_and_join.preferential_treatment);
						try(ResultSet rs = pstmt.executeQuery();){
							if(rs.next()) {
								alrim = "회원가입 성공";
								Join_alrim alrim = new Join_alrim();
								alrim.main(null);
								return true;
							}else {
								alrim = "회원가입 실패";
								Join_alrim alrim = new Join_alrim();
								alrim.main(null);
								return false;
							}
						}
					}
					alrim = "정확한 값을 입력하세요";
					Join_alrim alrim = new Join_alrim();
					alrim.main(null);
					return false;
			}catch(Exception e) {
				alrim = "회원가입 실패 (중복된 아이디이가 있을수 있습니다)_1";
				Join_alrim alrim = new Join_alrim();
				alrim.main(null);
				e.printStackTrace();
				return false;
			}
	}
}