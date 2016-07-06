package view.mainWindow.faculty;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import controller.Controller;

public class FacultyFrame extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Topbar topbar;
	private FacultyTablePanel facultyTablePanel;
	private Controller controller;
	public FacultyFrame() {
		initializer();
	}
	
	public void initializer(){
		controller = new Controller();
		topbar = new Topbar();
		facultyTablePanel = new FacultyTablePanel();
		facultyTablePanel.setFacultyData(controller.getFaculty());
		
		topbar.setTopberPanelListener(new TopbarPanelListener() {
			
			public void topbarPanelEventOccured(TopbarEvent e) {
				try {
					controller.connect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				controller.loadSearchFaculty(e);
				facultyTablePanel.refresh();
				
			}
		});
		
		setLayout(new BorderLayout());
		add(topbar,BorderLayout.NORTH);
		add(facultyTablePanel,BorderLayout.CENTER);
		setVisible(true);
	}
}
