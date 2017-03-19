package domain;

import java.io.IOException;

public class LockSystemTask extends Task{

	public boolean completeTask() {
		try {
			Runtime.getRuntime().exec("C:\\Windows\\System32\\rundll32.exe user32.dll,LockWorkStation");
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public String toString(){
		return "Lock System Task";
	}

}
