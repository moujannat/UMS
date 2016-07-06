package view.mainWindow.faculty;

import java.util.EventObject;

public class TopbarEvent extends EventObject{

	private static final long serialVersionUID = 1L;
	private String search;
	public TopbarEvent(Object source) {
		super(source);
	}
	
	public TopbarEvent(Object source,String search) {
		super(source);
		
		this.search = search;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	

}
