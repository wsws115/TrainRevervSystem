package train.admin.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import train.calender.CalenderMain;
import train.dao.TicketDAO;
import javax.swing.ScrollPaneConstants;

public class Admin_check extends JPanel {
	
	TicketDAO ticketdao = new TicketDAO();
	
	JPanel leftPanel, rightPanel;
	public static JButton dateBtn;
	JButton trainBtn, carBtn, searchBtn;
	JLabel dateLab, trainNumLab, carLab;	
	JComboBox<Integer> trainComboBox = new JComboBox<Integer>();
	JComboBox<String> carComboBox  = new JComboBox<String>();
	String[] columnNames = {"좌석번호", "티켓번호", "출발지", "도착지", "차내식", "반환"};
	DefaultTableModel TicketModel = new DefaultTableModel(columnNames, 0);
	
	Integer[] trainNums = null;	
	
	public Admin_check() {
		// 메인 패널 옵션
		setLayout(new BorderLayout(0, 0));
		setBounds(441, 80, 1483, 931);
		setBackground(Color.white);
		
		// 티켓 조회하는 버튼 모여있는 왼쪽 패널
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.WHITE);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[] {100, 250, 0};
		gbl_leftPanel.rowHeights = new int[]{100, 100, 100, 0, 0, 0, 0, 0, 0};
		gbl_leftPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_leftPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		leftPanel.setLayout(gbl_leftPanel);		
		add(leftPanel, BorderLayout.WEST);
		
			dateLab = new JLabel("날짜");
			dateLab.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
			GridBagConstraints gbc_dateBtn = new GridBagConstraints();
			gbc_dateBtn.fill = GridBagConstraints.VERTICAL;
			gbc_dateBtn.insets = new Insets(30, 30, 5, 30);
			gbc_dateBtn.gridx = 0;
			gbc_dateBtn.gridy = 0;
			leftPanel.add(dateLab, gbc_dateBtn);
			train.calender.PanelDate.mainChk= false;
			dateBtn = new JButton();
			dateBtn.setBackground(Color.white);
			dateBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
			GridBagConstraints gbc_dateTextField = new GridBagConstraints();
			gbc_dateTextField.insets = new Insets(30, 30, 5, 30);
			gbc_dateTextField.fill = GridBagConstraints.BOTH;
			gbc_dateTextField.gridx = 1;
			gbc_dateTextField.gridy = 0;
			// 날짜 버튼 클릭 -> DB에서 맞는 기차 번호 가져옴 -> 콤보박스로 출력
			dateBtn.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					CalenderMain calender = new CalenderMain();
					calender.setVisible(true);
					
					// ★ 수정 - 캘린더 날짜 가져오기 !!!!
					trainNums = ticketdao.getTrainNum(20230522);
					
					for (Integer num : trainNums) {
						trainComboBox.addItem(num);
					}
				}
			});
			leftPanel.add(dateBtn, gbc_dateTextField);
			
			trainNumLab = new JLabel("기차번호");
			trainNumLab.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
			GridBagConstraints gbc_trainBtn = new GridBagConstraints();
			gbc_trainBtn.fill = GridBagConstraints.VERTICAL;
			gbc_trainBtn.insets = new Insets(30, 30, 5, 30);
			gbc_trainBtn.gridx = 0;
			gbc_trainBtn.gridy = 1;		
			leftPanel.add(trainNumLab, gbc_trainBtn);
			
			trainComboBox.setPreferredSize(new Dimension(350, 50));
			trainComboBox.setBackground(Color.WHITE);
			trainComboBox.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
			trainComboBox.setMaximumRowCount(20);
			GridBagConstraints gbc_trainTextField = new GridBagConstraints();
			gbc_trainTextField.fill = GridBagConstraints.BOTH;
			gbc_trainTextField.insets = new Insets(30, 30, 5, 30);
			gbc_trainTextField.gridx = 1;
			gbc_trainTextField.gridy = 1;
			leftPanel.add(trainComboBox, gbc_trainTextField);
			
			carLab = new JLabel("호차번호");
			carLab.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
			GridBagConstraints gbc_carBtn = new GridBagConstraints();
			gbc_carBtn.fill = GridBagConstraints.VERTICAL;
			gbc_carBtn.insets = new Insets(30, 30, 5, 30);
			gbc_carBtn.gridx = 0;
			gbc_carBtn.gridy = 2;
			leftPanel.add(carLab, gbc_carBtn);	
			
			carComboBox.setPreferredSize(new Dimension(350, 50));
			carComboBox.setBackground(Color.WHITE);
			carComboBox.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
			carComboBox.setMaximumRowCount(20);
			carComboBox.setModel(getSpecialCarInfo()); // 1 ~ 10호차 기본 값 넣어놓음
			GridBagConstraints gbc_carComboBox = new GridBagConstraints();
			gbc_carComboBox.insets = new Insets(30, 30, 5, 30);
			gbc_carComboBox.fill = GridBagConstraints.BOTH;
			gbc_carComboBox.gridx = 1;
			gbc_carComboBox.gridy = 2;
			leftPanel.add(carComboBox, gbc_carComboBox);
			
			searchBtn = new JButton("조회");
			searchBtn.setBackground(new Color(0, 128, 192));
			searchBtn.setForeground(Color.WHITE);
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.anchor = GridBagConstraints.EAST;
			gbc_btnNewButton.gridheight = 2;
			gbc_btnNewButton.insets = new Insets(30, 30, 5, 30);
			gbc_btnNewButton.gridx = 1;
			gbc_btnNewButton.gridy = 4;
			// 조회 버튼 클릭 시, 조건에 맞는 리스트를 DB에서 조회하여 테이블로 출력
			searchBtn.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					// ★ 수정중 - 날짜, 기차번호, 호차번호 값 가져와야함 !!
					int date = 20230522;
					int trainNum = Integer.valueOf(trainComboBox.getSelectedItem().toString());
					int traincode = Integer.valueOf(carComboBox.getSelectedItem().toString().substring(0, carComboBox.getSelectedItem().toString().indexOf("호")));
					ticketdao.getTicketList(date, trainNum, traincode, TicketModel);
				}
			});
			leftPanel.add(searchBtn, gbc_btnNewButton);
		
		// 테이블이 저장되는 오른쪽 패널
		rightPanel = new JPanel();
		rightPanel.setBackground(new Color(100, 149, 237));
		rightPanel.setLayout(new GridLayout(0, 1, 0, 0));		
		add(rightPanel, BorderLayout.CENTER);	
			
			// 화면 우측에서 티켓 리스트를 조회할 수 있는 테이블
			JTable table = new JTable(TicketModel);
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("HY헤드라인M", Font.PLAIN, 18));
			table.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
			DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
			celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
			// "좌석번호", "티켓번호", "출발지", "도착지", "차내식", "반환"
			table.getColumn("좌석번호").setCellRenderer(celAlignCenter);
			table.getColumn("티켓번호").setCellRenderer(celAlignCenter);
			table.getColumn("출발지").setCellRenderer(celAlignCenter);
			table.getColumn("도착지").setCellRenderer(celAlignCenter);
			table.getColumn("차내식").setCellRenderer(celAlignCenter);
			table.getColumn("반환").setCellRenderer(celAlignCenter);
			table.getColumn("좌석번호").setPreferredWidth(50);
			table.getColumn("티켓번호").setPreferredWidth(100);
			table.getColumn("출발지").setPreferredWidth(70);
			table.getColumn("도착지").setPreferredWidth(70);
			table.getColumn("차내식").setPreferredWidth(100);
			table.getColumn("반환").setPreferredWidth(10);
			
			table.getColumn("반환").setCellRenderer(new AdminBtn("반환", table));
			table.getColumn("반환").setCellEditor(new AdminBtn("반환", table));
			
			JScrollPane scrollPane = new JScrollPane(table);
			JPanel tablePanel = new JPanel();		
			tablePanel.setLayout(new BorderLayout(0, 0));
			tablePanel.add(scrollPane, BorderLayout.CENTER);
			rightPanel.add(tablePanel);
		
	}
	
	/** 호차 번호 콤보박스에 호차 기본 값을 넣어놓는 메소드 */
	DefaultComboBoxModel<String> getSpecialCarInfo() {
		int carNum = 10;
		String[] trainInfo = new String[carNum];

		for (int i = 0; i <= trainInfo.length; i++) {
			if (i == 0) { // 특실 + 휠체어석 1호차
				trainInfo[i] = i + 1 + "호차 / 특실 (휠체어석)";
			} else if (i + 1 == 2 || i + 1 == 3) { // 일반실 +일반좌석 5~ 10호차
				trainInfo[i] = i + 1 + "호차 / 특실";
			} else if (i == 3) { // 일반실 + 휠체어석 4호차
				trainInfo[i] = i + 1 + "호차 / 일반실 (휠체어석)";
			} else if (i >= 4 && i < 10) { // 일반실 +일반좌석 5~ 10호차
				trainInfo[i] = i + 1 + "호차 / 일반실";
			}
		}
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(trainInfo);
		return model;
	}	
	
}
