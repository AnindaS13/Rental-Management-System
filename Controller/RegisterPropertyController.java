package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import Model.Listing;

import Controller.ContactController.ListingButton;
import Controller.ContactController.MessageButton;
import Controller.ContactController.RegisterButton;
import Model.Manager;
import Model.Landlord;
import Gui.EditListStatusLandlordView;
import Gui.EditStatusManagerView;
import Gui.RegisterPropertyView;

// controller for registering new property by landlords, updating status by managers and
//landlords. Pay fee option for landlords to list property
public class RegisterPropertyController extends ParentController{

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
		
		// displaying all landlords listings
		landlordView.setTable(landlord.LandlordListings(db.getAllListings()));
		
		//action listener for different views. for navigation same actionlistener are assigned
		//for registerProperty view and landlordView.
		registerProperty.RegisterPerformed(new RegisterButton());
		registerProperty.ListingsPerformed(new ListingButton());
		registerProperty.MessagesPerformed(new MessageButton());
		registerProperty.AddPropPerformed(new AddPropertyButton());
		
		landlordView.RegisterPerformed(new RegisterButton());
		landlordView.ListingsPerformed(new ListingButton());
		landlordView.MessagesPerformed(new MessageButton());
		landlordView.paySubmission(new PayButton());
		landlordView.updateStatus(new UpdateStatusButton());
				
		managerView.renterLandlordPerformed(new managerRenterLandlordList());
		managerView.ListingsPerformed(new managerEditStatus());
		managerView.SummaryReportPerformed(new managerSummary());
		managerView.EditFeesPerformed(new managerEditFee());
		managerView.updateStatus (new managerUpdateStatus());
	}
	
	//implementation of action listeners
	//action listeners for landlord views
	public class RegisterButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			registerProperty.draw();
		}
	}

	//udpate the status of listing by landlords
	public class UpdateStatusButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String id = landlordView.getIDForStatusUpdateInput();
			String status = landlordView.getStatus();
			db.updateStatus(id, status);
			landlordView.draw();
			landlordView.setTable(landlord.LandlordListings(db.getAllListings()));
		}
	}

	//udpate the status of listing by managers
	public class managerUpdateStatus implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Update status for manager pressed");
			String ID = managerView.getIdEntered();
			String status = managerView.getEnteredStatus();
			db.managerUpdateStatus(ID, status);
			switchView("RenterLandlordList");
		}
	}

	//fee payment by landlords
	public class PayButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Pay button pressed");
			String temp = landlordView.getpayInput();
			LocalDate date = LocalDate.now();
			String listTime = date.toString();
			String status = "Active";
			db.updateListingDate(temp,listTime, status);
			landlordView.draw();
			landlordView.setTable(landlord.LandlordListings(db.getAllListings()));
			notifyRenter(temp);
		}
	}

	//to display all the listing of landlords to them
	public class ListingButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			landlordView.draw();
			landlordView.setTable(landlord.LandlordListings(db.getAllListings()));
		}
	}
	
	//to get the messages that are either sent by registered or unregistered renter
	public class MessageButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switchView("LandlordMessages");
		}
	}

	//to register a new property
	public class AddPropertyButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Add property button pressed");	
			String type = registerProperty.getTypeInput();
			int bed = registerProperty.getBedNum();
			int bath = registerProperty.getBathNum();
			boolean furnish = registerProperty.getFurn();
			String address = registerProperty.getAddress();
			String quad = registerProperty.getQuadrant();
			String date = "";
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
	
	//method to switch view. handled by parent controller
	@Override
	public void switchView(String view) {
		super.switchView(view);
	}
	
	//actionlisteners for manager view
	
	public class managerRenterLandlordList implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switchView("RenterLandlordList");
		}
	}
	
	//manager navigation menu buttons
	public class managerEditStatus implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			managerView.setTable(db.getAllListings());
		}
	}
	
	public class managerSummary implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switchView("SummaryReportView");
		}
	}
	
	public class managerEditFee implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switchView("EditFee");
		}
	}
	

	//method to switch from 1 view to another view, all 3 views are controller by this controller
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
	
	//setting up output table in managerview
	public void listingsForManager() {
		managerView.setTable(db.getAllListings());
	}
	
}


