package view.mainWindow.home.student;

import java.util.EventListener;

public interface StudentRefreshListener extends EventListener{
	public void refreshEventOccured(RefreshEvent e);
}
