package view.mainWindow.faculty;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Topbar extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textID;
	private JButton btnID;
	private JLabel lblID;
	private TopbarPanelListener panelListener;
	public Topbar() {
		initializer();
	}
	public void initializer(){
		textID = new JTextField(25);
		btnID = new JButton("Search");
		lblID = new JLabel("Search Faculty");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btnID.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String search = textID.getText();
				TopbarEvent te = new TopbarEvent(this, search);
				
				if(panelListener!=null){
					panelListener.topbarPanelEventOccured(te);
				}
				
			}
		});
		
		setBorder(BorderFactory.createEtchedBorder());
		
		add(lblID);
		add(textID);
		add(btnID);
	}
	
	public void setTopberPanelListener(TopbarPanelListener listener){
		panelListener = listener;
	}

}
