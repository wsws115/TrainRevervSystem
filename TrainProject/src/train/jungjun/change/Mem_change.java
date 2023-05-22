package train.jungjun.change;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import train.jungjun.Change_main;
import train.jungjun.GoMain;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mem_change extends JFrame {

	private JPanel contentPane;
	public static String id = "";
	public static String pw = "";
	
	ImageIcon img1 = new ImageIcon
			("resource/E-RAIL.png");
	ImageIcon img2 = new ImageIcon
			("resource/back_homebtn.PNG");
	ImageIcon img3 = new ImageIcon
			("resource/home.png");
	Image img = img1.getImage();
 	Image updateImg = img.getScaledInstance(400, 330, Image.SCALE_SMOOTH);
    ImageIcon updateIcon = new ImageIcon(updateImg);
    private JTextField id_textField;
    private JPasswordField pw_passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mem_change frame = new Mem_change();
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
	public Mem_change() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logo = new JLabel(updateIcon);
		logo.setBounds(675, 30, 400, 330);
		contentPane.add(logo);
		
		JButton home_btn = new JButton(img3);
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.jungjun.GoMain gomain = new GoMain();
				gomain.main(null);
			}
		});
		home_btn.setBorderPainted(false);
		home_btn.setContentAreaFilled(false);
		home_btn.setFocusPainted(false);
		home_btn.setBounds(1800, 10, 109, 109);
		contentPane.add(home_btn);
		
		JButton back_btn = new JButton(img2);
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.jungjun.Change_main Cmain = new Change_main();
				Cmain.main(null);
				dispose();
			}
		});
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		back_btn.setBounds(10, 10, 136, 136);
		contentPane.add(back_btn);
		
		JLabel id_label = new JLabel("아이디");
		id_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		id_label.setBounds(585, 437, 200, 100);
		contentPane.add(id_label);
		
		JLabel lblNewLabel = new JLabel("비밀번호");
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		lblNewLabel.setBounds(585, 567, 250, 100);
		contentPane.add(lblNewLabel);
		
		id_textField = new JTextField();
		id_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		id_textField.setBounds(885, 437, 400, 100);
		contentPane.add(id_textField);
		id_textField.setColumns(10);
		
		pw_passwordField = new JPasswordField();
		pw_passwordField.setFont(new Font("굴림", Font.PLAIN, 50));
		pw_passwordField.setBounds(885, 567, 400, 100);
		contentPane.add(pw_passwordField);
		
		JButton login_btn = new JButton("로그인");
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = id_textField.getText();
				pw = pw_passwordField.getText();
				Mem_chageDAO CDAO = new Mem_chageDAO();
				boolean login_result = CDAO.DAO();
				System.out.println("로그인 성공 여부" + login_result);
			}
		});
		login_btn.setBackground(new Color(0, 128, 192));
		login_btn.setForeground(Color.WHITE);
		login_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		login_btn.setBounds(585, 727, 700, 100);
		contentPane.add(login_btn);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
