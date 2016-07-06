package view.mainWindow.home.faculty;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Controller;
import model.Faculty;

public class FacultyTablePanel extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private JTable table;
	private FacultyTableModel facultyTableModel;
	private JButton refresh;
	private Controller controller;
	private FacultyRefreshListener facultyRefreshListener;
	
	public FacultyTablePanel() {
		facultyTableModel = new FacultyTableModel();
		table = new JTable(facultyTableModel);
		refresh = new JButton("Refresh");
		controller = new Controller();
		setFacultyData(controller.getFaculty());
		refresh.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RefreshEvent re = new RefreshEvent(this);
				if(facultyRefreshListener != null){
					facultyRefreshListener.refreshEventOccured(re);
				}
				
			}
		});
		
		setLayout(new BorderLayout());
		add(refresh,BorderLayout.NORTH);
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setFacultyData(List<Faculty> db){
		facultyTableModel.setData(db);
	}
	
	public void refresh(){
		facultyTableModel.fireTableDataChanged();
	}
	
	public void setFacultyRefresh(FacultyRefreshListener listener){
		facultyRefreshListener = listener;
	}
}
