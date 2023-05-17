package train.food.component;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class OrderTable extends JTable {
	
	String mainpont = "HY헤드라인M";
	
	public static final int SEATROW = 0;
	public static final int NAMEROW = 1;
	public static final int PRICEROW = 2;
	public static final int MINUSROW = 3;
	public static final int QTYROW = 4;
	public static final int PLUSROW = 5;
	public static final int CANCELROW = 6;
	
	public OrderTable(DefaultTableModel order_dtm) {
		
		setModel(order_dtm);
		
		// 테이블 서식 설정
		// "좌석번호", "음식이름", "가격", "-", "수량", "+", "취소"
			setRowHeight(30);
			setFont(new Font(mainpont, Font.PLAIN, 20));	
			getTableHeader().setFont(new Font(mainpont, Font.BOLD, 25));
			DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
			// 중앙 정렬
			celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
			getColumn("좌석번호").setCellRenderer(celAlignCenter);
			getColumn("음식이름").setCellRenderer(celAlignCenter);
			getColumn("가격").setCellRenderer(celAlignCenter);
			getColumn("수량").setCellRenderer(celAlignCenter);
			// 열 너비 설정
			getColumn("좌석번호").setPreferredWidth(70);
			getColumn("음식이름").setPreferredWidth(250);
			getColumn("가격").setPreferredWidth(150);
			getColumn("수량").setPreferredWidth(70);
			getColumn("+").setPreferredWidth(10);
			getColumn("-").setPreferredWidth(10);
			getColumn("취소").setPreferredWidth(10);
		
		// 테이블 이동, 크기 조절 불가
		getTableHeader().setReorderingAllowed(false);
		getTableHeader().setReorderingAllowed(false);
		
		// user_table plus, minus 버튼 추가		
		getColumnModel().getColumn(MINUSROW).setCellRenderer(new OrderTableBtn("-", order_dtm, this));
		getColumnModel().getColumn(MINUSROW).setCellEditor(new OrderTableBtn("-", order_dtm, this));
		
		getColumnModel().getColumn(PLUSROW).setCellRenderer(new OrderTableBtn("+", order_dtm, this));
		getColumnModel().getColumn(PLUSROW).setCellEditor(new OrderTableBtn("+", order_dtm, this));
		
		getColumnModel().getColumn(CANCELROW).setCellRenderer(new OrderTableBtn("X", order_dtm, this));
		getColumnModel().getColumn(CANCELROW).setCellEditor(new OrderTableBtn("X", order_dtm, this));		
	}
	
	/** 테이블의 모든 행 값을 구하는 메소드 */
	public void getTableAllValue() {
		
		
		
	}
	
}
