package train.seat_standard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

import train.seat_special.SpecialSeatSelect;

public class StandardWheelSeatPanel extends JPanel{
	private String[] standardwheelleft = { "1A", "1B", "2A", "2B", "3A", "3B", "4A",
			"4B", "5A", "5B", "6A", "6B", "7A", "7B", "8A", "8B", "9A", "9B", "10A","10B" };
	private String[] standardwheelright = { "1C", "1D", "2C", "2D", "3C", "3D", "4C",
			"4D", "5C", "5D", "6C", "6D", "7C", "7D", "8C", "8D", "9C", "9D", "10C",
			"10D" };
	private String mainFont = "HY헤드라인M";
	private String html = "<html>";
	private String br = "<br>휠체어석<html>";
	
	List<String> list = new ArrayList<>();
	
	
	
	public StandardWheelSeatPanel() {
		// 일반실의 좌석 선택 패널은 좌석이 1열4석 총 10열 40석으로 구성되어있다
		// [좌석의 메인 패널] - [좌측좌석패널(A,B)]
		// - [우측좌석패널(C,D)]
		// 좌/우 좌석패널 사이에는 공간이 있어 통로를 표현한다
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
	       leftSeatPanel.add(getHalfSeatPanel(standardwheelleft), BorderLayout.WEST);
	       
	       // 우측좌석패널(C,D)
	       JPanel rightSeatPanel = new JPanel();
//	       rightSeatPanel.setLayout(new BorderLayout());
	       rightSeatPanel.setBackground(Color.white);
	       rightSeatPanel.add(getHalfSeatPanel(standardwheelright),BorderLayout.EAST);
	       getseatPanel(seatSelectMainPanel,leftSeatPanel,rightSeatPanel);
		
		
//		List<String> selectedBtns = new ArrayList<>();
	}
	

	
		/*버튼을 받아서 패널에 부착해서 돌려줌 ...
		 * 버튼의 택스트를 받아와서 라벨에 전달한다
		 * 토글버튼이 선택되면 값을 보여주고
		 * 토글버튼이 선택해제되면 값을 지운다
		 * 
		 * 
		 * 아니면 positions배열을 활용해도됨 !
		 * >> 안됨 .. 토글버튼의 상태가 변화할때마다 값을 새로 가져와야하기 때문 ,,, 
		 * 
		 * 
		 * 리스트로 받아서 토글버튼이 선택 해제되면 리스트에서 값을 삭제하고 라벨에 출력
		 * 토글버튼의 상태에 따라 이벤트를 달아서
		 * 선택되면 = 텍스트를 라벨에 전달
		 * 선택해제되면 = null 라벨에 전달 
		 * 
		 * */
	
	/** 좌석의 개수를 전달하면 해당 개수의 버튼이 부착된 패널을 반환해주는 메서드 (좌/ 우 패널 */
    JPanel getHalfSeatPanel(String[] positions) {
       
       JPanel seatPanel = new JPanel();
       JToggleButton[] seatBtns = new JToggleButton[positions.length];
       ActionListener action1 = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
             String buttonText = ((JToggleButton) e.getSource()).getText();
             String[] seatarr = buttonText.split("<|>");
             buttonText = seatarr[2];

             if (((JToggleButton) e.getSource()).isSelected()) {
                list.add(buttonText);             
                SpecialSeatSelect.setLable(list.toString());
             } else {
                list.remove(list.indexOf(buttonText));
                SpecialSeatSelect.setLable(list.toString());
             }
          }
       };
       
       ActionListener action2 = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
             String buttonText = ((JToggleButton) e.getSource()).getText();
             
             if (((JToggleButton) e.getSource()).isSelected()) {
                list.add(buttonText);             
                SpecialSeatSelect.setLable(list.toString());
             } else {
                list.remove(list.indexOf(buttonText));
                SpecialSeatSelect.setLable(list.toString());
             }
          }
       };
       
       for (int i = 0; i < seatBtns.length; i++) {
          seatBtns[i] = new JToggleButton();
          
          // 버튼의 속성
          if(positions.length == 10) {
             if(i == 0 || i == 9) {
                seatBtns[i].setText(html+positions[i]+br);
                seatBtns[i].addActionListener(action1);
                
             }else {
                seatBtns[i].setText(positions[i]);
                seatBtns[i].addActionListener(action2);
             }
          }else {
             if(i == 0 || i == 1 || i == 18 || i == 19) {
                seatBtns[i].setText(html+positions[i]+br);
                seatBtns[i].addActionListener(action1);
             }else {
                seatBtns[i].setText(positions[i]);
                seatBtns[i].addActionListener(action2);
             }
             
          }
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
	   
	   
	   /** 메인패널(좌석선택패널이 부착될 패널)과 좌우측 패널을 전달받아
	    * 모든 패널이 부착된 메인패널을 리턴하는 메서드*/
	   JPanel getseatPanel(JPanel seatMainPanel, JPanel left, JPanel right) {
	      
//	      seatMainPanel.setLayout(new GridLayout(1, 2,150,0));
	       seatMainPanel.setBackground(Color.white);
	      seatMainPanel.add(left, BorderLayout.WEST);
	      seatMainPanel.add(right, BorderLayout.EAST);
	      
	      return seatMainPanel;
	   }
}