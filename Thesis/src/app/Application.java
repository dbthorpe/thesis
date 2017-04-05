package app;

import domain.DomainController;
import domain.IDomainController;
import email.EmailHandler;
import email.IEmailHandler;
import gui.GuiController;
import gui.IModel;
import gui.Model;
import gui.View;

public class Application {

	public static void main(String[] args) {
		IEmailHandler emailHandler = new EmailHandler();
		IDomainController domainController = new DomainController();
		IModel model = new Model();
		GuiController guiController = new GuiController();
		View view = new View();
		
		emailHandler.setDomainController(domainController);
		
		domainController.setEmailHandler(emailHandler);
		domainController.setModel(model);
		
		model.setDomainController(domainController);
		model.setView(view);
		view.setController(guiController);
		guiController.setView(view);
		guiController.setModel(model);

		
		view.build();
		view.show();
	}

}
