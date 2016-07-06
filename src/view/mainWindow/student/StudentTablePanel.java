package view.mainWindow.student;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controller.Controller;
import model.Student;

public class StudentTablePanel extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private JTable table;
	private StudentTableModel studentTableModel;
	private Controller controller;
	
	public StudentTablePanel() {
		controller = new Controller();
		
		//String[] colName = {"First Name", "Last Name", "Father Name", "Mother Name", "Gender", "DOB", "Home Address", "City", "Postal Code", "Country", "Reg Date", "Semester", "ID", "Department", "Status"};
		//DefaultTableModel dtable = new DefaultTableModel();
		studentTableModel = new StudentTableModel();
		table = new JTable(studentTableModel);
		
		
		setStudentData(controller.getStudent());
		
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setStudentData(List<Student> db){
		studentTableModel.setData(db);
	}
	
	public void refresh(){
		studentTableModel.fireTableDataChanged();
	}
	
	
}
