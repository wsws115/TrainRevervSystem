package train.calender;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import train.TrainReserv_Main;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class Calender_Panel extends JPanel {
	private train.calender.CalendarCustom calendarCustom2;
	/**
	 * Create the panel.
	 */
	public Calender_Panel() {
		
		CalendarCustom calender = new CalendarCustom();
		calender.setBounds(0,0,1400,900);
		
		JButton previousBtn = new JButton("이전");
		previousBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.st_sub_btn.setText("서울");
				TrainReserv_Main.en_sub_btn.setText("부산");
				Calendar calendar = Calendar.getInstance();
				LocalDate ld = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) +1,calendar.get(Calendar.DATE));
				String date = String.valueOf(ld.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
				TrainReserv_Main.date_text.setText(date);
				TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "subway");
				
			}
		});
		previousBtn.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		
		JButton nextBtn = new JButton("다음");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "subkind");
			}
		});
		nextBtn.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(previousBtn, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 986, Short.MAX_VALUE)
					.addComponent(nextBtn, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(calender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(previousBtn, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
						.addComponent(nextBtn, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(calender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}
}
