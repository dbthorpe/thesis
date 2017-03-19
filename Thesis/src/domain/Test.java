package domain;

import email.EmailHandler;
import email.IEmailHandler;
import gui.IModel;
import gui.Model;

public class Test {

	public static void main(String args[]){
		DomainController d = new DomainController();
		IEmailHandler e = new EmailHandler();
		IModel m = new Model();
		d.setEmailHandler(e);
		e.setDomainController(d);
		d.setModel(m);
		d.startNewTasks();
	}
}
