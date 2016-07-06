package view.mainWindow.academic.addCourse;

import java.util.EventObject;

public class CoursePanelEvent extends EventObject{

	private static final long serialVersionUID = 1L;
	private String coursediscription;
	private String code;
	private double credit;
	private String dept;
	private String prequsite;
	private String fdept;
	
	public CoursePanelEvent(Object source) {
		super(source);
	}
	
	public CoursePanelEvent(Object source,String coursediscription,String code,double credit,String dept,String prequsite,String fdept) {
		super(source);
		
		this.coursediscription = coursediscription;
		this.code = code;
		this.credit = credit;
		this.dept = dept;
		this.prequsite = prequsite;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
