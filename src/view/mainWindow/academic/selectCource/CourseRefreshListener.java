package view.mainWindow.academic.selectCource;

import java.util.EventListener;

public interface CourseRefreshListener extends EventListener{
	public void refreshEventOccured(RefreshEvent e);
}
