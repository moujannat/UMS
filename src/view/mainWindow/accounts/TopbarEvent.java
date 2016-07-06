package view.mainWindow.accounts;

import java.util.EventObject;

public class TopbarEvent extends EventObject{

	private static final long serialVersionUID = 1L;
	private String id;

	public TopbarEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public TopbarEvent(Object source,String id) {
		super(source);
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
