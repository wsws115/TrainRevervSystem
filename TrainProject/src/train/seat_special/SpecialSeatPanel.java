package train.seat_special;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

public class SpecialSeatPanel extends JPanel {
	String[] specialleft = { "1A", "1B", "2A", "2B", "3A", "3B", "4A", "4B", "5A", "5B", "6A", "6B", "7A", "7B", "8A",
			"8B", "9A", "9B", "10A", "10B" };
	String[] specialright = { "1C", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C" };
	String mainFont = "HY헤드라인M";
	
	List<String> list = new ArrayList<>();
   
	public SpecialSeatPanel() {

		JScrollPane seatSelectScroll = new JScrollPane();
		JPanel seatSelectMainPanel = new JPanel();
		

		seatSelectScroll.setViewportView(seatSelectMainPanel);
		seatSelectScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		seatSelectScroll.setPreferredSize(new Dimension(700, 400));
		add(seatSelectScroll);

		// 좌석 선택 버튼을 포함하는 패널, 세로 스크롤 있음
		seatSelectMainPanel.setPreferredSize(new Dimension(600, 1100));
		seatSelectMainPanel.setLayout(new BorderLayout());
		seatSelectScroll.getVerticalScrollBar().setUnitIncrement(30);

		
		// 좌측좌석패널(A,B)
		JPanel leftSeatPanel = new JPanel();
		leftSeatPanel.setBackground(Color.white);
		leftSeatPanel.add(getHalfSeatPanel(specialleft), BorderLayout.WEST);

		// 우측좌석패널(C,D)
		JPanel rightSeatPanel = new JPanel();
//		       rightSeatPanel.setLayout(new BorderLayout());
		rightSeatPanel.setBackground(Color.white);
		rightSeatPanel.add(getHalfSeatPanel(specialright), BorderLayout.EAST);
		
		
		
		getseatPanel(seatSelectMainPanel,leftSeatPanel,rightSeatPanel);
	}
   
   
   /** 메인패널(좌석선택패널이 부착될 패널)과 좌우측 패널을 전달받아
    * 모든 패널이 부착된 메인패널을 리턴하는 메서드*/
	JPanel getseatPanel(JPanel seatMainPanel, JPanel left, JPanel right) {
		

//      seatMainPanel.setLayout(new GridLayout(1, 2,150,0));
		seatMainPanel.setBackground(Color.white);
		seatMainPanel.add(left, BorderLayout.WEST);
		seatMainPanel.add(right, BorderLayout.EAST);

		return seatMainPanel;
	}
   
   
	/** 좌석의 개수를 전달하면 해당 개수의 버튼이 부착된 패널을 반환해주는 메서드 (좌/ 우 패널 */
	JPanel getHalfSeatPanel(String[] positions) {
		JPanel seatPanel = new JPanel();
		JToggleButton[] seatBtns = new JToggleButton[positions.length];
		for (int i = 0; i < seatBtns.length; i++) {
			seatBtns[i] = new JToggleButton();
			
			// 버튼의 속성
			seatBtns[i].setText(positions[i]);
			seatBtns[i].setPreferredSize(new Dimension(120, 100)); // 버튼 텍스트 설정
			seatBtns[i].setForeground(Color.WHITE);
			seatBtns[i].setBorderPainted(false);
			seatBtns[i].setFocusPainted(false);
			seatBtns[i].setBackground(new Color(0, 128, 192));
			seatBtns[i].setFont(new Font("HY헤드라인M", Font.BOLD, 20));
			seatPanel.add(seatBtns[i]);
		}
		
		seatPanel.setLayout(new GridLayout(10, 2, 10, 10));
		return seatPanel;
	}
   

   
   
}