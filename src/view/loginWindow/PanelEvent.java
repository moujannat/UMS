package view.loginWindow;

import java.util.EventObject;

public class PanelEvent extends EventObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;

	public PanelEvent(Object source) {
		super(source);
		
	}
	public PanelEvent(Object source,String name,String password) {
		super(source);
		this.name = name;
		this.password = password;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

		
}
