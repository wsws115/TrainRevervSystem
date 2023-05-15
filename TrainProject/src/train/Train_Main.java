package train;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Train_Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Train_Main frame = new Train_Main();
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
	public Train_Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0, 0, 1924, 1011);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton train_reserv_btn = new JButton();
		train_reserv_btn.setBorderPainted(false);
		train_reserv_btn.setContentAreaFilled(false);
		train_reserv_btn.setFocusPainted(false);
		
		train_reserv_btn.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main second_frame = new TrainReserv_Main();
				second_frame.main(null);
				setVisible(false);
			}
		});
		try {
			train_reserv_btn.setIcon(
					new ImageIcon(ImageIO.read(
							new File("C:\\javafullstack\\javadefalut\\files\\images\\train.jpg"))
							.getScaledInstance(280, 280, Image.SCALE_AREA_AVERAGING)));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		train_reserv_btn.setBounds(627, 315, 297, 233);
		panel.add(train_reserv_btn);
		
		JButton tiket_btn = new JButton();
		tiket_btn.setBounds(998, 315, 297, 233);
		tiket_btn.setBorderPainted(false);
		tiket_btn.setContentAreaFilled(false);
		tiket_btn.setFocusPainted(false);
		panel.add(tiket_btn);
		try {
			tiket_btn.setIcon(
					new ImageIcon(ImageIO.read(
							new File("C:\\javafullstack\\javadefalut\\files\\images\\ticket.jpg"))
							.getScaledInstance(170, 170, Image.SCALE_AREA_AVERAGING)));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		JButton login_btn = new JButton("");
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prectice login_frame = new prectice();
				login_frame.main(null);
				setVisible(false);
			}
		});
		login_btn.setBounds(627, 591, 297, 233);
		panel.add(login_btn);
		login_btn.setBorderPainted(false);
		login_btn.setContentAreaFilled(false);
		login_btn.setFocusPainted(false);
		
		try {
			login_btn.setIcon(
					new ImageIcon(ImageIO.read(
							new File("C:\\javafullstack\\javadefalut\\files\\images\\login.jpg"))
							.getScaledInstance(170, 170, Image.SCALE_AREA_AVERAGING)));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		JButton admin_login_btn = new JButton();
		admin_login_btn.setBounds(1773, 10, 139, 71);
		panel.add(admin_login_btn);
		admin_login_btn.setBorderPainted(false);
		admin_login_btn.setContentAreaFilled(false);
		admin_login_btn.setFocusPainted(false);
		
		try {
			admin_login_btn.setIcon(
					new ImageIcon(ImageIO.read(
							new File("C:\\javafullstack\\javadefalut\\files\\images\\admin_login.jpg"))
							.getScaledInstance(110, 70, Image.SCALE_AREA_AVERAGING)));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("기차 예매");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(710, 514, 92, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("조회 / 변경");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(1083, 514, 146, 30);
		panel.add(lblNewLabel_1);
		
		JButton sign_up_btn = new JButton();
		sign_up_btn.setFocusPainted(false);
		sign_up_btn.setContentAreaFilled(false);
		sign_up_btn.setBorderPainted(false);
		sign_up_btn.setBounds(998, 587, 297, 233);
		panel.add(sign_up_btn);
		sign_up_btn.setBorderPainted(false);
		sign_up_btn.setContentAreaFilled(false);
		sign_up_btn.setFocusPainted(false);
		
		try {
			sign_up_btn.setIcon(
					new ImageIcon(ImageIO.read(
							new File("C:\\javafullstack\\javadefalut\\files\\images\\sign_up.jpg"))
							.getScaledInstance(170, 170, Image.SCALE_AREA_AVERAGING)));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		JLabel lblNewLabel_2 = new JLabel("회원가입");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(1083, 794, 92, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("로그인");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setBounds(724, 794, 92, 30);
		panel.add(lblNewLabel_2_1);
		
		JLabel logo_label = new JLabel("");
		logo_label.setForeground(Color.BLACK);
		logo_label.setHorizontalAlignment(SwingConstants.CENTER);
		logo_label.setFont(new Font("굴림", Font.BOLD, 70));
		logo_label.setBounds(543, 10, 773, 350);
		try {
			logo_label.setIcon(
					new ImageIcon(ImageIO.read(
							new File("C:\\javafullstack\\javadefalut\\files\\images\\logo.jpg"))
							.getScaledInstance(500, 350, Image.SCALE_AREA_AVERAGING)));
		}catch(IOException e) {
			e.printStackTrace();
		}
		panel.add(logo_label);
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1924, 1011);
		contentPane.add(panel_1);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
