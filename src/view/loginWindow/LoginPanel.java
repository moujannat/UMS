package view.loginWindow;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LoginPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel nameLabel;
	private JLabel passwordLabel;
	private JTextField nameField;
	private JPasswordField passwordField;
	//private ButtonPanel btnPanel;
	private JButton loginButton;
	private PanelListener panelListener;
	
	public LoginPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("User Name: ");
		passwordLabel = new JLabel("Password: ");
		nameField = new JTextField(15);
		passwordField = new JPasswordField(15);
		
		loginButton = new JButton("Login");
		
		loginButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				char[] getpassword = passwordField.getPassword();
				String  password= new String(getpassword);
				
				PanelEvent ev = new PanelEvent(this, name, password);
				
				if(panelListener != null){
					panelListener.panelEventOccured(ev);
				}
			}
		});
		
		//btnPanel = new ButtonPanel();
		
		TitledBorder innerBorder = BorderFactory.createTitledBorder("Admin Login");
		javax.swing.border.Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		
		////////////////////////first row/////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 0.5;
		
		gc.gridx = 2;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel,gc);
		
		gc.gridx = 3;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nameField,gc);
		
		//////////////////////////////////second row/////////////////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 0.5;
		
		gc.gridx = 2;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(passwordLabel,gc);
		
		gc.gridx = 3;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(passwordField,gc);
		
		//////////////////////////////////////////third row////////////////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 1.5;
		
		/*gc.gridx=2;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.BASELINE_LEADING;
		gc.insets = new Insets(0, 0, 0, 0);
		//add(btnPanel,gc);
		add(exitButton,gc);*/
		
		
		gc.gridx=3;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.BASELINE;
		gc.insets = new Insets(0, 0, 0, 5);
		add(loginButton,gc);
	}
	
	public void setPanelListener(PanelListener listener){
		this.panelListener = listener;
	}

}
