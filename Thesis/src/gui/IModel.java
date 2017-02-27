package gui;

import domain.IDomainController;

public interface IModel {

	public void setDomainController(IDomainController domain);
	public void setView(View view);
	public void jobUpdate(String message);
}
