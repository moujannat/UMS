package view.mainWindow.staff;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Staff;

public class StaffTableModel extends AbstractTableModel {


	private static final long serialVersionUID = 1L;
	
	private List<Staff> db;
	
	private String[] colName = {"First Name", "Last Name", "Gender", "DOB", "City", "Country", "Entry Date", "Designation", "ID", "Department"};
	
	public StaffTableModel(){
	}
	
	public void setData(List<Staff> db){
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
		Staff staff = db.get(row);
		switch (col) {
		case 0:
			return staff.getFirstName();
		case 1:
			return staff.getLastName();
		case 2:
			return staff.getGender();
		case 3:
			return staff.getDob();
		case 4:
			return staff.getCity();
		case 5:
			return staff.getCountry();
		case 6:
			return staff.getentryDate();
		case 7:
			return staff.getdesignation();
		case 8:
			return staff.getId();
		case 9:
			return staff.getDepartment();
		}
		
		
		return null;
	}

}
