package train;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import train.table_button.TableActionEvent;
import train.table_button.TableCellEditor;
import train.table_button.TableCellReader;
import train.table_button.Table_button;

import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search_Train_Panel extends JPanel {
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public Search_Train_Panel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1480, 930);
		add(panel);
		
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		scrollPane.setBounds(0, 0, 1470, 920);
		panel.add(scrollPane);
		String header[]= {"구분","열차번호","출발","도착","우등","일반","유아","입석","가격","예약대기","소요시간"};
	    String train[][] = {
	          {"KTX","15","대전","서울","","","","","23700","","1:55"},
	          {"KTX","13","대전","서울","","","","","23700","","1:58"} 
	    };
		table = new JTable(train, header);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		table.setRowHeight(35);
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 25));
//		table.getColumnModel().getColumn(4).setCellRenderer(new TableCellReader());
//		TableActionEvent event = new TableActionEvent() {
//
//			@Override
//			public void onEdit(int row) {
//				
//			}
//		};
//		table.getColumnModel().getColumn(4).setCellEditor(new TableCellEditor(event));
		scrollPane.setViewportView(table);
		

	}
	
}
