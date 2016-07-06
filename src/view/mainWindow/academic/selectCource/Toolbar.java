package view.mainWindow.academic.selectCource;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton refresh;
	private TolbarRefreshListener tl;
	public Toolbar() {
		initializer();
	}
	public void initializer(){
		refresh = new JButton("Refresh");
		
		refresh.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ToolbarRefresh tb = new ToolbarRefresh(this);
				if(tl != null){
					tl.refreshEventOccured(tb);
				}
			}
		});
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(refresh);
	}
	
	public void setTolbar(TolbarRefreshListener listener){
		tl = listener;
	}
}
