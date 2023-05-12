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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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
				qty = (int) user_dtm.getValueAt(i, 3);
			}
			
			sum += (int) user_dtm.getValueAt(i, 1) * qty;
		}
		totalPrice_Lab.setText(String.valueOf(sum) + "원");
	}
	
	FoodDao foodDao = new FoodDao();
	String mainpont = "HY헤드라인M";
	
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
			String[] orderTableColumnName = {"음식이름", "가격", "-", "수량", "+", "취소"};
			// DefaultTableModel 행 값 - 음식이름 0, 가격 1, - 2, 수량 3, + 4, 취소 5	
			DefaultTableModel order_dtm = new DefaultTableModel(orderTableColumnName, 0);

			OrderTable order_table = new OrderTable(order_dtm);
			JScrollPane user_sp = new JScrollPane(order_table);	
			
			orderTable_panel.add(user_sp, BorderLayout.CENTER); // 오더 테이블 패널에 JTable 넣음
	
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
		cancel_Btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		cancel_Btn.setForeground(Color.white);
		cancel_Btn.setBackground(new Color(0, 128, 192));
		cancel_Btn.setBounds(1016, 734, 162, 146);
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
		
		// @ 선택 완료 누르면, 다음 단계로
		JButton select_Btn = new JButton("다음");
		select_Btn.setFont(new Font(mainpont, Font.PLAIN, 30));
		select_Btn.setForeground(Color.white);
		select_Btn.setBackground(new Color(0, 128, 192));
		select_Btn.setBounds(1218, 734, 178, 146);
		add(select_Btn);
			// 액션 시, 좌석 번호 받고 / 테이블 DB값 DB에 올리기
		select_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});  // [하] - 끝 -
		
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
						meal_panel.setPreferredSize(new Dimension(1000, 700));
						meal_panel.setBackground(new Color(255, 255, 255));
						meal_panel.setLayout(new GridLayout(4, 2));
						
							// 1번 카드 스크롤
						JScrollPane meal_sf = new JScrollPane(meal_panel);
						meal_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						meal_sf.setAutoscrolls(false);
						meal_sf.getVerticalScrollBar().setUnitIncrement(30);
						meal_sf.setBounds(90, 180, 1306, 497);
						
						// ＠ 2번 - 면류 패널
						JPanel noodle_panel = new JPanel();
						noodle_panel.setBounds(100, 100, 1200, 2000);
						noodle_panel.setPreferredSize(new Dimension(1000, 700));
						noodle_panel.setBackground(new Color(255, 255, 255));
						noodle_panel.setLayout(new GridLayout(4, 2));
							// 2번 카드 스크롤
						JScrollPane noodle_sf = new JScrollPane(noodle_panel);
						noodle_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						noodle_panel.setAutoscrolls(false);
						noodle_sf.getVerticalScrollBar().setUnitIncrement(30);
						noodle_sf.setBounds(90, 180, 1306, 497);
						
						// ＠ 3번 - 간식류 패널
						JPanel snack_panel = new JPanel();
						snack_panel.setBounds(100, 100, 1200, 2000);
						snack_panel.setPreferredSize(new Dimension(1000, 700));
						snack_panel.setBackground(new Color(255, 255, 255));
							// 3번 스크롤
						JScrollPane snack_sf = new JScrollPane(snack_panel);
						snack_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						snack_panel.setAutoscrolls(false);
						snack_panel.setLayout(new GridLayout(4, 2));
						snack_sf.getVerticalScrollBar().setUnitIncrement(30);
						snack_sf.setBounds(90, 180, 1306, 497);
						
						// ＠ 4번 - 음료 패널
						JPanel drink_panel = new JPanel();
						drink_panel.setBounds(100, 100, 1200, 2000);
						drink_panel.setPreferredSize(new Dimension(1000, 700));
						drink_panel.setBackground(new Color(255, 255, 255));
							// 4번 스크롤
						JScrollPane drink_sf = new JScrollPane(drink_panel);
						drink_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						drink_panel.setAutoscrolls(false);
						drink_panel.setLayout(new GridLayout(4, 2));
						drink_sf.getVerticalScrollBar().setUnitIncrement(30);
						drink_sf.setBounds(90, 180, 1306, 497);
					
		// @ 패널 내부 메뉴 버튼들
						
						List<FoodDto> allFoodList = foodDao.getFoodAll();
						FoodBtn[] foodBtns = new FoodBtn[allFoodList.size()];
						FoodLab[] foodName_Lab = new FoodLab[allFoodList.size()];
						FoodLab[] foodPrice_Lab = new FoodLab[allFoodList.size()];
						
						// 0 ~ 7 도시락, 8 ~ 11 컵라면, 12 ~ 16 과자, 17 ~ 18 음료 : 총 음식 갯수 19						
						for (int i = 0; i < allFoodList.size(); ++i) {							
							foodBtns[i] = new FoodBtn(allFoodList.get(i), order_dtm);
							foodName_Lab[i] = new FoodLab(foodBtns[i].getName());
							foodPrice_Lab[i] = new FoodLab(foodBtns[i].getPrice() + "원");							
							
							if (i <= 7) {								
								meal_panel.add(foodBtns[i]);
								meal_panel.add(foodName_Lab[i]);
								meal_panel.add(foodPrice_Lab[i]);
								
							} else if (i <= 11) {
								noodle_panel.add(foodBtns[i]);
								noodle_panel.add(foodName_Lab[i]);
								noodle_panel.add(foodPrice_Lab[i]);
								
							} else if (i <= 15) {
								snack_panel.add(foodBtns[i]);
								snack_panel.add(foodName_Lab[i]);
								snack_panel.add(foodPrice_Lab[i]);
								
							} else {
								drink_panel.add(foodBtns[i]);
								drink_panel.add(foodName_Lab[i]);
								drink_panel.add(foodPrice_Lab[i]);
							}
						}
						
						// @ 버튼 이미지
						foodBtns[0].getImage("C:\\java(KSJ)\\project 이미지\\0장어.jpg");
						foodBtns[1].getImage("C:\\java(KSJ)\\project 이미지\\1비빔밥.jpg");
						foodBtns[2].getImage("C:\\java(KSJ)\\project 이미지\\2불고기.jpg");
						foodBtns[3].getImage("C:\\java(KSJ)\\project 이미지\\3오징어.jpg");
						foodBtns[4].getImage("C:\\java(KSJ)\\project 이미지\\4함박.jpg");
						foodBtns[5].getImage("C:\\java(KSJ)\\project 이미지\\5참치.jpg");
						foodBtns[6].getImage("C:\\java(KSJ)\\project 이미지\\6치킨.jpg");
						foodBtns[7].getImage("C:\\java(KSJ)\\project 이미지\\7어린이.jpg");
						foodBtns[8].getImage("C:\\java(KSJ)\\project 이미지\\100신라면.jpg");
						foodBtns[9].getImage("C:\\java(KSJ)\\project 이미지\\101진라면.jpg");
						foodBtns[10].getImage("C:\\java(KSJ)\\project 이미지\\102짜파.jpg");
						foodBtns[11].getImage("C:\\java(KSJ)\\project 이미지\\103라볶.jpg");
						foodBtns[12].getImage("C:\\java(KSJ)\\project 이미지\\200새우깡.jpg");
						foodBtns[13].getImage("C:\\java(KSJ)\\project 이미지\\201초코송이.jpg");
						foodBtns[14].getImage("C:\\java(KSJ)\\project 이미지\\203양파링.jpg");
						foodBtns[15].getImage("C:\\java(KSJ)\\project 이미지\\204허니.jpg");
						foodBtns[16].getImage("C:\\java(KSJ)\\project 이미지\\400콜라.jpg");
						foodBtns[17].getImage("C:\\java(KSJ)\\project 이미지\\401사이다.jpg");
						foodBtns[18].getImage("C:\\java(KSJ)\\project 이미지\\402봉봉.jpg");
						foodBtns[19].getImage("C:\\java(KSJ)\\project 이미지\\403망고.jpg");
						
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
		
		// ★ 패널 기본 셋팅
		setBackground(new Color(255, 255, 255));
		setBounds(441, 80, 1483, 931);
		setLayout(null); 
	}

}