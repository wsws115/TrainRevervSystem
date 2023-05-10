package train;

import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class metro_panel extends JPanel {
	public class RoundedButton extends JButton {
	      public RoundedButton() { super(); decorate(); } 
	      public RoundedButton(String text) { super(text); decorate(); } 
	      public RoundedButton(Action action) { super(action); decorate(); } 
	      public RoundedButton(Icon icon) { super(icon); decorate(); } 
	      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(153,204,204); //배경색 결정
	         Color o=new Color(0,0,1); //글자색 결정
	         int width = getWidth(); 
	         int height = getHeight(); 
	         Graphics2D graphics = (Graphics2D) g; 
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
	         else { graphics.setColor(c); } 
	         graphics.fillRoundRect(0, 0, width, height, 20, 20); 
	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	         int textX = (width - stringBounds.width) / 2; 
	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	         graphics.setColor(o); 
	         graphics.setFont(getFont()); 
	         graphics.drawString(getText(), textX, textY); 
	         graphics.dispose(); 
	         super.paintComponent(g);
	         }
	      }
	/**
	 * Create the panel.
	 */
	public metro_panel() {
		setBounds(0, 0, 1440, 762);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1466, 762);
		add(panel);
		CardLayout card = new CardLayout();
		panel.setLayout(card);
		
		Panel panel_main = new Panel();
		panel_main.setLayout(null);
		panel_main.setBackground(new Color(0, 124, 192));
		panel_main.setBounds(10, 10, 1435, 744);
		panel.add(panel_main);
		
		JLabel lblNewLabel_1_1 = new JLabel("철도역");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("돋움", Font.BOLD, 40));
		lblNewLabel_1_1.setBounds(685, 0, 124, 48);
		panel_main.add(lblNewLabel_1_1);
		
		Button next_btn_1 = new Button("KTX정차역");
		next_btn_1.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
		next_btn_1.setBounds(52, 619, 179, 102);
		panel_main.add(next_btn_1);
		
		Button button_ga = new Button("가");
		button_ga.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ga.setBounds(52, 77, 76, 48);
		panel_main.add(button_ga);
		
		Button button_na = new Button("나");
		button_na.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_na.setBounds(149, 77, 76, 48);
		panel_main.add(button_na);
		
		Button button_da = new Button("다");
		button_da.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_da.setBounds(246, 77, 76, 48);
		panel_main.add(button_da);
		
		Button button_la = new Button("라");
		button_la.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_la.setBounds(343, 77, 76, 48);
		panel_main.add(button_la);
		
		Button button_ma = new Button("마");
		button_ma.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ma.setBounds(438, 77, 76, 48);
		panel_main.add(button_ma);
		
		Button button_ba = new Button("바");
		button_ba.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ba.setBounds(535, 77, 76, 48);
		panel_main.add(button_ba);
		
		Button button_sa = new Button("사");
		button_sa.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_sa.setBounds(636, 77, 76, 48);
		panel_main.add(button_sa);
		
		Button button_ah = new Button("아");
		button_ah.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ah.setBounds(738, 77, 76, 48);
		panel_main.add(button_ah);
		
		Button button_za = new Button("자");
		button_za.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_za.setBounds(835, 77, 76, 48);
		panel_main.add(button_za);
		
		Button button_cha = new Button("차");
		button_cha.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_cha.setBounds(932, 77, 76, 48);
		panel_main.add(button_cha);
		
		Button button_ka = new Button("카");
		button_ka.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ka.setBounds(1029, 77, 76, 48);
		panel_main.add(button_ka);
		
		Button button_ta = new Button("타");
		button_ta.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ta.setBounds(1126, 77, 76, 48);
		panel_main.add(button_ta);
		
		Button button_pa = new Button("파");
		button_pa.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_pa.setBounds(1223, 77, 76, 48);
		panel_main.add(button_pa);
		
		Button button_ha = new Button("하");
		button_ha.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ha.setBounds(1320, 77, 76, 48);
		panel_main.add(button_ha);
		
		JPanel panel_card = new JPanel();
		panel_card.setBounds(50, 150, 1344, 437);
		panel_main.add(panel_card);
		CardLayout cl = new CardLayout();
		panel_card.setLayout(cl);
		//버튼_가 액션
				button_ga.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_ga");
		            }
		        });
				//버튼_나 액션
					button_na.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			            	cl.show(panel_card, "panel_na");
			            }
		        });
				//버튼_다 액션
				button_da.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_da");
		            }
		        });
				//버튼_라 액션
				button_la.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_la");
		            }
		        });
				//버튼_마 액션
				button_ma.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_ma");
		            }
		        });
				//버튼_바 액션
				button_ba.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_ba");
		            }
		        });
				//버튼_사 액션
				button_sa.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_sa");
		            }
		        });
				//버튼_아 액션
				button_ah.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_ah");
		            }
		        });
				//버튼_자 액션
				button_za.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_za");
		            }
		        });
				//버튼_차 액션
				button_cha.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_cha");
		            }
		        });
				//버튼_카 액션
				button_ka.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_ka");
		            }
		        });
				//버튼_타 액션
				button_ta.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_ta");
		            }
		        });
				//버튼_파 액션
				button_pa.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_pa");
		            }
		        });
				//버튼_하 액션
				button_ha.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	cl.show(panel_card, "panel_ha");
		            }
		        });
		
		
		
		next_btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "ktx");
			}
		});
		
		
		JPanel panel_ga = new JPanel();
		panel_ga.setLayout(null);
		panel_card.add(panel_ga, "panel_ga");
		
		RoundedButton btnNewButton = new RoundedButton("가남");
		btnNewButton.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton.setBounds(28, 10, 150, 75);
		panel_ga.add(btnNewButton);
		
		RoundedButton btnNewButton_1 = new RoundedButton("가평");
		btnNewButton_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1.setBounds(190, 10, 150, 75);
		panel_ga.add(btnNewButton_1);
		
		RoundedButton btnNewButton_2 = new RoundedButton("각계");
		btnNewButton_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2.setBounds(352, 10, 150, 75);
		panel_ga.add(btnNewButton_2);
		
		RoundedButton btnNewButton_3 = new RoundedButton("감곡장호원");
		btnNewButton_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3.setBounds(514, 10, 150, 75);
		panel_ga.add(btnNewButton_3);
		
		RoundedButton btnNewButton_4 = new RoundedButton("강경");
		btnNewButton_4.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4.setBounds(676, 10, 150, 75);
		panel_ga.add(btnNewButton_4);
		
		RoundedButton btnNewButton_5 = new RoundedButton("강구");
		btnNewButton_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5.setBounds(838, 10, 150, 75);
		panel_ga.add(btnNewButton_5);
		
		RoundedButton btnNewButton_6 = new RoundedButton("강릉");
		btnNewButton_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6.setBounds(1000, 10, 150, 75);
		panel_ga.add(btnNewButton_6);
		
		RoundedButton btnNewButton_7 = new RoundedButton("강촌");
		btnNewButton_7.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7.setBounds(1162, 10, 150, 75);
		panel_ga.add(btnNewButton_7);
		
		RoundedButton btnNewButton_8 = new RoundedButton("개포");
		btnNewButton_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8.setBounds(28, 95, 150, 75);
		panel_ga.add(btnNewButton_8);
		
		RoundedButton btnNewButton_1_1 = new RoundedButton("건천");
		btnNewButton_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(190, 95, 150, 75);
		panel_ga.add(btnNewButton_1_1);
		
		RoundedButton btnNewButton_2_1 = new RoundedButton("경산");
		btnNewButton_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1.setBounds(352, 95, 150, 75);
		panel_ga.add(btnNewButton_2_1);
		
		RoundedButton btnNewButton_3_1 = new RoundedButton("계룡");
		btnNewButton_3_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1.setBounds(514, 95, 150, 75);
		panel_ga.add(btnNewButton_3_1);
		
		RoundedButton btnNewButton_4_1 = new RoundedButton("고한");
		btnNewButton_4_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1.setBounds(676, 95, 150, 75);
		panel_ga.add(btnNewButton_4_1);
		
		RoundedButton btnNewButton_5_1 = new RoundedButton("곡성");
		btnNewButton_5_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1.setBounds(838, 95, 150, 75);
		panel_ga.add(btnNewButton_5_1);
		
		RoundedButton btnNewButton_6_1 = new RoundedButton("공주");
		btnNewButton_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1.setBounds(1000, 95, 150, 75);
		panel_ga.add(btnNewButton_6_1);
		
		RoundedButton btnNewButton_7_1 = new RoundedButton("광명");
		btnNewButton_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1.setBounds(1162, 95, 150, 75);
		panel_ga.add(btnNewButton_7_1);
		
		RoundedButton btnNewButton_9 = new RoundedButton("광양");
		btnNewButton_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9.setBounds(28, 180, 150, 75);
		panel_ga.add(btnNewButton_9);
		
		RoundedButton btnNewButton_1_2 = new RoundedButton("광주");
		btnNewButton_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(190, 180, 150, 75);
		panel_ga.add(btnNewButton_1_2);
		
		RoundedButton btnNewButton_2_2 = new RoundedButton("광주송정");
		btnNewButton_2_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_2.setBounds(352, 180, 150, 75);
		panel_ga.add(btnNewButton_2_2);
		
		RoundedButton btnNewButton_3_2 = new RoundedButton("광천");
		btnNewButton_3_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_2.setBounds(514, 180, 150, 75);
		panel_ga.add(btnNewButton_3_2);
		
		RoundedButton btnNewButton_4_2 = new RoundedButton("구례구");
		btnNewButton_4_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_2.setBounds(676, 180, 150, 75);
		panel_ga.add(btnNewButton_4_2);
		
		RoundedButton btnNewButton_5_2 = new RoundedButton("구미");
		btnNewButton_5_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_2.setBounds(838, 180, 150, 75);
		panel_ga.add(btnNewButton_5_2);
		
		RoundedButton btnNewButton_6_2 = new RoundedButton("구포");
		btnNewButton_6_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_2.setBounds(1000, 180, 150, 75);
		panel_ga.add(btnNewButton_6_2);
		
		RoundedButton btnNewButton_7_2 = new RoundedButton("군복");
		btnNewButton_7_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_2.setBounds(1162, 180, 150, 75);
		panel_ga.add(btnNewButton_7_2);
		
		RoundedButton btnNewButton_10 = new RoundedButton("군산");
		btnNewButton_10.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_10.setBounds(28, 265, 150, 75);
		panel_ga.add(btnNewButton_10);
		
		RoundedButton btnNewButton_1_3 = new RoundedButton("극락강");
		btnNewButton_1_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(190, 265, 150, 75);
		panel_ga.add(btnNewButton_1_3);
		
		RoundedButton btnNewButton_2_3 = new RoundedButton("기장");
		btnNewButton_2_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_3.setBounds(352, 265, 150, 75);
		panel_ga.add(btnNewButton_2_3);
		
		RoundedButton btnNewButton_3_3 = new RoundedButton("김제");
		btnNewButton_3_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_3.setBounds(514, 265, 150, 75);
		panel_ga.add(btnNewButton_3_3);
		
		RoundedButton btnNewButton_4_3 = new RoundedButton("김천");
		btnNewButton_4_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_3.setBounds(676, 265, 150, 75);
		panel_ga.add(btnNewButton_4_3);
		
		RoundedButton btnNewButton_5_3 = new RoundedButton("김천구미");
		btnNewButton_5_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_3.setBounds(838, 265, 150, 75);
		panel_ga.add(btnNewButton_5_3);
		
		JPanel panel_na = new JPanel();
		panel_na.setLayout(null);
		panel_card.add(panel_na, "panel_na");
		
		RoundedButton btnNewButton_12 = new RoundedButton("나전");
		btnNewButton_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_12.setBounds(28, 10, 150, 75);
		panel_na.add(btnNewButton_12);
		
		RoundedButton btnNewButton_1_5 = new RoundedButton("나주");
		btnNewButton_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_5.setBounds(190, 10, 150, 75);
		panel_na.add(btnNewButton_1_5);
		
		RoundedButton btnNewButton_2_5 = new RoundedButton("남성현");
		btnNewButton_2_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_5.setBounds(352, 10, 150, 75);
		panel_na.add(btnNewButton_2_5);
		
		RoundedButton btnNewButton_3_5 = new RoundedButton("남원");
		btnNewButton_3_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_5.setBounds(514, 10, 150, 75);
		panel_na.add(btnNewButton_3_5);
		
		RoundedButton btnNewButton_4_5 = new RoundedButton("남창");
		btnNewButton_4_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_5.setBounds(676, 10, 150, 75);
		panel_na.add(btnNewButton_4_5);
		
		RoundedButton btnNewButton_5_5 = new RoundedButton("남춘천");
		btnNewButton_5_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_5.setBounds(838, 10, 150, 75);
		panel_na.add(btnNewButton_5_5);
		
		RoundedButton btnNewButton_6_5 = new RoundedButton("논산");
		btnNewButton_6_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_5.setBounds(1000, 10, 150, 75);
		panel_na.add(btnNewButton_6_5);
		
		RoundedButton btnNewButton_7_5 = new RoundedButton("능주");
		btnNewButton_7_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_5.setBounds(1162, 10, 150, 75);
		panel_na.add(btnNewButton_7_5);
		
		JPanel panel_da = new JPanel();
		panel_da.setLayout(null);
		panel_card.add(panel_da, "panel_da");
		
		RoundedButton btnNewButton_13 = new RoundedButton("다시");
		btnNewButton_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_13.setBounds(28, 10, 150, 75);
		panel_da.add(btnNewButton_13);
		
		RoundedButton btnNewButton_1_6 = new RoundedButton("단양");
		btnNewButton_1_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_6.setBounds(190, 10, 150, 75);
		panel_da.add(btnNewButton_1_6);
		
		RoundedButton btnNewButton_2_6 = new RoundedButton("대구");
		btnNewButton_2_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_6.setBounds(352, 10, 150, 75);
		panel_da.add(btnNewButton_2_6);
		
		RoundedButton btnNewButton_3_6 = new RoundedButton("대야");
		btnNewButton_3_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_6.setBounds(514, 10, 150, 75);
		panel_da.add(btnNewButton_3_6);
		
		RoundedButton btnNewButton_4_6 = new RoundedButton("대전");
		btnNewButton_4_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_6.setBounds(676, 10, 150, 75);
		panel_da.add(btnNewButton_4_6);
		
		RoundedButton btnNewButton_5_6 = new RoundedButton("대천");
		btnNewButton_5_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_6.setBounds(838, 10, 150, 75);
		panel_da.add(btnNewButton_5_6);
		
		RoundedButton btnNewButton_6_6 = new RoundedButton("덕소");
		btnNewButton_6_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_6.setBounds(1000, 10, 150, 75);
		panel_da.add(btnNewButton_6_6);
		
		RoundedButton btnNewButton_7_6 = new RoundedButton("덕하");
		btnNewButton_7_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_6.setBounds(1162, 10, 150, 75);
		panel_da.add(btnNewButton_7_6);
		
		RoundedButton btnNewButton_8_2 = new RoundedButton("도계");
		btnNewButton_8_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_2.setBounds(28, 95, 150, 75);
		panel_da.add(btnNewButton_8_2);
		
		RoundedButton btnNewButton_1_1_2 = new RoundedButton("도고온천");
		btnNewButton_1_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_2.setBounds(190, 95, 150, 75);
		panel_da.add(btnNewButton_1_1_2);
		
		RoundedButton btnNewButton_2_1_2 = new RoundedButton("도라산");
		btnNewButton_2_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_2.setBounds(352, 95, 150, 75);
		panel_da.add(btnNewButton_2_1_2);
		
		RoundedButton btnNewButton_3_1_2 = new RoundedButton("동대구");
		btnNewButton_3_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_2.setBounds(514, 95, 150, 75);
		panel_da.add(btnNewButton_3_1_2);
		
		RoundedButton btnNewButton_4_1_2 = new RoundedButton("동백산");
		btnNewButton_4_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_2.setBounds(676, 95, 150, 75);
		panel_da.add(btnNewButton_4_1_2);
		
		RoundedButton btnNewButton_5_1_2 = new RoundedButton("동탄");
		btnNewButton_5_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_2.setBounds(838, 95, 150, 75);
		panel_da.add(btnNewButton_5_1_2);
		
		RoundedButton btnNewButton_6_1_2 = new RoundedButton("동해");
		btnNewButton_6_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_2.setBounds(1000, 95, 150, 75);
		panel_da.add(btnNewButton_6_1_2);
		
		RoundedButton btnNewButton_7_1_2 = new RoundedButton("동화");
		btnNewButton_7_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_2.setBounds(1162, 95, 150, 75);
		panel_da.add(btnNewButton_7_1_2);
		
		RoundedButton btnNewButton_9_2 = new RoundedButton("둔내");
		btnNewButton_9_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_2.setBounds(28, 180, 150, 75);
		panel_da.add(btnNewButton_9_2);
		
		RoundedButton btnNewButton_1_2_2 = new RoundedButton("득량");
		btnNewButton_1_2_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_2.setBounds(190, 180, 150, 75);
		panel_da.add(btnNewButton_1_2_2);
		
		JPanel panel_la = new JPanel();
		panel_la.setLayout(null);
		panel_card.add(panel_la, "panel_la");
		
		JLabel lblNewLabel = new JLabel("역정보 없음");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.BOLD, 80));
		lblNewLabel.setBounds(442, 70, 464, 293);
		panel_la.add(lblNewLabel);
		
		JPanel panel_ma = new JPanel();
		panel_ma.setLayout(null);
		panel_card.add(panel_ma, "panel_ma");
		
		RoundedButton btnNewButton_15 = new RoundedButton("마산");
		btnNewButton_15.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_15.setBounds(28, 10, 150, 75);
		panel_ma.add(btnNewButton_15);
		
		RoundedButton btnNewButton_1_8 = new RoundedButton("마석");
		btnNewButton_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_8.setBounds(190, 10, 150, 75);
		panel_ma.add(btnNewButton_1_8);
		
		RoundedButton btnNewButton_2_8 = new RoundedButton("만종");
		btnNewButton_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_8.setBounds(352, 10, 150, 75);
		panel_ma.add(btnNewButton_2_8);
		
		RoundedButton btnNewButton_3_8 = new RoundedButton("매곡");
		btnNewButton_3_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_8.setBounds(514, 10, 150, 75);
		panel_ma.add(btnNewButton_3_8);
		
		RoundedButton btnNewButton_4_8 = new RoundedButton("명봉");
		btnNewButton_4_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_8.setBounds(676, 10, 150, 75);
		panel_ma.add(btnNewButton_4_8);
		
		RoundedButton btnNewButton_5_8 = new RoundedButton("목포");
		btnNewButton_5_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_8.setBounds(838, 10, 150, 75);
		panel_ma.add(btnNewButton_5_8);
		
		RoundedButton btnNewButton_6_8 = new RoundedButton("몽탄");
		btnNewButton_6_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_8.setBounds(1000, 10, 150, 75);
		panel_ma.add(btnNewButton_6_8);
		
		RoundedButton btnNewButton_7_8 = new RoundedButton("무안");
		btnNewButton_7_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_8.setBounds(1162, 10, 150, 75);
		panel_ma.add(btnNewButton_7_8);
		
		RoundedButton btnNewButton_8_4 = new RoundedButton("묵호");
		btnNewButton_8_4.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_4.setBounds(28, 95, 150, 75);
		panel_ma.add(btnNewButton_8_4);
		
		RoundedButton btnNewButton_1_1_4 = new RoundedButton("문산");
		btnNewButton_1_1_4.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_4.setBounds(190, 95, 150, 75);
		panel_ma.add(btnNewButton_1_1_4);
		
		RoundedButton btnNewButton_2_1_4 = new RoundedButton("물금");
		btnNewButton_2_1_4.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_4.setBounds(352, 95, 150, 75);
		panel_ma.add(btnNewButton_2_1_4);
		
		RoundedButton btnNewButton_3_1_4 = new RoundedButton("민둥산");
		btnNewButton_3_1_4.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_4.setBounds(514, 95, 150, 75);
		panel_ma.add(btnNewButton_3_1_4);
		
		RoundedButton btnNewButton_4_1_4 = new RoundedButton("밀양");
		btnNewButton_4_1_4.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_4.setBounds(676, 95, 150, 75);
		panel_ma.add(btnNewButton_4_1_4);
		
		JPanel panel_ba = new JPanel();
		panel_ba.setLayout(null);
		panel_card.add(panel_ba, "panel_ba");
		
		RoundedButton btnNewButton_16 = new RoundedButton("반곡");
		btnNewButton_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_16.setBounds(28, 10, 150, 75);
		panel_ba.add(btnNewButton_16);
		
		RoundedButton btnNewButton_1_9 = new RoundedButton("반성");
		btnNewButton_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_9.setBounds(190, 10, 150, 75);
		panel_ba.add(btnNewButton_1_9);
		
		RoundedButton btnNewButton_2_9 = new RoundedButton("백양리");
		btnNewButton_2_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_9.setBounds(352, 10, 150, 75);
		panel_ba.add(btnNewButton_2_9);
		
		RoundedButton btnNewButton_3_9 = new RoundedButton("백양사");
		btnNewButton_3_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_9.setBounds(514, 10, 150, 75);
		panel_ba.add(btnNewButton_3_9);
		
		RoundedButton btnNewButton_4_9 = new RoundedButton("벌교");
		btnNewButton_4_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_9.setBounds(676, 10, 150, 75);
		panel_ba.add(btnNewButton_4_9);
		
		RoundedButton btnNewButton_5_9 = new RoundedButton("별어곡");
		btnNewButton_5_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_9.setBounds(838, 10, 150, 75);
		panel_ba.add(btnNewButton_5_9);
		
		RoundedButton btnNewButton_6_9 = new RoundedButton("보성");
		btnNewButton_6_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_9.setBounds(1000, 10, 150, 75);
		panel_ba.add(btnNewButton_6_9);
		
		RoundedButton btnNewButton_7_9 = new RoundedButton("봉양");
		btnNewButton_7_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_9.setBounds(1162, 10, 150, 75);
		panel_ba.add(btnNewButton_7_9);
		
		RoundedButton btnNewButton_8_5 = new RoundedButton("봉화");
		btnNewButton_8_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_5.setBounds(28, 95, 150, 75);
		panel_ba.add(btnNewButton_8_5);
		
		RoundedButton btnNewButton_1_1_5 = new RoundedButton("부강");
		btnNewButton_1_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_5.setBounds(190, 95, 150, 75);
		panel_ba.add(btnNewButton_1_1_5);
		
		RoundedButton btnNewButton_2_1_5 = new RoundedButton("부발");
		btnNewButton_2_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_5.setBounds(352, 95, 150, 75);
		panel_ba.add(btnNewButton_2_1_5);
		
		RoundedButton btnNewButton_3_1_5 = new RoundedButton("부산");
		btnNewButton_3_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_5.setBounds(514, 95, 150, 75);
		panel_ba.add(btnNewButton_3_1_5);
		
		RoundedButton btnNewButton_4_1_5 = new RoundedButton("부전");
		btnNewButton_4_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_5.setBounds(676, 95, 150, 75);
		panel_ba.add(btnNewButton_4_1_5);
		
		RoundedButton btnNewButton_5_1_5 = new RoundedButton("북영천");
		btnNewButton_5_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_5.setBounds(838, 95, 150, 75);
		panel_ba.add(btnNewButton_5_1_5);
		
		RoundedButton btnNewButton_6_1_5 = new RoundedButton("북울산");
		btnNewButton_6_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_5.setBounds(1000, 95, 150, 75);
		panel_ba.add(btnNewButton_6_1_5);
		
		RoundedButton btnNewButton_7_1_5 = new RoundedButton("북천");
		btnNewButton_7_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_5.setBounds(1162, 95, 150, 75);
		panel_ba.add(btnNewButton_7_1_5);
		
		RoundedButton btnNewButton_9_5 = new RoundedButton("불국사");
		btnNewButton_9_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_5.setBounds(28, 180, 150, 75);
		panel_ba.add(btnNewButton_9_5);
		
		RoundedButton btnNewButton_1_2_5 = new RoundedButton("비동");
		btnNewButton_1_2_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_5.setBounds(190, 180, 150, 75);
		panel_ba.add(btnNewButton_1_2_5);
		
		JPanel panel_sa = new JPanel();
		panel_sa.setLayout(null);
		panel_card.add(panel_sa, "panel_sa");
		
		RoundedButton btnNewButton_17 = new RoundedButton("사릉");
		btnNewButton_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_17.setBounds(28, 10, 150, 75);
		panel_sa.add(btnNewButton_17);
		
		RoundedButton btnNewButton_1_10 = new RoundedButton("사북");
		btnNewButton_1_10.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_10.setBounds(190, 10, 150, 75);
		panel_sa.add(btnNewButton_1_10);
		
		RoundedButton btnNewButton_2_10 = new RoundedButton("사상");
		btnNewButton_2_10.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_10.setBounds(352, 10, 150, 75);
		panel_sa.add(btnNewButton_2_10);
		
		RoundedButton btnNewButton_3_10 = new RoundedButton("삼랑진");
		btnNewButton_3_10.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_10.setBounds(514, 10, 150, 75);
		panel_sa.add(btnNewButton_3_10);
		
		RoundedButton btnNewButton_4_10 = new RoundedButton("삼례");
		btnNewButton_4_10.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_10.setBounds(676, 10, 150, 75);
		panel_sa.add(btnNewButton_4_10);
		
		RoundedButton btnNewButton_5_10 = new RoundedButton("삼산");
		btnNewButton_5_10.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_10.setBounds(838, 10, 150, 75);
		panel_sa.add(btnNewButton_5_10);
		
		RoundedButton btnNewButton_6_10 = new RoundedButton("삼탄");
		btnNewButton_6_10.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_10.setBounds(1000, 10, 150, 75);
		panel_sa.add(btnNewButton_6_10);
		
		RoundedButton btnNewButton_7_10 = new RoundedButton("삽교");
		btnNewButton_7_10.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_10.setBounds(1162, 10, 150, 75);
		panel_sa.add(btnNewButton_7_10);
		
		RoundedButton btnNewButton_8_6 = new RoundedButton("상동");
		btnNewButton_8_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_6.setBounds(28, 95, 150, 75);
		panel_sa.add(btnNewButton_8_6);
		
		RoundedButton btnNewButton_1_1_6 = new RoundedButton("상봉");
		btnNewButton_1_1_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_6.setBounds(190, 95, 150, 75);
		panel_sa.add(btnNewButton_1_1_6);
		
		RoundedButton btnNewButton_2_1_6 = new RoundedButton("상주");
		btnNewButton_2_1_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_6.setBounds(352, 95, 150, 75);
		panel_sa.add(btnNewButton_2_1_6);
		
		RoundedButton btnNewButton_3_1_6 = new RoundedButton("서경주");
		btnNewButton_3_1_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_6.setBounds(514, 95, 150, 75);
		panel_sa.add(btnNewButton_3_1_6);
		
		RoundedButton btnNewButton_4_1_6 = new RoundedButton("서광주");
		btnNewButton_4_1_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_6.setBounds(676, 95, 150, 75);
		panel_sa.add(btnNewButton_4_1_6);
		
		RoundedButton btnNewButton_5_1_6 = new RoundedButton("서대구");
		btnNewButton_5_1_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_6.setBounds(838, 95, 150, 75);
		panel_sa.add(btnNewButton_5_1_6);
		
		RoundedButton btnNewButton_6_1_6 = new RoundedButton("서대전");
		btnNewButton_6_1_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_6.setBounds(1000, 95, 150, 75);
		panel_sa.add(btnNewButton_6_1_6);
		
		RoundedButton btnNewButton_7_1_6 = new RoundedButton("서울");
		btnNewButton_7_1_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_6.setBounds(1162, 95, 150, 75);
		panel_sa.add(btnNewButton_7_1_6);
		
		RoundedButton btnNewButton_9_6 = new RoundedButton("서원주");
		btnNewButton_9_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_6.setBounds(28, 180, 150, 75);
		panel_sa.add(btnNewButton_9_6);
		
		RoundedButton btnNewButton_1_2_6 = new RoundedButton("서정리");
		btnNewButton_1_2_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_6.setBounds(190, 180, 150, 75);
		panel_sa.add(btnNewButton_1_2_6);
		
		RoundedButton btnNewButton_2_2_6 = new RoundedButton("서천");
		btnNewButton_2_2_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_2_6.setBounds(352, 180, 150, 75);
		panel_sa.add(btnNewButton_2_2_6);
		
		RoundedButton btnNewButton_3_2_6 = new RoundedButton("석불");
		btnNewButton_3_2_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_2_6.setBounds(514, 180, 150, 75);
		panel_sa.add(btnNewButton_3_2_6);
		
		RoundedButton btnNewButton_4_2_6 = new RoundedButton("석포");
		btnNewButton_4_2_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_2_6.setBounds(676, 180, 150, 75);
		panel_sa.add(btnNewButton_4_2_6);
		
		RoundedButton btnNewButton_5_2_6 = new RoundedButton("선평");
		btnNewButton_5_2_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_2_6.setBounds(838, 180, 150, 75);
		panel_sa.add(btnNewButton_5_2_6);
		
		RoundedButton btnNewButton_6_2_6 = new RoundedButton("성환");
		btnNewButton_6_2_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_2_6.setBounds(1000, 180, 150, 75);
		panel_sa.add(btnNewButton_6_2_6);
		
		RoundedButton btnNewButton_7_2_6 = new RoundedButton("센텀");
		btnNewButton_7_2_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_2_6.setBounds(1162, 180, 150, 75);
		panel_sa.add(btnNewButton_7_2_6);
		
		RoundedButton btnNewButton_10_6 = new RoundedButton("수서");
		btnNewButton_10_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_10_6.setBounds(28, 265, 150, 75);
		panel_sa.add(btnNewButton_10_6);
		
		RoundedButton btnNewButton_1_3_6 = new RoundedButton("수원");
		btnNewButton_1_3_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_3_6.setBounds(190, 265, 150, 75);
		panel_sa.add(btnNewButton_1_3_6);
		
		RoundedButton btnNewButton_2_3_6 = new RoundedButton("순천");
		btnNewButton_2_3_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_3_6.setBounds(352, 265, 150, 75);
		panel_sa.add(btnNewButton_2_3_6);
		
		RoundedButton btnNewButton_3_3_6 = new RoundedButton("승부");
		btnNewButton_3_3_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_3_6.setBounds(514, 265, 150, 75);
		panel_sa.add(btnNewButton_3_3_6);
		
		RoundedButton btnNewButton_4_3_6 = new RoundedButton("신경주");
		btnNewButton_4_3_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_3_6.setBounds(676, 265, 150, 75);
		panel_sa.add(btnNewButton_4_3_6);
		
		RoundedButton btnNewButton_5_3_6 = new RoundedButton("신기");
		btnNewButton_5_3_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_3_6.setBounds(838, 265, 150, 75);
		panel_sa.add(btnNewButton_5_3_6);
		
		RoundedButton btnNewButton_6_3_6 = new RoundedButton("신녕");
		btnNewButton_6_3_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_3_6.setBounds(1000, 265, 150, 75);
		panel_sa.add(btnNewButton_6_3_6);
		
		RoundedButton btnNewButton_7_3_6 = new RoundedButton("신동");
		btnNewButton_7_3_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_3_6.setBounds(1162, 265, 150, 75);
		panel_sa.add(btnNewButton_7_3_6);
		
		RoundedButton btnNewButton_11_6 = new RoundedButton("신례원");
		btnNewButton_11_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_11_6.setBounds(28, 350, 150, 75);
		panel_sa.add(btnNewButton_11_6);
		
		RoundedButton btnNewButton_1_4_6 = new RoundedButton("신림");
		btnNewButton_1_4_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_4_6.setBounds(190, 350, 150, 75);
		panel_sa.add(btnNewButton_1_4_6);
		
		RoundedButton btnNewButton_2_4_6 = new RoundedButton("신탄진");
		btnNewButton_2_4_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_4_6.setBounds(352, 350, 150, 75);
		panel_sa.add(btnNewButton_2_4_6);
		
		RoundedButton btnNewButton_3_4_6 = new RoundedButton("신태인");
		btnNewButton_3_4_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_4_6.setBounds(514, 350, 150, 75);
		panel_sa.add(btnNewButton_3_4_6);
		
		RoundedButton btnNewButton_4_4_6 = new RoundedButton("신해운대");
		btnNewButton_4_4_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_4_6.setBounds(676, 350, 150, 75);
		panel_sa.add(btnNewButton_4_4_6);
		
		RoundedButton btnNewButton_5_4_6 = new RoundedButton("심천");
		btnNewButton_5_4_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_4_6.setBounds(838, 350, 150, 75);
		panel_sa.add(btnNewButton_5_4_6);
		
		RoundedButton btnNewButton_6_4_6 = new RoundedButton("쌍룡");
		btnNewButton_6_4_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_4_6.setBounds(1000, 350, 150, 75);
		panel_sa.add(btnNewButton_6_4_6);
		
		JPanel panel_za = new JPanel();
		panel_za.setLayout(null);
		panel_card.add(panel_za, "panel_za");
		
		RoundedButton btnNewButton_19 = new RoundedButton("장사");
		btnNewButton_19.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_19.setBounds(28, 10, 150, 75);
		panel_za.add(btnNewButton_19);
		
		RoundedButton btnNewButton_1_12 = new RoundedButton("장성");
		btnNewButton_1_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_12.setBounds(190, 10, 150, 75);
		panel_za.add(btnNewButton_1_12);
		
		RoundedButton btnNewButton_2_12 = new RoundedButton("장항");
		btnNewButton_2_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_12.setBounds(352, 10, 150, 75);
		panel_za.add(btnNewButton_2_12);
		
		RoundedButton btnNewButton_3_12 = new RoundedButton("전의");
		btnNewButton_3_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_12.setBounds(514, 10, 150, 75);
		panel_za.add(btnNewButton_3_12);
		
		RoundedButton btnNewButton_4_12 = new RoundedButton("전주");
		btnNewButton_4_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_12.setBounds(676, 10, 150, 75);
		panel_za.add(btnNewButton_4_12);
		
		RoundedButton btnNewButton_5_12 = new RoundedButton("점촌");
		btnNewButton_5_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_12.setBounds(838, 10, 150, 75);
		panel_za.add(btnNewButton_5_12);
		
		RoundedButton btnNewButton_6_12 = new RoundedButton("정동진");
		btnNewButton_6_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_12.setBounds(1000, 10, 150, 75);
		panel_za.add(btnNewButton_6_12);
		
		RoundedButton btnNewButton_7_12 = new RoundedButton("정선");
		btnNewButton_7_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_12.setBounds(1162, 10, 150, 75);
		panel_za.add(btnNewButton_7_12);
		
		RoundedButton btnNewButton_8_8 = new RoundedButton("정읍");
		btnNewButton_8_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_8.setBounds(28, 95, 150, 75);
		panel_za.add(btnNewButton_8_8);
		
		RoundedButton btnNewButton_1_1_8 = new RoundedButton("제천");
		btnNewButton_1_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_8.setBounds(190, 95, 150, 75);
		panel_za.add(btnNewButton_1_1_8);
		
		RoundedButton btnNewButton_2_1_8 = new RoundedButton("조성");
		btnNewButton_2_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_8.setBounds(352, 95, 150, 75);
		panel_za.add(btnNewButton_2_1_8);
		
		RoundedButton btnNewButton_3_1_8 = new RoundedButton("조치원");
		btnNewButton_3_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_8.setBounds(514, 95, 150, 75);
		panel_za.add(btnNewButton_3_1_8);
		
		RoundedButton btnNewButton_4_1_8 = new RoundedButton("좌천");
		btnNewButton_4_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_8.setBounds(676, 95, 150, 75);
		panel_za.add(btnNewButton_4_1_8);
		
		RoundedButton btnNewButton_5_1_8 = new RoundedButton("주덕");
		btnNewButton_5_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_8.setBounds(838, 95, 150, 75);
		panel_za.add(btnNewButton_5_1_8);
		
		RoundedButton btnNewButton_6_1_8 = new RoundedButton("중리");
		btnNewButton_6_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_8.setBounds(1000, 95, 150, 75);
		panel_za.add(btnNewButton_6_1_8);
		
		RoundedButton btnNewButton_7_1_8 = new RoundedButton("증평");
		btnNewButton_7_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_8.setBounds(1162, 95, 150, 75);
		panel_za.add(btnNewButton_7_1_8);
		
		RoundedButton btnNewButton_9_8 = new RoundedButton("지탄");
		btnNewButton_9_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_8.setBounds(28, 180, 150, 75);
		panel_za.add(btnNewButton_9_8);
		
		RoundedButton btnNewButton_1_2_8 = new RoundedButton("지평");
		btnNewButton_1_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_8.setBounds(190, 180, 150, 75);
		panel_za.add(btnNewButton_1_2_8);
		
		RoundedButton btnNewButton_2_2_8 = new RoundedButton("진례");
		btnNewButton_2_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_2_8.setBounds(352, 180, 150, 75);
		panel_za.add(btnNewButton_2_2_8);
		
		RoundedButton btnNewButton_3_2_8 = new RoundedButton("진부(오대산)");
		btnNewButton_3_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_2_8.setBounds(514, 180, 150, 75);
		panel_za.add(btnNewButton_3_2_8);
		
		RoundedButton btnNewButton_4_2_8 = new RoundedButton("진상");
		btnNewButton_4_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_2_8.setBounds(676, 180, 150, 75);
		panel_za.add(btnNewButton_4_2_8);
		
		RoundedButton btnNewButton_5_2_8 = new RoundedButton("진영");
		btnNewButton_5_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_2_8.setBounds(838, 180, 150, 75);
		panel_za.add(btnNewButton_5_2_8);
		
		RoundedButton btnNewButton_6_2_8 = new RoundedButton("진주");
		btnNewButton_6_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_2_8.setBounds(1000, 180, 150, 75);
		panel_za.add(btnNewButton_6_2_8);
		
		JPanel panel_cha = new JPanel();
		panel_cha.setLayout(null);
		panel_card.add(panel_cha, "panel_cha");
		
		RoundedButton btnNewButton_20 = new RoundedButton("창원");
		btnNewButton_20.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_20.setBounds(28, 10, 150, 75);
		panel_cha.add(btnNewButton_20);
		
		RoundedButton btnNewButton_1_13 = new RoundedButton("창원중앙");
		btnNewButton_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_13.setBounds(190, 10, 150, 75);
		panel_cha.add(btnNewButton_1_13);
		
		RoundedButton btnNewButton_2_13 = new RoundedButton("천안");
		btnNewButton_2_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_13.setBounds(352, 10, 150, 75);
		panel_cha.add(btnNewButton_2_13);
		
		RoundedButton btnNewButton_3_13 = new RoundedButton("천안아산");
		btnNewButton_3_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_13.setBounds(514, 10, 150, 75);
		panel_cha.add(btnNewButton_3_13);
		
		RoundedButton btnNewButton_4_13 = new RoundedButton("철암");
		btnNewButton_4_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_13.setBounds(676, 10, 150, 75);
		panel_cha.add(btnNewButton_4_13);
		
		RoundedButton btnNewButton_5_13 = new RoundedButton("청도");
		btnNewButton_5_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_13.setBounds(838, 10, 150, 75);
		panel_cha.add(btnNewButton_5_13);
		
		RoundedButton btnNewButton_6_13 = new RoundedButton("청량리");
		btnNewButton_6_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_13.setBounds(1000, 10, 150, 75);
		panel_cha.add(btnNewButton_6_13);
		
		RoundedButton btnNewButton_7_13 = new RoundedButton("청리");
		btnNewButton_7_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_13.setBounds(1162, 10, 150, 75);
		panel_cha.add(btnNewButton_7_13);
		
		RoundedButton btnNewButton_8_9 = new RoundedButton("청소");
		btnNewButton_8_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_9.setBounds(28, 95, 150, 75);
		panel_cha.add(btnNewButton_8_9);
		
		RoundedButton btnNewButton_1_1_9 = new RoundedButton("청주");
		btnNewButton_1_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_9.setBounds(190, 95, 150, 75);
		panel_cha.add(btnNewButton_1_1_9);
		
		RoundedButton btnNewButton_2_1_9 = new RoundedButton("청주공항");
		btnNewButton_2_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_9.setBounds(352, 95, 150, 75);
		panel_cha.add(btnNewButton_2_1_9);
		
		RoundedButton btnNewButton_3_1_9 = new RoundedButton("청평");
		btnNewButton_3_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_9.setBounds(514, 95, 150, 75);
		panel_cha.add(btnNewButton_3_1_9);
		
		RoundedButton btnNewButton_4_1_9 = new RoundedButton("추풍령");
		btnNewButton_4_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_9.setBounds(676, 95, 150, 75);
		panel_cha.add(btnNewButton_4_1_9);
		
		RoundedButton btnNewButton_5_1_9 = new RoundedButton("춘양");
		btnNewButton_5_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_9.setBounds(838, 95, 150, 75);
		panel_cha.add(btnNewButton_5_1_9);
		
		RoundedButton btnNewButton_6_1_9 = new RoundedButton("춘천");
		btnNewButton_6_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_9.setBounds(1000, 95, 150, 75);
		panel_cha.add(btnNewButton_6_1_9);
		
		RoundedButton btnNewButton_7_1_9 = new RoundedButton("충주");
		btnNewButton_7_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_9.setBounds(1162, 95, 150, 75);
		panel_cha.add(btnNewButton_7_1_9);
		
		JPanel panel_ka = new JPanel();
		panel_ka.setLayout(null);
		panel_card.add(panel_ka, "panel_ka");
		
		JLabel lblNewLabel_1 = new JLabel("역정보 없음");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.BOLD, 80));
		lblNewLabel_1.setBounds(442, 70, 464, 293);
		panel_ka.add(lblNewLabel_1);
		
		JPanel panel_ta = new JPanel();
		panel_ta.setLayout(null);
		panel_card.add(panel_ta, "panel_ta");
		
		RoundedButton btnNewButton_22 = new RoundedButton("탑리");
		btnNewButton_22.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_22.setBounds(28, 10, 150, 75);
		panel_ta.add(btnNewButton_22);
		
		RoundedButton btnNewButton_1_15 = new RoundedButton("태백");
		btnNewButton_1_15.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_15.setBounds(190, 10, 150, 75);
		panel_ta.add(btnNewButton_1_15);
		
		RoundedButton btnNewButton_2_15 = new RoundedButton("태화강");
		btnNewButton_2_15.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_15.setBounds(352, 10, 150, 75);
		panel_ta.add(btnNewButton_2_15);
		
		RoundedButton btnNewButton_3_15 = new RoundedButton("퇴계원");
		btnNewButton_3_15.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_15.setBounds(514, 10, 150, 75);
		panel_ta.add(btnNewButton_3_15);
		
		JPanel panel_pa = new JPanel();
		panel_pa.setLayout(null);
		panel_card.add(panel_pa, "panel_pa");
		
		RoundedButton btnNewButton_23 = new RoundedButton("판교");
		btnNewButton_23.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_23.setBounds(28, 10, 150, 75);
		panel_pa.add(btnNewButton_23);
		
		RoundedButton btnNewButton_1_16 = new RoundedButton("평내호평");
		btnNewButton_1_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_16.setBounds(190, 10, 150, 75);
		panel_pa.add(btnNewButton_1_16);
		
		RoundedButton btnNewButton_2_16 = new RoundedButton("평창");
		btnNewButton_2_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_16.setBounds(352, 10, 150, 75);
		panel_pa.add(btnNewButton_2_16);
		
		RoundedButton btnNewButton_3_16 = new RoundedButton("평택");
		btnNewButton_3_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_16.setBounds(514, 10, 150, 75);
		panel_pa.add(btnNewButton_3_16);
		
		RoundedButton btnNewButton_4_16 = new RoundedButton("평택지제");
		btnNewButton_4_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_16.setBounds(676, 10, 150, 75);
		panel_pa.add(btnNewButton_4_16);
		
		RoundedButton btnNewButton_5_16 = new RoundedButton("포항");
		btnNewButton_5_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_16.setBounds(838, 10, 150, 75);
		panel_pa.add(btnNewButton_5_16);
		
		RoundedButton btnNewButton_6_16 = new RoundedButton("풍기");
		btnNewButton_6_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_16.setBounds(1000, 10, 150, 75);
		panel_pa.add(btnNewButton_6_16);
		
		JPanel panel_ha = new JPanel();
		panel_ha.setLayout(null);
		panel_card.add(panel_ha, "panel_ha");
		
		RoundedButton btnNewButton_24 = new RoundedButton("하동");
		btnNewButton_24.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_24.setBounds(28, 10, 150, 75);
		panel_ha.add(btnNewButton_24);
		
		RoundedButton btnNewButton_1_17 = new RoundedButton("하양");
		btnNewButton_1_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_17.setBounds(190, 10, 150, 75);
		panel_ha.add(btnNewButton_1_17);
		
		RoundedButton btnNewButton_2_17 = new RoundedButton("한림정");
		btnNewButton_2_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_17.setBounds(352, 10, 150, 75);
		panel_ha.add(btnNewButton_2_17);
		
		RoundedButton btnNewButton_3_17 = new RoundedButton("함안");
		btnNewButton_3_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_17.setBounds(514, 10, 150, 75);
		panel_ha.add(btnNewButton_3_17);
		
		RoundedButton btnNewButton_4_17 = new RoundedButton("함열");
		btnNewButton_4_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_17.setBounds(676, 10, 150, 75);
		panel_ha.add(btnNewButton_4_17);
		
		RoundedButton btnNewButton_5_17 = new RoundedButton("함창");
		btnNewButton_5_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_17.setBounds(838, 10, 150, 75);
		panel_ha.add(btnNewButton_5_17);
		
		RoundedButton btnNewButton_6_17 = new RoundedButton("함평");
		btnNewButton_6_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_17.setBounds(1000, 10, 150, 75);
		panel_ha.add(btnNewButton_6_17);
		
		RoundedButton btnNewButton_7_17 = new RoundedButton("행신");
		btnNewButton_7_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_17.setBounds(1162, 10, 150, 75);
		panel_ha.add(btnNewButton_7_17);
		
		RoundedButton btnNewButton_8_13 = new RoundedButton("현동");
		btnNewButton_8_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_13.setBounds(28, 95, 150, 75);
		panel_ha.add(btnNewButton_8_13);
		
		RoundedButton btnNewButton_1_1_13 = new RoundedButton("호계");
		btnNewButton_1_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_13.setBounds(190, 95, 150, 75);
		panel_ha.add(btnNewButton_1_1_13);
		
		RoundedButton btnNewButton_2_1_13 = new RoundedButton("홍성");
		btnNewButton_2_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_13.setBounds(352, 95, 150, 75);
		panel_ha.add(btnNewButton_2_1_13);
		
		RoundedButton btnNewButton_3_1_13 = new RoundedButton("화명");
		btnNewButton_3_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_13.setBounds(514, 95, 150, 75);
		panel_ha.add(btnNewButton_3_1_13);
		
		RoundedButton btnNewButton_4_1_13 = new RoundedButton("화본");
		btnNewButton_4_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_13.setBounds(676, 95, 150, 75);
		panel_ha.add(btnNewButton_4_1_13);
		
		RoundedButton btnNewButton_5_1_13 = new RoundedButton("화순");
		btnNewButton_5_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_13.setBounds(838, 95, 150, 75);
		panel_ha.add(btnNewButton_5_1_13);
		
		RoundedButton btnNewButton_6_1_13 = new RoundedButton("황간");
		btnNewButton_6_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_13.setBounds(1000, 95, 150, 75);
		panel_ha.add(btnNewButton_6_1_13);
		
		RoundedButton btnNewButton_7_1_13 = new RoundedButton("횡성");
		btnNewButton_7_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_13.setBounds(1162, 95, 150, 75);
		panel_ha.add(btnNewButton_7_1_13);
		
		RoundedButton btnNewButton_9_13 = new RoundedButton("횡천");
		btnNewButton_9_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_13.setBounds(28, 180, 150, 75);
		panel_ha.add(btnNewButton_9_13);
		
		RoundedButton btnNewButton_1_2_13 = new RoundedButton("효천");
		btnNewButton_1_2_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_13.setBounds(190, 180, 150, 75);
		panel_ha.add(btnNewButton_1_2_13);
		
		RoundedButton btnNewButton_2_2_13 = new RoundedButton("희방사");
		btnNewButton_2_2_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_2_13.setBounds(352, 180, 150, 75);
		panel_ha.add(btnNewButton_2_2_13);
		
		JScrollPane panel_ah = new JScrollPane((Component) null);
		panel_ah.setPreferredSize(new Dimension(1344, 437));
		panel_card.add(panel_ah, "panel_ah");
		
		JPanel test = new JPanel();
		test.setLayout(null);
		test.setPreferredSize(new Dimension(900, 600));
		test.setAutoscrolls(true);
		panel_ah.setViewportView(test);
		
		JPanel panel_ah_1 = new JPanel();
		panel_ah_1.setLayout(null);
		panel_ah_1.setBounds(0, 0, 1340, 737);
		test.add(panel_ah_1);
		
		RoundedButton btnNewButton_18_1 = new RoundedButton("아산");
		btnNewButton_18_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_18_1.setBounds(28, 10, 150, 75);
		panel_ah_1.add(btnNewButton_18_1);
		
		RoundedButton btnNewButton_1_11_1 = new RoundedButton("아우라지");
		btnNewButton_1_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_11_1.setBounds(190, 10, 150, 75);
		panel_ah_1.add(btnNewButton_1_11_1);
		
		RoundedButton btnNewButton_2_11_1 = new RoundedButton("아화");
		btnNewButton_2_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_11_1.setBounds(352, 10, 150, 75);
		panel_ah_1.add(btnNewButton_2_11_1);
		
		RoundedButton btnNewButton_3_11_1 = new RoundedButton("안강");
		btnNewButton_3_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_11_1.setBounds(514, 10, 150, 75);
		panel_ah_1.add(btnNewButton_3_11_1);
		
		RoundedButton btnNewButton_4_11_1 = new RoundedButton("안동");
		btnNewButton_4_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_11_1.setBounds(676, 10, 150, 75);
		panel_ah_1.add(btnNewButton_4_11_1);
		
		RoundedButton btnNewButton_5_11_1 = new RoundedButton("안양");
		btnNewButton_5_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_11_1.setBounds(838, 10, 150, 75);
		panel_ah_1.add(btnNewButton_5_11_1);
		
		RoundedButton btnNewButton_6_11_1 = new RoundedButton("앙성온천");
		btnNewButton_6_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_11_1.setBounds(1000, 10, 150, 75);
		panel_ah_1.add(btnNewButton_6_11_1);
		
		RoundedButton btnNewButton_7_11_1 = new RoundedButton("약목");
		btnNewButton_7_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_11_1.setBounds(1162, 10, 150, 75);
		panel_ah_1.add(btnNewButton_7_11_1);
		
		RoundedButton btnNewButton_8_7_1 = new RoundedButton("양동");
		btnNewButton_8_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_7_1.setBounds(28, 95, 150, 75);
		panel_ah_1.add(btnNewButton_8_7_1);
		
		RoundedButton btnNewButton_1_1_7_1 = new RoundedButton("양원");
		btnNewButton_1_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_7_1.setBounds(190, 95, 150, 75);
		panel_ah_1.add(btnNewButton_1_1_7_1);
		
		RoundedButton btnNewButton_2_1_7_1 = new RoundedButton("양평");
		btnNewButton_2_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_7_1.setBounds(352, 95, 150, 75);
		panel_ah_1.add(btnNewButton_2_1_7_1);
		
		RoundedButton btnNewButton_3_1_7_1 = new RoundedButton("여수EXPO");
		btnNewButton_3_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_7_1.setBounds(514, 95, 150, 75);
		panel_ah_1.add(btnNewButton_3_1_7_1);
		
		RoundedButton btnNewButton_4_1_7_1 = new RoundedButton("여천");
		btnNewButton_4_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_7_1.setBounds(676, 95, 150, 75);
		panel_ah_1.add(btnNewButton_4_1_7_1);
		
		RoundedButton btnNewButton_5_1_7_1 = new RoundedButton("연산");
		btnNewButton_5_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_7_1.setBounds(838, 95, 150, 75);
		panel_ah_1.add(btnNewButton_5_1_7_1);
		
		RoundedButton btnNewButton_6_1_7_1 = new RoundedButton("영덕");
		btnNewButton_6_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_7_1.setBounds(1000, 95, 150, 75);
		panel_ah_1.add(btnNewButton_6_1_7_1);
		
		RoundedButton btnNewButton_7_1_7_1 = new RoundedButton("영동");
		btnNewButton_7_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_7_1.setBounds(1162, 95, 150, 75);
		panel_ah_1.add(btnNewButton_7_1_7_1);
		
		RoundedButton btnNewButton_9_7_1 = new RoundedButton("영등포");
		btnNewButton_9_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_7_1.setBounds(28, 180, 150, 75);
		panel_ah_1.add(btnNewButton_9_7_1);
		
		RoundedButton btnNewButton_1_2_7_1 = new RoundedButton("영월");
		btnNewButton_1_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_7_1.setBounds(190, 180, 150, 75);
		panel_ah_1.add(btnNewButton_1_2_7_1);
		
		RoundedButton btnNewButton_2_2_7_1 = new RoundedButton("영주");
		btnNewButton_2_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_2_7_1.setBounds(352, 180, 150, 75);
		panel_ah_1.add(btnNewButton_2_2_7_1);
		
		RoundedButton btnNewButton_3_2_7_1 = new RoundedButton("영천");
		btnNewButton_3_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_2_7_1.setBounds(514, 180, 150, 75);
		panel_ah_1.add(btnNewButton_3_2_7_1);
		
		RoundedButton btnNewButton_4_2_7_1 = new RoundedButton("예당");
		btnNewButton_4_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_2_7_1.setBounds(676, 180, 150, 75);
		panel_ah_1.add(btnNewButton_4_2_7_1);
		
		RoundedButton btnNewButton_5_2_7_1 = new RoundedButton("예미");
		btnNewButton_5_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_2_7_1.setBounds(838, 180, 150, 75);
		panel_ah_1.add(btnNewButton_5_2_7_1);
		
		RoundedButton btnNewButton_6_2_7_1 = new RoundedButton("예산");
		btnNewButton_6_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_2_7_1.setBounds(1000, 180, 150, 75);
		panel_ah_1.add(btnNewButton_6_2_7_1);
		
		RoundedButton btnNewButton_7_2_7_1 = new RoundedButton("예천");
		btnNewButton_7_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_2_7_1.setBounds(1162, 180, 150, 75);
		panel_ah_1.add(btnNewButton_7_2_7_1);
		
		RoundedButton btnNewButton_10_7_1 = new RoundedButton("오근장");
		btnNewButton_10_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_10_7_1.setBounds(28, 265, 150, 75);
		panel_ah_1.add(btnNewButton_10_7_1);
		
		RoundedButton btnNewButton_1_3_7_1 = new RoundedButton("오산");
		btnNewButton_1_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_3_7_1.setBounds(190, 265, 150, 75);
		panel_ah_1.add(btnNewButton_1_3_7_1);
		
		RoundedButton btnNewButton_2_3_7_1 = new RoundedButton("오송");
		btnNewButton_2_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_3_7_1.setBounds(352, 265, 150, 75);
		panel_ah_1.add(btnNewButton_2_3_7_1);
		
		RoundedButton btnNewButton_3_3_7_1 = new RoundedButton("오수");
		btnNewButton_3_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_3_7_1.setBounds(514, 265, 150, 75);
		panel_ah_1.add(btnNewButton_3_3_7_1);
		
		RoundedButton btnNewButton_4_3_7_1 = new RoundedButton("옥산");
		btnNewButton_4_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_3_7_1.setBounds(676, 265, 150, 75);
		panel_ah_1.add(btnNewButton_4_3_7_1);
		
		RoundedButton btnNewButton_5_3_7_1 = new RoundedButton("옥수");
		btnNewButton_5_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_3_7_1.setBounds(838, 265, 150, 75);
		panel_ah_1.add(btnNewButton_5_3_7_1);
		
		RoundedButton btnNewButton_6_3_7_1 = new RoundedButton("옥천");
		btnNewButton_6_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_3_7_1.setBounds(1000, 265, 150, 75);
		panel_ah_1.add(btnNewButton_6_3_7_1);
		
		RoundedButton btnNewButton_7_3_7_1 = new RoundedButton("온양온천");
		btnNewButton_7_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_3_7_1.setBounds(1162, 265, 150, 75);
		panel_ah_1.add(btnNewButton_7_3_7_1);
		
		RoundedButton btnNewButton_11_7_3 = new RoundedButton("완사");
		btnNewButton_11_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_11_7_3.setBounds(28, 350, 150, 75);
		panel_ah_1.add(btnNewButton_11_7_3);
		
		RoundedButton btnNewButton_1_4_7_3 = new RoundedButton("왕십리");
		btnNewButton_1_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_4_7_3.setBounds(190, 350, 150, 75);
		panel_ah_1.add(btnNewButton_1_4_7_3);
		
		RoundedButton btnNewButton_2_4_7_3 = new RoundedButton("왜관");
		btnNewButton_2_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_4_7_3.setBounds(352, 350, 150, 75);
		panel_ah_1.add(btnNewButton_2_4_7_3);
		
		RoundedButton btnNewButton_3_4_7_3 = new RoundedButton("용궁");
		btnNewButton_3_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_4_7_3.setBounds(514, 350, 150, 75);
		panel_ah_1.add(btnNewButton_3_4_7_3);
		
		RoundedButton btnNewButton_4_4_7_3 = new RoundedButton("용문");
		btnNewButton_4_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_4_7_3.setBounds(676, 350, 150, 75);
		panel_ah_1.add(btnNewButton_4_4_7_3);
		
		RoundedButton btnNewButton_5_4_7_3 = new RoundedButton("용산");
		btnNewButton_5_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_4_7_3.setBounds(838, 350, 150, 75);
		panel_ah_1.add(btnNewButton_5_4_7_3);
		
		RoundedButton btnNewButton_6_4_7_3 = new RoundedButton("운천");
		btnNewButton_6_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_4_7_3.setBounds(1000, 350, 150, 75);
		panel_ah_1.add(btnNewButton_6_4_7_3);
		
		RoundedButton btnNewButton_7_4_7_3 = new RoundedButton("울산(통도사)");
		btnNewButton_7_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_4_7_3.setBounds(1162, 350, 150, 75);
		panel_ah_1.add(btnNewButton_7_4_7_3);
		
		RoundedButton btnNewButton_11_7_1_1 = new RoundedButton("웅천");
		btnNewButton_11_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_11_7_1_1.setBounds(28, 435, 150, 75);
		panel_ah_1.add(btnNewButton_11_7_1_1);
		
		RoundedButton btnNewButton_1_4_7_1_1 = new RoundedButton("원동");
		btnNewButton_1_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_4_7_1_1.setBounds(190, 435, 150, 75);
		panel_ah_1.add(btnNewButton_1_4_7_1_1);
		
		RoundedButton btnNewButton_2_4_7_1_1 = new RoundedButton("원주");
		btnNewButton_2_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_4_7_1_1.setBounds(352, 435, 150, 75);
		panel_ah_1.add(btnNewButton_2_4_7_1_1);
		
		RoundedButton btnNewButton_3_4_7_1_1 = new RoundedButton("월포");
		btnNewButton_3_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_4_7_1_1.setBounds(514, 435, 150, 75);
		panel_ah_1.add(btnNewButton_3_4_7_1_1);
		
		RoundedButton btnNewButton_4_4_7_1_1 = new RoundedButton("음성");
		btnNewButton_4_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_4_7_1_1.setBounds(676, 435, 150, 75);
		panel_ah_1.add(btnNewButton_4_4_7_1_1);
		
		RoundedButton btnNewButton_5_4_7_1_1 = new RoundedButton("의성");
		btnNewButton_5_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_4_7_1_1.setBounds(838, 435, 150, 75);
		panel_ah_1.add(btnNewButton_5_4_7_1_1);
		
		RoundedButton btnNewButton_6_4_7_1_1 = new RoundedButton("이양");
		btnNewButton_6_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_4_7_1_1.setBounds(1000, 435, 150, 75);
		panel_ah_1.add(btnNewButton_6_4_7_1_1);
		
		RoundedButton btnNewButton_7_4_7_1_1 = new RoundedButton("이원");
		btnNewButton_7_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_4_7_1_1.setBounds(1162, 435, 150, 75);
		panel_ah_1.add(btnNewButton_7_4_7_1_1);
		
		RoundedButton btnNewButton_11_7_2_2 = new RoundedButton("익산");
		btnNewButton_11_7_2_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_11_7_2_2.setBounds(28, 520, 150, 75);
		panel_ah_1.add(btnNewButton_11_7_2_2);
		
		RoundedButton btnNewButton_1_4_7_2_1 = new RoundedButton("인천공항T1");
		btnNewButton_1_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_4_7_2_1.setBounds(190, 520, 150, 75);
		panel_ah_1.add(btnNewButton_1_4_7_2_1);
		
		RoundedButton btnNewButton_2_4_7_2_1 = new RoundedButton("인천공항T2");
		btnNewButton_2_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_4_7_2_1.setBounds(352, 520, 150, 75);
		panel_ah_1.add(btnNewButton_2_4_7_2_1);
		
		RoundedButton btnNewButton_3_4_7_2_1 = new RoundedButton("일로");
		btnNewButton_3_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_4_7_2_1.setBounds(514, 520, 150, 75);
		panel_ah_1.add(btnNewButton_3_4_7_2_1);
		
		RoundedButton btnNewButton_4_4_7_2_1 = new RoundedButton("일신");
		btnNewButton_4_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_4_7_2_1.setBounds(676, 520, 150, 75);
		panel_ah_1.add(btnNewButton_4_4_7_2_1);
		
		RoundedButton btnNewButton_5_4_7_2_1 = new RoundedButton("임기");
		btnNewButton_5_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_4_7_2_1.setBounds(838, 520, 150, 75);
		panel_ah_1.add(btnNewButton_5_4_7_2_1);
		
		RoundedButton btnNewButton_6_4_7_2_1 = new RoundedButton("임성리");
		btnNewButton_6_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_4_7_2_1.setBounds(1000, 520, 150, 75);
		panel_ah_1.add(btnNewButton_6_4_7_2_1);
		
		RoundedButton btnNewButton_7_4_7_2_1 = new RoundedButton("임실");
		btnNewButton_7_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_4_7_2_1.setBounds(1162, 520, 150, 75);
		panel_ah_1.add(btnNewButton_7_4_7_2_1);
		
		RoundedButton btnNewButton_11_7_2_1_1 = new RoundedButton("임진강");
		btnNewButton_11_7_2_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_11_7_2_1_1.setBounds(28, 605, 150, 75);
		panel_ah_1.add(btnNewButton_11_7_2_1_1);
		
		

	}
}
