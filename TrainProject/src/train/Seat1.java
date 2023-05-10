package train;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import train.buttons.MinusBtn;
import train.buttons.PlusBtn;
import train.buttons.ResetBtn;
import train.buttons.SeatBtn;
import train.buttons.SelectBtn;
import train.labels.SeatinfoLabel;
import train.labels.TrainInfoLabel;
import train.labels.TypeLabel;

public class SeatSelectPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SeatSelectPanel() {
		
//		public String getSeatInfo() {
//			
//		}

		setBackground(Color.WHITE);
		setBounds(412, 0, 1500, 1010);
		setLayout(null);
		
		
		//화면 좌측에서 새로고침, 인원선택을 포함하는 패널
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.WHITE);
		leftPanel.setBounds(100,100,500,850);
		leftPanel.setLayout(null);
		add(leftPanel);
		
		
		// 타입별 라벨 (어른, 어린이, 유아, 경로, 중증장애인, 경증장애인) 
		JLabel typeLabel1 = new TypeLabel("어른(만 13세 이상)");
		typeLabel1.setBounds(0, 157, 198, 29);
		leftPanel.add(typeLabel1);
		
		JLabel typeLabel2 = new TypeLabel("어린이(만 6세 ~ 12세)");
		typeLabel2.setBounds(0, 221, 255, 29);
		leftPanel.add(typeLabel2);
		
		JLabel typeLabel3 = new TypeLabel("유아(만 6세 미만)");
		typeLabel3.setBounds(0, 277, 198, 29);
		leftPanel.add(typeLabel3);
		
		JLabel typeLabel4 = new TypeLabel("경로(만 65세 미만)");
		typeLabel4.setBounds(0, 337, 198, 29);
		leftPanel.add(typeLabel4);
		
		JLabel typeLabel5 = new TypeLabel("중증 장애인");
		typeLabel5.setBounds(0, 397, 139, 29);
		leftPanel.add(typeLabel5);
		
		JLabel typeLabel6 = new TypeLabel("경증 장애인");
		typeLabel6.setBounds(0, 456, 120, 30);
		leftPanel.add(typeLabel6);
		
		
		//타입별 인원 카운트
		JTextField countTextField1 = new CountTextField(270);
		countTextField1.setLocation(390, 148);
		leftPanel.add(countTextField1);
		
		JTextField countTextField2 = new CountTextField(330);
		countTextField2.setLocation(390, 208);
		leftPanel.add(countTextField2);
		
		JTextField countTextField3 = new CountTextField(390);
		countTextField3.setLocation(390, 268);
		leftPanel.add(countTextField3);
		
		JTextField countTextField4 = new CountTextField(450);
		countTextField4.setLocation(390, 328);
		leftPanel.add(countTextField4);
		
		JTextField countTextField5 = new CountTextField(510);
		countTextField5.setLocation(390, 388);
		leftPanel.add(countTextField5);
		
		JTextField countTextField6 = new CountTextField(570);
		countTextField6.setLocation(390, 448);
		leftPanel.add(countTextField6);
		
		
		// 타입 별 인원 선택 버튼(plus, minus), 새로고침 버튼
		JButton resetBtn = new ResetBtn(countTextField1,countTextField2,countTextField3,
				countTextField4,countTextField5,countTextField6);
		resetBtn.setSize(170, 68);
		resetBtn.setLocation(330, 0);
		leftPanel.add(resetBtn);
		
		JButton plusBtn1 = new PlusBtn("+",countTextField1);
		plusBtn1.setBounds(450, 148, 50, 50);
		leftPanel.add(plusBtn1);
		
		JButton plusBtn2 = new PlusBtn("+",countTextField2);
		plusBtn2.setBounds(450, 208, 50, 50);
		leftPanel.add(plusBtn2);
		
		JButton plusBtn3 = new PlusBtn("+",countTextField3);
		plusBtn3.setBounds(450, 268, 50, 50);
		leftPanel.add(plusBtn3);
		
		JButton plusBtn4 = new PlusBtn("+",countTextField4);
		plusBtn4.setBounds(450, 329, 50, 50);
		leftPanel.add(plusBtn4);
		
		JButton plusBtn5 = new PlusBtn("+",countTextField5);

		plusBtn5.setBounds(450, 389, 50, 50);
		leftPanel.add(plusBtn5);
		
		JButton plusBtn6 = new PlusBtn("+",countTextField6);
		plusBtn6.setBounds(450, 448, 50, 50);
		leftPanel.add(plusBtn6);
		
		JButton minusBtn1 = new MinusBtn("-",countTextField1);
		minusBtn1.setBounds(330, 148, 50, 50);
		leftPanel.add(minusBtn1);
		
		JButton minusBtn2 = new MinusBtn("-",countTextField2);
		minusBtn2.setBounds(330, 208, 50, 50);
		leftPanel.add(minusBtn2);
		
		JButton minusBtn3 = new MinusBtn("-",countTextField3);
		minusBtn3.setBounds(330, 268, 50, 50);
		leftPanel.add(minusBtn3);
		
		JButton minusBtn4 = new MinusBtn("-",countTextField4);
		minusBtn4.setBounds(330, 328, 50, 50);
		leftPanel.add(minusBtn4);
		
		JButton minusBtn5 = new MinusBtn("-",countTextField5);
		minusBtn5.setBounds(330, 388, 50, 50);
		leftPanel.add(minusBtn5);
		
		JButton minusBtn6 = new MinusBtn("-",countTextField6);

		minusBtn6.setBounds(330, 448, 50, 50);
		leftPanel.add(minusBtn6);
		
		JPanel checkPanel = new JPanel();
		checkPanel.setBackground(SystemColor.control);
		checkPanel.setBounds(0, 566, 500, 182);
		leftPanel.add(checkPanel);
		checkPanel.setLayout(null);
		
		
		
		JLabel checkLabel = new JLabel("<html> 좌석 선택<br>명 좌석 선택 / 총 x 명 <html>");
		checkLabel.setHorizontalAlignment(SwingConstants.CENTER);
		checkLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		checkLabel.setBounds(0, 0, 500, 182);
		checkPanel.add(checkLabel);
		
		JLabel lblNewLabel = new JLabel("인원 선택");
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 0, 237, 68);
		leftPanel.add(lblNewLabel);

		//화면 우측에서 호차정보 콤보박스, 기차정보 라벨, 호차이동 버튼, 좌석 선택 버튼을 포함하는 패널
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.WHITE);
		rightPanel.setBounds(656,100,800,850);
		add(rightPanel);
		rightPanel.setLayout(null);
		
		//해당 열차의 전 호차의 정보를 볼 수 있는 콤보박스
		JComboBox <String> combo = new TrainNumcomboBox();
		rightPanel.add(combo);
		
		//현재 기차의 정보를 알려주는 라벨
		JLabel trainInfoLabel = new TrainInfoLabel("KTX-산천 419 (일반실) ");
		rightPanel.add(trainInfoLabel);
		
		// 호차번호 -1 (앞칸으로 이동)
		JButton previousBtn = new JButton("14호차");
		rightPanel.add(previousBtn);
		
		// 호차번호 + 1 (뒷칸으로 이동)
		JButton nextBtn = new JButton("16호차");
		rightPanel.add(nextBtn);
		
		JLabel seatInfoLabel = new JLabel("잔여 25석 / 전체 28석");
		seatInfoLabel.setBounds(181, 94, 437, 46);
		rightPanel.add(seatInfoLabel);
		seatInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		seatInfoLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		
		JScrollPane seatScrollPane = new JScrollPane();
		seatScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		seatScrollPane.setPreferredSize(new Dimension(700,600)); 
		rightPanel.add(seatScrollPane);
		seatScrollPane.setBounds(50,150,700,600);
		
		// 좌석 선택 버튼을 포함하는 패널, 세로 스크롤 있음
		JPanel seatPanel = new JPanel();
		seatPanel.setBackground(Color.WHITE);
		seatPanel.setPreferredSize(new Dimension(700,2000));
		seatPanel.setBounds(50,200,700,600);
		seatScrollPane.setViewportView(seatPanel);
		seatScrollPane.getVerticalScrollBar().setUnitIncrement(30); // 스크롤을 움직일 때 움직여지는 범위
		seatPanel.setLayout(null);
		
		//좌석 선택 버튼
		//이미 예약된 좌석일 경우 enable로 바꿈
		JToggleButton seatselectBtn1 = new SeatBtn();
		seatselectBtn1.setEnabled(false);
		seatselectBtn1.setBounds(10, 10, 150, 150);
		seatPanel.add(seatselectBtn1);
		
		JLabel seatinfoLabel1 = new SeatinfoLabel("     1A");
//		seatinfoLabel1.setBounds(0,0,seatselectBtn1.getWidth(), seatselectBtn1.getHeight());
		seatselectBtn1.add(seatinfoLabel1);
		
		
		JToggleButton seatselectBtn2 = new SeatBtn();
		seatselectBtn2.setBounds(170, 10, 150, 150);
		seatPanel.add(seatselectBtn2);
		JLabel seatinfoLabel2 = new SeatinfoLabel("     1B");
		seatselectBtn2.add(seatinfoLabel2);
		
		JToggleButton seatselectBtn3 = new SeatBtn();
		seatselectBtn3.setBounds(370, 10, 150, 150);
		seatPanel.add(seatselectBtn3);
		JLabel seatinfoLabel3 = new SeatinfoLabel("     1C");
		seatselectBtn3.add(seatinfoLabel3);
		
		JToggleButton seatselectBtn4 = new SeatBtn();
		seatselectBtn4.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		seatselectBtn4.setBounds(530, 10, 150, 150);
		seatPanel.add(seatselectBtn4);
		JLabel seatinfoLabel4 = new SeatinfoLabel("     1D");
		seatselectBtn4.add(seatinfoLabel4);
		
		JToggleButton seatselectBtn5 = new SeatBtn();
		seatselectBtn5.setBounds(10, 170, 150, 150);
		seatPanel.add(seatselectBtn5);
		JLabel seatinfoLabel5 = new SeatinfoLabel("     2A");
		seatselectBtn5.add(seatinfoLabel5);
		
		JToggleButton seatselectBtn6 = new SeatBtn();
		seatselectBtn6.setBounds(170, 170, 150, 150);
		seatPanel.add(seatselectBtn6);
		JLabel seatinfoLabel6 = new SeatinfoLabel("     2B");
		seatselectBtn6.add(seatinfoLabel6);
		
		JToggleButton seatselectBtn7 = new SeatBtn();
		seatselectBtn7.setBounds(370, 170, 150, 150);
		seatPanel.add(seatselectBtn7);
		JLabel seatinfoLabel7 = new SeatinfoLabel("     2C");
		seatselectBtn7.add(seatinfoLabel7);
		
		JToggleButton seatselectBtn8 = new SeatBtn();
		seatselectBtn8.setBounds(530, 170, 150, 150);
		seatPanel.add(seatselectBtn8);
		JLabel seatinfoLabel8 = new SeatinfoLabel("     2D");
		seatselectBtn8.add(seatinfoLabel8);
		
		JToggleButton seatselectBtn9 = new SeatBtn();
		seatselectBtn9.setEnabled(false);
		seatselectBtn9.setBounds(10, 330, 150, 150);
		seatPanel.add(seatselectBtn9);
		JLabel seatinfoLabel9 = new SeatinfoLabel("     3A");
		seatselectBtn9.add(seatinfoLabel9);
		
		JToggleButton seatselectBtn10 = new SeatBtn();
		seatselectBtn10.setBounds(170, 330, 150, 150);
		seatPanel.add(seatselectBtn10);
		JLabel seatinfoLabel10 = new SeatinfoLabel("     3B");
		seatselectBtn10.add(seatinfoLabel10);
		
		JToggleButton seatselectBtn11 = new SeatBtn();
		seatselectBtn11.setBounds(370, 330, 150, 150);
		seatPanel.add(seatselectBtn11);
		JLabel seatinfoLabel11 = new SeatinfoLabel("     3C");
		seatselectBtn11.add(seatinfoLabel11);
		
		JToggleButton seatselectBtn12 = new SeatBtn();
		seatselectBtn12.setBounds(530, 330, 150, 150);
		seatPanel.add(seatselectBtn12);
		JLabel seatinfoLabel12 = new SeatinfoLabel("     3D");
		seatselectBtn12.add(seatinfoLabel12);
		
		JToggleButton seatselectBtn13 = new SeatBtn();
		seatselectBtn13.setBounds(10, 490, 150, 150);
		seatPanel.add(seatselectBtn13);
		JLabel seatinfoLabel13 = new SeatinfoLabel("     4A");
		seatselectBtn13.add(seatinfoLabel13);
		
		JToggleButton seatselectBtn14 = new SeatBtn();
		seatselectBtn14.setBounds(170, 490, 150, 150);
		seatPanel.add(seatselectBtn14);
		JLabel seatinfoLabel14 = new SeatinfoLabel("     4B");
		seatselectBtn14.add(seatinfoLabel14);
		
		JToggleButton seatselectBtn15 = new SeatBtn();
		seatselectBtn15.setBounds(370, 490, 150, 150);
		seatPanel.add(seatselectBtn15);
		JLabel seatinfoLabel15 = new SeatinfoLabel("     4C");
		seatselectBtn15.add(seatinfoLabel15);
		
		JToggleButton seatselectBtn18 = new SeatBtn();
		seatselectBtn18.setBounds(530, 490, 150, 150);
		seatPanel.add(seatselectBtn18);
		JLabel seatinfoLabel18 = new SeatinfoLabel("     4D");
		seatselectBtn18.add(seatinfoLabel18);
		
		JToggleButton seatselectBtn19 = new SeatBtn();
		seatselectBtn19.setBounds(10, 650, 150, 150);
		seatPanel.add(seatselectBtn19);
		JLabel seatinfoLabel19 = new SeatinfoLabel("     5A");
		seatselectBtn19.add(seatinfoLabel19);
		
		JToggleButton seatselectBtn20 = new SeatBtn();
		seatselectBtn20.setBounds(170, 650, 150, 150);
		seatPanel.add(seatselectBtn20);
		JLabel seatinfoLabel20 = new SeatinfoLabel("     5B");
		seatselectBtn20.add(seatinfoLabel20);
		
		JToggleButton seatselectBtn21 = new SeatBtn();
		seatselectBtn21.setBounds(370, 650, 150, 150);
		seatPanel.add(seatselectBtn21);
		JLabel seatinfoLabel21 = new SeatinfoLabel("     5C");
		seatselectBtn21.add(seatinfoLabel21);
		
		JToggleButton seatselectBtn22 = new SeatBtn();
		seatselectBtn22.setBounds(530, 650, 150, 150);
		seatPanel.add(seatselectBtn22);
		JLabel seatinfoLabel22 = new SeatinfoLabel("     5D");
		seatselectBtn22.add(seatinfoLabel22);
		
		JToggleButton seatselectBtn23 = new SeatBtn();
		seatselectBtn23.setBounds(10, 810, 150, 150);
		seatPanel.add(seatselectBtn23);
		JLabel seatinfoLabel23 = new SeatinfoLabel("     6A");
		seatselectBtn23.add(seatinfoLabel23);
		
		JToggleButton seatselectBtn24 = new SeatBtn();
		seatselectBtn24.setBounds(170, 810, 150, 150);
		seatPanel.add(seatselectBtn24);
		JLabel seatinfoLabel24 = new SeatinfoLabel("     6B");
		seatselectBtn24.add(seatinfoLabel24);
		
		JToggleButton seatselectBtn25 = new SeatBtn();
		seatselectBtn25.setBounds(370, 810, 150, 150);
		seatPanel.add(seatselectBtn25);
		JLabel seatinfoLabel25 = new SeatinfoLabel("     6C");
		seatselectBtn25.add(seatinfoLabel25);
		
		JToggleButton seatselectBtn26 = new SeatBtn();
		seatselectBtn26.setBounds(530, 810, 150, 150);
		seatPanel.add(seatselectBtn26);
		JLabel seatinfoLabel26 = new SeatinfoLabel("     6D");
		seatselectBtn26.add(seatinfoLabel26);
		
		
		JToggleButton seatselectBtn27 = new SeatBtn();
		seatselectBtn27.setBounds(10, 970, 150, 150);
		seatPanel.add(seatselectBtn27);
		JLabel seatinfoLabel27 = new SeatinfoLabel("     7A");
		seatselectBtn27.add(seatinfoLabel27);
		
		JToggleButton seatselectBtn28 = new SeatBtn();
		seatselectBtn28.setBounds(170, 970, 150, 150);
		seatPanel.add(seatselectBtn28);
		JLabel seatinfoLabel28 = new SeatinfoLabel("     7B");
		seatselectBtn28.add(seatinfoLabel28);
		
		JToggleButton seatselectBtn29 = new SeatBtn();
		seatselectBtn29.setBounds(370, 970, 150, 150);
		seatPanel.add(seatselectBtn29);
		JLabel seatinfoLabel29 = new SeatinfoLabel("     7C");
		seatselectBtn29.add(seatinfoLabel29);
		
		JToggleButton seatselectBtn30 = new SeatBtn();
		seatselectBtn30.setBounds(530, 970, 150, 150);
		seatPanel.add(seatselectBtn30);
		JLabel seatinfoLabel30 = new SeatinfoLabel("     7D");
		seatselectBtn30.add(seatinfoLabel30);
		
		JToggleButton seatselectBtn31 = new SeatBtn();
		seatselectBtn31.setBounds(10, 1130, 150, 150);
		seatPanel.add(seatselectBtn31);
		JLabel seatinfoLabel31 = new SeatinfoLabel("     8A");
		seatselectBtn31.add(seatinfoLabel31);
		
		JToggleButton seatselectBtn32 = new SeatBtn();
		seatselectBtn32.setBounds(170, 1130, 150, 150);
		seatPanel.add(seatselectBtn32);
		JLabel seatinfoLabel32 = new SeatinfoLabel("     8B");
		seatselectBtn32.add(seatinfoLabel32);
		
		JToggleButton seatselectBtn33 = new SeatBtn();
		seatselectBtn33.setBounds(370, 1130, 150, 150);
		seatPanel.add(seatselectBtn33);
		JLabel seatinfoLabel33 = new SeatinfoLabel("     8C");
		seatselectBtn33.add(seatinfoLabel33);
		
		JToggleButton seatselectBtn34 = new SeatBtn();
		seatselectBtn34.setBounds(530, 1130, 150, 150);
		seatPanel.add(seatselectBtn34);
		JLabel seatinfoLabel34 = new SeatinfoLabel("     8D");
		seatselectBtn34.add(seatinfoLabel34);
		
		JToggleButton seatselectBtn35 = new SeatBtn();
		seatselectBtn35.setBounds(10, 1290, 150, 150);
		seatPanel.add(seatselectBtn35);
		JLabel seatinfoLabel35 = new SeatinfoLabel("     9A");
		seatselectBtn35.add(seatinfoLabel35);
		
		JToggleButton seatselectBtn36 = new SeatBtn();
		seatselectBtn36.setBounds(170, 1290, 150, 150);
		seatPanel.add(seatselectBtn36);
		JLabel seatinfoLabel36 = new SeatinfoLabel("     9B");
		seatselectBtn36.add(seatinfoLabel36);
		
		JToggleButton seatselectBtn37 = new SeatBtn();
		seatselectBtn37.setBounds(370, 1290, 150, 150);
		seatPanel.add(seatselectBtn37);
		JLabel seatinfoLabel37 = new SeatinfoLabel("     9C");
		seatselectBtn37.add(seatinfoLabel37);
		
		JToggleButton seatselectBtn38 = new SeatBtn();
		seatselectBtn38.setBounds(530, 1290, 150, 150);
		seatPanel.add(seatselectBtn38);
		JLabel seatinfoLabel38 = new SeatinfoLabel("     9D");
		seatselectBtn38.add(seatinfoLabel38);
		
		JToggleButton seatselectBtn39 = new SeatBtn();
		seatselectBtn39.setBounds(10, 1450, 150, 150);
		seatPanel.add(seatselectBtn39);
		JLabel seatinfoLabel39 = new SeatinfoLabel("    10A");
		seatselectBtn39.add(seatinfoLabel39);
		
		JToggleButton seatselectBtn40 = new SeatBtn();
		seatselectBtn40.setBounds(170, 1450, 150, 150);
		seatPanel.add(seatselectBtn40);
		JLabel seatinfoLabel40 = new SeatinfoLabel("    10B");
		seatselectBtn40.add(seatinfoLabel40);
		
		JToggleButton seatselectBtn41 = new SeatBtn();
		seatselectBtn41.setBounds(370, 1450, 150, 150);
		seatPanel.add(seatselectBtn41);
		JLabel seatinfoLabel41 = new SeatinfoLabel("    10C");
		seatselectBtn41.add(seatinfoLabel41);
		
		JToggleButton seatselectBtn42 = new SeatBtn();
		seatselectBtn42.setBounds(530, 1450, 150, 150);
		seatPanel.add(seatselectBtn42);
		JLabel seatinfoLabel42 = new SeatinfoLabel("    10D");
		seatselectBtn42.add(seatinfoLabel42);
		
		JToggleButton seatselectBtn43 = new SeatBtn();
		seatselectBtn43.setBounds(10, 1610, 150, 150);
		seatPanel.add(seatselectBtn43);
		JLabel seatinfoLabel43 = new SeatinfoLabel("    11A");
		seatselectBtn43.add(seatinfoLabel43);
		
		JToggleButton seatselectBtn44 = new SeatBtn();
		seatselectBtn44.setBounds(170, 1610, 150, 150);
		seatPanel.add(seatselectBtn44);
		JLabel seatinfoLabel44 = new SeatinfoLabel("    11B");
		seatselectBtn44.add(seatinfoLabel44);
		
		JToggleButton seatselectBtn45 = new SeatBtn();
		seatselectBtn45.setBounds(370, 1610, 150, 150);
		seatPanel.add(seatselectBtn45);
		JLabel seatinfoLabel45 = new SeatinfoLabel("    11C");
		seatselectBtn45.add(seatinfoLabel45);
		
		JToggleButton seatselectBtn46 = new SeatBtn();
		seatselectBtn46.setBounds(530, 1610, 150, 150);
		seatPanel.add(seatselectBtn46);
		JLabel seatinfoLabel46 = new SeatinfoLabel("    11D");
		seatselectBtn46.add(seatinfoLabel46);
		
		JToggleButton seatselectBtn47 = new SeatBtn();
		seatselectBtn47.setBounds(10, 1770, 150, 150);
		seatPanel.add(seatselectBtn47);
		JLabel seatinfoLabel47 = new SeatinfoLabel("    12A");
		seatselectBtn47.add(seatinfoLabel47);
		
		JToggleButton seatselectBtn48 = new SeatBtn();
		seatselectBtn48.setBounds(170, 1770, 150, 150);
		seatPanel.add(seatselectBtn48);
		JLabel seatinfoLabel48 = new SeatinfoLabel("    12B");
		seatselectBtn48.add(seatinfoLabel48);
		
		JToggleButton seatselectBtn49 = new SeatBtn();
		seatselectBtn49.setBounds(370, 1770, 150, 150);
		seatPanel.add(seatselectBtn49);
		JLabel seatinfoLabel49 = new SeatinfoLabel("    12C");
		seatselectBtn49.add(seatinfoLabel49);
		
		JToggleButton seatselectBtn50 = new SeatBtn();
		seatselectBtn50.setEnabled(false);
		seatselectBtn50.setBounds(530, 1770, 150, 150);
		seatPanel.add(seatselectBtn50);
		JLabel seatinfoLabel50 = new SeatinfoLabel("    12D");
		seatselectBtn50.add(seatinfoLabel50);
		
		//선택 완료 버튼
		JButton selectBtn = new SelectBtn();
		rightPanel.add(selectBtn);

	}
}
