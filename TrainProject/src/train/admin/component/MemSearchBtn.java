package train.admin.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import train.admin.AdminFrame;
import train.ticket.Rev_detail;

public class MemSearchBtn extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	
	JButton searchBtn;
	public static String ticket_code;
	public MemSearchBtn(String text, JTable table) {
		searchBtn = new JButton();
		searchBtn.setText(text);
		searchBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		searchBtn.setForeground(Color.white);
		searchBtn.setBackground(new Color(000, 102, 000));
		searchBtn.addActionListener(e ->{
			if (text.equals("출력")) {
				int row = table.getSelectedRow();
				Rev_detail rev = new Rev_detail();
				ticket_code = String.valueOf(table.getValueAt(row, 0));
				System.out.println(ticket_code);
//				rev.ticket_code = String.valueOf(table.getValueAt(row, 0));
				rev.chk_admin = true;
				rev.chk_login = true;
				rev.main(null);
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
		return searchBtn;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return searchBtn;
	}

}
