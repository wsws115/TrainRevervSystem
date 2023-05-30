package train;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import train.search.Search_Train_Panel;

public class Loading_Panel extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public Loading_Panel() {
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(255, 255, 255));
		leftPanel.setBounds(100, 39, 982, 506);
		leftPanel.setLayout(null);
		try {
			JButton typeLabel1 = new JButton();
			typeLabel1.setBounds(0, 39, 300, 280);
			leftPanel.add(typeLabel1);
			typeLabel1.setIcon(new ImageIcon(ImageIO.read(new File("resource\\Loading_logo.png")).getScaledInstance(586, 471, Image.SCALE_AREA_AVERAGING)));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
