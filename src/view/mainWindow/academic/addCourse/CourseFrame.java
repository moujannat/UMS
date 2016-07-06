package view.mainWindow.academic.addCourse;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

import controller.Controller;

public class CourseFrame extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AddCoursePanel addCoursePanel;
	private CourseTablePanel courseTablePanel;
	private Controller controller;
	
	public CourseFrame(){
		initialize();
	}
	
	public void initialize() {
		setLocation(0,0);
		
		addCoursePanel = new AddCoursePanel();
		courseTablePanel = new CourseTablePanel();
		controller = new Controller();
		
		courseTablePanel.setCourseData(controller.getCourse());
		
		courseTablePanel.setCourseRefresh(new CourseRefreshListener() {
			
			public void refreshEventOccured(view.mainWindow.academic.addCourse.RefreshEvent e) {
				try {
					controller.connect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					controller.loadCourseTable(e);
					courseTablePanel.refresh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		addCoursePanel.setCoursePanelListener(new CoursePanelListener() {
			public void coursePanelEventOccured(CoursePanelEvent e){
				try {
					controller.connect();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				controller.addCourse(e);
				try {
					controller.loadCourseTable();
					courseTablePanel.refresh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				addCoursePanel.setVisible(false);
				addCoursePanel = new AddCoursePanel();
				initialize();
			}
		});
		
		setLayout(new BorderLayout());
		
		add(addCoursePanel,BorderLayout.WEST);
		add(courseTablePanel,BorderLayout.CENTER);
	}
}
