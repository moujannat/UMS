package view.mainWindow.student;

import java.util.EventObject;

public class ToolbarEvent extends EventObject{
	

	private static final long serialVersionUID = 1L;
	private String search;

	public ToolbarEvent(Object source) {
		super(source);
	}
	public ToolbarEvent(Object source,String search){
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
