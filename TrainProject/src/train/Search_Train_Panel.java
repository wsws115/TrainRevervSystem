package train;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import train.search_component.ReservBtn;
import train.table_button.TableActionEvent;
//import train.table_button.TableCellEditor;
import train.table_button.TableCellReader;
import train.table_button.Table_button;

import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Search_Train_Panel extends JPanel {
	public JTable table;
	public DefaultTableModel model;
	private JSONArray array;
	public String header[]= {"구분","열차번호","출발","도착","우등","일반","유아","입석","가격","소요시간"};
	private SubwayCode subc;
	
	/**
	 * Create the panel.
	 */
	public static JScrollPane scrollPane;
	public Search_Train_Panel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1480, 930);
		add(panel);
		
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
//		scrollPane.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		scrollPane.setBounds(0, 0, 1470, 920);
		panel.add(scrollPane);
		model = new DefaultTableModel(header,0);
		table = new JTable(model);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		table.setRowHeight(35);
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		table.getColumnModel().getColumn(4).setCellRenderer(new ReservBtn("우등예매", table));
		table.getColumnModel().getColumn(4).setCellEditor(new ReservBtn("우등예매",table));
		table.getColumnModel().getColumn(5).setCellRenderer(new ReservBtn("일반예매",table));
		table.getColumnModel().getColumn(5).setCellEditor(new ReservBtn("일반예매",table));
		table.getColumnModel().getColumn(6).setCellRenderer(new ReservBtn("유아예매",table));
		table.getColumnModel().getColumn(6).setCellEditor(new ReservBtn("유아예매",table));
		table.getColumnModel().getColumn(7).setCellRenderer(new ReservBtn("입석예매",table));
		table.getColumnModel().getColumn(7).setCellEditor(new ReservBtn("입석예매",table));
		
		subc = new SubwayCode();
		String st = subc.sub_map.get(TrainReserv_Main.st_sub_btn.getText());
		String en = subc.sub_map.get(TrainReserv_Main.en_sub_btn.getText());
		String da = TrainReserv_Main.date_text.getText();
		String tanm = TrainReserv_Main.train_text.getText();
		
		System.out.println("?여기");
		Train_API tapi = new Train_API(st, en, da, tanm);
//		Search_Train_Panel search_panel = new Search_Train_Panel();
//		DefaultTableModel model = (DefaultTableModel) search_panel.table.getModel();
		try {
			array = tapi.train_api();
		    
			for(int i =0; i< array.size(); ++i) {
				JSONObject object = (JSONObject) array.get(i);
//				System.out.println("요금 ==> "+object.get("adultcharge"));
//			    System.out.println("출발역 ==> "+object.get("arrplacename"));
//			    System.out.println("출발시간 ==> "+object.get("arrplandtime"));
//			    System.out.println("도착역 ==> "+object.get("depplacename"));
//			    System.out.println("도착시간 ==> "+object.get("depplandtime"));
//			    System.out.println("열차이름 ==> "+object.get("traingradename"));
//			    System.out.println("열차번호 ==> "+object.get("trainno"));
//			    Object[] str={object.get("traingradename"),object.get("trainno"),
//			    		object.get("arrplacename"),object.get("depplacename"),
//			    		"","","","",object.get("adultcharge"),"",object.get("depplandtime")}; 
//			    System.out.println(str.toString());
			    model.insertRow(i, new Object[]{object.get("traingradename"),object.get("trainno"),
			    		object.get("arrplacename"),object.get("depplacename"),
			    		"","","","",
			    		object.get("adultcharge"),object.get("depplandtime")});
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
       
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

