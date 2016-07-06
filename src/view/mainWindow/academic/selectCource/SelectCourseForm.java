package view.mainWindow.academic.selectCource;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

import controller.Controller;

public class SelectCourseForm extends JPanel{

	private static final long serialVersionUID = 1L;
	private CourseTablePanel courseTablePanel;
	private Controller controller;
	private Toolbar toolbar;
	public SelectCourseForm() {
		initializer();
	}
	public void initializer(){
		setLocation(0,0);
		
		courseTablePanel = new CourseTablePanel();
		controller = new Controller();
		toolbar = new Toolbar();
		
		courseTablePanel.setCourseData(controller.getCourseSem());
		
		toolbar.setTolbar(new TolbarRefreshListener() {
			
			public void refreshEventOccured(ToolbarRefresh tl) {
				try {
					controller.connect();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					controller.loadCourseSemTable(tl);
					courseTablePanel.refresh();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		/*courseTablePanel.setCourseRefresh(new CourseRefreshListener() {
			
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
		});*/
		
		setLayout(new BorderLayout());
		add(toolbar,BorderLayout.NORTH);
		add(courseTablePanel,BorderLayout.CENTER);
	}
}
