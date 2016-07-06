package view.mainWindow.academic.addCourse;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.Controller;

public class AddCoursePanel extends JPanel{

	private static final long serialVersionUID = 1L;
		private JTextField textFieldCourseDescription;
		private JTextField textFieldCourseCode;
		private JTextField textFieldCourseCredit;
		private JTextField textFieldCoursePrequsite;
		
		private CoursePanelListener coursePanelListener;
		
		private JButton addButton;
		
		private JComboBox<?> courseDeptComboBox;
		private JComboBox<?> courseFDeptComboBox;
		
		public AddCoursePanel(){
			
			Dimension dim = getPreferredSize();
			dim.width = 300;
			setPreferredSize(dim);
			
			
			new Controller();
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			//setSize(452, 700);
			
			TitledBorder innerBorder = BorderFactory.createTitledBorder("Add a Course");
			Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
			setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
			
			
			setLayout(gridBagLayout);
			
			GridBagConstraints gc = new GridBagConstraints();
			
			gc.weightx = 1;
			gc.weighty = 0.1;
			
			JLabel lblFirstName = new JLabel("Course Name");
			gc.fill = GridBagConstraints.NONE;
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 10, 5);
			gc.gridx = 2;
			gc.gridy = 0;
			add(lblFirstName, gc);
			
			textFieldCourseDescription = new JTextField(15);
			gc.insets = new Insets(5, 0, 10, 0);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.gridx = 4;
			gc.gridy = 0;
			add(textFieldCourseDescription, gc);
			
			///////////////////////////////////////////////////////////////////////
			
			JLabel lblLastName = new JLabel("Code");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 10, 5);
			gc.gridx = 2;
			gc.gridy = 1;
			add(lblLastName, gc);
			
			textFieldCourseCode = new JTextField(15);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 10, 0);
			gc.gridx = 4;
			gc.gridy = 1;
			add(textFieldCourseCode, gc);
			
			/////////////////////////////////////////////////////////////////////////
			
			JLabel lblFatherName= new JLabel("Credit");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 10, 5);
			gc.gridx = 2;
			gc.gridy = 2;
			add(lblFatherName, gc);
			
			textFieldCourseCredit = new JTextField(15);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 10, 0);
			gc.gridx = 4;
			gc.gridy = 2;
			add(textFieldCourseCredit, gc);
			
			////////////////////////////////////////////////////////////////////////////////
			
			JLabel lblMotherName = new JLabel("Prequsite");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 10, 5);
			gc.gridx = 2;
			gc.gridy = 3;
			add(lblMotherName, gc);
			
			textFieldCoursePrequsite = new JTextField(15);
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 10, 0);
			gc.gridx = 4;
			gc.gridy = 3;
			add(textFieldCoursePrequsite, gc);
			
			/////////////////////////////////////////////////////////////////////////
			
			JLabel lblGender = new JLabel("Dept");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 10, 5);
			gc.gridx = 2;
			gc.gridy = 4;
			add(lblGender, gc);
			
			String d[] ={"CSE","EEE","BBA","ARCH","MATH","STATISTICS","ENGLISH","PHYSICS","CHEMISTRY"};
			courseDeptComboBox = new JComboBox<Object>(d);
			courseDeptComboBox.setPreferredSize(new Dimension(150, 25));
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 10, 0);
			gc.gridx = 4;
			gc.gridy = 4;
			add(courseDeptComboBox,gc);
			
           ////////////////////////////////////////////////////////////////////
			
			JLabel lbldob = new JLabel("Course Dept");
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 10, 5);
			gc.gridx = 2;
			gc.gridy = 5;
			add(lbldob, gc);
			
			
			courseFDeptComboBox= new JComboBox<Object>(d);
			courseFDeptComboBox.setPreferredSize(new Dimension(150, 25));
			gc.anchor = GridBagConstraints.LINE_START;
			gc.insets = new Insets(0, 0, 10, 0);
			gc.gridx = 4;
			gc.gridy = 5;
			add(courseFDeptComboBox, gc);
	
			//////////////////////////////////////////////////////////////////////////////
			gc.weightx = 1;
			gc.weighty = 1.5;
			
			addButton = new JButton("Add Course");
			gc.anchor = GridBagConstraints.NORTHWEST;
			gc.insets = new Insets(0, 0, 10, 0);
			gc.gridx = 4;
			gc.gridy = 6;
			add(addButton, gc);
			
			
			addButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					 String coursediscription=textFieldCourseDescription.getText();
					 //System.out.println(firstName);
					 String code=textFieldCourseCode.getText();
					 String findedcredit=textFieldCourseCredit.getText();
					 double credit = Double.parseDouble(findedcredit);
					 String prequsite=textFieldCoursePrequsite.getText();
					 
					
					 String dept=courseDeptComboBox.getSelectedItem().toString();
					 
					 String fdept=courseFDeptComboBox.getSelectedItem().toString();
					 
					 CoursePanelEvent  cpe = new CoursePanelEvent(this, coursediscription, code, credit, dept, prequsite, fdept);
					 if(coursePanelListener != null){
						 coursePanelListener.coursePanelEventOccured(cpe);
					 }
						
					/*	try {
							db.connect();
							db.saveStaff(firstName, lastName, fatherName, motherName, gender, dob, homeAddress, city, postalCode, country, entryDate, designation, id, department, status);
							JOptionPane.showMessageDialog(null, "Staff Data Inserted");
							db.disconnect();
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Error\n Check all input Panels");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Error\nCheck all input Panels");

						}*/
					
				}
			});
			
		}

		public void setCoursePanelListener(CoursePanelListener listener){
			coursePanelListener = listener;
		}
		
		
	}
 
