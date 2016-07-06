package view.mainWindow.home.student;

import java.util.EventObject;

public class StudentTableCreateEvent extends EventObject{

	private static final long serialVersionUID = 1L;
	private String idnum;
	public StudentTableCreateEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public StudentTableCreateEvent(Object source,String idnum) {
		super(source);
		this.idnum = idnum;
	}
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

}
