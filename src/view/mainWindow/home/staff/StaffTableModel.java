package view.mainWindow.home.staff;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Staff;

public class StaffTableModel extends AbstractTableModel {


	private static final long serialVersionUID = 1L;
	
	private List<Staff> db;
	
	private String[] colName = {"First Name", "Last Name", "Father Name", "Mother Name", "Gender", "DOB", "Home Address", "City", "Postal Code", "Country", "Entry Date", "Designation", "ID", "Department", "Status"};
	
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
		return 15;
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
			return staff.getFatherName();
		case 3:
			return staff.getMotherName();
		case 4:
			return staff.getGender();
		case 5:
			return staff.getDob();
		case 6:
			return staff.getHomeAddress();
		case 7:
			return staff.getCity();
		case 8:
			return staff.getPostalCode();
		case 9:
			return staff.getCountry();
		case 10:
			return staff.getentryDate();
		case 11:
			return staff.getdesignation();
		case 12:
			return staff.getId();
		case 13:
			return staff.getDepartment();
		case 14:
			return staff.getStatus();
		
		}
		
		
		return null;
	}

}
