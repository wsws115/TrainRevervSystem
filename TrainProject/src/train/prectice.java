package train;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.CardLayout;

import javax.swing.JPasswordField;
import java.awt.Font;

public class prectice extends JFrame {

	private JPanel contentPane;
	private JTextField id_textFiled_1;
	private JPasswordField passwordField_1;
	private JTextField id_textField_2;
	private JPasswordField passwordField_2;
	private JTextField name_textField;
	private JTextField phone_number_textField;
	private JTextField birthday_textField;
	
	private JTextField email_textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prectice frame = new prectice();
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
	public prectice() {
		
		this.setTitle("로그인창");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel id_1 = new JLabel("아이디 :");
		id_1.setFont(new Font("굴림", Font.PLAIN, 35));
		id_1.setBounds(110, 200, 219, 94);
		contentPane.add(id_1);
		
		id_textFiled_1 = new JTextField();
		id_textFiled_1.setFont(new Font("굴림", Font.PLAIN, 35));
		id_textFiled_1.setBounds(330, 200, 374, 94);
		contentPane.add(id_textFiled_1);
		id_textFiled_1.setColumns(10);
		
		JLabel pw_1 = new JLabel("비밀번호 :");
		pw_1.setFont(new Font("굴림", Font.PLAIN, 35));
		pw_1.setBounds(110, 300, 219, 94);
		contentPane.add(pw_1);
		
		JButton check_1 = new JButton("확인");
		check_1.setFont(new Font("굴림", Font.PLAIN, 50));
		check_1.setBounds(100, 870, 363, 114);
		contentPane.add(check_1);
		
		check_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = id_textFiled_1.getText().trim();
				String pw = passwordField_1.getText().trim();
				
				if(id.length()==0 || pw.length()==0) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!", JOptionPane.DEFAULT_OPTION);
					return;
				}else if(id.equals("admin123") && pw.equals("admin123")) { // 데이터베이스 연결 아직 안함 (임시방편)
					JOptionPane.showMessageDialog(null, "로그인 성공.", "사실 아니지만",
							JOptionPane.DEFAULT_OPTION);
					return;
				}else if(!(id.length()==0 || pw.length()==0)
						&& !(id.equals("admin123") && pw.equals("admin123"))) {
					JOptionPane.showMessageDialog(null, "로그인 실패.", "아이디 또는 비번이 틀림",
							JOptionPane.DEFAULT_OPTION);
					return;
				}
				
			}
		});
		
		JButton cancel_1 = new JButton("취소");
		cancel_1.setFont(new Font("굴림", Font.PLAIN, 50));
		cancel_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Train_Main first_frame = new Train_Main();
				first_frame.main(null);
				setVisible(false);
				
			}
		});
		cancel_1.setBounds(550, 870, 374, 114);
		contentPane.add(cancel_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("굴림", Font.PLAIN, 35));
		passwordField_1.setBounds(330, 300, 374, 94);
		contentPane.add(passwordField_1);
		
		JLabel login_label = new JLabel("로그인");
		login_label.setFont(new Font("굴림체", Font.PLAIN, 60));
		login_label.setBounds(324, 30, 291, 160);
		contentPane.add(login_label);
		
		JLabel name = new JLabel("이름 :");
		name.setFont(new Font("굴림", Font.PLAIN, 35));
		name.setBounds(1040, 400, 219, 94);
		contentPane.add(name);
		
		JLabel phone_number = new JLabel("전화번호 :");
		phone_number.setFont(new Font("굴림", Font.PLAIN, 35));
		phone_number.setBounds(1040, 500, 219, 94);
		contentPane.add(phone_number);
		
		JLabel join_membership = new JLabel("회원가입");
		join_membership.setFont(new Font("굴림체", Font.PLAIN, 60));
		join_membership.setBounds(1199, 30, 291, 160);
		contentPane.add(join_membership);
		
		JLabel id_2 = new JLabel("아이디 :");
		id_2.setFont(new Font("굴림", Font.PLAIN, 35));
		id_2.setBounds(1040, 200, 219, 94);
		contentPane.add(id_2);
		
		id_textField_2 = new JTextField();
		id_textField_2.setFont(new Font("굴림", Font.PLAIN, 35));
		id_textField_2.setColumns(10);
		id_textField_2.setBounds(1250, 200, 374, 94);
		contentPane.add(id_textField_2);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("굴림", Font.PLAIN, 35));
		passwordField_2.setBounds(1250, 300, 374, 94);
		contentPane.add(passwordField_2);
		
		JLabel pw_2 = new JLabel("비밀번호 :");
		pw_2.setFont(new Font("굴림", Font.PLAIN, 35));
		pw_2.setBounds(1040, 300, 219, 94);
		contentPane.add(pw_2);
		
		JLabel birthday = new JLabel("생년월일 :");
		birthday.setFont(new Font("굴림", Font.PLAIN, 35));
		birthday.setBounds(1040, 600, 219, 94);
		contentPane.add(birthday);
		
		JLabel email = new JLabel("이메일 :");
		email.setFont(new Font("굴림", Font.PLAIN, 35));
		email.setBounds(1040, 700, 219, 94);
		contentPane.add(email);
		
		name_textField = new JTextField();
		name_textField.setFont(new Font("굴림", Font.PLAIN, 35));
		name_textField.setColumns(10);
		name_textField.setBounds(1250, 400, 374, 94);
		contentPane.add(name_textField);
		
		phone_number_textField = new JTextField();
		phone_number_textField.setFont(new Font("굴림", Font.PLAIN, 35));
		phone_number_textField.setColumns(10);
		phone_number_textField.setBounds(1250, 500, 374, 94);
		contentPane.add(phone_number_textField);
		
		birthday_textField = new JTextField();
		birthday_textField.setFont(new Font("굴림", Font.PLAIN, 35));
		birthday_textField.setColumns(10);
		birthday_textField.setBounds(1250, 600, 374, 94);
		contentPane.add(birthday_textField);
		
		email_textField = new JTextField();
		email_textField.setFont(new Font("굴림", Font.PLAIN, 35));
		email_textField.setColumns(10);
		email_textField.setBounds(1250, 700, 374, 94);
		contentPane.add(email_textField);
		
		JButton check_2 = new JButton("확인");
		check_2.setFont(new Font("굴림", Font.PLAIN, 50));
		check_2.setBounds(1000, 870, 374, 114);
		contentPane.add(check_2);
		
		JButton cancel_2 = new JButton("취소");
		cancel_2.setFont(new Font("굴림", Font.PLAIN, 50));
		cancel_2.setBounds(1450, 870, 374, 114);
		contentPane.add(cancel_2);
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
