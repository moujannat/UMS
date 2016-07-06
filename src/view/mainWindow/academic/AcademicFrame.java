package view.mainWindow.academic;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import view.mainWindow.academic.addCourse.CourseFrame;
import view.mainWindow.academic.selectCource.SelectCourseForm;
import view.mainWindow.academic.settings.AdminSettings;

public class AcademicFrame extends JPanel{

	private static final long serialVersionUID = 1L;
	private CourseFrame courseFrame;
	private AdminSettings adminSettings;
	private SelectCourseForm selectCourseForm;
	private JTabbedPane tabPane;
	
	public AcademicFrame() {
		setLocation(0, 0);
		tabPane = new JTabbedPane();
		courseFrame = new CourseFrame();
		adminSettings = new AdminSettings();
		selectCourseForm = new SelectCourseForm();
		setLayout(new BorderLayout());
		tabPane.add("Course",courseFrame);
		tabPane.add("User Settings",new JScrollPane(adminSettings));
		tabPane.add("selectCourse",new JScrollPane(selectCourseForm));
		add(tabPane,BorderLayout.CENTER);
		setVisible(true);
		
	}
}
