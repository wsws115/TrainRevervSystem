package train;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class subway {

   private JFrame frame;
   private JTextField textField;
   private JTextField textField_1;
   private JTextField textField_2;

   /**
    * Launch the application.
    */
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
            Color o=new Color(247,99,12); //글자색 결정
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
            graphics.setFont(getFont()); 
            graphics.drawString(getText(), textX, textY); 
            graphics.dispose(); 
            super.paintComponent(g);
            }
         }
   public static void main(String[] args) {
      
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               
            	subway window = new subway();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public subway() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame("키오스크");
      frame.setBounds(100, 100, 2000, 1050);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.getContentPane().setLayout(null);
      
      JLabel lblNewLabel = new JLabel("출발지");
      lblNewLabel.setBounds(12, 132, 107, 73);
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      frame.getContentPane().add(lblNewLabel);
      
      JButton btnNewButton = new JButton("뒤로가기");
      btnNewButton.setFont(new Font("돋움", Font.BOLD, 30));
      btnNewButton.setBounds(12, 881, 202, 120);
      frame.getContentPane().add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton("다음");
      btnNewButton_1.setFont(new Font("돋움", Font.BOLD, 30));
      btnNewButton_1.setBounds(226, 881, 202, 120);
      frame.getContentPane().add(btnNewButton_1);
      
      JLabel lblNewLabel_2 = new JLabel("도착지");
      lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      lblNewLabel_2.setBounds(12, 215, 107, 73);
      frame.getContentPane().add(lblNewLabel_2);
      
      textField = new JTextField();
      textField.setBounds(157, 152, 181, 29);
      frame.getContentPane().add(textField);
      textField.setColumns(10);
      
      textField_1 = new JTextField();
      textField_1.setColumns(10);
      textField_1.setBounds(157, 246, 181, 29);
      frame.getContentPane().add(textField_1);
      
      JLabel lblNewLabel_2_1 = new JLabel("출발일자");
      lblNewLabel_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      lblNewLabel_2_1.setBounds(12, 298, 133, 73);
      frame.getContentPane().add(lblNewLabel_2_1);
      
      textField_2 = new JTextField();
      textField_2.setColumns(10);
      textField_2.setBounds(157, 321, 181, 29);
      frame.getContentPane().add(textField_2);
      
      JLabel lblNewLabel_2_2 = new JLabel("인원 수");
      lblNewLabel_2_2.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      lblNewLabel_2_2.setBounds(12, 381, 107, 73);
      frame.getContentPane().add(lblNewLabel_2_2);
      
      JComboBox comboBox = new JComboBox();
      comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
      comboBox.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      comboBox.setBounds(157, 412, 181, 29);
      frame.getContentPane().add(comboBox);
      
      RoundedButton button = new RoundedButton("서울");
      button.setFont(new Font("돋움", Font.BOLD, 25));
      button.setBounds(52, 74, 190, 102);
      
      RoundedButton button_1 = new RoundedButton("용산");
      button_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_1.setBounds(248, 74, 190, 102);
      
      RoundedButton button_2 = new RoundedButton("영등포");
      button_2.setFont(new Font("돋움", Font.BOLD, 25));
      button_2.setBounds(444, 74, 190, 102);
      
      RoundedButton button_3 = new RoundedButton("광명");
      button_3.setFont(new Font("돋움", Font.BOLD, 25));
      button_3.setBounds(640, 74, 190, 102);
      
      RoundedButton button_4 = new RoundedButton("수원");
      button_4.setFont(new Font("돋움", Font.BOLD, 25));
      button_4.setBounds(836, 74, 190, 102);
      
      RoundedButton button_5 = new RoundedButton("천안아산");
      button_5.setFont(new Font("돋움", Font.BOLD, 25));
      button_5.setBounds(1032, 74, 190, 102);
      
      RoundedButton button_6 = new RoundedButton("오송");
      button_6.setFont(new Font("돋움", Font.BOLD, 25));
      button_6.setBounds(1228, 74, 190, 102);
      
      RoundedButton button_7 = new RoundedButton("대전");
      button_7.setFont(new Font("돋움", Font.BOLD, 25));
      button_7.setBounds(52, 182, 190, 102);
      
      RoundedButton button_8 = new RoundedButton("서대전");
      button_8.setFont(new Font("돋움", Font.BOLD, 25));
      button_8.setBounds(52, 290, 190, 102);
      
      RoundedButton button_9 = new RoundedButton("김천구미");
      button_9.setFont(new Font("돋움", Font.BOLD, 25));
      button_9.setBounds(52, 398, 190, 102);
      
      RoundedButton button_10 = new RoundedButton("동대구");
      button_10.setFont(new Font("돋움", Font.BOLD, 25));
      button_10.setBounds(52, 506, 190, 102);
      
      RoundedButton button_11 = new RoundedButton("포항");
      button_11.setFont(new Font("돋움", Font.BOLD, 25));
      button_11.setBounds(248, 182, 190, 102);
      
      RoundedButton button_12 = new RoundedButton("밀양");
      button_12.setFont(new Font("돋움", Font.BOLD, 25));
      button_12.setBounds(248, 290, 190, 102);
      
      RoundedButton button_13 = new RoundedButton("구포");
      button_13.setFont(new Font("돋움", Font.BOLD, 25));
      button_13.setBounds(444, 182, 190, 102);
      
      RoundedButton button_14 = new RoundedButton("부산");
      button_14.setFont(new Font("돋움", Font.BOLD, 25));
      button_14.setBounds(444, 290, 190, 102);
      
      RoundedButton button_15 = new RoundedButton("신경주");
      button_15.setFont(new Font("돋움", Font.BOLD, 25));
      button_15.setBounds(248, 398, 190, 102);
      
      RoundedButton button_16 = new RoundedButton("울산(통도사)");
      button_16.setFont(new Font("돋움", Font.BOLD, 25));
      button_16.setBounds(444, 398, 190, 102);
      
      RoundedButton button_17 = new RoundedButton("마산");
      button_17.setFont(new Font("돋움", Font.BOLD, 25));
      button_17.setBounds(640, 182, 190, 102);
      
      RoundedButton button_18 = new RoundedButton("창원중앙");
      button_18.setFont(new Font("돋움", Font.BOLD, 25));
      button_18.setBounds(640, 290, 190, 102);
      
      RoundedButton button_19 = new RoundedButton("경산");
      button_19.setFont(new Font("돋움", Font.BOLD, 25));
      button_19.setBounds(248, 506, 190, 102);
      
      RoundedButton button_20 = new RoundedButton("논산");
      button_20.setFont(new Font("돋움", Font.BOLD, 25));
      button_20.setBounds(444, 506, 190, 102);
      
      RoundedButton button_21 = new RoundedButton("익산");
      button_21.setFont(new Font("돋움", Font.BOLD, 25));
      button_21.setBounds(640, 398, 190, 102);
      
      RoundedButton button_22 = new RoundedButton("정읍");
      button_22.setFont(new Font("돋움", Font.BOLD, 25));
      button_22.setBounds(640, 506, 190, 102);
      
      RoundedButton button_23 = new RoundedButton("광주송정");
      button_23.setFont(new Font("돋움", Font.BOLD, 25));
      button_23.setBounds(836, 182, 190, 102);
      
      RoundedButton button_24 = new RoundedButton("목포");
      button_24.setFont(new Font("돋움", Font.BOLD, 25));
      button_24.setBounds(1032, 182, 190, 102);
      
      RoundedButton button_25 = new RoundedButton("전주");
      button_25.setFont(new Font("돋움", Font.BOLD, 25));
      button_25.setBounds(1228, 182, 190, 102);
      
      RoundedButton button_26 = new RoundedButton("순천");
      button_26.setFont(new Font("돋움", Font.BOLD, 25));
      button_26.setBounds(836, 290, 190, 102);
      
      RoundedButton button_27 = new RoundedButton("여수EXPO");
      button_27.setFont(new Font("돋움", Font.BOLD, 25));
      button_27.setBounds(1032, 290, 190, 102);
      
      RoundedButton button_28 = new RoundedButton("청량리");
      button_28.setFont(new Font("돋움", Font.BOLD, 25));
      button_28.setBounds(1228, 290, 190, 102);
      
      RoundedButton button_29 = new RoundedButton("강릉");
      button_29.setFont(new Font("돋움", Font.BOLD, 25));
      button_29.setBounds(836, 398, 190, 102);
      
      RoundedButton button_30 = new RoundedButton("행신");
      button_30.setFont(new Font("돋움", Font.BOLD, 25));
      button_30.setBounds(1032, 398, 190, 102);
      
      RoundedButton button_31 = new RoundedButton("정동진");
      button_31.setFont(new Font("돋움", Font.BOLD, 25));
      button_31.setBounds(1228, 398, 190, 102);
      
      JFrame f = new JFrame("CardLayout");
      
      /** -------------------패널2--------------------------RoundedButton*/
      
      JPanel panel_2 = new JPanel();
      panel_2.setBounds(434, 126, 1436, 756);
      frame.getContentPane().add(panel_2);
      CardLayout card = new CardLayout();
      panel_2.setLayout(card);
      
      Panel panel = new Panel();
      panel_2.add(panel, "name_1729988537434500");
      panel.setBackground(new Color(153, 204, 204));
      panel.setLayout(null);
      panel.add(button);
      panel.add(button_1);
      panel.add(button_2);
      panel.add(button_3);
      panel.add(button_4);
      panel.add(button_5);
      panel.add(button_6);
      panel.add(button_7);
      panel.add(button_8);
      panel.add(button_9);
      panel.add(button_10);
      panel.add(button_11);
      panel.add(button_12);
      panel.add(button_13);
      panel.add(button_14);
      panel.add(button_15);
      panel.add(button_16);
      panel.add(button_17);
      panel.add(button_18);
      panel.add(button_19);
      panel.add(button_20);
      panel.add(button_21);
      panel.add(button_22);
      panel.add(button_23);
      panel.add(button_24);
      panel.add(button_25);
      panel.add(button_26);
      panel.add(button_27);
      panel.add(button_28);
      panel.add(button_29);
      panel.add(button_30);
      panel.add(button_31);
      
      Button next_btn = new Button("다음");
      next_btn.setFont(new Font("돋움", Font.BOLD, 25));
      next_btn.setBounds(1236, 644, 190, 102);
      panel.add(next_btn);
      
      JLabel lblNewLabel_1 = new JLabel("주요역");
      lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
      lblNewLabel_1.setBounds(42, 10, 190, 58);
      panel.add(lblNewLabel_1);
      
      JLabel lblNewLabel_1_1 = new JLabel("KTX 정차역");
      lblNewLabel_1_1.setForeground(new Color(255, 0, 0));
      lblNewLabel_1_1.setFont(new Font("돋움", Font.BOLD, 40));
      lblNewLabel_1_1.setBounds(630, 10, 251, 58);
      panel.add(lblNewLabel_1_1);
      
      Button next_btn_1 = new Button("철도역");
      next_btn_1.setFont(new Font("돋움", Font.BOLD, 25));
      next_btn_1.setBounds(52, 644, 190, 102);
      panel.add(next_btn_1);
      
      Panel panel_1 = new Panel();
      panel_1.setLayout(null);
      panel_1.setBackground(new Color(153, 204, 204));
      panel_1.setBounds(31, 37, 1395, 709);
      panel_2.add(panel_1);
      
      Button button_35 = new Button("평택");
      button_35.setFont(new Font("돋움", Font.BOLD, 25));
      button_35.setBounds(45, 80, 190, 102);
      panel_1.add(button_35);
      
      Button button_1_1 = new Button("천안");
      button_1_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_1_1.setBounds(241, 80, 190, 102);
      panel_1.add(button_1_1);
      
      Button button_2_1 = new Button("조치원");
      button_2_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_2_1.setBounds(437, 80, 190, 102);
      panel_1.add(button_2_1);
      
      Button button_3_1 = new Button("김천");
      button_3_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_3_1.setBounds(633, 80, 190, 102);
      panel_1.add(button_3_1);
      
      Button button_4_1 = new Button("구미");
      button_4_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_4_1.setBounds(829, 80, 190, 102);
      panel_1.add(button_4_1);
      
      Button button_5_1 = new Button("태화강");
      button_5_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_5_1.setBounds(1025, 80, 190, 102);
      panel_1.add(button_5_1);
      
      Button button_6_1 = new Button("대천");
      button_6_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_6_1.setBounds(1221, 80, 190, 102);
      panel_1.add(button_6_1);
      
      Button button_7_1 = new Button("춘천");
      button_7_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_7_1.setBounds(45, 188, 190, 102);
      panel_1.add(button_7_1);
      
      Button button_8_1 = new Button("원주");
      button_8_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_8_1.setBounds(45, 296, 190, 102);
      panel_1.add(button_8_1);
      
      Button button_11_1 = new Button("부전");
      button_11_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_11_1.setBounds(241, 188, 190, 102);
      panel_1.add(button_11_1);
      
      Button button_12_1 = new Button("홍성");
      button_12_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_12_1.setBounds(241, 296, 190, 102);
      panel_1.add(button_12_1);
      
      Button button_13_1 = new Button("영동");
      button_13_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_13_1.setBounds(437, 188, 190, 102);
      panel_1.add(button_13_1);
      
      Button button_14_1 = new Button("남춘천");
      button_14_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_14_1.setBounds(437, 296, 190, 102);
      panel_1.add(button_14_1);
      
      Button button_17_1 = new Button("제천");
      button_17_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_17_1.setBounds(633, 188, 190, 102);
      panel_1.add(button_17_1);
      
      Button button_23_1 = new Button("신탄진");
      button_23_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_23_1.setBounds(829, 188, 190, 102);
      panel_1.add(button_23_1);
      
      Button button_24_1 = new Button("왜관");
      button_24_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_24_1.setBounds(1025, 188, 190, 102);
      panel_1.add(button_24_1);
      
      Button button_25_1 = new Button("동해");
      button_25_1.setFont(new Font("돋움", Font.BOLD, 25));
      button_25_1.setBounds(1221, 188, 190, 102);
      panel_1.add(button_25_1);
      
      Button back_btn = new Button("이전으로");
      back_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            card.previous(panel_2);
         }
      });
      back_btn.setFont(new Font("돋움", Font.BOLD, 25));
      back_btn.setBounds(1236, 644, 190, 102);
      panel_1.add(back_btn);
      
      next_btn.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            card.next(panel_2);
         }
      });
      
   }
}