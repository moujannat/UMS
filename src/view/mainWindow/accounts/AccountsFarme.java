package view.mainWindow.accounts;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import controller.Controller;

public class AccountsFarme extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private Topbar topbar;
	private AccountsPanel accountsPanel;
	private AccountsTablePanel accountsTablePanel;
	private Controller controller;

	public AccountsFarme() {
		initializer();
	}
	
	public void initializer(){
		topbar = new Topbar();
		accountsPanel = new AccountsPanel();
		accountsTablePanel = new AccountsTablePanel();
		controller = new Controller();
		
		setLayout(new BorderLayout());
		accountsTablePanel.setAccountData(controller.getAccounts());
		
		topbar.setTopbarPanel(new TopbarListtener() {
			
			public void topbarEventOccured(TopbarEvent e) {
				try {
					controller.connect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				controller.setStudentid(e);
				
				controller.loadAccounts(e);
				accountsTablePanel.refresh();
				
				//accountsPanel.setVisible(false)
				accountsPanel.setVisible(false);
				accountsPanel = new AccountsPanel();
				initializer();
				
			}
		});
		
		accountsPanel.setPanelListener(new AccountPanelListener() {
			
			public void accountPanelEventOccured(AccountPanelEvent e) {
				try {
					controller.connect();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				controller.saveAccounts(e);
				controller.updateAccounts(e);
				controller.loadAccounts(e);
				accountsTablePanel.refresh();
				
				accountsPanel.setVisible(false);
				accountsPanel = new AccountsPanel();
				initializer();
				
			}
		});
		
		add(topbar,BorderLayout.NORTH);
		add(accountsPanel,BorderLayout.WEST);
		add(accountsTablePanel,BorderLayout.CENTER);
		
	}
}
