package domain;

import email.IEmailHandler;
import gui.IModel;

public class DomainController implements IDomainController{
	
	private IModel model;
	private IEmailHandler emailHandler;
	
	public void setModel(IModel model) {
		this.model = model;
	}

	public void setEmailHandler(IEmailHandler emailHandler) {
		this.emailHandler = emailHandler;
	}

}
