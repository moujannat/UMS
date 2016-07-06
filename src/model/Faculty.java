package model;

public class Faculty {
	
	private String firstName;
	private String lastName;
	private String fatherName;
	private String motherName;
	private String gender;
	private String dob;
	private String homeAddress;
	private String city;
	private int postalCode;
	private String country;
	private String entryDate;
	private String designation;
	private String id;
	private String department;
	private String status;
	
	public Faculty(String firstName,String lastName,String fatherName,String motherName,String gender,String dob,String homeAddress,String city,int postalCode,
			       String country, String entryDate,String designation,String id,String department,String status){
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.gender = gender;
		this.dob = dob;
		this.homeAddress = homeAddress;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.entryDate = entryDate;
		this.designation = designation;
		this.id = id;
		this.department = department;
		this.status = status;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getentryDate() {
		return entryDate;
	}
	public void setentryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getdesignation() {
		return designation;
	}
	public void setdesignation(String designation) {
		this.designation = designation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	


}
