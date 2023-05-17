package train.food.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import train.food.FoodCourtMainPanel;

public class OrderTableBtn extends AbstractCellEditor implements TableCellEditor, TableCellRenderer, MouseListener {
    
	JButton count_Btn;
	String mainpont = "HY헤드라인M";
	DefaultTableModel model;
	
    public OrderTableBtn(String text, DefaultTableModel model, JTable user_table) {
    	this.model = model;
    	
    	count_Btn = new JButton();
    	count_Btn.setText(text);

    	count_Btn.setFont(new Font(mainpont, Font.PLAIN, 18));
    	count_Btn.setForeground(Color.white);
    	count_Btn.setBackground(new Color(0, 49, 74));
    	
    	count_Btn.addMouseListener(this);
    	
    	count_Btn.addActionListener(e -> {

    		if (text.equals("+")) {
    			// 수량 + 1
    			int addQty = (int) model.getValueAt(user_table.getSelectedRow(), OrderTable.QTYROW) + 1;	
    			
    			if (addQty < 1) {
    				addQty = 1;
    			}
    			
    			model.setValueAt(addQty, user_table.getSelectedRow(), OrderTable.QTYROW);
    			
    		} else if (text.equals("-")) {
    			// 수량 - 1
    			int minusQty = (int) model.getValueAt(user_table.getSelectedRow(), OrderTable.QTYROW) - 1;	
    			
    			if (minusQty < 1) {
    				minusQty = 1;
    			}		
    			model.setValueAt(minusQty, user_table.getSelectedRow(), OrderTable.QTYROW);
    			
    		} else if (text.equals("X")) {	    			
    			
    			// 테이블 행 삭제 전에, 테이블 변경을 중지하고 삭제 진행	
    			if (user_table.isEditing()) {
    				user_table.getCellEditor().stopCellEditing();
    				model.removeRow(user_table.getSelectedRow());
    			}
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		FoodCourtMainPanel.getTotalPrice(model);	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}	
}
