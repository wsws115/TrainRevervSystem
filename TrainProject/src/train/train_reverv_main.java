package train;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

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
//import com.github.lgooddatepicker.components.TimePicker;


public class train_reverv_main extends JFrame {

	private JPanel contentPane;
	private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					train_reverv_main frame = new train_reverv_main();
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
	public train_reverv_main() {
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
		
		JPanel search_panel = new Search_Train_Panel();
		card_panel.setBounds(441,80,1483,931);
		card_panel.add(search_panel);
		
		JPanel seat_panel = new Seat1();
		card_panel.setBounds(441,80,1483,931);
		card_panel.add(seat_panel);
		
		JPanel food_panel = new FoodCourtPanel();
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
		
		try {
			home_btn.setIcon(
					new ImageIcon(ImageIO.read(
							
							new File("C:\\javafullstack\\javadefalut\\files\\images\\home.jpg"))
							.getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		JButton back_btn = new JButton("");
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train_main first_frame = new train_main();
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
		
		JButton btnNewButton = new JButton("출발역");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(card_panel);
			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		btnNewButton.setBounds(12, 82, 140, 49);
		reserv_panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("도착역");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		btnNewButton_1.setBounds(205, 82, 140, 49);
		reserv_panel.add(btnNewButton_1);
		
		JLabel start_date_label = new JLabel("출발일");
		start_date_label.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		start_date_label.setBounds(150, 173, 86, 34);
		reserv_panel.add(start_date_label);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("열차 조회");
		lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel_1_1_1_1.setBounds(12, 295, 114, 34);
		reserv_panel.add(lblNewLabel_1_1_1_1);
		
//		DatePicker datePicker = new DatePicker();
//		datePicker.setSize(new Dimension(500, 500));
//		datePicker.setMinimumSize(new Dimension(133, 23));
//		datePicker.getComponentToggleCalendarButton().setFont(new Font("맑은 고딕", Font.PLAIN, 20));
//		datePicker.getComponentDateTextField().setFont(new Font("맑은 고딕", Font.PLAIN, 30));
//		datePicker.getComponentToggleCalendarButton().setText("달력");
//		datePicker.setBounds(49, 225, 220, 34);
//		datePicker.setDateToToday();
		
//		reserv_panel.add(datePicker);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 339, 381, 241);
		reserv_panel.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setSelected(true);
		group.add(rdbtnNewRadioButton);
		
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 0;
		panel.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JLabel lblNewLabel_1 = new JLabel("전체");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 3;
		gbc_rdbtnNewRadioButton_1.gridy = 0;
		panel.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_1);
		JLabel lblNewLabel_1_2 = new JLabel("KTX");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 4;
		gbc_lblNewLabel_1_2.gridy = 0;
		panel.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 6;
		gbc_rdbtnNewRadioButton_2.gridy = 0;
		panel.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_2);
		JLabel lblNewLabel_1_4 = new JLabel("ITX-청춘");
		lblNewLabel_1_4.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_4 = new GridBagConstraints();
		gbc_lblNewLabel_1_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_4.gridx = 7;
		gbc_lblNewLabel_1_4.gridy = 0;
		panel.add(lblNewLabel_1_4, gbc_lblNewLabel_1_4);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("");
		GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnNewRadioButton_4.gridx = 3;
		gbc_rdbtnNewRadioButton_4.gridy = 1;
		panel.add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
		group.add(rdbtnNewRadioButton_4);
		JLabel lblNewLabel_1_3 = new JLabel("새마을");
		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_3.gridx = 4;
		gbc_lblNewLabel_1_3.gridy = 1;
		panel.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("");
		GridBagConstraints gbc_rdbtnNewRadioButton_5 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnNewRadioButton_5.gridx = 6;
		gbc_rdbtnNewRadioButton_5.gridy = 1;
		panel.add(rdbtnNewRadioButton_5, gbc_rdbtnNewRadioButton_5);
		group.add(rdbtnNewRadioButton_5);
		
		JLabel lblNewLabel_1_5 = new JLabel("무궁화호");
		lblNewLabel_1_5.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_5 = new GridBagConstraints();
		gbc_lblNewLabel_1_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_5.gridx = 7;
		gbc_lblNewLabel_1_5.gridy = 1;
		panel.add(lblNewLabel_1_5, gbc_lblNewLabel_1_5);
		
//		TimePicker timePicker = new TimePicker();
//		timePicker.setBounds(281, 225, 97, 34);
//		timePicker.setTimeToNow();
//		reserv_panel.add(timePicker);
		try {
			back_btn.setIcon(
					new ImageIcon(ImageIO.read(
							new File("C:\\javafullstack\\javadefalut\\files\\images\\backkey.jpg"))
							.getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
