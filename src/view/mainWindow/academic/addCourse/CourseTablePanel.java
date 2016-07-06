package view.mainWindow.academic.addCourse;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
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
	private JButton refresh;
	private Controller controller;
	private CourseRefreshListener courseRefreshListener;
	private JPopupMenu pop;
	
	public CourseTablePanel() {
		courseTableModel = new CourseTableModel();
		table = new JTable(courseTableModel);
		refresh = new JButton("Refresh");
		controller = new Controller();
		pop = new JPopupMenu();
		
		JMenuItem addme = new JMenuItem("Add");
		pop.add(addme);
		
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				pop.show(table, e.getX(), e.getY());
			}
			
		});
		
		setCourseData(controller.getCourse());
		
		refresh.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RefreshEvent re = new RefreshEvent(this);
				if(courseRefreshListener != null){
					courseRefreshListener.refreshEventOccured(re);
				}
				
			}
		});
		
		setLayout(new BorderLayout());
		add(refresh,BorderLayout.NORTH);
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setCourseData(List<Course> db){
		courseTableModel.setData(db);
	}
	
	public void refresh(){
		courseTableModel.fireTableDataChanged();
	}
	
	public void setCourseRefresh(CourseRefreshListener listener){
		courseRefreshListener = listener;
	}
}
