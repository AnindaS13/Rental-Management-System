package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import Controller.ContactController.ListingButton;
import Controller.ContactController.MessageButton;
import Controller.ContactController.RegisterButton;
import Model.Manager;
import Model.Landlord;
import Gui.EditListStatusLandlordView;
import Gui.EditStatusManagerView;
import Gui.RegisterPropertyView;

public class RegisterPropertyController extends ParentController{
//	Landlord landlord;
//	Manager manager;
	RegisterPropertyView registerProperty;
	EditListStatusLandlordView landlordView;
	EditStatusManagerView managerView;
	
	DBConnect db = new DBConnect();
		
	public RegisterPropertyController (Landlord l, Manager m, EditListStatusLandlordView lp, 
										EditStatusManagerView mp, RegisterPropertyView regisP){
		super();
		this.manager = m;
		this.landlord = l;
		this.registerProperty = regisP;
		this.landlordView = lp;
		this.managerView = mp;
		registerProperty.draw();
		
		registerProperty.RegisterPerformed(new RegisterButton());
		registerProperty.ListingsPerformed(new ListingButton());
		registerProperty.MessagesPerformed(new MessageButton());
		registerProperty.AddPropPerformed(new AddPropertyButton());
		
		landlordView.RegisterPerformed(new RegisterButton());
		landlordView.ListingsPerformed(new ListingButton());
		landlordView.MessagesPerformed(new MessageButton());
	//	landlordView.AddPropPerformed(new AddPropertyButton());
	}
	
	
	public class RegisterButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("register button pressed");
			registerProperty.draw();
		}
	}
	
	public class ListingButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Listing button pressed");
			landlordView.draw();
		}
	}
	
	public class MessageButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Message button pressed");
			System.out.println("user email in register propert is: "+landlord.getEmail());
			switchView("LandlordMessages");
		}
	}

	public class AddPropertyButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Add property button pressed");	
			//String email = registerProperty.getEmail();
			String type = registerProperty.getTypeInput();
			int bed = registerProperty.getBedNum();
			int bath = registerProperty.getBathNum();
			boolean furnish = registerProperty.getFurn();
			String quad = registerProperty.getQuadrant();
			String listTime = new SimpleDateFormat("HH.mm").format(new java.util.Date());
			String status = "Suspended";
			System.out.println(type+", "+bed+", "+bath+", "+furnish+", "+
								quad+", "+listTime+", "+status);
			//Add this data to database.
		}
	}
	
	@Override
	public void switchView(String view) {
		super.switchView(view);
	}
	
	public void setView(boolean v1, boolean v2) {
		if(v1) {
			registerProperty.draw();
		}
		if(v2) {
			landlordView.draw();
		}
	}
	
//	public static void main(String[] args) {
//	System.out.println("Register property controller main");
//	Manager m = new Manager();
//	Landlord l = new Landlord(); 
//	RegisterPropertyView r = new RegisterPropertyView();
//	
//	RegisterPropertyController c = new RegisterPropertyController(l, m, r);
//	}
}


