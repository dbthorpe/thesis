package domain;

import java.util.ArrayList;
import java.util.List;

import email.IEmailHandler;
import gui.IModel;

public class DomainController implements IDomainController{
	private IModel model;
	private IEmailHandler emailHandler;
	private List<String> allowedEmails = new ArrayList<String>();
	private TaskFactory tFactory = new TaskFactory();
	
	public DomainController(){
		allowedEmails.add("delete");
		allowedEmails.add("lock");
	}
	public void setModel(IModel model) {
		this.model = model;
	}

	public void setEmailHandler(IEmailHandler emailHandler) {
		this.emailHandler = emailHandler;
	}
	
	public void startNewTasks(){
		List<String> newTasks = emailHandler.pullForNewEmails(allowedEmails);
		List<Task> tasks = new ArrayList<Task>();
		Task currTask;
		for(int i = 0; i < newTasks.size(); i++){
			currTask = tFactory.getTask(newTasks.get(i));
			if(currTask!=null){
				tasks.add(currTask);
			}
		}
		model.reportNumberOfNewTasks(tasks.size());
		boolean result;
		for(int i = 0; i<tasks.size(); i++){
			result = tasks.get(i).completeTask();
			model.reportResult(tasks.get(i).toString(), result);
		}
		
	}
	
}
