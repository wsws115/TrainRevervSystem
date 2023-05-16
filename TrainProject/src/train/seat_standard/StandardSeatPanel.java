package train.seat_standard;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

import train.seat_special.SpecialSeatSelect;

public class StandardSeatPanel extends JPanel implements MouseListener{

//   private JFrame frame;

	String[] standardleft = { "1A", "1B", "2A", "2B", "3A", "3B", "4A", "4B", "5A", "5B", "6A", "6B", "7A", "7B", "8A",
			"8B", "9A", "9B", "10A", "10B" };
	String[] standardright = { "1C", "1D", "2C", "2D", "3C", "3D", "4C", "4D", "5C", "5D", "6C", "6D", "7C", "7D", "8C",
			"8D", "9C", "9D", "10C", "10D", };
	String mainFont = "HY헤드라인M";
	JToggleButton[] leftBtns;
	JToggleButton[] rightBtns;
	int people = Integer.parseInt(train.TrainReserv_Main.selectPeopleLabel.getText());
	List<String> list = new ArrayList<>();
	public StandardSeatPanel() {
       //일반실의 좌석 선택 패널은 좌석이 1열4석 총 10열 40석으로 구성되어있다
       //[좌석의 메인 패널] - [좌측좌석패널(A,B)]
       //            - [우측좌석패널(C,D)]
       //좌/우 좌석패널 사이에는 공간이 있어 통로를 표현한다
       JScrollPane seatSelectScroll = new JScrollPane();
       JPanel seatSelectMainPanel = new JPanel();

       seatSelectScroll.setViewportView(seatSelectMainPanel);
       seatSelectScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
       seatSelectScroll.setPreferredSize(new Dimension(700,400));
       add(seatSelectScroll);
       
       // 좌석 선택 버튼을 포함하는 패널, 세로 스크롤 있음
       seatSelectMainPanel.setPreferredSize(new Dimension(600, 1100));
       seatSelectMainPanel.setLayout(new BorderLayout());
       seatSelectScroll.getVerticalScrollBar().setUnitIncrement(30);
      
       getseatPanel(seatSelectMainPanel);
       

	}

	   /**SeatBtn의 상태가 selected일 때 선택한 SeatBtn의 정보를 String 타입으로 반환하는 메서드*/
		String getSeatInfo(JToggleButton seat) {
			if(seat.isSelected()) {
				// 선택되어있는 상태
				
				return seat.getText();
			}
			return "";
		}
		
	   
	   
	   
	   /** 좌석의 개수를 전달하면 해당 개수의 버튼이 부착된 패널을 반환해주는 메서드 (좌/ 우 패널 */
	   JPanel getHalfSeatPanel(boolean chk) {
	      
		   JPanel seatPanel = new JPanel();
		   String[] positions;
		   if (chk) {
			  positions = standardleft;
			  leftBtns = new JToggleButton[positions.length];
			  
		      ActionListener action = new ActionListener() {
		    	    public void actionPerformed(ActionEvent e) {
		    	        String buttonText = ((JToggleButton) e.getSource()).getText();
		    	        System.out.println(buttonText);
		    	    }
		    	};
		      for(int i = 0; i < leftBtns.length; i++) {
		    	  leftBtns[i] = new JToggleButton();
		         
		         //버튼의 속성
		    	  leftBtns[i].setText(positions[i]);
		    	  leftBtns[i].setPreferredSize(new Dimension(120,100)); // 버튼 텍스트 설정
		    	  leftBtns[i].setBorderPainted(false);
		    	  leftBtns[i].setFocusPainted(false);
		    	  leftBtns[i].addMouseListener(this);
		    	  leftBtns[i].setForeground(Color.WHITE);
		          leftBtns[i].setBackground(new Color(0, 128, 192) );
		          leftBtns[i].setFont(new Font(mainFont, Font.BOLD, 20));
		          leftBtns[i].addActionListener(action);
		          seatPanel.add(leftBtns[i]);
		 
		      }
		   }else {
			   positions = standardright;
			   rightBtns = new JToggleButton[positions.length];
			      ActionListener action = new ActionListener() {
			    	    public void actionPerformed(ActionEvent e) {
			    	        String buttonText = ((JToggleButton) e.getSource()).getText();
			    	        System.out.println(buttonText);
			    	    }
			    	};
			      for(int i = 0; i < rightBtns.length; i++) {
			    	  rightBtns[i] = new JToggleButton();
			         
			         //버튼의 속성
			    	  rightBtns[i].setText(positions[i]);
			    	  rightBtns[i].setPreferredSize(new Dimension(120,100)); // 버튼 텍스트 설정
			    	  rightBtns[i].setBorderPainted(false);
			    	  rightBtns[i].setFocusPainted(false);
			    	  rightBtns[i].addMouseListener(this);
			          rightBtns[i].setForeground(Color.WHITE);
			          rightBtns[i].setBackground(new Color(0, 128, 192) );
			          rightBtns[i].setFont(new Font(mainFont, Font.BOLD, 20));
			          rightBtns[i].addActionListener(action);
			          seatPanel.add(rightBtns[i]);
			      }
		   }
	      
	      seatPanel.setLayout(new GridLayout(10,2,10,10));
	      return seatPanel;
	    }
	   
	   
	   /** 메인패널(좌석선택패널이 부착될 패널)과 좌우측 패널을 전달받아
	    * 모든 패널이 부착된 메인패널을 리턴하는 메서드*/
	   JPanel getseatPanel(JPanel seatMainPanel) {
	      
	       // 좌측좌석패널(A,B)
	       JPanel leftSeatPanel = new JPanel();
	       leftSeatPanel.setBackground(Color.white);
	       leftSeatPanel.add(getHalfSeatPanel(true), BorderLayout.WEST);
	       
	       // 우측좌석패널(C,D)
	       JPanel rightSeatPanel = new JPanel();
	//       rightSeatPanel.setLayout(new BorderLayout());
	       rightSeatPanel.setBackground(Color.white);
	       rightSeatPanel.add(getHalfSeatPanel(false),BorderLayout.EAST);
	      
	      
	//      seatMainPanel.setLayout(new GridLayout(1, 2,150,0));
	       seatMainPanel.setBackground(Color.white);
	      seatMainPanel.add(leftSeatPanel, BorderLayout.WEST);
	      seatMainPanel.add(rightSeatPanel, BorderLayout.EAST);
	      
	      return seatMainPanel;
	   }

	@Override
	public void mouseClicked(MouseEvent e) {
		if(list.size() == people) {
			for (int i = 0; i < leftBtns.length; i++) {
				SpecialSeatSelect.chkAll = false;
				leftBtns[i].setEnabled(false);
			}
			for (int i = 0; i < rightBtns.length; i++) {
				SpecialSeatSelect.chkAll = false;
				rightBtns[i].setEnabled(false);
			}
			StandardSeatSelect.list = list;
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