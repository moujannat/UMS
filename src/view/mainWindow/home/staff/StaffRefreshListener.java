package view.mainWindow.home.staff;

import java.util.EventListener;

public interface StaffRefreshListener extends EventListener{
	public void refreshEventOccured(RefreshEvent e);
}
