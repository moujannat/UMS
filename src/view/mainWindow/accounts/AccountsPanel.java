package view.mainWindow.accounts;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Controller;

public class AccountsPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtDate;
	private JTextField txtSemester;
	private JTextField txtDebit;
	private JTextField txtCredit;
	private JTextField txtBalance;
	private JTextField txtAmount;
	private JButton btn;
	private Controller controller;
	private String id;
	private AccountPanelListener accountPanelListener;
	public AccountsPanel() {
		initializer();
	}
	public void initializer() {
		Dimension dim = new Dimension();
		dim.width = 320;
		setPreferredSize(dim);
		
		controller = new Controller();
		
		TitledBorder innerBorder = BorderFactory.createTitledBorder("Student Financial Information");
		Border outerborder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerborder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		//////////////////////////////////////
		JLabel lblid = new JLabel("Student ID");
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.gridx = 2;
		gc.gridy = 1;
		add(lblid,gc);
		
		try {
			controller.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			 id = controller.getStudentid();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		txtID = new JTextField(id,15);
		txtID.setEditable(false);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.gridx = 4;
		gc.gridy = 1;
		add(txtID,gc);
		
		
		JLabel lbl = new JLabel("Date");
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.gridx = 2;
		gc.gridy = 2;
		add(lbl,gc);
		

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
	    
		txtDate = new JTextField(date,15);
		txtDate.setEditable(false);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.gridx = 4;
		gc.gridy = 2;
		add(txtDate,gc);
		
		
		JLabel lblSemester = new JLabel("Semester");
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.gridx = 2;
		gc.gridy = 3;
		add(lblSemester,gc);
		
		
		
		
		String semester = controller.semester();
		
		txtSemester = new JTextField(semester,15);
		txtSemester.setEditable(false);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.gridx = 4;
		gc.gridy = 3;
		add(txtSemester,gc);
		
		
		JLabel lbldebir = new JLabel("Debit");
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.gridx = 2;
		gc.gridy = 4;
		add(lbldebir,gc);
		
		String debit = Double.toString(controller.getdebit(id));
		txtDebit = new JTextField(debit,15);
		txtDebit.setEditable(false);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.gridx = 4;
		gc.gridy = 4;
		add(txtDebit,gc);
		
		
		JLabel lblcredit = new JLabel("Credit");
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.gridx = 2;
		gc.gridy = 5;
		add(lblcredit,gc);
		
		String credit = Double.toString(controller.getcredit(id));
		
		txtCredit = new JTextField(credit,15);
		txtCredit.setEditable(false);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.gridx = 4;
		gc.gridy = 5;
		add(txtCredit,gc);
		
		
		JLabel lblbalance = new JLabel("Balance");
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.gridx = 2;
		gc.gridy = 6;
		add(lblbalance,gc);
		
		String balance = Double.toString(controller.getbalance(id));
		
		txtBalance = new JTextField(balance,15);
		txtBalance.setEditable(false);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.gridx = 4;
		gc.gridy = 6;
		add(txtBalance,gc);
		
		
		JLabel lblamount = new JLabel("Given Amount");
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.gridx = 2;
		gc.gridy = 7;
		add(lblamount,gc);
		
		txtAmount = new JTextField(15);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.gridx = 4;
		gc.gridy = 7;
		add(txtAmount,gc);
		
		
		gc.weightx = 1;
		gc.weighty = 2;
		
		btn = new JButton("Add");
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.gridx = 4;
		gc.gridy = 8;
		add(btn,gc);
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String studentid = txtID.getText();
				String presentdate = txtDate.getText();
				String semester = txtSemester.getText();
				double debit = Double.parseDouble(txtDebit.getText());
				double credit = Double.parseDouble(txtCredit.getText());
				double balance = Double.parseDouble(txtBalance.getText());
				
				double amount = Double.parseDouble(txtAmount.getText());
				
				credit = amount;
				balance = balance-amount;
				
				
				AccountPanelEvent ape = new AccountPanelEvent(this, studentid, presentdate, semester, debit, credit, balance);
				if(accountPanelListener != null){
					accountPanelListener.accountPanelEventOccured(ape);
				}
				
			}
		});
		
	}
	
	public void setPanelListener(AccountPanelListener listener){
		accountPanelListener = listener;
	}
}
