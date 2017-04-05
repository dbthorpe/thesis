package gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class View extends JFrame{

	private GuiController controller;
	private Model model;
	private Font buttonFont;
	private JLabel timeUntilPoll;
	private JTextArea textArea;
	private JScrollPane taskUpdates;
	private Timer timer;
	private JLabel timeRemaining;
	private int minutesBetweenPolls = 1;

	public void setController(GuiController controller){
		this.controller = controller;
	}

	public void setModel(Model model){
		this.model = model;
	}

	private void buttonSetup(JPanel panelHoldingButtons, JButton button, String buttonLabel){
		button.setText(buttonLabel);
		button.setFont(buttonFont);
		panelHoldingButtons.add(button);
	}


	public void build(){
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setSize(325, 300);
		setTitle("Thesis");

		buttonFont = new Font("Monospaced", Font.BOLD, 11);

		JPanel emailOptionsAndInfo = new JPanel();
		emailOptionsAndInfo.setLayout(new BoxLayout(emailOptionsAndInfo, BoxLayout.X_AXIS));
		buttonSetup(emailOptionsAndInfo, controller.getStartButton(), "Start");
		buttonSetup(emailOptionsAndInfo, controller.getStopButton(), "Stop");
		//buttonSetup(emailOptionsAndInfo, controller.getSettingsButton(), "Settings");


		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setText("Task Updates: \n");
		taskUpdates = new JScrollPane(textArea);
		taskUpdates.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		taskUpdates.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		taskUpdates.setAutoscrolls(true);

		timeRemaining = new JLabel(" Not Started ");
		emailOptionsAndInfo.add(timeRemaining);
		timer = controller.createTimer(minutesBetweenPolls);

		Container contentPane = getContentPane();
		contentPane.add(emailOptionsAndInfo, "North");
		contentPane.add(taskUpdates, "Center");

		//pack();


	}

	public void newTaskUpdate(String update){
		textArea.setText(textArea.getText() + update + "\n");
	}

	public void updateTimerLabel(String updatedText) {
		timeRemaining.setText(updatedText);
	}

	public void startTimer() {
		updateTimerLabel(" Time Until Poll: " + minutesBetweenPolls +" min");
		timer.start();
		newTaskUpdate("Timer started!");
	}

	public void stopTimer() {
		timer.stop();
		timer.restart();
		newTaskUpdate("Timer stopped!");
		updateTimerLabel(" Stopped");
	}


}
