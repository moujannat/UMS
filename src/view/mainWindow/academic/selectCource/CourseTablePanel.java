package view.mainWindow.academic.selectCource;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Controller;
import model.Course;

public class CourseTablePanel extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private JTable table;
	private CourseTableModel courseTableModel;
	private Controller controller;
	private JPopupMenu popupMenu;
	
	public CourseTablePanel() {
		initializer();
	}
	
	public void initializer() {
		courseTableModel = new CourseTableModel();
		table = new JTable(courseTableModel);
		controller = new Controller();
		popupMenu = new JPopupMenu();
		
		JMenuItem addcourse = new JMenuItem("Semester");
		setCourseData(controller.getCourseSem());
		popupMenu.add(addcourse);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row);
				if(e.getButton() == MouseEvent.BUTTON3){
					popupMenu.show(table, e.getX(), e.getY());
				}
			}
			
		});
		
		addcourse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String courseid = (String) table.getValueAt(row, 1);
				try {
					controller.connect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				controller.setCourseSemester(courseid);
				controller.createCourseSemester(courseid);
				
			}
		});
		
	
		/*refresh.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RefreshEvent re = new RefreshEvent(this);
				if(courseRefreshListener != null){
					courseRefreshListener.refreshEventOccured(re);
				}
				
			}
		});*/
		
		
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setCourseData(List<Course> db){
		courseTableModel.setData(db);
	}
	
	public void refresh(){
		courseTableModel.fireTableDataChanged();
	}
	
	public void setCourseRefresh(CourseRefreshListener listener){
	}
	
	public void setCourseRefresh(TolbarRefreshListener listener){
	}
}
