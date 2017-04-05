package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

public class GuiController {
	private IModel model;
	private View view;
	
	public void setView(View view){
		this.view = view;
	}
	
	public void setModel(IModel model){
		this.model = model;
	}
	
	public JButton getStartButton(){
		JButton button = new JButton();
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				view.startTimer();
			}
		});
		return button;
	}
	
	public JButton getStopButton(){
		JButton button = new JButton();
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				view.stopTimer();
			}
		});
		return button;
	}
	
	public JButton getSettingsButton(){
		JButton button = new JButton();
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		return button;
	}
	
	public Timer createTimer(int timeInMinutes){
		Timer timer = new Timer(60000, new ActionListener() {
			
			private int count = timeInMinutes-1;
			private final int startingCount = timeInMinutes-1;
			
			public void actionPerformed(ActionEvent e) {
				if (count <= 0) {
					view.updateTimerLabel(" Now polling!");
					model.pollForTasks();
					count = startingCount;
					view.updateTimerLabel(" Time Until Poll: " + (count+1) + " min");
					
				} 
				else {
					view.updateTimerLabel(" Time Until Poll: " + (count+1) + " min");
					count--;
				}
			}
		});
		
		return timer;
	}
}

