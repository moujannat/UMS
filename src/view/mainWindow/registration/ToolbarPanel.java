package view.mainWindow.registration;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ToolbarPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField searchField;
	private JButton btnsearch;
	private ToolbarPanelListener panelListener;

	// private final JRadioButton rdbtnMaleRadioButton;
	// private final JRadioButton rdbtnFemaleRadioButton;

	/**
	 * Create the application.
	 */
	public ToolbarPanel() {
		initialization();
	}

	public void initialization() {
		searchField = new JTextField(20);
		btnsearch = new JButton("Search");
		JLabel lbl = new JLabel("Student Id ");
		//btnsearch.setBorder(getBorder());

		btnsearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String search = searchField.getText();
				ToolbarEvent te = new ToolbarEvent(this, search);
				if(panelListener != null){
					try {
						panelListener.registrationPanelEventOccured(te);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(lbl);
		add(searchField);
		add(btnsearch);
	}

	public void setToolbarPanelListener(ToolbarPanelListener listener) {
		panelListener = listener;
	}

}
