package train;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import foodcourt.component.FoodBtn;
import foodcourt.component.FoodLab;
import foodcourt.component.MenuBtn;

public class FoodCourtPanel extends JPanel {
	
	private JTable table;
	
	String mainpont = "HY헤드라인M";
	
	// ★ [상] 메뉴 대분류
	private MenuBtn meal_MenuBtn, noodle_MenuBtn, snack_MenuBtn, drink_MenuBtn;
	
	// ★ [중] 메뉴 세분류
	private CardLayout cardLayout = new CardLayout();
	private JPanel main_Menupanel, meal_panel, noodle_panel, snack_panel, drink_panel;
	private JScrollPane meal_sf, noodle_sf, snack_sf, drink_sf;	
	
	// ★ [하] 유저 테이블
	private JPanel user_panel;
	private JScrollPane user_sp; // 유저 테이블 스크롤
	private String[] title = {"음식이름", "가격", "-", "수량", "+", "취소"};
							// 음식이름 0, 가격 1, - 2, 수량 3, + 4, 취소 5	
	private DefaultTableModel user_dtm = new DefaultTableModel(title, 0); // 테이블 값 관리
	private JTable user_table; // 사용자가 선택한 메뉴 표출 테이블
	private JLabel title_Lab, total_Lab, totalPrice_Lab; // 총 가격이 출력 될 라벨
	private JButton select_Btn, cancel_Btn; // 선택 취소, 선택 완료 버튼
	
	/** [하] 테이블에 따라 총 가격을 구하는 메소드 */
	void getTotalPrice() {
		int sum = 0;
		
		for (int i = 0; i < user_dtm.getRowCount(); ++i) {
			int qty = 0;
			
			if (user_dtm.getColumnCount() != 0) {
				qty = (int) user_dtm.getValueAt(i, 3);
			}
			
			sum += (int) user_dtm.getValueAt(i, 1) * qty;
		}
		// 테이블에 따라 총 가격 셋팅
		totalPrice_Lab.setText(String.valueOf(sum) + "원");
	}
	
	
	/**
	 * Create the panel.
	 */
	
	public FoodCourtMainPanel() {
		
		// ★ [하]
		
		// @ 유저 패널
		user_panel = new JPanel();
		user_panel.setVisible(true);
		user_panel.setBackground(new Color(255, 255, 255));
		user_panel.setBounds(90, 700, 894, 180);
		user_panel.setLayout(new BorderLayout(10, 10));
		add(user_panel);
		
			// @ 하단 타이틀 라벨
			title_Lab = new JLabel("【 선택한 메뉴 】");
			user_panel.add(title_Lab, BorderLayout.NORTH);
			title_Lab.setFont(new Font(mainpont, Font.PLAIN, 20));
			
			// @ user_table
			user_table = new JTable(user_dtm);
			user_table.setModel(user_dtm);
			user_sp = new JScrollPane(user_table);
			
				// user_table 내부 글꼴 설정
				user_table.setRowHeight(30);
				user_table.setFont(new Font(mainpont, Font.PLAIN, 20));	
				user_table.getTableHeader().setFont(new Font(mainpont, Font.BOLD, 25));
				DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
				// 중앙 정렬
				celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
				user_table.getColumn("음식이름").setCellRenderer(celAlignCenter);
				user_table.getColumn("가격").setCellRenderer(celAlignCenter);
				user_table.getColumn("수량").setCellRenderer(celAlignCenter);
				// 열 너비 설정
				user_table.getColumn("음식이름").setPreferredWidth(250);
				user_table.getColumn("가격").setPreferredWidth(150);
				user_table.getColumn("수량").setPreferredWidth(70);
				user_table.getColumn("+").setPreferredWidth(10);
				user_table.getColumn("-").setPreferredWidth(10);
				user_table.getColumn("취소").setPreferredWidth(10);
				
				// 테이블 이동, 크기 조절 불가
				user_table.getTableHeader().setReorderingAllowed(false);
				user_table.getTableHeader().setReorderingAllowed(false);
				
				// user_table plus, minus 버튼 추가
				// 음식이름 0, 가격 1, - 2, 수량 3, + 4, 취소 5
				user_table.getColumnModel().getColumn(2).setCellRenderer(new countBtn("-"));
				user_table.getColumnModel().getColumn(2).setCellEditor(new countBtn("-"));
				
				user_table.getColumnModel().getColumn(4).setCellRenderer(new countBtn("+"));
				user_table.getColumnModel().getColumn(4).setCellEditor(new countBtn("+"));
				
				user_table.getColumnModel().getColumn(5).setCellRenderer(new countBtn("X"));
				user_table.getColumnModel().getColumn(5).setCellEditor(new countBtn("X"));				
		    
			// 유저 패널에 JTable 넣음
	        user_panel.add(user_sp, BorderLayout.CENTER);
	
		// ★ [하] 총계만 써진 단순 라벨
		total_Lab = new JLabel("총 계 :");
		total_Lab.setFont(new Font(mainpont, Font.PLAIN, 30));
		total_Lab.setBounds(742, 880, 106, 44);
		add(total_Lab);
		
		// @ FoodBtn을 누르면, 총 합계가 들어갈 가격 라벨
		totalPrice_Lab = new JLabel("0 원");
		totalPrice_Lab.setFont(new Font(mainpont, Font.PLAIN, 30));
		totalPrice_Lab.setBounds(860, 880, 141, 44);
		add(totalPrice_Lab);
		
		// @ 전체 취소 버튼 누르면, JTable 내용 모두 삭제
		cancel_Btn = new JButton("<html>전체<br> 취소</html>");
		cancel_Btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		cancel_Btn.setForeground(Color.white);
		cancel_Btn.setBackground(new Color(0, 128, 192));
		cancel_Btn.setBounds(1016, 734, 162, 146);
		add(cancel_Btn);
		// 액션 시, 버튼 삭제
		cancel_Btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				user_dtm.setRowCount(0); // 전체 행 삭제
				user_dtm.fireTableDataChanged(); // 데이터 저장				
				user_table.repaint(); // 데이터 새로고침
				
				getTotalPrice(); // 가격 새로고침
			}
		});
		
		// @ 선택 완료 누르면, 다음 단계로
		select_Btn = new JButton("다음");
		select_Btn.setFont(new Font(mainpont, Font.PLAIN, 30));
		select_Btn.setForeground(Color.white);
		select_Btn.setBackground(new Color(0, 128, 192));
		select_Btn.setBounds(1218, 734, 178, 146);
		add(select_Btn); // [하] - 끝 -
		
		// 선택 완료는 아직 구현 안함 (버튼만 존재)
		
		// ★ [중] - 하단 total Price 때문에 [하] 밑으로 넣음
		
			// @ 메뉴 카드들을 넣을 부모 패널 (카드 레이아웃 설정됨)
			main_Menupanel = new JPanel();
			main_Menupanel.setLayout(cardLayout);
			main_Menupanel.setBounds(90, 139, 1306, 538);
		
		// @ 자식 패널들		
						// ＠ 1번 - 식사류 패널
						meal_panel = new JPanel();
						meal_panel.setPreferredSize(new Dimension(1000, 700));
						meal_panel.setBounds(100, 100, 1200, 2000);
						meal_panel.setBackground(new Color(255, 255, 255));
							// 1번 카드 스크롤
						meal_sf = new JScrollPane(meal_panel);
						meal_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						meal_panel.setAutoscrolls(false);
						meal_panel.setLayout(null);
						
							// 1번 스크롤 프레임 옵션
						meal_sf.setPreferredSize(new Dimension(800, 300));
						meal_sf.setBounds(90, 180, 1306, 497);
						meal_sf.getVerticalScrollBar().setUnitIncrement(30);
						
						// ＠ 2번 - 면류 패널
						noodle_panel = new JPanel();
						noodle_panel.setPreferredSize(new Dimension(1000, 700));
						noodle_panel.setBounds(100, 100, 1200, 2000);
						noodle_panel.setBackground(new Color(255, 255, 255));
							// 2번 카드 스크롤
						noodle_sf = new JScrollPane(noodle_panel);
						noodle_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						noodle_panel.setAutoscrolls(false);
						noodle_panel.setLayout(null);
						
							// 2번 스크롤 프레임 옵션
						noodle_sf.setPreferredSize(new Dimension(800, 300));
						noodle_sf.setBounds(90, 180, 1306, 497);
						noodle_sf.getVerticalScrollBar().setUnitIncrement(30);
						
						// ＠ 3번 - 간식류 패널
						snack_panel = new JPanel();
						snack_panel.setPreferredSize(new Dimension(1000, 700));
						snack_panel.setBounds(100, 100, 1200, 2000);
						snack_panel.setBackground(new Color(255, 255, 255));
							// 3번 스크롤
						snack_sf = new JScrollPane(snack_panel);
						snack_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						snack_panel.setAutoscrolls(false);
						snack_panel.setLayout(null);
						
							// 3번 스크롤 프레임 옵션
						snack_sf.setPreferredSize(new Dimension(800, 300));
						snack_sf.setBounds(90, 180, 1306, 497);
						snack_sf.getVerticalScrollBar().setUnitIncrement(30);
						
						// ＠ 4번 - 음료 패널
						drink_panel = new JPanel();
						drink_panel.setPreferredSize(new Dimension(1000, 700));
						drink_panel.setBounds(100, 100, 1200, 2000);
						drink_panel.setBackground(new Color(255, 255, 255));
							// 4번 스크롤
						drink_sf = new JScrollPane(drink_panel);
						drink_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						drink_panel.setAutoscrolls(false);
						drink_panel.setLayout(null);
						
							// 4번 스크롤 프레임 옵션
						drink_sf.setPreferredSize(new Dimension(800, 300));
						drink_sf.setBounds(90, 180, 1306, 497);
						drink_sf.getVerticalScrollBar().setUnitIncrement(30);
					
		// @ 패널 내부 메뉴 버튼들
						// @ 1.  meal_panel 버튼, 메뉴명 라벨, 가격 라벨
						FoodBtn eelBtn = new FoodBtn("장어덮밥", 11000, user_dtm, totalPrice_Lab);
						eelBtn.getImage("C:\\java(KSJ)\\project 이미지\\0장어.jpg");
						eelBtn.setLocation(80, 60);
						meal_panel.add(eelBtn);
						
						FoodBtn bibimBabBtn = new FoodBtn("비빔밥", 9000, user_dtm, totalPrice_Lab);
						bibimBabBtn.getImage("C:\\java(KSJ)\\project 이미지\\1비빔밥.jpg");
						bibimBabBtn.setLocation(400, 60);
						meal_panel.add(bibimBabBtn);
						
						FoodBtn bulgogiBtn = new FoodBtn("불고기덮밥", 9000, user_dtm, totalPrice_Lab);
						bulgogiBtn.getImage("C:\\java(KSJ)\\project 이미지\\2불고기.jpg");
						bulgogiBtn.setLocation(700, 60);
						meal_panel.add(bulgogiBtn);
						
						FoodBtn squidBtn = new FoodBtn("오징어덮밥", 9000, user_dtm, totalPrice_Lab);
						squidBtn.getImage("C:\\java(KSJ)\\project 이미지\\3오징어.jpg");
						squidBtn.setLocation(1000, 60);
						meal_panel.add(squidBtn);
						
						FoodBtn hamBtn = new FoodBtn("함박스테이크", 10000, user_dtm, totalPrice_Lab);
						hamBtn.getImage("C:\\java(KSJ)\\project 이미지\\4함박.jpg");
						hamBtn.setLocation(80, 300);
						meal_panel.add(hamBtn);
						
						FoodBtn tunaBtn = new FoodBtn("참치마요컵밥", 7000, user_dtm, totalPrice_Lab);
						tunaBtn.getImage("C:\\java(KSJ)\\project 이미지\\5참치.jpg");
						tunaBtn.setLocation(400, 300);
						meal_panel.add(tunaBtn);
						
						FoodBtn chickenBtn = new FoodBtn("치킨마요컵밥", 7000, user_dtm, totalPrice_Lab);
						chickenBtn.getImage("C:\\java(KSJ)\\project 이미지\\6치킨.jpg");
						chickenBtn.setLocation(700, 300);
						meal_panel.add(chickenBtn);	
						
						FoodBtn childBtn = new FoodBtn("꾸러기 도시락", 6000, user_dtm, totalPrice_Lab);
						childBtn.getImage("C:\\java(KSJ)\\project 이미지\\7어린이.jpg");
						childBtn.setLocation(1000, 300);
						meal_panel.add(childBtn);
						
						JLabel eelLab = new FoodLab(eelBtn.getName());
						eelLab.setLocation(80, 30);
						meal_panel.add(eelLab);
						
						JLabel eelPriceLab = new FoodLab(eelBtn.getPrice() + "원");
						eelPriceLab.setLocation(80, 220);
						meal_panel.add(eelPriceLab);
						
						JLabel bibimBabLab = new FoodLab(bibimBabBtn.getName());
						bibimBabLab.setLocation(400, 30);
						meal_panel.add(bibimBabLab);
						
						JLabel bibimBabPriceLab = new FoodLab(bibimBabBtn.getPrice() + "원");
						bibimBabPriceLab.setLocation(400, 220);
						meal_panel.add(bibimBabPriceLab);
						
						JLabel bulgogiLab = new FoodLab(bulgogiBtn.getName());
						bulgogiLab.setLocation(700, 30);
						meal_panel.add(bulgogiLab);
						
						JLabel bulgogiPriceLab = new FoodLab(bulgogiBtn.getPrice() + "원");
						bulgogiPriceLab.setLocation(700, 220);
						meal_panel.add(bulgogiPriceLab);
						
						JLabel squidLab = new FoodLab(squidBtn.getName());
						squidLab.setLocation(1000, 30);
						meal_panel.add(squidLab);
						
						JLabel squidPriceLab = new FoodLab(squidBtn.getPrice() + "원");
						squidPriceLab.setLocation(1000, 220);
						meal_panel.add(squidPriceLab);
						
						JLabel hamLab = new FoodLab(hamBtn.getName());
						hamLab.setLocation(80, 270);
						meal_panel.add(hamLab);
						
						JLabel hamPriceLab = new FoodLab(hamBtn.getPrice() + "원");
						hamPriceLab.setLocation(80, 460);
						meal_panel.add(hamPriceLab);
						
						JLabel tunaLab = new FoodLab(tunaBtn.getName());
						tunaLab.setLocation(700, 270);
						meal_panel.add(tunaLab);
						
						JLabel tunaPriceLab = new FoodLab(tunaBtn.getPrice() + "원");
						tunaPriceLab.setLocation(700, 460);
						meal_panel.add(tunaPriceLab);
						
						JLabel chickenLab = new FoodLab(chickenBtn.getName());
						chickenLab.setLocation(400, 270);
						meal_panel.add(chickenLab);
						
						JLabel chickenPriceLab = new FoodLab(chickenBtn.getPrice() + "원");
						chickenPriceLab.setLocation(400, 460);
						meal_panel.add(chickenPriceLab);			
						
						JLabel childLab = new FoodLab(childBtn.getName());
						childLab.setLocation(1000, 270);
						meal_panel.add(childLab);
						
						JLabel childPriceLab = new FoodLab(childBtn.getPrice() + "원");
						childPriceLab.setLocation(1000, 460);
						meal_panel.add(childPriceLab);		
						
						// @ 2. noodle_panel 버튼, 메뉴명 라벨, 가격 라벨
						FoodBtn sinramen_Btn = new FoodBtn("신라면 컵", 2000, user_dtm, totalPrice_Lab);
						sinramen_Btn.getImage("C:\\java(KSJ)\\project 이미지\\100신라면.jpg");
						sinramen_Btn.setLocation(80, 60);
						noodle_panel.add(sinramen_Btn);
						
						JLabel sinramen_Lab = new FoodLab(sinramen_Btn.getName());
						sinramen_Lab.setLocation(80, 30);
						noodle_panel.add(sinramen_Lab);
						
						JLabel sinramenPrice_Lab = new FoodLab(sinramen_Btn.getPrice() + "원");
						sinramenPrice_Lab.setLocation(80, 220);
						noodle_panel.add(sinramenPrice_Lab);
						
						FoodBtn jinramen_Btn = new FoodBtn("진라면 컵", 2000, user_dtm, totalPrice_Lab);
						jinramen_Btn.getImage("C:\\java(KSJ)\\project 이미지\\101진라면.jpg");
						jinramen_Btn.setLocation(400, 60);
						noodle_panel.add(jinramen_Btn);
						
						JLabel jinramen_Lab = new FoodLab(jinramen_Btn.getName());
						jinramen_Lab.setLocation(400, 30);
						noodle_panel.add(jinramen_Lab);
						
						JLabel jinramenPrice_Lab = new FoodLab(jinramen_Btn.getPrice() + "원");
						jinramenPrice_Lab.setLocation(400, 220);
						noodle_panel.add(jinramenPrice_Lab);
						
						FoodBtn zzaramen_Btn = new FoodBtn("짜파게티 컵", 2000, user_dtm, totalPrice_Lab);
						zzaramen_Btn.getImage("C:\\java(KSJ)\\project 이미지\\102짜파.jpg");
						zzaramen_Btn.setLocation(700, 60);
						noodle_panel.add(zzaramen_Btn);
						
						JLabel zzaramen_Lab = new FoodLab(zzaramen_Btn.getName());
						zzaramen_Lab.setLocation(700, 30);
						noodle_panel.add(zzaramen_Lab);
						
						JLabel zzaramenPrice_Lab = new FoodLab(zzaramen_Btn.getPrice() + "원");
						zzaramenPrice_Lab.setLocation(700, 220);
						noodle_panel.add(zzaramenPrice_Lab);
						
						FoodBtn stirnoodles_Btn = new FoodBtn("라면볶이 컵", 2000, user_dtm, totalPrice_Lab);
						stirnoodles_Btn.getImage("C:\\java(KSJ)\\project 이미지\\103라볶.jpg");
						stirnoodles_Btn.setLocation(1000, 60);
						noodle_panel.add(stirnoodles_Btn);
						
						JLabel stirnoodles_Lab = new FoodLab(stirnoodles_Btn.getName());
						stirnoodles_Lab.setLocation(1000, 30);
						noodle_panel.add(stirnoodles_Lab);
						
						JLabel stirnoodlesPrice_Lab = new FoodLab(stirnoodles_Btn.getPrice() + "원");
						stirnoodlesPrice_Lab.setLocation(1000, 220);
						noodle_panel.add(stirnoodlesPrice_Lab);
						
						// @ 3. snack_panel 버튼, 메뉴명 라벨, 가격 라벨
						FoodBtn s_SnackBtn = new FoodBtn("새우깡", 1200, user_dtm, totalPrice_Lab);
						s_SnackBtn.getImage("C:\\java(KSJ)\\project 이미지\\200새우깡.jpg");
						s_SnackBtn.setLocation(80, 60);
						snack_panel.add(s_SnackBtn);
						
						JLabel s_SnackLab = new FoodLab(s_SnackBtn.getName());
						s_SnackLab.setLocation(80, 30);
						snack_panel.add(s_SnackLab);
						
						JLabel s_SnackPriceLab = new FoodLab(s_SnackBtn.getPrice() + "원");
						s_SnackPriceLab.setLocation(80, 220);
						snack_panel.add(s_SnackPriceLab);
						
						FoodBtn c_SnackBtn = new FoodBtn("초코송이", 1000, user_dtm, totalPrice_Lab);
						c_SnackBtn.getImage("C:\\java(KSJ)\\project 이미지\\201초코송이.jpg");
						c_SnackBtn.setLocation(400, 60);
						snack_panel.add(c_SnackBtn);
						
						JLabel c_SnackLab = new FoodLab(c_SnackBtn.getName());
						c_SnackLab.setLocation(400, 30);
						snack_panel.add(c_SnackLab);
						
						JLabel c_SnackPriceLab = new FoodLab(s_SnackBtn.getPrice() + "원");
						c_SnackPriceLab.setLocation(400, 220);
						snack_panel.add(c_SnackPriceLab);
						
						FoodBtn o_SnackBtn = new FoodBtn("양파링", 1400, user_dtm, totalPrice_Lab);
						o_SnackBtn.getImage("C:\\java(KSJ)\\project 이미지\\203양파링.jpg");
						o_SnackBtn.setLocation(700, 60);
						snack_panel.add(o_SnackBtn);
						
						JLabel o_SnackLab = new FoodLab(o_SnackBtn.getName());
						o_SnackLab.setLocation(700, 30);
						snack_panel.add(o_SnackLab);
						
						JLabel o_SnackPriceLab = new FoodLab(o_SnackBtn.getPrice() + "원");
						o_SnackPriceLab.setLocation(700, 220);
						snack_panel.add(o_SnackPriceLab);
						
						FoodBtn honey_SnackBtn = new FoodBtn("허니버터칩", 2000, user_dtm, totalPrice_Lab);
						honey_SnackBtn.getImage("C:\\java(KSJ)\\project 이미지\\204허니.jpg");
						honey_SnackBtn.setLocation(1000, 60);
						snack_panel.add(honey_SnackBtn);
						
						JLabel honey_SnackLab = new FoodLab(honey_SnackBtn.getName());
						honey_SnackLab.setLocation(1000, 30);
						snack_panel.add(honey_SnackLab);
						
						JLabel honey_SnackPriceLab = new FoodLab(honey_SnackBtn.getPrice() + "원");
						honey_SnackPriceLab.setLocation(1000, 220);
						snack_panel.add(honey_SnackPriceLab);
						
						FoodBtn twisted_SnackBtn = new FoodBtn("꿀꽈배기", 2000, user_dtm, totalPrice_Lab);
						twisted_SnackBtn.getImage("C:\\java(KSJ)\\project 이미지\\205꿀꽈배기.jpg");
						twisted_SnackBtn.setLocation(80, 300);
						snack_panel.add(twisted_SnackBtn);
						
						JLabel twisted_SnackLab = new FoodLab(twisted_SnackBtn.getName());
						twisted_SnackLab.setLocation(80, 270);
						snack_panel.add(twisted_SnackLab);
						
						JLabel twistedPrice_Lab = new FoodLab(twisted_SnackBtn.getPrice() + "원");
						twistedPrice_Lab.setLocation(80, 460);
						snack_panel.add(twistedPrice_Lab);
						
						// @ 4. drink_panel 버튼, 메뉴명 라벨, 가격 라벨
						FoodBtn b_DrinkBtn = new FoodBtn("봉봉", 800, user_dtm, totalPrice_Lab);
						b_DrinkBtn.getImage("C:\\java(KSJ)\\project 이미지\\400봉봉.jpg");
						b_DrinkBtn.setLocation(80, 60);
						drink_panel.add(b_DrinkBtn);
						
						JLabel b_DrinkLab = new FoodLab(b_DrinkBtn.getName());
						b_DrinkLab.setLocation(80, 30);
						drink_panel.add(b_DrinkLab);
						
						JLabel b_DrinkPriceLab = new FoodLab(b_DrinkBtn.getPrice() + "원");
						b_DrinkPriceLab.setLocation(80, 220);
						drink_panel.add(b_DrinkPriceLab);
						
						FoodBtn cola_DrinkBtn = new FoodBtn("코카콜라", 1000, user_dtm, totalPrice_Lab);
						cola_DrinkBtn.getImage("C:\\java(KSJ)\\project 이미지\\401콜라.jpg");
						cola_DrinkBtn.setLocation(400, 60);
						drink_panel.add(cola_DrinkBtn);						
						
						JLabel cola_DrinkLab = new FoodLab(cola_DrinkBtn.getName());
						cola_DrinkLab.setLocation(400, 30);
						drink_panel.add(cola_DrinkLab);
						
						JLabel cola_DrinkPriceLab = new FoodLab(cola_DrinkBtn.getPrice() + "원");
						cola_DrinkPriceLab.setLocation(400, 220);
						drink_panel.add(cola_DrinkPriceLab);
					
		// @ 메뉴 부모 패널들에 자식 스크롤 추가
		main_Menupanel.add("pane1", meal_sf);
		main_Menupanel.add("pane2", noodle_sf);
		main_Menupanel.add("pane3", snack_sf);
		main_Menupanel.add("pane4", drink_sf);
		
		add(main_Menupanel); // [중] - 끝 -
					
		
		
		// ★ [상] - card 패널 show 때문에 [중] 밑으로 두었음
			
			// @ 메뉴 버튼들
			meal_MenuBtn = new MenuBtn("식사류", cardLayout, main_Menupanel, "pane1");
			meal_MenuBtn.setLocation(94, 29);
			add(meal_MenuBtn);
			
			noodle_MenuBtn = new MenuBtn("면류", cardLayout, main_Menupanel, "pane2");
			noodle_MenuBtn.setLocation(440, 29);
			add(noodle_MenuBtn);
	
			snack_MenuBtn = new MenuBtn("간식", cardLayout, main_Menupanel, "pane3");
			snack_MenuBtn.setLocation(778, 29);
			add(snack_MenuBtn);
			
			drink_MenuBtn = new MenuBtn("음료", cardLayout, main_Menupanel, "pane4");
			drink_MenuBtn.setLocation(1148, 29);
			add(drink_MenuBtn); // [상] - 끝 -		
		
		// ★ 패널 기본 셋팅
		setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		setBounds(0, 0, 1500, 1010);
		setLayout(null);
		
		// 테이블 ?
        table.setRowHeight(30);
        table.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        choicePanel.add(table, BorderLayout.CENTER); 
	}
	
	/** JTable 내부에 plus, minus, 삭제 버튼 생성 클래스 */
	class countBtn extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	     
		JButton count_Btn;
		
	    public countBtn(String text) {
	    	count_Btn = new JButton();
	    	count_Btn.setText(text);

	    	count_Btn.setFont(new Font(mainpont, Font.PLAIN, 18));
	    	count_Btn.setForeground(Color.white);
	    	count_Btn.setBackground(new Color(0, 49, 74));
	    	
	    	count_Btn.addActionListener(e -> {
	    		// 음식이름 0, 가격 1, - 2, 수량 3, + 4, 취소 5

	    		if (text.equals("+")) {
	    			// 수량 + 1
	    			int addQty = (int) user_dtm.getValueAt(user_table.getSelectedRow(), 3) + 1;	
	    			
	    			if (addQty < 1) {
	    				addQty = 1;
	    			}
	    			
	    			user_dtm.setValueAt(addQty, user_table.getSelectedRow(), 3);
	    			
	    			getTotalPrice(); // 현재 총 가격 리턴
	    			
	    		} else if (text.equals("-")) {
	    			// 수량 - 1
	    			int minusQty = (int) user_dtm.getValueAt(user_table.getSelectedRow(), 3) - 1;	
	    			
	    			if (minusQty < 1) {
	    				minusQty = 1;
	    			}		
	    			user_dtm.setValueAt(minusQty, user_table.getSelectedRow(), 3);
	    			
	    			getTotalPrice(); // 현재 총 가격 리턴
	    			
	    		} else if (text.equals("X")) {	    			
	    			
	    			// 하 ..... 
	    				    			
	    			// 행 선택하면 삭제
	    			if (user_table.getSelectedRow() >= 0) {
		    			user_dtm.removeRow(user_table.getSelectedRow());
		    			user_dtm.fireTableDataChanged(); // 데이터 저장
		    			user_table.repaint(); // 데이터 새로고침
	    			}
	    				    			
	    			getTotalPrice(); // 현재 총 가격 리턴 
	    		}		
            });
	    }
	     
	    @Override
	    public Object getCellEditorValue() {
	        return null;
	    }
	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
	            int row, int column) {
	        return count_Btn;
	    }
	    @Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
	            int column) {
	        return count_Btn;
	    }	
	}

}


