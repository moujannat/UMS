package view.mainWindow.student;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Student;

public class StudentTableModel extends AbstractTableModel {


	private static final long serialVersionUID = 1L;
	
	private List<Student> db;
	
	private String[] colName = {"First Name", "Last Name", "Father Name", "Mother Name", "Gender", "DOB",  "City", "Country",  "ID", "Department"};
	
	public StudentTableModel(){
	}
	
	public void setData(List<Student> db){
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
		Student student = db.get(row);
		switch (col) {
		case 0:
			return student.getFirstName();
		case 1:
			return student.getLastName();
		case 2:
			return student.getFatherName();
		case 3:
			return student.getMotherName();
		case 4:
			return student.getGender();
		case 5:
			return student.getDob();
		case 6:
			return student.getCity();
		case 7:
			return student.getCountry();
		case 8:
			return student.getId();
		case 9:
			return student.getDepartment();
		}
		
		
		return null;
	}

}
