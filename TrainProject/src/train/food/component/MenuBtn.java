package train.food.component;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuBtn extends JButton {

	public MenuBtn(String name, CardLayout card, JPanel cards, String cardName) {
		setText(name);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 128, 192));
		setFont(new Font("HY헤드라인M", Font.BOLD, 40));
		setSize(240, 80);

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(cards, cardName);
			}
		});
	}
}
