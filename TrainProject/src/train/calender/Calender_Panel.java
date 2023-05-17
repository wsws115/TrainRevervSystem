package train.calender;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Calender_Panel extends JPanel {
	private train.calender.CalendarCustom calendarCustom2;
	/**
	 * Create the panel.
	 */
	public Calender_Panel() {
		
		CalendarCustom calender = new CalendarCustom();
		calender.setBounds(0,0,1400,900);
		add(calender);

	}
}
