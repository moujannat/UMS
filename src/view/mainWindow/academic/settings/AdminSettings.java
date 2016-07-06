package view.mainWindow.academic.settings;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

import controller.Controller;


public class AdminSettings extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField textFieldSemester;
	private JTextField textField;
	private JTextField textFieldnewUser;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldNew;
	private JPasswordField passwordFieldReType;
	private Controller controller;


	public AdminSettings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() {
		setLayout(null);
		
		JLabel lblAddSemester = new JLabel("Add Semester");
		lblAddSemester.setFont(new Font("Viner Hand ITC", Font.PLAIN, 15));
		lblAddSemester.setBounds(53, 28, 129, 24);
		add(lblAddSemester);
		
		JLabel lblNewSemester = new JLabel("New Semester");
		lblNewSemester.setBounds(53, 97, 70, 14);
		add(lblNewSemester);
		
		textFieldSemester = new JTextField();
		textFieldSemester.setBounds(179, 87, 200, 24);
		add(textFieldSemester);
		textFieldSemester.setColumns(10);
		
		
		
		JTextArea textAreaHints = new JTextArea();
		textAreaHints.setEditable(true);
		textAreaHints.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		textAreaHints.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 21));
		textAreaHints.setBounds(53, 193, 332, 216);
		add(textAreaHints);
		
		//////////////////////////////////////////////////////////////////////
		controller = new Controller();
		try {
			controller.connect();
		} catch (Exception e) {
			controller.disconnect();
		}
		String semester = controller.semester();
		
		Calendar cal = Calendar.getInstance();  
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1; //zero-based 
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		String gap = "     ";
		String hints = gap+"Current Semester : "+semester+"\n"+gap+"Current Year : "+year+"\n"+gap+"Current Month : "+month+"\n"+gap+"Current Day : "+day;
		
		textAreaHints.append(hints);
		textAreaHints.setEditable(false);
		/////////////////////////////////////////////////////////////////////
		
		JLabel lblUserInformation = new JLabel("User Information");
		lblUserInformation.setFont(new Font("Viner Hand ITC", Font.PLAIN, 18));
		lblUserInformation.setBounds(468, 28, 152, 14);
		add(lblUserInformation);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(504, 87, 63, 14);
		add(lblUserName);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(641, 82, 214, 24);
		add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(766, 123, 89, 23);
		add(btnEdit);
		
		JLabel lblUserName_1 = new JLabel("New User Name");
		lblUserName_1.setBounds(501, 241, 92, 24);
		add(lblUserName_1);
		
		textFieldnewUser = new JTextField();
		textFieldnewUser.setBounds(641, 241, 214, 24);
		add(textFieldnewUser);
		textFieldnewUser.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(504, 340, 76, 14);
		add(lblNewPassword);
		
		JLabel lblTypeAgain = new JLabel("Re-Type");
		lblTypeAgain.setBounds(504, 392, 76, 14);
		add(lblTypeAgain);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(766, 429, 89, 23);
		add(btnUpdate);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(290, 134, 89, 23);
		add(btnCreate);
		//////////////////////////////semester add//////////////////////////////////////////
		btnCreate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String name = textFieldSemester.getText();
				controller.addSemester(name);
				//CreateStudentPanel cp = new CreateStudentPanel();
			}
		});
		////////////////////////////////////////////////////////////////////////
		
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setBounds(504, 289, 89, 14);
		add(lblCurrentPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(641, 286, 214, 20);
		add(passwordField);
		
		passwordFieldNew = new JPasswordField();
		passwordFieldNew.setBounds(641, 337, 214, 20);
		add(passwordFieldNew);
		
		passwordFieldReType = new JPasswordField();
		passwordFieldReType.setBounds(641, 389, 214, 20);
		add(passwordFieldReType);
	}
}
