package gui;

import domain.IDomainController;

public class Model implements IModel{

	private IDomainController domain;
	private View view;
	public Model (){
	}
	
	public void setDomainController (IDomainController domain){
		this.domain = domain;
	}
	
	public void setView(View view){
		this.view = view;
	}

	public void jobUpdate(String message) {
		
	}
}



