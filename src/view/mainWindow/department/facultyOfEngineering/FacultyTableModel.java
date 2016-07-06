package view.mainWindow.department.facultyOfEngineering;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Faculty;

public class FacultyTableModel extends AbstractTableModel {


	private static final long serialVersionUID = 1L;
	
	private List<Faculty> db;
	
	private String[] colName = {"First Name", "Last Name", "Gender", "DOB", "City", "Country", "Entry Date", "Designation", "ID", "Department"};
	
	public FacultyTableModel(){
	}
	
	public void setData(List<Faculty> db){
		this.db = db;
	}

	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colName[column];
	}


	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return db.size();
	}

	public Object getValueAt(int row, int col) {
		Faculty faculty = db.get(row);
		switch (col) {
		case 0:
			return faculty.getFirstName();
		case 1:
			return faculty.getLastName();
		case 2:
			return faculty.getGender();
		case 3:
			return faculty.getDob();
		case 4:
			return faculty.getCity();
		case 5:
			return faculty.getCountry();
		case 6:
			return faculty.getentryDate();
		case 7:
			return faculty.getdesignation();
		case 8:
			return faculty.getId();
		case 9:
			return faculty.getDepartment();
		}
		
		
		return null;
	}

}
