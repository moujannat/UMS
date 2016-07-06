package view.mainWindow.staff;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Controller;
import model.Staff;

public class StaffTablePanel extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private JTable table;
	private StaffTableModel staffTableModel;
	private Controller controller;
	
	public StaffTablePanel() {
		staffTableModel = new StaffTableModel();
		table = new JTable(staffTableModel);
		controller = new Controller();
		setStaffData(controller.getStaff());
			
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setStaffData(List<Staff> db){
		staffTableModel.setData(db);
	}
	
	public void refresh(){
		staffTableModel.fireTableDataChanged();
	}
	
}
