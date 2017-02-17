package email;

import domain.IDomainController;

public class EmailHandler implements IEmailHandler{
	private IDomainController domain;
	
	public void setDomainController(IDomainController domain){
		this.domain = domain;
	}

}
