package gui;

import javax.swing.JFrame;

public class View extends JFrame{
	
	private GuiController controller;
	
	public void setController(GuiController controller){
		this.controller = controller;
	}
}
