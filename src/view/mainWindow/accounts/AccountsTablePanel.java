package view.mainWindow.accounts;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Controller;
import model.Accounts;

public class AccountsTablePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private AccountsTableModel accountsTableModel;
	private Controller controller;
	public AccountsTablePanel() {
		initializer();
	}
	
	public void initializer(){
		accountsTableModel = new AccountsTableModel();
		table=new JTable(accountsTableModel);
		controller = new Controller();
		setAccountData(controller.getAccounts());
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setAccountData(List<Accounts> db){
		accountsTableModel.setData(db);
	}
	
	public void refresh(){
		accountsTableModel.fireTableDataChanged();
	}
	
}
