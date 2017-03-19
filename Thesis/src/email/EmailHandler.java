package email;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import domain.IDomainController;

public class EmailHandler implements IEmailHandler{

	private IDomainController domain;


	public void setDomainController(IDomainController domain){

	}

	public List<String> pullForNewEmails(List<String> allowedEmails) {
		try {
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");

			Session session = Session.getDefaultInstance(props, null);

			Store store = session.getStore("imaps");
			store.connect("smtp.gmail.com", "dbthorpe.thesis@gmail.com","829982868");

			Folder inbox = store.getFolder("inbox");
			inbox.open(Folder.READ_WRITE);

			Message[] messages = inbox.getMessages();
			List<String> newAutomateEmails = new ArrayList<String>();
			String currSubject = "";
			String newTask = "";
			for (int i = 0; i < messages.length; i++) {
					currSubject = messages[i].getSubject();
					if(currSubject.contains("automate:")){
						newTask = currSubject.substring(currSubject.indexOf(":")+1);
						if(allowedEmails.contains(newTask.trim())){
							newAutomateEmails.add(newTask);
						}
						messages[i].setFlag(Flags.Flag.DELETED, true);
					}
			}
			inbox.close(true);
			store.close();
			return newAutomateEmails;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}