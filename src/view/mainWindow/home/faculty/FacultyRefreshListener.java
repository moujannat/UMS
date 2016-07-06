package view.mainWindow.home.faculty;

import java.util.EventListener;

public interface FacultyRefreshListener extends EventListener{
	public void refreshEventOccured(RefreshEvent e);
}
