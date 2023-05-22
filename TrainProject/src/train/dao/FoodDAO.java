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
import train.dto.FoodDTO;

public class FoodDAO {
	
	/** 음식 DB에서 값을 가져오는 메소드 */
	public List<FoodDTO> getFoodAll() {
		
		List<FoodDTO> list = new ArrayList<>();
		
		String query = "SELECT * FROM trainfood ORDER BY food_number";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
			) {
				while (rs.next()) {
					list.add(new FoodDTO(
							rs.getString("food_number"),
							rs.getString("food_type"),
							rs.getString("food_name"),
							rs.getInt("food_price"),
							rs.getString("food_image_location")
					));
				}				
				return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	/** userchoicefood DB로 값을 보내는 메소드 */
	public void addFood(String type, String name, int price, String location) {
		
		UIManager.put("OptionPane.minimumSize",new Dimension(400, 400));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));

		String query = "INSERT INTO trainfood VALUES('F' || lpad(food_number_seq.nextval, 4, '0'),?,?,?,?)";				
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {

				pstmt.setString(1, type);
				pstmt.setString(2, name);
				pstmt.setInt(3, price);
				pstmt.setString(4, location); // 이미지 파일명만...

				if (pstmt.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "메뉴가 추가되었습니다.");
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** DB에서 메뉴를 삭제하는 메소드 */
	public void delectFood(String foodNum) {
		
		UIManager.put("OptionPane.minimumSize",new Dimension(400, 400));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
			
		String query = "DELETE FROM trainfood WHERE food_number = ?";		
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {

				pstmt.setString(1, foodNum);	
				
				if (pstmt.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "선택한 메뉴를 삭제하였습니다");
				}

		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

}