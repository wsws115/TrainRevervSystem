package train;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Subway_Kind extends JPanel {

	/**
	 * Create the panel.
	 */
	public Subway_Kind() {
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(null);
		
		JButton subKtxBtn = new JButton("KTX");
		subKtxBtn.setForeground(Color.WHITE);
		subKtxBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		subKtxBtn.setBackground(new Color(0, 128, 129));
		subKtxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subKtxBtn.getText());
			}
		});
		subKtxBtn.setBounds(293, 370, 400, 150);
		rightPanel.add(subKtxBtn);
		
		JButton subSrtBtn = new JButton("SRT");
		subSrtBtn.setForeground(Color.WHITE);
		subSrtBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		subSrtBtn.setBackground(new Color(0, 128, 129));
		subSrtBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subSrtBtn.getText());
			}
		});
		subSrtBtn.setBounds(705, 370, 400, 150);
		rightPanel.add(subSrtBtn);
		
		JButton subNewBtn = new JButton("새마을호");
		subNewBtn.setForeground(Color.WHITE);
		subNewBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		subNewBtn.setBackground(new Color(0, 128, 129));
		subNewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subNewBtn.getText());
			}
		});
		subNewBtn.setBounds(293, 530, 400, 150);
		rightPanel.add(subNewBtn);
		
		JButton subFlowerBtn = new JButton("무궁화호");
		subFlowerBtn.setForeground(Color.WHITE);
		subFlowerBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		subFlowerBtn.setBackground(new Color(0, 128, 129));
		subFlowerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subFlowerBtn.getText());
			}
		});
		subFlowerBtn.setBounds(705, 530, 400, 150);
		rightPanel.add(subFlowerBtn);
		
		JButton subYungItxBtn = new JButton("ITX-청춘");
		subYungItxBtn.setForeground(Color.WHITE);
		subYungItxBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		subYungItxBtn.setBackground(new Color(0, 128, 129));
		subYungItxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subYungItxBtn.getText());
			}
		});
		subYungItxBtn.setBounds(293, 690, 400, 150);
		rightPanel.add(subYungItxBtn);
		
		JButton subNewItxBtn = new JButton("ITX-새마을");
		subNewItxBtn.setForeground(Color.WHITE);
		subNewItxBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		subNewItxBtn.setBackground(new Color(0, 128, 129));
		subNewItxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subNewItxBtn.getText());
			}
		});
		subNewItxBtn.setBounds(705, 690, 400, 150);
		rightPanel.add(subNewItxBtn);
		
		JButton allSubBtn = new JButton("전체");
		allSubBtn.setForeground(Color.WHITE);
		allSubBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		allSubBtn.setBackground(new Color(0, 128, 129));
		allSubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(allSubBtn.getText());
			}
		});
		allSubBtn.setBounds(450, 182, 500, 150);
		rightPanel.add(allSubBtn);
		
		JLabel typeLabel1_4_1 = new JLabel("열차선택");
		typeLabel1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel1_4_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		typeLabel1_4_1.setBounds(543, 50, 335, 100);
		rightPanel.add(typeLabel1_4_1);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(rightPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(rightPanel, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton nextBtn = new JButton("다음");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "select");
			}
		});
		nextBtn.setForeground(Color.WHITE);
		nextBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		nextBtn.setBackground(new Color(0, 128, 129));
		nextBtn.setBounds(1180, 10, 195, 117);
		rightPanel.add(nextBtn);
		
		JButton previousBtn = new JButton("이전");
		previousBtn.setForeground(Color.WHITE);
		previousBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		previousBtn.setBackground(new Color(0, 128, 129));
		previousBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "subway");
			}
		});
		previousBtn.setBounds(12, 10, 195, 117);
		rightPanel.add(previousBtn);
		setLayout(groupLayout);

	}
}