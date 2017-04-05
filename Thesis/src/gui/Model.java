package gui;

import domain.IDomainController;

public class Model implements IModel{

	private IDomainController domain;
	private View view;

	public void setDomainController (IDomainController domain){
		this.domain = domain;
	}

	public void setView(View view){
		this.view = view;
	}

	public void jobUpdate(String message) {

	}

	public void reportNumberOfNewTasks(int size) {
		view.newTaskUpdate("There are " + size + " new tasks.");
	}

	public void reportResult(String string, boolean result) {
		if(result){
			view.newTaskUpdate(string + " was successful.");
		}
		else{
			view.newTaskUpdate(string +" was not successful.");
		}
	}

	public void pollForTasks() {
		domain.startNewTasks();
	}
}



