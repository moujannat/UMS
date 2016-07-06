package view.mainWindow.academic.addCourse;

import java.util.EventListener;

public interface CourseRefreshListener extends EventListener{
	public void refreshEventOccured(RefreshEvent e);
}
