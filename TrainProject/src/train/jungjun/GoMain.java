package train.jungjun;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import train.Train_Main;
import train.jungjun.login_join_page.Login_and_join;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GoMain extends JDialog {

	private final JPanel contentPanel = new JPanel();
//	public static boolean Goclose = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GoMain dialog = new GoMain();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GoMain() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(800, 300, 600, 600);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 584, 350);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel label1 = new JLabel("처음으로 돌아가시겠습니까?");
			label1.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
			label1.setBounds(90, 90, 400, 75);
			contentPanel.add(label1);
		}
		{
			JLabel label2 = new JLabel("진행 내역이 초기화됩니다");
			label2.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
			label2.setBounds(90, 160, 400, 75);
			contentPanel.add(label2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 360, 584, 201);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("확인");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Train_Main gomain = new Train_Main();
						gomain.main(null);
						dispose();
					}
				});
				okButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(new Color(0, 128, 192));
				okButton.setBounds(30, 50, 250, 100);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(new Color(0, 128, 192));
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
				cancelButton.setBounds(310, 50, 250, 100);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
