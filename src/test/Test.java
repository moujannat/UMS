package test;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.Database;

public class Test {
	public static void main(String[] args) {
		
		Database db =new Database();
		//cp = new Controller();
		try {
			db.connect();
			//db.loadStudent();
			//db.disconnect();
			int i = db.studentcount();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		System.out.println(date);
		
		/*
		Calendar cal = Calendar.getInstance();  
	    int year = cal.get(cal.YEAR);  
	    int month = cal.get(cal.MONTH)+1; //zero-based 
	    System.out.println(year);
	    System.out.println(month);
	    System.out.println("year = "+year+"\nmonth = "+month);  
	    
	    java.text.NumberFormat nf = new java.text.DecimalFormat("0000");  
	    String idnum = nf.format(4);
	    System.out.println(idnum);
	    
	    try {
			String semester = db.semester();
			System.out.println(semester);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	    
	   /* String name = "student00008";
	    try {
			db.createStudentTable(name);
			System.out.println("Table created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	    
	   /* try {
			db.searchStudent("14-00002-3");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*try {
			db.loadCourseReg("14-00001-3");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*try {
			db.studentaccounts("14-00001", "Fall 14-15");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	    
		/*try {
			//String id = cp.getStudentidc();
			//System.out.println(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		
	    
	}

}
