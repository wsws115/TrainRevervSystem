package train;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import train.calender.CalenderMain;
import train.calender.Calender_Panel;
import train.subway.SubwayPanel;
import train.subway.Subway_Kind;
import train.food.*;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import com.github.lgooddatepicker.components.DatePicker;
//import com.github.lgooddatepicker.components.DateTimePicker;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
    public static JButton selectsubBtn; 
    public static String seatSelect;
    public static int carNum;
    public static JLabel selectPeopleLabel;
    public static List<String> seatSelectString;
    public static JLabel seatSelectLabel;
    public static CardLayout card;
    public static JPanel card_panel;
    public static boolean sub_select = true;
    public static boolean login_who = true;
    public static TrainReserv_Main frame;
    /**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TrainReserv_Main();
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
		
		card = new CardLayout();
		card_panel = new JPanel();
		card_panel.setBackground(new Color(255, 255, 255));
		card_panel.setBounds(441, 80, 1483, 931);
		contentPane.add(card_panel);
		card_panel.setLayout(card);
		
		JPanel subway_panel = new SubwayPanel();
		card_panel.setBounds(441,80,1483,931);
		card_panel.add(subway_panel, "subway");
		
		JPanel calendar_panel = new Calender_Panel();
		card_panel.setBounds(441,80,1483,931);
		card_panel.add(calendar_panel, "calender");
		
		JPanel subway_kind = new Subway_Kind();
		card_panel.setBounds(441,80,1483,931);
		card_panel.add(subway_kind, "subkind");
		
		JPanel seat_panel = new Peopel_select();
		card_panel.setBounds(441,80,1483,931);
		card_panel.add(seat_panel, "select");
		
		JPanel food_panel = new FoodCourtMainPanel();
		food_panel.setBounds(441, 80, 1483, 931);
		card_panel.add(food_panel, "food");
		
		
		JPanel main_panel = new JPanel();
		main_panel.setBackground(new Color(54, 124, 179));
		main_panel.setBounds(0, 0, 1924, 1011);
		contentPane.add(main_panel);
		
		JButton home_btn = new JButton();
		home_btn.setBorderPainted(false);
		home_btn.setContentAreaFilled(false);
		home_btn.setFocusPainted(false);
		
		JButton back_btn = new JButton();
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Train_Main first_frame = new Train_Main();
				first_frame.main(null);
				setVisible(false);
			}
		});
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		
		
		JLabel lblNewLabel = new JLabel("진행사항 아이콘");
		
		JPanel reserv_panel = new JPanel();
		reserv_panel.setAutoscrolls(true);
		reserv_panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		reserv_panel.setBackground(new Color(187, 214, 234));
		reserv_panel.setLayout(null);
		
		JLabel start_place_label = new JLabel("출발");
		start_place_label.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		start_place_label.setBounds(168, 31, 63, 29);
		reserv_panel.add(start_place_label);
		
		JLabel lblNewLabel_1_1 = new JLabel("도착");
		lblNewLabel_1_1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(169, 158, 63, 29);
		reserv_panel.add(lblNewLabel_1_1);
//		card.next(card_panel);
		st_sub_btn = new JButton("서울");
		st_sub_btn.setForeground(Color.WHITE);
		st_sub_btn.setBackground(new Color(0, 128, 192));
		st_sub_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sub_select = true;
			}
		});
		st_sub_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		st_sub_btn.setBounds(45, 82, 319, 49);
		reserv_panel.add(st_sub_btn);
		
		en_sub_btn = new JButton("부산");
		en_sub_btn.setForeground(Color.WHITE);
		en_sub_btn.setBackground(new Color(0, 128, 192));
		en_sub_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sub_select = false;
			}
		});
		en_sub_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		en_sub_btn.setBounds(45, 209, 319, 49);
		reserv_panel.add(en_sub_btn);
		
		JLabel start_date_label = new JLabel("출발일");
		start_date_label.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		start_date_label.setBounds(157, 292, 86, 34);
		reserv_panel.add(start_date_label);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("열차 조회");
		lblNewLabel_1_1_1_1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		lblNewLabel_1_1_1_1.setBounds(146, 415, 114, 34);
		reserv_panel.add(lblNewLabel_1_1_1_1);
		
		ButtonGroup group = new ButtonGroup();
		Calendar calendar = Calendar.getInstance();
		LocalDate ld = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) +1,calendar.get(Calendar.DATE));
		String date = String.valueOf(ld.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		
		date_text = new JTextField(date);
		date_text.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		date_text.setColumns(10);
		date_text.setBounds(99, 343, 186, 41);
		date_text.setEditable(false);
		reserv_panel.add(date_text);
		
		selectsubBtn = new JButton("전체");
		selectsubBtn.setForeground(Color.WHITE);
		selectsubBtn.setBackground(new Color(0, 128, 192));
		selectsubBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		selectsubBtn.setBounds(86, 459, 211, 49);
		reserv_panel.add(selectsubBtn);
		
		JLabel lblNewLabel_1 = new JLabel("전체 인원 :");
		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(12, 550, 152, 54);
		reserv_panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("좌석 선택 :");
		lblNewLabel_1_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(12, 661, 152, 54);
		reserv_panel.add(lblNewLabel_1_2);
		
		seatSelectLabel = new JLabel("X");
		seatSelectLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		seatSelectLabel.setBounds(205, 673, 174, 31);
		reserv_panel.add(seatSelectLabel);
		
		selectPeopleLabel = new JLabel("X");
		selectPeopleLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		selectPeopleLabel.setBounds(205, 562, 80, 31);
		reserv_panel.add(selectPeopleLabel);
		
		JButton previous_btn = new JButton();
		previous_btn.setBorderPainted(false);
		previous_btn.setContentAreaFilled(false);
		previous_btn.setFocusPainted(false);
		previous_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(card_panel);
			}
		});

		GroupLayout gl_main_panel = new GroupLayout(main_panel);
		gl_main_panel.setHorizontalGroup(
			gl_main_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_main_panel.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_main_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_main_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(previous_btn, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(back_btn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(1600)
							.addComponent(home_btn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addComponent(reserv_panel, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE))
					.addGap(30))
		);
		gl_main_panel.setVerticalGroup(
			gl_main_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_main_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_main_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(home_btn, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGap(20)
						.addGroup(gl_main_panel.createSequentialGroup()
							.addGroup(gl_main_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(back_btn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(previous_btn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addComponent(reserv_panel, GroupLayout.PREFERRED_SIZE, 921, GroupLayout.PREFERRED_SIZE)))
					.addGap(5))
		);
		main_panel.setLayout(gl_main_panel);
		
		try {
			home_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/Home.png")).getScaledInstance(70, 60, Image.SCALE_AREA_AVERAGING)));
			
			previous_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/main_back.png")).getScaledInstance(110, 50, Image.SCALE_AREA_AVERAGING)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
