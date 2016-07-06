package view.mainWindow.registration;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Course;

public class CourseTableModel extends AbstractTableModel {


	private static final long serialVersionUID = 1L;
	
	private List<Course> db;
	
	private String[] colName = {"Course Description", "Course Code", "Credit","Department", "Prerequsite","Faculty of Dept"};
	
	public CourseTableModel(){
	}
	
	public void setData(List<Course> db){
		this.db = db;
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
		Course course = db.get(row);
		switch (col) {
		case 0:
			return course.getCoursediscription();
		case 1:
			return course.getCode();
		case 2:
			return course.getCredit();
		case 3:
			return course.getDept();
		case 4:
			return course.getPrequsite();
		case 5:
			return course.getFdept();
		
		
		}
		
		
		return null;
	}

}
