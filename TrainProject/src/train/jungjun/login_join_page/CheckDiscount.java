package train.jungjun.login_join_page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckDiscount extends JDialog {

   private final JPanel contentPanel = new JPanel();
   private JTextField CardNum_textField;
   public static String CardNum = "";
   public static String alrim = "";

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      try {
         CheckDiscount dialog = new CheckDiscount();
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Create the dialog.
    */
   public CheckDiscount() {
      UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
      UIManager.put("OptionPane.messageFont",
            new Font("HY헤드라인M", Font.BOLD, 50));
      setBounds(800, 300, 600, 600);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);
      {
         JLabel alram = new JLabel("복지카드번호를 입력해주세요");
         alram.setHorizontalAlignment(SwingConstants.CENTER);
         alram.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
         alram.setBounds(75, 125, 450, 75);
         contentPanel.add(alram);
      }
      {
         JLabel cardNum = new JLabel("복지카드번호");
         cardNum.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
         cardNum.setBounds(180, 225, 200, 75);
         contentPanel.add(cardNum);
      }
      {
         CardNum_textField = new JTextField();
         CardNum_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
         CardNum_textField.setBounds(35, 300, 500, 100);
         contentPanel.add(CardNum_textField);
         CardNum_textField.setColumns(10);
      }
      {
         JButton OK = new JButton("확인");
         OK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               CardNum = CardNum_textField.getText();
               CheckDiscountRegex regex = new CheckDiscountRegex();
               if(regex.regex1() && Login_and_join.discount.equals("장애인")) {
                  Login_and_join.preferential_treatment = "disabled";
                  Login_and_join.preferential_treatment_chk_B = true;
                  alrim = "인증에 성공했습니다";
                  CheckDiscount_alrim alrim = new CheckDiscount_alrim();
                  alrim.main(null);
               }else if(regex.regex2() && Login_and_join.discount.equals("국가유공자")){
                  Login_and_join.preferential_treatment = "national_merit";
                  Login_and_join.preferential_treatment_chk_B = true;
                  alrim = "인증에 성공했습니다";
                  CheckDiscount_alrim alrim = new CheckDiscount_alrim();
                  alrim.main(null);
               }else if(regex.regex1() && Login_and_join.discount.equals("국가유공자")){
                  alrim = "장애인를 선택해주세요";
                  CheckDiscount_alrim alrim = new CheckDiscount_alrim();
                  alrim.main(null);
               }else if(regex.regex2() && Login_and_join.discount.equals("장애인")){
                  alrim = "국가유공자를 선택해주세요";
                  CheckDiscount_alrim alrim = new CheckDiscount_alrim();
                  alrim.main(null);
               }else {
                  alrim = "정확한 값을 입력하세요";
                  CheckDiscount_alrim alrim = new CheckDiscount_alrim();
                  alrim.main(null);
               }
            }
         });
         OK.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         OK.setForeground(Color.WHITE);
         OK.setBackground(new Color(0, 128, 192));
         OK.setBounds(35, 450, 200, 75);
         contentPanel.add(OK);
      }
      {
         JButton Cancel = new JButton("닫기");
         Cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
         });
         Cancel.setBackground(new Color(0, 128, 192));
         Cancel.setForeground(Color.WHITE);
         Cancel.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         Cancel.setBounds(335, 450, 200, 75);
         contentPanel.add(Cancel);
      }
      
      JLabel lblNewLabel = new JLabel(Login_and_join.discount + "이(가) 선택되었습니다");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
      lblNewLabel.setBounds(75, 30, 450, 75);
      contentPanel.add(lblNewLabel);
   }
}