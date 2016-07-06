package model;

public class Accounts {
	private String studentid;
	private String date;
	private String semester;
	private double debit;
	private double credit;
	private double balance;
	public Accounts() {
		// TODO Auto-generated constructor stub
	}
	
	public Accounts(String studentid,String date,String semester,double debit,double credit,double balance) {
		this.studentid = studentid;
		this.date = date;
		this.semester = semester;
		this.debit = debit;
		this.credit = credit;
		this.balance = balance;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	
}
