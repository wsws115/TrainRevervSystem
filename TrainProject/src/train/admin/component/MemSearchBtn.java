package train.admin.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class MemSearchBtn extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	
	JButton searchBtn;
	
	public MemSearchBtn(String text, JTable table) {
		searchBtn = new JButton();
		searchBtn.setText(text);
		searchBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		searchBtn.setForeground(Color.white);
		searchBtn.setBackground(new Color(000, 102, 000));
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
