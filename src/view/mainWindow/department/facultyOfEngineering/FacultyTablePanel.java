package view.mainWindow.department.facultyOfEngineering;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Controller;
import model.Faculty;

public class FacultyTablePanel extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private JTable table;
	private FacultyTableModel facultyTableModel;
	private Controller controller;
	
	public FacultyTablePanel() {
		facultyTableModel = new FacultyTableModel();
		table = new JTable(facultyTableModel);
		controller = new Controller();
		setFacultyData(controller.getFaculty());
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setFacultyData(List<Faculty> db){
		facultyTableModel.setData(db);
	}
	
	public void refresh(){
		facultyTableModel.fireTableDataChanged();
	}
	
}
