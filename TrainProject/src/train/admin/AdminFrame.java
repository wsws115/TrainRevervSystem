package train.admin;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import train.admin.component.Admin_check;
import train.admin.component.Admin_food;
import train.admin.component.Admin_member;

public class AdminFrame extends JFrame {

	private JPanel contentPane;
	JButton ticketBtn, memberBtn, foodBtn;

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
		managementsPanel.setBounds(500, 154, 1350, 800);
		managementsPanel.setLayout(card);
		// 자식 패널
		JPanel check = new Admin_check(); // 승객 확인 패널
		JPanel member = new Admin_member(); // 회원 확인 패널
		JPanel food = new Admin_food(); // 차내식 관리 패널
		
		managementsPanel.add(check, "check");
		managementsPanel.add(member, "member");
		managementsPanel.add(food, "food");
		
		contentPane.add(managementsPanel);
		
		ticketBtn = new JButton("티켓 관리");
		ticketBtn.setForeground(new Color(0, 0, 64));
		ticketBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		ticketBtn.setBackground(new Color(255, 251, 217));
		ticketBtn.setBounds(91, 154, 350, 150);
		ticketBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ticketBtn.setForeground(new Color(0, 0, 64));
				memberBtn.setForeground(Color.lightGray);
				foodBtn.setForeground(Color.lightGray);	
				
				card.show(managementsPanel, "check");
			}
		});
		contentPane.add(ticketBtn);
		
		memberBtn = new JButton("회원 관리");
		memberBtn.setForeground(Color.lightGray);
		memberBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		memberBtn.setBackground(new Color(255, 251, 217));
		memberBtn.setBounds(91, 427, 350, 150);
		memberBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ticketBtn.setForeground(Color.lightGray);
				memberBtn.setForeground(new Color(0, 0, 64));
				foodBtn.setForeground(Color.lightGray);	
				
				card.show(managementsPanel, "member");
			}
		});
		contentPane.add(memberBtn);
		
		foodBtn = new JButton("차내식 관리");
		foodBtn.setForeground(Color.lightGray);
		foodBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		foodBtn.setBackground(new Color(255, 251, 217));
		foodBtn.setBounds(91, 711, 350, 150);
		foodBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ticketBtn.setForeground(Color.lightGray);
				memberBtn.setForeground(Color.lightGray);
				foodBtn.setForeground(new Color(0, 0, 64));
				
				card.show(managementsPanel, "food");
			}
		});
		contentPane.add(foodBtn);
	}
}
