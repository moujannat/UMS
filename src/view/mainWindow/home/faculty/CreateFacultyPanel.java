package view.mainWindow.home.faculty;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.Database;
import controller.Controller;

public class CreateFacultyPanel extends JPanel{

	private static final long serialVersionUID = 1L;
		private JTextField textFieldFirstName;
		private JTextField textFieldLastName;
		private JTextField textFieldFatherName;
		private JTextField textFieldMotherName;
		private JTextField textFieldCity;
		private JTextField textFieldPostalCode;
		private JTextField textFieldCountry;
		private JTextField textFieldEntryDate;
		private JTextField textFieldId;
		private JTextField textFieldDOB;
		
		private JButton createButton;
		
		private JComboBox<?> deptComboBox;
		private JComboBox<?> designationComboBox;
		private JComboBox<?> genderComboBox;
		
		private JTextArea homeArea;
		
		private FacultyPanelListener facultyPanelListener;
		private Controller controller;
		
		public CreateFacultyPanel(){
			
			Dimension dim = getPreferredSize();
			dim.width = 300;
			setPreferredSize(dim);
			
			new Database();
			controller = new Controller();
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			//setSize(452, 700);
			
			TitledBorder innerBorder = BorderFactory.createTitledBorder("Add Faculty Member");
			Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
			setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
			
			
			setLayout(gridBagLayout);
			
			GridBagConstraints gc = new GridBagConstraints();
			
			gc.weightx = 1;
			gc.weighty = 0.1;
			
			JLabel lblFirstName = new JLabel("First Name");
			gc.fill = GridBagConstraints.NONE;
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 5, 5);
			gc.gridx = 2;
			gc.gridy = 1;
			add(lblFirstName, gc);
			
			textFieldFirstName = new JTextField(15);
			gc.insets = new Insets(0, 0, 5, 0);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.gridx = 4;
			gc.gridy = 1;
			add(textFieldFirstName, gc);
			
			JLabel lblLastName = new JLabel("Last Name");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 5, 5);
			gc.gridx = 2;
			gc.gridy = 3;
			add(lblLastName, gc);
			
			textFieldLastName = new JTextField(15);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 3;
			add(textFieldLastName, gc);
			
			JLabel lblFatherName= new JLabel("Father Name");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 5, 5);
			gc.gridx = 2;
			gc.gridy = 5;
			add(lblFatherName, gc);
			
			textFieldFatherName = new JTextField(15);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 5;
			add(textFieldFatherName, gc);
			
			JLabel lblMotherName = new JLabel("Mother Name");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 5, 5);
			gc.gridx = 2;
			gc.gridy = 7;
			add(lblMotherName, gc);
			
			textFieldMotherName = new JTextField(15);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 7;
			add(textFieldMotherName, gc);
			
			JLabel lblGender = new JLabel("Gender");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 5, 5);
			gc.gridx = 2;
			gc.gridy = 9;
			add(lblGender, gc);
			
			String gn[] ={"Male","Female"};
			genderComboBox = new JComboBox<Object>(gn);
			genderComboBox.setPreferredSize(new Dimension(150, 25));
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 9;
			add(genderComboBox,gc);
			

			JLabel lbldob = new JLabel("DOB");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 5, 5);
			gc.gridx = 2;
			gc.gridy = 11;
			add(lbldob, gc);
			
			textFieldDOB = new JTextField("dd/mm/yyyy",15);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 11;
			add(textFieldDOB, gc);
			
			JLabel lblHomeAddress = new JLabel("Home Addess");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 5, 5);
			gc.gridx = 2;
			gc.gridy = 13;
			add(lblHomeAddress, gc);
			
			homeArea = new JTextArea(5,15);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 5);
			gc.gridx = 4;
			gc.gridy = 13;
			add(new JScrollPane(homeArea), gc);
			
			
			JLabel lblCity = new JLabel("City");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 5, 5);
			gc.gridx = 2;
			gc.gridy = 15;
			add(lblCity, gc);
			
			textFieldCity = new JTextField(15);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 15;
			add(textFieldCity, gc);
			
			JLabel lblPostalCode = new JLabel("Postal Code");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 5, 5);
			gc.gridx = 2;
			gc.gridy = 17;
			add(lblPostalCode, gc);
			
			textFieldPostalCode = new JTextField(15);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 17;
			add(textFieldPostalCode, gc);
			
			JLabel lblCountry = new JLabel("Country");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 5, 5);
			gc.gridx = 2;
			gc.gridy = 19;
			add(lblCountry, gc);
			
			textFieldCountry = new JTextField("Bangladesh",15);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 19;
			add(textFieldCountry, gc);
			
			JLabel lblRegDate = new JLabel("Entry Date");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 5, 5);
			gc.gridx = 2;
			gc.gridy = 21;
			add(lblRegDate, gc);
			
			Calendar cal = Calendar.getInstance();  
		    int year = cal.get(Calendar.YEAR);
		    int month = cal.get(Calendar.MONTH)+1;
		    int day = cal.get(Calendar.DAY_OF_MONTH);
		    
		    String entryDate = new String(day+"/"+month+"/"+year);
			
			textFieldEntryDate = new JTextField(entryDate,15);
			textFieldEntryDate.setEditable(false);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 21;
			add(textFieldEntryDate, gc);
			
			
			JLabel lblSemester = new JLabel("Designation");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 0, 5);
			gc.gridx = 2;
			gc.gridy = 23;
			add(lblSemester, gc);
			
			String desig[] ={"Select a Designation","Dean","Director","Dept Head","Professor","Associate Professor","Lacturer"};
			designationComboBox= new JComboBox<Object>(desig);
			designationComboBox.setPreferredSize(new Dimension(150, 25));
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 23;
			add(designationComboBox, gc);
			
			JLabel lblID = new JLabel("ID");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 0, 5);
			gc.gridx = 2;
			gc.gridy = 25;
			add(lblID, gc);
			
			try {
				controller.connect();
			} catch (Exception e1) {
				controller.disconnect();
			}
			
			int idcount = controller.facultycount()+1;
			cal = Calendar.getInstance();  
		    year = cal.get(Calendar.YEAR);
		    int idyear = year-2000;
		    java.text.NumberFormat nf = new java.text.DecimalFormat("00000");  
		    String idnum = nf.format(idcount);
		    String facultyid =new String(idyear+"-"+idnum);
		    controller.disconnect();
			
			textFieldId = new JTextField(facultyid,15);
			textFieldId.setEditable(false);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 25;
			add(textFieldId, gc);
			
			JLabel lblStatus = new JLabel("Department");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 0, 5);
			gc.gridx = 2;
			gc.gridy = 27;
			add(lblStatus, gc);
			
			String dept[] ={"Select a department","CSE","EEE","BBA","ARCH","MATH","STATISTICS","ENGLISH","PHYSICS","CHEMISTRY"};
			deptComboBox = new JComboBox<Object>(dept);
			deptComboBox.setPreferredSize(new Dimension(150, 25));
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 27;
			add(deptComboBox, gc);
			
			createButton = new JButton("Create");
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 5, 0);
			gc.gridx = 4;
			gc.gridy = 29;
			add(createButton, gc);
			
			
			createButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					 String firstName=textFieldFirstName.getText();
					 //System.out.println(firstName);
					 String lastName=textFieldLastName.getText();
					 String fatherName=textFieldFatherName.getText();
					 String motherName=textFieldMotherName.getText();
					 
					/* ButtonModel rselected = bg.getSelection();
					 
					 
					 if(rselected == rdbtnMaleRadioButton){
						 cg.setGender("Male");;
					 }
					 else if(rselected==rdbtnFemaleRadioButton){
						 cg.setGender("Female");
					 }*/
					// System.out.println(cg.getGender());
					 String gender=genderComboBox.getSelectedItem().toString();
					// System.out.println(gender);
					 String dob=textFieldDOB.getText();
					 String homeAddress=homeArea.getText();;
					 String city=textFieldCity.getText();
					 int postalCode=Integer.parseInt(textFieldPostalCode.getText());
					 System.out.println(postalCode);
					 String country=textFieldCountry.getText();
					 String entryDate=textFieldEntryDate.getText();
					 String designation=designationComboBox.getSelectedItem().toString();
					 String id=textFieldId.getText();
					 String department=deptComboBox.getSelectedItem().toString();
					 //System.out.println(department);
					 String status="Active";
					 
					
					 FacultyPanelEvent fpe = new FacultyPanelEvent(this, firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, entryDate, designation, id, department, status);
					 if(facultyPanelListener != null){
						 facultyPanelListener.facultyPanelEventOccured(fpe);
					 }
						
						/*try {
							db.connect();
							db.saveFaculty(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, entryDate, designation, id, department, status);
							JOptionPane.showMessageDialog(null, "Faculty Data Inserted");
							db.disconnect();
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Error\n Check all input Panels");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Error\nCheck all input Panels");

						}*/
					
				}
			});
			
		}

		public void setFacultyPanelListener(FacultyPanelListener listener){
			facultyPanelListener = listener;
		}
		
		
	}
 
