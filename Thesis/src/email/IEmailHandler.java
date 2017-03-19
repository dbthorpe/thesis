package email;

import java.util.List;

import domain.IDomainController;

public interface IEmailHandler {
	
	public void setDomainController(IDomainController domain);
	
	public List<String> pullForNewEmails(List<String> allowedEmails);
	
}
