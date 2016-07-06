package view.mainWindow.home.staff;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

import view.mainWindow.home.staff.CreateStaffPanel;
import view.mainWindow.home.staff.StaffRefreshListener;
import view.mainWindow.home.staff.StaffTablePanel;
import controller.Controller;

public class StaffFrame extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CreateStaffPanel createStaffPanel;
	private StaffTablePanel staffTablePanel;
	private Controller controller;
	
	public StaffFrame(){
		initialize();
	}
	
	public void initialize() {
		setLocation(0,0);
		
		createStaffPanel = new CreateStaffPanel();
		staffTablePanel = new StaffTablePanel();
		controller = new Controller();
		
		staffTablePanel.setStaffData(controller.getStaff());
		
		staffTablePanel.setStaffRefresh(new StaffRefreshListener() {
			
			public void refreshEventOccured(view.mainWindow.home.staff.RefreshEvent e) {
				try {
					controller.connect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					controller.loadStaffTable(e);
					staffTablePanel.refresh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		createStaffPanel.setStaffPanelListener(new StaffPanelListener() {
			public void staffPanelEventOccured(StaffPanelEvent e){
				try {
					controller.connect();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				controller.addStaff(e);
				try {
					controller.loadStaffTable();
					staffTablePanel.refresh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				createStaffPanel.setVisible(false);
				createStaffPanel = new CreateStaffPanel();
				initialize();
			}
		});
		
		setLayout(new BorderLayout());
		
		add(createStaffPanel,BorderLayout.WEST);
		add(staffTablePanel,BorderLayout.CENTER);
	}
}
