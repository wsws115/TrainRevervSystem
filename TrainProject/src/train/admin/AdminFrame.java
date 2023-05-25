package train.admin;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import train.admin.component.Admin_food;
import train.admin.component.Admin_memTicket;
import train.admin.component.Admin_nomomTicket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class AdminFrame extends JFrame {

	private JPanel contentPane;
	public static String ticket_code;
	JButton memTicketBtn, nomemTicketBtn, foodBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {		
		// 기본 셋팅
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1924, 1011);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 부모 패널
		CardLayout card = new CardLayout();
		JPanel managementsPanel = new JPanel();
		managementsPanel.setBounds(100, 200, 1700, 750);
		managementsPanel.setLayout(card);
		// 자식 패널
		Admin_memTicket member = new Admin_memTicket(); // 회원 확인 패널
		Admin_nomomTicket nomember = new Admin_nomomTicket(); // 비회원 확인 패널
		Admin_food food = new Admin_food(); // 차내식 관리 패널
		
		managementsPanel.add(member, "member");
		managementsPanel.add(nomember, "nomember");
		managementsPanel.add(food, "food");
		
		contentPane.add(managementsPanel);
		
		memTicketBtn = new JButton("회원 티켓 관리");
		memTicketBtn.setForeground(new Color(0, 0, 64));
		memTicketBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 45));
		memTicketBtn.setBackground(new Color(255, 251, 217));
		memTicketBtn.setBounds(100, 81, 380, 90);
		memTicketBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				memTicketBtn.setForeground(new Color(0, 0, 64));
				nomemTicketBtn.setForeground(Color.lightGray);
				foodBtn.setForeground(Color.lightGray);	
				
				nomember.reset();
				food.reset();
				
				card.show(managementsPanel, "member");
			}
		});
		contentPane.add(memTicketBtn);
		
		nomemTicketBtn = new JButton("비회원 티켓 관리");
		nomemTicketBtn.setForeground(Color.lightGray);
		nomemTicketBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 45));
		nomemTicketBtn.setBackground(new Color(255, 251, 217));
		nomemTicketBtn.setBounds(546, 81, 380, 90);
		nomemTicketBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				memTicketBtn.setForeground(Color.lightGray);
				nomemTicketBtn.setForeground(new Color(0, 0, 64));
				foodBtn.setForeground(Color.lightGray);	
				
				member.reset();
				food.reset();
				
				card.show(managementsPanel, "nomember");
			}
		});
		contentPane.add(nomemTicketBtn);
		
		foodBtn = new JButton("차내식 관리");
		foodBtn.setForeground(Color.lightGray);
		foodBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 45));
		foodBtn.setBackground(new Color(255, 251, 217));
		foodBtn.setBounds(983, 81, 380, 90);
		foodBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				memTicketBtn.setForeground(Color.lightGray);
				nomemTicketBtn.setForeground(Color.lightGray);
				foodBtn.setForeground(new Color(0, 0, 64));
				
				member.reset();
				nomember.reset();
				
				card.show(managementsPanel, "food");
			}
		});
		contentPane.add(foodBtn);
		
		// ★ 로그아웃 누르면 Home으로 돌아가는 기능 추가해야됨 !!!!!
		JButton homeBtn = new JButton("Logout");
		homeBtn.setBackground(new Color(255, 251, 217));
		homeBtn.setForeground(new Color(0, 0, 0));
		homeBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		homeBtn.setBounds(1714, 30, 153, 79);
		contentPane.add(homeBtn);
	}
}
