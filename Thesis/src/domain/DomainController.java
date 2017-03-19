package domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import email.IEmailHandler;
import gui.IModel;

public class DomainController implements IDomainController{
	private IModel model;
	private IEmailHandler emailHandler;
	private Timer t;
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

	public void start() {	
		int delay = 1000*5;
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				startNewTasks();
			}
		};
		t = new Timer(delay, taskPerformer);
		t.start();
	}
		

	public void close() {
		t.stop();
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
		System.out.println(tasks.size());
		model.reportNumberOfNewTasks(tasks.size());
		boolean result;
		for(int i = 0; i<tasks.size(); i++){
			result = tasks.get(i).completeTask();
			System.out.println(tasks.get(i).toString() + " result: " + result);
			model.reportResult(tasks.get(i).toString(), result);
		}
		
	}
	
}
