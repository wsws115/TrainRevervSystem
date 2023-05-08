package train;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;

public class FoodCourtPanel extends JPanel {
   private JTable table;
   
   /**
    * Create the panel.
    */
   
   public FoodCourtPanel() {
      
      setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
      setBounds(0, 0, 1500, 1010);
      setLayout(null);
      
         JButton menuButton1 = new JButton("도시락");
         menuButton1.setBounds(47, 29, 240, 81);
         add(menuButton1);
         menuButton1.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
         menuButton1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 20));
         
         JButton menuButton2 = new JButton("면류");
         menuButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
         });
         menuButton2.setBounds(403, 29, 240, 81);
         add(menuButton2);
         menuButton2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 20));
         
         JButton menuButton3 = new JButton("간식");
         menuButton3.setBounds(757, 29, 240, 81);
         add(menuButton3);
         menuButton3.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 20));
         
         JButton menuButton4 = new JButton("음료");
         menuButton4.setBounds(1130, 29, 240, 81);
         add(menuButton4);
         menuButton4.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 20));
         
         JLabel menuLabel = new JLabel("【 메뉴 선택 】");
         menuLabel.setBounds(40, 150, 141, 32);
         add(menuLabel);
         menuLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
      JScrollPane menuPanel = new JScrollPane();
      menuPanel.setPreferredSize(new Dimension(1420, 550));
      menuPanel.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
      menuPanel.setBounds(40, 200, 1406, 548);
      add(menuPanel);
      
      JPanel panel_1 = new JPanel();
      panel_1.setLayout(null);
      panel_1.setPreferredSize(new Dimension(1405, 800));
      panel_1.setAutoscrolls(true);
      menuPanel.setViewportView(panel_1);
      
      JButton nullBtn_10 = new JButton();
      nullBtn_10.setBounds(0, 47, 240, 223);
      panel_1.add(nullBtn_10);
      
      JLabel nullLab_10 = new JLabel("선택안함");
      nullLab_10.setHorizontalAlignment(SwingConstants.CENTER);
      nullLab_10.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      nullLab_10.setBounds(37, 10, 141, 40);
      panel_1.add(nullLab_10);
      
      JLabel bulgogiPriceLab_1_10 = new JLabel("8000원");
      bulgogiPriceLab_1_10.setHorizontalAlignment(SwingConstants.CENTER);
      bulgogiPriceLab_1_10.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      bulgogiPriceLab_1_10.setBounds(48, 280, 141, 40);
      panel_1.add(bulgogiPriceLab_1_10);
      
      JButton nullBtn_1_1 = new JButton();
      nullBtn_1_1.setBounds(289, 47, 240, 223);
      panel_1.add(nullBtn_1_1);
      
      JLabel bulgogiPriceLab_1_1_1 = new JLabel("8000원");
      bulgogiPriceLab_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
      bulgogiPriceLab_1_1_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      bulgogiPriceLab_1_1_1.setBounds(337, 280, 141, 40);
      panel_1.add(bulgogiPriceLab_1_1_1);
      
      JLabel nullLab_1_1 = new JLabel("선택안함");
      nullLab_1_1.setHorizontalAlignment(SwingConstants.CENTER);
      nullLab_1_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      nullLab_1_1.setBounds(326, 10, 141, 40);
      panel_1.add(nullLab_1_1);
      
      JButton nullBtn_2_1 = new JButton();
      nullBtn_2_1.setBounds(590, 47, 240, 223);
      panel_1.add(nullBtn_2_1);
      
      JLabel bulgogiPriceLab_1_2_1 = new JLabel("8000원");
      bulgogiPriceLab_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
      bulgogiPriceLab_1_2_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      bulgogiPriceLab_1_2_1.setBounds(638, 280, 141, 40);
      panel_1.add(bulgogiPriceLab_1_2_1);
      
      JLabel nullLab_2_1 = new JLabel("선택안함");
      nullLab_2_1.setHorizontalAlignment(SwingConstants.CENTER);
      nullLab_2_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      nullLab_2_1.setBounds(627, 10, 141, 40);
      panel_1.add(nullLab_2_1);
      
      JButton nullBtn_3_1 = new JButton();
      nullBtn_3_1.setBounds(876, 47, 240, 223);
      panel_1.add(nullBtn_3_1);
      
      JLabel bulgogiPriceLab_1_3_1 = new JLabel("8000원");
      bulgogiPriceLab_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
      bulgogiPriceLab_1_3_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      bulgogiPriceLab_1_3_1.setBounds(924, 280, 141, 40);
      panel_1.add(bulgogiPriceLab_1_3_1);
      
      JLabel nullLab_3_1 = new JLabel("선택안함");
      nullLab_3_1.setHorizontalAlignment(SwingConstants.CENTER);
      nullLab_3_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      nullLab_3_1.setBounds(913, 10, 141, 40);
      panel_1.add(nullLab_3_1);
      
      JButton nullBtn_4_1 = new JButton();
      nullBtn_4_1.setBounds(1154, 47, 240, 223);
      panel_1.add(nullBtn_4_1);
      
      JLabel bulgogiPriceLab_1_4_1 = new JLabel("8000원");
      bulgogiPriceLab_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
      bulgogiPriceLab_1_4_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      bulgogiPriceLab_1_4_1.setBounds(1202, 280, 141, 40);
      panel_1.add(bulgogiPriceLab_1_4_1);
      
      JLabel nullLab_4_1 = new JLabel("선택안함");
      nullLab_4_1.setHorizontalAlignment(SwingConstants.CENTER);
      nullLab_4_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      nullLab_4_1.setBounds(1191, 10, 141, 40);
      panel_1.add(nullLab_4_1);
      
      JButton nullBtn_5_1 = new JButton();
      nullBtn_5_1.setBounds(0, 391, 240, 223);
      panel_1.add(nullBtn_5_1);
      
      JLabel bulgogiPriceLab_1_5_1 = new JLabel("8000원");
      bulgogiPriceLab_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
      bulgogiPriceLab_1_5_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      bulgogiPriceLab_1_5_1.setBounds(48, 624, 141, 40);
      panel_1.add(bulgogiPriceLab_1_5_1);
      
      JLabel nullLab_5_1 = new JLabel("선택안함");
      nullLab_5_1.setHorizontalAlignment(SwingConstants.CENTER);
      nullLab_5_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      nullLab_5_1.setBounds(37, 354, 141, 40);
      panel_1.add(nullLab_5_1);
      
      JButton nullBtn_6_1 = new JButton();
      nullBtn_6_1.setBounds(289, 391, 240, 223);
      panel_1.add(nullBtn_6_1);
      
      JLabel bulgogiPriceLab_1_6_1 = new JLabel("8000원");
      bulgogiPriceLab_1_6_1.setHorizontalAlignment(SwingConstants.CENTER);
      bulgogiPriceLab_1_6_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      bulgogiPriceLab_1_6_1.setBounds(337, 624, 141, 40);
      panel_1.add(bulgogiPriceLab_1_6_1);
      
      JLabel nullLab_6_1 = new JLabel("선택안함");
      nullLab_6_1.setHorizontalAlignment(SwingConstants.CENTER);
      nullLab_6_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      nullLab_6_1.setBounds(326, 354, 141, 40);
      panel_1.add(nullLab_6_1);
      
      JButton nullBtn_7_1 = new JButton();
      nullBtn_7_1.setBounds(590, 391, 240, 223);
      panel_1.add(nullBtn_7_1);
      
      JLabel bulgogiPriceLab_1_7_1 = new JLabel("8000원");
      bulgogiPriceLab_1_7_1.setHorizontalAlignment(SwingConstants.CENTER);
      bulgogiPriceLab_1_7_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      bulgogiPriceLab_1_7_1.setBounds(638, 624, 141, 40);
      panel_1.add(bulgogiPriceLab_1_7_1);
      
      JLabel nullLab_7_1 = new JLabel("선택안함");
      nullLab_7_1.setHorizontalAlignment(SwingConstants.CENTER);
      nullLab_7_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      nullLab_7_1.setBounds(627, 354, 141, 40);
      panel_1.add(nullLab_7_1);
      
      JButton nullBtn_8_1 = new JButton();
      nullBtn_8_1.setBounds(876, 391, 240, 223);
      panel_1.add(nullBtn_8_1);
      
      JLabel bulgogiPriceLab_1_8_1 = new JLabel("8000원");
      bulgogiPriceLab_1_8_1.setHorizontalAlignment(SwingConstants.CENTER);
      bulgogiPriceLab_1_8_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      bulgogiPriceLab_1_8_1.setBounds(924, 624, 141, 40);
      panel_1.add(bulgogiPriceLab_1_8_1);
      
      JLabel nullLab_8_1 = new JLabel("선택안함");
      nullLab_8_1.setHorizontalAlignment(SwingConstants.CENTER);
      nullLab_8_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      nullLab_8_1.setBounds(913, 354, 141, 40);
      panel_1.add(nullLab_8_1);
      
      JButton nullBtn_9_1 = new JButton();
      nullBtn_9_1.setBounds(1154, 391, 240, 223);
      panel_1.add(nullBtn_9_1);
      
      JLabel bulgogiPriceLab_1_9_1 = new JLabel("8000원");
      bulgogiPriceLab_1_9_1.setHorizontalAlignment(SwingConstants.CENTER);
      bulgogiPriceLab_1_9_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      bulgogiPriceLab_1_9_1.setBounds(1202, 624, 141, 40);
      panel_1.add(bulgogiPriceLab_1_9_1);
      
      JLabel nullLab_9_1 = new JLabel("선택안함");
      nullLab_9_1.setHorizontalAlignment(SwingConstants.CENTER);
      nullLab_9_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
      nullLab_9_1.setBounds(1191, 354, 141, 40);
      panel_1.add(nullLab_9_1);
         
         JPanel choicePanel = new JPanel();
         choicePanel.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
         choicePanel.setBounds(40, 745, 1406, 234);
         add(choicePanel);
         choicePanel.setLayout(new BorderLayout(0, 0));
         
         String header[]= {"구분","음식이름","수량","가격"};
         String food[][] = {
               {"도시락","불고기덮밥","1","8000원"},
               {"도시락","전주비빔밥","1","10000원"} 
         };
//         String header[]= {"구분","열차번호","출발","도착","특실/우등실","일반","유아","자유석/입석","가격","예약대기","소요시간"};
//       String train[][] = {
//             {"KTX","15","대전","서울","","","","","23700","","1:55"},
//             {"KTX","13","대전","서울","","","","","23700","","1:58"} 
//       };
         table = new JTable(food, header);
         table.setModel(new DefaultTableModel(
            new Object[][] {
               {"\uB3C4\uC2DC\uB77D", "\uBD88\uACE0\uAE30\uB36E\uBC25", "1", "8000\uC6D0"},
               {"\uB3C4\uC2DC\uB77D", "\uC804\uC8FC\uBE44\uBE54\uBC25", "1", "10000\uC6D0"},
               {null, null, null, null},
               {null, null, null, null},
               {"\uCD1D\uAC00\uACA9", null, null, "18000"},
            },
            new String[] {
               "\uAD6C\uBD84", "\uC74C\uC2DD\uC774\uB984", "\uC218\uB7C9", "\uAC00\uACA9"
            }
         ));
         
         table.setRowHeight(30);
         table.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
         choicePanel.add(table, BorderLayout.CENTER);
         
         // 스크롤바
         JScrollPane pane = new JScrollPane();
         
         
   }
}