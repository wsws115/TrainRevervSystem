package train.train_food_component;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FoodLab extends JLabel {

	public FoodLab(String text) {
		setText(text);
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		setSize(176, 24);
	}
}
