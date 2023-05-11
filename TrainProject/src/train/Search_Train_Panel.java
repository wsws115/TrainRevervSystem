package train;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Search_Train_Panel extends JPanel {
	public JTable table;
	public DefaultTableModel model;
	private JSONArray array;
	public String header[]= {"구분","열차번호","출발","출발시간","도착","도착시간","가격","소요시간","우등","일반"};
	private SubwayCode subc;
	private SubwayCategory sub_cg;
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
		table.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		table.setRowHeight(35);
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		table.getColumnModel().getColumn(8).setCellRenderer(new ReservBtn("우등예매", table));
		table.getColumnModel().getColumn(8).setCellEditor(new ReservBtn("우등예매",table));
		table.getColumnModel().getColumn(9).setCellRenderer(new ReservBtn("일반예매",table));
		table.getColumnModel().getColumn(9).setCellEditor(new ReservBtn("일반예매",table));
		table.setAutoCreateRowSorter(true);
		
		subc = new SubwayCode();
		sub_cg = new SubwayCategory();
		String st = subc.sub_map.get(TrainReserv_Main.st_sub_btn.getText());
		String en = subc.sub_map.get(TrainReserv_Main.en_sub_btn.getText());
		String da = TrainReserv_Main.date_text.getText();
		String tanm = TrainReserv_Main.subSelectText;
		System.out.println(tanm);
		if(tanm.equals("전체")) {
			for(String key : sub_cg.sub_category.keySet()) {
				System.out.println(key);
				try {
					String train_nm = sub_cg.sub_category.get(key);
					System.out.println(train_nm);
					train_api_table(st, en, da, train_nm);
				}catch(Exception e) {
					System.out.println("열차 없음.");
				}
			}
		}else {
			String train_nm = sub_cg.sub_category.get(tanm);
			System.out.println(train_nm);
			train_api_table(st, en, da, train_nm);
		}
		
		scrollPane.setViewportView(table);
	}
	
	public void train_api_table(String st, String en, String da, String tanm) {
		Train_API tapi = new Train_API(st, en, da, tanm);
		try {
			array = tapi.train_api();
		    
			for(int i =0; i< array.size(); ++i) {
				JSONObject object = (JSONObject) array.get(i);
//				System.out.println("요금 ==> "+object.get("adultcharge"));
//			    System.out.println("출발역 ==> "+object.get("depplacename"));
//			    System.out.println("출발시간 ==> "+object.get("depplandtime"));
//			    System.out.println("도착역 ==> "+object.get("arrplacename"));
//			    System.out.println("도착시간 ==> "+object.get("arrplandtime"));
//			    System.out.println("열차이름 ==> "+object.get("traingradename"));
//			    System.out.println("열차번호 ==> "+object.get("trainno"));
//			    Object[] str={object.get("traingradename"),object.get("trainno"),
//			    		object.get("arrplacename"),object.get("depplacename"),
//			    		"","","","",object.get("adultcharge"),"",object.get("depplandtime")}; 
//			    System.out.println(str.toString());
				
				LocalDateTime st_date = LocalDateTime.parse(String.valueOf(object.get("depplandtime")), DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
				LocalDateTime en_date = LocalDateTime.parse(String.valueOf(object.get("arrplandtime")), DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
				String st_time = st_date.getHour()+"시"+st_date.getMinute()+"분";
				String en_time = en_date.getHour()+"시"+en_date.getMinute()+"분";
				Duration diff = Duration.between(st_date.toLocalTime(), en_date.toLocalTime());
				long el_hour;
				long el_min;
				if (diff.toHours() < 0 && diff.toMinutes() < 0) {
					el_hour = diff.toHours() + 24;
					el_min = Math.abs(diff.toMinutes()%60);
				}else {
					el_hour = diff.toHours();
					el_min = Math.abs(diff.toMinutes()%60-60);
				}
				String eltime = el_hour + "시간" + el_min+"분";
				
			    model.insertRow(i, new Object[]{object.get("traingradename"),object.get("trainno"),
			    		object.get("depplacename"),st_time,object.get("arrplacename"),en_time,
			    		object.get("adultcharge"),eltime,
			    		"",""
			    });
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
