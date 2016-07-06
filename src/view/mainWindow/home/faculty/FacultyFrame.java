package view.mainWindow.home.faculty;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

import controller.Controller;

public class FacultyFrame extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CreateFacultyPanel createFacultyPanel;
	private  FacultyTablePanel facultyTablePanel;
	private Controller controller;
	
	public FacultyFrame(){
		initialize();
	}
	
	public void initialize() {
		setLocation(0, 0);
		
		createFacultyPanel = new CreateFacultyPanel();
		facultyTablePanel = new FacultyTablePanel();
		controller = new Controller();
		
		facultyTablePanel.setFacultyData(controller.getFaculty());
		
		facultyTablePanel.setFacultyRefresh(new FacultyRefreshListener() {
			
			public void refreshEventOccured(view.mainWindow.home.faculty.RefreshEvent e) {
				try {
					controller.connect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					controller.loadFacultyTable(e);
					facultyTablePanel.refresh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		createFacultyPanel.setFacultyPanelListener(new FacultyPanelListener() {
			
			public void facultyPanelEventOccured(FacultyPanelEvent e) {
				try {
					controller.connect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				controller.addFaculty(e);
				
				try {
					controller.loadFacultyTable();
					facultyTablePanel.refresh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				createFacultyPanel.setVisible(false);
				createFacultyPanel = new CreateFacultyPanel();
				initialize();
			}
		});
		
		setLayout(new BorderLayout());
		
		add(createFacultyPanel,BorderLayout.WEST);
		add(facultyTablePanel,BorderLayout.CENTER);
	}

}
