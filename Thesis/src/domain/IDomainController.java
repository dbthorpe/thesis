package domain;

import email.IEmailHandler;
import gui.IModel;

public interface IDomainController {
	public void setModel(IModel model);
	public void setEmailHandler(IEmailHandler emailHandler);
}
