package train;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import train.jungjun.login_join_page.Login_and_join;

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
	
	public static boolean gojoin= false;
	
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
//				train_reverv_main second_frame = new train_reverv_main();
//				second_frame.main(null);
//				Second_main main2 = new Second_main();
//				main2.main(null);
				Second_main main2 = new Second_main();
				main2.main(null);
				setVisible(false);
			}
		});
		
		train_reserv_btn.setBounds(400, 500, 509, 338);
		panel.add(train_reserv_btn);
		
		JButton tiket_btn = new JButton();
		tiket_btn.setBounds(1000, 500, 509, 338);
		tiket_btn.setBorderPainted(false);
		tiket_btn.setContentAreaFilled(false);
		tiket_btn.setFocusPainted(false);
		panel.add(tiket_btn);
		
		JButton admin_login_btn = new JButton();
		admin_login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.jungjun.admin_page.Admin_page admin_frame =
						new train.jungjun.admin_page.Admin_page();
				admin_frame.main(null);
				setVisible(false);
			}
		});
		admin_login_btn.setBounds(1668, 0, 256, 256);
		panel.add(admin_login_btn);
		admin_login_btn.setBorderPainted(false);
		admin_login_btn.setContentAreaFilled(false);
		admin_login_btn.setFocusPainted(false);
		
		
		JLabel logo_label = new JLabel();
		logo_label.setForeground(Color.BLACK);
		logo_label.setHorizontalAlignment(SwingConstants.CENTER);
		logo_label.setFont(new Font("굴림", Font.BOLD, 70));
		logo_label.setBounds(675, 15, 574, 473);
		panel.add(logo_label);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		try {
			
			ImageIcon img1 = new ImageIcon
					(ImageIO.read(new File
							("C:\\javafullstack\\git-repositories\\TrainRevervSystem\\TrainProject\\resource\\goTrain.png"))
							.getScaledInstance(300, 200, Image.SCALE_AREA_AVERAGING));
			train_reserv_btn.setIcon(img1);
			ImageIcon img2 = new ImageIcon
					(ImageIO.read(new File
							("C:\\javafullstack\\git-repositories\\TrainRevervSystem\\TrainProject\\resource\\goCheck.png"))
							.getScaledInstance(300, 200, Image.SCALE_AREA_AVERAGING));
			tiket_btn.setIcon(img2);
			ImageIcon img3 = new ImageIcon
					(ImageIO.read(new File
							("C:\\javafullstack\\git-repositories\\TrainRevervSystem\\TrainProject\\resource\\admin_login.jpg"))
							.getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING));
			admin_login_btn.setIcon(img3);
			ImageIcon img4 = new ImageIcon
					(ImageIO.read(new File
							("C:\\javafullstack\\git-repositories\\TrainRevervSystem\\TrainProject\\resource\\E-RAIL.png"))
							.getScaledInstance(500, 400, Image.SCALE_AREA_AVERAGING));
			logo_label.setIcon(img4);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}