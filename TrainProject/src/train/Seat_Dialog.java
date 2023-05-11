package train;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import java.awt.Component;

public class Seat_Dialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private boolean selectDone = true;
	private static int select_seat = 0;
	
	private JButton seatselectBtn1;
	private JButton seatselectBtn2;
	private JButton seatselectBtn3;
	private JButton seatselectBtn5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Seat_Dialog dialog = new Seat_Dialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Seat_Dialog() {
		setBounds(100, 100, 803, 933);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JPanel rightPanel = new JPanel();
			rightPanel.setLayout(null);
			contentPanel.add(rightPanel);
			{
				JComboBox trainNum_comboBox = new JComboBox();
				trainNum_comboBox.addItem("test1");
				trainNum_comboBox.addItem("test2");
				trainNum_comboBox.addItem("test3");
				
				trainNum_comboBox.setMaximumRowCount(20);
				trainNum_comboBox.setBounds(50, 50, 700, 40);
				rightPanel.add(trainNum_comboBox);
			}
			{
				JLabel trainInfoLabel = new JLabel("KTX-산천 419 (일반실) ");
				trainInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				trainInfoLabel.setFont(new Font("굴림", Font.BOLD, 20));
				trainInfoLabel.setBounds(282, 122, 230, 24);
				rightPanel.add(trainInfoLabel);
			}
			{
				JButton previousBtn = new JButton("14호차");
				previousBtn.setBounds(50, 138, 120, 40);
				rightPanel.add(previousBtn);
			}
			{
				JButton nextBtn = new JButton("16호차");
				nextBtn.setBounds(630, 138, 120, 40);
				rightPanel.add(nextBtn);
			}
			{
				JLabel seatInfoLabel = new JLabel("잔여 25석 / 전체 28 석");
				seatInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				seatInfoLabel.setFont(new Font("굴림", Font.BOLD, 20));
				seatInfoLabel.setBounds(167, 156, 469, 34);
				rightPanel.add(seatInfoLabel);
			}
			{
				JScrollPane seatScrollPane = new JScrollPane();
				seatScrollPane.setPreferredSize(new Dimension(700, 600));
				seatScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				seatScrollPane.setBounds(50, 200, 700, 600);
				rightPanel.add(seatScrollPane);
				{
					JPanel seatPanel = new JPanel();
					seatPanel.setLayout(null);
					seatPanel.setPreferredSize(new Dimension(700, 1500));
					seatScrollPane.setViewportView(seatPanel);
					{
						seatselectBtn1 = new JButton("A1");
						seatselectBtn1.setBounds(50, 50, 100, 100);
						seatPanel.add(seatselectBtn1);
						seatselectBtn1.addActionListener(this);
						
					}
					{
						seatselectBtn2 = new JButton("A2");
						seatselectBtn2.setBounds(170, 50, 100, 100);
						seatPanel.add(seatselectBtn2);
						seatselectBtn2.addActionListener(this);
					}
					{
						seatselectBtn3 = new JButton("A3");
						seatselectBtn3.setBounds(430, 50, 100, 100);
						seatPanel.add(seatselectBtn3);
						seatselectBtn3.addActionListener(this);
					}
					{
						seatselectBtn5 = new JButton("A4");
						seatselectBtn5.setBounds(550, 50, 100, 100);
						seatPanel.add(seatselectBtn5);
						seatselectBtn5.addActionListener(this);
					}
					{
						JButton seatselectBtn6 = new JButton("B1");
						seatselectBtn6.setBounds(50, 170, 100, 100);
						seatPanel.add(seatselectBtn6);
					}
					{
						JButton seatselectBtn7 = new JButton("B2");
						seatselectBtn7.setBounds(170, 170, 100, 100);
						seatPanel.add(seatselectBtn7);
					}
					{
						JButton seatselectBtn8 = new JButton("B3");
						seatselectBtn8.setBounds(430, 170, 100, 100);
						seatPanel.add(seatselectBtn8);
					}
					{
						JButton seatselectBtn9 = new JButton("B4");
						seatselectBtn9.setBounds(550, 170, 100, 100);
						seatPanel.add(seatselectBtn9);
					}
					{
						JButton seatselectBtn10 = new JButton("C1");
						seatselectBtn10.setBounds(50, 290, 100, 100);
						seatPanel.add(seatselectBtn10);
					}
					{
						JButton seatselectBtn11 = new JButton("C2");
						seatselectBtn11.setBounds(170, 290, 100, 100);
						seatPanel.add(seatselectBtn11);
					}
					{
						JButton seatselectBtn12 = new JButton("C3");
						seatselectBtn12.setBounds(430, 290, 100, 100);
						seatPanel.add(seatselectBtn12);
					}
					{
						JButton seatselectBtn13 = new JButton("C4");
						seatselectBtn13.setBounds(550, 290, 100, 100);
						seatPanel.add(seatselectBtn13);
					}
					{
						JButton seatselectBtn14 = new JButton("D1");
						seatselectBtn14.setBounds(50, 410, 100, 100);
						seatPanel.add(seatselectBtn14);
					}
					{
						JButton seatselectBtn15 = new JButton("D2");
						seatselectBtn15.setBounds(170, 410, 100, 100);
						seatPanel.add(seatselectBtn15);
					}
					{
						JButton seatselectBtn16 = new JButton("D3");
						seatselectBtn16.setBounds(430, 410, 100, 100);
						seatPanel.add(seatselectBtn16);
					}
					{
						JButton seatselectBtn17 = new JButton("D4");
						seatselectBtn17.setBounds(550, 410, 100, 100);
						seatPanel.add(seatselectBtn17);
					}
					{
						JButton seatselectBtn18 = new JButton("E1");
						seatselectBtn18.setBounds(50, 530, 100, 100);
						seatPanel.add(seatselectBtn18);
					}
					{
						JButton seatselectBtn19 = new JButton("E2");
						seatselectBtn19.setBounds(170, 530, 100, 100);
						seatPanel.add(seatselectBtn19);
					}
					{
						JButton seatselectBtn20 = new JButton("E3");
						seatselectBtn20.setBounds(430, 530, 100, 100);
						seatPanel.add(seatselectBtn20);
					}
					{
						JButton seatselectBtn21 = new JButton("E4");
						seatselectBtn21.setBounds(550, 530, 100, 100);
						seatPanel.add(seatselectBtn21);
					}
					{
						JButton seatselectBtn22 = new JButton("F1");
						seatselectBtn22.setBounds(50, 650, 100, 100);
						seatPanel.add(seatselectBtn22);
					}
					{
						JButton seatselectBtn23 = new JButton("F2");
						seatselectBtn23.setBounds(170, 650, 100, 100);
						seatPanel.add(seatselectBtn23);
					}
					{
						JButton seatselectBtn24 = new JButton("F3");
						seatselectBtn24.setBounds(430, 650, 100, 100);
						seatPanel.add(seatselectBtn24);
					}
					{
						JButton seatselectBtn25 = new JButton("F4");
						seatselectBtn25.setBounds(550, 650, 100, 100);
						seatPanel.add(seatselectBtn25);
					}
					{
						JButton seatselectBtn26 = new JButton("G1");
						seatselectBtn26.setBounds(50, 770, 100, 100);
						seatPanel.add(seatselectBtn26);
					}
					{
						JButton seatselectBtn27 = new JButton("G2");
						seatselectBtn27.setBounds(170, 770, 100, 100);
						seatPanel.add(seatselectBtn27);
					}
					{
						JButton seatselectBtn28 = new JButton("G3");
						seatselectBtn28.setBounds(430, 770, 100, 100);
						seatPanel.add(seatselectBtn28);
					}
					{
						JButton seatselectBtn29 = new JButton("G4");
						seatselectBtn29.setBounds(550, 770, 100, 100);
						seatPanel.add(seatselectBtn29);
					}
					{
						JButton seatselectBtn30 = new JButton("H1");
						seatselectBtn30.setBounds(50, 890, 100, 100);
						seatPanel.add(seatselectBtn30);
					}
					{
						JButton seatselectBtn31 = new JButton("H2");
						seatselectBtn31.setBounds(170, 890, 100, 100);
						seatPanel.add(seatselectBtn31);
					}
					{
						JButton seatselectBtn32 = new JButton("H3");
						seatselectBtn32.setBounds(430, 890, 100, 100);
						seatPanel.add(seatselectBtn32);
					}
					{
						JButton seatselectBtn33 = new JButton("H4");
						seatselectBtn33.setBounds(550, 890, 100, 100);
						seatPanel.add(seatselectBtn33);
					}
					{
						JButton seatselectBtn34 = new JButton("I1");
						seatselectBtn34.setBounds(50, 1010, 100, 100);
						seatPanel.add(seatselectBtn34);
					}
					{
						JButton seatselectBtn35 = new JButton("I2");
						seatselectBtn35.setBounds(170, 1010, 100, 100);
						seatPanel.add(seatselectBtn35);
					}
					{
						JButton seatselectBtn36 = new JButton("I3");
						seatselectBtn36.setBounds(430, 1010, 100, 100);
						seatPanel.add(seatselectBtn36);
					}
					{
						JButton seatselectBtn37 = new JButton("I4");
						seatselectBtn37.setBounds(550, 1010, 100, 100);
						seatPanel.add(seatselectBtn37);
					}
					{
						JButton seatselectBtn38 = new JButton("J1");
						seatselectBtn38.setBounds(50, 1130, 100, 100);
						seatPanel.add(seatselectBtn38);
					}
					{
						JButton seatselectBtn39 = new JButton("J2");
						seatselectBtn39.setBounds(170, 1130, 100, 100);
						seatPanel.add(seatselectBtn39);
					}
					{
						JButton seatselectBtn40 = new JButton("J3");
						seatselectBtn40.setBounds(430, 1130, 100, 100);
						seatPanel.add(seatselectBtn40);
					}
					{
						JButton seatselectBtn41 = new JButton("J4");
						seatselectBtn41.setBounds(550, 1130, 100, 100);
						seatPanel.add(seatselectBtn41);
					}
					{
						JButton seatselectBtn42 = new JButton("K1");
						seatselectBtn42.setBounds(50, 1250, 100, 100);
						seatPanel.add(seatselectBtn42);
					}
					{
						JButton seatselectBtn43 = new JButton("K2");
						seatselectBtn43.setBounds(170, 1250, 100, 100);
						seatPanel.add(seatselectBtn43);
					}
					{
						JButton seatselectBtn44 = new JButton("K3");
						seatselectBtn44.setBounds(430, 1250, 100, 100);
						seatPanel.add(seatselectBtn44);
					}
					{
						JButton seatselectBtn45 = new JButton("K4");
						seatselectBtn45.setBounds(550, 1250, 100, 100);
						seatPanel.add(seatselectBtn45);
					}
					{
						JButton seatselectBtn46 = new JButton("L1");
						seatselectBtn46.setBounds(50, 1370, 100, 100);
						seatPanel.add(seatselectBtn46);
					}
					{
						JButton seatselectBtn47 = new JButton("L2");
						seatselectBtn47.setBounds(170, 1370, 100, 100);
						seatPanel.add(seatselectBtn47);
					}
					{
						JButton seatselectBtn48 = new JButton("L3");
						seatselectBtn48.setBounds(430, 1370, 100, 100);
						seatPanel.add(seatselectBtn48);
					}
					{
						JButton seatselectBtn49 = new JButton("L4");
						seatselectBtn49.setBounds(550, 1370, 100, 100);
						seatPanel.add(seatselectBtn49);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setSize(200,200);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 String people = TrainReserv_Main.people;
		 select_seat++;
		 String select_num = ""+select_seat;
		 TrainReserv_Main.seatSelectLabel.setText(select_num);
		 int people_num = Integer.parseInt(people);
		 if (people_num == select_seat) {
			 selectDone = false;
			 System.out.println("끝");
			 seatselectBtn1.setEnabled(selectDone);
			 seatselectBtn2.setEnabled(selectDone);
			 seatselectBtn3.setEnabled(selectDone);
			 seatselectBtn5.setEnabled(selectDone);
		 }else {
			 System.out.println(select_seat);
		 }
		
	}

}
