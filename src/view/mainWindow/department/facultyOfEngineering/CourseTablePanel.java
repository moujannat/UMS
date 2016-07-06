package view.mainWindow.department.facultyOfEngineering;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Controller;
import model.Course;

public class CourseTablePanel extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private JTable table;
	private CourseTableModel courseTableModel;
	private Controller controller;

	
	public CourseTablePanel() {
		courseTableModel = new CourseTableModel();
		table = new JTable(courseTableModel);
		controller = new Controller();
		
		setCourseData(controller.getCourse());
		
		try {
			controller.connect();
		} catch (Exception e) {
			controller.disconnect();
		}
		controller.loadCouresOnDept("EEE");
		refresh();
		controller.disconnect();
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setCourseData(List<Course> db){
		courseTableModel.setData(db);
	}
	
	public void refresh(){
		courseTableModel.fireTableDataChanged();
	}
	
	
}
