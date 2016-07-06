package view.mainWindow.home.staff;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Controller;
import model.Staff;

public class StaffTablePanel extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private JTable table;
	private StaffTableModel staffTableModel;
	private JButton refresh;
	private Controller controller;
	private StaffRefreshListener staffRefreshListener;
	
	public StaffTablePanel() {
		staffTableModel = new StaffTableModel();
		table = new JTable(staffTableModel);
		refresh = new JButton("Refresh");
		controller = new Controller();
		setStaffData(controller.getStaff());
		refresh.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RefreshEvent re = new RefreshEvent(this);
				if(staffRefreshListener != null){
					staffRefreshListener.refreshEventOccured(re);
				}
				
			}
		});
		
		setLayout(new BorderLayout());
		add(refresh,BorderLayout.NORTH);
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setStaffData(List<Staff> db){
		staffTableModel.setData(db);
	}
	
	public void refresh(){
		staffTableModel.fireTableDataChanged();
	}
	
	public void setStaffRefresh(StaffRefreshListener listener){
		staffRefreshListener = listener;
	}
}
