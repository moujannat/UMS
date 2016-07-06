package view.loginWindow;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	
	public TopPanel() {
		setBorder(BorderFactory.createEtchedBorder());
		titleLabel = new JLabel("Login Window");
		titleLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(titleLabel);
	}

}
