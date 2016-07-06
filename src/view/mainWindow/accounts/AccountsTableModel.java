package view.mainWindow.accounts;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Accounts;

public class AccountsTableModel extends AbstractTableModel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String colName[] = {"Student Id", "Date","Semester", "Debit", "Credit", "Balance"};
	
	private List<Accounts> db;
	
	public void setData(List<Accounts> db){
		this.db = db;
	}
	
	public AccountsTableModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colName[column];
	}
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return db.size();
	}

	public Object getValueAt(int row, int col) {
		Accounts accounts = db.get(row);
		switch (col) {
		case 0:
			return accounts.getStudentid();
		case 1:
			return accounts.getDate();
		case 2:
			return accounts.getSemester();
		case 3:
			return accounts.getDebit();
		case 4:
			return accounts.getCredit();
		case 5:
			return accounts.getBalance();
		
		
		}
		return null;
	}

}
