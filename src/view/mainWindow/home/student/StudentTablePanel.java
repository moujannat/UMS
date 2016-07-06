package view.mainWindow.home.student;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controller.Controller;
import model.Student;

public class StudentTablePanel extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private JTable table;
	private StudentTableModel studentTableModel;
	private JButton refresh;
	private Controller controller;
	private StudentRefreshListener studentRefreshListener;
	
	public StudentTablePanel() {
		controller = new Controller();
		
		//String[] colName = {"First Name", "Last Name", "Father Name", "Mother Name", "Gender", "DOB", "Home Address", "City", "Postal Code", "Country", "Reg Date", "Semester", "ID", "Department", "Status"};
		//DefaultTableModel dtable = new DefaultTableModel();
		studentTableModel = new StudentTableModel();
		table = new JTable(studentTableModel);
		refresh = new JButton("Refresh");
		
		
		setStudentData(controller.getStudent());
		refresh.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RefreshEvent re = new RefreshEvent(this);
				if(studentRefreshListener != null){
					studentRefreshListener.refreshEventOccured(re);
				}
				
			}
		});
		
		setLayout(new BorderLayout());
		add(refresh,BorderLayout.NORTH);
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setStudentData(List<Student> db){
		studentTableModel.setData(db);
	}
	
	public void refresh(){
		studentTableModel.fireTableDataChanged();
	}
	
	public void setStudentRefresh(StudentRefreshListener listener){
		studentRefreshListener = listener;
	}
}
