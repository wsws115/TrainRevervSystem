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
		leftPanel.setLayout(null);
		try {
			JLabel typeLabel1 = new JLabel();
			typeLabel1.setIcon(new ImageIcon("resource\\Loading_logo.PNG"));
			typeLabel1.setBounds(682, 105, 586, 471);
			leftPanel.add(typeLabel1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
