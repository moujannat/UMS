package view.mainWindow.registration;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

import controller.Controller;

public class RegistrationForm extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ToolbarPanel toobarPanel;
	private CourseTablePanel courseTablePanel;
	private Controller controller;
	public RegistrationForm() {
		initializer();
	}
	public void initializer(){
		setLocation(0,0);
		
		toobarPanel = new ToolbarPanel();
		courseTablePanel = new CourseTablePanel();
		controller = new Controller();
		
		courseTablePanel.setCourseData(controller.getCourseReg());
		
		toobarPanel.setToolbarPanelListener(new ToolbarPanelListener() {
			
			public void registrationPanelEventOccured(ToolbarEvent e)
					throws SQLException {
				
				try {
					controller.connect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				controller.loadCourseReg(e);
				courseTablePanel.refresh();
				
			}
		});
			
		
		
		setLayout(new BorderLayout());
		add(toobarPanel,BorderLayout.NORTH);
		add(courseTablePanel,BorderLayout.CENTER);
	}
}
