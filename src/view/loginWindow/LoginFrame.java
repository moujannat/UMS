package view.loginWindow;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Database;
import view.mainWindow.MainFrame;


public class LoginFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private TopPanel topPanel;
	private LoginPanel loginPanel;
	
	public LoginFrame(){
		super("University Management System");
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void initialize() throws SQLException {
		
		
		
		
		setResizable(false);
		
		setLocation(450, 200);
		
		
		topPanel = new TopPanel();
		loginPanel = new LoginPanel();
		

		setLayout(new BorderLayout());
		
		
		
		loginPanel.setPanelListener(new PanelListener(){
			public void panelEventOccured(PanelEvent e){
				String name = e.getName();
				String password = e.getPassword();
				
				Database db = new Database();
				try {
					db.connect();
					String check = db.login(name, password);
					if(check=="Connected"){
						new MainFrame();
						setVisible(false);
						db.disconnect();
					}
					else{
						JOptionPane.showMessageDialog(null, "Wrong User Name and Password");
						loginPanel.setVisible(false);
						loginPanel = new LoginPanel();
						initialize();
					
					}
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Problem in Connection");
				}
			}
		});
		
		setSize(500, 300);
		add(topPanel,BorderLayout.NORTH);
		add(loginPanel,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
