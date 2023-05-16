package train.seat_special;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class SpecialSeatSelect extends JDialog{

   private JFrame frame;
   private String fisrtH ="<html>";
   private String middleH = "<br> /";
   public static JLabel selectedSeatInfoLabel = new JLabel();
   public static void setLable(String str) {
      selectedSeatInfoLabel.setText(str);
   }
   public static List<String> list;
   public static boolean chkAll = true;
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               SpecialSeatSelect window = new SpecialSeatSelect();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   private String mainFont = "HY헤드라인M"; 
   
   public SpecialSeatSelect() {
      getContentPane().setBackground(Color.WHITE);
//      getContentPane().setLayout(new BorderLayout(500,500));
      
      //[topPanel / middilPanel / lowPanel을 모두 포함하는 가장 큰 패널]
      JPanel totalMainPanel = new JPanel();
      totalMainPanel.setBackground(Color.WHITE);
      getContentPane().add(totalMainPanel, BorderLayout.NORTH);
      totalMainPanel.setLayout(new BorderLayout(0,0));
      
      // [화면 가운데에서 좌석선택 패널을 포함하는 패널]
      JPanel middlePanel = new JPanel();
      middlePanel.setBackground(Color.WHITE);
      totalMainPanel.add(middlePanel, BorderLayout.CENTER);
      middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
      
     JPanel seatSelectPanel = new JPanel();
     CardLayout card = new CardLayout(10,10);
     seatSelectPanel.setLayout(card);
     seatSelectPanel.setBackground(new Color(255, 255, 255));
     middlePanel.add(seatSelectPanel);
     
      //특실예매를 눌렀을 때 > [1~3호차]
      //1호차는 특실 + 휠체어석
      //2,3호차는 특실 + 일반좌석
      
      JPanel specialwheel1 = new SpecialWheelSeatPanel(); 
      JPanel special2 = new SpecialSeatPanel(); 
      JPanel special3 = new SpecialSeatPanel(); 
      
      seatSelectPanel.add("special1", specialwheel1);
      seatSelectPanel.add("special2", special2);
      seatSelectPanel.add("special3", special3);      
      
      // [화면 하단에서 좌석선택확인 라벨과 선택완료 버튼을 포함하는 패널]
      JPanel lowPanel = new JPanel();
      lowPanel.setBackground(Color.WHITE);
      totalMainPanel.add(lowPanel, BorderLayout.SOUTH);

      selectedSeatInfoLabel.setFont(new Font(mainFont, Font.PLAIN, 20));
      lowPanel.add(selectedSeatInfoLabel);
      
      JButton selectCompleteButton = new JButton("다음");
      selectCompleteButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		train.TrainReserv_Main.seatSelectLabel.setText("우등석"+list.toString());
      		train.TrainReserv_Main.seatSelectString = list;
      		setVisible(false);
      	}
      });
      selectCompleteButton.setForeground(Color.WHITE);
      
      selectCompleteButton.setBackground(new Color(0, 128, 192));
      selectCompleteButton.setBorderPainted(false);
      selectCompleteButton.setFocusPainted(false);
      selectCompleteButton.setFont(new Font(mainFont, Font.BOLD, 20));
      lowPanel.add(selectCompleteButton);      
      
      JButton selectRemoveBtn = new JButton("초기화");
      selectRemoveBtn.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		chkAll = true;
      		seatSelectPanel.remove(specialwheel1);
            seatSelectPanel.remove(special2);
            seatSelectPanel.remove(special3);
            
            JPanel specialwheel1 = new SpecialWheelSeatPanel(); 
            JPanel special2 = new SpecialSeatPanel(); 
            JPanel special3 = new SpecialSeatPanel(); 
            
            seatSelectPanel.add("special1", specialwheel1);
            seatSelectPanel.add("special2", special2);
            seatSelectPanel.add("special3", special3);
      	}
      });
      selectRemoveBtn.setForeground(Color.WHITE);
      selectRemoveBtn.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
      selectRemoveBtn.setFocusPainted(false);
      selectRemoveBtn.setBorderPainted(false);
      selectRemoveBtn.setBackground(new Color(0, 128, 192));
      lowPanel.add(selectRemoveBtn);
      
      //[화면 상단에서 호차선택콤보박스, 앞/뒤호차 이동 버튼, 현재 기차정보라벨을 포함하는 패널]
      JPanel topPanel = new JPanel();
      topPanel.setBackground(Color.WHITE);
      totalMainPanel.add(topPanel, BorderLayout.NORTH);
      topPanel.setLayout(new GridLayout(0, 1, 0, 0));
      
      JSplitPane splitPane = new JSplitPane(); //상단패널을 상1- 콤보박스, 상2 - 라벨및버튼으로 나눔
      splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
      topPanel.add(splitPane);
      
      JPanel top2panel = new JPanel();
      splitPane.setRightComponent(top2panel);
      top2panel.setLayout(new BorderLayout(0, 0));
      
      JComboBox trainInfoComboBox = new JComboBox();
      trainInfoComboBox.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String getSelectedCar = (String) trainInfoComboBox.getSelectedItem();
              if(getSelectedCar.contains("1호차")) {
                 card.show(seatSelectPanel,"special1");
              }else if(getSelectedCar.contains("2호차")) {
                 card.show(seatSelectPanel,"special2");
              }else if(getSelectedCar.contains("3호차")) {
                 card.show(seatSelectPanel,"special3");
              }
          }
      });
      
      trainInfoComboBox.setPreferredSize(new Dimension(900, 50));
      trainInfoComboBox.setBackground(Color.WHITE);
      trainInfoComboBox.setFont(new Font(mainFont, Font.PLAIN, 20));
      trainInfoComboBox.setMaximumRowCount(20);
      trainInfoComboBox.setModel(getSpecialCarInfo()); 
      splitPane.setLeftComponent(trainInfoComboBox);      
        
      JButton previousCarButton = new JButton("<");
      previousCarButton.setForeground(Color.WHITE);
      previousCarButton.setBackground(new Color(0, 128, 192));
      previousCarButton.setBorderPainted(false);
      previousCarButton.setFocusPainted(false);
      previousCarButton.setFont(new Font(mainFont, Font.BOLD, 20));      
      
      previousCarButton.addActionListener(new ActionListener() {      
         @Override
         public void actionPerformed(ActionEvent e) {
            int index = trainInfoComboBox.getSelectedIndex();
            if (index == 0) {
               System.out.println("카드 레이아웃의 끝임");
            } else {
               card.previous(seatSelectPanel);
               trainInfoComboBox.setSelectedIndex(index - 1);
            }
         }
      });
      
      top2panel.add(previousCarButton, BorderLayout.WEST);
      
      JButton nextCarButton = new JButton(">");
      nextCarButton.setForeground(Color.WHITE);
      nextCarButton.setBackground(new Color(0, 128, 192));
      nextCarButton.setBorderPainted(false);
      nextCarButton.setFocusPainted(false);
      nextCarButton.setFont(new Font(mainFont, Font.BOLD, 20));
      
      nextCarButton.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         
         int index = trainInfoComboBox.getSelectedIndex();
         if (index == 2) {
            System.out.println("카드 레이아웃의 마지막 번호임");
         } else {
            card.next(seatSelectPanel);
            trainInfoComboBox.setSelectedIndex(index + 1);
         }
      }
   });
      
      top2panel.add(nextCarButton, BorderLayout.EAST);
    //앞에서 기차정보를 받아와서 넣어야함(잔여좌석도)
      JLabel TrainInfoLabel = new JLabel("<html>KTX 316 (일반실)<br> / 잔여 3석 총 30석<html>");
      TrainInfoLabel.setBackground(new Color(255, 102, 153));
      TrainInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
      TrainInfoLabel.setFont(new Font(mainFont, Font.PLAIN, 30));
      top2panel.add(TrainInfoLabel);      
      
      setTitle("좌석 선택");
      setSize(1000,650);
      
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setVisible(true);
      setResizable(false);
      
   }
   
   
   /**특실예매를 눌렀을 떄 콤보박스에 전달해줘야하는 모델을 리턴하는 메서드*/
   DefaultComboBoxModel getSpecialCarInfo() {
      int special = 3;
      String[] trainInfo = new String[special];

      for (int i = 0; i <= trainInfo.length; i++) {
         if (i+1 == 1) { // 특실 + 휠체어석 1호차
            trainInfo[i] = i+1 + "호차   (휠체어석) / 특실";
         } else if (i+1 == 2 || i+1 == 3) { // 일반실 +일반좌석 5~ 10호차
            trainInfo[i] = i+1 + "호차 / 특실";
         }
      }

      DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(trainInfo);
      return model;
      }
}