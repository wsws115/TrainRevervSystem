package train;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import train.dao.FoodDao;
import train.dto.FoodDto;
import train.train_food_component.FoodBtn;
import train.train_food_component.FoodLab;
import train.train_food_component.MenuBtn;
import train.train_food_component.OrderTable;
import train.train_food_component.OrderTableBtn;

public class FoodCourtMainPanel extends JPanel {
	// [하] 총 가격 라벨 (버튼 액션 시, 토탈 가격 바뀌어야 되서 static 설정)
	public static JLabel totalPrice_Lab;	
	
	/** [하] 테이블에 따라 총 가격을 구하는 메소드 */
	public static void getTotalPrice(DefaultTableModel user_dtm) {
		int sum = 0;
		
		for (int i = 0; i < user_dtm.getRowCount(); ++i) {
			int qty = 0;
			
			if (user_dtm.getColumnCount() != 0) {
				qty = (int) user_dtm.getValueAt(i, OrderTable.QTYROW);
			}
			
			sum += (int) user_dtm.getValueAt(i, OrderTable.PRICEROW) * qty;
		}
		totalPrice_Lab.setText(String.valueOf(sum) + "원");
	}
	
	String[] orderTableColumnName = {"좌석번호", "음식이름", "가격", "-", "수량", "+", "취소"};
	String mainpont = "HY헤드라인M";
	
//	FoodDao foodDao = new FoodDao();
	
	/**
	 * Create the panel.
	 */
	
	public FoodCourtMainPanel() {
		
		// ★ [하]
		
		// @ OrderTable 패널
		JPanel orderTable_panel = new JPanel();
		orderTable_panel.setVisible(true);
		orderTable_panel.setBackground(new Color(255, 255, 255));
		orderTable_panel.setBounds(90, 700, 894, 180);
		orderTable_panel.setLayout(new BorderLayout(10, 10));
		add(orderTable_panel);
		
			// @ 하단 타이틀 라벨
			JLabel orderTableMainTitle_Lab = new JLabel("【 선택한 메뉴 】");
			orderTable_panel.add(orderTableMainTitle_Lab, BorderLayout.NORTH);
			orderTableMainTitle_Lab.setFont(new Font(mainpont, Font.PLAIN, 20));
			
			// @ user_table
			DefaultTableModel order_dtm = new DefaultTableModel(orderTableColumnName, 0);

			OrderTable order_table = new OrderTable(order_dtm);
			JScrollPane user_sp = new JScrollPane(order_table);	
			
			orderTable_panel.add(user_sp, BorderLayout.CENTER); // 오더 테이블 패널에 JTable 넣음
		
		// ★ [중] - 하단 total Price 때문에 [하] 밑으로 넣음
		
			// @ 메뉴 카드들을 넣을 부모 패널 (카드 레이아웃 설정됨)
			CardLayout cardLayout = new CardLayout();
			
			JPanel main_Menupanel = new JPanel();
			main_Menupanel.setLayout(cardLayout);
			main_Menupanel.setBounds(90, 139, 1306, 538);
		
		// @ 자식 패널들		
						// ＠ 1번 - 식사류 패널
						JPanel meal_panel = new JPanel();
						meal_panel.setBounds(100, 100, 1200, 2000);
						meal_panel.setBackground(new Color(255, 255, 255));
						meal_panel.setLayout(new GridLayout(4, 6, 0, 20));
						
							// 1번 카드 스크롤
						JScrollPane meal_sf = new JScrollPane(meal_panel);
						meal_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						meal_sf.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						meal_sf.getVerticalScrollBar().setUnitIncrement(30);
						meal_sf.setBounds(90, 180, 1306, 497);
						
						// ＠ 2번 - 면류 패널
						JPanel noodle_panel = new JPanel();
						noodle_panel.setBounds(100, 100, 1200, 2000);
						noodle_panel.setBackground(new Color(255, 255, 255));
						noodle_panel.setLayout(new GridLayout(2, 6, 0, 20));
							// 2번 카드 스크롤
						JScrollPane noodle_sf = new JScrollPane(noodle_panel);
						noodle_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						noodle_sf.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						noodle_sf.getVerticalScrollBar().setUnitIncrement(30);
						noodle_sf.setBounds(90, 180, 1306, 497);
						
						// ＠ 3번 - 간식류 패널
						JPanel snack_panel = new JPanel();
						snack_panel.setBounds(100, 100, 1200, 2000);
						snack_panel.setBackground(new Color(255, 255, 255));
						snack_panel.setLayout(new GridLayout(2, 6, 0, 20));
							// 3번 스크롤
						JScrollPane snack_sf = new JScrollPane(snack_panel);
						snack_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						snack_sf.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						snack_sf.getVerticalScrollBar().setUnitIncrement(30);
						snack_sf.setBounds(90, 180, 1306, 497);
						
						// ＠ 4번 - 음료 패널
						JPanel drink_panel = new JPanel();
						drink_panel.setBounds(100, 100, 1200, 2000);
						drink_panel.setBackground(new Color(255, 255, 255));
						drink_panel.setLayout(new GridLayout(2, 6, 0, 20));
							// 4번 스크롤
						JScrollPane drink_sf = new JScrollPane(drink_panel);
						drink_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						drink_sf.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						drink_sf.getVerticalScrollBar().setUnitIncrement(30);
						drink_sf.setBounds(90, 180, 1306, 497);
					
//		// @ 패널 내부 메뉴 버튼들						
//						List<FoodDto> allFoodList = foodDao.getFoodAll();
//						FoodBtn[] foodBtns = new FoodBtn[allFoodList.size()];
//						FoodLab[] foodName_Lab = new FoodLab[allFoodList.size()];
//						FoodLab[] foodPrice_Lab = new FoodLab[allFoodList.size()];
////						
//						// 0 ~ 7 도시락, 8 ~ 11 컵라면, 12 ~ 16 과자, 17 ~ 18 음료 : 총 음식 갯수 19						
//						for (int i = 0; i < allFoodList.size(); ++i) {							
//							foodBtns[i] = new FoodBtn(allFoodList.get(i), order_dtm);
//							foodName_Lab[i] = new FoodLab(foodBtns[i].getName());
//							foodPrice_Lab[i] = new FoodLab(foodBtns[i].getPrice() + "원");							
//							
//							if (i <= 7) {								
//								meal_panel.add(foodBtns[i]);
//								meal_panel.add(foodName_Lab[i]);
//								meal_panel.add(foodPrice_Lab[i]);
//								
//							} else if (i <= 11) {
//								noodle_panel.add(foodBtns[i]);
//								noodle_panel.add(foodName_Lab[i]);
//								noodle_panel.add(foodPrice_Lab[i]);
//								
//							} else if (i <= 15) {
//								snack_panel.add(foodBtns[i]);
//								snack_panel.add(foodName_Lab[i]);
//								snack_panel.add(foodPrice_Lab[i]);
//								
//							} else {
//								drink_panel.add(foodBtns[i]);
//								drink_panel.add(foodName_Lab[i]);
//								drink_panel.add(foodPrice_Lab[i]);
//							}
//						}
//						
//						// @ 버튼 이미지
//						foodBtns[0].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%9E%A5%EC%96%B4%EB%8D%AE%EB%B0%A5.jpg?raw=true");
//						foodBtns[1].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%A0%84%EC%A3%BC%EB%B9%84%EB%B9%94%EB%B0%A5.jpg?raw=true");
//						foodBtns[2].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EB%B6%88%EA%B3%A0%EA%B8%B0%EB%8D%AE%EB%B0%A5.jpg?raw=true");
//						foodBtns[3].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%98%A4%EC%A7%95%EC%96%B4%EB%8D%AE%EB%B0%A5.jpg?raw=true");
//						foodBtns[4].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%ED%95%A8%EB%B0%95.jpg?raw=true");
//						foodBtns[5].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%B0%B8%EC%B9%98%EB%A7%88%EC%9A%94.jpg?raw=true");
//						foodBtns[6].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%B9%98%ED%82%A8%EB%A7%88%EC%9A%94.jpg?raw=true");
//						foodBtns[7].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%96%B4%EB%A6%B0%EC%9D%B4%EC%84%B8%ED%8A%B8.jpg?raw=true");
//						foodBtns[8].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%8B%A0%EB%9D%BC%EB%A9%B4.jpg?raw=true");
//						foodBtns[9].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%A7%84%EB%9D%BC%EB%A9%B4.jpg?raw=true");
//						foodBtns[10].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%A7%9C%ED%8C%8C%EA%B2%8C%ED%8B%B0.jpg?raw=true");
//						foodBtns[11].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EB%9D%BC%EB%A9%B4%EB%B3%B6%EC%9D%B4.jpg?raw=true");
//						foodBtns[12].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%83%88%EC%9A%B0%EA%B9%A1.jpg?raw=true");
//						foodBtns[13].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%B4%88%EC%BD%94%EC%86%A1%EC%9D%B4.jpg?raw=true");
//						foodBtns[14].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%96%91%ED%8C%8C%EB%A7%81.jpg?raw=true");
//						foodBtns[15].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%ED%97%88%EB%8B%88%EB%B2%84%ED%84%B0%EC%B9%A9.jpg?raw=true");
//						foodBtns[16].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%BD%94%EC%B9%B4%EC%BD%9C%EB%9D%BC.jpg?raw=true");
//						foodBtns[17].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EC%82%AC%EC%9D%B4%EB%8B%A4.jpg?raw=true");
//						foodBtns[18].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EB%B4%89%EB%B4%89.jpg?raw=true");
//						foodBtns[19].getImage("https://github.com/wsws115/TrainRevervSystem/blob/train_merge_food_login_sujin_image/TrainProject/src/image/food_%EB%A7%9D%EA%B3%A0.jpg?raw=true");
////						
						// @ 메뉴 부모 패널들에 자식 스크롤 추가
						main_Menupanel.add("pane1", meal_sf);
						main_Menupanel.add("pane2", noodle_sf);
						main_Menupanel.add("pane3", snack_sf);
						main_Menupanel.add("pane4", drink_sf);
						
						add(main_Menupanel); // [중] - 끝 -
		
		// ★ [상] - card 패널 show 때문에 [중] 밑으로 두었음
			
			// @ 메뉴 버튼들
			MenuBtn meal_MenuBtn = new MenuBtn("식사류", cardLayout, main_Menupanel, "pane1");
			meal_MenuBtn.setLocation(94, 29);
			add(meal_MenuBtn);
			
			MenuBtn noodle_MenuBtn = new MenuBtn("면류", cardLayout, main_Menupanel, "pane2");
			noodle_MenuBtn.setLocation(440, 29);
			add(noodle_MenuBtn);
	
			MenuBtn snack_MenuBtn = new MenuBtn("간식", cardLayout, main_Menupanel, "pane3");
			snack_MenuBtn.setLocation(778, 29);
			add(snack_MenuBtn);
			
			MenuBtn drink_MenuBtn = new MenuBtn("음료", cardLayout, main_Menupanel, "pane4");
			drink_MenuBtn.setLocation(1148, 29);
			add(drink_MenuBtn); // [상] - 끝 -	
			
		// ★ [하] 총계만 써진 단순 라벨
		    JLabel total_Lab = new JLabel("총 계 :");
			total_Lab.setFont(new Font(mainpont, Font.PLAIN, 30));
			total_Lab.setBounds(742, 880, 106, 44);
			add(total_Lab);
			
			// @ FoodBtn을 누르면, 총 합계가 들어갈 가격 라벨
			totalPrice_Lab = new JLabel("0 원");
			totalPrice_Lab.setFont(new Font(mainpont, Font.PLAIN, 30));
			totalPrice_Lab.setBounds(860, 880, 141, 44);
			add(totalPrice_Lab);
			
			// @ 전체 취소 버튼 누르면, JTable 내용 모두 삭제
			JButton cancel_Btn = new JButton("<html>전체<br> 취소</html>");
			cancel_Btn.setFont(new Font(mainpont, Font.PLAIN, 30));
			cancel_Btn.setForeground(Color.white);
			cancel_Btn.setBackground(new Color(0, 128, 192));
			cancel_Btn.setBounds(1016, 734, 178, 146);
			add(cancel_Btn);
			// 액션 시, 버튼 삭제
			cancel_Btn.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {				
					order_dtm.setRowCount(0); // 전체 행 삭제
					order_dtm.fireTableDataChanged(); // 데이터 저장				
					order_table.repaint(); // 데이터 새로고침
					
					getTotalPrice(order_dtm); // 가격 새로고침
				}
			});
			
			// @ 다음 누르면, 다음 단계로			
			JButton select_Btn = new JButton("다음");
			select_Btn.setFont(new Font(mainpont, Font.PLAIN, 30));
			select_Btn.setForeground(Color.white);
			select_Btn.setBackground(new Color(0, 128, 192));
			select_Btn.setBounds(1218, 734, 178, 146);
			add(select_Btn);
				// 액션 시, 좌석 번호 받고 / 테이블 DB값 DB에 올리기
			select_Btn.addActionListener(new ActionListener() {
				// ★ 수정해야됨 ~
				@Override
				public void actionPerformed(ActionEvent e) {
					if (order_table.getRowCount() == 0) {
						System.out.println("아무것도 선택 안되면 데이터 없이 다음으로 이동");
					} else {
						System.out.println("테이블 값을 가져가야됨 ~");
						// 0 좌석번호, 1 음식이름, 2 가격, 3 food_number_pk, 4 수량, 5 - 버튼 (null), 6 취소 버튼 (null)
						TableModel model = order_table.getModel();
						
						for (int idx = 0; idx < model.getRowCount(); idx++) {
							String rows = "";
							for (int cdx = 0; cdx < model.getColumnCount(); cdx++) {
								Object val = model.getValueAt(idx, cdx);
								rows = rows + " " + val;
							}
							System.out.println(rows);
						}

					}
					
				}
			});  // [하] - 끝 -
		
		// ★ 패널 기본 셋팅
		setBackground(new Color(255, 255, 255));
		setBounds(441, 80, 1483, 931);
		setLayout(null); 
	}

}