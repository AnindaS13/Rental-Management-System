package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Gui.ReadMessageView;
import Model.UnregisteredRenter;
import Model.RegisteredRenter;
import Model.Landlord;

//controller to send messages to landlords, both unregistered and registered renters

public class ContactController extends ParentController {
	
	private ReadMessageView messages;
	private DBConnect db = new DBConnect();
	
	public ContactController (Landlord landlord, ReadMessageView msg) {
		this.landlord = landlord;
		this.messages = msg;

		//getting all messages of the user (landlord)
		ArrayList<String> userMsg = landlord.RetreiveMessage(db.getMessages());
		//setting output in view
		messages.setOutput(userMsg);
		
		//action listeners
		messages.RegisterPerformed(new RegisterButton());
		messages.ListingsPerformed(new ListingButton());
		messages.MessagesPerformed(new MessageButton());
	}
	
	//implementation to action listernes
	public class RegisterButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switchView("RegisterProperty");
		}
	}
	
	public class ListingButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switchView("landlordListings");
		}
	}
	
	public class MessageButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> userMsg = landlord.RetreiveMessage(db.getMessages());
			messages.setOutput(userMsg);
		}
	}
	
	//switch method to change the view, handled by parent controller.
	@Override
	public void switchView(String view) {
		super.switchView(view);
	}
	
}
