package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RMIServerFrm extends JFrame {
	private static final long serialVersionUID = 1L;
	public RMIServerFrm() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		JLabel lblStatus = new JLabel("Server is running...");
		lblStatus.setBounds(40, 30, 150, 40);
		this.add(lblStatus);
		this.setPreferredSize(new Dimension(800, 600));
		this.pack();
	}
	
}
