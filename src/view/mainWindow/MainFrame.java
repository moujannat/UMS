package view.mainWindow;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import model.Database;
import controller.Controller;
import view.mainWindow.academic.AcademicFrame;
import view.mainWindow.accounts.AccountsFarme;
import view.mainWindow.department.facultyOfEngineering.CourseTableModel;
import view.mainWindow.department.facultyOfEngineering.CourseTablePanel;
import view.mainWindow.department.facultyOfEngineering.FacultyTableModel;
import view.mainWindow.department.facultyOfEngineering.FacultyTablePanel;
import view.mainWindow.department.facultyOfEngineering.StudentTableModel;
import view.mainWindow.department.facultyOfEngineering.StudentTablePanel;
import view.mainWindow.faculty.FacultyFrame;
import view.mainWindow.home.HomeFrame;
import view.mainWindow.home.student.CreateStudentPanel;
import view.mainWindow.registration.RegistrationForm;
import view.mainWindow.staff.StaffFrame;


public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private HomeFrame homeFrame;
	private AcademicFrame academicFrame;
	private view.mainWindow.student.StudentFrame studentFrame;
	private RegistrationForm registrationForm;
	private AccountsFarme accountsFarme;
	private FacultyFrame facultyFrame;
	private view.mainWindow.department.facultyOfEngineering.FacultyTablePanel facultyEE;
	private view.mainWindow.department.facultyOfEngineering.FacultyTableModel facultymodelEE;
	private view.mainWindow.department.facultyOfEngineering.StudentTablePanel studentEE;
	private view.mainWindow.department.facultyOfEngineering.StudentTableModel studentmodelEE;
	private view.mainWindow.department.facultyOfEngineering.CourseTablePanel courseEE;
	private view.mainWindow.department.facultyOfEngineering.CourseTableModel courseModelEE;
	private StaffFrame staffFrame;
	private CreateStudentPanel csp;
	private Controller controller;
	public CardLayout cards;
	
	public MainFrame(){
		super("University Management System");
		
		cards = new CardLayout();
		
		homeFrame = new HomeFrame();
		academicFrame = new AcademicFrame();
		studentFrame = new view.mainWindow.student.StudentFrame();
		registrationForm = new RegistrationForm();
		csp = new CreateStudentPanel();
		accountsFarme = new AccountsFarme();
		facultyFrame = new FacultyFrame();
		staffFrame = new StaffFrame();
		
		controller = new Controller();
		
		////////////////////////////////////
		courseEE = new view.mainWindow.department.facultyOfEngineering.CourseTablePanel();
		studentEE = new view.mainWindow.department.facultyOfEngineering.StudentTablePanel();
		facultyEE = new view.mainWindow.department.facultyOfEngineering.FacultyTablePanel();
		
		courseModelEE = new view.mainWindow.department.facultyOfEngineering.CourseTableModel();
		studentmodelEE = new view.mainWindow.department.facultyOfEngineering.StudentTableModel();
		facultymodelEE = new view.mainWindow.department.facultyOfEngineering.FacultyTableModel();
		///////////////////////////////////
		
		//new StudentFrame();
		
		//setResizable(false);
		
		setLocation(0, 0);
		
		setLayout(cards);
	
		
		setJMenuBar(createMenuBar());
		
		
		//add(homeFrame,"home");
		add(homeFrame,"home");
		add(academicFrame,"academic");
		add(studentFrame,"student");
		add(registrationForm,"registration");
		add(accountsFarme,"accounts");
		add(facultyFrame,"faculty");
		add(staffFrame,"staff");
		add(courseEE,"eeecourse");
		add(studentEE,"eeestudents");
		add(facultyEE,"eeefaculty");
		setLocation(200, 100);
		
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setSize(1050, 590);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private JMenuBar createMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		
		JMenu homeMenu = new JMenu("Home");
		homeMenu.addMenuListener(new MenuListener() {
			
			public void menuSelected(MenuEvent arg0) {
				csp.setVisible(false);
				csp = new CreateStudentPanel();
				cards.show(MainFrame.this.getContentPane(), "home");
				
			}
			
			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenu academicMenu = new JMenu("Academic");
		
		//JMenuItem acashow = new JMenuItem("Show");
		//JMenuItem acacreate= new JMenuItem("Create");
		
		academicMenu.addMenuListener(new MenuListener() {
			
			public void menuSelected(MenuEvent arg0) {
				cards.show(MainFrame.this.getContentPane(), "academic");
				
			}
			
			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		/*acacreate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				cards.show(MainFrame.this.getContentPane(), "academic");
				
			}
		});
		
		academicMenu.add(acashow);
		academicMenu.add(acacreate);*/
		
		JMenu studentMenu = new JMenu("Student");
		studentMenu.addMenuListener(new MenuListener() {
			
			public void menuSelected(MenuEvent arg0) {
				cards.show(MainFrame.this.getContentPane(), "student");
				
			}
			
			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		JMenu facultyMenu = new JMenu("Faculty");
		
		facultyMenu.addMenuListener(new MenuListener() {
			
			public void menuSelected(MenuEvent arg0) {
				cards.show(MainFrame.this.getContentPane(), "faculty");
				
			}
			
			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenu registrationMenu = new JMenu("Registration");
		
		registrationMenu.addMenuListener(new MenuListener() {
			
			public void menuSelected(MenuEvent arg0) {
				cards.show(MainFrame.this.getContentPane(), "registration");
				
			}
			
			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenu alumniMenu = new JMenu("Alumni");
		JMenu staffMenu = new JMenu("Staff");
		staffMenu.addMenuListener(new MenuListener() {
			
			public void menuSelected(MenuEvent arg0) {
				cards.show(MainFrame.this.getContentPane(), "staff");
				
			}
			
			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		JMenu accountsMenu = new JMenu("Accounts");
		accountsMenu.addMenuListener(new MenuListener() {
			
			public void menuSelected(MenuEvent arg0) {
				cards.show(MainFrame.this.getContentPane(), "accounts");
				
			}
			
			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		//////////////////////////dept menu/////////////////////////////
		JMenu deptMenu = new JMenu("Department");
		
		JMenu fsit = new JMenu("Faculty Of Science And Information Technology");
		JMenu fe = new JMenu("Faculty Of Engineering");
		JMenu fss = new JMenu("Faculty Of Arts And Social Science");
		JMenu fba = new JMenu("Faculty Of Business Administration");
		
		JMenuItem overview = new JMenuItem("Overview");
		JMenuItem subjects = new JMenuItem("Courses");
		JMenuItem students = new JMenuItem("Students");
		JMenuItem facultyMember = new JMenuItem("Faculty Members");
		JMenuItem alumni = new JMenuItem("Alumni");
		
		/*overview.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				cards.show(MainFrame.this.getContentPane(), "academic");
				
			}
		});*/
		
		fsit.add(overview);
		fsit.add(subjects);
		fsit.add(students);
		fsit.add(facultyMember);
		fsit.add(alumni);
		///////////////////////EEEEEEEEEEEEEEEEEEEE////////////////////////////////
		JMenuItem overview1 = new JMenuItem("Overview");
		JMenuItem subjects1 = new JMenuItem("Courses");
		JMenuItem students1 = new JMenuItem("Students");
		JMenuItem facultyMember1 = new JMenuItem("Faculty Members");
		JMenuItem alumni1 = new JMenuItem("Alumni");
		
		//////////////course/////////////////
		courseModelEE.setData(controller.getCourse());
		subjects1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					controller.connect();
				} catch (Exception e) {
					controller.disconnect();
				}
				
				cards.show(MainFrame.this.getContentPane(), "eeecourse");
				
				controller.loadCouresOnDept("EEE");
				courseEE.refresh();
				controller.disconnect();
			}
		});
		///////////////////////////////
		
		/////////////////student//////////////////
		studentmodelEE.setData(controller.getStudent());
		students1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					controller.connect();
				} catch (Exception e) {
					controller.disconnect();
					System.out.println("Here is problem");
				}
				
				controller.loadStudentOnDept("EEE");
				studentEE.refresh();
				cards.show(MainFrame.this.getContentPane(), "eeestudents");
				controller.disconnect();
			}
		});
		//////////////////////////////////
		
		////////////////////////////////////////////////////////////
		facultymodelEE.setData(controller.getFaculty());
		facultyMember1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					controller.connect();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				controller.loadFacultyOnDept("EEE");
				facultyEE.refresh();
				cards.show(MainFrame.this.getContentPane(), "eeefaculty");
			}
		});
		///////////////////////////////////////////////////////////
		
		fe.add(overview1);
		fe.add(subjects1);
		fe.add(students1);
		fe.add(facultyMember1);
		fe.add(alumni1);
	//////////eeeeeeeeeeeeeeeeeeeeeeeeee///////////////////////////////////////////	
		JMenuItem overview2 = new JMenuItem("Overview");
		JMenuItem subjects2 = new JMenuItem("Courses");
		JMenuItem students2 = new JMenuItem("Students");
		JMenuItem facultyMember2 = new JMenuItem("Faculty Members");
		JMenuItem alumni2 = new JMenuItem("Alumni");
		
		fss.add(overview2);
		fss.add(subjects2);
		fss.add(students2);
		fss.add(facultyMember2);
		fss.add(alumni2);
		
		JMenuItem overview3 = new JMenuItem("Overview");
		JMenuItem subjects3 = new JMenuItem("Courses");
		JMenuItem students3 = new JMenuItem("Students");
		JMenuItem facultyMember3 = new JMenuItem("Faculty Members");
		JMenuItem alumni3 = new JMenuItem("Alumni");
		
		fba.add(overview3);
		fba.add(subjects3);
		fba.add(students3);
		fba.add(facultyMember3);
		fba.add(alumni3);
		
		deptMenu.add(fsit);
		deptMenu.add(fe);
		deptMenu.add(fss);
		deptMenu.add(fba);
		
		
		menuBar.add(homeMenu);
		menuBar.add(academicMenu);
		menuBar.add(deptMenu);
		menuBar.add(studentMenu);
		menuBar.add(facultyMenu);
		menuBar.add(alumniMenu);
		menuBar.add(staffMenu);
		menuBar.add(accountsMenu);
		menuBar.add(registrationMenu);
		
		
		return menuBar;
	}

}
