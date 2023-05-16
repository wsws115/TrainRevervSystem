package train.seat_standard;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class StandardSeatSelect extends JDialog {

	private JFrame frame;

	 public static JLabel selectedSeatInfoLabel = new JLabel();
	   public static void setLable(String str) {
	      selectedSeatInfoLabel.setText(str);
	   }
	 private String mainFont = "HY헤드라인M"; 
	   
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StandardSeatSelect window = new StandardSeatSelect();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StandardSeatSelect() {
	      getContentPane().setBackground(Color.WHITE);
//	      getContentPane().setLayout(new BorderLayout(500,500));
	      
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
		  
		  

	      //일반 예매를 눌렀을 때 > [4~10호차]
	      //4호차는 일반실 + 휠체어석
	      //5 ~ 10호차는 일반실 + 일반좌석
	      JPanel standardwheel4 = new StandardWheelSeatPanel();
	      JPanel standard5 = new StandardSeatPanel();
	      JPanel standard6 = new StandardSeatPanel();
	      JPanel standard7 = new StandardSeatPanel();
	      JPanel standard8 = new StandardSeatPanel();
	      JPanel standard9 = new StandardSeatPanel();
	      JPanel standard10 = new StandardSeatPanel();
	      

	      seatSelectPanel.add("standard4",standardwheel4);
	      seatSelectPanel.add("standard5",standard5);
	      seatSelectPanel.add("standard6",standard6);
	      seatSelectPanel.add("standard7",standard7);
	      seatSelectPanel.add("standard8",standard8);
	      seatSelectPanel.add("standard9",standard9);
	      seatSelectPanel.add("standard10",standard10);
	      
	      
	      
	      
	      
	      // [화면 하단에서 좌석선택확인 라벨과 선택완료 버튼을 포함하는 패널]
	      JPanel lowPanel = new JPanel();
	      lowPanel.setBackground(Color.WHITE);
	      totalMainPanel.add(lowPanel, BorderLayout.SOUTH);

	      selectedSeatInfoLabel.setFont(new Font(mainFont, Font.PLAIN, 20));
	      lowPanel.add(selectedSeatInfoLabel);
	      
	      JLabel selectedSeatInfoLabel = new JLabel("");
	      selectedSeatInfoLabel.setFont(new Font(mainFont, Font.PLAIN, 20));
	      lowPanel.add(selectedSeatInfoLabel);
	      
	      JButton selectCompleteButton = new JButton("다음");
	      selectCompleteButton.setForeground(Color.WHITE);
	      
	      selectCompleteButton.setBackground(new Color(0, 128, 192));
	      selectCompleteButton.setBorderPainted(false);
	      selectCompleteButton.setFocusPainted(false);
	      selectCompleteButton.setFont(new Font(mainFont, Font.BOLD, 20));
	      lowPanel.add(selectCompleteButton);
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      //[화면 상단에서 호차선택콤보박스, 앞/뒤호차 이동 버튼, 현재 기차정보라벨을 포함하는 패널]
	      JPanel topPanel = new JPanel();
	      topPanel.setBackground(Color.WHITE);
	      totalMainPanel.add(topPanel, BorderLayout.NORTH);
	      topPanel.setLayout(new GridLayout(0, 1, 0, 0));

	      
	      JSplitPane splitPane = new JSplitPane(); //상단패널을 상1- 콤보박스, 상2 - 라벨및버튼으로 나눔
	      splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
	      topPanel.add(splitPane);
	      
	      JComboBox trainInfoComboBox = new JComboBox();
	      trainInfoComboBox.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	              String getSelectedCar = (String)trainInfoComboBox.getSelectedItem();
	              if(getSelectedCar.contains("4호차")) {
	            	  card.show(seatSelectPanel,"standard4");
	              }else if(getSelectedCar.contains("5호차")) {
	            	  card.show(seatSelectPanel,"standard5");
	              }else if(getSelectedCar.contains("6호차")) {
	            	  card.show(seatSelectPanel,"standard6");
	              }else if(getSelectedCar.contains("7호차")) {
	            	  card.show(seatSelectPanel,"standard7");
	              }else if(getSelectedCar.contains("8호차")) {
	            	  card.show(seatSelectPanel,"standard8");
	              }else if(getSelectedCar.contains("9호차")) {
	            	  card.show(seatSelectPanel,"standard9");
	              }else if(getSelectedCar.contains("10호차")) {
	            	  card.show(seatSelectPanel,"standard10");
	              }
	          }
	      });
	      trainInfoComboBox.setPreferredSize(new Dimension(900, 50));
	      trainInfoComboBox.setBackground(Color.WHITE);
	      trainInfoComboBox.setFont(new Font(mainFont, Font.PLAIN, 20));
	      trainInfoComboBox.setMaximumRowCount(20);
	      trainInfoComboBox.setModel(getStandardCarInfo()); 
	      
	      splitPane.setLeftComponent(trainInfoComboBox);
	      
	      JPanel top2panel = new JPanel();
	      splitPane.setRightComponent(top2panel);
	      top2panel.setLayout(new BorderLayout(0, 0));

	      JButton previousCarButton = new JButton("<");
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
	      previousCarButton.setForeground(Color.WHITE);
	      previousCarButton.setBackground(new Color(0, 128, 192));
	      previousCarButton.setBorderPainted(false);
	      previousCarButton.setFocusPainted(false);
	      previousCarButton.setFont(new Font(mainFont, Font.BOLD, 20));
	      top2panel.add(previousCarButton, BorderLayout.WEST);
	      
	      
	      //앞에서 기차정보를 받아와서 넣어야함(잔여좌석도)
	      JLabel TrainInfoLabel = new JLabel("<html>KTX 316 (일반실)<br> / 잔여 3석 총 30석<html>");
	      TrainInfoLabel.setBackground(new Color(255, 102, 153));
	      TrainInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
	      TrainInfoLabel.setFont(new Font(mainFont, Font.PLAIN, 30));
	      top2panel.add(TrainInfoLabel);
	      
	      JButton nextCarButton = new JButton(">");
	      nextCarButton.addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             
	             int index = trainInfoComboBox.getSelectedIndex();
	             if (index == 6) {
	                System.out.println("카드 레이아웃의 마지막 번호임");
	             } else {
	                card.next(seatSelectPanel);
	                trainInfoComboBox.setSelectedIndex(index + 1);
	             }
	          }
	       });
	      nextCarButton.setForeground(Color.WHITE);
	      nextCarButton.setBackground(new Color(0, 128, 192));
	      nextCarButton.setBorderPainted(false);
	      nextCarButton.setFocusPainted(false);
//	      nextCarButton.setHorizontalAlignment(SwingConstants.RIGHT);
	      nextCarButton.setFont(new Font(mainFont, Font.BOLD, 20));
	      top2panel.add(nextCarButton, BorderLayout.EAST);
	      
	      
	      
	      setTitle("좌석 선택");
	      setSize(1000,650);
	      
	      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	      setVisible(true);
	      setResizable(false);
	      
	}

	 /**일반예매를 눌렀을 떄 콤보박스에 전달해줘야하는 모델을 리턴하는 메서드
	    *  trainType은 기차의 종류 trainTypeLen은 객차타입별 객차의 개수*/
	   DefaultComboBoxModel getStandardCarInfo() {
	      int standard = 7;
	      String[] trainInfo = new String[standard];

	      for (int i = 0; i <= trainInfo.length; i++) {
	         if (i == 0) { // 일반실 + 휠체어석 4호차
	            trainInfo[i] = i + 4 + "호차   (휠체어석) / 일반실";
	         } else if (i >= 1 && i <= 6) { // 일반실 +일반좌석 5~ 10호차
	            trainInfo[i] = i + 4+ "호차 / 일반실";
	         }
	      }

	      DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(trainInfo);
	      return model;
	   }
}