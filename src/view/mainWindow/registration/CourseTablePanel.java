package view.mainWindow.registration;

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

import model.Course;
import controller.Controller;


public class CourseTablePanel extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private JTable table;
	private CourseTableModel courseTableModel;
	private Controller controller;
	private JPopupMenu popupMenu;
	
	public CourseTablePanel(){
		initializer();
	}
	
	
	
	public void initializer(){
		courseTableModel = new CourseTableModel();
		table = new JTable(courseTableModel);
		controller = new Controller();
		popupMenu = new JPopupMenu();
		
		JMenuItem addcourse = new JMenuItem("Add");
		popupMenu.add(addcourse);
		
		setCourseData(controller.getCourseReg());
		
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row);
				if(e.getButton() == MouseEvent.BUTTON3){
					popupMenu.show(table, e.getX(), e.getY());
				}
			}
			
		});
		
		addcourse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				String courseid = (String)table.getValueAt(row, 1);
				System.out.println(courseid);
				double credit = ((Double)table.getValueAt(row, 2)).doubleValue();
				//double credit = Double.parseDouble(scredit);
				//System.out.println(credit);
				try {
					controller.connect();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				controller.addcourseonstudent(courseid, credit);
				
				
			}
		});
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setCourseData(List<Course> db){
		courseTableModel.setData(db);
	}
	
	public void refresh(){
		courseTableModel.fireTableDataChanged();
	}
	
	
}
