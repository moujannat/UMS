package view.mainWindow.staff;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import controller.Controller;

public class StaffFrame extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Topbar topbar;
	private StaffTablePanel facultyTablePanel;
	private Controller controller;
	public StaffFrame() {
		initializer();
	}
	
	public void initializer(){
		controller = new Controller();
		topbar = new Topbar();
		facultyTablePanel = new StaffTablePanel();
		facultyTablePanel.setStaffData(controller.getStaff());
		
		topbar.setTopberPanelListener(new TopbarPanelListener() {
			
			public void topbarPanelEventOccured(TopbarEvent e) {
				try {
					controller.connect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				controller.loadSeachStaff(e);;
				facultyTablePanel.refresh();
				
			}
		});
		
		setLayout(new BorderLayout());
		add(topbar,BorderLayout.NORTH);
		add(facultyTablePanel,BorderLayout.CENTER);
		setVisible(true);
	}
}
