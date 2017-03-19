package domain;

public class TaskFactory {
	
	public Task getTask(String task){
		switch(task){
		case "delete":
			return new DeleteHistoryTask();
		case "lock":
			return new LockSystemTask();
		default:
			return null;
		}
	}
}
