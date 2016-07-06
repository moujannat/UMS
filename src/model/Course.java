package model;

public class Course {
	private String coursediscription;
	private String code;
	private double credit;
	private String dept;
	private String prequsite;
	private String fdept;
	public Course(){
		//.........default
	}
	public Course(String coursedescription,String code,double credit,String dept,String prerequsite,String fdept){
		this.coursediscription = coursedescription;
		this.code = code;
		this.credit = credit;
		this.dept = dept;
		this.prequsite = prerequsite;
		this.fdept = fdept;
	}
	public String getCoursediscription() {
		return coursediscription;
	}
	public void setCoursediscription(String coursediscription) {
		this.coursediscription = coursediscription;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPrequsite() {
		return prequsite;
	}
	public void setPrequsite(String prequsite) {
		this.prequsite = prequsite;
	}
	public String getFdept() {
		return fdept;
	}
	public void setFdept(String fdept) {
		this.fdept = fdept;
	}
	
	
}
