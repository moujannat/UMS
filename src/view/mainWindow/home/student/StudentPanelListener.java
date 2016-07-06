package view.mainWindow.home.student;

import java.sql.SQLException;

public interface StudentPanelListener {
	public void studentPanelEventOccured(StudentPanelEvent e) throws SQLException;
	public void studentTableEventOccured(StudentTableCreateEvent e);
}
