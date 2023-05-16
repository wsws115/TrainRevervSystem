package train;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Subway_Select extends JPanel {
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	
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
	public Subway_Select() {
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(null);
		
		JLabel typeLabel1 = new JLabel("어른(만 13세 이상)");
		typeLabel1.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		typeLabel1.setBounds(12, 274, 335, 66);
		leftPanel.add(typeLabel1);
		
		JButton returnBtn = new JButton("새로고침");
		returnBtn.setFont(new Font("HY견고딕", Font.BOLD, 27));
		returnBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				textField1.setText("0");
				textField2.setText("0");
				textField3.setText("0");
				textField4.setText("0");
				
			}
		});
		returnBtn.setBounds(383, 589, 261, 112);
		leftPanel.add(returnBtn);
		
		JButton minusBtn1 = new JButton("-");
		minusBtn1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		minusBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField1.getText();
				textField1.setText(""+minuspeople(str));
			}
		});
		minusBtn1.setBounds(383, 274, 79, 66);
		leftPanel.add(minusBtn1);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		textField1.setText("0");
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setColumns(10);
		textField1.setBounds(474, 274, 79, 66);
		leftPanel.add(textField1);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(null);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(leftPanel, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(rightPanel, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rightPanel, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
						.addComponent(leftPanel, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		
		JButton subKtxBtn = new JButton("KTX");
		subKtxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subKtxBtn.getText());
			}
		});
		subKtxBtn.setForeground(Color.WHITE);
		subKtxBtn.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		subKtxBtn.setBackground(new Color(0, 128, 129));
		subKtxBtn.setBounds(65, 358, 250, 100);
		rightPanel.add(subKtxBtn);
		
		JButton subSrtBtn = new JButton("SRT");
		subSrtBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subSrtBtn.getText());
			}
		});
		subSrtBtn.setForeground(Color.WHITE);
		subSrtBtn.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		subSrtBtn.setBackground(new Color(0, 128, 129));
		subSrtBtn.setBounds(352, 358, 250, 100);
		rightPanel.add(subSrtBtn);
		
		JButton subNewBtn = new JButton("새마을호");
		subNewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subNewBtn.getText());
			}
		});
		subNewBtn.setForeground(Color.WHITE);
		subNewBtn.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		subNewBtn.setBackground(new Color(0, 128, 129));
		subNewBtn.setBounds(65, 468, 250, 100);
		rightPanel.add(subNewBtn);
		
		JButton subFlowerBtn = new JButton("무궁화호");
		subFlowerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subFlowerBtn.getText());
			}
		});
		subFlowerBtn.setForeground(Color.WHITE);
		subFlowerBtn.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		subFlowerBtn.setBackground(new Color(0, 128, 129));
		subFlowerBtn.setBounds(352, 468, 250, 100);
		rightPanel.add(subFlowerBtn);
		
		JButton subYungItxBtn = new JButton("ITX-청춘");
		subYungItxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subYungItxBtn.getText());
			}
		});
		subYungItxBtn.setForeground(Color.WHITE);
		subYungItxBtn.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		subYungItxBtn.setBackground(new Color(0, 128, 129));
		subYungItxBtn.setBounds(65, 577, 250, 100);
		rightPanel.add(subYungItxBtn);
		
		JButton subNewItxBtn = new JButton("ITX-새마을");
		subNewItxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subNewItxBtn.getText());
			}
		});
		subNewItxBtn.setForeground(Color.WHITE);
		subNewItxBtn.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		subNewItxBtn.setBackground(new Color(0, 128, 129));
		subNewItxBtn.setBounds(352, 578, 250, 100);
		rightPanel.add(subNewItxBtn);
		
		JButton allSubBtn = new JButton("전체");
		allSubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(allSubBtn.getText());
			}
		});
		allSubBtn.setForeground(Color.WHITE);
		allSubBtn.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		allSubBtn.setBackground(new Color(0, 128, 129));
		allSubBtn.setBounds(165, 236, 335, 108);
		rightPanel.add(allSubBtn);
		
		JLabel typeLabel1_4_1 = new JLabel("열차선택");
		typeLabel1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel1_4_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		typeLabel1_4_1.setBounds(165, 97, 335, 66);
		rightPanel.add(typeLabel1_4_1);
		
		JButton plusBtn1 = new JButton("+");
		plusBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField1.getText();
				textField1.setText(""+pluspeople(str));
			}
		});
		plusBtn1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		plusBtn1.setBounds(565, 274, 79, 66);
		leftPanel.add(plusBtn1);
		
		JLabel typeLabel1_1 = new JLabel("어린이(만 6세 ~ 만 12세)");
		typeLabel1_1.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		typeLabel1_1.setBounds(12, 350, 335, 66);
		leftPanel.add(typeLabel1_1);
		
		JButton minusBtn2 = new JButton("-");
		minusBtn2.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		minusBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField2.getText();
				textField2.setText(""+minuspeople(str));
			}
		});
		minusBtn2.setBounds(383, 350, 79, 66);
		leftPanel.add(minusBtn2);
		
		textField2 = new JTextField();
		textField2.setText("0");
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		textField2.setColumns(10);
		textField2.setBounds(474, 350, 79, 66);
		leftPanel.add(textField2);
		
		JButton plusBtn2 = new JButton("+");
		plusBtn2.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		plusBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField2.getText();
				textField2.setText(""+pluspeople(str));
			}
		});
		plusBtn2.setBounds(565, 350, 79, 66);
		leftPanel.add(plusBtn2);
		
		JLabel typeLabel1_2 = new JLabel("경로(65세이상)");
		typeLabel1_2.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		typeLabel1_2.setBounds(12, 426, 335, 66);
		leftPanel.add(typeLabel1_2);
		
		JButton minusBtn3 = new JButton("-");
		minusBtn3.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		minusBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField3.getText();
				textField3.setText(""+minuspeople(str));
			}
		});
		minusBtn3.setBounds(383, 426, 79, 66);
		leftPanel.add(minusBtn3);
		
		textField3 = new JTextField();
		textField3.setText("0");
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		textField3.setColumns(10);
		textField3.setBounds(474, 426, 79, 66);
		leftPanel.add(textField3);
		
		JButton plusBtn3 = new JButton("+");
		plusBtn3.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		plusBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField3.getText();
				textField3.setText(""+pluspeople(str));
			}
		});
		plusBtn3.setBounds(565, 426, 79, 66);
		leftPanel.add(plusBtn3);
		
		JLabel typeLabel1_3 = new JLabel("장애인");
		typeLabel1_3.setFont(new Font("HY견고딕", Font.PLAIN, 27));
		typeLabel1_3.setBounds(12, 502, 335, 66);
		leftPanel.add(typeLabel1_3);
		
		JButton minusBtn4 = new JButton("-");
		minusBtn4.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		minusBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField4.getText();
				textField4.setText(""+minuspeople(str));
			}
		});
		minusBtn4.setBounds(383, 502, 79, 66);
		leftPanel.add(minusBtn4);
		
		textField4 = new JTextField();
		textField4.setText("0");
		textField4.setHorizontalAlignment(SwingConstants.CENTER);
		textField4.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		textField4.setColumns(10);
		textField4.setBounds(474, 502, 79, 66);
		leftPanel.add(textField4);
		
		JButton plusBtn4 = new JButton("+");
		plusBtn4.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		plusBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField4.getText();
				textField4.setText(""+pluspeople(str));
			}
		});
		plusBtn4.setBounds(565, 502, 79, 66);
		leftPanel.add(plusBtn4);
		
		JLabel typeLabel1_4 = new JLabel("인원 선택");
		typeLabel1_4.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel1_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		typeLabel1_4.setBounds(156, 91, 335, 66);
		leftPanel.add(typeLabel1_4);
		
		JButton returnBtn_1 = new JButton("확인");
		returnBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectPeopleLabel.setText(""+sumPeople(
						textField1.getText(), textField2.getText(),textField3.getText(),textField4.getText()));
			}
		});
		returnBtn_1.setFont(new Font("HY견고딕", Font.BOLD, 27));
		returnBtn_1.setBounds(12, 589, 261, 112);
		leftPanel.add(returnBtn_1);
		setLayout(groupLayout);

	}
}
