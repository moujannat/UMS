package view.mainWindow.home.student;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

import controller.Controller;

public class StudentFrame extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CreateStudentPanel createStudentPanel;
	private StudentTablePanel studentTablePanel;
	private Controller controller;
	
	public StudentFrame(){
		inisialization();
	}
	
	public void inisialization() {
		setLocation(0, 0);
		
		createStudentPanel = new CreateStudentPanel();
		studentTablePanel = new StudentTablePanel();
		controller = new Controller();
		
		studentTablePanel.setStudentData(controller.getStudent());
		setLayout(new BorderLayout());
		
		studentTablePanel.setStudentRefresh(new StudentRefreshListener() {
			
			public void refreshEventOccured(RefreshEvent e) {
				try {
					try {
						controller.connect();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					controller.loadStudentTable(e);
					studentTablePanel.refresh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		createStudentPanel.setStudentPanelListener(new StudentPanelListener() {
			public void studentPanelEventOccured(StudentPanelEvent e){
				 controller.addStudent(e);
				 try {
					controller.loadStudentTable();
					studentTablePanel.refresh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 createStudentPanel.setVisible(false);
					createStudentPanel = new CreateStudentPanel();
					inisialization();
				// createStudentPanel.validate();
				//createStudentPanel.repaint();
				 //createStudentPanel.revalidate();
			}
			public void studentTableEventOccured(StudentTableCreateEvent e){
				controller.createStudentTable(e);
				/*createStudentPanel.setVisible(false);
				createStudentPanel = new CreateStudentPanel();
				inisialization();
				createStudentPanel.validate();
				createStudentPanel.repaint();
				 createStudentPanel.revalidate();*/
				 
			}
			
			
		});

		
		add(createStudentPanel,BorderLayout.WEST);
		add(studentTablePanel,BorderLayout.CENTER);
	}

}
