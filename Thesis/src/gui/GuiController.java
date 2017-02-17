package gui;

public class GuiController {
	private IModel model;
	private View view;
	
	public void setView(View view){
		this.view = view;
	}
	
	public void setModel(IModel model){
		this.model = model;
	}
}
