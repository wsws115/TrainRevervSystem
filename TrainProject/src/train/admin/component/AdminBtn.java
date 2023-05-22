package train.admin.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import train.dao.FoodDAO;
import train.dao.MemberDAO;
import train.dao.TicketDAO;

/** JTable내부에 반환버튼생성 클래스 */
public class AdminBtn extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	JButton cancelBtn;

	TicketDAO ticketdao = new TicketDAO();
	FoodDAO fooddao = new FoodDAO();
	MemberDAO memberdao = new MemberDAO();

	public AdminBtn(String text, JTable orderTable) {
		cancelBtn = new JButton();
		cancelBtn.setText(text);
		cancelBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		cancelBtn.setForeground(Color.white);
		cancelBtn.setBackground(Color.red);

		cancelBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = orderTable.getSelectedRow();
				// 차내식 삭제 시, 액션
				if (text.equals("반환")) {
					
					String ticketNum = (String) orderTable.getValueAt(orderTable.getSelectedRow(), 1);
					ticketdao.refundTicket(ticketNum);
					
				} else if (text.equals("삭제")) {
					
					String foodNum = orderTable.getValueAt(row, 0).toString();	
					String imageFileName = orderTable.getValueAt(row, 4).toString();

					String destinationFolder = "resource/";
					Path filePath = Paths.get(destinationFolder + imageFileName);

					fooddao.delectFood(foodNum);
					try {
						Files.delete(filePath);
					} catch (NoSuchFileException err1) {
						System.err.println("삭제하려는 파일 / 디렉토리가 없습니다");
					} catch (IOException err2) {
						err2.printStackTrace();
					}
				// 유저 삭제 시, 액션
				} else if (text.equals("탈퇴")) {		
					
					String userNum = (String) orderTable.getValueAt(orderTable.getSelectedRow(), 0);
					memberdao.withdraw(userNum);
				}

				((DefaultTableModel)orderTable.getModel()).removeRow(row);

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
		return cancelBtn;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
			int column) {
		return cancelBtn;
	}      

}
