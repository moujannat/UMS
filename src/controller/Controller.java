package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.util.List;

import model.Accounts;
import model.Course;
import model.Database;
import model.Faculty;
import model.Login;
import model.Staff;
import model.Student;
import view.mainWindow.academic.addCourse.CoursePanelEvent;
import view.mainWindow.academic.selectCource.ToolbarRefresh;
import view.mainWindow.accounts.AccountPanelEvent;
import view.mainWindow.accounts.TopbarEvent;
import view.mainWindow.home.faculty.FacultyPanelEvent;
import view.mainWindow.home.staff.StaffPanelEvent;
import view.mainWindow.home.student.RefreshEvent;
import view.mainWindow.home.student.StudentPanelEvent;
import view.mainWindow.home.student.StudentTableCreateEvent;
import view.mainWindow.registration.ToolbarEvent;

public class Controller {
	
	Database db = new Database();
	Login ln = new Login();
	
	public List<Student> getStudent(){
		return db.getStudent();
	}
	public List<Accounts> getAccounts(){
		return db.getAccounts();
	}
	
	public List<Staff> getStaff(){
		return db.getStaff();
	}
	
	public List<Faculty> getFaculty(){
		return db.getFaculty();
	}
	
	public List<Course> getCourse(){
		return db.getCourse();
	}
	
	public List<Course> getCourseSem(){
		return db.getCourseSem();
	}
	
	public List<Login> getLogin(){
		return db.getLogin();
	}
	
	public List<Course> getCourseReg(){
		return db.getCourseReg();
	}
	
	public void addStudent(StudentPanelEvent e){
		String firstName = e.getFirstName();
		 String lastName = e.getLastName();
		 String fatherName = e.getFatherName();
		 String motherName = e.getMotherName();
		 String gender = e.getGender();
		 String dob = e.getDob();
		 String homeAddress = e.getHomeAddress();
		 String city = e.getCity();
		 int postalCode = e.getPostalCode();
		 String country = e.getCountry();
		 String regDate = e.getRegDate();
		 String semester = e.getSemester();
		 String id = e.getId();
		 String department = e.getDepartment();
		 String status = e.getStatus();
		 
		 
		 
		  try {
			db.connect();
			db.saveStudent(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, regDate, semester, id, department, status);
			JOptionPane.showMessageDialog(null, "Student Data Inserted");
			//db.disconnect();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error\n Check all input Panels");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error\nCheck all input Panels");

		}
	}
	
	public void addStaff(StaffPanelEvent e){
		String firstName = e.getFirstName();
		 String lastName = e.getLastName();
		 String fatherName = e.getFatherName();
		 String motherName = e.getMotherName();
		 String gender = e.getGender();
		 String dob = e.getDob();
		 String homeAddress = e.getHomeAddress();
		 String city = e.getCity();
		 int postalCode = e.getPostalCode();
		 String country = e.getCountry();
		 String entryDate = e.getEntryDate();
		 String designation = e.getDesignation();
		 String id = e.getId();
		 String department = e.getDepartment();
		 String status = e.getStatus();
		 
		 try {
			//db.connect();
			db.saveStaff(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, entryDate, designation, id, department, status);
			JOptionPane.showMessageDialog(null, "Staff Data Inserted");
			//db.disconnect();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error\n Check all input Panels");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error\nCheck all input Panels");

		}
	}
	
	public void addFaculty(FacultyPanelEvent e){
		String firstName = e.getFirstName();
		 String lastName = e.getLastName();
		 String fatherName = e.getFatherName();
		 String motherName = e.getMotherName();
		 String gender = e.getGender();
		 String dob = e.getDob();
		 String homeAddress = e.getHomeAddress();
		 String city = e.getCity();
		 int postalCode = e.getPostalCode();
		 String country = e.getCountry();
		 String entryDate = e.getEntryDate();
		 String designation = e.getDesignation();
		 String id = e.getId();
		 String department = e.getDepartment();
		 String status = e.getStatus();
		 
		 try {
			//db.connect();
			db.saveFaculty(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, entryDate, designation, id, department, status);
			JOptionPane.showMessageDialog(null, "Faculty Data Inserted");
			//db.disconnect();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error\n Check all input Panels");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error\nCheck all input Panels");

		}
	}
	
	public void addCourse(CoursePanelEvent e){
		 String coursediscription = e.getCoursediscription();
		 String code = e.getCode();
		 double credit = e.getCredit();
		 String dept = e.getDept();
		 String prequsite = e.getPrequsite();
		 String fdept = e.getFdept();
		 
		 try {
			//db.connect();
			db.saveCourse(coursediscription, code, credit, dept, prequsite, fdept);
			JOptionPane.showMessageDialog(null, "Course Data Inserted");
			//db.disconnect();
		} catch (SQLException e1) {
			System.out.println("Error here");
			JOptionPane.showMessageDialog(null, "Error\n Check all input Panels");
		} 
	}
	
	public void connect() throws Exception{
		db.connect();
	}
	
	public void disconnect(){
		db.disconnect();
	}
	
	public void loadStudentTable() throws SQLException{
		/*try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		db.loadStudent();
		//db.disconnect();
	}
	
	public void loadStudentTable(RefreshEvent e) throws SQLException{
		/*try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		db.loadStudent();
		//db.disconnect();
	}
	
	public void loadSearchStudent(view.mainWindow.student.ToolbarEvent e) throws SQLException{
		String search = e.getSearch();
		db.searchStudent(search);
		//db.disconnect();
	}
	
	public void loadSearchFaculty(view.mainWindow.faculty.TopbarEvent e){
		String search = e.getSearch();
		try {
			db.searchFaculty(search);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void loadSeachStaff(view.mainWindow.staff.TopbarEvent e){
		String search = e.getSearch();
		
		try {
			db.searchStaff(search);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void loadStaffTable() throws SQLException{
		/*try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		db.loadStaff();
		//db.disconnect();
	}
	
	public void loadStaffTable(view.mainWindow.home.staff.RefreshEvent e) throws SQLException{
		/*try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		db.loadStaff();
		//db.disconnect();
	}
	
	public void loadFacultyTable() throws SQLException{
		/*try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		db.loadFaculty();
		//db.disconnect();
	}
	
	public void loadFacultyTable(view.mainWindow.home.faculty.RefreshEvent e) throws SQLException{
		/*try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		db.loadFaculty();
		//db.disconnect();
	}
	
	public void loadCourseTable() throws SQLException{
		/*try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		db.loadCourse();
		//db.disconnect();
	}
	
	public void loadCourseSemTable() throws SQLException{
		/*try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		db.loadCourseSem();
		//db.disconnect();
	}
	
	public void loadCourseSemTable(ToolbarRefresh e) throws SQLException{
		
			db.loadCourseSem();
	}
	
	public void loadCourseTable(view.mainWindow.academic.addCourse.RefreshEvent e) throws SQLException{
		/*try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		db.loadCourse();
		//db.disconnect();
	}
	
	
	public int studentcount(){
		try {
			return db.studentcount();
		} catch (SQLException e) {
			return 0;
		}
	}
	
	public int facultycount(){
		try {
			return db.facultycount();
		} catch (SQLException e) {
			return 0;
		}
	}
	
	public int staffcount(){
		try {
			return db.staffcount();
		} catch (SQLException e) {
			return 0;
		}
	}
	
	public String semester(){
		try {
			return db.semester();
		} catch (SQLException e) {
			return "unavailable";
		}
	}
	
	public void createStudentTable(StudentTableCreateEvent e){
		String name = e.getIdnum();
		try {
			db.createStudentTable(name);
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		}
	}
	
	public void addSemester(String name){
		//String semester = name;
		try {
			db.saveSemester(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setCourseSemester(String name){
		try {
			db.addCourseSemester(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadCourseSem(){
		try {
			db.loadCourseSem();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadCourseReg(ToolbarEvent te){
		String studentid = te.getSearch();
		try {
			db.loadCourseReg(studentid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createCourseSemester(String name){
		try {
			db.createcourseTable(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addcourseonstudent(String courseid,double credit){
		try {
			db.addcourseonstudent(courseid, credit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double getdebit(String id){
		try {
			return db.getdebit(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}
	public double getcredit(String id){
		try{
			return db.getcredit(id);
		} catch (SQLException e) {
			return 0;
		}
	}
	public double getbalance(String id){
		try {
			return db.getbalance(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}
	
	public void setStudentid(TopbarEvent e){
		String id = e.getId();
		try {
			db.setstudentid(id);
		} catch (SQLException e1) {
			System.out.println("Here it is");
		}
	}
	
	public String getStudentid() throws SQLException {
		return db.getStudentid();
		
		
	}
	
	public void loadAccounts(AccountPanelEvent e){
		String id = e.getStudentid();
		try {
			System.out.println("Problem");
			db.loadAccounts(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void loadAccounts(TopbarEvent e){
		String id = e.getId();
		try {
			System.out.println("Problem");
			db.loadAccounts(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void saveAccounts(AccountPanelEvent e){
		String studentid = e.getStudentid();
		String date  = e.getDate();
		String semester = e.getSemester();
		double debit = e.getDebit();
		double credit = e.getCredit();
		double balance = e.getBalance();
		try {
			db.saveAccounts(studentid, date, semester, debit, credit, balance);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void updateAccounts(AccountPanelEvent e){
		String studentid = e.getStudentid();
		String semester = e.getSemester();
		double debit = e.getDebit();
		double credit = e.getCredit();
		double balance = e.getBalance();
		try {
			db.updateAccount(studentid,semester, debit, credit, balance);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void loadCouresOnDept(String dept){
		try {
			db.searchCourseonDept(dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadStudentOnDept(String dept){
		try {
			db.searchStudent(dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFacultyOnDept(String dept){
		try {
			db.searchFaculty(dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
