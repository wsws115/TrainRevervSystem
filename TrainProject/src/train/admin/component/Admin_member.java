package train.admin.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import train.dao.MemberDAO;
import train.dto.MemberDTO;

public class Admin_member extends JPanel {
	
	MemberDAO memberdao = new MemberDAO();
	List<MemberDTO> allMemberList = memberdao.getAllMember();
	
	String orderTableColumnName [] = {"회원 번호", "아이디", "비밀번호", "이름", "전화번호", "생년월일", "이메일", "우대 사항", "탈퇴"};
	
	DefaultTableModel model;
	
	void getMeberValue(DefaultTableModel order_dtm) {
		order_dtm.setNumRows(0);
		
		for (MemberDTO member : allMemberList) {
			Vector<Object> list = new Vector<>();
			list.add(member.getUserNum());
			list.add(member.getId());
			list.add(member.getPassword());
			list.add(member.getName());
			list.add(member.getPhone());
			list.add(member.getBirth());
			list.add(member.getEmail());
			list.add(member.getPreferential());	
			order_dtm.addRow(list);
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Admin_member() {
		setBounds(441, 80, 1350, 800);
		setBackground(Color.white);
		setLayout(null);
		
		model = new DefaultTableModel(orderTableColumnName, 0);
								
		JTable membertable = new JTable(model);
		membertable.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));	
		membertable.getTableHeader().setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		membertable.setRowHeight(50);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		membertable.getColumn("회원 번호").setCellRenderer(celAlignCenter);
		membertable.getColumn("아이디").setCellRenderer(celAlignCenter);
		membertable.getColumn("비밀번호").setCellRenderer(celAlignCenter);
		membertable.getColumn("이름").setCellRenderer(celAlignCenter);
		membertable.getColumn("전화번호").setCellRenderer(celAlignCenter);
		membertable.getColumn("생년월일").setCellRenderer(celAlignCenter);
		membertable.getColumn("이메일").setCellRenderer(celAlignCenter);
		membertable.getColumn("우대 사항").setCellRenderer(celAlignCenter);
		
		membertable.getColumn("회원 번호").setPreferredWidth(70);
		membertable.getColumn("아이디").setPreferredWidth(100);
		membertable.getColumn("비밀번호").setPreferredWidth(100);
		membertable.getColumn("이름").setPreferredWidth(50);
		membertable.getColumn("전화번호").setPreferredWidth(100);
		membertable.getColumn("생년월일").setPreferredWidth(50);
		membertable.getColumn("이메일").setPreferredWidth(100);
		membertable.getColumn("우대 사항").setPreferredWidth(100);
		
		membertable.setBounds(300, 300, 1600, 700);
		
		membertable.getColumn("탈퇴").setCellRenderer(new AdminBtn("탈퇴", membertable));
		membertable.getColumn("탈퇴").setCellEditor(new AdminBtn("탈퇴",membertable));
		
		JScrollPane scrollPane = new JScrollPane(membertable);
		scrollPane.setBounds(0, 100, 1350, 800);
		add(scrollPane);		
		
		JButton searchBtn = new JButton("조회");
		searchBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				getMeberValue(model);			
			}
		});
		searchBtn.setBackground(new Color(0, 128, 192));
		searchBtn.setForeground(Color.white);
		searchBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		searchBtn.setBounds(10, 20, 220, 60);
		add(searchBtn);
	}
}
