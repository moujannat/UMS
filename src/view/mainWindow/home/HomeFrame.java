package view.mainWindow.home;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import view.mainWindow.home.faculty.FacultyFrame;
import view.mainWindow.home.staff.StaffFrame;
import view.mainWindow.home.student.StudentFrame;




public class HomeFrame extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private StudentFrame studentFrame;
	private FacultyFrame facultyFrame;
	private StaffFrame staffFrame;
	
	private JTabbedPane tabPane;
	//private StudentTablePanel studentTablePanel;
	
	
	
	public HomeFrame(){
		
		setLocation(0, 0);
		
		tabPane = new JTabbedPane();
		
		studentFrame = new StudentFrame();
		facultyFrame = new FacultyFrame();
		staffFrame = new StaffFrame();
		
		
		setLayout(new BorderLayout());
		
		tabPane.add("Student", studentFrame);
		tabPane.add("Faculty", facultyFrame);
		tabPane.add("Staff",staffFrame);
		
		add(tabPane,BorderLayout.CENTER);
		
		//setSize(1360, 700);
		//add(createStudentFrame, BorderLayout.WEST);
		//add(createFacultyFrame,BorderLayout.CENTER);
		//add(createStaffFrame,BorderLayout.EAST);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
