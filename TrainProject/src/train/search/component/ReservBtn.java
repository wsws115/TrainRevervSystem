package train.search.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import train.search.Search_Train_Panel;
import train.seat_special.SpecialSeatSelect;
import train.seat_standard.StandardSeatSelect;

public class ReservBtn  extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
	JButton reservBtn;
	String mainpont = "HY헤드라인M";
	public static String name;
	public static String num;
	public static String st_time;
	public static String en_time;
	public static String price;
	public static String timetaken;
	// 음식이름 0, 가격 1, - 2, 수량 3, + 4, 취소 5
	
	public ReservBtn(String text, JTable stp_table) {
		reservBtn = new JButton();
		reservBtn.setText(text);

		reservBtn.setFont(new Font(mainpont, Font.PLAIN, 18));
		reservBtn.setForeground(Color.white);
		reservBtn.setBackground(new Color(0, 49, 74));
    	
		reservBtn.addActionListener(e -> {

	    		if (text.equals("우등예매")) {
	    			System.out.println(stp_table.getSelectedRow());
	    			SpecialSeatSelect sd = new SpecialSeatSelect();
	    			int row = stp_table.getSelectedRow();
	    			name = (String) stp_table.getValueAt(row, 0);
	    			System.out.println(name);
	    			num = String.valueOf(stp_table.getValueAt(row, 1)) ;
	    			System.out.println(num);
	    			st_time = String.valueOf(stp_table.getValueAt(row, 2));
	    			System.out.println(st_time);
	    			en_time = String.valueOf(stp_table.getValueAt(row, 3));
	    			System.out.println(en_time);
	    			price = String.valueOf(stp_table.getValueAt(row, 5));
	    			System.out.println(price);
	    			timetaken = String.valueOf(stp_table.getValueAt(row, 4));
	    			System.out.println(timetaken);
	    			sd.setVisible(true);
	    			// 수량 + 1
//	    			int addQty = (int) reserv_dtm.getValueAt(rev_table.getSelectedRow(), 3) + 1;	
//	    			
//	    			if (addQty < 1) {
//	    				addQty = 1;
//	    			}
//	    			
//	    			reserv_dtm.setValueAt(addQty, rev_table.getSelectedRow(), 3);
	    			
	    			
	    		} else if (text.equals("일반예매")) {
	    			System.out.println(stp_table.getSelectedRow());
	    			StandardSeatSelect sb = new StandardSeatSelect();
	    			int row = stp_table.getSelectedRow();
	    			name = (String) stp_table.getValueAt(row, 0);
	    			num = String.valueOf(stp_table.getValueAt(row, 1));
	    			st_time = String.valueOf(stp_table.getValueAt(row, 2));
	    			en_time = String.valueOf(stp_table.getValueAt(row, 3));
	    			price = String.valueOf(stp_table.getValueAt(row, 7));
	    			timetaken = String.valueOf(stp_table.getValueAt(row, 4));
	    			sb.setVisible(true);
	    			// 수량 - 1
//	    			int minusQty = (int) reserv_dtm.getValueAt(rev_table.getSelectedRow(), 3) - 1;	
//	    			
//	    			if (minusQty < 1) {
//	    				minusQty = 1;
//	    			}		
//	    			reserv_dtm.setValueAt(minusQty, rev_table.getSelectedRow(), 3);
	    		}
		});
	}
    			
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return reservBtn;
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return reservBtn;
	}

}
