package train;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class Seat1 extends JPanel {

   /**
    * Create the panel.
    */
   public Seat1() {
      
      setBounds(412, 0, 1333, 871);
      setLayout(null);
      
      
      //화면 좌측에서 새로고침, 인원선택을 포함하는 패널
      JPanel leftPanel = new JPanel();
//      leftPanel.setBackground(SystemColor.inactiveCaption);
      leftPanel.setBounds(12,10,500,850);
      leftPanel.setLayout(null);
      add(leftPanel);
      
      
      // 타입별 라벨 (어른, 어린이, 유아, 경로, 중증장애인, 경증장애인) 
      JLabel typeLabel1 = new JLabel("어른(만 13세 이상)");
      typeLabel1.setBounds(69, 272, 102, 15);
      leftPanel.add(typeLabel1);
      
      JLabel typeLabel2 = new JLabel("어린이(만 6세 ~ 12세)");
      typeLabel2.setBounds(69, 332, 121, 15);
      leftPanel.add(typeLabel2);
      
      JLabel typeLabel3 = new JLabel("유아(만 6세 미만)");
      typeLabel3.setBounds(69, 392, 96, 15);
      leftPanel.add(typeLabel3);
      
      JLabel typeLabel4 = new JLabel("경로(만 65세 미만)");
      typeLabel4.setBounds(69, 452, 102, 15);
      leftPanel.add(typeLabel4);
      
      JLabel typeLabel5 = new JLabel("중증 장애인");
      typeLabel5.setBounds(69, 512, 64, 15);
      leftPanel.add(typeLabel5);
      
      JLabel typeLabel6 = new JLabel("경증 장애인");
      typeLabel6.setBounds(69, 572, 64, 15);
      leftPanel.add(typeLabel6);
      
      
      // 타입 별 인원 선택 버튼(plus, minus), 새로고침 버튼
      JButton returnBtn = new JButton("새로고침");
      returnBtn.setBounds(279, 89, 149, 84);
      returnBtn.setFont(new Font("굴림", Font.BOLD, 25));
      leftPanel.add(returnBtn);
      
      JButton plusBtn1 = new JButton("+");
      plusBtn1.setBounds(383, 257, 45, 45);
      leftPanel.add(plusBtn1);
      
      JButton plusBtn2 = new JButton("+");
      plusBtn2.setBounds(383, 317, 45, 45);
      leftPanel.add(plusBtn2);
      
      JButton plusBtn3 = new JButton("+");
      plusBtn3.setBounds(383, 377, 45, 45);
      leftPanel.add(plusBtn3);
      
      JButton plusBtn4 = new JButton("+");
      plusBtn4.setBounds(383, 437, 45, 45);
      leftPanel.add(plusBtn4);
      
      JButton plusBtn5 = new JButton("+");
      plusBtn5.setBounds(383, 497, 45, 45);
      leftPanel.add(plusBtn5);
      
      JButton plusBtn6 = new JButton("+");
      plusBtn6.setBounds(383, 557, 45, 45);
      leftPanel.add(plusBtn6);
      
      JButton minusBtn1 = new JButton("-");
      minusBtn1.setBounds(279, 317, 45, 45);
      leftPanel.add(minusBtn1);
      
      JButton minusBtn2 = new JButton("-");
      minusBtn2.setBounds(279, 377, 45, 45);
      leftPanel.add(minusBtn2);
      
      JButton minusBtn3 = new JButton("-");
      minusBtn3.setBounds(279, 437, 45, 45);
      leftPanel.add(minusBtn3);
      
      JButton minusBtn4 = new JButton("-");
      minusBtn4.setBounds(279, 497, 45, 45);
      leftPanel.add(minusBtn4);
      
      JButton minusBtn5 = new JButton("-");
      minusBtn5.setBounds(279, 557, 45, 45);
      leftPanel.add(minusBtn5);
      
      JButton minusBtn6 = new JButton("-");
      minusBtn6.setBounds(279, 257, 45, 45);
      leftPanel.add(minusBtn6);

      
      //타입별 인원 카운트
      JTextField countTextField1 = new JTextField();
      countTextField1.setBounds(331, 258, 45, 45);
      countTextField1.setHorizontalAlignment(SwingConstants.CENTER);
      countTextField1.setText("1");
      leftPanel.add(countTextField1);
      countTextField1.setColumns(10);
      
      JTextField countTextField2 = new JTextField();
      countTextField2.setBounds(331, 318, 45, 45);
      countTextField2.setText("0");
      countTextField2.setHorizontalAlignment(SwingConstants.CENTER);
      countTextField2.setColumns(10);
      leftPanel.add(countTextField2);
      
      JTextField countTextField3 = new JTextField();
      countTextField3.setBounds(331, 378, 45, 45);
      countTextField3.setText("0");
      countTextField3.setHorizontalAlignment(SwingConstants.CENTER);
      countTextField3.setColumns(10);
      leftPanel.add(countTextField3);
      
      JTextField countTextField4 = new JTextField();
      countTextField4.setBounds(331, 438, 45, 45);
      countTextField4.setText("0");
      countTextField4.setHorizontalAlignment(SwingConstants.CENTER);
      countTextField4.setColumns(10);
      leftPanel.add(countTextField4);
      
      JTextField countTextField5 = new JTextField();
      countTextField5.setBounds(331, 498, 45, 45);
      countTextField5.setText("0");
      countTextField5.setHorizontalAlignment(SwingConstants.CENTER);
      countTextField5.setColumns(10);
      leftPanel.add(countTextField5);
      
      JTextField countTextField6 = new JTextField();
      countTextField6.setBounds(331, 558, 45, 45);
      countTextField6.setText("0");
      countTextField6.setHorizontalAlignment(SwingConstants.CENTER);
      countTextField6.setColumns(10);
      leftPanel.add(countTextField6);
      
      JToggleButton test_toggle_btn = new JToggleButton("");
      test_toggle_btn.setEnabled(false);
      test_toggle_btn.setDisabledIcon(new ImageIcon("C:\\Java_WorkSpace\\enable_img.png"));
      test_toggle_btn.setIcon(new ImageIcon("C:\\Java_WorkSpace\\standard.png"));
      test_toggle_btn.setSelectedIcon(new ImageIcon("C:\\Java_WorkSpace\\select.png"));
      test_toggle_btn.setBounds(12, 626, 221, 193);
      leftPanel.add(test_toggle_btn);
      test_toggle_btn.setDisabledIcon(null);
      
      JToggleButton test_toggle_btn_1 = new JToggleButton("");
      test_toggle_btn_1.setEnabled(true);
      test_toggle_btn_1.setDisabledIcon(new ImageIcon("C:\\Java_WorkSpace\\enable_img.png"));
      test_toggle_btn_1.setIcon(new ImageIcon("C:\\Java_WorkSpace\\standard.png"));
      test_toggle_btn_1.setSelectedIcon(new ImageIcon("C:\\Java_WorkSpace\\select.png"));
      test_toggle_btn_1.setBounds(245, 626, 221, 193);
      leftPanel.add(test_toggle_btn_1);

      
      
      //화면 우측에서 호차정보 콤보박스, 기차정보 라벨, 호차이동 버튼, 좌석 선택 버튼을 포함하는 패널
      JPanel rightPanel = new JPanel();
      rightPanel.setBounds(524,10,800,850);
//      rightPanel.setBackground(SystemColor.inactiveCaption);
      add(rightPanel);
      rightPanel.setLayout(null);
      
      //해당 열차의 전 호차의 정보를 볼 수 있는 콤보박스
      // 들어가야 할 정보 : 호차넘버, 타입, 잔여 좌석 수 
      JComboBox trainNum_comboBox = new JComboBox();
      trainNum_comboBox.setMaximumRowCount(20);
      trainNum_comboBox.setBounds(50, 50, 700, 40);
      rightPanel.add(trainNum_comboBox);
      
      //현재 기차의 정보를 알려주는 라벨
      JLabel trainInfoLabel = new JLabel("KTX-산천 419 (일반실) ");
      trainInfoLabel.setBounds(282, 122, 230, 24);
      trainInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
      trainInfoLabel.setFont(new Font("굴림", Font.BOLD, 20));
      rightPanel.add(trainInfoLabel);
      
      // 호차번호 -1 (앞칸으로 이동)
      JButton previousBtn = new JButton("14호차");
      previousBtn.setBounds(50, 138, 120, 40);
      rightPanel.add(previousBtn);
      
      // 호차번호 + 1 (뒷칸으로 이동)
      JButton nextBtn = new JButton("16호차");
      nextBtn.setBounds(630, 138, 120, 40);
      rightPanel.add(nextBtn);
      
      JLabel seatInfoLabel = new JLabel("잔여 25석 / 전체 28 석");
      seatInfoLabel.setBounds(167, 156, 469, 34);
      rightPanel.add(seatInfoLabel);
      seatInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
      seatInfoLabel.setFont(new Font("굴림", Font.BOLD, 20));
      
      JScrollPane seatScrollPane = new JScrollPane();
      seatScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      seatScrollPane.setPreferredSize(new Dimension(700,600)); 
      rightPanel.add(seatScrollPane);
      seatScrollPane.setBounds(50,200,700,600);
      
      JPanel seatPanel = new JPanel();
      seatPanel.setPreferredSize(new Dimension(700,1500));
//      seatPanel.setBackground(new Color(255, 175, 175));
      seatPanel.setBounds(50,200,700,600);
      
      seatScrollPane.setViewportView(seatPanel);
      seatPanel.setLayout(null);
      
      
      //좌석 선택 버튼
      //이미 예약된 좌석일 경우 enable로 바꿈
      JButton seatselectBtn1 = new JButton("A1");
      seatselectBtn1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		
      	}
      });
      seatselectBtn1.setBounds(50, 50, 100, 100);
      seatPanel.add(seatselectBtn1);
      
      JButton seatselectBtn2 = new JButton("A2");
      seatselectBtn2.setBounds(170, 50, 100, 100);
      seatPanel.add(seatselectBtn2);
      
      JButton seatselectBtn3 = new JButton("A3");
      seatselectBtn3.setBounds(430, 50, 100, 100);
      seatPanel.add(seatselectBtn3);
      
      JButton seatselectBtn5 = new JButton("A4");
      seatselectBtn5.setBounds(550, 50, 100, 100);
      seatPanel.add(seatselectBtn5);
      
      JButton seatselectBtn6 = new JButton("B1");
      seatselectBtn6.setBounds(50, 170, 100, 100);
      seatPanel.add(seatselectBtn6);
      
      JButton seatselectBtn7 = new JButton("B2");
      seatselectBtn7.setBounds(170, 170, 100, 100);
      seatPanel.add(seatselectBtn7);
      
      JButton seatselectBtn8 = new JButton("B3");
      seatselectBtn8.setBounds(430, 170, 100, 100);
      seatPanel.add(seatselectBtn8);
      
      JButton seatselectBtn9 = new JButton("B4");
      seatselectBtn9.setBounds(550, 170, 100, 100);
      seatPanel.add(seatselectBtn9);
      
      JButton seatselectBtn10 = new JButton("C1");
      seatselectBtn10.setBounds(50, 290, 100, 100);
      seatPanel.add(seatselectBtn10);
      
      JButton seatselectBtn11 = new JButton("C2");
      seatselectBtn11.setBounds(170, 290, 100, 100);
      seatPanel.add(seatselectBtn11);
      
      JButton seatselectBtn12 = new JButton("C3");
      seatselectBtn12.setBounds(430, 290, 100, 100);
      seatPanel.add(seatselectBtn12);
      
      JButton seatselectBtn13 = new JButton("C4");
      seatselectBtn13.setBounds(550, 290, 100, 100);
      seatPanel.add(seatselectBtn13);
      
      JButton seatselectBtn14 = new JButton("D1");
      seatselectBtn14.setBounds(50, 410, 100, 100);
      seatPanel.add(seatselectBtn14);
      
      JButton seatselectBtn15 = new JButton("D2");
      seatselectBtn15.setBounds(170, 410, 100, 100);
      seatPanel.add(seatselectBtn15);
      
      JButton seatselectBtn16 = new JButton("D3");
      seatselectBtn16.setBounds(430, 410, 100, 100);
      seatPanel.add(seatselectBtn16);
      
      JButton seatselectBtn17 = new JButton("D4");
      seatselectBtn17.setBounds(550, 410, 100, 100);
      seatPanel.add(seatselectBtn17);
      
      JButton seatselectBtn18 = new JButton("E1");
      seatselectBtn18.setBounds(50, 530, 100, 100);
      seatPanel.add(seatselectBtn18);
      
      JButton seatselectBtn19 = new JButton("E2");
      seatselectBtn19.setBounds(170, 530, 100, 100);
      seatPanel.add(seatselectBtn19);
      
      JButton seatselectBtn20 = new JButton("E3");
      seatselectBtn20.setBounds(430, 530, 100, 100);
      seatPanel.add(seatselectBtn20);
      
      JButton seatselectBtn21 = new JButton("E4");
      seatselectBtn21.setBounds(550, 530, 100, 100);
      seatPanel.add(seatselectBtn21);
      
      JButton seatselectBtn22 = new JButton("F1");
      seatselectBtn22.setBounds(50, 650, 100, 100);
      seatPanel.add(seatselectBtn22);
      
      JButton seatselectBtn23 = new JButton("F2");
      seatselectBtn23.setBounds(170, 650, 100, 100);
      seatPanel.add(seatselectBtn23);
      
      JButton seatselectBtn24 = new JButton("F3");
      seatselectBtn24.setBounds(430, 650, 100, 100);
      seatPanel.add(seatselectBtn24);
      
      JButton seatselectBtn25 = new JButton("F4");
      seatselectBtn25.setBounds(550, 650, 100, 100);
      seatPanel.add(seatselectBtn25);
      
      JButton seatselectBtn26 = new JButton("G1");
      seatselectBtn26.setBounds(50, 770, 100, 100);
      seatPanel.add(seatselectBtn26);
      
      JButton seatselectBtn27 = new JButton("G2");
      seatselectBtn27.setBounds(170, 770, 100, 100);
      seatPanel.add(seatselectBtn27);
      
      JButton seatselectBtn28 = new JButton("G3");
      seatselectBtn28.setBounds(430, 770, 100, 100);
      seatPanel.add(seatselectBtn28);
      
      JButton seatselectBtn29 = new JButton("G4");
      seatselectBtn29.setBounds(550, 770, 100, 100);
      seatPanel.add(seatselectBtn29);
      
      JButton seatselectBtn30 = new JButton("H1");
      seatselectBtn30.setBounds(50, 890, 100, 100);
      seatPanel.add(seatselectBtn30);
      
      JButton seatselectBtn31 = new JButton("H2");
      seatselectBtn31.setBounds(170, 890, 100, 100);
      seatPanel.add(seatselectBtn31);
      
      JButton seatselectBtn32 = new JButton("H3");
      seatselectBtn32.setBounds(430, 890, 100, 100);
      seatPanel.add(seatselectBtn32);
      
      JButton seatselectBtn33 = new JButton("H4");
      seatselectBtn33.setBounds(550, 890, 100, 100);
      seatPanel.add(seatselectBtn33);
      
      JButton seatselectBtn34 = new JButton("I1");
      seatselectBtn34.setBounds(50, 1010, 100, 100);
      seatPanel.add(seatselectBtn34);
      
      JButton seatselectBtn35 = new JButton("I2");
      seatselectBtn35.setBounds(170, 1010, 100, 100);
      seatPanel.add(seatselectBtn35);
      
      JButton seatselectBtn36 = new JButton("I3");
      seatselectBtn36.setBounds(430, 1010, 100, 100);
      seatPanel.add(seatselectBtn36);
      
      JButton seatselectBtn37 = new JButton("I4");
      seatselectBtn37.setBounds(550, 1010, 100, 100);
      seatPanel.add(seatselectBtn37);
      
      JButton seatselectBtn38 = new JButton("J1");
      seatselectBtn38.setBounds(50, 1130, 100, 100);
      seatPanel.add(seatselectBtn38);
      
      JButton seatselectBtn39 = new JButton("J2");
      seatselectBtn39.setBounds(170, 1130, 100, 100);
      seatPanel.add(seatselectBtn39);
      
      JButton seatselectBtn40 = new JButton("J3");
      seatselectBtn40.setBounds(430, 1130, 100, 100);
      seatPanel.add(seatselectBtn40);
      
      JButton seatselectBtn41 = new JButton("J4");
      seatselectBtn41.setBounds(550, 1130, 100, 100);
      seatPanel.add(seatselectBtn41);
      
      JButton seatselectBtn42 = new JButton("K1");
      seatselectBtn42.setBounds(50, 1250, 100, 100);
      seatPanel.add(seatselectBtn42);
      
      JButton seatselectBtn43 = new JButton("K2");
      seatselectBtn43.setBounds(170, 1250, 100, 100);
      seatPanel.add(seatselectBtn43);
      
      JButton seatselectBtn44 = new JButton("K3");
      seatselectBtn44.setBounds(430, 1250, 100, 100);
      seatPanel.add(seatselectBtn44);
      
      JButton seatselectBtn45 = new JButton("K4");
      seatselectBtn45.setBounds(550, 1250, 100, 100);
      seatPanel.add(seatselectBtn45);
      
      JButton seatselectBtn46 = new JButton("L1");
      seatselectBtn46.setBounds(50, 1370, 100, 100);
      seatPanel.add(seatselectBtn46);
      
      JButton seatselectBtn47 = new JButton("L2");
      seatselectBtn47.setBounds(170, 1370, 100, 100);
      seatPanel.add(seatselectBtn47);
      
      JButton seatselectBtn48 = new JButton("L3");
      seatselectBtn48.setBounds(430, 1370, 100, 100);
      seatPanel.add(seatselectBtn48);
      
      JButton seatselectBtn49 = new JButton("L4");
      seatselectBtn49.setBounds(550, 1370, 100, 100);
      seatPanel.add(seatselectBtn49);

      
   }
}