package view;

import javax.swing.SwingUtilities;

import view.loginWindow.LoginFrame;



public class App {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){

			public void run() {
				new LoginFrame();
			}
			
		});
	}
}
