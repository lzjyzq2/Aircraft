package aircraft;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JFrame;

import base.Resources;

public class AircraftJFrame extends JFrame {
	
	public AircraftJFrame() {
		this.setTitle("·É»ú´óÕ½");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation((getToolkit().getScreenSize().width-Resources.width)/2, (getToolkit().getScreenSize().height-Resources.height)/2);
		getContentPane().setPreferredSize(new Dimension(Resources.width, Resources.height));
		AircraftJPanel sgj = new AircraftJPanel();
		sgj.setFocusable(true);
		this.add(sgj);
		pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new AircraftJFrame();
	}
}
