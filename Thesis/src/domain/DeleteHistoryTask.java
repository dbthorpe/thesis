package domain;

import java.io.File;

public class DeleteHistoryTask extends Task{
	private final String history = "C:\\Users\\David\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles";
	
	public boolean completeTask() {
		File historyFile = new File(history);
		return deletePlaces(historyFile);
		
	}
	
	private boolean deletePlaces(File currentFolder){
	        File[] profiles = currentFolder.listFiles();
	            for(int i=0; i<profiles.length; i++) {
	            	File places = new File(profiles[i].getPath()+"\\places.sqlite");
	            	if(!places.delete()){
	            		return false;
	            	}
	            }
	                
	    return true;
	}

	public String toString(){
		return "Delete History Task";
	}
}
