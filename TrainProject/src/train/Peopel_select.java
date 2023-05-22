package train;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.FontUIResource;

import train.search.Search_Train_Panel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Peopel_select extends JPanel {
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private boolean login_who = train.TrainReserv_Main.login_who;
	
	private int pluspeople(String str) {
		int num = Integer.parseInt(str)+1;
		if(num < 9 && num > 0) {
			return num;
		}else {
			return 9;
		}
	}
	
	private int minuspeople(String str) {
		int num = Integer.parseInt(str)-1;
		if(num < 9 && num > 0) {
			return num;
		}else {
			return 0;
		}
	}
	
	private int sumPeople(String str1, String str2, String str3, String str4) {
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int num3 = Integer.parseInt(str3);
		int num4 = Integer.parseInt(str4);
		int sum = num1 + num2 + num3 + num4;
		if(sum != 0) {
			return sum;
		}else {
			return 0;
		}
	}
	/**
	 * Create the panel.
	 */
	public Peopel_select() {
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(null);
		
		JLabel typeLabel1 = new JLabel("어른(만 13세 이상)");
		typeLabel1.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		typeLabel1.setBounds(295, 282, 516, 66);
		leftPanel.add(typeLabel1);
		
		JButton returnBtn = new JButton("새로고침");
		returnBtn.setFont(new Font("HY견고딕", Font.BOLD, 35));
		returnBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				textField1.setText("0");
				textField2.setText("0");
				textField3.setText("0");
				textField4.setText("0");
				
			}
		});
		returnBtn.setBounds(823, 598, 304, 112);
		leftPanel.add(returnBtn);
		
		JButton minusBtn1 = new JButton("-");
		minusBtn1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		minusBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField1.getText();
				textField1.setText(""+minuspeople(str));
			}
		});
		minusBtn1.setBounds(823, 263, 100, 80);
		leftPanel.add(minusBtn1);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		textField1.setText("0");
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setColumns(10);
		textField1.setBounds(935, 263, 80, 80);
		leftPanel.add(textField1);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(leftPanel, GroupLayout.DEFAULT_SIZE, 1419, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(leftPanel, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		
		JButton plusBtn1 = new JButton("+");
		plusBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField1.getText();
				textField1.setText(""+pluspeople(str));
			}
		});
		plusBtn1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		plusBtn1.setBounds(1027, 263, 100, 80);
		leftPanel.add(plusBtn1);
		
		JLabel typeLabel1_1 = new JLabel("어린이(만 6세 ~ 만 12세)");
		typeLabel1_1.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		typeLabel1_1.setBounds(295, 358, 516, 66);
		leftPanel.add(typeLabel1_1);
		
		JButton minusBtn2 = new JButton("-");
		minusBtn2.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		minusBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField2.getText();
				textField2.setText(""+minuspeople(str));
			}
		});
		minusBtn2.setBounds(823, 344, 100, 80);
		leftPanel.add(minusBtn2);
		
		textField2 = new JTextField();
		textField2.setText("0");
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		textField2.setColumns(10);
		textField2.setBounds(935, 344, 80, 80);
		leftPanel.add(textField2);
		
		JButton plusBtn2 = new JButton("+");
		plusBtn2.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		plusBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField2.getText();
				textField2.setText(""+pluspeople(str));
			}
		});
		plusBtn2.setBounds(1027, 344, 100, 80);
		leftPanel.add(plusBtn2);
		
		JLabel typeLabel1_2 = new JLabel("경로(65세이상)");
		typeLabel1_2.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		typeLabel1_2.setBounds(295, 434, 516, 66);
		leftPanel.add(typeLabel1_2);
		
		JButton minusBtn3 = new JButton("-");
		minusBtn3.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		minusBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField3.getText();
				textField3.setText(""+minuspeople(str));
			}
		});
		minusBtn3.setBounds(823, 426, 100, 80);
		leftPanel.add(minusBtn3);
		
		textField3 = new JTextField();
		textField3.setText("0");
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		textField3.setColumns(10);
		textField3.setBounds(935, 426, 80, 80);
		leftPanel.add(textField3);
		
		JButton plusBtn3 = new JButton("+");
		plusBtn3.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		plusBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField3.getText();
				textField3.setText(""+pluspeople(str));
			}
		});
		plusBtn3.setBounds(1027, 426, 100, 80);
		leftPanel.add(plusBtn3);
		
		JLabel typeLabel1_3 = new JLabel("장애인");
		typeLabel1_3.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		typeLabel1_3.setBounds(295, 510, 516, 66);
		leftPanel.add(typeLabel1_3);
		
		JButton minusBtn4 = new JButton("-");
		minusBtn4.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		minusBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField4.getText();
				textField4.setText(""+minuspeople(str));
			}
		});
		minusBtn4.setBounds(823, 508, 100, 80);
		leftPanel.add(minusBtn4);
		
		textField4 = new JTextField();
		textField4.setText("0");
		textField4.setHorizontalAlignment(SwingConstants.CENTER);
		textField4.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		textField4.setColumns(10);
		textField4.setBounds(935, 508, 80, 80);
		leftPanel.add(textField4);
		
		JButton plusBtn4 = new JButton("+");
		plusBtn4.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		plusBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField4.getText();
				textField4.setText(""+pluspeople(str));
			}
		});
		plusBtn4.setBounds(1027, 508, 100, 80);
		leftPanel.add(plusBtn4);
		
		JLabel typeLabel1_4 = new JLabel("인원 선택");
		typeLabel1_4.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel1_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		typeLabel1_4.setBounds(502, 100, 335, 66);
		leftPanel.add(typeLabel1_4);
		
		JButton returnBtn_1 = new JButton("다음");
		returnBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectPeopleLabel.setText(""+sumPeople(
						textField1.getText(), textField2.getText(),textField3.getText(),textField4.getText()));
				UIManager.put("OptionPane.messageFont", new Font("HY헤드라인M", Font.BOLD, 40));
			    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("HY헤드라인M",Font.PLAIN, 30)));
				if(TrainReserv_Main.selectPeopleLabel.getText().equals("X")) {
					JOptionPane.showMessageDialog(null,"인원을 선택해주십시오.");
				}else if(TrainReserv_Main.date_text.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"날짜를 선택해주십시오.");
				}else {
					JPanel search_panel = new Search_Train_Panel();
					TrainReserv_Main.card_panel.setBounds(441,80,1483,931);
					TrainReserv_Main.card_panel.add(search_panel, "기차API");
					TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "기차API");
				}
			}
		});
		returnBtn_1.setFont(new Font("HY견고딕", Font.BOLD, 35));
		returnBtn_1.setBounds(1207, 10, 200, 112);
		leftPanel.add(returnBtn_1);
		
		JButton previousBtn = new JButton("이전");
		previousBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "subkind");
			}
		});
		previousBtn.setFont(new Font("HY견고딕", Font.BOLD, 35));
		previousBtn.setBounds(12, 10, 200, 112);
		leftPanel.add(previousBtn);
		setLayout(groupLayout);
		try {
			if(train.jungjun.login_join_page.Login_and_joinDAO.preferential.equals("default")) {
				minusBtn4.setEnabled(false);
				plusBtn4.setEnabled(false);
				textField4.setEnabled(false);
			}
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		if(!login_who) {
			minusBtn2.setEnabled(login_who);
			minusBtn3.setEnabled(login_who);
			minusBtn4.setEnabled(login_who);
			plusBtn2.setEnabled(login_who);
			plusBtn3.setEnabled(login_who);
			plusBtn4.setEnabled(login_who);
			textField2.setEnabled(login_who);
			textField3.setEnabled(login_who);
			textField4.setEnabled(login_who);
		}
	}
}
