package view.mainWindow.student;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;
import controller.Controller;


public class StudentFrame extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private ToolbarPanel toolbarPanel;
	private StudentTablePanel studentTablePanel;
	private Controller controller;
	
	public StudentFrame(){
		
		setLocation(0, 0);
		toolbarPanel = new ToolbarPanel();
		studentTablePanel = new StudentTablePanel();
		controller = new Controller();
		
		studentTablePanel.setStudentData(controller.getStudent());
		//studentTablePanel.setStudentData(db);
		toolbarPanel.setToolbarPanelListener(new ToolbarPanelListener() {
			
			public void studentPanelEventOccured(ToolbarEvent e) throws SQLException {
				try {
					controller.connect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				controller.loadSearchStudent(e);
				studentTablePanel.refresh();
				
			}
		});
		
		setLayout(new BorderLayout());
		add(toolbarPanel,BorderLayout.NORTH);
		add(studentTablePanel);
		//setSize(1360, 700);
		//add(createStudentFrame, BorderLayout.WEST);
		//add(createFacultyFrame,BorderLayout.CENTER);
		//add(createStaffFrame,BorderLayout.EAST);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
