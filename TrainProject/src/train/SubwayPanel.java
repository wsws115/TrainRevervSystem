package train;

import javax.swing.JPanel;


import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Button;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SubwayPanel extends JPanel implements MouseListener{
	private String train_name;
	
	//버튼 디자인
	   public class RoundedButton extends JButton {
	         public RoundedButton() { super(); decorate(); } 
	         public RoundedButton(String text) { super(text); decorate(); } 
	         public RoundedButton(Action action) { super(action); decorate(); } 
	         public RoundedButton(Icon icon) { super(icon); decorate(); } 
	         public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
	         protected void decorate() { setBorderPainted(false); setOpaque(false); }
	         @Override 
	         protected void paintComponent(Graphics g) {
	            Color c=new Color(255,247,242); //배경색 결정
	            Color o=new Color(247,99,30); //글자색 결정
	            int width = getWidth(); 
	            int height = getHeight(); 
	            Graphics2D graphics = (Graphics2D) g; 
	            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	            if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	            else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
	            else { graphics.setColor(c); } 
	            graphics.fillRoundRect(0, 0, width, height, 50, 50); 
	            FontMetrics fontMetrics = graphics.getFontMetrics(); 
	            Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	            int textX = (width - stringBounds.width) / 2; 
	            int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	            graphics.setColor(o); 
	            graphics.setFont(new Font("맑은 고딕", Font.PLAIN, 30)); 
	            graphics.drawString(getText(), textX, textY); 
	            graphics.dispose(); 
	            super.paintComponent(g);
	            }
	         }
	/**
	 * Create the panel.
	 */
	public SubwayPanel(){
		setLayout(null);
		CardLayout card = new CardLayout();
		JPanel card_panel = new JPanel();
		card_panel.setBounds(0, 0, 1483,931);
		add(card_panel);
		card_panel.setLayout(card);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(153, 204, 204));
		panel_1.setBounds(0, 0, 1436, 931);
		card_panel.add(panel_1);
		RoundedButton button = new RoundedButton("서울");
	      button.setFont(new Font("돋움", Font.BOLD, 25));
	      button.setBounds(52, 74, 190, 102);
	      button.setHorizontalAlignment(SwingConstants.CENTER);
	      button.addMouseListener(this);
	      panel_1.add(button);
	      
	      RoundedButton button_1 = new RoundedButton("용산");
	      button_1.setFont(new Font("돋움", Font.BOLD, 25));
	      button_1.setBounds(248, 74, 190, 102);
	      button_1.setHorizontalAlignment(SwingConstants.CENTER);
	      button_1.addMouseListener(this);
	      panel_1.add(button_1);
	      
	      RoundedButton button_2 = new RoundedButton("영등포");
	      button_2.setFont(new Font("돋움", Font.BOLD, 25));
	      button_2.setBounds(444, 74, 190, 102);
	      button_2.setHorizontalAlignment(SwingConstants.CENTER);
	      button_2.addMouseListener(this);
	      panel_1.add(button_2);
	      
	      RoundedButton button_3 = new RoundedButton("광명");
	      button_3.setFont(new Font("돋움", Font.BOLD, 25));
	      button_3.setBounds(640, 74, 190, 102);
	      button_3.setHorizontalAlignment(SwingConstants.CENTER);
	      button_3.addMouseListener(this);
	      panel_1.add(button_3);
	      
	      RoundedButton button_4 = new RoundedButton("수원");
	      button_4.setFont(new Font("돋움", Font.BOLD, 25));
	      button_4.setBounds(836, 74, 190, 102);
	      button_4.setHorizontalAlignment(SwingConstants.CENTER);
	      button_4.addMouseListener(this);
	      panel_1.add(button_4);
	      
	      RoundedButton button_5 = new RoundedButton("천안아산");
	      button_5.setFont(new Font("돋움", Font.BOLD, 25));
	      button_5.setBounds(1032, 74, 190, 102);
	      button_5.setHorizontalAlignment(SwingConstants.CENTER);
	      button_5.addMouseListener(this);
	      panel_1.add(button_5);
	      
	      RoundedButton button_6 = new RoundedButton("오송");
	      button_6.setFont(new Font("돋움", Font.BOLD, 25));
	      button_6.setBounds(1228, 74, 190, 102);
	      button_6.setHorizontalAlignment(SwingConstants.CENTER);
	      button_6.addMouseListener(this);
	      panel_1.add(button_6);
	      
	      RoundedButton button_7 = new RoundedButton("대전");
	      button_7.setFont(new Font("돋움", Font.BOLD, 25));
	      button_7.setBounds(52, 182, 190, 102);
	      button_7.setHorizontalAlignment(SwingConstants.CENTER);
	      button_7.addMouseListener(this);
	      panel_1.add(button_7);
	      
	      RoundedButton button_8 = new RoundedButton("서대전");
	      button_8.setFont(new Font("돋움", Font.BOLD, 25));
	      button_8.setBounds(52, 290, 190, 102);
	      button_8.addMouseListener(this);
	      panel_1.add(button_8);
	      
	      RoundedButton button_9 = new RoundedButton("김천구미");
	      button_9.setFont(new Font("돋움", Font.BOLD, 25));
	      button_9.setBounds(52, 398, 190, 102);
	      button_9.addMouseListener(this);
	      panel_1.add(button_9);
	      
	      RoundedButton button_10 = new RoundedButton("동대구");
	      button_10.setFont(new Font("돋움", Font.BOLD, 25));
	      button_10.setBounds(52, 506, 190, 102);
	      button_10.addMouseListener(this);
	      panel_1.add(button_10);
	      
	      
	      RoundedButton button_11 = new RoundedButton("포항");
	      button_11.setFont(new Font("돋움", Font.BOLD, 25));
	      button_11.setBounds(248, 182, 190, 102);
	      panel_1.add(button_11);
	      
	      RoundedButton button_12 = new RoundedButton("밀양");
	      button_12.setFont(new Font("돋움", Font.BOLD, 25));
	      button_12.setBounds(248, 290, 190, 102);
	      panel_1.add(button_12);
	      
	      RoundedButton button_13 = new RoundedButton("구포");
	      button_13.setFont(new Font("돋움", Font.BOLD, 25));
	      button_13.setBounds(444, 182, 190, 102);
	      panel_1.add(button_13);
	      
	      RoundedButton button_14 = new RoundedButton("부산");
	      button_14.setFont(new Font("돋움", Font.BOLD, 25));
	      button_14.setBounds(444, 290, 190, 102);
	      panel_1.add(button_14);
	      
	      RoundedButton button_15 = new RoundedButton("신경주");
	      button_15.setFont(new Font("돋움", Font.BOLD, 25));
	      button_15.setBounds(248, 398, 190, 102);
	      panel_1.add(button_15);
	      
	      RoundedButton button_16 = new RoundedButton("울산(통도사)");
	      button_16.setFont(new Font("돋움", Font.BOLD, 25));
	      button_16.setBounds(444, 398, 190, 102);
	      panel_1.add(button_16);
	      
	      RoundedButton button_17 = new RoundedButton("마산");
	      button_17.setFont(new Font("돋움", Font.BOLD, 25));
	      button_17.setBounds(640, 182, 190, 102);
	      panel_1.add(button_17);
	      
	      RoundedButton button_18 = new RoundedButton("창원중앙");
	      button_18.setFont(new Font("돋움", Font.BOLD, 25));
	      button_18.setBounds(640, 290, 190, 102);
	      panel_1.add(button_18);
	      
	      RoundedButton button_19 = new RoundedButton("경산");
	      button_19.setFont(new Font("돋움", Font.BOLD, 25));
	      button_19.setBounds(248, 506, 190, 102);
	      panel_1.add(button_19);
	      
	      RoundedButton button_20 = new RoundedButton("논산");
	      button_20.setFont(new Font("돋움", Font.BOLD, 25));
	      button_20.setBounds(444, 506, 190, 102);
	      panel_1.add(button_20);
	      
	      RoundedButton button_21 = new RoundedButton("익산");
	      button_21.setFont(new Font("돋움", Font.BOLD, 25));
	      button_21.setBounds(640, 398, 190, 102);
	      panel_1.add(button_21);
	      
	      RoundedButton button_22 = new RoundedButton("정읍");
	      button_22.setFont(new Font("돋움", Font.BOLD, 25));
	      button_22.setBounds(640, 506, 190, 102);
	      panel_1.add(button_22);
	      
	      RoundedButton button_23 = new RoundedButton("광주송정");
	      button_23.setFont(new Font("돋움", Font.BOLD, 25));
	      button_23.setBounds(836, 182, 190, 102);
	      panel_1.add(button_23);
	      
	      RoundedButton button_24 = new RoundedButton("목포");
	      button_24.setFont(new Font("돋움", Font.BOLD, 25));
	      button_24.setBounds(1032, 182, 190, 102);
	      panel_1.add(button_24);
	      
	      RoundedButton button_25 = new RoundedButton("전주");
	      button_25.setFont(new Font("돋움", Font.BOLD, 25));
	      button_25.setBounds(1228, 182, 190, 102);
	      panel_1.add(button_25);
	      
	      RoundedButton button_26 = new RoundedButton("순천");
	      button_26.setFont(new Font("돋움", Font.BOLD, 25));
	      button_26.setBounds(836, 290, 190, 102);
	      panel_1.add(button_26);
	      
	      RoundedButton button_27 = new RoundedButton("여수EXPO");
	      button_27.setFont(new Font("돋움", Font.BOLD, 25));
	      button_27.setBounds(1032, 290, 190, 102);
	      panel_1.add(button_27);
	      
	      RoundedButton button_28 = new RoundedButton("청량리");
	      button_28.setFont(new Font("돋움", Font.BOLD, 25));
	      button_28.setBounds(1228, 290, 190, 102);
	      panel_1.add(button_28);
	      
	      RoundedButton button_29 = new RoundedButton("강릉");
	      button_29.setFont(new Font("돋움", Font.BOLD, 25));
	      button_29.setBounds(836, 398, 190, 102);
	      panel_1.add(button_29);
	      
	      RoundedButton button_30 = new RoundedButton("행신");
	      button_30.setFont(new Font("돋움", Font.BOLD, 25));
	      button_30.setBounds(1032, 398, 190, 102);
	      panel_1.add(button_30);
	      
	      RoundedButton button_31 = new RoundedButton("정동진");
	      button_31.setFont(new Font("돋움", Font.BOLD, 25));
	      button_31.setBounds(1228, 398, 190, 102);
	      panel_1.add(button_31);
	      
		Button next_btn = new Button("다음");
		next_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(card_panel);
			}
		});
		next_btn.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		next_btn.setBounds(1236, 819, 190, 102);
		panel_1.add(next_btn);
		
		JLabel lblNewLabel_1 = new JLabel("주요역");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(42, 10, 190, 58);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("KTX 정차역");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("돋움", Font.BOLD, 40));
		lblNewLabel_1_1.setBounds(630, 10, 251, 58);
		panel_1.add(lblNewLabel_1_1);
		
		Button next_btn_1 = new Button("철도역");
		next_btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(card_panel, "metro");
			}
		});
		next_btn_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		next_btn_1.setBounds(52, 819, 190, 102);
		panel_1.add(next_btn_1);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(153, 204, 204));
		panel_1_1.setBounds(0, 0, 1436, 756);
		card_panel.add(panel_1_1);
		
		Button button_35 = new Button("평택");
		button_35.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_35.setBounds(45, 80, 190, 102);
		panel_1_1.add(button_35);
		
		Button button_1_1 = new Button("천안");
		button_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_1_1.setBounds(241, 80, 190, 102);
		panel_1_1.add(button_1_1);
		
		Button button_2_1 = new Button("조치원");
		button_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_2_1.setBounds(437, 80, 190, 102);
		panel_1_1.add(button_2_1);
		
		Button button_3_1 = new Button("김천");
		button_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_3_1.setBounds(633, 80, 190, 102);
		panel_1_1.add(button_3_1);
		
		Button button_4_1 = new Button("구미");
		button_4_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_4_1.setBounds(829, 80, 190, 102);
		panel_1_1.add(button_4_1);
		
		Button button_5_1 = new Button("태화강");
		button_5_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_5_1.setBounds(1025, 80, 190, 102);
		panel_1_1.add(button_5_1);
		
		Button button_6_1 = new Button("대천");
		button_6_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_6_1.setBounds(1221, 80, 190, 102);
		panel_1_1.add(button_6_1);
		
		Button button_7_1 = new Button("춘천");
		button_7_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_7_1.setBounds(45, 188, 190, 102);
		panel_1_1.add(button_7_1);
		
		Button button_8_1 = new Button("원주");
		button_8_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_8_1.setBounds(45, 296, 190, 102);
		panel_1_1.add(button_8_1);
		
		Button button_11_1 = new Button("부전");
		button_11_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_11_1.setBounds(241, 188, 190, 102);
		panel_1_1.add(button_11_1);
		
		Button button_12_1 = new Button("홍성");
		button_12_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_12_1.setBounds(241, 296, 190, 102);
		panel_1_1.add(button_12_1);
		
		Button button_13_1 = new Button("영동");
		button_13_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_13_1.setBounds(437, 188, 190, 102);
		panel_1_1.add(button_13_1);
		
		Button button_14_1 = new Button("남춘천");
		button_14_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_14_1.setBounds(437, 296, 190, 102);
		panel_1_1.add(button_14_1);
		
		Button button_17_1 = new Button("제천");
		button_17_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_17_1.setBounds(633, 188, 190, 102);
		panel_1_1.add(button_17_1);
		
		Button button_23_1 = new Button("신탄진");
		button_23_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_23_1.setBounds(829, 188, 190, 102);
		panel_1_1.add(button_23_1);
		
		Button button_24_1 = new Button("왜관");
		button_24_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_24_1.setBounds(1025, 188, 190, 102);
		panel_1_1.add(button_24_1);
		
		Button button_25_1 = new Button("동해");
		button_25_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button_25_1.setBounds(1221, 188, 190, 102);
		panel_1_1.add(button_25_1);
		
		Button back_btn = new Button("이전으로");
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(card_panel);
			}
		});
		back_btn.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		back_btn.setBounds(1221, 819, 190, 102);
		panel_1_1.add(back_btn);
		
		JPanel metro_panel = new metro_panel();
		card_panel.add(metro_panel, "metro");

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		train_name = ((JButton)e.getSource()).getText();
		if(train_reverv_main.sub_select) {
			train_reverv_main.st_sub_btn.setText(train_name);
		}else {
			train_reverv_main.en_sub_btn.setText(train_name);
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
