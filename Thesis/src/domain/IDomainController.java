package domain;

import email.IEmailHandler;
import gui.IModel;

public interface IDomainController {
	public void setModel(IModel model);
	public void setEmailHandler(IEmailHandler emailHandler);
	
	// will need to add calls for whatever gui functionality there is included
	public void start();
	public void close();
}
