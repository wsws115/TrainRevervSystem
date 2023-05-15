package train;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Second_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Second_main frame = new Second_main();
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
	public Second_main() {
		ImageIcon img1 = new ImageIcon
				("C:/Java_WorkSpace/JavaTest/git-repository/trainProject/TrainRevervSystem/TrainProject/images/E-RAIL.png");
		ImageIcon img2 = new ImageIcon
				("C:/Java_WorkSpace/JavaTest/git-repository/trainProject/TrainRevervSystem/TrainProject/images/home.png");
		ImageIcon img3 = new ImageIcon
				("C:/Java_WorkSpace/JavaTest/git-repository/trainProject/TrainRevervSystem/TrainProject/images/goLogin.png");
		ImageIcon img4 = new ImageIcon
				("C:/Java_WorkSpace/JavaTest/git-repository/trainProject/TrainRevervSystem/TrainProject/images/goNoLogin.png");
		ImageIcon img5 = new ImageIcon
				("C:/Java_WorkSpace/JavaTest/git-repository/trainProject/TrainRevervSystem/TrainProject/images/back.png");
		
		
		setBounds(100, 100, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		
		JLabel logo = new JLabel(img1);
		logo.setBounds(675, 15, 573, 473);
		getContentPane().add(logo);
		
		JButton goMain_btn = new JButton(img2);
		goMain_btn.setBorderPainted(false);
		goMain_btn.setContentAreaFilled(false);
		goMain_btn.setFocusPainted(false);
		goMain_btn.setBounds(1783, 10, 109, 109);
		getContentPane().add(goMain_btn);
		
		goMain_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Train_Main main1 = new Train_Main();
				main1.main(null);
				setVisible(false);
			}
		});
		
		JButton membership_btn = new JButton(img3);
		membership_btn.setBorderPainted(false);
		membership_btn.setContentAreaFilled(false);
		membership_btn.setFocusPainted(false);
		membership_btn.setBounds(400, 500, 510, 337);
		getContentPane().add(membership_btn);
		
		membership_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				train.jungjun.login_join_page.Login_and_join login = new train.jungjun.login_join_page.Login_and_join();
				login.main(null);
				setVisible(false);
			}
		});
		
		JButton no_membership_btn = new JButton(img4);
		no_membership_btn.setBorderPainted(false);
		no_membership_btn.setContentAreaFilled(false);
		no_membership_btn.setFocusPainted(false);
		no_membership_btn.setBounds(1000, 500, 510, 337);
		getContentPane().add(no_membership_btn);
		
		JButton back_btn = new JButton(img5);
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		back_btn.setBounds(10, 10, 136, 136);
		getContentPane().add(back_btn);
		back_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Train_Main main1 = new Train_Main();
				main1.main(null);
				setVisible(false);
			}
		});
	}

}