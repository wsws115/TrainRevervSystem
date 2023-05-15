package train.train_food_component;

import java.awt.Component;
import java.awt.Font;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class OrderTableCombo extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	
	JComboBox<String> choiceSeat;
	String mainpont = "HY헤드라인M";
	
	String[] seats = {"1A", "1B", "1C"};
	
	public OrderTableCombo() {
		choiceSeat = new JComboBox<String>(seats);
		choiceSeat.setFont(new Font(mainpont, Font.PLAIN, 20));
	}
	
	 @Override
	    public Object getCellEditorValue() {
	        return null;
	    }
	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
	            int row, int column) {
	        return choiceSeat;
	    }
	    @Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
	            int column) {
	        return choiceSeat;
	    }

}
