package train;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import train.calender.CalenderMain;
import train.table_button.TableCellReader;

//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import com.github.lgooddatepicker.components.DatePicker;
//import com.github.lgooddatepicker.components.DateTimePicker;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
//import com.github.lgooddatepicker.components.CalendarPanel;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import com.github.lgooddatepicker.components.TimePicker;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;

/**
 * @author LJH
 *
 */
public class TrainReserv_Main extends JFrame {

	
	private JPanel contentPane;
	private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
    
    public static JTextField date_text;
    public static JButton st_sub_btn;
    public static JButton en_sub_btn;
    public static String subSelectText;
    
    
    public static boolean sub_select = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainReserv_Main frame = new TrainReserv_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrainReserv_Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CardLayout card = new CardLayout();
		JPanel card_panel = new JPanel();
		card_panel.setBounds(441, 80, 1483, 931);
		contentPane.add(card_panel);
		card_panel.setLayout(card);
		
		JPanel subway_panel = new SubwayPanel();
		card_panel.setBounds(441,80,1483,931);
		card_panel.add(subway_panel);
		
		JPanel seat_panel = new Seat1();
		card_panel.setBounds(441,80,1483,931);
		card_panel.add(seat_panel);
		
		JPanel food_panel = new FoodCourtMainPanel();
		food_panel.setBounds(441, 80, 1483, 931);
		
		card_panel.add(food_panel);
		
		
		JPanel main_panel = new JPanel();
		main_panel.setBackground(new Color(54, 124, 179));
		main_panel.setBounds(0, 0, 1924, 1011);
		contentPane.add(main_panel);
		main_panel.setLayout(null);
		
		JButton home_btn = new JButton("");
		home_btn.setBounds(1832, 10, 80, 50);
		main_panel.add(home_btn);
		home_btn.setBorderPainted(false);
		home_btn.setContentAreaFilled(false);
		home_btn.setFocusPainted(false);
		
//		try {
//			home_btn.setIcon(
//					new ImageIcon(ImageIO.read(
//							
//							new File("C:\\javafullstack\\javadefalut\\files\\images\\home.jpg"))
//							.getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		
		JButton back_btn = new JButton("");
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Train_Main first_frame = new Train_Main();
				first_frame.main(null);
				setVisible(false);
			}
		});
		back_btn.setBounds(12, 10, 66, 50);
		main_panel.add(back_btn);
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		
		
		JLabel lblNewLabel = new JLabel("진행사항 아이콘");
		lblNewLabel.setBounds(440, 10, 246, 50);
		main_panel.add(lblNewLabel);
		
		JPanel reserv_panel = new JPanel();
		reserv_panel.setAutoscrolls(true);
		reserv_panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		reserv_panel.setBackground(new Color(31, 173, 203));
		reserv_panel.setBounds(12, 80, 417, 921);
		main_panel.add(reserv_panel);
		reserv_panel.setLayout(null);
		
		JLabel start_place_label = new JLabel("출발");
		start_place_label.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		start_place_label.setBounds(12, 31, 256, 29);
		reserv_panel.add(start_place_label);
		
		JLabel lblNewLabel_1_1 = new JLabel("도착");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(205, 31, 63, 29);
		reserv_panel.add(lblNewLabel_1_1);
//		card.next(card_panel);
		st_sub_btn = new JButton("서울");
		st_sub_btn.setForeground(Color.WHITE);
		st_sub_btn.setBackground(new Color(0, 128, 129));
		st_sub_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sub_select = true;
			}
		});
		st_sub_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		st_sub_btn.setBounds(45, 82, 140, 49);
		reserv_panel.add(st_sub_btn);
		
		en_sub_btn = new JButton("부산");
		en_sub_btn.setForeground(Color.WHITE);
		en_sub_btn.setBackground(new Color(0, 128, 129));
		en_sub_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sub_select = false;
			}
		});
		en_sub_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		en_sub_btn.setBounds(205, 82, 140, 49);
		reserv_panel.add(en_sub_btn);
		
		JLabel start_date_label = new JLabel("출발일");
		start_date_label.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		start_date_label.setBounds(150, 173, 86, 34);
		reserv_panel.add(start_date_label);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("열차 조회");
		lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel_1_1_1_1.setBounds(12, 295, 114, 34);
		reserv_panel.add(lblNewLabel_1_1_1_1);
		
		ButtonGroup group = new ButtonGroup();
		
		JButton search_btn = new JButton("조회");
		search_btn.setForeground(Color.WHITE);
		search_btn.setBackground(new Color(0, 128, 129));
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel search_panel = new Search_Train_Panel();
				card_panel.setBounds(441,80,1483,931);
				card_panel.add(search_panel, "기차API");
				card.show(card_panel, "기차API");
			} 
		});
		search_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		search_btn.setBounds(128, 667, 140, 49);
		reserv_panel.add(search_btn);
		
		
		JButton next_btn = new JButton("다음");
		next_btn.setForeground(Color.WHITE);
		next_btn.setBackground(new Color(0, 128, 129));
		next_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(card_panel);
			} 
		});
		next_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		next_btn.setBounds(202, 828, 140, 49);
		reserv_panel.add(next_btn);
		
		JButton previous_btn = new JButton("이전");
		previous_btn.setForeground(Color.WHITE);
		previous_btn.setBackground(new Color(0, 128, 129));
		previous_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(card_panel);
			}
		});
		previous_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		previous_btn.setBounds(45, 828, 140, 49);
		reserv_panel.add(previous_btn);
		
		date_text = new JTextField();
		date_text.setColumns(10);
		date_text.setBounds(99, 223, 186, 41);
		date_text.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				CalenderMain calender = new CalenderMain();
				calender.setVisible(true);
			}
		
		});
		
		reserv_panel.add(date_text);
		
		JButton allSubBtn = new JButton("전체");
		allSubBtn.setForeground(Color.WHITE);
		allSubBtn.setBackground(new Color(0, 128, 129));
		allSubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subSelectText = allSubBtn.getText();
			}
		});
		allSubBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		allSubBtn.setBounds(86, 339, 211, 49);
		reserv_panel.add(allSubBtn);
		
		JButton subKtxBtn = new JButton("KTX");
		subKtxBtn.setForeground(Color.WHITE);
		subKtxBtn.setBackground(new Color(0, 128, 129));
		subKtxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subSelectText = subKtxBtn.getText();
			}
		});
		subKtxBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		subKtxBtn.setBounds(45, 398, 140, 49);
		reserv_panel.add(subKtxBtn);
		
		JButton subSrtBtn = new JButton("SRT");
		subSrtBtn.setForeground(Color.WHITE);
		subSrtBtn.setBackground(new Color(0, 128, 129));
		subSrtBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subSelectText = subSrtBtn.getText();
			}
		});
		subSrtBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		subSrtBtn.setBounds(205, 398, 140, 49);
		reserv_panel.add(subSrtBtn);
		
		JButton subNewBtn = new JButton("새마을호");
		subNewBtn.setForeground(Color.WHITE);
		subNewBtn.setBackground(new Color(0, 128, 129));
		subNewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subSelectText = subNewBtn.getText();
			}
		});
		subNewBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		subNewBtn.setBounds(45, 457, 140, 49);
		reserv_panel.add(subNewBtn);
		
		JButton subFlowerBtn = new JButton("무궁화호");
		subFlowerBtn.setForeground(Color.WHITE);
		subFlowerBtn.setBackground(new Color(0, 128, 129));
		subFlowerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subSelectText = subFlowerBtn.getText();
			}
		});
		subFlowerBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		subFlowerBtn.setBounds(205, 457, 140, 49);
		reserv_panel.add(subFlowerBtn);
		
		JButton subYungItxBtn = new JButton("ITX-청춘");
		subYungItxBtn.setForeground(Color.WHITE);
		subYungItxBtn.setBackground(new Color(0, 128, 129));
		subYungItxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subSelectText = subYungItxBtn.getText();
			}
		});
	    subYungItxBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
	    subYungItxBtn.setBounds(45, 516, 140, 49);
		reserv_panel.add(subYungItxBtn);
		
		JButton subNewItxBtn = new JButton("ITX-새마을");
		subNewItxBtn.setForeground(Color.WHITE);
		subNewItxBtn.setBackground(new Color(0, 128, 129));
		subNewItxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subSelectText = subNewItxBtn.getText();
			}
		});
		subNewItxBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 21));
		subNewItxBtn.setBounds(205, 516, 140, 49);
		reserv_panel.add(subNewItxBtn);
		
		
		
//		TimePicker timePicker = new TimePicker();
//		timePicker.setBounds(281, 225, 97, 34);
//		timePicker.setTimeToNow();
//		reserv_panel.add(timePicker);
//		try {
//			back_btn.setIcon(
//					new ImageIcon(ImageIO.read(
//							new File("C:\\javafullstack\\javadefalut\\files\\images\\backkey.jpg"))
//							.getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
//			
//			
//			
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
	}
}
