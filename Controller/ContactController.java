package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gui.ReadMessageView;
import Model.UnregisteredRenter;
import Model.RegisteredRenter;
import Model.Landlord;


public class ContactController extends ParentController {
	
	private UnregisteredRenter uRenter;
	private RegisteredRenter rRenter;
	private Landlord landloard; 
	private ReadMessageView messages;
	
	public ContactController (UnregisteredRenter r1, RegisteredRenter r2, Landlord landlord, ReadMessageView msg) {
		this.uRenter = r1;
		this.rRenter = r2; 
		this.landloard = landlord;
		this.messages = msg;
		
		messages.RegisterPerformed(new RegisterButton());
		messages.ListingsPerformed(new ListingButton());
		messages.MessagesPerformed(new MessageButton());
	}
	
	
	public class RegisterButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("register button pressed");	
			switchView("register");
		}
	}
	
	public class ListingButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Listing button pressed");
			switchView("listing");
		}
	}
	
	public class MessageButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Message button pressed");	
		}
	}
	
	@Override
	public void switchView(String view) {
		super.switchView(view);
	}
	
	public static void main(String[] args) {
	System.out.println("Contact controller main");
	UnregisteredRenter R1 = new UnregisteredRenter();
	RegisteredRenter R2 = new RegisteredRenter();
	Landlord l = new Landlord(); 
	ReadMessageView msg = new ReadMessageView();
	
	ContactController c = new ContactController(R1, R2, l, msg);
	}
}
