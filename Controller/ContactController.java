package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Gui.ReadMessageView;
import Model.UnregisteredRenter;
import Model.RegisteredRenter;
import Model.Landlord;


public class ContactController extends ParentController {
	
	private ReadMessageView messages;
	private DBConnect db = new DBConnect();
	
	public ContactController (Landlord landlord, ReadMessageView msg) {
		this.landlord = landlord;
		this.messages = msg;

		//getting all messages of the user (landlord)
		ArrayList<String> userMsg = landlord.RetreiveMessage(db.getMessages());
		messages.setOutput(userMsg);
		messages.RegisterPerformed(new RegisterButton());
		messages.ListingsPerformed(new ListingButton());
		messages.MessagesPerformed(new MessageButton());
	}
	
	
	public class RegisterButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("register button pressed");	
			switchView("RegisterProperty");
		}
	}
	
	public class ListingButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Listing button pressed");
			switchView("landlordListings");
		}
	}
	
	public class MessageButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Message button pressed");
			ArrayList<String> userMsg = landlord.RetreiveMessage(db.getMessages());
			messages.setOutput(userMsg);
		}
	}
	
	@Override
	public void switchView(String view) {
		super.switchView(view);
	}
	
}
