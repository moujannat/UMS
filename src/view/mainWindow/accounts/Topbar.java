package view.mainWindow.accounts;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

public class Topbar extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textID;
	private JButton btnID;
	private JLabel lblID;
	private TopbarListtener topbarListtener;
	public Topbar() {
		initializer();
	}
	public void initializer(){
		textID = new JTextField(25);
		btnID = new JButton("Search");
		lblID = new JLabel("Search With Student Id");
		
		new AccountsPanel();
		
		new Controller();
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		setBorder(BorderFactory.createEtchedBorder());
		
		btnID.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String id = textID.getText();
				
				TopbarEvent te = new TopbarEvent(this, id);
				if(topbarListtener!=null){
					topbarListtener.topbarEventOccured(te);
				}
				
			}
		});
		
		add(lblID);
		add(textID);
		add(btnID);
	}

	public void setTopbarPanel(TopbarListtener listener){
		topbarListtener = listener;
	}
}
