package view.mainWindow.home.faculty;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Faculty;

public class FacultyTableModel extends AbstractTableModel {


	private static final long serialVersionUID = 1L;
	
	private List<Faculty> db;
	
	private String[] colName = {"First Name", "Last Name", "Father Name", "Mother Name", "Gender", "DOB", "Home Address", "City", "Postal Code", "Country", "Entry Date", "Designation", "ID", "Department", "Status"};
	
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
		return 15;
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
			return faculty.getFatherName();
		case 3:
			return faculty.getMotherName();
		case 4:
			return faculty.getGender();
		case 5:
			return faculty.getDob();
		case 6:
			return faculty.getHomeAddress();
		case 7:
			return faculty.getCity();
		case 8:
			return faculty.getPostalCode();
		case 9:
			return faculty.getCountry();
		case 10:
			return faculty.getentryDate();
		case 11:
			return faculty.getdesignation();
		case 12:
			return faculty.getId();
		case 13:
			return faculty.getDepartment();
		case 14:
			return faculty.getStatus();
		
		}
		
		
		return null;
	}

}
