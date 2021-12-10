package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
		landlordView.paySubmission(new PayButton());
		landlordView.updateStatus(new UpdateStatusButton());
	//	landlordView.AddPropPerformed(new AddPropertyButton());
				
		managerView.renterLandlordPerformed(new managerRenterLandlordList());
		managerView.ListingsPerformed(new managerEditStatus());
		managerView.SummaryReportPerformed(new managerSummary());
		managerView.EditFeesPerformed(new managerEditFee());
		managerView.updateStatus (new managerUpdateStatus());
	}
	
	
	public class RegisterButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("register button pressed");
			registerProperty.draw();
		}
	}

	public class UpdateStatusButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Update status pressed");
			String id = landlordView.getIDForStatusUpdateInput();
			String status = landlordView.getStatus();
			db.updateStatus(id, status);
			registerProperty.draw();
		}
	}

	public class PayButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Pay button pressed");
			String temp = landlordView.getpayInput();
			LocalDate date = LocalDate.now();
			String listTime = date.toString();
			String status = "Active";
			db.updateListingDate(temp,listTime, status);
			registerProperty.draw();
			notifyRenter(temp);
		}
	}

	
	public class ListingButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Listing button pressed");
			landlordView.draw();
			landlordView.setTable(landlord.LandlordListings(db.getAllListings()));
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
			// String email = .getEmail();
			String type = registerProperty.getTypeInput();
			int bed = registerProperty.getBedNum();
			int bath = registerProperty.getBathNum();
			boolean furnish = registerProperty.getFurn();
			String address = registerProperty.getAddress();
			String quad = registerProperty.getQuadrant();
			String date = "";
			// LocalDate date = LocalDate.now();
			// String listTime = date.toString(); //new SimpleDateFormat("HH.mm").format(new java.util.Date());
			String status = "Registered";
			System.out.println(type+", "+bed+", "+bath+", "+furnish+", "+
								quad+", "+ date +", "+status);
			//Add this data to database.
			try {
				db.addListing(landlord.getEmail(), type, bed, bath, furnish, address, quad, date, status);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public void switchView(String view) {
		super.switchView(view);
	}
	
	public class managerRenterLandlordList implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("renter landlord list");
			switchView("RenterLandlordList");
		}
	}
	
	public class managerEditStatus implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Edit listing pressed");
			managerView.setTable(db.getAllListings());
		}
	}
	
	public class managerSummary implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("SummaryReport pressed");
			switchView("SummaryReportView");
		}
	}
	
	public class managerEditFee implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("editfeeclicked");
			switchView("EditFee");
		}
	}
	
	public class managerUpdateStatus implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public void setView(boolean v1, boolean v2, boolean v3) {
		if(v1) {
			registerProperty.draw();
		}
		if(v2) {
			landlordView.draw();
		}
		if(v3) {
			managerView.draw();
		}
	}
	
	public void listingsForManager() {
		managerView.setTable(db.getAllListings());
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


