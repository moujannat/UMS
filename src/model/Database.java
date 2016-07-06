package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Database {
	
	private ArrayList<Student> student;
    private ArrayList<Faculty> faculty;
    private ArrayList<Staff> staff;
    private ArrayList<Course> course;
    private ArrayList<Course> courseSem;
    private ArrayList<Course> courseReg;
    private ArrayList<Login> login;
    private ArrayList<Accounts> accounts;
    private String sqlsearch;
    private Connection con;
	private String studentdept;
	
	public Database(){
		student = new ArrayList<Student>();
        faculty = new ArrayList<Faculty>();
        staff = new ArrayList<Staff>();
        course = new ArrayList<Course>();
        login = new ArrayList<Login>();
        courseSem = new ArrayList<Course>();
        courseReg = new ArrayList<Course>();
        accounts = new ArrayList<Accounts>();
	}
	
	public void addAccounts(Accounts ac){
		accounts.add(ac);
	}
	
	public List<Accounts> getAccounts(){
        return accounts;
    }
	
	public void addLogin(Login ln){
		login.add(ln);
	}
	
	public List<Login> getLogin(){
		return login;
	}
	
    public void addStudent(Student std){
        student.add(std);
    }

    public List<Student> getStudent(){
        return student;
    }

    public void addFaculty(Faculty fl){
        faculty.add(fl);
    }

    public List<Faculty> getFaculty(){
        return faculty;
    }

    public void addStaff(Staff sf){
        staff.add(sf);
    }

    public List<Staff> getStaff(){
        return staff;
    }
    
    public void addCourse(Course sf){
        course.add(sf);
    }
    
    public void addCourseSem(Course sf){
        courseSem.add(sf);
    }

    public List<Course> getCourse(){
        return course;
    }
    
    public List<Course> getCourseSem(){
        return courseSem;
    }
    
    public void addCourseReg(Course sf){
        courseReg.add(sf);
    }

    public List<Course> getCourseReg(){
        return courseReg;
    }
	
	public void connect() throws Exception{
		
		if(con != null) return;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Driver not found");
		}
		
		String connectionUrl = "jdbc:mysql://localhost/ums";
		 con = DriverManager.getConnection(connectionUrl, "mostafij", "1001101");
		 
		 System.out.println("Connected: "+con);
		
	}
	public void disconnect(){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Can't close the connection");
			}
		}
	}
	
	public String login(String str1,String str2) throws SQLException{
		PreparedStatement ps = con.prepareStatement("select UserName,Password,id  from userlogin where UserName=? and Password=?");
        ps.setString(1, str1);
        ps.setString(2, str2);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
        	String username = rs.getString("UserName");
        	System.out.println(username);
        	String password = rs.getString("Password");
        	String id = rs.getString("id");
        	Login ln = new Login(username,password,id);
        	login.add(ln);
        	return "Connected";
        }
        else{
        	return "Wrong password Or User Name";
        }
	}
	

	public void saveStudent(String firstName,String lastName,String fatherName,String motherName,String gender,String dob,String homeAddress,String city,int postalCode,String country,String regDate,String semester,String id,String department,String status) throws SQLException{
		String fName= firstName ;
		String ltName= lastName;
		String faName= fatherName;
		String mName= motherName;
		String  g=gender;
		String  d=dob;
		String  h=homeAddress;
		String c=city;
		int  p=postalCode;
		String co= country;
		String  reg=regDate;
		String  sem=semester;
		String  i=id;
		String  dept=department;
		String  st=status;
		
		String insertsql = "INSERT INTO student (firstname ,lastname ,fathername ,mothername ,gender ,dob ,homeaddress ,city ,postalcode ,country ,regdate ,semester ,id ,department ,status)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?);";
		PreparedStatement insertStatement = con.prepareStatement(insertsql);
		
		int col = 1;
		insertStatement.setString(col++, fName);
		insertStatement.setString(col++,  ltName);
		insertStatement.setString(col++,  faName);
		insertStatement.setString(col++,  mName);
		insertStatement.setString(col++,  g);
		insertStatement.setString(col++,  d);
		insertStatement.setString(col++,  h);
		insertStatement.setString(col++,  c);
		insertStatement.setInt(col++,  p);
		insertStatement.setString(col++,  co);
		insertStatement.setString(col++,  reg);
		insertStatement.setString(col++,  sem);
		insertStatement.setString(col++,  i);
		insertStatement.setString(col++,  dept);
		insertStatement.setString(col++,  st);
		
		insertStatement.executeUpdate();
		
		
		insertStatement.close();
 	}
	
	////////////////////////////////////////////////////
	public void saveAccounts(String studentid,String date,String semester,double debit,double credit,double balance ) throws SQLException{
		String sid= studentid ;
		String d= date;
		String sem= semester;
		double de = debit;
		double c = credit;
		double b = balance;
		
		String insertsql = "INSERT INTO accounts (studentid ,date ,semester ,debit ,credit ,balance)VALUES (?, ?, ?, ?, ?, ? );";
		PreparedStatement insertStatement = con.prepareStatement(insertsql);
		
		int col = 1;
		insertStatement.setString(col++, sid);
		insertStatement.setString(col++,  d);
		insertStatement.setString(col++,  sem);
		insertStatement.setDouble(col++,  de);
		insertStatement.setDouble(col++,  c);
		insertStatement.setDouble(col++,  b);
		
		
		insertStatement.executeUpdate();
		
		
		insertStatement.close();
 	}
	
	public void updateAccount(String studentid,String semester,double debit,double credit,double balance ) throws SQLException{
		String sid= studentid ;
		String sem= semester;
		double de = debit;
		double c = credit;
		double b = balance;
		
		String insertsql = "UPDATE account SET semester='"+sem+"',debit="+de+",credit="+c+",balance="+b+" WHERE studentid='"+sid+"';";
		PreparedStatement insertStatement = con.prepareStatement(insertsql);
		
		insertStatement.executeUpdate();
		
		
		insertStatement.close();
 	}
	
	public void loadAccounts(String stid) throws SQLException{
		accounts.clear();
		String gstudentid = stid;
		String insertsql = "select studentid ,date ,semester ,debit,credit ,balance from accounts where studentid = '"+gstudentid+"';";
		Statement statement = con.createStatement();
		
		ResultSet results = statement.executeQuery(insertsql);
		
		while(results.next()){
			 String studentid = results.getString("studentid");
			 String date = results.getString("date");
			 String semester = results.getString("semester");
			 double debit = results.getDouble("debit");
			 double credit = results.getDouble("credit");
			 double balance = results.getDouble("balance");
			 
			 Accounts ac = new Accounts(studentid, date, semester, debit, credit, balance);
			 accounts.add(ac);
		}
		results.close();
		statement.close();
 	}
	/////////////////////////////////////////////////////

	public void saveFaculty(String firstName,String lastName,String fatherName,String motherName,String gender,String dob,String homeAddress,String city,int postalCode,String country,String entrydate,String designation,String id,String department,String status) throws SQLException{
		String fName= firstName ;
		String ltName= lastName;
		String faName= fatherName;
		String mName= motherName;
		String  g=gender;
		String  d=dob;
		String  h=homeAddress;
		String c=city;
		int  p=postalCode;
		String co= country;
		String  entry=entrydate;
		String  des=designation;
		String  i=id;
		String  dept=department;
		String  st=status;
		
		String insertsql = "INSERT INTO faculty (firstname ,lastname ,fathername ,mothername ,gender ,dob ,homeaddress ,city ,postalcode ,country ,entrydate ,designation ,id ,department ,status)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?);";
		PreparedStatement insertStatement = con.prepareStatement(insertsql);
		
		int col = 1;
		insertStatement.setString(col++, fName);
		insertStatement.setString(col++,  ltName);
		insertStatement.setString(col++,  faName);
		insertStatement.setString(col++,  mName);
		insertStatement.setString(col++,  g);
		insertStatement.setString(col++,  d);
		insertStatement.setString(col++,  h);
		insertStatement.setString(col++,  c);
		insertStatement.setInt(col++,  p);
		insertStatement.setString(col++,  co);
		insertStatement.setString(col++,  entry);
		insertStatement.setString(col++,  des);
		insertStatement.setString(col++,  i);
		insertStatement.setString(col++,  dept);
		insertStatement.setString(col++,  st);
		
		insertStatement.executeUpdate();
		
		insertStatement.close();
	}


	public void saveStaff(String firstName,String lastName,String fatherName,String motherName,String gender,String dob,String homeAddress,String city,int postalCode,String country,String entrydate,String designation,String id,String department,String status) throws SQLException{
		String fName= firstName ;
		String ltName= lastName;
		String faName= fatherName;
		String mName= motherName;
		String  g=gender;
		String  d=dob;
		String  h=homeAddress;
		String c=city;
		int  p=postalCode;
		String co= country;
		String  entry=entrydate;
		String  des=designation;
		String  i=id;
		String  dept=department;
		String  st=status;
		
		String insertsql = "INSERT INTO staff (firstname ,lastname ,fathername ,mothername ,gender ,dob ,homeaddress ,city ,postalcode ,country ,entrydate ,designation ,id ,department ,status)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?);";
		PreparedStatement insertStatement = con.prepareStatement(insertsql);
		
		int col = 1;
		insertStatement.setString(col++, fName);
		insertStatement.setString(col++,  ltName);
		insertStatement.setString(col++,  faName);
		insertStatement.setString(col++,  mName);
		insertStatement.setString(col++,  g);
		insertStatement.setString(col++,  d);
		insertStatement.setString(col++,  h);
		insertStatement.setString(col++,  c);
		insertStatement.setInt(col++,  p);
		insertStatement.setString(col++,  co);
		insertStatement.setString(col++,  entry);
		insertStatement.setString(col++,  des);
		insertStatement.setString(col++,  i);
		insertStatement.setString(col++,  dept);
		insertStatement.setString(col++,  st);
		
		insertStatement.executeUpdate();
		
		insertStatement.close();
 	}
	
	public void saveCourse(String coursediscription,String code,double credit,String dept,String prequsite,String fdept) throws SQLException{
	
		String cd = coursediscription;
		String co = code;
		double cr = credit;
		String d = dept;
		String pre = prequsite;
		String fd = fdept;
		String s = "available";
		
		String insertsql = "INSERT INTO course (coursedescription ,code ,credit ,dept ,prerequsite ,fdept,status)VALUES (?, ?, ?, ?, ?, ?,?);";
		PreparedStatement insertStatement = con.prepareStatement(insertsql);
		
		int col = 1;
		insertStatement.setString(col++, cd);
		insertStatement.setString(col++,  co);
		insertStatement.setDouble(col++,  cr);
		insertStatement.setString(col++,  d);
		insertStatement.setString(col++,  pre);
		insertStatement.setString(col++,  fd);
		insertStatement.setString(col++,  s);
		insertStatement.executeUpdate();
		
		insertStatement.close();
	}
	

	
	public void saveSemester(String name) throws SQLException{
		String semester = name;
		String status = "active";
		String insertSql = "UPDATE semester SET status = 'end' WHERE status = 'active';";
		PreparedStatement insertStatement = con.prepareStatement(insertSql);
		insertStatement.executeUpdate();
		
		insertSql = "UPDATE course SET status = 'available' where status = 'unavailable'";
		 insertStatement = con.prepareStatement(insertSql);
		insertStatement.executeUpdate();
		
		insertSql = "INSERT INTO semester(name,status) VALUES (?,?);";
		insertStatement = con.prepareStatement(insertSql);
		insertStatement.setString(1, semester);
		insertStatement.setString(2, status);
		insertStatement.executeUpdate();
		String[] splitval = name.split(" ");
		String[] second = splitval[1].split("-");
		String semestertablename = new String(splitval[0]+second[0]+second[1]);
		String cretestatement =  "create table "+semestertablename+" (semester varchar(15) null,courseid varchar(20));";
		insertStatement = con.prepareStatement(cretestatement);
		insertStatement.executeUpdate();
		insertStatement.close();
	}

	public void loadStudent() throws SQLException{
		student.clear();
		
		String sql = "select firstname ,lastname ,fathername ,mothername ,gender ,dob ,homeaddress ,city ,postalcode ,country ,regdate ,semester ,id ,department ,status from student order by id desc";
		Statement statement = con.createStatement();
		
		ResultSet results = statement.executeQuery(sql);
		
		while(results.next()){
			String firstName = results.getString("firstName");
			String lastName = results.getString("lastName");
			String fatherName = results.getString("fatherName");
			String motherName =results.getString("motherName");
			String gender =results.getString("gender");
			String dob = results.getString("dob");
			String homeAddress = results.getString("homeAddress");
			String city = results.getString("city");
			int postalCode = results.getInt("postalCode");
			String country = results.getString("country");
			String regDate = results.getString("regDate");
			String semester = results.getString("semester");
			String id = results.getString("id");
			String department = results.getString("department");
			String status = results.getString("status");
			
			//System.out.println(firstName);
			
			Student st = new Student(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, regDate, semester, id, department, status);
			student.add(st);
			
		}
		
		results.close();
		statement.close();
	}
	
	public void loadStaff() throws SQLException{
		staff.clear();
		
		String sql = "select firstname ,lastname ,fathername ,mothername ,gender ,dob ,homeaddress ,city ,postalcode ,country ,entrydate ,designation ,id ,department ,status from staff order by id desc";
		Statement statement = con.createStatement();
		
		ResultSet results = statement.executeQuery(sql);
		
		while(results.next()){
			String firstName = results.getString("firstName");
			String lastName = results.getString("lastName");
			String fatherName = results.getString("fatherName");
			String motherName =results.getString("motherName");
			String gender =results.getString("gender");
			String dob = results.getString("dob");
			String homeAddress = results.getString("homeAddress");
			String city = results.getString("city");
			int postalCode = results.getInt("postalCode");
			String country = results.getString("country");
			String entryDate = results.getString("entryDate");
			String designation = results.getString("designation");
			String id = results.getString("id");
			String department = results.getString("department");
			String status = results.getString("status");
			
			//System.out.println(firstName);
			
			Staff st = new Staff(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, entryDate, designation, id, department, status);
			staff.add(st);
			
		}
		
		results.close();
		statement.close();
	}
	
	public void loadFaculty() throws SQLException{
		faculty.clear();
		
		String sql = "select firstname ,lastname ,fathername ,mothername ,gender ,dob ,homeaddress ,city ,postalcode ,country ,entrydate ,designation ,id ,department ,status from faculty order by id desc";
		Statement statement = con.createStatement();
		
		ResultSet results = statement.executeQuery(sql);
		
		while(results.next()){
			String firstName = results.getString("firstName");
			String lastName = results.getString("lastName");
			String fatherName = results.getString("fatherName");
			String motherName =results.getString("motherName");
			String gender =results.getString("gender");
			String dob = results.getString("dob");
			String homeAddress = results.getString("homeAddress");
			String city = results.getString("city");
			int postalCode = results.getInt("postalCode");
			String country = results.getString("country");
			String entryDate = results.getString("entryDate");
			String designation = results.getString("designation");
			String id = results.getString("id");
			String department = results.getString("department");
			String status = results.getString("status");
			
			//System.out.println(firstName);
			
			Faculty fa = new Faculty(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, entryDate, designation, id, department, status);
			faculty.add(fa);
			
		}
		
		results.close();
		statement.close();
	}
	
	public void loadCourse() throws SQLException{
		course.clear();
		
		String sql = "select coursedescription ,code ,credit ,dept ,prerequsite ,fdept from course order by dept;";
		Statement statement = con.createStatement();
		
		ResultSet results = statement.executeQuery(sql);
		
		while(results.next()){
			String coursedescription = results.getString("coursedescription");
			String code = results.getString("code");
			double credit = results.getDouble("credit");
			String dept =results.getString("dept");
			String prerequsite =results.getString("prerequsite");
			String fdept = results.getString("fdept");
			
			
			//System.out.println(coursedescription);
			
			Course cr = new Course(coursedescription, code, credit, dept, prerequsite, fdept);
			course.add(cr);
			}
		results.close();
		statement.close();
		}
	
	public void loadCourseReg(String studentid) throws SQLException{
		courseReg.clear();
		
		String idnumber = studentid;
		String insertSql = "UPDATE studentid SET studentid = '"+idnumber+"' WHERE status = 'active';";
		PreparedStatement insertStatement = con.prepareStatement(insertSql);
		insertStatement.executeUpdate();
		
		String id = studentid;
		String id1[] = id.split("-");
		String getedid = new String("student"+id1[1]);
		int number = searchstudentcount(getedid);
		System.out.println(number);
		String semester = semester();
		String sem[] = semester.split(" ");
		String sem1[] = sem[1].split("-");
		String getedsemester = new String(sem[0]+sem1[0]+sem1[1]);
		toLowerCase(getedsemester);
		
		sqlsearch = "select department from student where id  = '"+id+"';";
		Statement statement = con.createStatement();
		ResultSet results = statement.executeQuery(sqlsearch);
		while(results.next())
			 studentdept = results.getString("department");
		
		
		if(number!=0){
			String sqlid = "select courseid from "+getedid+";";
			String iccourse[] = new String[100];
			//statement = con.createStatement();
			results = statement.executeQuery(sqlid);
			int col=0;
			while(results.next()){
				String idc = results.getString("courseid");
				iccourse[col++] = idc;
			}
			
			sqlsearch = "select coursedescription ,code ,credit ,dept ,prerequsite ,fdept from course where status ='unavailable' and fdept='"+studentdept+"';";
			 statement = con.createStatement();
			
			 results = statement.executeQuery(sqlsearch);
			
			while(results.next()){
				//System.out.println("######################");
				String coursedescription = results.getString("coursedescription");
				String code = results.getString("code");
				double credit = results.getDouble("credit");
				String dept =results.getString("dept");
				String prerequsite =results.getString("prerequsite");
				String fdept = results.getString("fdept");
				String t = "ok";
				for(int i=0;i<col;i++){
					System.out.println(iccourse[i]);
					if(code.equals(iccourse[i])){
						t="not";
						break;
						}
					
					}
				System.out.println("######################");
				System.out.println(t);
				if(t=="ok"){
					for(int i=0;i<col;i++){
						if(prerequsite.equals(iccourse[i]) || prerequsite.equals("none")){
						Course cr = new Course(coursedescription, code, credit, dept, prerequsite, fdept);
						courseReg.add(cr);
						}
					}
				}
				
				
				//System.out.println(coursedescription);
				//System.out.println(coursedescription);
				
				//Course cr = new Course(coursedescription, code, credit, dept, prerequsite, fdept);
				//courseReg.add(cr);
				}
		
		}
		else{
			String sqlsearchb = "select coursedescription ,code ,credit ,dept ,prerequsite ,fdept from course where status ='unavailable' and fdept='"+studentdept+"'and prerequsite='none' ;";
			Statement statementn = con.createStatement();
			
			ResultSet resultsw = statementn.executeQuery(sqlsearchb);
			
			while(resultsw.next()){
				String coursedescription = resultsw.getString("coursedescription");
				String code = resultsw.getString("code");
				double credit = resultsw.getDouble("credit");
				String dept =resultsw.getString("dept");
				String prerequsite =resultsw.getString("prerequsite");
				String fdept = resultsw.getString("fdept");
				
				System.out.println(coursedescription);
				//System.out.println(coursedescription);
				
				Course cr = new Course(coursedescription, code, credit, dept, prerequsite, fdept);
				courseReg.add(cr);
				}
		}
		
		/*if(number != 0){
		 sqlsearch = "select c.coursedescription ,c.code ,c.credit ,c.dept ,c.prerequsite ,c.fdept from course as c,"+getedid+" as st,"+tablesemester+" as s where c.code = s.courseid and (c.prerequsite = st.courseid or c.prerequsite='none') and s.courseid <> st.courseid and c.fdept='"+studentdept+"' ;";
		}
		else{
			sqlsearch = "select c.coursedescription ,c.code ,c.credit ,c.dept ,c.prerequsite ,c.fdept from course as c,"+tablesemester+" as s where c.code=s.courseid and c.prerequsite='none' and c.fdept='"+studentdept+"';";
		}*/
		
		results.close();
		statement.close();
		}
		
		public void loadCourseSem() throws SQLException{
			courseSem.clear();
			
			String sql = "select coursedescription ,code ,credit ,dept ,prerequsite ,fdept from course where status = 'available';";
			Statement statement = con.createStatement();
			
			ResultSet results = statement.executeQuery(sql);
			
			while(results.next()){
				String coursedescription = results.getString("coursedescription");
				String code = results.getString("code");
				double credit = results.getDouble("credit");
				String dept =results.getString("dept");
				String prerequsite =results.getString("prerequsite");
				String fdept = results.getString("fdept");
				
				System.out.println(coursedescription);
				
				Course cr = new Course(coursedescription, code, credit, dept, prerequsite, fdept);
				courseSem.add(cr);
				
			}
		
		results.close();
		statement.close();
	}
		
		public void searchCourseonDept(String search) throws SQLException{
			course.clear();
			String deptt = search;
			String sql = "select coursedescription ,code ,credit ,dept ,prerequsite ,fdept from course where dept='"+deptt+"';";
			Statement statement = con.createStatement();
			
			ResultSet results = statement.executeQuery(sql);
			
			while(results.next()){
				String coursedescription = results.getString("coursedescription");
				String code = results.getString("code");
				double credit = results.getDouble("credit");
				String dept =results.getString("dept");
				String prerequsite =results.getString("prerequsite");
				String fdept = results.getString("fdept");
				
				System.out.println(coursedescription);
				
				Course cr = new Course(coursedescription, code, credit, dept, prerequsite, fdept);
				course.add(cr);
				
			}
		
		results.close();
		statement.close();
	}
	
	public void cgpaCount(String id){
		String splitid = id;
		String[] splitval = splitid.split("-");
		String tablename = new String("student"+splitval[1]);
		System.out.println(tablename);
		
	}
	
	public void searchStudent(String search) throws SQLException{
		student.clear();
		String studentserach = search;
		String sql = "select firstname ,lastname ,fathername ,mothername ,gender ,dob ,homeaddress ,city ,postalcode ,country ,regdate ,semester ,id ,department ,status from student where id = '"+studentserach+"' or department='"+studentserach+"' or country='"+studentserach+"' or firstname='"+studentserach+"' or lastname='"+studentserach+"' or mothername='"+studentserach+"' or gender='"+studentserach+"' or dob='"+studentserach+"' or city='"+studentserach+"';";
		Statement statement = con.createStatement();
		
		ResultSet results = statement.executeQuery(sql);
		
		while(results.next()){
			String firstName = results.getString("firstName");
			String lastName = results.getString("lastName");
			String fatherName = results.getString("fatherName");
			String motherName =results.getString("motherName");
			String gender =results.getString("gender");
			String dob = results.getString("dob");
			String homeAddress = results.getString("homeAddress");
			String city = results.getString("city");
			int postalCode = results.getInt("postalCode");
			String country = results.getString("country");
			String regDate = results.getString("regDate");
			String semester = results.getString("semester");
			String id = results.getString("id");
			String department = results.getString("department");
			String status = results.getString("status");
			System.out.println(id);
			cgpaCount(id);
			//System.out.println(firstName);
			
			Student st = new Student(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, regDate, semester, id, department, status);
			student.add(st);
			
		}
		
		results.close();
		statement.close();
	}
	
	public void searchStudentonDept(String dept) throws SQLException{
		student.clear();
		String depar= dept;
		String sql = "select firstname ,lastname ,fathername ,mothername ,gender ,dob ,homeaddress ,city ,postalcode ,country ,regdate ,semester ,id ,department ,status from student where department='"+depar+"';";
		Statement statement = con.createStatement();
		
		ResultSet results = statement.executeQuery(sql);
		
		while(results.next()){
			String firstName = results.getString("firstName");
			String lastName = results.getString("lastName");
			String fatherName = results.getString("fatherName");
			String motherName =results.getString("motherName");
			String gender =results.getString("gender");
			String dob = results.getString("dob");
			String homeAddress = results.getString("homeAddress");
			String city = results.getString("city");
			int postalCode = results.getInt("postalCode");
			String country = results.getString("country");
			String regDate = results.getString("regDate");
			String semester = results.getString("semester");
			String id = results.getString("id");
			String department = results.getString("department");
			String status = results.getString("status");
			System.out.println(id);
			cgpaCount(id);
			//System.out.println(firstName);
			
			Student st = new Student(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, regDate, semester, id, department, status);
			student.add(st);
			
		}
		
		results.close();
		statement.close();
	}
	
	public void searchFaculty(String search) throws SQLException{
		faculty.clear();
		String searchFaculty = search;
		String sql = "select firstname ,lastname ,fathername ,mothername ,gender ,dob ,homeaddress ,city ,postalcode ,country ,entrydate ,designation ,id ,department ,status from faculty where firstname='"+searchFaculty+"' or lastname='"+searchFaculty+"' or gender='"+searchFaculty+"' or dob='"+searchFaculty+"' or city='"+searchFaculty+"' or country='"+searchFaculty+"' or entrydate='"+searchFaculty+"' or designation='"+searchFaculty+"' or id='"+searchFaculty+"' or department='"+searchFaculty+"';";
		Statement statement = con.createStatement();
		
		ResultSet results = statement.executeQuery(sql);
		
		while(results.next()){
			String firstName = results.getString("firstName");
			String lastName = results.getString("lastName");
			String fatherName = results.getString("fatherName");
			String motherName =results.getString("motherName");
			String gender =results.getString("gender");
			String dob = results.getString("dob");
			String homeAddress = results.getString("homeAddress");
			String city = results.getString("city");
			int postalCode = results.getInt("postalCode");
			String country = results.getString("country");
			String entryDate = results.getString("entryDate");
			String designation = results.getString("designation");
			String id = results.getString("id");
			String department = results.getString("department");
			String status = results.getString("status");
			
			//System.out.println(firstName);
			
			Faculty fa = new Faculty(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, entryDate, designation, id, department, status);
			faculty.add(fa);
		}
		results.close();
		statement.close();	
	}
	
	public void searchFacultyonDept(String search) throws SQLException{
		faculty.clear();
		String dept = search;
		String sql = "select firstname ,lastname ,fathername ,mothername ,gender ,dob ,homeaddress ,city ,postalcode ,country ,entrydate ,designation ,id ,department ,status from faculty where department'"+dept+"';";
		Statement statement = con.createStatement();
		
		ResultSet results = statement.executeQuery(sql);
		
		while(results.next()){
			String firstName = results.getString("firstName");
			String lastName = results.getString("lastName");
			String fatherName = results.getString("fatherName");
			String motherName =results.getString("motherName");
			String gender =results.getString("gender");
			String dob = results.getString("dob");
			String homeAddress = results.getString("homeAddress");
			String city = results.getString("city");
			int postalCode = results.getInt("postalCode");
			String country = results.getString("country");
			String entryDate = results.getString("entryDate");
			String designation = results.getString("designation");
			String id = results.getString("id");
			String department = results.getString("department");
			String status = results.getString("status");
			
			//System.out.println(firstName);
			
			Faculty fa = new Faculty(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, entryDate, designation, id, department, status);
			faculty.add(fa);
		}
		results.close();
		statement.close();	
	}
		
		public void searchStaff(String search) throws SQLException{
			staff.clear();
			String searchStaff = search;
			String sql = "select firstname ,lastname ,fathername ,mothername ,gender ,dob ,homeaddress ,city ,postalcode ,country ,entrydate ,designation ,id ,department ,status from staff where firstname='"+searchStaff+"' or lastname='"+searchStaff+"' or gender='"+searchStaff+"' or dob='"+searchStaff+"' or city='"+searchStaff+"' or country='"+searchStaff+"' or entrydate='"+searchStaff+"' or designation='"+searchStaff+"' or id='"+searchStaff+"' or department='"+searchStaff+"';";
			Statement statement = con.createStatement();
			
			ResultSet results = statement.executeQuery(sql);
			
			while(results.next()){
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				String fatherName = results.getString("fatherName");
				String motherName =results.getString("motherName");
				String gender =results.getString("gender");
				String dob = results.getString("dob");
				String homeAddress = results.getString("homeAddress");
				String city = results.getString("city");
				int postalCode = results.getInt("postalCode");
				String country = results.getString("country");
				String entryDate = results.getString("entryDate");
				String designation = results.getString("designation");
				String id = results.getString("id");
				String department = results.getString("department");
				String status = results.getString("status");
				
				//System.out.println(firstName);
				
				Staff st = new Staff(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, entryDate, designation, id, department, status);
				staff.add(st);
				
			}
			
		
		results.close();
		statement.close();
	}
	
	public void addCourseSemester(String name) throws SQLException{
		String courseid = name;
		
			String sem = semester();
			
			String tsem[] = sem.split(" ");
			String rsem[] = tsem[1].split("-");
			String tableName = new String(tsem[0]+rsem[0]+rsem[1]);
			
			/////////////////////////////////////////
			String insertsql = "INSERT INTO "+tableName+" (semester,courseid )VALUES (?, ?);";
			PreparedStatement insertStatement = con.prepareStatement(insertsql);
			
			insertStatement.setString(1, sem);
			insertStatement.setString(2, courseid);
			
			insertStatement.executeUpdate();
			
			 insertsql = "UPDATE course SET status = 'unavailable' where code = '"+courseid+"';";
			 insertStatement = con.prepareStatement(insertsql);
			insertStatement.executeUpdate();
			
			insertStatement.close();
			///////////////////////////////////////
			//System.out.println(coursedescription);
			
			
		}
		
	
	public int studentcount() throws SQLException{
		String checkSql = "select count(*) from student";
		PreparedStatement ps = con.prepareStatement(checkSql);
		
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		int number = resultSet.getInt(1);
		return number;
		
	}
	
	public int searchstudentcount(String name) throws SQLException{
		String checkSql = "select count(*) from "+name+";";
		PreparedStatement ps = con.prepareStatement(checkSql);
		
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		int number = resultSet.getInt(1);
		return number;
		
	}
	
	public int facultycount() throws SQLException{
		String checkSql = "select count(*) from faculty";
		PreparedStatement ps = con.prepareStatement(checkSql);
		
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		int number = resultSet.getInt(1);
		return number;
		
	}
	
	public int staffcount() throws SQLException{
		String checkSql = "select count(*) from staff";
		PreparedStatement ps = con.prepareStatement(checkSql);
		
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		int number = resultSet.getInt(1);
		return number;
		
	}
	
	public String semester() throws SQLException {
		String checkSql = "select name from semester where status =?;";
		PreparedStatement ps;
		
			ps = con.prepareStatement(checkSql);
		
			ps.setString(1, "active");
		
		ResultSet resultSet;
	
			resultSet = ps.executeQuery();
		
		resultSet.next();
		String semester = resultSet.getString(1);
		return semester;
		
	}
	
	public void createStudentTable(String name) throws SQLException{
		 Statement smt = con.createStatement();
		 
		String checkSql = "create table "+name+" (studentid varchar(15) null,semester varchar(20) null,courseid varchar(15) null,credit double null,result double null,PRIMARY KEY(courseid));";
		smt.executeUpdate(checkSql);
		smt.close();
		
	}
	
	public void createcourseTable(String name) throws SQLException{
		String semester = semester();
		String sem1[] = semester.split(" ");
		String sem2[] = sem1[1].split("-");
		String tabllname = new String(sem1[0]+sem2[0]+sem2[1]+name);
		 Statement smt = con.createStatement();
		 
		String checkSql = "create table "+tabllname+" (studentid varchar(15) null,semester varchar(20) null,courseid varchar(15) null,credit double null,mid double null,final double null,result double null);";
		smt.executeUpdate(checkSql);
		smt.close();
		
	}
	
	public String regid() throws SQLException {
		String checkSql = "select studentid from studentid where status =?;";
		PreparedStatement ps;
		
			ps = con.prepareStatement(checkSql);
		
			ps.setString(1, "active");
		
		ResultSet resultSet;
	
			resultSet = ps.executeQuery();
		
		resultSet.next();
		String studentid = resultSet.getString(1);
		return studentid;
		
	}
	
	public void studentaccounts(String studentid,String semester) throws SQLException{
		String checkSql = "select count(*) from account where studentid = ? ";
		PreparedStatement ps = con.prepareStatement(checkSql);
		ps.setString(1, studentid);
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		int number = resultSet.getInt(1);
		System.out.println(number);
		if(number == 0){
			String insertsql = "INSERT INTO account(studentid,semester,debit,credit,balance)VALUES (?,?,?,?,?);";
			ps = con.prepareStatement(insertsql);
			ps.setString(1, studentid);
			ps.setString(2, semester);
			ps.setDouble(3, 0.0);
			ps.setDouble(4, 0.0);
			ps.setDouble(5, 0.0);
			ps.executeUpdate();
		}
	}
	
	public void addcourseonstudent(String courseid,double coursecredit) throws SQLException{
		String studentid = regid();
		//String course = courseid;
		String semester = semester();
		double ccredit = coursecredit;
		studentaccounts(studentid,semester);
		String sql = "select debit,balance from accounts where studentid = ? and semester = ?;";
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, studentid);
		ps.setString(2, semester);
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		double debit = resultSet.getDouble(1);
		double balance = resultSet.getDouble(2);
		
		String splitstudent[] = studentid.split("-");
		String tablename = new String("student"+splitstudent[1]);
		
		sql = "INSERT INTO "+tablename+" (studentid,semester,courseid,credit,result)VALUES (?,?,?,?,?);";
		ps = con.prepareStatement(sql);
		ps.setString(1, studentid);
		ps.setString(2, semester);
		ps.setString(3, courseid);
		ps.setDouble(4, ccredit);
		ps.setDouble(5, 0.0);
		ps.executeUpdate();
		
		debit = debit+(ccredit*4000);
		balance = balance+(ccredit*4000);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		dateFormat.format(cal.getTime());
		
		String s = courseid;
		String sem[] = semester.split(" ");
		String sem2[] = sem[1].split("-");
		String coursename = new String(sem[0]+sem2[0]+sem2[1]+s);
		String courseName = toLowerCase(coursename);
		sql = "INSERT INTO "+courseName+" (studentid,semester,courseid,credit,mid,final,result)VALUES (?,?,?,?,?,?,?);";
		ps = con.prepareStatement(sql);
		ps.setString(1, studentid);
		ps.setString(2, semester);
		ps.setString(3, courseid);
		ps.setDouble(4, ccredit);
		ps.setDouble(5, 0.0);
		ps.setDouble(6, 0.0);
		ps.setDouble(7, 0.0);
		ps.executeUpdate();
		
		sql = "UPDATE account SET debit="+debit+" ,balance = "+balance+" where studentid = '"+studentid+"' and semester = '"+semester+"';";
		ps = con.prepareStatement(sql);
		ps.executeUpdate();
		
	}
	
	public String toLowerCase(String inputString){
		String lower = "";
		for(int i=0;i<inputString.length();i++){
			char cp = inputString.charAt(i);
			char c = Character.toLowerCase(cp);
			lower = lower+c;
		}
		return lower;
	}
	
	public double getdebit(String studentid) throws SQLException{
		String sql = "select debit from account where studentid = ?;";
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, studentid);
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		double debit = resultSet.getDouble(1);
		
		return debit;
	}
	
	public double getcredit(String studentid) throws SQLException{
		String sql = "select credit from account where studentid = ?;";
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, studentid);
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		double credit = resultSet.getDouble(1);
		
		return credit;
	}
	
	public double getbalance(String studentid) throws SQLException{
		String sql = "select balance from account where studentid = ?;";
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, studentid);
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		double balance = resultSet.getDouble(1);
		
		return balance;
	}
	
	public void setstudentid(String studentid) throws SQLException{
		String insertSql = "UPDATE studentid SET studentid = '"+studentid+"' WHERE status = 'active';";
		PreparedStatement insertStatement = con.prepareStatement(insertSql);
		insertStatement.executeUpdate();
	} 
	
	public String getStudentid() throws SQLException{
		String sql = "select studentid from studentid where status='active';";
		PreparedStatement ps =con.prepareStatement(sql);
		ResultSet resultSet = ps.executeQuery();
		System.out.println("ok");
		resultSet.next();
		String id = resultSet.getString(1);
		
		return id;
	}
	
	

}
