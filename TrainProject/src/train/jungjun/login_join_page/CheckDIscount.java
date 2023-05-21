package train.jungjun.login_join_page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckDIscount extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CheckDIscount dialog = new CheckDIscount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CheckDIscount() {
		setBounds(800, 300, 600, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("복지카드번호를 입력해주세요");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
			lblNewLabel.setBounds(75, 50, 450, 75);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("복지카드번호");
			lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
			lblNewLabel_1.setBounds(175, 200, 200, 75);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
			textField.setBounds(35, 300, 500, 100);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("확인");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnNewButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(new Color(0, 128, 192));
			btnNewButton.setBounds(35, 450, 200, 75);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("취소");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_1.setBackground(new Color(0, 128, 192));
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
			btnNewButton_1.setBounds(335, 450, 200, 75);
			contentPanel.add(btnNewButton_1);
		}
	}

}
