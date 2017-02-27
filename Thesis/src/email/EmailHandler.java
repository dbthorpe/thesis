package email;

import java.util.List;

import domain.IDomainController;

public class EmailHandler implements IEmailHandler{
	
	private IDomainController domain;
	
	private final String query = "from:dbthorpe@gmail.com AND subject:automate";
	
	public void setDomainController(IDomainController domain){

	}

	public List<String> pullForNewEmails() {
		return null;
	}

}