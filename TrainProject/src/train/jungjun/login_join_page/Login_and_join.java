package train.jungjun.login_join_page;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Login_and_join extends JFrame {
	
	private JPanel contentPane;
	private JTextField id_textField;
	private JPasswordField pw_passwordField;
	private JTextField id_textField_2;
	private JTextField id_textField_3;
	private JPasswordField pw_passwordField_2;
	private JTextField name_textField;
	private JTextField name_textField_3;
	private JTextField phone_textField;
	private JTextField phone_textField_3;
	private JTextField birthday_textField;
	private JTextField email_textField;
	
	public static String id = "";
	public static String pw = "";
	
	public static String id2 = "";
	public static String pw2 = "";
	public static String name = "";
	public static String phone_number = "";
	public static String birthday = "";
	public static String email = "";
	public static String preferential_treatment = "";
	public static String name1 = "";
	
	public static boolean pw_chk_B = false;
	public static boolean email_chk_B = false;
	public static boolean num_chk_B = false;
	public static boolean birthday_chk_B = false;
	public static boolean preferential_treatment_chk_B = false;
	public static boolean id_chk_B = false;
	public static boolean name_chk_B = false;
	
	public static String name2 = "";
	public static String phone_number2 = "";
	
	public static String id3 = "";
	public static String name3 = "";
	public static String phone_number3 = "";
	
	ImageIcon img3 = new ImageIcon
			("C:/java_PJJ/Java_project_Jungjun/Application/images/E-RAIL.png");
			//("C:/Users/USER/git/TrainRevervSystem/TrainProject/images/E-RAIL.png");
	ImageIcon img7 = new ImageIcon
			("C:/java_PJJ/Java_project_Jungjun/Application/images/back.PNG");
			//("C:/Users/USER/git/TrainRevervSystem/TrainProject/images/back.png");
	ImageIcon img1 = new ImageIcon
			("C:/java_PJJ/Java_project_Jungjun/Application/images/radio_button_off.PNG");
	ImageIcon img2 = new ImageIcon
			("C:/java_PJJ/Java_project_Jungjun/Application/images/radio_button_on.PNG");
	
	
	Image img = img3.getImage();
 	Image updateImg = img.getScaledInstance(400, 330, Image.SCALE_SMOOTH);
    ImageIcon updateIcon = new ImageIcon(updateImg);
    private JTextField name_textField_2;
    private JTextField phone_textField_2;
    //private JLabel id_label_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_and_join frame = new Login_and_join();
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
	public Login_and_join() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1920, 1080);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel login = new JPanel();
		layeredPane.add(login, "name_29419370275400");
		login.setLayout(null);
		
		JLabel id_label = new JLabel("아이디");
		id_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		id_label.setBounds(585, 437, 200, 100);
		login.add(id_label);
		
		JLabel pw_label = new JLabel("비밀번호");
		pw_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		pw_label.setBounds(585, 567, 250, 100);
		login.add(pw_label);
		
		id_textField = new JTextField();
		id_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		id_textField.setBounds(885, 437, 400, 100);
		login.add(id_textField);
		id_textField.setColumns(10);
		
		pw_passwordField = new JPasswordField();
		pw_passwordField.setFont(new Font("굴림", Font.PLAIN, 50));
		pw_passwordField.setBounds(885, 567, 400, 100);
		login.add(pw_passwordField);
		
		JButton check_btn = new JButton("로그인");
		check_btn.setForeground(Color.WHITE);
		check_btn.setBackground(new Color(0, 128, 192));
		check_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				id = id_textField.getText();
				pw = pw_passwordField.getText();
				
				Login_and_joinDAO dao = new Login_and_joinDAO();
				boolean login_result = dao.login_chk();
				System.out.println("로그인 성공 여부 " + login_result);
			}	
		});
		check_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		check_btn.setBounds(585, 727, 700, 100);
		login.add(check_btn);
		
		JLabel E_RAIL = new JLabel(updateIcon);
		E_RAIL.setBounds(675, 30, 400, 330);
		login.add(E_RAIL);
		
		JButton back_main_btn = new JButton(img7);
		back_main_btn.setBounds(10, 10, 136, 136);
		login.add(back_main_btn);
		back_main_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.Train_Main main_frame =
						new train.Train_Main();
				main_frame.main(null);
				setVisible(false);
			}
		});
		//back_main_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 70));
		back_main_btn.setBorderPainted(false);
		back_main_btn.setContentAreaFilled(false);
		back_main_btn.setFocusPainted(false);
		
		JButton join_btn = new JButton("회원가입");
		join_btn.setBorderPainted(false);
		join_btn.setContentAreaFilled(false);
		join_btn.setFocusPainted(false);
		join_btn.setBounds(1400, 857, 350, 100);
		login.add(join_btn);
		join_btn.setForeground(new Color(0, 128, 192));
		
		
//		JButton join_btn = new JButton("회원가입");
//		join_btn.setForeground(new Color(0, 128, 192));
//		join_btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				layeredPane.removeAll();
//				layeredPane.add(join);
//				layeredPane.repaint();
//				layeredPane.revalidate();
//			}
//		});
		
		join_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 70));
		
		JButton find_id_btn = new JButton("ID 찾기");
		find_id_btn.setBorderPainted(false);
		find_id_btn.setContentAreaFilled(false);
		find_id_btn.setFocusPainted(false);
		find_id_btn.setForeground(new Color(0, 128, 192));
		find_id_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 70));
		find_id_btn.setBounds(475, 857, 275, 100);
		login.add(find_id_btn);
		
		JButton find_pw_btn = new JButton("PASSWORD 찾기");
		find_pw_btn.setForeground(new Color(0, 128, 192));
		find_pw_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 70));
		find_pw_btn.setFocusPainted(false);
		find_pw_btn.setContentAreaFilled(false);
		find_pw_btn.setBorderPainted(false);
		find_pw_btn.setBounds(750, 857, 600, 100);
		login.add(find_pw_btn);
		
		JPanel join = new JPanel();
		layeredPane.add(join, "name_29419379635300");
		join.setLayout(null);
		
		JButton back_login_btn = new JButton(img7);
		back_login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.Train_Main.gojoin = false;
				Find_id_jd.gopwfind = false;
				layeredPane.removeAll();
				layeredPane.add(login);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		back_login_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 70));
		back_login_btn.setFocusPainted(false);
		back_login_btn.setContentAreaFilled(false);
		back_login_btn.setBorderPainted(false);
		back_login_btn.setBounds(10, 10, 136, 136);
		join.add(back_login_btn);
		
		JLabel id_label_2 = new JLabel("아이디");
		id_label_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		id_label_2.setBounds(550, 150, 200, 75);
		join.add(id_label_2);
		
		JLabel join_label = new JLabel("회원가입");
		join_label.setHorizontalAlignment(SwingConstants.CENTER);
		join_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 70));
		join_label.setBounds(125, 150, 400, 100);
		join.add(join_label);
		
		JLabel pw_label_2 = new JLabel("비밀번호");
		pw_label_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		pw_label_2.setBounds(550, 235, 200, 75);
		join.add(pw_label_2);
		
		id_textField_2 = new JTextField();
		id_textField_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		id_textField_2.setColumns(10);
		id_textField_2.setBounds(800, 150, 400, 75);
		join.add(id_textField_2);
		
		pw_passwordField_2 = new JPasswordField();
		pw_passwordField_2.setFont(new Font("굴림", Font.PLAIN, 40));
		pw_passwordField_2.setBounds(800, 235, 400, 75);
			
		join.add(pw_passwordField_2);
		
		JLabel name_label = new JLabel("이름");
		name_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		name_label.setBounds(550, 320, 200, 75);
		join.add(name_label);
		
		JLabel phone_label = new JLabel("전화번호");
		phone_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		phone_label.setBounds(550, 485, 250, 75);
		join.add(phone_label);
		
		name_textField = new JTextField();
		name_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		name_textField.setBounds(800, 320, 400, 75);
		join.add(name_textField);
		name_textField.setColumns(10);
		
		phone_textField = new JTextField();
		phone_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		phone_textField.setBounds(800, 485, 400, 75);
		join.add(phone_textField);
		phone_textField.setColumns(10);
		
		JLabel birthday_label = new JLabel("생년월일");
		birthday_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		birthday_label.setBounds(550, 400, 200, 75);
		join.add(birthday_label);
		
		JLabel email_label = new JLabel("이메일");
		email_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		email_label.setBounds(550, 570, 250, 75);
		join.add(email_label);
		
		birthday_textField = new JTextField();
		birthday_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		birthday_textField.setBounds(800, 405, 400, 75);
		join.add(birthday_textField);
		birthday_textField.setColumns(10);
		
		email_textField = new JTextField();
		email_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		email_textField.setBounds(800, 570, 400, 75);
		join.add(email_textField);
		email_textField.setColumns(10);
		
		JButton check_btn_2 = new JButton("가입 완료");
		check_btn_2.setForeground(Color.WHITE);
		check_btn_2.setBackground(new Color(0, 128, 192));
		check_btn_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		check_btn_2.setBounds(650, 775, 700, 100);
		join.add(check_btn_2);
		
		JButton chk_overlap_btn = new JButton("중복 확인");
		chk_overlap_btn.setForeground(Color.WHITE);
		chk_overlap_btn.setBackground(new Color(0, 128, 192));
		chk_overlap_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id2 = id_textField_2.getText();
				CheckDAO dao3 = new CheckDAO();
				dao3.id_check();
			}
		});
		chk_overlap_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		chk_overlap_btn.setBounds(1250, 160, 180, 60);
		join.add(chk_overlap_btn);
		
		JLabel pw_alrim = new JLabel();
		pw_alrim.setFont(new Font("굴림", Font.PLAIN, 20));
		pw_alrim.setBounds(1250, 235, 500, 60);
		join.add(pw_alrim);
		
		JLabel email_alrim = new JLabel();
		email_alrim.setFont(new Font("굴림", Font.PLAIN, 20));
		email_alrim.setBounds(1250, 570, 400, 60);
		join.add(email_alrim);
		
		JLabel number_alrim = new JLabel();
		number_alrim.setFont(new Font("굴림", Font.PLAIN, 20));
		number_alrim.setBounds(1250, 485, 400, 60);
		join.add(number_alrim);
		
		JLabel birthday_alrim = new JLabel();
		birthday_alrim.setFont(new Font("굴림", Font.PLAIN, 20));
		birthday_alrim.setBounds(1250, 400, 400, 60);
		join.add(birthday_alrim);
		
		JLabel preferential_treatment_label = new JLabel("우대 사항");
		preferential_treatment_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		preferential_treatment_label.setBounds(550, 645, 250, 75);
		join.add(preferential_treatment_label);
		
		JRadioButton default_radio_btn = new JRadioButton("기본");
		default_radio_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		default_radio_btn.setBounds(800, 645, 125, 75);
		default_radio_btn.setIcon(img1);
		
		JRadioButton disabled_radio_btn = new JRadioButton("장애인");
		disabled_radio_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		disabled_radio_btn.setBounds(930, 645, 150, 75);
		disabled_radio_btn.setIcon(img1);
		
		JRadioButton national_merit_radio_btn = new JRadioButton("국가유공자");
		national_merit_radio_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		national_merit_radio_btn.setBounds(1090, 645, 250, 75);
		national_merit_radio_btn.setIcon(img1);
//		join.add(national_merit_radio_btn);
		
		JButton preferential_treatment_btn = new JButton("확인");
		preferential_treatment_btn.setForeground(Color.WHITE);
		preferential_treatment_btn.setBackground(new Color(0, 128, 192));
		preferential_treatment_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		preferential_treatment_btn.setBounds(1350, 650, 130, 60);
		join.add(preferential_treatment_btn);
		
		default_radio_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				default_radio_btn.setIcon(img2);
				disabled_radio_btn.setIcon(img1);
				national_merit_radio_btn.setIcon(img1);
			}
		});
		
		disabled_radio_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				default_radio_btn.setIcon(img1);
				disabled_radio_btn.setIcon(img2);
				national_merit_radio_btn.setIcon(img1);
			}
		});
		
		national_merit_radio_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				default_radio_btn.setIcon(img1);
				disabled_radio_btn.setIcon(img1);
				national_merit_radio_btn.setIcon(img2);
			}
		});
		
		ButtonGroup group = new ButtonGroup();
		group.add(default_radio_btn);
		group.add(disabled_radio_btn);
		group.add(national_merit_radio_btn);
		
		join.add(default_radio_btn);
		join.add(disabled_radio_btn);
		join.add(national_merit_radio_btn);
		
		JLabel id_alrim = new JLabel();
		id_alrim.setFont(new Font("굴림", Font.PLAIN, 20));
		id_alrim.setBounds(1450, 160, 400, 60);
		join.add(id_alrim);
		
		JLabel name_alrim = new JLabel();
		name_alrim.setFont(new Font("굴림", Font.PLAIN, 20));
		name_alrim.setBounds(1250, 320, 400, 60);
		join.add(name_alrim);
		
		JPanel password_find = new JPanel();
		layeredPane.add(password_find);
		password_find.setLayout(null);
		
		JButton back_login_btn2 = new JButton(img7);
		back_login_btn2.setFocusPainted(false);
		back_login_btn2.setContentAreaFilled(false);
		back_login_btn2.setBorderPainted(false);
		back_login_btn2.setBounds(10, 10, 136, 136);
		password_find.add(back_login_btn2);
		
		JLabel id_label_3;
		id_label_3 = new JLabel("아이디");
		id_label_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		id_label_3.setBounds(550, 375, 200, 75);
		password_find.add(id_label_3);
		
		JLabel name_label_3 = new JLabel("이름");
		name_label_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		name_label_3.setBounds(550, 525, 200, 75);
		password_find.add(name_label_3);
		
		name_textField_3 = new JTextField();
		name_textField_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		name_textField_3.setBounds(800, 525, 400, 75);
		password_find.add(name_textField_3);
		name_textField_3.setColumns(10);
		
		id_textField_3 = new JTextField();
		id_textField_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		id_textField_3.setColumns(10);
		id_textField_3.setBounds(800, 375, 400, 75);
		password_find.add(id_textField_3);
		
		JLabel phone_label_3 = new JLabel("전화번호");
		phone_label_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		phone_label_3.setBounds(550, 675, 250, 75);
		password_find.add(phone_label_3);
		
		phone_textField_3 = new JTextField();
		phone_textField_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		phone_textField_3.setBounds(800, 675, 400, 75);
		password_find.add(phone_textField_3);
		phone_textField_3.setColumns(10);
		
		JButton find_pw_select_btn = new JButton("확인");
		find_pw_select_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 70));
		find_pw_select_btn.setBackground(new Color(0, 128, 192));
		find_pw_select_btn.setForeground(Color.WHITE);
		find_pw_select_btn.setBounds(550, 800, 300, 100);
		password_find.add(find_pw_select_btn);
		
		JLabel find_pw = new JLabel("비밀번호 재설정");
		find_pw.setHorizontalAlignment(SwingConstants.CENTER);
		find_pw.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		find_pw.setBounds(170, 60, 375, 100);
		password_find.add(find_pw);
		
		JLabel E_RAIL_3 = new JLabel(updateIcon);
		E_RAIL_3.setBounds(675, 30, 400, 330);
		password_find.add(E_RAIL_3);
		
		JPanel id_find = new JPanel();
		layeredPane.add(id_find, "name_46900319103700");
		id_find.setLayout(null);
		
		JLabel find_id = new JLabel("아이디 찾기");
		find_id.setBounds(170, 60, 350, 100);
		find_id.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		id_find.add(find_id);
		
		JButton back_login_btn3 = new JButton(img7);
		back_login_btn3.setBounds(10, 10, 136, 136);
		back_login_btn3.setFocusPainted(false);
		back_login_btn3.setContentAreaFilled(false);
		back_login_btn3.setBorderPainted(false);
		id_find.add(back_login_btn3);
		
		JLabel name_label_2 = new JLabel("이름");
		name_label_2.setBounds(550, 400, 200, 75);
		name_label_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		name_label_2.setEnabled(true);
		id_find.add(name_label_2);
		
		name_textField_2 = new JTextField();
		name_textField_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		name_textField_2.setBounds(800, 400, 400, 75);
		id_find.add(name_textField_2);
		name_textField_2.setColumns(10);
		
		JLabel phone_label_2 = new JLabel("전화번호");
		phone_label_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		phone_label_2.setBounds(550, 600, 200, 75);
		id_find.add(phone_label_2);
		
		phone_textField_2 = new JTextField();
		phone_textField_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		phone_textField_2.setBounds(800, 600, 400, 75);
		id_find.add(phone_textField_2);
		phone_textField_2.setColumns(10);
		
		JButton find_id_select_btn = new JButton("확인");
		find_id_select_btn.setForeground(Color.WHITE);
		find_id_select_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		find_id_select_btn.setBackground(new Color(0, 128, 192));
		find_id_select_btn.setBounds(550, 800, 300, 100);
		id_find.add(find_id_select_btn);
		
		JLabel E_RAIL_2 = new JLabel(updateIcon);
		E_RAIL_2.setBounds(675, 30, 400, 330);
		id_find.add(E_RAIL_2);
		
		find_pw_select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id3 = id_textField_3.getText();
				name3 = name_textField_3.getText();
				phone_number3 = phone_textField_3.getText();
				Find_pwDAO DAO = new Find_pwDAO();
				if(DAO.find_pw()) {
					Find_pw_Jd pw_jd = new Find_pw_Jd();
					pw_jd.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"정확히 입력하세요");
				}
				
			}
		});
		
		find_id_select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name2 = name_textField_2.getText();
				phone_number2 = phone_textField_2.getText();
				Find_id_jd id_jd = new Find_id_jd();
				id_jd.setVisible(true);
			}
		});
		
		preferential_treatment_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
				UIManager.put("OptionPane.messageFont",
						new Font("HY헤드라인M", Font.BOLD, 50));
				 if (default_radio_btn.isSelected()) {
					 preferential_treatment = "default";
					 preferential_treatment_chk_B = true;
					 JOptionPane.showMessageDialog(null,"기본이 선택되었습니다");
				 }else if(disabled_radio_btn.isSelected()) {
					 preferential_treatment = "disabled";
					 preferential_treatment_chk_B = true;
					 JOptionPane.showMessageDialog(null,"장애인이 선택되었습니다");
				 }else if(national_merit_radio_btn.isSelected()) {
					 preferential_treatment = "national_merit";
					 preferential_treatment_chk_B = true;
					 JOptionPane.showMessageDialog(null,"국가 유공자가 선택되었습니다");
				 }
			}
		});
		join_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.Train_Main.gojoin = false;
				Find_id_jd.gopwfind = false;
				layeredPane.removeAll();
				layeredPane.add(join);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		find_pw_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.Train_Main.gojoin = false;
				Find_id_jd.gopwfind = false;
				layeredPane.removeAll();
				layeredPane.add(password_find);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		back_login_btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.Train_Main.gojoin = false;
				Find_id_jd.gopwfind = false;
				layeredPane.removeAll();
				layeredPane.add(login);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		back_login_btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.Train_Main.gojoin = false;
				Find_id_jd.gopwfind = false;
				layeredPane.removeAll();
				layeredPane.add(login);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		find_id_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(id_find);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		pw_passwordField_2.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				PW_chk pw = new PW_chk();
				pw2 = pw_passwordField_2.getText();
				if(pw.pw_chk(pw2)) {
					pw_alrim.setText("사용 가능한 비밀번호입니다");
					pw_chk_B = true;
				}else {
					pw_alrim.setText("6자리이상 영어 대문자,소문자,숫자,특수문자를 포함하세요");
				}
			}
		});
		
		email_textField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				email = email_textField.getText();
				Email_chk email_1 = new Email_chk();
				if(email_1.email_chk(email)) {
					email_alrim.setText("이메일을 정확히 입력하셨습니다");
					email_chk_B = true;
				}else {
					email_alrim.setText("이메일을 정확히 입력하세요");
				}
			}
		});
		
		phone_textField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				phone_number = phone_textField.getText();
				Number_chk number_1 = new Number_chk();
				if(number_1.number_chk(phone_number)) {
					number_alrim.setText("올바른 전화번호입니다");
					num_chk_B = true;
				}else {
					number_alrim.setText("-를 포함하여 입력하세요");
				}
			}
		});
		
		birthday_textField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				birthday = birthday_textField.getText();
				Birthday_chk chk_birthday = new Birthday_chk();
				if(chk_birthday.birthday_chk(birthday)) {
					birthday_alrim.setText("올바른 생년월일입니다");
					birthday_chk_B = true;
				}else {
					birthday_alrim.setText("-를 포함하여 올바른 값을 입력하세요");
				}
			}
		});
		
		id_textField_2.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				id2 = id_textField_2.getText();
				boolean result1 = id2.matches("^\\w*admin+\\w*$");
				boolean result2 = id2.matches("^\\w*Admin+\\w*$");
				boolean result3 = id2.matches("^\\w*ADMIN+\\w*$");
				ID_chk id = new ID_chk();
				if(result1 || result2 || result3) {
					id_alrim.setText("admin을 포함하지 마세요");
				}else if(id.id_chk(id2)){
					id_alrim.setText("올바른 아이디입니다");
					id_chk_B = true;
				}else {
					id_alrim.setText("4~20자리 영문자,숫자를 입력하세요");
				}
			}
		});
		
		name_textField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				name1 = name_textField.getText();
				Name_chk name = new Name_chk();
				if(name.name_chk(name1)) {
					name_alrim.setText("올바른 이름입니다");
					name_chk_B = true;
				}else {
					name_alrim.setText("2자리 이상 한글을 입력하세요");
				}
			}
		});
		
		check_btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id2 = id_textField_2.getText();
				pw2 = pw_passwordField_2.getText();
				name = name_textField.getText();
				phone_number = phone_textField.getText();
				birthday = birthday_textField.getText();
				email = email_textField.getText();
				
				JoinDAO dao2 = new JoinDAO();
				boolean join_result = dao2.join_chk();
				System.out.println("회원가입 성공 여부 : " + join_result);
				}
		});
		
		if(train.Train_Main.gojoin) {
			layeredPane.removeAll();
			layeredPane.add(join);
			layeredPane.repaint();
			layeredPane.revalidate();
		}
		
		if(Find_id_jd.gopwfind) {
			layeredPane.removeAll();
			layeredPane.add(password_find);
			layeredPane.repaint();
			layeredPane.revalidate();
		}
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}